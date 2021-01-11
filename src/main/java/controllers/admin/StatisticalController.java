package controllers.admin;

import controllers.chart.IncomeChartController;
import dao.StatisticalDao;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import utils.Debouncer;
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
    Debouncer debouncer = new Debouncer();
    IncomeChartController incomeChartController = new IncomeChartController();

    public StatisticalController() {
    }

    public StatisticalView getView() {
        return view;
    }

    public void setView(StatisticalView view) {
        if (view != this.view) {
            this.view = view;
            addEvent();
        }
    }

    public void addEvent() {
        Runnable onDateChange = () -> {
            Date startDate = view.getDateChooserStart().getDate();
            Date endDate = view.getDateChooserEnd().getDate();
            if (startDate.after(endDate)) {
                view.showError("Ngày bắt đầu không thể sau ngày kết thúc");
                return;
            }
            try {
                renderData(new Timestamp(startDate.getTime()), new Timestamp(endDate.getTime()));
            } catch (SQLException ex) {
                view.showError(ex);
            }

        };
        PropertyChangeListener eventListener = evt -> debouncer.debounce("date_change", onDateChange, 1000);//Chờ 3s không thay đổi mới hiển thị data

        view.getDateChooserStart().addPropertyChangeListener(eventListener);
        view.getDateChooserEnd().addPropertyChangeListener(eventListener);
    }

    public void initData() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        view.getDateChooserEnd().setCalendar(c);
        c.add(Calendar.DATE, -30);
        view.getDateChooserStart().setCalendar(c);
    }

    public void renderData(Timestamp start, Timestamp end) throws SQLException {
        int totalIncome = statisticalDao.getTotalIncome(start, end);
        view.getLbTotalOrder().setText(statisticalDao.getTotalOrder(start, end) + "");
        view.getLbTotalEmployee().setText(statisticalDao.getTotalEmployee() + "");
        view.getLbTotalCustomer().setText(statisticalDao.getTotalCustomer() + "");
        IntervalIncrease.create(totalIncome, 1500, 25, (i) -> {
            view.getLbTotalIncome().setText(formatter.format(i));
        });
        renderChart(start, end);
    }

    public void renderChart(Timestamp start, Timestamp end) throws SQLException {
        incomeChartController.show(view.getPnlContent(), start, end);
    }

}
