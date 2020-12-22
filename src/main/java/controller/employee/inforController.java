/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.EmployeeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import main.Runner;
import models.Employee;
import views.employee.ChangePassView;
import views.employee.inforView;

/**
 *
 * @author Admin
 */
public class inforController {

    private Employee session;
    private inforView view;

    public inforController() {
        session = Runner.getSession();

    }

    public inforView getView() {
        return view;
    }

    public void setView(inforView view) {
        view.getLabName().setText("Chào mừng " + session.getName());
        this.view = view;
        addEvent();

    }

    public void addEvent() {
        view.getBtnChangePass().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ChangePassView changePassView = new ChangePassView();
                changePassView.setVisible(true);
                changePassView.setLocationRelativeTo(null);
                changePassView.getBtnCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        changePassView.dispose();
                    }
                });
                changePassView.getBtnConfrim().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String oldPass = changePassView.getTxtOldPass().getText(),
                                    newPass = changePassView.getTxtNewPass().getText(),
                                    confrimPass = changePassView.getTxtConfrimPass().getText();
                            if (oldPass.isEmpty() || newPass.isEmpty() || confrimPass.isEmpty()) {
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
                                JOptionPane.showMessageDialog(changePassView, "Thay đổi thành công !");
                            }
                        } catch (Exception ee) {
                            ee.printStackTrace();
                            JOptionPane.showMessageDialog(changePassView, ee.getMessage());
                        }
                    }

                });

            }
        });
        // Sự kiện bấm nút sửa
        view.getBtnChangeInfor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

            }
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
