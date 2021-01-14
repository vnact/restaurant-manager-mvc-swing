package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Shipment;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class ShipmentDao extends Dao<Shipment> {

    CustomerDao customerDao = new CustomerDao();
    OrderDao orderDao = new OrderDao();

    @Override
    public ArrayList<Shipment> getAll() throws SQLException {
        ArrayList<Shipment> shipments = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `shipment`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Shipment shipment = Shipment.getFromResultSet(rs);
            shipment.setCustomer(customerDao.get(shipment.getIdCustomer()));
            shipment.setOrder(orderDao.get(shipment.getIdOrder()));
            shipments.add(shipment);
        }
        return shipments;
    }

    @Override
    public Shipment get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `shipment` WHERE `idOrder` = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Shipment shipment = Shipment.getFromResultSet(rs);
            shipment.setCustomer(customerDao.get(shipment.getIdCustomer()));
            shipment.setOrder(orderDao.get(shipment.getIdOrder()));
            return shipment;
        }
        return null;
    }

    @Override
    public void save(Shipment t) throws SQLException {
        if (t == null) {
            throw new SQLException("Shipment rỗng");
        }
        String query = "INSERT INTO `shipment` (`idOrder`, `idCustomer`, `shipperName`, `shipperPhoneNumber`, `shipCost`, `status`, `notice`, `startDate`) VALUES (?, ?, ?, ?, ?, ?, ?, current_timestamp())";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdOrder());
        stmt.setInt(2, t.getIdCustomer());
        stmt.setNString(3, t.getShipperName());
        stmt.setNString(4, t.getShipperPhoneNumber());
        stmt.setInt(5, t.getShipCost());
        stmt.setNString(6, t.getStatus().getId());
        stmt.setNString(7, t.getNotice());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(Shipment t) throws SQLException {
        if (t == null) {
            throw new SQLException("Shipment rỗng");
        }
        String query = "UPDATE `shipment` SET `idCustomer` = ?, `shipperName` = ?, `shipperPhoneNumber` = ?, `shipCost` = ?, `status` = ?, `notice` = ?, `startDate` = ?, `endDate` = ? WHERE `shipment`.`idOrder` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdCustomer());
        stmt.setNString(2, t.getShipperName());
        stmt.setNString(3, t.getShipperPhoneNumber());
        stmt.setInt(4, t.getShipCost());
        stmt.setNString(5, t.getStatus().getId());
        stmt.setNString(6, t.getNotice());
        stmt.setTimestamp(7, t.getStartDate());
        stmt.setTimestamp(8, t.getEndDate());
        stmt.setInt(9, t.getIdOrder());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(Shipment t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `shipment` WHERE `shipment`.`idOrder` = ?");
        stmt.setInt(1, t.getIdOrder());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `shipment` WHERE `shipment`.`idOrder` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void deleteByIdCustomer(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `shipment` WHERE `shipment`.`idCustomer` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ArrayList<Shipment> searchByKey(String key, String word) throws SQLException {
        ArrayList<Shipment> shipments = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `shipment` WHERE " + key + " LIKE '%" + word + "%'";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Shipment shipment = Shipment.getFromResultSet(rs);
            shipments.add(shipment);
        }
        return shipments;
    }

}
