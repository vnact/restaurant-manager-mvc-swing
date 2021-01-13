/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.popup;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import models.Table;
import utils.ErrorPopup;

/**
 * createAt Dec 21, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class EditOrderPopupView extends javax.swing.JFrame implements PopupView {

    DefaultComboBoxModel<Table> tbComboBoxModel = new DefaultComboBoxModel<>();

    public EditOrderPopupView() {
        initComponents();
        setLocationRelativeTo(null);
        cboTable.setModel(tbComboBoxModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlTop = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        pnlLeft = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spnDiscount = new javax.swing.JSpinner();
        cboTable = new javax.swing.JComboBox<>();
        cboType = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        lbIdOrder = new javax.swing.JLabel();
        lbEmployeeName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancelOrder = new javax.swing.JButton();
        btnShipManager = new javax.swing.JButton();
        btnPaid = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnPrintOrder = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbTotalAmount = new javax.swing.JLabel();
        lbFinalAmount = new javax.swing.JLabel();
        lbDiscount = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbPaidAmount = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlOrderItem = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        pnlFoodCategory = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlFoodItem = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1555, 640));

        pnlTop.setPreferredSize(new java.awt.Dimension(1500, 40));
        pnlTop.setLayout(new java.awt.GridBagLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setText("Cập nhật hóa đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        pnlTop.add(lbTitle, gridBagConstraints);

        getContentPane().add(pnlTop, java.awt.BorderLayout.PAGE_START);

        pnlLeft.setPreferredSize(new java.awt.Dimension(250, 600));
        pnlLeft.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chỉnh sửa thông tin"));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 200));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Nhân viên:");
        jLabel2.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Bàn:");
        jLabel3.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Loại hóa đơn:");
        jLabel4.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel4, gridBagConstraints);
        jPanel3.add(jLabel5, new java.awt.GridBagConstraints());

        jLabel6.setText("Giảm giá(%):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel6, gridBagConstraints);

        spnDiscount.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(spnDiscount, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cboTable, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(cboType, gridBagConstraints);

        jLabel17.setText("Mã HD:");
        jLabel17.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(jLabel17, gridBagConstraints);

        lbIdOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbIdOrder.setText("001");
        lbIdOrder.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbIdOrder, gridBagConstraints);

        lbEmployeeName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbEmployeeName.setForeground(new java.awt.Color(255, 0, 0));
        lbEmployeeName.setText("Trần Đức Cường");
        lbEmployeeName.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel3.add(lbEmployeeName, gridBagConstraints);

        pnlLeft.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thao tác"));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 175));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        btnOK.setText("Cập Nhật");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnOK, gridBagConstraints);

        btnCancelOrder.setText("Hủy Hóa Đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnCancelOrder, gridBagConstraints);

        btnShipManager.setText("Quản lý ship");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnShipManager, gridBagConstraints);

        btnPaid.setText("Thanh Toán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnPaid, gridBagConstraints);

        btnCancel.setText("Đóng");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnCancel, gridBagConstraints);

        btnPrintOrder.setText("In Hóa Đơn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(btnPrintOrder, gridBagConstraints);

        pnlLeft.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Tổng:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Đã Thanh Toán:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Giảm Giá:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel9, gridBagConstraints);

        lbTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalAmount.setForeground(new java.awt.Color(255, 0, 0));
        lbTotalAmount.setText("1000,000,000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lbTotalAmount, gridBagConstraints);

        lbFinalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbFinalAmount.setForeground(new java.awt.Color(255, 0, 0));
        lbFinalAmount.setText("1020,000,000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lbFinalAmount, gridBagConstraints);

        lbDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbDiscount.setForeground(new java.awt.Color(255, 0, 0));
        lbDiscount.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lbDiscount, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("VND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("VND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel14, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel15, gridBagConstraints);

        jLabel10.setText("Phải Trả");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel10, gridBagConstraints);

        lbPaidAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbPaidAmount.setForeground(new java.awt.Color(255, 0, 0));
        lbPaidAmount.setText("1020,000,000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lbPaidAmount, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("VND");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel16, gridBagConstraints);

        jLabel18.setText("Trạng thái:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(jLabel18, gridBagConstraints);

        lbStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 0, 0));
        lbStatus.setText("Chưa thanh toán");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel5.add(lbStatus, gridBagConstraints);

        pnlLeft.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlLeft, java.awt.BorderLayout.LINE_START);

        pnlRight.setBackground(new java.awt.Color(102, 102, 0));
        pnlRight.setPreferredSize(new java.awt.Dimension(525, 600));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách món đã đặt"));
        jPanel6.setPreferredSize(new java.awt.Dimension(525, 800));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(525, 5002));

        pnlOrderItem.setMaximumSize(new java.awt.Dimension(515, 5000));
        pnlOrderItem.setPreferredSize(new java.awt.Dimension(515, 5000));
        jScrollPane1.setViewportView(pnlOrderItem);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        getContentPane().add(pnlRight, java.awt.BorderLayout.LINE_END);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        pnlFoodCategory.setPreferredSize(new java.awt.Dimension(150, 600));
        pnlFoodCategory.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(150, 50));

        jLabel11.setBackground(new java.awt.Color(102, 51, 0));
        jLabel11.setText("Trà sữa");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel11)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pnlFoodCategory.add(jPanel10);

        jPanel11.setBackground(new java.awt.Color(51, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(150, 50));

        jLabel12.setText("Bánh");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel12)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel12)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlFoodCategory.add(jPanel11);

        pnlCenter.add(pnlFoodCategory, java.awt.BorderLayout.LINE_START);

        jPanel14.setOpaque(false);
        jPanel14.setPreferredSize(new java.awt.Dimension(625, 600));

        jScrollPane2.setBackground(new java.awt.Color(153, 153, 0));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setOpaque(false);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(625, 600));

        pnlFoodItem.setMaximumSize(new java.awt.Dimension(615, 10000));
        pnlFoodItem.setMinimumSize(new java.awt.Dimension(615, 1000));
        pnlFoodItem.setName(""); // NOI18N
        pnlFoodItem.setPreferredSize(new java.awt.Dimension(615, 5000));
        pnlFoodItem.setRequestFocusEnabled(false);
        pnlFoodItem.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jPanel8.setBackground(new java.awt.Color(102, 51, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setToolTipText("");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        pnlFoodItem.add(jPanel8);

        jPanel12.setBackground(new java.awt.Color(102, 51, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setToolTipText("");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        pnlFoodItem.add(jPanel12);

        jPanel13.setBackground(new java.awt.Color(102, 0, 0));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setToolTipText("");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        pnlFoodItem.add(jPanel13);

        jScrollPane2.setViewportView(pnlFoodItem);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlCenter.add(jPanel14, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnCancelOrder() {
        return btnCancelOrder;
    }

    public JButton getBtnPrintOrder() {
        return btnPrintOrder;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public JButton getBtnPaid() {
        return btnPaid;
    }

    public JButton getBtnShipManager() {
        return btnShipManager;
    }

    public JComboBox<Table> getCboTable() {
        return cboTable;
    }

    public JComboBox<String> getCboType() {
        return cboType;
    }

    public JLabel getLbDiscount() {
        return lbDiscount;
    }

    public JLabel getLbFinalAmount() {
        return lbFinalAmount;
    }

    public JLabel getLbIdOrder() {
        return lbIdOrder;
    }

    public JLabel getLbPaidAmount() {
        return lbPaidAmount;
    }

    @Override
    public JLabel getLbTitle() {
        return lbTitle;
    }

    public JLabel getLbTotalAmount() {
        return lbTotalAmount;
    }

    public JPanel getPnlFoodCategory() {
        return pnlFoodCategory;
    }

    public JPanel getPnlFoodItem() {
        return pnlFoodItem;
    }

    public JPanel getPnlOrderItem() {
        return pnlOrderItem;
    }

    public JSpinner getSpnDiscount() {
        return spnDiscount;
    }

    public DefaultComboBoxModel<Table> getTbComboBoxModel() {
        return tbComboBoxModel;
    }

    public JLabel getLbEmployeeName() {
        return lbEmployeeName;
    }

    public JLabel getLbStatus() {
        return lbStatus;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnPaid;
    private javax.swing.JButton btnPrintOrder;
    private javax.swing.JButton btnShipManager;
    private javax.swing.JComboBox<Table> cboTable;
    private javax.swing.JComboBox<String> cboType;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbDiscount;
    private javax.swing.JLabel lbEmployeeName;
    private javax.swing.JLabel lbFinalAmount;
    private javax.swing.JLabel lbIdOrder;
    private javax.swing.JLabel lbPaidAmount;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTotalAmount;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlFoodCategory;
    private javax.swing.JPanel pnlFoodItem;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlOrderItem;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JSpinner spnDiscount;
    // End of variables declaration//GEN-END:variables

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception e) {
        ErrorPopup.show(e);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
