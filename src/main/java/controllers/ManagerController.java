package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.admin.ManagerPaneView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
//Form chung cho các panel kế thừa
public abstract class ManagerController {

    protected ManagerPaneView view;

    public ManagerController() {
    }

    public ManagerPaneView getView() {
        return view;
    }

    public void setView(ManagerPaneView view) {
        if (this.view == null) {
            this.view = view;
            addEvent();
        }
    }

    public abstract void actionAdd();

    public abstract void actionDelete();

    public abstract void actionEdit();

    public abstract void updateData();

    private void addEvent() {
        // Sự kiện bấm nút thêm
        view.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionAdd();
            }
        });
        // Sự kiện bấm nút sửa
        view.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionEdit();
            }
        });
        // Sự kiện bấm nút xóa
        view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionDelete();
            }
        });
        // Sự kiện bấm nút cập nhật
        view.getBtnSync().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Sync Data");
                updateData();
            }
        });
    }
}
