package main;

import controllers.AdminDashboardController;
import dao.EmployeeDao;
import models.Employee;
import views.AdminDashboardView;

/**
 * createAt Dec 23, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class TestAdmin {

    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        try {
            javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
            System.out.println("Khởi tạo look and feel thành công!");
            Employee e = employeeDao.get(1);
            SessionManager.create(e);
            AdminDashboardView v = new AdminDashboardView();
            AdminDashboardController controller = new AdminDashboardController(v);
            Runtime.getRuntime().addShutdownHook(new ShutdownHook());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
