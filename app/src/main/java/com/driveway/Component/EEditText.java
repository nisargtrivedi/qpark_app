package com.driveway.Component;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatEditText;

/**
 * Created by admin on 7/5/2017.
 */

public class EEditText extends AppCompatEditText {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public EEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context, attrs);
    }

    public EEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);

        Typeface customFont = selectTypeface(context, textStyle);
        setTypeface(customFont);
    }

    private Typeface selectTypeface(Context context, int textStyle) {
        /*
        * information about the TextView textStyle:
        * http://developer.android.com/reference/android/R.styleable.html#TextView_textStyle
        */
        switch (textStyle) {
            case Typeface.BOLD: // bold
                return FontCache.getTypeface("ProductSansBold.ttf", context);

            case Typeface.ITALIC: // italic
                return FontCache.getTypeface("ProductSansItalic.ttf", context);

            case Typeface.BOLD_ITALIC: // bold italic
                return FontCache.getTypeface("ProductSansBold.ttf", context);

            case Typeface.NORMAL: // regular
                return FontCache.getTypeface("ProductSansRegular.ttf", context);
            default:
                return FontCache.getTypeface("ProductSansRegular.ttf", context);
        }
    }
}
