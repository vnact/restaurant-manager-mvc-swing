package controllers.popup.order;

import java.util.ArrayList;
import javax.swing.JPanel;
import models.OrderItem;
import views.popup.order.OrderItemPane;

/**
 * createAt Dec 21, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class OrderItemController {

    private ArrayList<OrderItem> orderItems;
    private JPanel panelOrderItem;
    private int idOrder;

    public interface Event {

        public abstract void onChange();
    }
    Event onQuantityChange;

    public OrderItemController() {
    }

    public JPanel getPanelOrderItem() {
        return panelOrderItem;
    }

    public void setPanelOrderItem(JPanel panelOrderItem) {
        this.panelOrderItem = panelOrderItem;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void renderOrderItem() {
        panelOrderItem.removeAll();
        for (OrderItem orderItem : orderItems) {
            OrderItemPane pane = new OrderItemPane(orderItem);
            pane.getSpnQuantity().addChangeListener(evt -> {
                orderItem.setQuantity((int) pane.getSpnQuantity().getValue());
                if (onQuantityChange != null) {
                    onQuantityChange.onChange();// Gọi hàm update amount
                }
            });
            panelOrderItem.add(pane);
        }
        panelOrderItem.updateUI();
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
        renderOrderItem();
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (OrderItem orderItem : orderItems) {
            totalAmount += orderItem.getAmount();
        }
        return totalAmount;
    }

    public void addOrderItem(OrderItem item) {
        if (item == null) {
            return;
        }
        item.setIdOrder(idOrder);
        for (OrderItem orderItem : orderItems) {
            if (item.equals(orderItem)) {
                orderItem.setQuantity(orderItem.getQuantity() + item.getQuantity());
                orderItem.setFoodPrice(item.getFoodPrice());
                renderOrderItem();
                return;
            }
        }
        orderItems.add(item);
        renderOrderItem();
    }

    public void setOnQuantityChange(Event onQuantityChange) {
        this.onQuantityChange = onQuantityChange;
    }

}
