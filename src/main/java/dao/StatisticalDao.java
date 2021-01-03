package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import models.Employee;
import models.Statistical;
import utils.OrderStatus;

/**
 * createAt Dec 28, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class StatisticalDao {

    Connection conn = Database.getInstance().getConnection();
    EmployeeDao employeeDao = new EmployeeDao();
    Statistical statistical = new Statistical();

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

    public ArrayList<Statistical.TotalIncome> getListTotalIncomeByEmployee(Timestamp start, Timestamp end) throws SQLException {
        ArrayList<Statistical.TotalIncome> incomes = new ArrayList<>();
        String query = "SELECT `idEmployee`, SUM(paidAmount) AS totalIncome, COUNT(id) AS totalOrder FROM `order` WHERE status = ? AND DATE(orderDate) >= DATE(?) AND DATE(orderDate) <= DATE(?) GROUP BY `idEmployee`  ORDER BY `totalIncome` DESC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Statistical.TotalIncome income = statistical.new TotalIncome();
            income.employee = employeeDao.get(rs.getInt("idEmployee"));
            income.totalIncome = rs.getInt("totalIncome");
            income.totalOrder = rs.getInt("totalOrder");
            incomes.add(income);
        }
        return incomes;
    }

    public ArrayList<Statistical.TotalIncome> getListTotalIncomeByDate(Timestamp start, Timestamp end) throws SQLException {
        ArrayList<Statistical.TotalIncome> incomes = new ArrayList<>();
        String query = "SELECT DATE(orderDate) AS orderDate, SUM(paidAmount) AS totalIncome FROM `order` WHERE status = ? AND DATE(orderDate) >= DATE(?) AND DATE(orderDate) <= DATE(?) GROUP BY orderDate ORDER BY `orderDate` ASC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Statistical.TotalIncome income = statistical.new TotalIncome();
            income.date = rs.getDate("orderDate");
            income.totalIncome = rs.getInt("totalIncome");
            incomes.add(income);
        }
        return incomes;
    }

    public ArrayList<Statistical.TotalIncome> getListTotalIncomeByDate(Timestamp start, Timestamp end, int idEmployee) throws SQLException {
        ArrayList<Statistical.TotalIncome> incomes = new ArrayList<>();
        String query = "SELECT DATE(orderDate) AS orderDate, SUM(paidAmount) AS totalIncome "
                + "FROM `order` WHERE status = ? AND DATE(orderDate) >= DATE(?) AND DATE(orderDate) <= DATE(?) AND idEmployee = ? "
                + "GROUP BY orderDate ORDER BY `orderDate` ASC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        statement.setInt(4, idEmployee);
        ResultSet rs = statement.executeQuery();
        Employee e = employeeDao.get(idEmployee);
        while (rs.next()) {
            Statistical.TotalIncome income = statistical.new TotalIncome();
            income.date = rs.getDate("orderDate");
            income.totalIncome = rs.getInt("totalIncome");
            income.employee = e;
        }
        return incomes;
    }

    public int getTotalEmployee() throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT COUNT(*) AS total FROM employee";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            return rs.getInt("total");
        }
        return 0;
    }

    public int getTotalCustomer() throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT COUNT(*) AS total FROM customer";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            return rs.getInt("total");
        }
        return 0;
    }

    public ArrayList<Date> getWorkingDays() throws SQLException {
        Timestamp current = new Timestamp(System.currentTimeMillis());
//        return getWorkingDays(new Timestamp(current.getTime() - 31 * 24 * 60 * 60 * 1000), current);
        return getWorkingDays(new Timestamp(0), current);
    }

    public ArrayList<Date> getWorkingDays(int idEmployee) throws SQLException {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        return getWorkingDays(new Timestamp(0), current, idEmployee);
    }

    public ArrayList<Date> getWorkingDays(Timestamp start, Timestamp end) throws SQLException {
        ArrayList<Date> workingDays = new ArrayList<>();
        String query = "SELECT DATE(startTime) AS startTime, DATE(endTime) AS endTime FROM `session` WHERE DATE(startTime) >= DATE(?) AND DATE(endTime) <= DATE(?) ORDER BY `startTime` ASC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setTimestamp(1, start);
        statement.setTimestamp(2, end);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Date startTime = rs.getDate("startTime");
            Date endTime = rs.getDate("endTime");
            Date i = startTime;
            while (!i.after(endTime)) {
                if (!workingDays.contains(i)) {
                    workingDays.add(i);
                }
                i = new Date(i.getTime() + 24 * 60 * 60 * 1000);//Check ngày sau
            }
        }
        return workingDays;
    }

    public ArrayList<Date> getWorkingDays(Timestamp start, Timestamp end, int idEmployee) throws SQLException {
        ArrayList<Date> workingDays = new ArrayList<>();
        String query = "SELECT DATE(startTime) AS startTime, DATE(endTime) AS endTime FROM `session` WHERE DATE(startTime) >= DATE(?) AND DATE(endTime) <= DATE(?) AND `idEmployee` = ? ORDER BY `session`.`startTime` ASC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setTimestamp(1, start);
        statement.setTimestamp(2, end);
        statement.setInt(3, idEmployee);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Date startTime = rs.getDate("startTime");
            Date endTime = rs.getDate("endTime");
            Date i = startTime;
            while (!i.after(endTime)) {
                if (!workingDays.contains(i)) {
                    workingDays.add(i);
                }
                i = new Date(i.getTime() + 24 * 60 * 60 * 1000);//Check ngày sau
            }
        }
        return workingDays;
    }

    public ArrayList<Statistical.ItemProduct> getQuantityItem(Timestamp start, Timestamp end, int Catetory) throws SQLException {
        ArrayList<Statistical.ItemProduct> itemProducts = new ArrayList<>();
        System.out.println(start);
        System.out.println(end);
        System.out.println(Catetory);
        String query = "SELECT `name`,SUM(quantity) as sum FROM `order_item`,`food_item`,`order` "
                + "WHERE `idFoodItem`=food_item.id AND idCategory= ? AND `idOrder`= order.id AND DATE(orderDate)>= DATE(?) AND DATE(orderDate)<= DATE(?) "
                + "GROUP BY idFoodItem ORDER by sum DESC";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, Catetory);
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        // System.out.println("okay");
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            Statistical.ItemProduct itemProduct = statistical.new ItemProduct();
            itemProduct.name = rs.getString("name");
            itemProduct.quantity = rs.getInt("sum");
            itemProducts.add(itemProduct);
        }
        return itemProducts;
    }
}
