package controllers.admin;

import dao.StatisticalDao;
import java.text.DecimalFormat;
import utils.IntervalIncrease;
import views.admin.StatisticalView;

/**
 * createAt Dec 27, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class StatisticalController {

    StatisticalView view;
    StatisticalDao statisticalDao = new StatisticalDao();
    DecimalFormat formatter = new DecimalFormat("###,###,###");

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
            int totalIncome = statisticalDao.getTotalIncome();
            view.getLbTotalOrder().setText(statisticalDao.getTotalOrder() + "");
            view.getLbTotalEmployee().setText(statisticalDao.getTotalEmployee() + "");
            view.getLbTotalCustomer().setText(statisticalDao.getTotalCustomer() + "");
            IntervalIncrease.create(totalIncome, 1500, 25, (i) -> {
                view.getLbTotalIncome().setText(formatter.format(i));
            });
        } catch (Exception e) {
            view.showError(e);
        }
    }

}
