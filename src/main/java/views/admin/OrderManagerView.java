package views.admin;

import javax.swing.DefaultComboBoxModel;
import models.Order;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class OrderManagerView extends ManagerPaneView<Order> {

    String[] list = {"ID"};

    public OrderManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("ID");
        tableModel.addColumn("Người lập");
        tableModel.addColumn("Bàn");
        tableModel.addColumn("Loại");
        tableModel.addColumn("Trạng thái");
        tableModel.addColumn("Ngày lập HD");
        tableModel.addColumn("Ngày thanh toán");
        tableModel.addColumn("Đã Thanh Toán");
        this.getCboSearchField().setModel(new DefaultComboBoxModel(list));
    }
}
