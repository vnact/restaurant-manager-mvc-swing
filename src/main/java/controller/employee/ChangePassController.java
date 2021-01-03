/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.EmployeeDao;
import static main.SessionManager.session;
import models.Employee;
import views.employee.ChangePassView;

/**
 *
 * @author Admin
 */
public class ChangePassController {

    ChangePassView view;
    Employee session;

    public ChangePassController() {

    }

    public void setView(ChangePassView view) {
        this.view = view;
    }

    public void setSession(Employee employee) {
        this.session = employee;
    }

    public void addEvent() {
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getBtnConfirm().addActionListener(evt -> {
            try {
                String oldPass = view.getTxtOldPass().getText(),
                        newPass = view.getTxtNewPass().getText(),
                        confirmPass = view.getTxtConfirmPass().getText();
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
                    view.showMessage("Thay đổi thành công !");
                    view.dispose();
                }
            } catch (Exception ee) {
                view.showError(ee);
            }
        });
    }
}
