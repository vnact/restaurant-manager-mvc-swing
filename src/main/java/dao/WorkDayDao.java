/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.WorkDay;

/**
 *
 * @author Admin
 */
public class WorkDayDao  {
    Connection conn = Database.getInstance().getConnection();
    public ArrayList<WorkDay> getDay(int id,String month,String year) throws SQLException {
        ArrayList<WorkDay> workDays = new ArrayList<>();
        Statement statement  = conn.createStatement();
        String query = "SELECT DAY.(DATE(startTime)) as day "
                + "FROM `session` "
                + "WHERE `id` = "+id+"and "
                + "YEAR.(DATE((startTime)) = "+ year + "and "
                + "MONTH.(DATE(startTime)) = "+month +""
                + "ORDER BY day ASC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            WorkDay workDay = WorkDay.getFromResultSet(rs);
            workDays.add(workDay);
        }
        return workDays;
    }


    public WorkDay get(int id,String date) throws SQLException {
        Statement statement = conn.createStatement();
        return null;
    }

    
    
}
