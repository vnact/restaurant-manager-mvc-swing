package main;

/**
 * createAt Dec 26, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class ShutdownHook extends Thread {

    @Override
    public void run() {
        //Khi đóng đột ngột
        System.out.println("Chuong trinh dung dot ngot!");
        try {
            if (SessionManager.getSession() != null) {
                System.out.println("Ket thuc phien lam viec!");
                SessionManager.update();// Kết thúc phiên làm việc
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}