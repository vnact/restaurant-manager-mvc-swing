package utils;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @createAt Nov 15, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class IconManager {

    public static String resourcesPath = "/";
    public static String iconsPath = resourcesPath + "icons/";

    public IconManager() {
    }

    public Icon getIcon(String name) {
        return new ImageIcon(getClass().getResource(iconsPath + name));
    }
}
