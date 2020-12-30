/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class WorkDay {

    private int amount, totalAmount, bonus;
    private String day;

    public WorkDay() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public static WorkDay getFromResultSet(ResultSet rs) throws SQLException {
        WorkDay w = new WorkDay();
        //w.setId(rs.getInt("id"));
        w.setBonus(rs.getInt("bonus"));
        w.setDay(rs.getString("day"));
        w.setTotalAmount(rs.getInt("total"));
        w.setAmount(rs.getInt("amount"));
        return w;
    }

}
