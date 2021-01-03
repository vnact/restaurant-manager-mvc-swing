package models;

import java.sql.Date;

/**
 * createAt Jan 2, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Statistical {

    public class WorkingMinus {

        public Employee employee;
        public Date date;
        public int minus;

        public WorkingMinus(Employee employee, Date date, int minus) {
            this.employee = employee;
            this.date = date;
            this.minus = minus;
        }

        public int getDateOfMonth() {
            return date.getDate();
        }

    }

    public class ProductIncome {

        public FoodItem item;
        public int quantity, amount, id;
        public String name;
    }

    public class EmployeeIncome {

        public Employee employee;
        public int totalIncome, totalOrder;
        public Date date;

        @Override
        public String toString() {
            return "TotalIncome{" + "employee=" + employee + ", totalIncome=" + totalIncome + ", totalOrder=" + totalOrder + ", date=" + date + '}';
        }

    }

}
