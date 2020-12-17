package controllers.popup;

import controllers.PopupController;
import controllers.admin.EmployeeManagerController;
import dao.EmployeeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Employee;
import views.popup.EmployeePopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class EmployeePopupController extends PopupController {

    EmployeeDao employeeDao = new EmployeeDao();

    public void add(EmployeeManagerController parrent, EmployeePopupView view) {
        setView(view);
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean addSuccess = addEmployee();
                    if (addSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Thêm nhân viên thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public void edit(EmployeeManagerController parrent, EmployeePopupView view, Employee employee) {
        setView(view);

        view.getLbTitle().setText("Sửa nhân viên - " + employee.getId());
        view.getTxtUsername().setText(employee.getUsername());
        view.getTxtPassword().setText(employee.getPassword());
        view.getTxtName().setText(employee.getName());
        view.getTxtPhoneNumber().setText(employee.getPhoneNumber());
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean editSuccess = editEmployee(employee);
                    if (editSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Sửa nhân viên thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public boolean addEmployee() throws Exception {
        EmployeePopupView view = (EmployeePopupView) this.getView();
        String username = view.getTxtUsername().getText(),
                password = view.getTxtPassword().getText(),
                phoneNumber = view.getTxtPhoneNumber().getText(),
                name = view.getTxtName().getText();
        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        if (employeeDao.findByUsername(username) != null) {
            throw new Exception("Tài khoản đã tồn tại");
        }
        Employee e = new Employee();
        e.setUsername(username);
        e.setPassword(password);
        e.setName(name);
        e.setPhoneNumber(phoneNumber);
        e.setPermissionName(view.getCboPermission().getSelectedItem().toString());
        e.setPermissionId(view.getCboPermission().getSelectedIndex() + 1);
        employeeDao.save(e);
        return true;
    }

    public boolean editEmployee(Employee e) throws Exception {
        EmployeePopupView view = (EmployeePopupView) this.getView();
        String username = view.getTxtUsername().getText(),
                password = view.getTxtPassword().getText(),
                phoneNumber = view.getTxtPhoneNumber().getText(),
                name = view.getTxtName().getText();
        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        Employee temp = employeeDao.findByUsername(username);
        if (temp != null && temp.getId() != e.getId()) {
            throw new Exception("Tên tài khoản đã tồn tại");
        }
        e.setUsername(username);
        e.setPassword(password);
        e.setName(name);
        e.setPhoneNumber(phoneNumber);
        e.setPermissionName(view.getCboPermission().getSelectedItem().toString());
        e.setPermissionId(view.getCboPermission().getSelectedIndex() + 1);
        employeeDao.update(e);
        return true;
    }
}
