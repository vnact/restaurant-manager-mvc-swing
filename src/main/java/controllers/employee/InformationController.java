/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.employee;

import javax.swing.JOptionPane;
import main.SessionManager;
import models.Employee;
import utils.ErrorPopup;
import views.employee.CalendarView;
import views.employee.ChangePassView;
import views.employee.InformationView;

/**
 *
 * @author Admin
 */
public class InformationController {

    private Employee session;
    private InformationView view;
    ChangePassController changePassController = new ChangePassController();

    public InformationController() {
        session = SessionManager.getSession().getEmployee();
    }

    public InformationView getView() {
        return view;
    }

    public void setView(InformationView view) {
        if (this.view != view) {
            view.getLabName().setText("Chào mừng " + session.getName());
            CalendarView calendarView = new CalendarView();
            CalendarController calendarController = new CalendarController(calendarView);
            view.getPanelCalendar().add(calendarView);
            addEvent(view);
            this.view = view;
        }
    }

    public void addEvent(InformationView view) {
        view.getBtnChangePass().addActionListener(evt -> {
            changePassController.show(new ChangePassView(), () -> JOptionPane.showMessageDialog(view, "Đổi pass thành công"), ErrorPopup::show);
        });
    }
}
