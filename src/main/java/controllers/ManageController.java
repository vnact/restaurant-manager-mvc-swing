package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.admin.ManagerPane;
import views.admin.popup.Popup;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
//Form chung cho các panel kế thừa
public abstract class ManageController {

    protected ManagerPane view;
    protected Popup popupView; // Popup khác

    // Mỗi popup sẽ có đối tượng event riêng
    abstract class PopupEvent {

        public void onBtnCancel() {
            setPopupView(null);
        }

        public abstract void onBtnOK();
    }

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

    public Popup getPopupView() {
        return popupView;
    }

    public void setPopupView(Popup popupView) {
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

    public void showPopup(Popup popupView, PopupEvent event) {
        if (popupView == null) {
            return;
        }
        setPopupView(popupView);
        popupView.getBtnCancel().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                event.onBtnCancel();
            }
        });
        popupView.getBtnOK().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                event.onBtnOK();
            }
        });
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
