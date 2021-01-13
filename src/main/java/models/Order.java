package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import utils.OrderStatus;
import utils.OrderType;

/**
 *
 * @author MSI
 */
public class Order extends Model {

    private int id, idEmployee, idTable;
    private OrderType type;
    private OrderStatus status;
    private Timestamp orderDate, payDate;
    private int paidAmount, totalAmount, discount;
    private Employee employee;
    private Table table;

    public Order() {
        status = OrderStatus.UNPAID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        this.idEmployee = employee.getId();
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
        this.idTable = table.getId();
    }

    public int getFinalAmount() {
        return totalAmount - (int) totalAmount * discount / 100;
    }

    public static Order getFromResultSet(ResultSet rs) throws SQLException {
        Order o = new Order();
        o.setId(rs.getInt("id"));
        o.setIdEmployee(rs.getInt("idEmployee"));
        o.setIdTable(rs.getInt("idTable"));
        o.setType(OrderType.getById(rs.getNString("type")));
        o.setStatus(OrderStatus.getById(rs.getNString("status")));
        o.setOrderDate(rs.getTimestamp("orderDate"));
        o.setPayDate(rs.getTimestamp("payDate"));
        o.setPaidAmount(rs.getInt("paidAmount"));
        o.setTotalAmount(rs.getInt("totalAmount"));
        o.setDiscount(rs.getInt("discount"));
        return o;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", idEmployee=" + idEmployee + ", idTable=" + idTable + ", type=" + type + ", status=" + status + ", orderDate=" + orderDate + ", payDate=" + payDate + ", paidAmount=" + paidAmount + ", totalAmount=" + totalAmount + '}';
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
            this.getId(), this.getEmployee().getName(), this.getTable().getName(),
            this.getType().getName(), this.getStatus().getName(), this.getOrderDate(), this.getPayDate(),
            String.format("%d/%d", this.getPaidAmount(), this.getFinalAmount())
        };
    }

}
