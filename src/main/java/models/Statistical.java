package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

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

    public class SalaryEmployee {

        public Employee employee;
        public int quantily, bonus;
        public int total;

        public int getTotal() {
            return employee.getSalary() + bonus;
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

        public boolean equalDate(Date date) {
            if (date.getYear() != this.date.getYear()) {
                return false;
            }
            if (date.getMonth() != this.date.getMonth()) {
                return false;
            }
            if (date.getDate() != this.date.getDate()) {
                return false;
            }
            return true;
        }

    }

    public class WorkingDay {

        private ArrayList<Calendar> dates = new ArrayList<>();

        public void addWorkDay(Date date) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            valid(cal);
            cal.set(Calendar.MILLISECOND, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            if (!dates.contains(cal)) {
                dates.add(cal);
            }
        }

        public boolean isWorking(Calendar cal) {
            if (cal == null) {
                return false;
            }
            valid(cal);
            for (Calendar date : dates) {
                if (date.getTime().equals(cal.getTime())) {
                    return true;
                }
            }
            return false;
        }

        private void valid(Calendar cal) {
            cal.set(Calendar.MILLISECOND, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.HOUR_OF_DAY, 0);
        }

        public void print() {
            for (Calendar date : dates) {
                System.out.println(date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR));
            }
        }

        public int count() {
            return dates.size();
        }

    }
}
