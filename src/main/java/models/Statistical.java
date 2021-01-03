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

    public class ItemProduct {

        public FoodItem item;
        public int quantity, amount;
        public String name;

        public ItemProduct() {

        }

        public Object[] toRowTable() {
            return new Object[]{
                name, quantity};
        }

    }

    public class OrderProduct {

    }

    public class TotalIncome {

        public Employee employee;
        public int totalIncome;
        public Date date;

        @Override
        public String toString() {
            return "TotalIncome{" + "employee=" + employee + ", totalIncome=" + totalIncome + ", date=" + date + '}';
        }
    }

}
