// Copyright (c) 2018 by Alexander Dadukin (st235@yandex.ru)
// All rights reserved.

package st235.github.com.richtextview;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that provides the ability to load custom fonts.
 */
public class FontProvider {

    private static FontProvider instance;

    private AssetManager assetsManager;
    private Map<String, Typeface> fonts = new HashMap<>();

    private FontProvider(AssetManager assetsManager) {
        this.assetsManager = assetsManager;
    }

    /**
     * Creates FontProvider.
     * @param assetManager - current assetManager. You may get it from context.getAssets()
     */
    public static void init(AssetManager assetManager) {
        instance = new FontProvider(assetManager);
    }

    /**
     * Returns provider. If the provider was not created, it throws an error.
     * @return FontProvider instance
     */
    public static FontProvider getInstance() {
        if (instance == null)
            throw new IllegalStateException("FontProvider instance must be initialized!");
        return instance;
    }

    /**
     * Returns font by passed asset path.
     * @param asset path to font, for example, __fonts/fontawesome.ttf__
     * @return loaded font as Typeface
     */
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

    static boolean isStringEmpty(String string) {
        return string == null || string.isEmpty();
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
}
