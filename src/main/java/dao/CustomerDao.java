package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Customer;

/**
 * @createAt Nov 25, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class CustomerDao extends Dao<Customer> {

    @Override
    public ArrayList<Customer> getAll() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `customer`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Customer customer = Customer.getFromResultSet(rs);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `customer` WHERE id = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Customer customer = Customer.getFromResultSet(rs);
            return customer;
        }
        return null;
    }

    @Override
    public void save(Customer t) throws SQLException {
        if (t == null) {
            throw new SQLException("Customer rỗng");
        }
        String query = "INSERT INTO `customer` (`phoneNumber`, `name`, `address`, `birthday`) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getPhoneNumber());
        stmt.setNString(2, t.getName());
        stmt.setNString(3, t.getAddress());
        stmt.setTimestamp(4, t.getBirthday());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(Customer t) throws SQLException {
        if (t == null) {
            throw new SQLException("Customer rỗng");
        }
        String query = "UPDATE `customer` SET `phoneNumber` = ?, `name` = ?, `address` = ?, `birthday` = ? WHERE `id` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getPhoneNumber());
        stmt.setNString(2, t.getName());
        stmt.setNString(3, t.getAddress());
        stmt.setTimestamp(4, t.getBirthday());
        stmt.setInt(5, t.getId());
        int row = stmt.executeUpdate();

    }

    @Override
    public void delete(Customer t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `customer` WHERE `id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();

    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `customer` WHERE `id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ArrayList<Customer> searchByKey(String key, String word) throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `customer` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Customer customer = Customer.getFromResultSet(rs);
            customers.add(customer);
        }
        return customers;
    }

}
