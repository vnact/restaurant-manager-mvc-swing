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
                ChangePassView CPview = new ChangePassView();
                CPview.setVisible(true);
                CPview.setLocationRelativeTo(null);
                CPview.getBtnCancel().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CPview.dispose();
                    }
                });
                CPview.getBtnConfrim().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String oldPass = CPview.getTxtOldPass().getText(),
                                newPass = CPview.getTxtNewPass().getText(),
                                confrimPass = CPview.getTxtConfrimPass().getText();
                        if (oldPass.isEmpty() || newPass.isEmpty() || confrimPass.isEmpty()) {
                            JOptionPane.showMessageDialog(CPview, "Vui lòng điền đầy đủ thông tin");
                        }
                        if (!oldPass.equals(session.getPassword())) {
                            System.out.println(oldPass);
                            JOptionPane.showMessageDialog(CPview, "Mật khẩu cũ không đúng ");
                        } else {
                            if (!newPass.equals(newPass)) {
                                JOptionPane.showMessageDialog(CPview, "Xác nhận mật khẩu sai !");
                            } else {
                                try {
                                    EmployeeDao eDao = new EmployeeDao();
                                    Employee employee = new Employee();
                                    employee.setId(session.getId());
                                    employee.setPassword(newPass);
                                    eDao.updatePass(employee);
                                    JOptionPane.showMessageDialog(CPview, "Thay đổi thành công !");
                                } catch (Exception ee) {
                                    ee.printStackTrace();
                                }

                            }
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
