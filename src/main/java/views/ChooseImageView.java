package views;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * createAt Dec 20, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class ChooseImageView extends JFileChooser {

    public ChooseImageView() {
        initFileChooser();
    }

    public void initFileChooser() {
        setDialogTitle("Chọn ảnh");
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        setDragEnabled(true);
        setCurrentDirectory(new File("D:\\"));
        setDialogType(JFileChooser.OPEN_DIALOG);
        FileFilter imageFilter = new FileNameExtensionFilter("Hình ảnh(jpg, png, gif,...)", ImageIO.getReaderFileSuffixes());
        setFileFilter(imageFilter);
    }
}
