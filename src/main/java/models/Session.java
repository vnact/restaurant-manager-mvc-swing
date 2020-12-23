package models;

import java.sql.Timestamp;

/**
 * createAt Dec 23, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Session {

    private Timestamp startDate, endDate;
    private Employee employee;

    public Session() {
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
