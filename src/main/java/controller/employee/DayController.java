/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.WorkDayDao;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import models.WorkDay;
import views.employee.DayView;
import views.employee.PopupInfor;
import views.employee.PopupInfor1;

/**
 *
 * @author Admin
 */
public class DayController {

    private DayView view;
    private String date;
    int id;

    public DayController(DayView view) {
        this.view = view;
        this.view.setVisible(true);
    }

    public DayController(DayView view, String date, int dayNumber, boolean setDay, int id) {
        this.view = view;
        this.id = id;
        view.getLabelNumber().setText(String.valueOf(dayNumber));
        if (setDay == true) {
            this.date = date;
            addEvent();
            this.view.setVisible(true);
        } else {
            this.view.setVisible(true);
        }

    }

    public void addEvent() {
        view.getLabelNumber().setBackground(Color.red);
        view.getLabelNumber().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("press");

                try {
                    PopupInfor popupInfor = new PopupInfor();
                    String Date = date + " 10:00:00.000";
                    WorkDayDao workDayDao = new WorkDayDao();
                    int totalTime = workDayDao.getTotalWorkingMinutes(Timestamp.valueOf(Date), id);
                    System.out.println(date);
                    WorkDay workDay = workDayDao.getSales(id, Timestamp.valueOf(Date));
                    popupInfor.getTxtDate().setText(date);
                    popupInfor.getTxtAmount().setText(String.valueOf(workDay.getAmount()));
                    popupInfor.getTxtTotalAmount().setText(String.valueOf(workDay.getTotalAmount()));
                    popupInfor.getTxtBonus().setText(String.valueOf(workDay.getBonus()));
                    popupInfor.getTxtTotalTime().setText(String.valueOf(totalTime));
                    System.out.println(workDay.getDay());
                    popupInfor.setVisible(true);
                } catch (SQLException ee) {
                    ee.printStackTrace();
                }
            }
        });
    }
}
