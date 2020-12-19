package main;

import controllers.LoginController;
import models.Employee;
import views.LoginView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Runner {

    private static Employee session;

    public static Employee getSession() {
        if (session == null) {
            createSession();// Tạo phiên đăng nhậsp ảo(test)
        }
        return session;
    }

    public static void createSession() {
        Employee e = new Employee();
        e.setName("Tester");
        e.setId(1);
    }

    public static void setSession(Employee session) {
        Runner.session = session;
    }

    public static void main(String[] args) {
        //Set up look and feel
        try {
            javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
            System.out.println("Khởi tạo look and feel thành công!");
        } catch (Exception ex) {
            System.err.println("Khởi tạo look and feel thất bại!");
        }
        LoginController controller = new LoginController(new LoginView());
    }

}
