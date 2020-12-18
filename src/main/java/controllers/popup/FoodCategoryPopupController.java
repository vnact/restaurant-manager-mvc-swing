package controllers.popup;

import controllers.PopupController;
import controllers.admin.FoodCategoryManagerController;
import dao.FoodCategoryDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.FoodCategory;
import views.popup.FoodCategoryPopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class FoodCategoryPopupController extends PopupController {

    FoodCategoryDao foodCategoryDao = new FoodCategoryDao();

    public void add(FoodCategoryManagerController parrent, FoodCategoryPopupView view) {
        setView(view);
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean addSuccess = addFoodCategory();
                    if (addSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Thêm loại món thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public void edit(FoodCategoryManagerController parrent, FoodCategoryPopupView view, FoodCategory employee) {
        setView(view);

        view.getLbTitle().setText("Sửa loại món - " + employee.getId());
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean editSuccess = editFoodCategory(employee);
                    if (editSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Sửa loại món thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public boolean addFoodCategory() throws Exception {
        FoodCategoryPopupView view = (FoodCategoryPopupView) this.getView();
        FoodCategory e = new FoodCategory();
        foodCategoryDao.save(e);
        return true;
    }

    public boolean editFoodCategory(FoodCategory e) throws Exception {
        FoodCategoryPopupView view = (FoodCategoryPopupView) this.getView();
        foodCategoryDao.update(e);
        return true;
    }
}
