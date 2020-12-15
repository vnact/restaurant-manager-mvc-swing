package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.admin.ManagerPane;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public abstract class ManageController {

    protected ManagerPane view;
//    protected Popup popupView;

    public ManageController() {
    }

    public ManageController(ManagerPane view) {
        this.view = view;
        addEvent();
    }

    public ManagerPane getView() {
        return view;
    }

    public void setView(ManagerPane view) {
        if (this.view == null) {
            this.view = view;
            addEvent();
        }
    }

//    public Popup getPopupView() {
//        return popupView;
//    }
//
//    public void setPopupView(Popup popupView) {
//        this.popupView = popupView;
//    }
//
//    private void addPopupEvent() {
//        popupView.getBtnCancel().addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                setPopupView(null);
//            }
//        });
//    }
    private void addEvent() {
        // Thêm
        view.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionAdd();
            }
        });
        // Sửa
        view.getBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionEdit();
            }
        });
        // Xóa
        view.getBtnDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                actionDelete();
            }
        });
        // Cập nhật
        view.getBtnSync().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Sync Data");
                updateData();
            }
        });
    }

    public abstract void actionAdd();

    public abstract void actionDelete();

    public abstract void actionEdit();

    public abstract void updateData();
}
