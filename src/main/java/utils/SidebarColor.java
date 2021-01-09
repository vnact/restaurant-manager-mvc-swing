package utils;

import java.awt.Color;

/**
 * createAt Jan 9, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class SidebarColor {

    public static Color getActiveColor(int level) {
        String colorCode;
        switch (level) {
            case 0:
                colorCode = "EAFAF1";
                break;
            case 1:
            case 2:
            case 3:
                colorCode = "EAFAF1";
                break;
            default:
                colorCode = "FFFFFF";
                break;
        }
        return Color.decode("#" + colorCode);
    }

    public static Color getInactiveColor(int level) {
        String colorCode;
        switch (level) {
            case 0:
                colorCode = "D5DBDB";
                break;
            case 1:
            case 2:
            case 3:
                colorCode = "D5DBDB";
                break;
            default:
                colorCode = "FFFFFF";
                break;
        }
        return Color.decode("#" + colorCode);
    }
}
