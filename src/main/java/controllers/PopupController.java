package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.popup.PopupView;

/**
 * createAt Dec 16, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public abstract class PopupController {

    PopupView view;

    public PopupController() {
    }

    public PopupView getView() {
        return view;
    }

    public void setView(PopupView view) {
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
