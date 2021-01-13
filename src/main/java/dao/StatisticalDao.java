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

    public int getTotalWorkingMinutes(Timestamp start, Timestamp end) throws SQLException {
        String query = "SELECT CEIL(SUM(TIME_TO_SEC(TIMEDIFF(endTime, startTime))) / 60) AS totalWorkingMinutes FROM `session` WHERE message = 'logout' AND DATE(startTime) >= DATE(?) AND DATE(endTime) <= DATE(?)";
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
        String query = "SELECT CEIL(SUM(TIME_TO_SEC(TIMEDIFF(endTime, startTime))) / 60) AS totalWorkingMinutes FROM `session` WHERE message = 'logout' AND DATE(startTime) >= DATE(?) AND DATE(endTime) <= DATE(?) AND idEmployee = ?";
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

    public ArrayList<Statistical.EmployeeIncome> getListTotalIncomeByEmployee(Timestamp start, Timestamp end) throws SQLException {
        ArrayList<Statistical.EmployeeIncome> incomes = new ArrayList<>();
        String query = "SELECT `idEmployee`, SUM(paidAmount) AS totalIncome, COUNT(id) AS totalOrder FROM `order` WHERE status = ? AND DATE(orderDate) >= DATE(?) AND DATE(orderDate) <= DATE(?) GROUP BY `idEmployee`  ORDER BY `totalIncome` DESC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Statistical.EmployeeIncome income = statistical.new EmployeeIncome();
            income.employee = employeeDao.get(rs.getInt("idEmployee"));
            income.totalIncome = rs.getInt("totalIncome");
            income.totalOrder = rs.getInt("totalOrder");
            incomes.add(income);
        }
        return incomes;
    }

    public ArrayList<Statistical.EmployeeIncome> getListTotalIncomeByDate(Timestamp start, Timestamp end) throws SQLException {
        ArrayList<Statistical.EmployeeIncome> incomes = new ArrayList<>();
        String query = "SELECT DATE(orderDate) AS orderDate, COUNT(id) AS totalOrder , SUM(paidAmount) AS totalIncome FROM `order` WHERE status = ? AND DATE(orderDate) >= DATE(?) AND DATE(orderDate) <= DATE(?) GROUP BY orderDate ORDER BY `orderDate` ASC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, OrderStatus.PAID.getId());
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Statistical.EmployeeIncome income = statistical.new EmployeeIncome();
            income.date = rs.getDate("orderDate");
            income.totalIncome = rs.getInt("totalIncome");
            income.totalOrder = rs.getInt("totalOrder");
            incomes.add(income);
        }
        return incomes;
    }

    public ArrayList<Statistical.EmployeeIncome> getListTotalIncomeByDate(Timestamp start, Timestamp end, int idEmployee) throws SQLException {
        ArrayList<Statistical.EmployeeIncome> incomes = new ArrayList<>();
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
            Statistical.EmployeeIncome income = statistical.new EmployeeIncome();
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

    public ArrayList<Statistical.ProductIncome> getQuantityItemByCategory(Timestamp start, Timestamp end, int Catetory) throws SQLException {
        ArrayList<Statistical.ProductIncome> itemProducts = new ArrayList<>();
        String query = "SELECT `name`,SUM(quantity) as sum FROM `order_item`,`food_item`,`order` "
                + "WHERE `idFoodItem`=food_item.id AND idCategory= ? AND `idOrder`= order.id AND DATE(orderDate)>= DATE(?) AND DATE(orderDate)<= DATE(?) "
                + "GROUP BY idFoodItem ORDER by sum DESC";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, Catetory);
        statement.setTimestamp(2, start);
        statement.setTimestamp(3, end);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Statistical.ProductIncome itemProduct = statistical.new ProductIncome();
            itemProduct.name = rs.getString("name");
            itemProduct.quantity = rs.getInt("sum");
            itemProducts.add(itemProduct);
        }
        return itemProducts;
    }

    public ArrayList<Statistical.ProductIncome> getQuantityItem(Timestamp start, Timestamp end) throws SQLException {
        ArrayList<Statistical.ProductIncome> itemProducts = new ArrayList<>();
        String query = "SELECT `idFoodItem`, `name`, SUM(quantity) as sum, (foodPrice*SUM(quantity)) as amount FROM `order_item`,`food_item`,`order` "
                + "WHERE `idFoodItem`=food_item.id AND `idOrder`= order.id AND DATE(orderDate)>= DATE(?) AND DATE(orderDate)<= DATE(?) AND order.status = ?"
                + "GROUP BY idFoodItem ORDER by sum DESC";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setTimestamp(1, start);
        statement.setTimestamp(2, end);
        statement.setNString(3, OrderStatus.PAID.getId());
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Statistical.ProductIncome itemProduct = statistical.new ProductIncome();
            itemProduct.name = rs.getString("name");
            itemProduct.quantity = rs.getInt("sum");
            itemProduct.id = rs.getInt("idFoodItem");
            itemProduct.amount = rs.getInt("amount");
            itemProducts.add(itemProduct);
        }
        return itemProducts;
    }

    public Statistical.WorkingDay getWorkingDays(Date start, Date end, int idEmployee) throws SQLException {
//        ArrayList<Date> workingDays = new ArrayList<>();
        Statistical.WorkingDay workingDays = statistical.new WorkingDay();
        String query = "SELECT DATE(startTime) AS startTime, DATE(endTime) AS endTime FROM `session` WHERE DATE(startTime) >= DATE(?) AND DATE(endTime) <= DATE(?) AND `idEmployee` = ? ORDER BY `session`.`startTime` ASC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setDate(1, start);
        statement.setDate(2, end);
        statement.setInt(3, idEmployee);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Date startTime = rs.getDate("startTime");
            Date endTime = rs.getDate("endTime");
            Date i = startTime;
            while (!i.after(endTime)) {
                workingDays.addWorkDay(i);
                i = new Date(i.getTime() + 24 * 60 * 60 * 1000);//Check ngày sau
            }
        }
        return workingDays;
    }

    public Statistical.WorkingDay getWorkingDays(Timestamp start, Timestamp end, int idEmployee) throws SQLException {
//        ArrayList<Date> workingDays = new ArrayList<>();
        Statistical.WorkingDay workingDays = statistical.new WorkingDay();
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
                workingDays.addWorkDay(i);
                i = new Date(i.getTime() + 24 * 60 * 60 * 1000);//Check ngày sau
            }
        }
        return workingDays;
    }

    public ArrayList<Statistical.SalaryEmployee> getSalaryEmployee(Timestamp start, Timestamp end) throws SQLException {
        ArrayList<Statistical.SalaryEmployee> list = new ArrayList<>();
        String query = "SELECT `idEmployee`, COUNT(id) as quantity, (COUNT(id) * 2000) as bonus FROM `order` GROUP BY `idEmployee` ";
        PreparedStatement statement = conn.prepareStatement(query);
//        statement.setTimestamp(2, end);
//        statement.setTimestamp(1, start);
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Statistical.SalaryEmployee salaryEmployee = statistical.new SalaryEmployee();
            salaryEmployee.employee = employeeDao.get(rs.getInt("idEmployee"));
            salaryEmployee.quantily = rs.getInt("quantity");
            salaryEmployee.bonus = rs.getInt("bonus");
            list.add(salaryEmployee);
        }
        return list;
    }

}
