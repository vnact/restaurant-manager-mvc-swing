package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Employee;

/**
 *
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class EmployeeDao extends Dao<Employee> {

    @Override
    public ArrayList<Employee> getAll() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM employee;";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Employee employee = Employee.getFromResultSet(rs);
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM employee WHERE employee.id = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Employee employee = Employee.getFromResultSet(rs);
            return employee;
        }
        return null;
    }

    @Override
    public void save(Employee t) throws SQLException {
        if (t == null) {
            throw new SQLException("Employee rỗng");
        }
        String query = "INSERT INTO `employee` (`username`, `password`, `name`, `phoneNumber`, `startDate`, `permission`, `salary`)"
                + " VALUES (?, ?, ?, ?, current_timestamp(), ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
//            stmt.setLong(0, t.getId());
        stmt.setNString(1, t.getUsername());
        stmt.setNString(2, t.getPassword());
        stmt.setNString(3, t.getName());
        stmt.setNString(4, t.getPhoneNumber());
        stmt.setNString(5, t.getPermission().getId());
        stmt.setInt(6, t.getSalary());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(Employee t) throws SQLException {
        if (t == null) {
            throw new SQLException("Employee rong");
        }
        String query = "UPDATE `employee` SET `username` = ?, `password` = ?, `name` = ?, `phoneNumber` = ?, `permission` = ?, `salary` = ? WHERE `id` = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getUsername());
        stmt.setNString(2, t.getPassword());
        stmt.setNString(3, t.getName());
        stmt.setNString(4, t.getPhoneNumber());
        stmt.setNString(5, t.getPermission().getId());
        stmt.setInt(6, t.getSalary());
        stmt.setInt(7, t.getId());
        stmt.executeUpdate();
    }

    @Override
    public void delete(Employee t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `employee` WHERE `employee`.`id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `employee` WHERE `employee`.`id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public Employee findByUsername(String userName) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM employee WHERE employee.username = '" + userName + "'";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Employee employee = Employee.getFromResultSet(rs);
            return employee;
        }
        return null;
    }

    public ArrayList<Employee> searchByKey(String key, String word) throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `employee` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Employee employee = Employee.getFromResultSet(rs);
            employees.add(employee);
        }
        return employees;
    }

    public Employee getRandom() throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM employee ORDER BY RAND() LIMIT 1";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Employee employee = Employee.getFromResultSet(rs);
            return employee;
        }
        return null;
    }
}
