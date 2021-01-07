package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.FoodItem;

/**
 * @createAt Dec 8, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class FoodItemDao extends Dao<FoodItem> {

    @Override
    public ArrayList<FoodItem> getAll() throws SQLException {
        ArrayList<FoodItem> foodItems = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_item` ORDER BY `food_item`.`idCategory` ASC , `food_item`.`name` ASC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            FoodItem foodItem = FoodItem.getFromResultSet(rs);
            foodItems.add(foodItem);
        }
        return foodItems;
    }

    public ArrayList<FoodItem> getByIdCategory(int id) throws SQLException {
        ArrayList<FoodItem> foodItems = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_item` WHERE `idCategory` = " + id;
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            FoodItem foodItem = FoodItem.getFromResultSet(rs);
            foodItems.add(foodItem);
        }
        return foodItems;
    }

    @Override
    public FoodItem get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_item` WHERE `id` = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            FoodItem foodItem = FoodItem.getFromResultSet(rs);
            return foodItem;
        }
        return null;
    }

    @Override
    public void save(FoodItem t) throws SQLException {
        if (t == null) {
            throw new SQLException("Food item rỗng");
        }
        String query = "INSERT INTO `food_item` (`name`, `description`, `urlImage`, `unitName`, `unitPrice`, `idCategory`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getName());
        stmt.setNString(2, t.getDescription());
        stmt.setNString(3, t.getUrlImage());
        stmt.setNString(4, t.getUnitName());
        stmt.setInt(5, t.getUnitPrice());
        stmt.setInt(6, t.getIdCategory());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(FoodItem t) throws SQLException {
        if (t == null) {
            throw new SQLException("Food item rỗng");
        }
        String query = "UPDATE `food_item` SET `name` = ?, `description` = ?, `urlImage` = ?, `unitName` = ?, `unitPrice` = ?, `idCategory` = ? WHERE `food_item`.`id` = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setLong(0, t.getId());
        stmt.setNString(1, t.getName());
        stmt.setNString(2, t.getDescription());
        stmt.setNString(3, t.getUrlImage());
        stmt.setNString(4, t.getUnitName());
        stmt.setInt(5, t.getUnitPrice());
        stmt.setInt(6, t.getIdCategory());
        stmt.setInt(7, t.getId());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(FoodItem t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `food_item` WHERE `food_item`.`id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `food_item` WHERE `food_item`.`id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ArrayList<FoodItem> searchByKey(String key, String word) throws SQLException {
        ArrayList<FoodItem> fooditems = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_item` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            FoodItem fooditem = FoodItem.getFromResultSet(rs);
            fooditems.add(fooditem);
        }
        return fooditems;
    }

    public FoodItem getRandom() throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_item` WHERE idCategory != 4 ORDER BY RAND() LIMIT 1";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            FoodItem foodItem = FoodItem.getFromResultSet(rs);
            return foodItem;
        }
        return null;
    }

    public FoodItem getRandom(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_item` WHERE `idCategory` = " + id + " ORDER BY RAND() LIMIT 1";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            FoodItem foodItem = FoodItem.getFromResultSet(rs);
            return foodItem;
        }
        return null;
    }

}
