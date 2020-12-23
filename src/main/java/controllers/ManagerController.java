package controllers;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import views.admin.ManagerPaneView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
//Form chung cho các panel kế thừa
public abstract class ManagerController {

    protected ManagerPaneView view = null;

    public ManagerController() {
    }

    public ManagerPaneView getView() {
        return view;
    }

    public void setView(ManagerPaneView view) {
        if (this.view != view) {
            this.view = view;
            addEvent();
        } else {
            this.view = view;
        }
    }

    public abstract void actionAdd();

    public abstract void actionSearch();

    public abstract void actionDelete();

    public abstract void actionEdit();

    public abstract void updateData();

    private void addEvent() {
        // Hiển thị place holder 
        view.getTxtSearch().addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                if (view.getTxtSearch().getText().equals("Search")) {
                    view.getTxtSearch().setText("");
                    view.getTxtSearch().setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent evt) {
                if (view.getTxtSearch().getText().equals("") || view.getTxtSearch().getText().equals("Search")) {
                    view.getTxtSearch().setText("Search");
                    view.getTxtSearch().setForeground(new Color(153, 153, 153));
                }
            }
        });
        view.getTxtSearch().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    actionSearch();
                }
            }
        });
        // Sự kiện bấm nút thêm
        view.getBtnAdd().addActionListener(evt -> actionAdd());
        // Sự kiện bấm nút sửa
        view.getBtnEdit().addActionListener(evt -> actionEdit());
        // Sự kiện bấm nút xóa
        view.getBtnDelete().addActionListener(evt -> actionDelete());
        // Sự kiện bấm nút cập nhật
        view.getBtnSync().addActionListener(evt -> updateData());
    }
}
