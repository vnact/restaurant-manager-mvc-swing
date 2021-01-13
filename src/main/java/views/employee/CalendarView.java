/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.employee;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import utils.ErrorPopup;

/**
 *
 * @author Admin
 */
public class CalendarView extends javax.swing.JPanel {

    /**
     * Creates new form CalendarView
     */
//    int month;//= LocalDate.now().getMonthValue();
//    int year;// = LocalDate.now().getYear();
    public CalendarView() {
        initComponents();
        setSize(738, 578);
        //setLocationRelativeTo(null);
//        cbxMonth.setSelectedIndex(LocalDate.now().getMonthValue() - 1);
//        txtYear.setText(String.valueOf(LocalDate.now().getYear()));
//        render(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
    }

    public JLabel getLbTotalBonus() {
        return lbTotalCustomer1;
    }

    public JLabel getLbTotalDay() {
        return lbTotalCustomer;
    }

    public JLabel getLbTotalIncome() {
        return lbTotalIncome;
    }

    public JLabel getLbTotalOrder() {
        return lbTotalOrder;
    }

    public JLabel getLbTotalTime() {
        return lbTotalTime;
    }

    public JButton getBtnEnter() {
        return btnEnter;
    }

    public JComboBox<String> getCbxMonth() {
        return cbxMonth;
    }

    public JPanel getPanelCalendar() {
        return panelCalendar;
    }

    public JTextField getTxtYear() {
        return txtYear;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbTotalOrder = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbTotalIncome = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lbTotalTime = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lbTotalCustomer = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lbTotalCustomer1 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        panelCalendar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnEnter = new javax.swing.JButton();
        txtYear = new javax.swing.JTextField();
        cbxMonth = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(738, 578));
        setPreferredSize(new java.awt.Dimension(725, 578));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(209, 242, 235));
        jPanel2.setMaximumSize(new java.awt.Dimension(470, 32));
        jPanel2.setMinimumSize(new java.awt.Dimension(470, 32));
        jPanel2.setPreferredSize(new java.awt.Dimension(470, 32));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lịch công");
        jLabel1.setAlignmentY(0.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(jLabel1, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);
        jPanel4.setMinimumSize(new java.awt.Dimension(255, 500));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 500));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel5.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(0, 192, 239));
        jPanel8.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bill_50px.png"))); // NOI18N
        jLabel9.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel5.add(jPanel8, java.awt.BorderLayout.LINE_START);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Số hóa đơn ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel9.add(jLabel10, gridBagConstraints);

        lbTotalOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalOrder.setText("14");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel9.add(lbTotalOrder, gridBagConstraints);

        jPanel5.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(221, 75, 57));
        jPanel10.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/money_50px.png"))); // NOI18N
        jLabel11.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel6.add(jPanel10, java.awt.BorderLayout.LINE_START);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tổng tiền bán hàng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel11.add(jLabel12, gridBagConstraints);

        lbTotalIncome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalIncome.setText("14,000,000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel11.add(lbTotalIncome, gridBagConstraints);

        jPanel6.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(0, 166, 90));
        jPanel12.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer_support_50px.png"))); // NOI18N
        jLabel13.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel7.add(jPanel12, java.awt.BorderLayout.LINE_START);

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tổng thời gian LV");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel13.add(jLabel14, gridBagConstraints);

        lbTotalTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalTime.setText("33");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel13.add(lbTotalTime, gridBagConstraints);

        jPanel7.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel7);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel16.setBackground(new java.awt.Color(243, 156, 18));
        jPanel16.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer_50px.png"))); // NOI18N
        jLabel15.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel14.add(jPanel16, java.awt.BorderLayout.LINE_START);

        jPanel24.setOpaque(false);
        jPanel24.setLayout(new java.awt.GridBagLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Số ngày làm việc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel24.add(jLabel16, gridBagConstraints);

        lbTotalCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalCustomer.setText("10+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel24.add(lbTotalCustomer, gridBagConstraints);

        jPanel14.add(jPanel24, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel14);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(245, 100));
        jPanel25.setLayout(new java.awt.BorderLayout());

        jPanel26.setBackground(new java.awt.Color(243, 156, 18));
        jPanel26.setMaximumSize(new java.awt.Dimension(100, 100));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer_50px.png"))); // NOI18N
        jLabel17.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel25.add(jPanel26, java.awt.BorderLayout.LINE_START);

        jPanel27.setOpaque(false);
        jPanel27.setLayout(new java.awt.GridBagLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Bonus");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel27.add(jLabel18, gridBagConstraints);

        lbTotalCustomer1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalCustomer1.setText("10+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel27.add(lbTotalCustomer1, gridBagConstraints);

        jPanel25.add(jPanel27, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel25);

        add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel28.setPreferredSize(new java.awt.Dimension(470, 512));
        jPanel28.setLayout(new java.awt.BorderLayout());

        panelCalendar.setBackground(new java.awt.Color(204, 209, 209));
        panelCalendar.setAlignmentX(0.0F);
        panelCalendar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelCalendar.setPreferredSize(new java.awt.Dimension(372, 434));
        jPanel28.add(panelCalendar, java.awt.BorderLayout.CENTER);
        panelCalendar.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setLayout(new java.awt.BorderLayout());

        btnEnter.setText("Enter");
        btnEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtYear.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        cbxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbxMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEnter)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnter)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setAlignmentX(0.0F);
        jPanel15.setAlignmentY(0.0F);
        jPanel15.setMinimumSize(new java.awt.Dimension(60, 60));
        jPanel15.setRequestFocusEnabled(false);
        jPanel15.setVerifyInputWhenFocusTarget(false);

        jPanel17.setAlignmentY(0.0F);
        jPanel17.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Chủ nhật");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel17);

        jPanel18.setAlignmentY(0.0F);
        jPanel18.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thứ 2");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel18);

        jPanel19.setAlignmentY(0.0F);
        jPanel19.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thứ 3");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel19);

        jPanel20.setAlignmentY(0.0F);
        jPanel20.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Thứ 4");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel20);

        jPanel21.setAlignmentY(0.0F);
        jPanel21.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Thứ 5");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel21);

        jPanel22.setAlignmentY(0.0F);
        jPanel22.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thứ 6");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel22);

        jPanel23.setAlignmentY(0.0F);
        jPanel23.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Thứ 7");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel23);

        jPanel1.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel28.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        add(jPanel28, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JComboBox<String> cbxMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbTotalCustomer;
    private javax.swing.JLabel lbTotalCustomer1;
    private javax.swing.JLabel lbTotalIncome;
    private javax.swing.JLabel lbTotalOrder;
    private javax.swing.JLabel lbTotalTime;
    private javax.swing.JPanel panelCalendar;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
