package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        //
        view.getTxt_search().addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(view.getTxt_search().getText().equals("Search")){
                    view.getTxt_search().setText("");
                    view.getTxt_search().setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(view.getTxt_search().getText().equals("")||view.getTxt_search().getText().equals("Search")){
                    view.getTxt_search().setText("Search");
                    view.getTxt_search().setForeground(new Color(153,153,153));
                }
            }
        });
        view.getTxt_search().addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                    actionSearch();
            }
        });
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
