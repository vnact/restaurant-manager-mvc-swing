package controllers.chart;

import dao.StatisticalDao;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.Statistical;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * createAt Jan 12, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class IncomeChartController {

    static StatisticalDao statisticalDao = new StatisticalDao();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");

    private CategoryDataset createDataset(Timestamp start, Timestamp end) throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<Statistical.EmployeeIncome> incomes = statisticalDao.getListTotalIncomeByDate(start, end);
        for (Date date : getAllDateBetween(start, end)) {
            Statistical.EmployeeIncome income = findByDate(incomes, date);
            if (income != null) {
                dataset.addValue(income.totalIncome / 100000, "TN", formatter.format(income.date));
            } else {
                dataset.addValue(0, "TN", formatter.format(date));
            }
        }
        return (CategoryDataset) dataset;
    }

    private Statistical.EmployeeIncome findByDate(ArrayList<Statistical.EmployeeIncome> incomes, Date date) {
        for (Statistical.EmployeeIncome income : incomes) {
            if (income.equalDate(date)) {
                return income;
            }
        }
        return null;
    }

    private static ArrayList<Date> getAllDateBetween(Timestamp start, Timestamp end) {
        ArrayList<Date> dates = new ArrayList<>();
        Date startTime = new Date(start.getTime());
        Date endTime = new Date(end.getTime());
        Date i = startTime;
        while (!i.after(endTime)) {
            dates.add(i);
            i = new Date(i.getTime() + 24 * 60 * 60 * 1000);//Check ngày sau
        }
        return dates;
    }

    public void show(JPanel panelRoot, Timestamp start, Timestamp end) throws SQLException {
        CategoryDataset dataset = createDataset(start, end);
        JPanel chartPanel = LineChart.createChartPanel(dataset);
        panelRoot.removeAll();
        panelRoot.add(chartPanel);
        panelRoot.updateUI();
//        panelRoot.revalidate();
    }

    public static void main(String[] args) {
        Timestamp start = new Timestamp(System.currentTimeMillis() - 3 * 24 * 60 * 60 * 1000), end = new Timestamp(System.currentTimeMillis());
        for (Date date : getAllDateBetween(start, end)) {
            System.out.println(date);
        }
    }
}
