/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.WorkDayDao;
import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import main.SessionManager;
import test.getDayOfMonth;
import views.employee.CalendarView;
import views.employee.DayView;

/**
 *
 * @author Admin
 */
public class CalendarController {

    CalendarView view;
    //ArrayList<Integer> list;
    int month;//= LocalDate.now().getMonthValue();
    int year;// = LocalDate.now().getYear();
    int id = SessionManager.getSession().getIdEmployee();

    public CalendarController(CalendarView view) {
        this.view = view;
        this.view.getCbxMonth().setSelectedIndex(LocalDate.now().getMonthValue() - 1);
        this.view.getTxtYear().setText(String.valueOf(LocalDate.now().getYear()));
        render(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        addEvent();
    }

    public void render(int month, int year) {
        view.getPanelCalendar().removeAll();
        int day = LocalDate.of(year, month, 1).getDayOfWeek().getValue();
        int days = new getDayOfMonth(month, year).getDay();
        System.out.println("ok1");
        if (day < 7) {
            for (int i = 0; i < day; i++) {
                Color color = Color.decode("#F0F0F0");
                DayView dayview = new DayView();
                dayview.getLabelNumber().setBackground(color);
                view.getPanelCalendar().add(dayview);
            }
        }
        System.out.println("ok2");
        try {
            WorkDayDao workDayDao = new WorkDayDao();
            ArrayList<Integer> list = workDayDao.getDay(id, month, year);
            if (list.size() == 0) {
                for (int i = 1; i <= days; i++) {
                    String date = year + "-" + month + "-" + i;
                    DayView dayView = new DayView();
                    DayController dayController = new DayController(dayView, date, i, false, id);
                    view.getPanelCalendar().add(dayView);
                }
            } else {
                int j = 0;
                for (int i = 1; i <= days; i++) {
                    if (list.get(j) == i) {
                        DayView dayView = new DayView();
                        System.out.println(list.get(j));
                        String date = year + "-" + month + "-" + i;
                        DayController dayController = new DayController(dayView, date, i, true, id);
                        view.getPanelCalendar().add(dayView);
                        if (j < list.size() - 1) {
                            j++;
                        }
                        System.out.println(j);
                    } else {
                        String date = year + "-" + month + "-" + i;
                        DayView dayView = new DayView();
                        DayController dayController = new DayController(dayView, date, i, false, id);
                        view.getPanelCalendar().add(dayView);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for (int i = 1; i <= days; i++) {
////            DayView dayview = new DayView();
////            dayview.getLabelNumber().setText(String.valueOf(i));
////            view.getPanelCalendar().add(dayview);
//            try {
//                WorkDayDao workDayDao = new WorkDayDao();
//                ArrayList<Integer> list = workDayDao.getDay(SessionManager.getSession().getIdEmployee(), month, year);
//                System.out.println(list.size());
////                System.out.println(list.size());
////                System.out.println(month);
////                System.out.println(year);
////                System.out.println(SessionManager.getSession().getId());
//            int j=0;
//                
//            if(list.get(j)==i){
//                DayView dayView = new DayView();
//                System.out.println(list.get(j));
//                String date = "'"+i+"-"+month+"-"+year+"'";
//                DayController dayController = new DayController(dayView,date,i,true);
//                view.getPanelCalendar().add(dayView);
//                j=j+1;
//            }
//            else{
//                String date = "'"+i+"-"+month+"-"+year+"'";
//                DayView dayView = new DayView();
//                DayController dayController = new DayController(dayView,date,i,false);
//                view.getPanelCalendar().add(dayView);
//            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("ok3");
        if (day == 7) {
            day = 0;
        }
        for (int i = 1; i <= 42 - days - day; i++) {
            Color color = Color.decode("#F0F0F0");
            DayView dayview = new DayView();
            dayview.getLabelNumber().setBackground(color);
            view.getPanelCalendar().add(dayview);
        }
        view.updateUI();
    }

    public void addEvent() {
        view.getBtnEnter().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month = Integer.valueOf((String) view.getCbxMonth().getSelectedItem());
                year = Integer.parseInt(view.getTxtYear().getText());
                render(month, year);
                System.out.println("ok");

            }
        });
    }

}
