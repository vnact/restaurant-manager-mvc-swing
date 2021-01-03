package controllers.admin;

import dao.StatisticalDao;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import models.Statistical;
import utils.Debouncer;
import views.admin.StatisticalIncomeView;

/**
 * createAt Jan 3, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class StatisticalIncomeController {

    StatisticalIncomeView view;
    Debouncer debouncer = new Debouncer();
    StatisticalDao statisticalDao = new StatisticalDao();

    public void setView(StatisticalIncomeView view) {
        if (view != this.view) {
            this.view = view;
            addEvent();
        }
    }

    public void initData() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        view.getDateChooserEnd().setCalendar(c);
        c.add(Calendar.DATE, -30);
        view.getDateChooserStart().setCalendar(c);
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
        PropertyChangeListener eventListener = evt -> debouncer.debounce("date_change", onDateChange, 1000);//Chờ 1s không thay đổi mới hiển thị data

        view.getDateChooserStart().addPropertyChangeListener(eventListener);
        view.getDateChooserEnd().addPropertyChangeListener(eventListener);
    }

    private void renderData(Timestamp start, Timestamp end) throws SQLException {
//        throw new UnsupportedOperationException("Not supported yet.");
        renderEmployee(start, end);
        renderProduct(start, end);
    }

    private void renderEmployee(Timestamp start, Timestamp end) throws SQLException {
        view.getEmployeeModel().setNumRows(0);
        for (Statistical.EmployeeIncome income : statisticalDao.getListTotalIncomeByEmployee(start, end)) {
            view.getEmployeeModel().addRow(new Object[]{
                income.employee.getId(), income.employee.getName(), income.totalOrder, income.totalIncome
            });
        }
    }

    private void renderProduct(Timestamp start, Timestamp end) throws SQLException {
        view.getProductModel().setNumRows(0);
        for (Statistical.ProductIncome product : statisticalDao.getQuantityItem(start, end)) {
            view.getProductModel().addRow(new Object[]{
                product.id, product.name, product.quantity, product.amount
            });
        }
    }

}
