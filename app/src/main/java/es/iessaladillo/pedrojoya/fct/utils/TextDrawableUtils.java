package es.iessaladillo.pedrojoya.fct.utils;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

public class TextDrawableUtils {

    private TextDrawableUtils() {
    }

    public static TextDrawable.IBuilder getRoundBuilder() {
        return TextDrawable.builder().round();
    }

    public static TextDrawable getDrawable(TextDrawable.IBuilder builder, String letter,
            String key) {
        return builder.build(letter.substring(0, 1), ColorGenerator.MATERIAL.getColor(key));
    }

}
