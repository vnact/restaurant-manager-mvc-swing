/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.popup.order;

import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import models.FoodItem;
import utils.ErrorPopup;
import utils.ImageManager;

/**
 * createAt Dec 14, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class FoodItemPane extends javax.swing.JPanel {

    ImageManager im = new ImageManager();
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    FoodItem foodItem;

    public FoodItemPane(FoodItem foodItem) {
        initComponents();
        this.foodItem = foodItem;
        try {
            if (foodItem != null) {
                lbName.setText(foodItem.getName());
                lbPrice.setText(formatter.format(foodItem.getUnitPrice()) + "VND / " + foodItem.getUnitName());
                String urlImage = foodItem.getUrlImage();
                if (urlImage != null && !urlImage.isEmpty()) {
                    ImageIcon ic = im.getImage(urlImage);
                    lbIcon.setIcon(im.resizeIcon(ic, 75, 75));
                }
            }
        } catch (Exception e) {
            ErrorPopup.show(e);
        }
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbIcon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(300, 75));
        setMinimumSize(new java.awt.Dimension(300, 75));
        setPreferredSize(new java.awt.Dimension(300, 75));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(75, 75));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/new_75px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setOpaque(false);

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbName.setText("Trà Sữa Trân Châu Đường Đen(L)");
        lbName.setName(""); // NOI18N
        lbName.setPreferredSize(new java.awt.Dimension(20, 20));

        lbPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(255, 0, 0));
        lbPrice.setText("50,000 VND / Ly");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbPrice)
                        .addGap(0, 121, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lbPrice)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPrice;
    // End of variables declaration//GEN-END:variables

}
