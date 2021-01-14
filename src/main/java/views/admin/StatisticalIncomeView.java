/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.admin;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import utils.ErrorPopup;

/**
 * createAt Jan 3, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class StatisticalIncomeView extends javax.swing.JPanel {

    DefaultTableModel employeeModel, productModel;

    public StatisticalIncomeView() {
        initComponents();
        employeeModel = new DefaultTableModel() {
            Class[] types = new Class[]{
                Integer.class, String.class, Integer.class, Integer.class
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        productModel = new DefaultTableModel() {
            Class[] types = new Class[]{
                Integer.class, String.class, Integer.class, Integer.class
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        tblEmployee.setModel(employeeModel);
        tblProduct.setModel(productModel);
        employeeModel.addColumn("ID");
        employeeModel.addColumn("Tên Nhân Viên");
        employeeModel.addColumn("Số hóa đơn");
        employeeModel.addColumn("Thu nhập");
        productModel.addColumn("ID");
        productModel.addColumn("Tên món");
        productModel.addColumn("Số lượng");
        productModel.addColumn("Thu nhập");
        setupHeader(tblEmployee);
        setupHeader(tblProduct);
    }

    private void setupHeader(JTable t) {
        t.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        t.getTableHeader().setBackground(new Color(51, 175, 255));
        t.getTableHeader().setForeground(new Color(255, 255, 255));
        ((DefaultTableCellRenderer) t.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.LEFT);
        t.setAutoCreateRowSorter(true);
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

    public DefaultTableModel getEmployeeModel() {
        return employeeModel;
    }

    public DefaultTableModel getProductModel() {
        return productModel;
    }

    public JDateChooser getDateChooserEnd() {
        return dateChooserEnd;
    }

    public JDateChooser getDateChooserStart() {
        return dateChooserStart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dateChooserStart = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dateChooserEnd = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel14.setPreferredSize(new java.awt.Dimension(1008, 40));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 8);
        flowLayout1.setAlignOnBaseline(true);
        jPanel14.setLayout(flowLayout1);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày bắt đầu:");
        jPanel14.add(jLabel6);

        dateChooserStart.setDateFormatString("dd/MM/yyyy");
        dateChooserStart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateChooserStart.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel14.add(dateChooserStart);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Ngày kết thúc:");
        jPanel14.add(jLabel3);

        dateChooserEnd.setDateFormatString("dd/MM/yyyy");
        dateChooserEnd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateChooserEnd.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel14.add(dateChooserEnd);

        add(jPanel14, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(504, 640));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Thống kê doanh thu theo nhân viên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jLabel1, gridBagConstraints);

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Doanh thu"
            }
        ));
        tblEmployee.setRowHeight(30);
        jScrollPane1.setViewportView(tblEmployee);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 436;
        gridBagConstraints.ipady = 407;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        jPanel1.add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel4.setPreferredSize(new java.awt.Dimension(504, 640));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thống kê doanh thu theo sản phẩm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jLabel2, gridBagConstraints);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Doanh thu"
            }
        ));
        tblProduct.setRowHeight(30);
        jScrollPane2.setViewportView(tblProduct);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 436;
        gridBagConstraints.ipady = 407;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel4.add(jScrollPane2, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateChooserEnd;
    private com.toedter.calendar.JDateChooser dateChooserStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
