package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import utils.OrderStatus;

/**
 * createAt Dec 28, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class StatisticalDao {
    
    Connection conn = Database.getInstance().getConnection();
    
    public int getTotalOrder(Timestamp start, Timestamp end, int idEmployee) throws SQLException {
        String query = "SELECT COUNT(*) AS totalOrder FROM `order` WHERE status = ? AND orderDate >= ? AND orderDate <= ? AND idEmployee = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        statement.setInt(4, idEmployee);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("totalOrder");
        }
        return 0;
    }
    
    public int getTotalOrder(Timestamp start, Timestamp end) throws SQLException {
        String query = "SELECT COUNT(*) AS totalOrder FROM `order` WHERE status = ? AND orderDate >= ? AND orderDate <= ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("totalOrder");
        }
        return 0;
    }
    
    public int getTotalOrder(int idEmployee) throws SQLException {
        Timestamp start = new Timestamp(0);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        return getTotalOrder(start, end, idEmployee);
    }
    
    public int getTotalOrder() throws SQLException {
        Timestamp start = new Timestamp(0);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        return getTotalOrder(start, end);
    }
    
    public int getTotalWorkingMinutes(Timestamp start, Timestamp end) throws SQLException {
        String query = "SELECT FLOOR(SUM(TIME_TO_SEC(TIMEDIFF(endTime, startTime))) / 60) AS totalWorkingMinutes FROM `session` WHERE DATE(startTime) >= DATE(?) AND DATE(endTime) <= DATE(?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setTimestamp(1, start);
        statement.setTimestamp(2, end);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("totalWorkingMinutes");
        }
        return 0;
    }
    
    public int getTotalWorkingMinutes(Timestamp start, Timestamp end, int idEmployee) throws SQLException {
        String query = "SELECT FLOOR(SUM(TIME_TO_SEC(TIMEDIFF(endTime, startTime))) / 60) AS totalWorkingMinutes FROM `session` WHERE DATE(startTime) >= DATE(?) AND DATE(endTime) <= DATE(?) AND idEmployee = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setTimestamp(1, start);
        statement.setTimestamp(2, end);
        statement.setInt(3, idEmployee);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("totalWorkingMinutes");
        }
        return 0;
    }
    
    public int getTotalWorkingMinutes() throws SQLException {
        
        Timestamp start = new Timestamp(0);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        return getTotalWorkingMinutes(start, end);
    }
    
    public int getTotalWorkingMinutes(int idEmployee) throws SQLException {
        Timestamp start = new Timestamp(0);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        return getTotalWorkingMinutes(start, end, idEmployee);
    }
    
    public int getTotalIncome() throws SQLException {
        Timestamp start = new Timestamp(0);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        return getTotalIncome(start, end);
    }
    
    public int getTotalIncome(int idEmployee) throws SQLException {
        Timestamp start = new Timestamp(0);
        Timestamp end = new Timestamp(System.currentTimeMillis());
        return getTotalIncome(start, end, idEmployee);
    }
    
    public int getTotalIncome(Timestamp start, Timestamp end) throws SQLException {
        String query = "SELECT SUM(paidAmount) AS totalIncome FROM `order` WHERE status = ? AND DATE(orderDate) >= DATE(?) AND DATE(orderDate) <= DATE(?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("totalIncome");
        }
        return 0;
    }
    
    public int getTotalIncome(Timestamp start, Timestamp end, int idEmployee) throws SQLException {
        String query = "SELECT SUM(paidAmount) AS totalIncome FROM `order` WHERE status = ? AND DATE(orderDate) >= DATE(?) AND DATE(orderDate) <= DATE(?) AND idEmployee = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        statement.setInt(4, idEmployee);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("totalIncome");
        }
        return 0;
    }
    
}
