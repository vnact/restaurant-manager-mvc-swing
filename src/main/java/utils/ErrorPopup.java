package utils;

import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class ErrorPopup {

    static PrintStream ps;

    public static void show(Exception e) {
        try {
            if (ps == null) {
                ps = new PrintStream(new FileOutputStream("log.txt", true));
            }
            e.printStackTrace(ps);

//            JOptionPane.showMessageDialog(null, e.getMessage(), "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            int val = JOptionPane.showConfirmDialog(null, e.getMessage() + "!\nXem chi tiểt lỗi?", "Có lỗi xảy ra", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (val == JOptionPane.YES_OPTION) {
                String errorSummary = "";
                int numElement = 0;
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    if (numElement >= 20) {
                        errorSummary += "\t...  more";
                    } else {
                        errorSummary += "\tat " + stackTraceElement;
                        errorSummary += "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, errorSummary, "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {

        }

    }
}
