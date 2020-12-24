package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.OrderItem;

/**
 *
 * @author MSI
 */
public class OrderItemDao extends Dao<OrderItem> {

    FoodItemDao foodItemDao = new FoodItemDao();

    @Override
    public ArrayList<OrderItem> getAll() throws SQLException {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `order_item` ORDER BY `order_item`.`idOrder` DESC, `order_item`.`quantity` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            OrderItem orderItem = OrderItem.getFromResultSet(rs);
            orderItem.setFoodItem(foodItemDao.get(orderItem.getIdFoodItem()));
            orderItem.setToppingItem(foodItemDao.get(orderItem.getIdTopping()));
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    @Override
    public OrderItem get(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(OrderItem t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order Item rỗng");
        }
        String query = "INSERT INTO `order_item` (`idOrder`, `idFoodItem`, `idTopping`, `quantity`, `foodPrice`, `toppingPrice`, `note`) VALUES (?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE  `quantity` = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdOrder());
        stmt.setInt(2, t.getIdFoodItem());
        stmt.setInt(3, t.getIdTopping());
        stmt.setInt(4, t.getQuantity());
        stmt.setInt(5, t.getFoodPrice());
        stmt.setInt(6, t.getToppingPrice());
        stmt.setNString(7, t.getNote());
        stmt.setInt(8, t.getQuantity());
        stmt.executeUpdate();
    }

    @Override
    public void update(OrderItem t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order Item rỗng");
        }
        String query = "UPDATE `order_item` SET  `quantity` = ?, `foodPrice` = ?, `toppingPrice` = ?, `note` = ? WHERE `idOrder` = ? AND `idFoodItem` = ? AND `idTopping` = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getQuantity());
        stmt.setInt(2, t.getFoodPrice());
        stmt.setInt(3, t.getToppingPrice());
        stmt.setNString(4, t.getNote());
        stmt.setInt(5, t.getIdOrder());
        stmt.setInt(6, t.getIdFoodItem());
        stmt.setInt(7, t.getIdTopping());
        stmt.executeUpdate();
    }

    @Override
    public void delete(OrderItem t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order Item rỗng");
        }
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `order_item` WHERE `idOrder` = ? AND `idFoodItem` = ? AND `idTopping` = ?");
        stmt.setInt(1, t.getIdOrder());
        stmt.setInt(2, t.getIdFoodItem());
        stmt.setInt(3, t.getIdTopping());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addItem(OrderItem t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order Item rỗng");
        }
        String query = "CALL `addOrderItem`(?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdOrder());
        stmt.setInt(2, t.getIdFoodItem());
        stmt.setInt(3, t.getIdTopping());
        stmt.setInt(4, t.getQuantity());
        stmt.setNString(5, t.getNote());
    }

    public ArrayList<OrderItem> getByIdOrder(int idOrder) throws SQLException {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `order_item`WHERE `idOrder` = " + idOrder + "  ORDER BY `order_item`.`quantity` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            OrderItem orderItem = OrderItem.getFromResultSet(rs);
            orderItem.setFoodItem(foodItemDao.get(orderItem.getIdFoodItem()));
            orderItem.setToppingItem(foodItemDao.get(orderItem.getIdTopping()));
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    public ArrayList<OrderItem> searchByKey(String key, String word) throws SQLException {
        ArrayList<OrderItem> orderitems = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `order_item` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            OrderItem orderitem = OrderItem.getFromResultSet(rs);
            orderitems.add(orderitem);
        }
        return orderitems;
    }

}
