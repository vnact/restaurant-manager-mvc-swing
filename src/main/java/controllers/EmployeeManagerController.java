package controllers;

import dao.EmployeeDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.Employee;
import views.admin.EmployeeManagerPane;
import views.admin.popup.EmployeePopup;

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

    public void addEmployee(EmployeePopup popupView) {
        try {
            String username = popupView.getTxtUsername().getText(),
                    password = popupView.getTxtPassword().getText(),
                    phoneNumber = popupView.getTxtPhoneNumber().getText(),
                    name = popupView.getTxtName().getText();
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
            e.setPermissionName(popupView.getCboPermission().getSelectedItem().toString());
            e.setPermissionId(popupView.getCboPermission().getSelectedIndex() + 1);
            employeeDao.save(e);
            view.showMessage("Thêm thành công");
            updateData();
            setPopupView(null);//Tắt Popup            
        } catch (Exception e) {
            view.showError(e);
        }
    }

    public void editEmployee(EmployeePopup popupView, Employee e) {
        try {
            String username = popupView.getTxtUsername().getText(),
                    password = popupView.getTxtPassword().getText(),
                    phoneNumber = popupView.getTxtPhoneNumber().getText(),
                    name = popupView.getTxtName().getText();
            e.setUsername(username);
            e.setPassword(password);
            e.setName(name);
            e.setPhoneNumber(phoneNumber);
            e.setPermissionName(popupView.getCboPermission().getSelectedItem().toString());
            e.setPermissionId(popupView.getCboPermission().getSelectedIndex() + 1);
            employeeDao.update(e);
            view.showMessage("Thêm thành công");
            updateData();
            setPopupView(null);//Tắt Popup      
        } catch (Exception ex) {
            view.showError(ex);
        }
    }

    @Override
    public void actionAdd() {
        EmployeePopup popup = new EmployeePopup();
        showPopup(popup, new PopupEvent() {
            @Override
            public void onBtnOK() {
                addEmployee(popup);
            }
        });
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa hàng loạt?", "Xóa nhân viên", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                employeeDao.deleteById(selectedIds[i]);
                updateData();
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn nhân viên cần edit");
            } else {;
                EmployeePopup popup = new EmployeePopup();
                popup.getLbTitle().setText("Sửa nhân viên - " + selectedId);
                Employee e = employeeDao.get(selectedId);
                if (e == null) {
                    throw new Exception("Nhân viên bạn chọn không hợp lệ");
                }
                popup.getTxtUsername().setText(e.getUsername());
                popup.getTxtPassword().setText(e.getPassword());
                popup.getTxtName().setText(e.getName());
                popup.getTxtPhoneNumber().setText(e.getPhoneNumber());
                popup.getBtnOK().setText("Cập nhật");
                showPopup(popup, new PopupEvent() {
                    @Override
                    public void onBtnOK() {
                        editEmployee(popup, e);
                    }
                });
            }
        } catch (Exception e) {
            view.showError(e);
        }
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
