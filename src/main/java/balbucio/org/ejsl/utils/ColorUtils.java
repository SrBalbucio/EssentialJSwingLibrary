package balbucio.org.ejsl.utils;

import java.awt.*;

public class ColorUtils {

    public static Color TRANSPARENTE = new Color(0, 0, 0, 0);

    public static Color hexToRgb(String colorStr) {
        colorStr = colorStr.replace("#", "");
        return new Color(
                Integer.parseInt(colorStr.substring(0, 2), 16),
                Integer.parseInt(colorStr.substring(2, 4), 16),
                Integer.parseInt(colorStr.substring(4, 6), 16));
    }

    public static String rgbToHex(Color color) {
        return Integer.toHexString(color.getRed()).toUpperCase() + (color.getRed() < 16 ? 0 : "") +
                Integer.toHexString(color.getGreen()).toUpperCase() + (color.getGreen() < 16 ? 0 : "") +
                Integer.toHexString(color.getBlue()).toUpperCase() + (color.getBlue() < 16 ? 0 : "");
    }
}
