package controllers.admin;

import controllers.ManagerController;
import controllers.popup.FoodItemPopupController;
import dao.FoodItemDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.FoodItem;
import views.admin.FoodItemManagerView;
import views.popup.FoodItemPopupView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 * Manager Controller mẫu
 */
public class FoodItemManagerController extends ManagerController {

    FoodItemDao foodItemDao = new FoodItemDao();
    FoodItemPopupController popupController = new FoodItemPopupController();

    public FoodItemManagerController() {
        super();
    }

    public void setView(FoodItemManagerView view) {
        super.setView(view);
    }

    @Override
    public void actionAdd() {
//        popupController.add(this, new FoodItemPopupView());
        popupController.add(new FoodItemPopupView(), this::updateData, view::showError);
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn món cần edit");
            } else {
                FoodItem foodItem = foodItemDao.get(selectedId);
                if (foodItem == null) {
                    throw new Exception("Món bạn chọn không hợp lệ");
                }
//                popupController.edit(this, new FoodItemPopupView(), foodItem);
                popupController.edit(new FoodItemPopupView(), foodItem, this::updateData, view::showError);
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
                foodItemDao.deleteById(selectedIds[i]);
            }
            updateData();
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<FoodItem> foodItems = foodItemDao.getAll();
            view.setTableData(foodItems);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            ArrayList<FoodItem> foodItems = foodItemDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
            view.setTableData(foodItems);
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
