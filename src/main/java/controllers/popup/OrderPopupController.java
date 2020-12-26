package controllers.popup;

import controllers.PopupController;
import controllers.admin.OrderManagerController;
import controllers.popup.order.FoodItemController;
import controllers.popup.order.OrderItemController;
import dao.EmployeeDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.TableDao;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import main.SessionManager;
import models.Employee;
import models.Order;
import models.OrderItem;
import models.Table;
import utils.EmployeePermission;
import utils.OrderStatus;
import utils.OrderType;
import utils.TableStatus;
import views.popup.AddOrderPopupView;
import views.popup.EditOrderPopupView;
import views.popup.ToppingPopupView;

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
    FoodItemController foodItemController = new FoodItemController();
    OrderItemController orderItemController = new OrderItemController();
    ToppingPopupController toppingPopupController = new ToppingPopupController();
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    public void add(OrderManagerController parrent, AddOrderPopupView view) {
        Employee session = SessionManager.getSession().getEmployee();
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
                    if (session.getPermission() == EmployeePermission.MANAGER) {
                        parrent.updateData();
                    } else {
                        parrent.updateDataByEmployee();
                    }
                    view.showMessage("Thêm hóa đơn thành công!");
                }
            } catch (Exception ex) {
                view.showError(ex);
            }
        });

    }

    public void edit(OrderManagerController parrent, EditOrderPopupView view, Order order) {
        setView(view);
        orderItemController.setPanelOrderItem(view.getPnlOrderItem());
        orderItemController.setIdOrder(order.getId());
        orderItemController.setOnQuantityChange(() -> {
            updateAmount(view, order);
        });
        foodItemController.setPanelFoodCategory(view.getPnlFoodCategory());
        foodItemController.setPanelFoodItem(view.getPnlFoodItem());

        Employee employee = SessionManager.getSession().getEmployee();

        if (employee != null) {
            view.getLbEmployeeName().setText(employee.getName());
        }
        view.getLbIdOrder().setText(order.getId() + "");
        try {
            for (Table table : tableDao.getAll()) { // Hiển thị danh sách bàn
                if (table.getStatus() == TableStatus.FREE || table.getId() == order.getIdTable()) {
                    view.getTbComboBoxModel().addElement(table);
                }
            }

            for (OrderType ot : OrderType.values()) { // Hiển thị loại hóa đơn
                view.getCboType().addItem(ot.getName());
            }
            orderItemController.setOrderItems(orderItemDao.getByIdOrder(order.getId()));
            foodItemController.renderCategory(foodItem -> {//Hiển thị danh sách món ăn
                System.out.println(foodItem);
                toppingPopupController.add(new ToppingPopupView(), foodItem, orderItem -> {
                    orderItemController.addOrderItem(orderItem);// Thêm vào danh sách order
                    updateAmount(view, order);
                });
            });
            view.getTbComboBoxModel().setSelectedItem(order.getTable());
            view.getSpnDiscount().setValue(order.getDiscount());
            view.getCboType().setSelectedItem(order.getType().getName());
            view.getLbDiscount().setText(order.getDiscount() + "");

        } catch (Exception e) {
            view.dispose();
            view.showError(e);
            return;
        }
        updateAmount(view, order);
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
        view.getSpnDiscount().addChangeListener(evt -> { // Thay giá trị
            order.setDiscount((int) view.getSpnDiscount().getValue());
            updateAmount(view, order);
        });
        view.getCboTable().addActionListener(evt -> { // Thay bàn
            try {
                Table nTable = (Table) view.getTbComboBoxModel().getSelectedItem(),
                        cTable = order.getTable();
                if (nTable == null || (cTable != null && nTable.getId() == cTable.getId())) {
                    return;
                }
                cTable.setStatus(TableStatus.FREE);
                nTable.setStatus(TableStatus.SERVING);
                order.setTable(nTable);
                tableDao.update(cTable);
                tableDao.update(nTable);
            } catch (Exception ex) {
                view.showError(ex);
            }
        });
        view.getBtnPaid().addActionListener(evt -> {
            try {
                String rawInput = JOptionPane.showInputDialog(null, "Nhập số tiền thanh toán!", order.getPaidAmount());
                if (rawInput == null) {
                    return;
                }
                int paidAmount = Integer.parseInt(rawInput);
                if (order.getFinalAmount() > paidAmount) {
                    JOptionPane.showMessageDialog(null, "Bạn còn phải thanh toán " + formatter.format(order.getFinalAmount() - paidAmount) + " VND");
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn đã thanh toán xong");
                }
                order.setPaidAmount(paidAmount);
                updateAmount(view, order);
            } catch (Exception e) {
                view.showError(e);
            }
        });

    }

    public void updateAmount(EditOrderPopupView view, Order order) {
        order.setTotalAmount(orderItemController.getTotalAmount());
        view.getLbDiscount().setText(order.getDiscount() + "");
        view.getLbPaidAmount().setText(formatter.format(order.getPaidAmount()));
        view.getLbFinalAmount().setText(formatter.format(order.getFinalAmount()));
        view.getLbTotalAmount().setText(formatter.format(order.getTotalAmount()));
    }

    public boolean addOrder() throws Exception {
        AddOrderPopupView view = (AddOrderPopupView) this.getView();
        Order e = new Order();
        Table table = (Table) view.getTbComboBoxModel().getSelectedItem();
        OrderType type = OrderType.getByName(view.getCboType().getSelectedItem().toString());
        Employee employee = SessionManager.getSession().getEmployee();
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
        order.setEmployee(employee);
        order.setTable(table);
        order.setStatus(OrderStatus.UNPAID);
        order.setType(type);
        order.setDiscount(discount);
        orderDao.save(order);
        tableDao.update(table);
        return true;
    }

    public boolean editOrder(Order order) throws Exception {
        EditOrderPopupView view = (EditOrderPopupView) this.getView();
        if (order.getTable() == null) {
            throw new Exception("Hết bàn");
        }
        if (order.getDiscount() < 0 || order.getDiscount() > 100) {
            throw new Exception("Discount phải nằm trong khoảng 0-100");
        }
        if (order.getEmployee() == null) {
            throw new Exception("Chọn nhân viên");
        }
        if (order.getType() == OrderType.LOCAL) {
            order.getTable().setStatus(TableStatus.SERVING);
        } else {
            order.getTable().setStatus(TableStatus.FREE);
        }
        if (order.getPaidAmount() == order.getFinalAmount()) {
            order.setStatus(OrderStatus.PAID);
        }
        for (OrderItem orderItem : orderItemController.getOrderItems()) {
            if (orderItem.getQuantity() <= 0) {
                orderItemDao.delete(orderItem);
            } else {
                orderItemDao.save(orderItem);
            }
        }
        if (order.getFinalAmount() > order.getPaidAmount()) {// Chưa thanh toán 
            order.setStatus(OrderStatus.UNPAID);
            order.setPayDate(null);
        } else {// Thanh toán
            order.setStatus(OrderStatus.PAID);
            order.setPayDate(new Timestamp(System.currentTimeMillis()));
            order.getTable().setStatus(TableStatus.FREE); // Trả bàn
        }
        order.setTotalAmount(orderItemController.getTotalAmount());
        orderDao.update(order);
        tableDao.update(order.getTable());
        return true;
    }
}
