package st235.github.com.richtextview;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import android.util.Log;

public class CustomFontSpan extends TypefaceSpan {

    private static final String TAG = "CustomFontSpan";

    public static final String ANY_FAMILY = "";

    private final Typeface newType;

    public CustomFontSpan(@NonNull String family, @NonNull Typeface type) {
        super(family);
        newType = type;
    }

    public CustomFontSpan(@NonNull String family, @Nullable String fontAsset) {
        super(family);
        if (FontProvider.isStringEmpty(fontAsset)) {
            newType = null;
        } else {
            newType = FontProvider.getInstance().getFont(fontAsset);
        }

        if (newType == null) Log.e(TAG, String.format("Typeface %1$s not loaded", fontAsset));
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeFace(ds, newType);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeFace(paint, newType);
    }

    private static void applyCustomTypeFace(Paint paint, Typeface tf) {
        int oldStyle;
        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        int fake = oldStyle & ~tf.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }

        paint.setTypeface(tf);
    }
}


