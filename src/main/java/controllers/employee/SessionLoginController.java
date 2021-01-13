/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.employee;

import java.awt.Color;
import java.text.SimpleDateFormat;
import models.Session;
import views.employee.SessionLoginView;

/**
 *
 * @author Administrator
 */
public class SessionLoginController {

    private SessionLoginView view;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public SessionLoginController() {

    }

    public void setView(SessionLoginView view) {
        this.view = view;
    }

    public void render(Session session) {
        view.getLbStartTime().setText(sdf.format(session.getStartTime()));
        if (session.getEndTime() == null) {
            view.getLbEndTime().setText("");
        } else {
            view.getLbEndTime().setText(sdf.format(session.getEndTime()));
        }
        if (session.getMessage().equals("login")) {
            view.getLbMessage().setText("Đang hoạt động");
            view.getLbMessage().setForeground(new Color(82, 164, 0));
        } else {
            view.getLbMessage().setText("Đã đăng xuất");
            view.getLbMessage().setForeground(new Color(144, 161, 198));
        }
    }
}
