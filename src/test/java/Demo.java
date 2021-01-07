
import dao.OrderDao;
import dao.StatisticalDao;
import java.sql.Timestamp;
import models.Statistical;

/**
 * createAt Dec 23, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Demo {

    public static void main(String[] args) {
        OrderDao orderDao = new OrderDao();
        StatisticalDao statisticalDao = new StatisticalDao();
        try {
            Timestamp start = new Timestamp(0);
            Timestamp end = new Timestamp(System.currentTimeMillis());
//            for (Date workingDay : statisticalDao.getWorkingDays(2)) {
//                System.out.println(workingDay);
//            }
//            System.out.println(statisticalDao.getTotalEmployee());
//            System.out.println(statisticalDao.getTotalCustomer());
//            System.out.println(statisticalDao.getTotalWorkingMinutes(1));
//            System.out.println(statisticalDao.getTotalIncome(2));
//            System.out.println(statisticalDao.getTotalOrder(2));
            for (Statistical.EmployeeIncome totalIncome : statisticalDao.getListTotalIncomeByDate(start, end)) {
                System.out.println(totalIncome);
            }
//            for (Order order : orderDao.searchByKey(1, "id", "1")) {
//                System.out.println(order);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
