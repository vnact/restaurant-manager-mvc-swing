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
                    view.showError(ex);
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
                    view.showError(ex);
                }
            }
        });

    }

    public boolean addFoodCategory() throws Exception {
        FoodCategoryPopupView view = (FoodCategoryPopupView) this.getView();
        String foodCategoryName = view.getTxtName().getText();
        if (foodCategoryName.isEmpty()) {
            throw new Exception("Vui lòng điền đủ thông tin");
        }
        if (foodCategoryDao.findByName(foodCategoryName) != null) {
            throw new Exception("Tên loại đã tồn tại");
        }
        FoodCategory f = new FoodCategory();
        f.setName(foodCategoryName);
        foodCategoryDao.save(f);
        return true;
    }

    public boolean editFoodCategory(FoodCategory fc) throws Exception {
        FoodCategoryPopupView view = (FoodCategoryPopupView) this.getView();
        String foodCategoryName = view.getTxtName().getText();
        if (foodCategoryName.isEmpty()) {
            throw new Exception("Điền tên loại món");
        }
        FoodCategory temp = foodCategoryDao.findByName(foodCategoryName);
        if (temp != null && temp.getId() != fc.getId()) {
            throw new Exception("Tên loại món đã được sử dụng");
        }
        fc.setName(foodCategoryName);
        foodCategoryDao.update(fc);
        return true;
    }
}
