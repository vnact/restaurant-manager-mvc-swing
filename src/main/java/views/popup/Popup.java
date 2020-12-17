package views.popup;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public interface Popup {

    public abstract JButton getBtnOK();

    public abstract JButton getBtnCancel();

    public abstract JLabel getLbTitle();

    public abstract void dispose();

    public abstract void setVisible(boolean b);
}
