package controllers.admin;

import controllers.ManagerController;
import controllers.popup.TablePopupController;
import dao.TableDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_OPTION;
import models.Table;
import utils.TableStatus;
import views.admin.EmployeeManagerPaneView;
import views.popup.TablePopupView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class TableManagerController extends ManagerController {

    TableDao tableDao = new TableDao();
    TablePopupController popupController = new TablePopupController();

    public TableManagerController() {
        super();
    }

    public void setView(EmployeeManagerPaneView view) {
        super.setView(view);
    }

    public void addTable(TablePopupView popup) {
        try {
            String name = popup.getTxtName().getText();
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
//            setPopupView(null);//Tắt Popup            
        } catch (Exception e) {
            view.showError(e);
        }
    }

    public void editTable(TablePopupView popup, Table t) {
        try {
            String name = popup.getTxtName().getText();
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
//            setPopupView(null);//Tắt Popup      
        } catch (Exception ex) {
            view.showError(ex);
        }
    }

    @Override
    public void actionAdd() {
        popupController.add(this, new TablePopupView());
    }

    @Override
    public void actionEdit() {
        try {
            int selectedId = view.getSelectedId();
            if (selectedId < 0) {
                throw new Exception("Chọn bàn cần edit");
            } else {
                Table t = tableDao.get(selectedId);
                if (t == null) {
                    throw new Exception("Bàn bạn chọn không hợp lệ");
                }
                popupController.edit(this, new TablePopupView(), t);
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
