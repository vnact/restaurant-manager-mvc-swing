package controllers.popup;

import controllers.PopupController;
import controllers.admin.TableManagerController;
import dao.TableDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Table;
import utils.TableStatus;
import views.popup.TablePopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class TablePopupController extends PopupController {

    TableDao tableDao = new TableDao();

    public void add(TableManagerController parrent, TablePopupView view) {
        setView(view);
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean addSuccess = addTable();
                    if (addSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Thêm bàn thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public void edit(TableManagerController parrent, TablePopupView view, Table table) {
        setView(view);
//
        view.getLbTitle().setText("Sửa bàn - " + table.getId());
        view.getTxtName().setText(table.getName());
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean editSuccess = editTable(table);
                    if (editSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Sửa bàn thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public boolean addTable() throws Exception {
        TablePopupView view = (TablePopupView) this.getView();
        String name = view.getTxtName().getText();
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
        return true;
    }

    public boolean editTable(Table t) throws Exception {
        TablePopupView view = (TablePopupView) this.getView();
        String tableName = view.getTxtName().getText();
        if (tableName.isEmpty()) {
            throw new Exception("Điền tên bàn");
        }
        Table temp = tableDao.findByName(tableName);
        if (temp != null && temp.getId() != t.getId()) {
            throw new Exception("Tên bàn đã được sử dụng");
        }
        t.setName(tableName);
        tableDao.update(t);
        return true;
    }
}
