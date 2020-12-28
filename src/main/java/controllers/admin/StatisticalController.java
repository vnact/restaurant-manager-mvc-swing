package controllers.admin;

import dao.OrderDao;
import views.admin.StatisticalView;

/**
 * createAt Dec 27, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class StatisticalController {
    
    StatisticalView view;
    OrderDao orderDao = new OrderDao();
    
    public StatisticalController() {
    }
    
    public StatisticalView getView() {
        return view;
    }
    
    public void setView(StatisticalView view) {
        this.view = view;
    }
    
    public void addEvent() {
        
    }
    
    public void initData() {
        try {
//            view
        } catch (Exception e) {
            view.showError(e);
        }
    }
    
}
