package controllers;

import dao.EmployeeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    EmployeePopup popupView;

    abstract class PopupEvent {

        public void onBtnCancel() {
            setPopupView(null);
        }

        public abstract void onBtnOK();
    }

    public EmployeeManagerController() {
        super();
    }

    public EmployeeManagerController(EmployeeManagerPane view) {
        super(view);
    }

    public void setView(EmployeeManagerPane view) {
        super.setView(view);
    }

    public EmployeePopup getPopupView() {
        return popupView;
    }

    public void setPopupView(EmployeePopup popupView) {
        if (popupView != null) {
            // Hiện popup mới
            popupView.setVisible(true);
        }
        if (this.popupView != null) {
            // Tắt popup cũ
            this.popupView.dispose();
        }
        this.popupView = popupView;
    }

    public void showPopup(EmployeePopup popupView, PopupEvent event) {
        if (popupView == null) {
            return;
        }
        setPopupView(popupView);
        this.popupView.getBtnCancel().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                event.onBtnCancel();
            }
        });
        this.popupView.getBtnOK().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                event.onBtnOK();
            }
        });
    }

    public void addEmployee() {
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

    public void editEmployee(Employee e) {
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
        showPopup(new EmployeePopup(), new PopupEvent() {
            @Override
            public void onBtnOK() {
                addEmployee();
            }
        });
    }

    @Override
    public void actionDelete() {
        int selectedRows[] = view.getTblData().getSelectedRows();
        try {
            if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa hàng loạt?", "Xóa nhân viên", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedRows.length; i++) {
                int selectedRow = selectedRows[i];
                int id = (int) view.getTblData().getValueAt(selectedRow, 0);
                employeeDao.deleteById(id);
                updateData();
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionEdit() {
        try {
            int selectedRow = view.getTblData().getSelectedRow();
            if (selectedRow < 0) {
                throw new Exception("Chọn nhân viên cần edit");
            } else {
                int id = (int) view.getTblData().getValueAt(selectedRow, 0);
                EmployeePopup popup = new EmployeePopup();
                popup.getLbTitle().setText("Sửa nhân viên - " + id);
                Employee e = employeeDao.get(id);
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
                        editEmployee(e);
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
