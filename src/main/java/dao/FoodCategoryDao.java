package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.FoodCategory;

/**
 * @createAt Dec 1, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class FoodCategoryDao extends Dao<FoodCategory> {

    @Override
    public ArrayList<FoodCategory> getAll() throws SQLException {
        ArrayList<FoodCategory> foodCategories = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_category`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            FoodCategory foodCategory = FoodCategory.getFromResultSet(rs);
            foodCategories.add(foodCategory);
        }
        return foodCategories;
    }

    @Override
    public FoodCategory get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_category` WHERE `id` = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            FoodCategory foodCategory = FoodCategory.getFromResultSet(rs);
            return foodCategory;
        }
        return null;
    }

    @Override
    public void save(FoodCategory t) throws SQLException {
        if (t == null) {
            throw new SQLException("FoodCategory rỗng");
        }
        String query = "INSERT INTO `food_category` (`name`, `slug`) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getName());
        stmt.setNString(2, t.getSlug());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(FoodCategory t) throws SQLException {
        if (t == null) {
            throw new SQLException("FoodCategory rỗng");
        }
        String query = "UPDATE `food_category` SET `name` = ?, `slug` = ? WHERE `id` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getName());
        stmt.setNString(2, t.getSlug());
        stmt.setInt(3, t.getId());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(FoodCategory t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `food_category` WHERE `id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `food_category` WHERE `id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public FoodCategory findByName(String name) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_category` WHERE `name` = '" + name + "'";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            FoodCategory foodCategory = FoodCategory.getFromResultSet(rs);
            return foodCategory;
        }
        return null;
    }

    public ArrayList<FoodCategory> searchByKey(String key, String word) throws SQLException {
        ArrayList<FoodCategory> foodCategorys = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `food_category` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            FoodCategory foodCategory = FoodCategory.getFromResultSet(rs);
            foodCategorys.add(foodCategory);
        }
        return foodCategorys;
    }

}
