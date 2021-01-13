package views.admin;

import javax.swing.DefaultComboBoxModel;
import models.Employee;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class EmployeeManagerView extends ManagerPaneView<Employee> {

    String[] list = {"ID", "Name", "phoneNumber"};

    public EmployeeManagerView() {
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
        tableModel.addColumn("Lương");
        this.getCboSearchField().setModel(new DefaultComboBoxModel(list));
    }
}
