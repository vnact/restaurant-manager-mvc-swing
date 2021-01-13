package controllers.employee;

import dao.StatisticalDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import views.employee.WorkDayInfoView;

/**
 * createAt Jan 9, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class WorkDayInfoController {

    WorkDayInfoView previousView = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DecimalFormat decimalFormat = new DecimalFormat("###,###,### VND");
    StatisticalDao statisticalDao = new StatisticalDao();

    public void show(WorkDayInfoView view, Calendar cal, int id) throws Exception {
        if (previousView != null) {
            previousView.dispose();
        }
        previousView = view;
        Calendar start = (Calendar) cal.clone(), end = (Calendar) cal.clone();
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        end.set(Calendar.HOUR_OF_DAY, 24);
        end.set(Calendar.MINUTE, 0);
        Timestamp startTime = new Timestamp(start.getTimeInMillis());
        Timestamp endTime = new Timestamp(end.getTimeInMillis());
        int totalOrder = statisticalDao.getTotalOrder(startTime, endTime, id);
        int workingMinus = statisticalDao.getTotalWorkingMinutes(startTime, endTime, id);
        int totalAmount = statisticalDao.getTotalIncome(startTime, endTime, id);
        view.getTxtDate().setText(dateFormat.format(cal.getTime()));
        view.getTxtTotalOrder().setText("" + totalOrder);
        view.getTxtBonus().setText(decimalFormat.format(totalOrder * 2000));
        view.getTxtTotalTime().setText(minutesToHours(workingMinus));
        view.getTxtTotalAmount().setText(decimalFormat.format(totalAmount));
        view.pack();
        view.setVisible(true);
        view.getLbExit().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                view.dispose();
            }
        });
    }

    private String minutesToHours(int m) {
        int hours = m / 60, minutes = m - hours * 60;
        return String.format("%02d:%02d:00", hours, minutes);
    }

}
