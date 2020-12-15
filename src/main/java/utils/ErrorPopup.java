package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author MSI
 */
public class ErrorPopup {

    public static void show(Exception e) {
//        JOptionPane.showMessageDialog(null, e.getMessage(), "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
        int val = JOptionPane.showConfirmDialog(null, e.getMessage() + "!\nXem chi tiểt lỗi?", "Có lỗi xảy ra", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (val == JOptionPane.YES_OPTION) {
            String errorSummary = "";
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                errorSummary += "\tat " + stackTraceElement;
                errorSummary += "\n";
            }
            JOptionPane.showMessageDialog(null, errorSummary, "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
        }
    }
}
