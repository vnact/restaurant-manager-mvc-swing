package views;

import controllers.AdminDashboardController;
import controllers.LoginController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.Employee;
import utils.ErrorPopup;
import views.admin.EmployeeManagerPane;
import views.admin.HomePane;
import views.admin.ManagerPane;
import views.admin.MenuItem;
import views.admin.TableManagerPane;

/**
 * @createAt Nov 15, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class AdminDashboardView extends javax.swing.JFrame {

    HomePane homePane = new HomePane();
    ManagerPane employeeManagerPane = new EmployeeManagerPane(), tableManagerPane = new TableManagerPane();
    JPanel[] cards = {homePane, employeeManagerPane, tableManagerPane};
    ArrayList<MenuItem> menuItems = new ArrayList<>();

    public AdminDashboardView() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public AdminDashboardView(Employee e) {
        initComponents();
        setLocationRelativeTo(null);
        lbName.setText(e.getName());
    }

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception e) {
        ErrorPopup.show(e);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Thêm dropdown menu
    public void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            MenuItem item = menu[i];
            menuItems.add(item);
            panelMenu.add(item);
            ArrayList<MenuItem> subMenus = item.getSubMenu();
            for (MenuItem subMenu : subMenus) {
                addMenu(subMenu);
                subMenu.setVisible(false);
            }
        }
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    // Thêm các pane vào cardlayout
    public void initLayout() {
        panelLayout.removeAll();
        for (int i = 0; i < cards.length; i++) {
            panelLayout.add(cards[i]);
        }
        panelLayout.updateUI();
    }

    public JPanel getPanelLayout() {
        return panelLayout;
    }

    public JPanel[] getCards() {
        return cards;
    }

    public HomePane getHomePane() {
        return homePane;
    }

    public ManagerPane getEmployeeManagerPane() {
        return employeeManagerPane;
    }

    public ManagerPane getTableManagerPane() {
        return tableManagerPane;
    }

    public void setPanel(JPanel panel) {
        for (JPanel card : getCards()) {
            card.setVisible(false);
        }
        panel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLeft = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        panelLayout = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang quản lý");
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panelLeft.setPreferredSize(new java.awt.Dimension(200, 680));
        panelLeft.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(255, 255, 255));
        panelHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        panelHeader.setPreferredSize(new java.awt.Dimension(200, 50));

        lbName.setText("Trần Đức Cường");

        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbName)
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(btnLogout))
                .addGap(11, 11, 11))
        );

        panelLeft.add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenu.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        panelLeft.add(panelMenu, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelLayout.setMaximumSize(new java.awt.Dimension(1000, 680));
        panelLayout.setMinimumSize(new java.awt.Dimension(1000, 680));
        panelLayout.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        panelLayout.add(jPanel1, "card2");

        getContentPane().add(panelLayout, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        new LoginController(new LoginView());
    }//GEN-LAST:event_btnLogoutActionPerformed

    public static void main(String[] args) {
        //Set up look and feel
        try {
            javax.swing.UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
            System.out.println("Khởi tạo look and feel thành công!");
        } catch (Exception ex) {
            System.err.println("Khởi tạo look and feel thất bại!");
        }
        AdminDashboardView v = new AdminDashboardView();
        AdminDashboardController controller = new AdminDashboardController(v);
        v.setPanel(v.getHomePane());
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbName;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelLayout;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
