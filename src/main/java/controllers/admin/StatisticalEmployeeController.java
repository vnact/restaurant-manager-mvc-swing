package controllers.admin;

import dao.SessionDao;
import dao.StatisticalDao;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import models.Session;
import models.Statistical;
import utils.Debouncer;
import views.admin.StatisticalEmployeeView;

/**
 * createAt Jan 11, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class StatisticalEmployeeController {

    StatisticalEmployeeView view;
    Debouncer debouncer = new Debouncer();
    StatisticalDao statisticalDao = new StatisticalDao();
    SessionDao sessionDao = new SessionDao();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public void setView(StatisticalEmployeeView view) {
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
                ex.printStackTrace();
                view.showError(ex);
            }

        };
        PropertyChangeListener eventListener = evt -> debouncer.debounce("date_change", onDateChange, 1000);//Chờ 1s không thay đổi mới hiển thị data

        view.getDateChooserStart().addPropertyChangeListener(eventListener);
        view.getDateChooserEnd().addPropertyChangeListener(eventListener);
    }

    private void renderData(Timestamp start, Timestamp end) throws SQLException {
        renderSession(start, end);
        renderEmployee(start, end);

    }

    private String formatTime(Timestamp time) {
        return dateFormat.format(new Date(time.getTime()));
    }

    private void renderSession(Timestamp start, Timestamp end) throws SQLException {
        view.getSessionModel().setNumRows(0);
        for (Session session : sessionDao.getAll(start, end)) {
            view.getSessionModel().addRow(new Object[]{
                session.getEmployee().getId(), session.getEmployee().getName(),
                formatTime(session.getStartTime()), formatTime(session.getEndTime())
            });
        }
    }

    private void renderEmployee(Timestamp start, Timestamp end) throws SQLException {
        view.getEmployeeModel().setNumRows(0);
        for (Statistical.SalaryEmployee salaryEmployee : statisticalDao.getSalaryEmployee(start, end)) {
            view.getEmployeeModel().addRow(new Object[]{
                salaryEmployee.employee.getId(), salaryEmployee.employee.getName(), salaryEmployee.employee.getSalary(), salaryEmployee.quantily, salaryEmployee.bonus, salaryEmployee.getTotal()
            });
        }
    }

}
