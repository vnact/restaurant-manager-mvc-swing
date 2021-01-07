
import controllers.popup.SelectCustomerPopupController;
import views.popup.SelectCustomerPopupView;

/**
 * createAt Dec 31, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class Demo3 {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SelectCustomerPopupView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SelectCustomerPopupController selectCustomerPopupController = new SelectCustomerPopupController();
        selectCustomerPopupController.select(new SelectCustomerPopupView(), (customer) -> System.out.println(customer));
    }

}
