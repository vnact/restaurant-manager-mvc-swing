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
        String query = "SELECT * FROM `shipment`";
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
            throw new SQLException("Customer rỗng");
        }
        String query = "INSERT INTO `shipment` (`idOrder`, `idCustomer`, `shipperName`, `shipperPhoneNumber`, `shipCost`, `status`, `notice`, `startDate`, `endDate`) VALUES (?, ?, ?, ?, ?, ?, ?, current_timestamp(), ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdOrder());
        stmt.setInt(2, t.getIdCustomer());
        stmt.setNString(3, t.getShipperName());
        stmt.setNString(4, t.getShipperPhoneNumber());
        stmt.setInt(5, t.getShipCost());
        stmt.setNString(6, t.getStatus().getId());
        stmt.setNString(7, t.getNotice());
        stmt.setTimestamp(8, t.getStartDate());
        stmt.setTimestamp(9, t.getEndDate());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(Shipment t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Shipment t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Shipment> searchByKey(String key, String word) throws SQLException {
        ArrayList<Shipment> shipments = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM Table WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            //  Shipment shipment= Shipment.getFromResultSet(rs);
            // shipments.add(shipment);
        }
        return shipments;
    }

}
