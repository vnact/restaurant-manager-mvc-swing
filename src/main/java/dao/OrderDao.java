/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Order;
import utils.OrderStatus;

/**
 *
 * @author MSI
 */
public class OrderDao extends Dao<Order> {

    EmployeeDao employeeDao = new EmployeeDao();
    TableDao tableDao = new TableDao();

    @Override
    public ArrayList<Order> getAll() throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `order` ORDER BY `order`.`orderDate` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Order order = Order.getFromResultSet(rs);
            order.setEmployee(employeeDao.get(order.getIdEmployee()));
            order.setTable(tableDao.get(order.getIdTable()));
            orders.add(order);
        }
        return orders;
    }

    public ArrayList<Order> getAll(int idEmployee) throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `order`  WHERE `idEmployee`= '" + idEmployee + "' ORDER BY `order`.`orderDate` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Order order = Order.getFromResultSet(rs);
            order.setEmployee(employeeDao.get(order.getIdEmployee()));
            order.setTable(tableDao.get(order.getIdTable()));
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `order` WHERE `id` = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Order order = Order.getFromResultSet(rs);
            order.setEmployee(employeeDao.get(order.getIdEmployee()));
            order.setTable(tableDao.get(order.getIdTable()));
            return order;
        }
        return null;
    }

    @Override
    public void save(Order t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order rỗng");
        }
        String query = "INSERT INTO `order` (`idEmployee`, `idTable`, `type`, `status`, `orderDate`, `payDate`, `paidAmount`, `totalAmount`, `discount`) VALUES (?, ?, ?, ?, current_timestamp(), NULL, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdEmployee());
        stmt.setInt(2, t.getIdTable());
        stmt.setNString(3, t.getType().getId());
        stmt.setNString(4, t.getStatus().getId());
        stmt.setInt(5, t.getPaidAmount());
        stmt.setInt(6, t.getTotalAmount());
        stmt.setInt(7, t.getDiscount());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(Order t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order rỗng");
        }
        String query = "UPDATE `order` SET `idEmployee` = ?, `idTable` = ?, `type` = ?, `status` = ?, `orderDate` = ?, `payDate` = ?, `paidAmount` = ?, `totalAmount` = ?, `discount` = ? WHERE `order`.`id` = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdEmployee());
        stmt.setInt(2, t.getIdTable());
        stmt.setNString(3, t.getType().getId());
        stmt.setNString(4, t.getStatus().getId());
        stmt.setTimestamp(5, t.getOrderDate());
        stmt.setTimestamp(6, t.getPayDate());
        stmt.setInt(7, t.getPaidAmount());
        stmt.setInt(8, t.getTotalAmount());
        stmt.setInt(9, t.getDiscount());
        stmt.setInt(10, t.getId());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(Order t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `order` WHERE `order`.`id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `order` WHERE `order`.`id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void deleteItems(int idOder) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `order_item` WHERE `idOrder` = ?");
        stmt.setInt(1, idOder);
        stmt.executeUpdate();
    }

    public ArrayList<Order> searchByKey(String key, String word) throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `order` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Order order = Order.getFromResultSet(rs);
            order.setEmployee(employeeDao.get(order.getIdEmployee()));
            order.setTable(tableDao.get(order.getIdTable()));
            orders.add(order);
        }
        return orders;
    }

    public void create(Order t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order rỗng");
        }
        String query = "INSERT INTO `order` (`idEmployee`, `idTable`, `type`, `status`, `orderDate`, `payDate`, `paidAmount`, `totalAmount`, `discount`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdEmployee());
        stmt.setInt(2, t.getIdTable());
        stmt.setNString(3, t.getType().getId());
        stmt.setNString(4, t.getStatus().getId());
        stmt.setTimestamp(5, t.getOrderDate());
        stmt.setTimestamp(6, t.getPayDate());
        stmt.setInt(7, t.getPaidAmount());
        stmt.setInt(8, t.getTotalAmount());
        stmt.setInt(9, t.getDiscount());
        int row = stmt.executeUpdate();
    }

    public ArrayList<Order> searchByKey(int idEmployee, String key, String word) throws SQLException {
        ArrayList<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM `order` WHERE " + key + " LIKE ? AND idEmployee = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, String.format("%s%s%s", "%", word, "%"));
        statement.setInt(2, idEmployee);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Order order = Order.getFromResultSet(rs);
            order.setEmployee(employeeDao.get(order.getIdEmployee()));
            order.setTable(tableDao.get(order.getIdTable()));
            orders.add(order);
        }
        return orders;
    }

    public Order getRandom() throws SQLException {
        String query = "SELECT * FROM `order` WHERE status = ? ORDER BY RAND() LIMIT 1";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.UNPAID.getId());
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            Order order = Order.getFromResultSet(rs);
            order.setEmployee(employeeDao.get(order.getIdEmployee()));
            order.setTable(tableDao.get(order.getIdTable()));
            return order;
        }
        return null;
    }

}
