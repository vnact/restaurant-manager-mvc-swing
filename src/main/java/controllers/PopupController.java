package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.popup.Popup;

/**
 * createAt Dec 16, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public abstract class PopupController {

    Popup view;

    public PopupController() {
    }

    public Popup getView() {
        return view;
    }

    public void setView(Popup view) {
        this.view = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                view.dispose();
            }
        });

    }

    public void destroy() {
        if (this.view != null) {
            view.dispose();
        }
        this.view = null;
    }

}
