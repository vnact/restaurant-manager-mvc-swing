package controllers.employee;

import dao.SessionDao;
import java.util.ArrayList;
import javax.swing.JFrame;
import main.SessionManager;
import models.Session;
import views.employee.HistoryLoginView;
import views.employee.SessionLoginView;

/**
 * createAt Jan 12, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class HistoryLoginController {

    JFrame previousView;
    HistoryLoginView view;
    SessionDao sessionDao = new SessionDao();
    int id = SessionManager.getSession().getIdEmployee();

    public void show(HistoryLoginView view) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            render();
            return;
        }
        previousView = view;
        this.view = view;
        view.setVisible(true);
        render();
    }

    public void render() {
        view.getPanelContent1().removeAll();
        try {
            ArrayList<Session> sessions = sessionDao.getSession(id);
            for (Session session : sessions) {
                SessionLoginController ctr = new SessionLoginController();
                SessionLoginView view = new SessionLoginView();
                ctr.setView(view);
                ctr.render(session);
                this.view.getPanelContent1().add(view);
                this.view.getPanelContent1().updateUI();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
