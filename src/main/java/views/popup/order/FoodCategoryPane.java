package views.popup.order;

import java.awt.Color;
import models.FoodCategory;
import utils.RandomColor;

/**
 * createAt Dec 13, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class FoodCategoryPane extends javax.swing.JPanel {

    FoodCategory foodCategory;

    public FoodCategoryPane(FoodCategory fc) {
        this.foodCategory = fc;
        initComponents();
        lbName.setText(fc.getName());
        Color bg = RandomColor.getColor();
        Color bgText = RandomColor.getContrastColor(bg);
        setBackground(bg);
        lbName.setForeground(bgText);
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lbName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(150, 50));
        setPreferredSize(new java.awt.Dimension(150, 50));
        setLayout(new java.awt.GridBagLayout());

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 0, 0));
        lbName.setText("Topping");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        add(lbName, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables

}
