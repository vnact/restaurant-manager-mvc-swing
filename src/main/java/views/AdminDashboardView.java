package views;

import controllers.AdminDashboardController;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.ErrorPopup;
import views.admin.MenuItem;

/**
 * @createAt Nov 15, 2020
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public class AdminDashboardView extends javax.swing.JFrame {

    JPanel[] cards;
    ArrayList<MenuItem> menuItems = new ArrayList<>();

    public AdminDashboardView() {
        initComponents();
        setLocationRelativeTo(null);
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

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public JLabel getLbName() {
        return lbName;
    }

    // Thêm dropdown menu
    public void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            MenuItem item = menu[i];
            menuItems.add(item);
            panelSideBar.add(item);
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

    public void setCards(JPanel[] cards) {
        this.cards = cards;
        initLayout();
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

    public JPanel getPanelSideBar() {
        return panelSideBar;
    }

    public void setPanel(JPanel panel) {
        for (JPanel card : cards) {
            card.setVisible(false);
        }
        panel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelLeft = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        panelSideBar = new javax.swing.JPanel();
        panelLayout = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang quản lý");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        panelLeft.setPreferredSize(new java.awt.Dimension(200, 680));
        panelLeft.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(255, 127, 80));
        panelHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        panelHeader.setPreferredSize(new java.awt.Dimension(200, 50));
        panelHeader.setLayout(new java.awt.GridBagLayout());

        lbName.setText("Trần Đức Cường");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        panelHeader.add(lbName, gridBagConstraints);

        btnLogout.setText("Thoát");
        btnLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogout.setFocusable(false);
        btnLogout.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        panelHeader.add(btnLogout, gridBagConstraints);

        panelLeft.add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelSideBar.setBackground(new java.awt.Color(142, 68, 173));
        panelSideBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));
        panelLeft.add(panelSideBar, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JPanel panelSideBar;
    // End of variables declaration//GEN-END:variables
}
