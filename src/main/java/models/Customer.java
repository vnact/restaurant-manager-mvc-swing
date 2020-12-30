package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @createAt Nov 24, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class Customer extends Model {

    protected int id;
    protected String phoneNumber, name, address;
    protected Timestamp birthday;

    public Customer() {
        birthday = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + "\nSDT: " + phoneNumber + "\nĐC: " + address;
    }

    public static Customer getFromResultSet(ResultSet rs) throws SQLException {
        Customer c = new Customer();
        c.setId(rs.getInt("id"));
        c.setName(rs.getNString("name"));
        c.setAddress(rs.getNString("address"));
        c.setPhoneNumber(rs.getString("phoneNumber"));
        c.setBirthday(rs.getTimestamp("birthday"));
        return c;
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
            this.getId(), this.getName(), this.getPhoneNumber(), this.getAddress(), this.getBirthday()
        };
    }

}
