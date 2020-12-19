package views.admin;

import models.FoodItem;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class FoodItemManagerView extends ManagerPaneView<FoodItem> {

    public FoodItemManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên Món");
        tableModel.addColumn("Mô tả");
        tableModel.addColumn("Link ảnh");
        tableModel.addColumn("Tên đv");
        tableModel.addColumn("Giá đv");
        tableModel.addColumn("Mã loại");
    }
}
