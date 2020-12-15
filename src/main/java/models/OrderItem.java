package models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MSI
 */
public class OrderItem {

    private int idOrder, idFoodItem, idTopping, quantity, foodPrice, toppingPrice;
    private String note;
    private FoodItem foodItem, toppingItem;

    public OrderItem() {
        quantity = 1;
        idTopping = 0;
        note = "";
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdFoodItem() {
        return idFoodItem;
    }

    public void setIdFoodItem(int idFoodItem) {
        this.idFoodItem = idFoodItem;
    }

    public int getIdTopping() {
        return idTopping;
    }

    public void setIdTopping(int idTopping) {
        this.idTopping = idTopping;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            this.quantity = 0;
        }
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(int toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
        this.idFoodItem = foodItem.getId();
    }

    public FoodItem getToppingItem() {
        return toppingItem;
    }

    public void setToppingItem(FoodItem toppingItem) {
        this.toppingItem = toppingItem;
        this.idTopping = toppingItem.getId();
    }

    public int getAmount() {
        return quantity * (foodPrice + toppingPrice);
    }

    public static OrderItem getFromResultSet(ResultSet rs) throws SQLException {
        OrderItem oi = new OrderItem();
        oi.setIdFoodItem(rs.getInt("idFoodItem"));
        oi.setIdOrder(rs.getInt("idOrder"));
        oi.setIdTopping(rs.getInt("idTopping"));
        oi.setQuantity(rs.getInt("quantity"));
        oi.setFoodPrice(rs.getInt("foodPrice"));
        oi.setToppingPrice(rs.getInt("toppingPrice"));
        oi.setNote(rs.getNString("note"));
        return oi;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "idOrder=" + idOrder + ", idFoodItem=" + idFoodItem + ", idTopping=" + idTopping + ", quantity=" + quantity + ", foodPrice=" + foodPrice + ", toppingPrice=" + toppingPrice + ", note=" + note + ", foodItem=" + foodItem + ", toppingItem=" + toppingItem + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItem other = (OrderItem) obj;
        if (this.idOrder != other.idOrder) {
            return false;
        }
        if (this.idFoodItem != other.idFoodItem) {
            return false;
        }
        if (this.idTopping != other.idTopping) {
            return false;
        }
        return true;
    }

}
