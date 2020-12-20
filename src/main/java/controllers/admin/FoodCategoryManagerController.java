package controllers.admin;

import controllers.ManagerController;
import controllers.popup.FoodCategoryPopupController;
import dao.FoodCategoryDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.FoodCategory;
import views.popup.FoodCategoryPopupView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class FoodCategoryManagerController extends ManagerController {

    FoodCategoryDao foodCategoryDao = new FoodCategoryDao();
    FoodCategoryPopupController popupController = new FoodCategoryPopupController();

    public FoodCategoryManagerController() {
        super();
    }

//    public void setView(FoodCategoryManagerView view) {
//        super.setView(view);
//    }
    @Override
    public void actionAdd() {
        popupController.add(this, new FoodCategoryPopupView());
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn bàn cần edit");
            } else {
                FoodCategory t = foodCategoryDao.get(selectedId);
                if (t == null) {
                    throw new Exception("Bàn bạn chọn không hợp lệ");
                }
                popupController.edit(this, new FoodCategoryPopupView(), t);
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
            ArrayList<FoodCategory> foodCategorys = foodCategoryDao.getAll();
            view.setTableData(foodCategorys);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
