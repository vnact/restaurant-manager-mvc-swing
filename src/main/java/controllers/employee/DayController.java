/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.employee;

import dao.WorkDayDao;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import models.WorkDay;
import utils.ErrorPopup;
import views.employee.DayView;
import views.employee.WorkDayInfoView;

/**
 *
 * @author Admin
 */
public class DayController {

    private DayView view;
    private String date;
    int id;
    WorkDayInfoController workDayInfoController = new WorkDayInfoController();

    public DayController() {
    }

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

    public void addDay(DayView view, int id, Calendar cal, boolean isWorking) {
        view.getLabelNumber().setText("" + cal.get(Calendar.DAY_OF_MONTH));
        if (isWorking) {
            view.setBackground(Color.red);
            Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
            view.setCursor(cursor);
        } else {
            view.setBackground(new Color(240, 240, 200));
        }
        addEvent(view, cal, id);
    }

    public void addEvent(DayView view, Calendar cal, int id) {
        view.getLabelNumber().setBackground(Color.red);
        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                WorkDayInfoView workDayInfoView = new WorkDayInfoView();
                try {
                    workDayInfoController.show(workDayInfoView, cal, id);
                } catch (Exception ex) {
                    ErrorPopup.show(ex);
                }
            }
        });
    }

    public void addEvent() {
        view.getLabelNumber().setBackground(Color.red);
        view.getLabelNumber().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("press");

                try {
                    WorkDayInfoView popupInfor = new WorkDayInfoView();
                    String Date = date + " 10:00:00.000";
                    WorkDayDao workDayDao = new WorkDayDao();
                    int totalTime = workDayDao.getTotalWorkingMinutes(Timestamp.valueOf(Date), id);
                    System.out.println(date);
                    WorkDay workDay = workDayDao.getSales(id, Timestamp.valueOf(Date));
                    popupInfor.getTxtDate().setText(date);
                    popupInfor.getTxtTotalOrder().setText(String.valueOf(workDay.getAmount()));
                    popupInfor.getTxtTotalAmount().setText(String.valueOf(workDay.getTotalAmount()));
                    popupInfor.getTxtBonus().setText(String.valueOf(workDay.getBonus()));
                    popupInfor.getTxtTotalTime().setText(String.valueOf(totalTime));
                    System.out.println(workDay.getDay());
//                    popupInfor.addFocusListener(new FocusListener() {
//                        private boolean gained = false;
//
//                        @Override
//                        public void focusGained(FocusEvent e) {
//                            gained = true;
//                        }
//
//                        @Override
//                        public void focusLost(FocusEvent e) {
//                            if (gained) {
//                                WorkDayInfoView.dispose();
//                            }
//                        }
//                    });
                    popupInfor.setVisible(true);
                } catch (SQLException ee) {
                    ee.printStackTrace();
                }
            }
        });
    }
}
