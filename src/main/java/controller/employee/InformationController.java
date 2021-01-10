/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.EmployeeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.SessionManager;
import models.Employee;
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

    public InformationController() {
        session = SessionManager.getSession().getEmployee();
    }

    public InformationView getView() {
        return view;
    }

    public void setView(InformationView view) {
        view.getLabName().setText("Chào mừng " + session.getName());
        this.view = view;
        CalendarView calendarView = new CalendarView();
        CalendarController calendarController = new CalendarController(calendarView);
        view.getPanelCalendar().add(calendarView);
        addEvent();
    }

    public void addEvent() {
        view.getBtnChangePass().addActionListener(evt -> {
            ChangePassView changePassView = new ChangePassView();
            ChangePassController changePassController = new ChangePassController();
            changePassController.setView(changePassView);
            changePassController.setSession(session);
            changePassController.addEvent();
        });
        // Sự kiện bấm nút sửa
        view.getBtnChangeInfor().addActionListener(evt -> {
        });
        // Sự kiện bấm nút xóa
        view.getBtnNS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

            }
        });
        // Sự kiện bấm nút cập nhật
        view.getBtnHS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Sync Data");
            }
        });
    }
}
