package controllers.admin;

import controllers.ManagerController;
import controllers.popup.OrderPopupController;
import dao.OrderDao;
import dao.TableDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import main.Runner;
import models.Order;
import models.Table;
import utils.TableStatus;
import views.admin.EmployeeManagerView;
import views.popup.AddOrderPopupView;
import views.popup.EditOrderPopupView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 * Manager Controller mẫu
 */
public class OrderManagerController extends ManagerController {

    OrderDao orderDao = new OrderDao();
    TableDao tableDao = new TableDao();
    OrderPopupController popupController = new OrderPopupController();

    public OrderManagerController() {
        super();
    }

    public void updateDataByEmployee() {
        try {
            ArrayList<Order> orders = orderDao.getByEmployee(Runner.getSession().getId());
            view.setTableData(orders);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    public void setView(EmployeeManagerView view) {
        super.setView(view);
    }

    @Override
    public void actionAdd() {
        popupController.add(this, new AddOrderPopupView());
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn hóa đơn cần edit");
            }
            Order order = orderDao.get(selectedId);
            if (order == null) {
                throw new Exception("Hóa đơn bạn chọn không hợp lệ");
            }
            popupController.edit(this, new EditOrderPopupView(), order);

        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Không thể khổi phục\nXác nhận xóa hàng loạt?", "Xóa", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                int id = selectedIds[i];
                Order o = orderDao.get(id);
                Table t = o.getTable();
                t.setStatus(TableStatus.FREE);
                orderDao.deleteItems(id); // Xóa item trong order 
                tableDao.update(t); // Trả bàn
                orderDao.deleteById(id); // Xóa order

            }
            updateData();
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<Order> orders = orderDao.getAll();
            view.setTableData(orders);
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionSearch() {
        try {
            ArrayList<Order> orders = orderDao.searchByKey(view.getCboSearchField().getSelectedItem().toString(), view.getTxtSearch().getText());
            view.setTableData(orders);
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
