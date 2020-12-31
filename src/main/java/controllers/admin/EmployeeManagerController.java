package controllers.admin;

import controllers.ManagerController;
import controllers.popup.EmployeePopupController;
import dao.EmployeeDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.Employee;
import views.popup.EmployeePopupView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class EmployeeManagerController extends ManagerController {

    EmployeeDao employeeDao = new EmployeeDao();
    EmployeePopupController popupController = new EmployeePopupController();

    public EmployeeManagerController() {
        super();
    }

    @Override
    public void actionAdd() {
//        popupController.add(this, new EmployeePopupView());
        popupController.add(new EmployeePopupView(), () -> {
            updateData();
            view.showMessage("Thêm nhân viên thành công!");
        }, view::showError);
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn nhân viên cần edit");
            } else {
                Employee e = employeeDao.get(selectedId);
                if (e == null) {
                    throw new Exception("Nhân viên bạn chọn không hợp lệ");
                }
//                popupController.edit(this, new EmployeePopupView(), e);
                popupController.edit(new EmployeePopupView(), e, () -> {
                    updateData();
                    view.showMessage("Sửa nhân viên thành công!");
                }, view::showError);
            }
        } catch (Exception e) {
            view.showError(e);
        }
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
    public void updateData() {
        try {
            ArrayList<Employee> employees = employeeDao.getAll();
            view.setTableData(employees);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            ArrayList<Employee> employees = employeeDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
            view.setTableData(employees);
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
