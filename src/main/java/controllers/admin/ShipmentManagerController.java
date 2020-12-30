package controllers.admin;

import controllers.ManagerController;
import dao.ShipmentDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.Shipment;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class ShipmentManagerController extends ManagerController {

    ShipmentDao shipmentDao = new ShipmentDao();

    public ShipmentManagerController() {
        super();
    }

    @Override
    public void actionAdd() {
        view.showMessage("Vui lòng thao tác ở giao diện chỉnh sửa hóa đơn!");
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa hàng loạt?", "Xóa", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                shipmentDao.deleteById(selectedIds[i]);
                updateData();
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn đơn ship cần edit");
            } else {
                Shipment e = shipmentDao.get(selectedId);
                if (e == null) {
                    throw new Exception("Đơn ship bạn chọn không hợp lệ");
                }
//                popupController.edit(this, new ShipmentPopupView(), e);
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<Shipment> shipments = shipmentDao.getAll();
            view.setTableData(shipments);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            ArrayList<Shipment> shipments = shipmentDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), String.valueOf(view.getTxtSearch().getText()));
            view.setTableData(shipments);
        } catch (Exception e) {
            view.showError(e);
        }
    }

}