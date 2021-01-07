package freechart;

import dao.StatisticalDao;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.geom.Ellipse2D;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import models.Statistical;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartDemo1 extends ApplicationFrame {

    static StatisticalDao statisticalDao = new StatisticalDao();

    public LineChartDemo1(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM");
        try {
            Timestamp start = new Timestamp(System.currentTimeMillis());
            Timestamp end = new Timestamp(System.currentTimeMillis());
            for (Statistical.EmployeeIncome employeeIncome : statisticalDao.getListTotalIncomeByDate(start, end)) {
                dataset.addValue(employeeIncome.totalIncome, "TN", formatter.format(employeeIncome.date));
            }
        } catch (Exception e) {
        }
        return (CategoryDataset) dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(null, null, "Thu nhập", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.addSubtitle((Title) new TextTitle("Thu nhập cửa hàng"));
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangePannable(true);
        plot.setRangeGridlinesVisible(false);
//        URL imageURL = LineChartDemo1.class.getClassLoader().getResource("OnBridge11small.png");
//        if (imageURL != null) {
//            ImageIcon temp = new ImageIcon(imageURL);
//            chart.setBackgroundImage(temp.getImage());
//            plot.setBackgroundPaint(null);
//        }
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtils.applyCurrentTheme(chart);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setDefaultShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setDefaultFillPaint(Color.WHITE);
        renderer.setSeriesStroke(0, new BasicStroke(3.0F));
        renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
        renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0D, -5.0D, 10.0D, 10.0D));
        return chart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        return (JPanel) panel;
    }

    public static void main(String[] args) {
        LineChartDemo1 demo = new LineChartDemo1("JFreeChart: LineChartDemo1.java");
        demo.pack();
        UIUtils.centerFrameOnScreen((Window) demo);
        demo.setVisible(true);
    }
}
