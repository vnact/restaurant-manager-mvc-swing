package controllers.popup;

import controllers.PopupController;
import controllers.admin.OrderManagerController;
import controllers.popup.order.FoodItemController;
import controllers.popup.order.OrderItemController;
import dao.EmployeeDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.TableDao;
import main.Runner;
import models.Employee;
import models.Order;
import models.Table;
import utils.OrderStatus;
import utils.OrderType;
import utils.TableStatus;
import views.popup.AddOrderPopupView;
import views.popup.EditOrderPopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 * Popup controller mẫu
 */
public class OrderPopupController extends PopupController {

    OrderDao orderDao = new OrderDao();
    EmployeeDao employeeDao = new EmployeeDao();
    TableDao tableDao = new TableDao();
    OrderItemDao orderItemDao = new OrderItemDao();

    public void add(OrderManagerController parrent, AddOrderPopupView view) {
        setView(view);
        try {
            for (Table table : tableDao.getAll()) {
                if (table.getStatus() == TableStatus.FREE) {
                    view.getTbComboBoxModel().addElement(table);
                }
            }
            for (OrderType ot : OrderType.values()) {
                view.getCboType().addItem(ot.getName());
            }
        } catch (Exception e) {
            view.dispose();
            view.showError(e);
            return;
        }
        view.getBtnOK().addActionListener(evt -> {
            try {
                boolean addSuccess = addOrder();
                if (addSuccess) {
                    view.dispose();
                    parrent.updateData();
                    view.showMessage("Thêm hóa đơn thành công!");
                }
            } catch (Exception ex) {
                view.showError(ex);
            }
        });

    }

    public void edit(OrderManagerController parrent, EditOrderPopupView view, Order order) {
        FoodItemController foodItemController = new FoodItemController();
        OrderItemController orderItemController = new OrderItemController();

        setView(view);

        orderItemController.setPanelOrderItem(view.getPnlOrderItem());
        orderItemController.setIdOrder(order.getId());
        foodItemController.setPanelFoodCategory(view.getPnlFoodCategory());
        foodItemController.setPanelFoodItem(view.getPnlFoodItem());

        Employee employee = Runner.getSession();

        if (employee != null) {
            view.getLbEmployeeName().setText(employee.getName());
        }
        view.getLbIdOrder().setText(order.getId() + "");
        try {
            for (Table table : tableDao.getAll()) {
                if (table.getStatus() == TableStatus.FREE || table.getId() == order.getIdTable()) {
                    view.getTbComboBoxModel().addElement(table);
                }
            }

            for (OrderType ot : OrderType.values()) {
                view.getCboType().addItem(ot.getName());
            }
            orderItemController.setOrderItems(orderItemDao.getByIdOrder(order.getId()));

            view.getTbComboBoxModel().setSelectedItem(order.getTable());
            view.getSpnDiscount().setValue(order.getDiscount());
            view.getCboType().setSelectedItem(order.getType().getName());
            view.getLbDiscount().setText(order.getDiscount() + "");
            foodItemController.renderCategory(foodItem -> {
                System.out.println(foodItem);
            });

        } catch (Exception e) {
            view.dispose();
            view.showError(e);
            return;
        }

        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(evt -> {
            try {
                boolean editSuccess = editOrder(order);
                if (editSuccess) {
                    view.dispose();
                    parrent.updateData();
                    view.showMessage("Sửa hóa đơn thành công!");
                }
            } catch (Exception ex) {
                view.showError(ex);
            }
        });
        view.getSpnDiscount().addChangeListener(evt -> {
            order.setDiscount((int) view.getSpnDiscount().getValue());
            view.getLbDiscount().setText(order.getDiscount() + "");
        });

    }

    public boolean addOrder() throws Exception {
        AddOrderPopupView view = (AddOrderPopupView) this.getView();
        Order e = new Order();
        Table table = (Table) view.getTbComboBoxModel().getSelectedItem();
        OrderType type = OrderType.getByName(view.getCboType().getSelectedItem().toString());
        Employee employee = Runner.getSession();
        int discount = (int) view.getSpnDiscount().getValue();
        if (table == null) {
            throw new Exception("Hết bàn");
        }
        if (discount < 0 || discount > 100) {
            throw new Exception("Discount phải nằm trong khoảng 0-100");
        }
        if (employee == null) {
            throw new Exception("Bạn chưa đăng nhập");
        }
        if (type == OrderType.LOCAL) {
            if (tableDao.get(table.getId()).getStatus() != TableStatus.FREE) {
                throw new Exception("Bàn này đang phục vụ");
            }
            table.setStatus(TableStatus.SERVING);
        }

        Order order = new Order();
        order.setIdEmployee(employee.getId());
        order.setIdTable(table.getId());
        order.setStatus(OrderStatus.UNPAID);
        order.setType(type);
        order.setDiscount(discount);
        orderDao.save(order);
        tableDao.update(table);
        return true;
    }

    public boolean editOrder(Order order) throws Exception {
        EditOrderPopupView view = (EditOrderPopupView) this.getView();
        orderDao.update(order);
        return true;
    }
}
