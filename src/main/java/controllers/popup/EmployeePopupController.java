package controllers.popup;

import dao.EmployeeDao;
import javax.swing.JFrame;
import models.Employee;
import utils.EmployeePermission;
import views.popup.EmployeePopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class EmployeePopupController {

    EmployeeDao employeeDao = new EmployeeDao();
    JFrame previousView;

    public void add(EmployeePopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        for (EmployeePermission permission : EmployeePermission.values()) {
            view.getCboPermission().addItem(permission.getName());
        }
        view.getBtnOK().addActionListener(evt -> {
            try {
                addEmployee(view);
                view.dispose();
                view.showMessage("Thêm nhân viên thành công!");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public void edit(EmployeePopupView view, Employee employee, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        for (EmployeePermission permission : EmployeePermission.values()) {
            view.getCboPermission().addItem(permission.getName());
        }
        view.getLbTitle().setText("Sửa nhân viên - " + employee.getId());
        view.getTxtUsername().setText(employee.getUsername());
        view.getTxtPassword().setText(employee.getPassword());
        view.getTxtName().setText(employee.getName());
        view.getTxtPhoneNumber().setText(employee.getPhoneNumber());
        view.getCboPermission().setSelectedItem(employee.getPermission().getName());
        view.getSpnSalary().setValue(employee.getSalary());
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(evt -> {
            try {
                editEmployee(view, employee);
                view.dispose();
                view.showMessage("Sửa nhân viên thành công!");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public void addEmployee(EmployeePopupView view) throws Exception {
        String username = view.getTxtUsername().getText(),
                password = view.getTxtPassword().getText(),
                phoneNumber = view.getTxtPhoneNumber().getText(),
                name = view.getTxtName().getText();
        int salary = (int) view.getSpnSalary().getValue();
        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        if (salary < 0) {
            throw new Exception("Lương không thể âm");
        }
        if (employeeDao.findByUsername(username) != null) {
            throw new Exception("Tài khoản đã tồn tại");
        }
        Employee e = new Employee();
        e.setUsername(username);
        e.setPassword(password);
        e.setName(name);
        e.setPhoneNumber(phoneNumber);
        e.setPermission(EmployeePermission.getByName(view.getCboPermission().getSelectedItem().toString()));
        e.setSalary(salary);
        employeeDao.save(e);
        return;
    }

    public boolean editEmployee(EmployeePopupView view, Employee e) throws Exception {
        String username = view.getTxtUsername().getText(),
                password = view.getTxtPassword().getText(),
                phoneNumber = view.getTxtPhoneNumber().getText(),
                name = view.getTxtName().getText();
        int salary = (int) view.getSpnSalary().getValue();
        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        if (salary < 0) {
            throw new Exception("Lương không thể âm");
        }
        Employee temp = employeeDao.findByUsername(username);
        if (temp != null && temp.getId() != e.getId()) {
            throw new Exception("Tên tài khoản đã tồn tại");
        }
        e.setUsername(username);
        e.setPassword(password);
        e.setName(name);
        e.setPhoneNumber(phoneNumber);
        e.setPermission(EmployeePermission.getByName(view.getCboPermission().getSelectedItem().toString()));
        e.setSalary(salary);
        employeeDao.update(e);
        return true;
    }
//    public void add(EmployeeManagerController parrent, EmployeePopupView view) {
//        setView(view);
//        for (EmployeePermission permission : EmployeePermission.values()) {
//            view.getCboPermission().addItem(permission.getName());
//        }
//        view.getBtnOK().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                try {
//                    boolean addSuccess = addEmployee();
//                    if (addSuccess) {
//                        view.dispose();
//                        parrent.updateData();
//                        view.showMessage("Thêm nhân viên thành công!");
//                    }
//                } catch (Exception ex) {
//                    parrent.getView().showError(ex);
//                }
//            }
//        });
//
//    }
//    public boolean addEmployee() throws Exception {
//        EmployeePopupView view = (EmployeePopupView) this.getView();
//        String username = view.getTxtUsername().getText(),
//                password = view.getTxtPassword().getText(),
//                phoneNumber = view.getTxtPhoneNumber().getText(),
//                name = view.getTxtName().getText();
//        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
//            throw new Exception("Vui lòng điền đầy đủ thông tin");
//        }
//        if (employeeDao.findByUsername(username) != null) {
//            throw new Exception("Tài khoản đã tồn tại");
//        }
//        Employee e = new Employee();
//        e.setUsername(username);
//        e.setPassword(password);
//        e.setName(name);
//        e.setPhoneNumber(phoneNumber);
//        e.setPermission(EmployeePermission.getByName(view.getCboPermission().getSelectedItem().toString()));
//        employeeDao.save(e);
//        return true;
//    }

//    public void edit(EmployeeManagerController parrent, EmployeePopupView view, Employee employee) {
//        setView(view);
//        for (EmployeePermission permission : EmployeePermission.values()) {
//            view.getCboPermission().addItem(permission.getName());
//        }
//        view.getLbTitle().setText("Sửa nhân viên - " + employee.getId());
//        view.getTxtUsername().setText(employee.getUsername());
//        view.getTxtPassword().setText(employee.getPassword());
//        view.getTxtName().setText(employee.getName());
//        view.getTxtPhoneNumber().setText(employee.getPhoneNumber());
//        view.getCboPermission().setSelectedItem(employee.getPermission().getName());
//        view.getBtnOK().setText("Cập nhật");
//        view.getBtnOK().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                try {
//                    boolean editSuccess = editEmployee(employee);
//                    if (editSuccess) {
//                        view.dispose();
//                        parrent.updateData();
//                        view.showMessage("Sửa nhân viên thành công!");
//                    }
//                } catch (Exception ex) {
//                    parrent.getView().showError(ex);
//                }
//            }
//        });
//
//    }
//
//    public boolean editEmployee(Employee e) throws Exception {
//        EmployeePopupView view = (EmployeePopupView) this.getView();
//        String username = view.getTxtUsername().getText(),
//                password = view.getTxtPassword().getText(),
//                phoneNumber = view.getTxtPhoneNumber().getText(),
//                name = view.getTxtName().getText();
//        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
//            throw new Exception("Vui lòng điền đầy đủ thông tin");
//        }
//        Employee temp = employeeDao.findByUsername(username);
//        if (temp != null && temp.getId() != e.getId()) {
//            throw new Exception("Tên tài khoản đã tồn tại");
//        }
//        e.setUsername(username);
//        e.setPassword(password);
//        e.setName(name);
//        e.setPhoneNumber(phoneNumber);
//        e.setPermission(EmployeePermission.getByName(view.getCboPermission().getSelectedItem().toString()));
//        employeeDao.update(e);
//        return true;
//    }
}
