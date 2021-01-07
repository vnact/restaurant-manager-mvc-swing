package freechart;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;

public class LineChartEx extends JFrame {

    public LineChartEx() {
        initUI();
    }

    private void initUI() {
        ArrayList<WorkingTime> dataList = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < 31; i++) {
            dataList.add(new WorkingTime(i + 1, rd.nextInt(10000000)));
        }
        ChartPanel chartPanel = new LineChart().createChartPanel(dataList);
        add(chartPanel);
        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            LineChartEx ex = new LineChartEx();
            ex.setVisible(true);
        });
    }
}
