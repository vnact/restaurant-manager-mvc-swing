package controllers.admin;

import controllers.ManagerController;
import controllers.popup.FoodCategoryPopupController;
import dao.FoodCategoryDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//        popupController.add(this, new FoodCategoryPopupView());
        popupController.add(new FoodCategoryPopupView(), this::updateData, view::showError);
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn loại món cần edit");
            } else {
                FoodCategory foodCategory = foodCategoryDao.get(selectedId);
                if (foodCategory == null) {
                    throw new Exception("Loại món bạn chọn không hợp lệ");
                }
//                popupController.edit(this, new FoodCategoryPopupView(), foodCategory);
                popupController.edit(new FoodCategoryPopupView(), foodCategory, this::updateData, view::showError);
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
        try {
            ArrayList<FoodCategory> foodCategorys = foodCategoryDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
            view.setTableData(foodCategorys);
        } catch (SQLException ex) {
            Logger.getLogger(FoodCategoryManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
