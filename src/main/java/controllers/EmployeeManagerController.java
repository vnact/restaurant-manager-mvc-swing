package controllers;

import dao.EmployeeDao;
import java.util.ArrayList;
import models.Employee;
import views.admin.EmployeeManagerPane;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class EmployeeManagerController extends ManageController {

    EmployeeDao employeeDao = new EmployeeDao();

    public EmployeeManagerController() {
        super();
    }

    public EmployeeManagerController(EmployeeManagerPane view) {
        super(view);
    }

    public void setView(EmployeeManagerPane view) {
        super.setView(view);
    }

    @Override
    public void actionAdd() {
        System.out.println("Thêm nhân viên");
    }

    @Override
    public void actionDelete() {
        System.out.println("Sữa nhân viên");
    }

    @Override
    public void actionEdit() {
        System.out.println("Xóa nhân viên");
    }

    @Override
    public void updateData() {
        try {
            ArrayList<Employee> employees = employeeDao.getAll();
            view.setTableData(employees);
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
