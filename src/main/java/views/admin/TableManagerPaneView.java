package views.admin;

import models.Table;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class TableManagerPaneView extends ManagerPaneView<Table> {

    public TableManagerPaneView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên bàn");
        tableModel.addColumn("Trạng thái");
    }
}
