package sasd97.github.com.lib_richtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by alexander on 14/07/2017.
 */

public class RichTextView extends AppCompatTextView {

    private static final String TAG = RichTextView.class.getCanonicalName();

    public RichTextView(Context context) {
        super(context);
    }

    public RichTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (isInEditMode()) return;
        loadFont(context, attrs);
    }

    public RichTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (isInEditMode()) return;
        loadFont(context, attrs);
    }

    private void loadFont(@NonNull Context context,
                          @NonNull AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RichTextView);
        if (typedArray == null) return;

        String fontAsset = typedArray.getString(R.styleable.RichTextView_fontAsset);
        if (FontProvider.isStringEmpty(fontAsset)) return;

        Typeface font = FontProvider.getInstance().getFont(fontAsset);
        int style = getTypeface() != null ? getTypeface().getStyle() : Typeface.NORMAL;
        if (font != null) setTypeface(font, style);
        else Log.e(TAG, String.format("Typeface %1$s not loaded", fontAsset));

        typedArray.recycle();
    }
}
