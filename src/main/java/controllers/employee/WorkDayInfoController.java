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
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###VND");
    StatisticalDao statisticalDao = new StatisticalDao();

    public void show(WorkDayInfoView view, Calendar cal, int id) throws Exception {
        if (previousView != null) {
            previousView.dispose();
        }
        previousView = view;
        Timestamp now = new Timestamp(cal.getTimeInMillis() / 1000 * 1000);
        int totalOrder = statisticalDao.getTotalOrder(now, now, id);
        int workingMinus = statisticalDao.getTotalWorkingMinutes(now, now, id);
        int totalAmount = statisticalDao.getTotalIncome(now, now, id);
        view.getTxtDate().setText(dateFormat.format(cal.getTime()));
        view.getTxtTotalOrder().setText("" + totalOrder);
        view.getTxtBonus().setText(totalOrder * 2000 + "");
        view.getTxtTotalTime().setText(minutesToHours(workingMinus));
        view.getTxtTotalAmount().setText(decimalFormat.format(totalAmount));
        view.pack();
        view.setVisible(true);
        view.getLbExit().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                view.dispose();
                previousView = null;
            }
        });
    }

    private String minutesToHours(int m) {
        int hours = m / 60, minutes = m - hours * 60;
        return String.format("%02d:%02d:00", hours, minutes);
    }

}
