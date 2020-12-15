package controllers;

import dao.EmployeeDao;
import dao.TableDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.Table;
import utils.TableStatus;
import views.admin.EmployeeManagerPane;
import views.admin.popup.TablePopup;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class TableManagerController extends ManageController {

    EmployeeDao employeeDao = new EmployeeDao();
    TableDao tableDao = new TableDao();
    TablePopup popupView;

    abstract class PopupEvent {

        public void onBtnCancel() {
            setPopupView(null);
        }

        public abstract void onBtnOK();
    }

    public TableManagerController() {
        super();
    }

    public TableManagerController(EmployeeManagerPane view) {
        super(view);
    }

    public void setView(EmployeeManagerPane view) {
        super.setView(view);
    }

    public TablePopup getPopupView() {
        return popupView;
    }

    public void setPopupView(TablePopup popupView) {
        if (popupView != null) {
            // Hiện popup mới
            popupView.setVisible(true);
        }
        if (this.popupView != null) {
            // Tắt popup cũ
            this.popupView.dispose();
        }
        this.popupView = popupView;
    }

    public void showPopup(TablePopup popupView, PopupEvent event) {
        if (popupView == null) {
            return;
        }
        setPopupView(popupView);
        this.popupView.getBtnCancel().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                event.onBtnCancel();
            }
        });
        this.popupView.getBtnOK().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                event.onBtnOK();
            }
        });
    }

    public void addTable() {
        try {
            String name = popupView.getTxtName().getText();
            if (name.isEmpty()) {
                throw new Exception("Vui lòng điền đủ thông tin");
            }
            if (tableDao.findByName(name) != null) {
                throw new Exception("Tên bàn đã được sử dụng");
            }
            Table t = new Table();
            t.setName(name);
            t.setStatus(TableStatus.FREE);
            tableDao.save(t);
            view.showMessage("Thêm thành công");
            updateData();
            setPopupView(null);//Tắt Popup            
        } catch (Exception e) {
            view.showError(e);
        }
    }

    public void editTable(Table t) {
        try {
            String name = popupView.getTxtName().getText();
            if (name.isEmpty()) {
                throw new Exception("Điền tên bàn");
            }
            Table temp = tableDao.findByName(name);
            if (temp != null && temp.getId() != t.getId()) {
                throw new Exception("Tên bàn đã được sử dụng");
            }
            t.setName(name);
            tableDao.update(t);
            view.showMessage("Cập nhật thành công");
            updateData();
            setPopupView(null);//Tắt Popup      
        } catch (Exception ex) {
            view.showError(ex);
        }
    }

    @Override
    public void actionAdd() {
        showPopup(new TablePopup(), new PopupEvent() {
            @Override
            public void onBtnOK() {
                addTable();
            }
        });
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn nhân viên cần edit");
            } else {
                TablePopup popup = new TablePopup();
                popup.getLbTitle().setText("Sửa bàn - " + selectedId);
                Table t = tableDao.get(selectedId);
                if (t == null) {
                    throw new Exception("Bàn bạn chọn không hợp lệ");
                }
                popup.getTxtName().setText(t.getName());
                popup.getBtnOK().setText("Cập nhật");
                showPopup(popup, new PopupEvent() {
                    @Override
                    public void onBtnOK() {
                        editTable(t);
                    }
                });
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void actionDelete() {
        int selectedIds[] = view.getSelectedIds();
        try {
            if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa hàng loạt?", "Xóa bàn", ERROR_MESSAGE) != YES_OPTION) {
                return;
            }
            for (int i = 0; i < selectedIds.length; i++) {
                tableDao.deleteById(selectedIds[i]);
                updateData();
            }
        } catch (Exception e) {
            view.showError(e);
        }
    }

    @Override
    public void updateData() {
        try {
            ArrayList<Table> tables = tableDao.getAll();
            view.setTableData(tables);
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
