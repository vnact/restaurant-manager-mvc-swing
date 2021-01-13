/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.popup;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import models.Customer;
import utils.ErrorPopup;
import views.CustomerRenderJList;

/**
 * createAt Dec 31, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class SelectCustomerPopupView extends javax.swing.JFrame {

    DefaultListModel<Customer> customerListModel = new DefaultListModel<>();

    public SelectCustomerPopupView() {
        initComponents();
        listCustomer.setModel(customerListModel);
        listCustomer.setCellRenderer(new CustomerRenderJList());
        setPreferredSize(new Dimension(400, 500));
        getRootPane().setDefaultButton(btnSearch);
        setLocationRelativeTo(null);
    }

    public DefaultListModel<Customer> getCustomerListModel() {
        return customerListModel;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnOK() {
        return btnOK;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public JTextField getTxtCustomerName() {
        return txtCustomerName;
    }

    public JList<Customer> getListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(JList<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public void renderCustomer(ArrayList<Customer> customers) {
        customerListModel.removeAllElements();
        for (Customer customer : customers) {
            customerListModel.addElement(customer);
        }
    }

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception message) {
        ErrorPopup.show(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txtCustomerName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCustomer = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(429, 40));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Chọn khách hàng");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(429, 50));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnOK.setText("OK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnOK, gridBagConstraints);

        btnCancel.setText("Cancel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(btnCancel, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 60));
        jPanel4.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel4.add(txtCustomerName, gridBagConstraints);

        btnSearch.setText("Tìm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        jPanel4.add(btnSearch, gridBagConstraints);

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 350));

        listCustomer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listCustomer);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Customer> listCustomer;
    private javax.swing.JTextField txtCustomerName;
    // End of variables declaration//GEN-END:variables
}
