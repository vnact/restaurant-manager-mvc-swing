package views.admin;

import models.FoodCategory;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class FoodCategoryManagerView extends ManagerPaneView<FoodCategory> {

    public FoodCategoryManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên loại");
    }
}
