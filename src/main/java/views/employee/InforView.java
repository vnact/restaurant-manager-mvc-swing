/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.employee;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class InforView extends javax.swing.JPanel {

    /**
     * Creates new form menuView
     */
    public InforView() {
        initComponents();

        btnChangeInfor.putClientProperty("JButton.buttonType", "roundRect");
        btnChangePass.putClientProperty("JButton.buttonType", "roundRect");
        btnHS.putClientProperty("JButton.buttonType", "roundRect");
        btnNS.putClientProperty("JButton.buttonType", "roundRect");
    }

    public JPanel getPanelCalendar() {
        return panelCalendar;
    }

    public JButton getBtnChangeInfor() {
        return btnChangeInfor;
    }

    public JButton getBtnChangePass() {
        return btnChangePass;
    }

    public JButton getBtnHS() {
        return btnHS;
    }

    public JButton getBtnNS() {
        return btnNS;
    }

    public JLabel getLabName() {
        return labName;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        btnChangePass = new javax.swing.JButton();
        btnChangeInfor = new javax.swing.JButton();
        btnNS = new javax.swing.JButton();
        btnHS = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labName = new javax.swing.JLabel();
        panelCalendar = new javax.swing.JPanel();

        setBackground(new java.awt.Color(225, 203, 138));
        setMinimumSize(new java.awt.Dimension(1008, 680));
        setPreferredSize(new java.awt.Dimension(1008, 680));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(251, 133, 95));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 15, 10, 15));
        jPanel1.setPreferredSize(new java.awt.Dimension(170, 680));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        btnChangePass.setText("Đổi mật khẩu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(btnChangePass, gridBagConstraints);

        btnChangeInfor.setText("Thay đổi thông tin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(btnChangeInfor, gridBagConstraints);

        btnNS.setText("Năng suất");
        btnNS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 43;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(btnNS, gridBagConstraints);

        btnHS.setText("Hiệu suất");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 47;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(btnHS, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.EAST);

        jPanel2.setOpaque(false);

        labName.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        labName.setText("Xin chào Trần Đức Cường !");

        panelCalendar.setPreferredSize(new java.awt.Dimension(480, 578));

        javax.swing.GroupLayout panelCalendarLayout = new javax.swing.GroupLayout(panelCalendar);
        panelCalendar.setLayout(panelCalendarLayout);
        panelCalendarLayout.setHorizontalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        panelCalendarLayout.setVerticalGroup(
            panelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labName)
                .addContainerGap(447, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(labName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 37, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNSActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeInfor;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnHS;
    private javax.swing.JButton btnNS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labName;
    private javax.swing.JPanel panelCalendar;
    // End of variables declaration//GEN-END:variables
}
