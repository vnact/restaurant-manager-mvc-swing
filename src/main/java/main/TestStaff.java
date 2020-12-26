package main;

import controllers.EmployeeDashboardController;
import dao.EmployeeDao;
import models.Employee;
import views.EmployeeDashboardView;
import views.admin.HomeView;

/**
 * createAt Dec 23, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class TestStaff {
    
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        try {
            javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
            System.out.println("Khởi tạo look and feel thành công!");
            Employee e = employeeDao.get(2);
            SessionManager.create(e);
            EmployeeDashboardController controller1 = new EmployeeDashboardController(new EmployeeDashboardView());
            controller1.getView().setPanel(new HomeView());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
