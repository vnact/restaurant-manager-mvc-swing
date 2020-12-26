package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * createAt Dec 23, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Session {

    private int id, idEmployee;
    private Timestamp startTime, endTime;
    private Employee employee;
    private String message;

    public Session() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        if (employee != null) {
            this.idEmployee = employee.getId();
        }
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Session getFromResultSet(ResultSet rs) throws SQLException {
        Session s = new Session();
        s.setId(rs.getInt("id"));
        s.setIdEmployee(rs.getInt("idEmployee"));
        s.setMessage(rs.getNString("message"));
        s.setStartTime(rs.getTimestamp("startTime"));
        s.setEndTime(rs.getTimestamp("endTime"));
        return s;
    }

    @Override
    public String toString() {
        return "Session{" + "id=" + id + ", idEmployee=" + idEmployee + ", startTime=" + startTime + ", endTime=" + endTime + ", message=" + message + '}';
    }

}
