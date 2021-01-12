package controllers.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.data.category.CategoryDataset;

/**
 * createAt Jan 3, 2021
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class LineChart {

    private static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createLineChart(null, "Ngày", "Thu nhập(100K)", dataset, PlotOrientation.VERTICAL, false, true, false);
        chart.addSubtitle((Title) new TextTitle("Thu nhập cửa hàng"));
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangePannable(true);
        plot.setRangeGridlinesVisible(false);
        plot.getDomainAxis().setCategoryLabelPositions(
                CategoryLabelPositions.UP_45);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ChartUtils.applyCurrentTheme(chart);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setDefaultShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
//        renderer.setDefaultFillPaint(Color.WHITE);
        renderer.setSeriesStroke(0, new BasicStroke(3.0F));
        renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
        renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0D, -5.0D, 10.0D, 10.0D));
        return chart;
    }

    public static JPanel createChartPanel(CategoryDataset dataset) {
        JFreeChart chart = createChart(dataset);
        chart.getPlot().setBackgroundPaint(new Color(242, 242, 242));
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        panel.setBackground(Color.WHITE);
        return (JPanel) panel;
    }
}
