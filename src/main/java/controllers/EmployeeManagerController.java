package controllers;

import dao.EmployeeDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

    public void editEmployee() {

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
        showPopup(new EmployeePopup(), new PopupEvent() {
            @Override
            public void onBtnOK() {
                editEmployee();
            }
        });
    }

    @Override
    public void actionEdit() {
        try {

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
