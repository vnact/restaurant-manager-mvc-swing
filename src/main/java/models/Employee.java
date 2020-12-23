package models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.EmployeePermission;

/**
 * @createAt Nov 24, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class Employee extends Model {

    protected int id;
    protected String username, password, name, phoneNumber, permissionName;
    protected int permissionId;
    protected EmployeePermission permission;
    protected Date startDate;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public EmployeePermission getPermission() {
        return permission;
    }

    public void setPermission(EmployeePermission permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public static Employee getFromResultSet(ResultSet rs) throws SQLException {
        Employee e = new Employee();
        e.setId(rs.getInt("id"));
        e.setUsername(rs.getNString("username"));
        e.setPassword(rs.getNString("password"));
        e.setName(rs.getNString("name"));
        e.setPhoneNumber(rs.getNString("phoneNumber"));
        e.setStartDate(rs.getDate("startDate"));
        e.setPermission(EmployeePermission.getById(rs.getNString("permission")));
        return e;
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
            id, name, username, password,
            phoneNumber, startDate, permission.getName()
        };
    }

}
