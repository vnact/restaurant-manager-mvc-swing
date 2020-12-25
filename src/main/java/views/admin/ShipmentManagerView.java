package views.admin;

import javax.swing.DefaultComboBoxModel;
import models.Shipment;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class ShipmentManagerView extends ManagerPaneView<Shipment> {

    String[] list = {"IDOrder"};

    public ShipmentManagerView() {
        super();
        setTableModel();
        renderTable();
    }

    @Override
    public void setTableModel() {
        tableModel.addColumn("Mã HD");
        tableModel.addColumn("Tên KH");
        tableModel.addColumn("Địa chỉ");
        tableModel.addColumn("Tên shipper");
        tableModel.addColumn("SDT shipper");
        tableModel.addColumn("Giá Ship");
        tableModel.addColumn("Trạng thái");
        tableModel.addColumn("Ngày bắt đầu");
        tableModel.addColumn("Ngày kết thúc");
        this.getCboSearchField().setModel(new DefaultComboBoxModel(list));
    }
}
