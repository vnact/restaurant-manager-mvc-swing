package controllers.popup;

import controllers.PopupController;
import controllers.admin.BaseManagerController;
import dao.BaseDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Base;
import views.popup.BasePopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 * Popup controller mẫu
 */
public class BasePopupController extends PopupController {

    BaseDao baseDao = new BaseDao();

    public void add(BaseManagerController parrent, BasePopupView view) {
        setView(view);
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean addSuccess = addBase();
                    if (addSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Thêm loại món thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public void edit(BaseManagerController parrent, BasePopupView view, Base base) {
        setView(view);

        view.getLbTitle().setText("Sửa loại món - " + base.getId());
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean editSuccess = editBase(base);
                    if (editSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Sửa loại món thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public boolean addBase() throws Exception {
        BasePopupView view = (BasePopupView) this.getView();
        Base e = new Base();
        baseDao.save(e);
        return true;
    }

    public boolean editBase(Base base) throws Exception {
        BasePopupView view = (BasePopupView) this.getView();
        baseDao.update(base);
        return true;
    }
}
