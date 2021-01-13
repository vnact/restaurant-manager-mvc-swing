package controllers;

import dao.OrderDao;
import dao.OrderItemDao;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import models.FoodItem;
import models.Order;
import models.OrderItem;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class PrintOrderController {

    XWPFDocument document;
    File orderFile;
    String fileName;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    public PrintOrderController() {
        document = new XWPFDocument();
        orderFile = new File("D:\\Desktop\\Order\\order.docx");
    }

    public void print(int id) throws Exception {
        orderFile = new File("D:\\Desktop\\Order\\order-" + id + ".docx");
        OrderDao orderDao = new OrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();
        Order order = orderDao.get(id);
        ArrayList<OrderItem> orderItems = orderItemDao.getByIdOrder(id);
        print(order, orderItems);
    }

    public File getOrderFile() {
        return orderFile;
    }

    public void setOrderFile(File orderFile) {
        this.orderFile = orderFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void createHeader() {
        XWPFParagraph paragraph;
        XWPFRun run;
        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run = paragraph.createRun();
        run.setText("Hóa Đơn");
        run.setBold(true);
        run.setColor("FF0000");
        run.setFontSize(30);
    }

    public void createHeaderInfo(Order order) {
        XWPFParagraph paragraph;
        XWPFRun run;
        int fontSize = 12;
        paragraph = document.createParagraph();
//        paragraph.setBorderBottom(Borders.BASIC_WIDE_MIDLINE);
//        paragraph.setBorderTop(Borders.BASIC_WIDE_MIDLINE);
//        paragraph.setBorderLeft(Borders.BASIC_WIDE_MIDLINE);
//        paragraph.setBorderRight(Borders.BASIC_WIDE_MIDLINE);
        paragraph.setAlignment(ParagraphAlignment.LEFT);

        run = paragraph.createRun();
        run.setText("Tên nhân viên: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setBold(true);
        run.setText(order.getEmployee().getName());
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Thời gian: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setBold(true);
        run.setText(dateFormat.format(new Date(order.getOrderDate().getTime())));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();
    }

    public void createOrderInfo(ArrayList<OrderItem> orderItems) {
        XWPFParagraph paragraph;
        XWPFRun run;
        int fontSize = 14;
        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        paragraph.setBorderTop(Borders.BIRDS);
        paragraph.setBorderBottom(Borders.BIRDS);
        run = paragraph.createRun();
        run.addBreak();
        for (OrderItem orderItem : orderItems) {
            FoodItem food = orderItem.getFoodItem(), topping = orderItem.getToppingItem();
            run = paragraph.createRun();
            run.setFontSize(fontSize);
            run.setBold(true);
            run.setText(String.format("%s(%s)          %d(%s)          %dVND", food.getName(), topping.getName(), orderItem.getQuantity(), food.getUnitName(), orderItem.getAmount()));
            run.addBreak();
        }
    }

    public void createPaidInfo(Order order) {
        int fontSize = 12;
        XWPFParagraph paragraph;
        XWPFRun run;
        paragraph = document.createParagraph();
//        paragraph.setBorderBottom(Borders.BALLOONS_3_COLORS);
        paragraph.setAlignment(ParagraphAlignment.LEFT);

        run = paragraph.createRun();
        run.setText("Tổng tiển: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(formatter.format(order.getTotalAmount()));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Giảm giá: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(order.getDiscount() + "%");
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Phải thanh toán: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(formatter.format(order.getFinalAmount()));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Đã thanh toán: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(formatter.format(order.getPaidAmount()));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Tiền thừa: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(formatter.format(order.getFinalAmount() - order.getPaidAmount()));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Ngày thanh toán ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(dateFormat.format(new Date(order.getPayDate().getTime())));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
    }

    public void createFooter() {
        XWPFParagraph paragraph;
        XWPFRun run;
        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        run = paragraph.createRun();
        run.setText("Cảm ơn quý khách!Hẹn gặp lại!");
        run.setItalic(true);
        run.setFontSize(10);
    }

    public void print(Order order, ArrayList<OrderItem> orderItems) throws Exception {
        FileOutputStream out = new FileOutputStream(orderFile, false);
        createHeader();
        createHeaderInfo(order);
        createOrderInfo(orderItems);
        createPaidInfo(order);
        createFooter();
        document.write(out);
        out.close();
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(orderFile);
        }
    }

}
