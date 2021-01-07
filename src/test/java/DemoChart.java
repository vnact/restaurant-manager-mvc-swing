//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import javax.swing.JPanel;
//import org.jfree.data.DefaultKeyedValues;
//
///**
// * createAt Dec 23, 2020
// *
// * @author Đỗ Tuấn Anh <daclip26@gmail.com>
// */
//public class DemoChart {
//
//    public static JPanel createDemoPanel() {
//        JPanel content = new JPanel(new BorderLayout());
//        content.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
//        CategoryDataset3D dataset = createDataset();
//        Chart3D chart = createChart(dataset);
//        Chart3DPanel chartPanel = new Chart3DPanel(chart);
//        content.setChartPanel(chartPanel);
//        content.add(new DisplayPanel3D(chartPanel));
//        chartPanel.zoomToFit(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
//        return content;
//    }
//
//    private static Chart3D createChart(CategoryDataset3D dataset) {
//        Chart3D chart = Chart3DFactory.createLineChart("Quarterly Profits",
//                "Large Banks in USA", dataset, null, "Quarter", "$ millions");
//        chart.setChartBoxColor(new Color(255, 255, 255, 128));
//        chart.setLegendAnchor(LegendAnchor.TOP_RIGHT);
//        return chart;
//    }
//
//    private static CategoryDataset3D createDataset() {
//        StandardCategoryDataset3D<String, String, String> dataset
//                = new StandardCategoryDataset3D<String, String, String>();
//
//        DefaultKeyedValues<String, Number> s0
//                = new DefaultKeyedValues<String, Number>();
//        s0.put("Q3/11", 5889);
//        s0.put("Q4/11", 1584);
//        s0.put("Q1/12", 328);
//        s0.put("Q2/12", 2098);
//        s0.put("Q3/12", -33);
//        s0.put("Q4/12", 367);
//        s0.put("Q1/13", 1110);
//        s0.put("Q2/13", 3571);
//        s0.put("Q3/13", 2218);
//        dataset.addSeriesAsRow("Bank of America", s0);
//
//        DefaultKeyedValues<String, Number> s1
//                = new DefaultKeyedValues<String, Number>();
//        s1.put("Q3/11", 3771);
//        s1.put("Q4/11", 956);
//        s1.put("Q1/12", 2931);
//        s1.put("Q2/12", 2946);
//        s1.put("Q3/12", 468);
//        s1.put("Q4/12", 1196);
//        s1.put("Q1/13", 3808);
//        s1.put("Q2/13", 4182);
//        s1.put("Q3/13", 3227);
//        dataset.addSeriesAsRow("Citigroup", s1);
//
//        DefaultKeyedValues<String, Number> s3
//                = new DefaultKeyedValues<String, Number>();
//        s3.put("Q3/11", 4055);
//        s3.put("Q4/11", 4107);
//        s3.put("Q1/12", 4248);
//        s3.put("Q2/12", 4622);
//        s3.put("Q3/12", 4937);
//        s3.put("Q4/12", 4857);
//        s3.put("Q1/13", 4931);
//        s3.put("Q2/13", 5272);
//        s3.put("Q3/13", 5317);
//
//        dataset.addSeriesAsRow("Wells Fargo", s3);
//        DefaultKeyedValues<String, Number> s2
//                = new DefaultKeyedValues<String, Number>();
//        s2.put("Q3/11", 4262);
//        s2.put("Q4/11", 3728);
//        s2.put("Q1/12", 4924);
//        s2.put("Q2/12", 4960);
//        s2.put("Q3/12", 5708);
//        s2.put("Q4/12", 5692);
//        s2.put("Q1/13", 6529);
//        s2.put("Q2/13", 6496);
//        s2.put("Q3/13", -380);
//        dataset.addSeriesAsRow("J.P.Morgan", s2);
//
//        return dataset;
//    }
//}
