///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package models;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//
///**
// *
// * @author Admin
// */
//public class WorkDay {
//    private int id,day,orderSales,sales,bonus;
//    private Timestamp beginTime,finishTime;
//
//    public WorkDay() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getDay() {
//        return day;
//    }
//
//    public void setDay(int day) {
//        this.day = day;
//    }
//
//    public int getOrderSales() {
//        return orderSales;
//    }
//
//    public void setOrderSales(int orderSales) {
//        this.orderSales = orderSales;
//    }
//
//    public int getSales() {
//        return sales;
//    }
//
//    public void setSales(int sales) {
//        this.sales = sales;
//    }
//
//    public int getBonus() {
//        return bonus;
//    }
//
//    public void setBonus(int bonus) {
//        this.bonus = bonus;
//    }
//
//    public Timestamp getBeginTime() {
//        return beginTime;
//    }
//
//    public void setBeginTime(Timestamp beginTime) {
//        this.beginTime = beginTime;
//    }
//
//    public Timestamp getFinishTime() {
//        return finishTime;
//    }
//
//    public void setFinishTime(Timestamp finishTime) {
//        this.finishTime = finishTime;
//    }
//    public static WorkDay getFromResultSet(ResultSet rs) throws SQLException {
//        FoodItem f = new FoodItem();
//        f.setId(rs.getInt("id"));
//        f.setName(rs.getNString("name"));
//        f.setDescription(rs.getNString("description"));
//        f.setUrlImage(rs.getNString("urlImage"));
//        f.setUnitName(rs.getNString("unitName"));
//        f.setUnitPrice(rs.getInt("unitPrice"));
//        f.setIdCategory(rs.getInt("idCategory"));
//        return f;
//    }
//}
