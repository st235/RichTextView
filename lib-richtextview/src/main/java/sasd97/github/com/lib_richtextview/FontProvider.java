package sasd97.github.com.lib_richtextview;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;

import junit.framework.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexander on 14/07/2017.
 */

public class FontProvider {

    private static FontProvider instance;

    private AssetManager assetsManager;
    private Map<String, Typeface> fonts = new HashMap<>();

    private FontProvider(AssetManager assetsManager) {
        this.assetsManager = assetsManager;
    }

    public static void init(AssetManager assetManager) {
        instance = new FontProvider(assetManager);
    }

    public static FontProvider getInstance() {
        if (instance == null)
            throw new IllegalStateException("FontProvider instance must be initialized!");
        return instance;
    }

    public Typeface getFont(String asset) {
        if (fonts.containsKey(asset)) return fonts.get(asset);

        try {
            Typeface font = Typeface.createFromAsset(assetsManager, asset);
            fonts.put(asset, font);
            return font;
        } catch (RuntimeException exception) {
            return retryLoadResource(asset);
        }
    }

    private Typeface retryLoadResource(String asset) {
        String fixedAsset = fixAssetFilename(asset);
        Typeface font = Typeface.createFromAsset(assetsManager, fixedAsset);
        fonts.put(asset, font);
        fonts.put(fixedAsset, font);
        return font;
    }

    private String fixAssetFilename(String asset) {
        if (isStringEmpty(asset)) return asset;

        if (!isAssetHaveExtension(asset))
            asset = String.format("%s.ttf", asset);

        return asset;
    }

    private boolean isAssetHaveExtension(@NonNull String asset) {
        return asset.endsWith(".ttf") || asset.endsWith(".ttc");
    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
    }
}
