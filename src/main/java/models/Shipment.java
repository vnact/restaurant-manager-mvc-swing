package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import utils.ShipmentStatus;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Shipment extends Model {

    private int idOrder, idCustomer;
    private String shipperName, shipperPhoneNumber, notice;
    private int shipCost;
    private ShipmentStatus status;
    private Timestamp startDate, endDate;
    private Order order;
    private Customer customer;

    public Shipment() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperPhoneNumber() {
        return shipperPhoneNumber;
    }

    public void setShipperPhoneNumber(String shipperPhoneNumber) {
        this.shipperPhoneNumber = shipperPhoneNumber;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        if (order != null) {
            this.idOrder = order.getId();
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (customer != null) {
            this.idCustomer = customer.getId();
        }
    }

    public int getShipCost() {
        return shipCost;
    }

    public void setShipCost(int shipCost) {
        this.shipCost = shipCost;
    }

    public static Shipment getFromResultSet(ResultSet rs) throws SQLException {
        Shipment shipment = new Shipment();
        shipment.setIdOrder(rs.getInt("idOrder"));
        shipment.setIdCustomer(rs.getInt("idCustomer"));
        shipment.setShipperName(rs.getNString("shipperName"));
        shipment.setShipperPhoneNumber(rs.getNString("shipperPhoneNumber"));
        shipment.setShipCost(rs.getInt("shipCost"));
        shipment.setStatus(ShipmentStatus.getById(rs.getNString("status")));
        shipment.setNotice(rs.getNString("notice"));
        shipment.setStartDate(rs.getTimestamp("startDate"));
        shipment.setEndDate(rs.getTimestamp("endDate"));
//        shipment.setIdOrder(rs.getInt("idOrder"));
        return shipment;
    }

    @Override
    public String toString() {
        return "Shipment{" + "idOrder=" + idOrder + ", idCustomer=" + idCustomer + ", shipperName=" + shipperName + ", shipperPhoneNumber=" + shipperPhoneNumber + ", notice=" + notice + ", shipCost=" + shipCost + ", status=" + status + ", startDate=" + startDate + ", endDate=" + endDate + ", order=" + order + ", customer=" + customer + '}';
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
            idOrder, customer.getName(), customer.getAddress(), shipperName,
            shipperPhoneNumber, shipCost, status.getName(), startDate, endDate
        };
    }

}
