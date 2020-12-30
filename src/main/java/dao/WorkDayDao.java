/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import models.WorkDay;

/**
 *
 * @author Admin
 */
public class WorkDayDao {

    Connection conn = Database.getInstance().getConnection();
//    public ArrayList<WorkDay> getDay(int id,String month,String year) throws SQLException {
//        ArrayList<WorkDay> workDays = new ArrayList<>();
//        Statement statement  = conn.createStatement();
//        String query = "SELECT DAY.(DATE(startTime)) as day "
//                + "FROM `session` "
//                + "WHERE `id` = "+id+"and "
//                + "YEAR.(DATE((startTime)) = "+ year + "and "
//                + "MONTH.(DATE(startTime)) = "+month +""
//                + "ORDER BY day ASC";
//        ResultSet rs = statement.executeQuery(query);
//        while (rs.next()) {
//            WorkDay workDay = WorkDay.getFromResultSet(rs);
//            workDays.add(workDay);
//        }
//        return workDays;
//    }
//
//
//    public WorkDay get(int id,String date) throws SQLException {
//        Statement statement = conn.createStatement();
//        return null;
//    }

    public ArrayList<Integer> getDay(int id, int month, int year) throws SQLException {
        String query = "SELECT  DISTINCT DAY(startTime) as day FROM `session` WHERE `idEmployee` = ? AND YEAR(startTime) = ? and MONTH(startTime) = ? ORDER BY day ASC";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        statement.setInt(2, year);
        statement.setInt(3, month);
        ResultSet rs = statement.executeQuery();
        ArrayList<Integer> list = new ArrayList();
        while (rs.next()) {
            list.add(rs.getInt("day"));
        }
        return list;
    }

    public WorkDay getSales(int id, Timestamp date) throws SQLException {
        System.out.println(id);
        System.out.println(date);
        String query = "SELECT DATE(orderDate) as day,COUNT(id) AS amount, SUM(totalAmount)as total,(COUNT(id)*2000) as bonus FROM `order` WHERE idEmployee = ? AND DATE(orderDate) = DATE(?)";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        statement.setTimestamp(2, date);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString("day"));
            WorkDay workDay = WorkDay.getFromResultSet(rs);
            return workDay;
        }

        return null;
    }

    public int getTotalWorkingMinutes(Timestamp date, int idEmployee) throws SQLException {
        String query = "SELECT FLOOR(SUM(TIME_TO_SEC(TIMEDIFF(endTime, startTime))) / 60) AS totalWorkingMinutes FROM `session` WHERE DATE(startTime) = DATE(?) AND idEmployee = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setTimestamp(1, date);
        statement.setInt(2, idEmployee);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("totalWorkingMinutes");
        }
        return 0;
    }

}
