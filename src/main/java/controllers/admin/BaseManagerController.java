package controllers.admin;

import controllers.ManagerController;
import controllers.popup.BasePopupController;
import dao.BaseDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.Base;
import views.admin.EmployeeManagerView;
import views.popup.BasePopupView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 * Manager Controller mẫu
 */
public class BaseManagerController extends ManagerController {

    BaseDao foodCategoryDao = new BaseDao();
    BasePopupController popupController = new BasePopupController();

    public BaseManagerController() {
        super();
    }

    public void setView(EmployeeManagerView view) {
        super.setView(view);
    }

    @Override
    public void actionAdd() {
        popupController.add(this, new BasePopupView());
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn bàn cần edit");
            } else {
                Base t = foodCategoryDao.get(selectedId);
                if (t == null) {
                    throw new Exception("Bàn bạn chọn không hợp lệ");
                }
                popupController.edit(this, new BasePopupView(), t);
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa hàng loạt?", "Xóa", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                foodCategoryDao.deleteById(selectedIds[i]);
            }
            updateData();
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<Base> tables = foodCategoryDao.getAll();
            view.setTableData(tables);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
