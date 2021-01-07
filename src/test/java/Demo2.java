
import dao.ShipmentDao;
import models.Shipment;

/**
 * createAt Dec 24, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Demo2 {
    
    public static void main(String[] args) {
        ShipmentDao shipmentDao = new ShipmentDao();
        try {
            for (Shipment ss : shipmentDao.getAll()) {
                System.out.println(ss);
                ss.setIdOrder(11);
                shipmentDao.save(ss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
