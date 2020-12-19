package views.admin;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Model;
import utils.ErrorPopup;
import utils.IconManager;

/**
 *
 * @author Tran Duc Cuong<clonebmn2itt@gmail.com>
 */
public abstract class ManagerPaneView<T extends Model> extends JPanel {

    DefaultTableModel tableModel = new DefaultTableModel();
    IconManager im = new IconManager();
    ArrayList<T> tableData = new ArrayList<>();

    public ManagerPaneView() {
        initComponents();
        tblData.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        tblData.getTableHeader().setOpaque(false);
        tblData.getTableHeader().setBackground(new Color(51, 175, 255));
        tblData.getTableHeader().setForeground(new Color(255,255,255));
        tblData.setAutoCreateRowSorter(true);
        btnAdd.setIcon(im.getIcon("add_25px.png"));
        btnEdit.setIcon(im.getIcon("edit_25px.png"));
        btnDelete.setIcon(im.getIcon("delete_25px.png"));
        btnSync.setIcon(im.getIcon("sync_25px.png"));
        tblData.setModel(tableModel);
        btnAdd.putClientProperty("JButton.buttonType", "roundRect");
        
    }

    public void showError(String message) {
        ErrorPopup.show(new Exception(message));
    }

    public void showError(Exception e) {
        ErrorPopup.show(e);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    //Lấy các nút để set event
    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getBtnSync() {
        return btnSync;
    }

    public ArrayList<T> getTableData() {
        return tableData;
    }

    public void setTableData(ArrayList<T> tableData) {
        this.tableData = tableData;
        renderTable();
    }

    public JTable getTblData() {
        return tblData;
    }

    // Lấy id các hàng đc chọn
    public int[] getSelectedIds() {

        int selectedRows[] = tblData.getSelectedRows();
        int selectedIds[] = new int[selectedRows.length];
        for (int i = 0; i < selectedRows.length; i++) {
            int selectedRow = selectedRows[i];
            int id = (int) tblData.getValueAt(selectedRow, 0);
            selectedIds[i] = id;
        }
        return selectedIds;
    }

    // Lấy id hàng chọn đầu
    public int getSelectedId() {

        int selectedRow = tblData.getSelectedRow();
        if (selectedRow < 0) {
            return -1;
        }
        int id = (int) tblData.getValueAt(selectedRow, 0);
        return id;
    }

    public void renderTable() {
        tableModel.setNumRows(0);
        try {
            for (T item : tableData) {
                tableModel.addRow(item.toRowTable());
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    public abstract void setTableModel();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSync = new javax.swing.JButton();

        setBackground(new java.awt.Color(118, 215, 196));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblData.setFocusable(false);
        tblData.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblData.setRowHeight(25);
        tblData.setShowVerticalLines(false);
        tblData.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblData);

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Thêm");

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Sửa");

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Xóa");

        btnSync.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSync.setText("Sync");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSync, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnAdd)
                .addGap(49, 49, 49)
                .addComponent(btnEdit)
                .addGap(50, 50, 50)
                .addComponent(btnDelete)
                .addGap(52, 52, 52)
                .addComponent(btnSync)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSync;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
