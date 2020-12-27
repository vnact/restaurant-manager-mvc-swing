/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.OrderDao;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class testSales {

    public static void main(String[] args) {
        try {

            OrderDao order = new OrderDao();
            ResultSet rs = order.getSales(1, "'2020-11-24'");
            System.out.println(rs.getInt(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
