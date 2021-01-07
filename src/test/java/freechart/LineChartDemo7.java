package freechart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.UIUtils;
import org.jfree.chart.util.ShapeUtils;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartDemo7 extends ApplicationFrame {

    public LineChartDemo7(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(21.0D, "Thu nhập", "Category 1");
        dataset.addValue(50.0D, "Thu nhập", "Category 2");
        dataset.addValue(152.0D, "Thu nhập", "Category 3");
        dataset.addValue(184.0D, "Thu nhập", "Category 4");
        dataset.addValue(299.0D, "Thu nhập", "Category 5");
        dataset.addValue(275.0D, "Số hóa đơn", "Category 1");
        dataset.addValue(121.0D, "Số hóa đơn", "Category 2");
        dataset.addValue(98.0D, "Số hóa đơn", "Category 3");
        dataset.addValue(103.0D, "Số hóa đơn", "Category 4");
        dataset.addValue(210.0D, "Số hóa đơn", "Category 5");
        return (CategoryDataset) dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart("Thống kê cửa hàng", null, "Count", dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesShape(1, ShapeUtils.createDiamond(4.0F));
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setDefaultFillPaint(Color.WHITE);
        return chart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return (JPanel) new ChartPanel(chart);
    }

    public static void main(String[] args) {
        LineChartDemo7 demo = new LineChartDemo7("JFreeChart: LineChartDemo7.java");
        demo.pack();
        UIUtils.centerFrameOnScreen((Window) demo);
        demo.setVisible(true);
    }
}
