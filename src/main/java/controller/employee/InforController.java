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
import views.employee.InforView;

/**
 *
 * @author Admin
 */
public class InforController {

    private Employee session;
    private InforView view;

    public InforController() {
        session = SessionManager.getSession().getEmployee();
    }

    public InforView getView() {
        return view;
    }

    public void setView(InforView view) {
        view.getLabName().setText("Chào mừng " + session.getName());
        this.view = view;
        CalendarView calendarView = new CalendarView();
        CalendarController calendarController = new CalendarController(calendarView);
        view.getPanelCalendar().add(calendarView);
        addEvent();
    }

    public void changePass(ChangePassView changePassView) {
        changePassView.setVisible(true);
        changePassView.setLocationRelativeTo(null);
        changePassView.getBtnCancel().addActionListener(evt -> changePassView.dispose());
        changePassView.getBtnConfirm().addActionListener(evt -> {
            try {
                String oldPass = changePassView.getTxtOldPass().getText(),
                        newPass = changePassView.getTxtNewPass().getText(),
                        confirmPass = changePassView.getTxtConfirmPass().getText();
                if (oldPass.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty()) {
                    throw new Exception("Vui lòng điền đầy đủ thông tin");
                }
                if (!oldPass.equals(session.getPassword())) {
                    System.out.println(oldPass);
                    throw new Exception("Mật khẩu cũ không đúng ");
                } else if (!newPass.equals(newPass)) {
                    throw new Exception("Xác nhận mật khẩu sai !");
                } else {
                    EmployeeDao employeeDao = new EmployeeDao();
                    Employee employee = session;
                    employee.setPassword(newPass);
                    employeeDao.update(employee);
                    changePassView.showMessage("Thay đổi thành công !");
                    changePassView.dispose();
                }
            } catch (Exception ee) {
                changePassView.showError(ee);
            }
        });
    }

    public void addEvent() {
        view.getBtnChangePass().addActionListener(evt -> changePass(new ChangePassView()));
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
