package views.admin;

import models.Employee;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class EmployeeManagerPaneView extends ManagerPaneView<Employee> {

    public EmployeeManagerPaneView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Họ và tên");
        tableModel.addColumn("Tên tài khoản");
        tableModel.addColumn("Mật khẩu");
        tableModel.addColumn("Số điện thoại");
        tableModel.addColumn("Ngày vào làm");
        tableModel.addColumn("Chức vụ");
    }
}
