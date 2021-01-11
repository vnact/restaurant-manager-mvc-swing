/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.employee;

/**
 *
 * @author Admin
 */
public class GetDayOfMonth {

    int month, year, day;

    public GetDayOfMonth(int month, int year) {
        this.month = month;
        this.year = year;
        getDays();
    }

    public int getDay() {
        return day;
    }

    public int getDays() {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = 31;
            return day;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = 30;
            return day;
        } else {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                day = 29;
                return day;
            } else {
                day = 28;
                return day;
            }
        }
    }

}
