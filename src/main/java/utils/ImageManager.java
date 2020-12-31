package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.imgscalr.Scalr;

/**
 * @createAt Nov 15, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class ImageManager {

    public static String resourcesPath = "/";
    public static String imagesPath = resourcesPath + "images/";

    public ImageManager() {
    }

    public ImageIcon getImage(String name) {
        try {
            URL pathImage = getClass().getResource(imagesPath + name);
            return new ImageIcon(pathImage);
        } catch (Exception e) {
            return new ImageIcon(getClass().getResource(imagesPath + "tra-hoa-hong-da.png"));
        }
    }

    public Icon resizeIcon(ImageIcon source, int width, int height) {
        Image img = source.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    public String saveImage(BufferedImage bi, String name) throws IOException {
        String pathImages = getClass().getResource(imagesPath).getPath();
        String fileName = getUniqueNameFile(name);
        File out = new File(pathImages + fileName);
        BufferedImage resizedImage = resizeImage(bi, 200);
        ImageIO.write(resizedImage, "png", out);
        return out.getName();
    }

    public BufferedImage resizeImage(BufferedImage source, int targetWidth) {
        try {
            return Scalr.resize(source, targetWidth);
        } catch (Exception e) {
            return source;
        }
    }

    public String getUniqueNameFile(String name) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Timestamp(System.currentTimeMillis()));
        String fileName = String.format("%s-%s.%s", name.length() > 35 ? name.substring(0, 35) : name, timeStamp, "png");
        return fileName;
    }
}
