package controllers.employee;

import javax.swing.JFrame;
import views.employee.HistoryLoginView;

/**
 * createAt Jan 12, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class HistoryLoginController {
    
    JFrame previousView;
    
    public void show(HistoryLoginView view) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
    }
}
