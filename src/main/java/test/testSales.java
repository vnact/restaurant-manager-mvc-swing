/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.WorkDayDao;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import models.WorkDay;

/**
 *
 * @author Admin
 */
public class testSales {

    static ArrayList<Integer> i;

    public static void main(String[] args) {
        try {

            WorkDayDao wdd = new WorkDayDao();
//            SimpleDateFormat dateFormat = new SimpleDateFormat( 
//            "yyyy-MM-dd hh:mm:ss:SSS"); 
//            Date date1=dateFormat.parse("2020-12-30 10:00:00:000"); 
//Timestamp dateTimeStamp=new Timestamp(date1.getTime()); 

            WorkDay workDay = wdd.getSales(2, Timestamp.valueOf("2020-12-30 10:01:00.000"));
            //int time = wdd.getTotalWorkingMinutes("'2020-12-30", 2);

            System.out.println(workDay.getAmount());
            System.out.println(workDay.getDay());
            System.out.println(workDay.getTotalAmount());
            // System.out.println(time);

            //System.out.println(rs.getInt("day"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
