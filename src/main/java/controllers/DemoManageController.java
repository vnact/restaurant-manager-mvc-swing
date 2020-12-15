package controllers;

import dao.EmployeeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import models.Employee;
import views.admin.DemoManagerPane;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class DemoManageController {

    private DemoManagerPane view;
    EmployeeDao employeeDao = new EmployeeDao();

    public DemoManageController() {
    }

    public DemoManageController(DemoManagerPane view) {
        this.view = view;
        addEvent();
    }

    public DemoManagerPane getView() {
        return view;
    }

    public void setView(DemoManagerPane view) {
        this.view = view;
        addEvent();
    }

    public void updateData() {
        try {
            ArrayList<Employee> employees = employeeDao.getAll();
            view.setTableData(employees);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    private void addEvent() {
        // Thêm
        view.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionAdd();
            }
        });
        // Sửa
        view.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionEdit();
            }
        });
        // Xóa
        view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionDelete();
            }
        });
        // Cập nhật
        view.getBtnSync().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                updateData();
            }
        });
    }

    private void actionAdd() {
        System.out.println("add");
    }

    private void actionEdit() {
        System.out.println("edit");
    }

    private void actionDelete() {
        System.out.println("delete");
    }

}
