/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import java.awt.Color;
import java.time.LocalDate;
import test.getDayOfMonth;
import views.employee.CalendarView;
import views.employee.DayView;

/**
 *
 * @author Admin
 */
public class CalendarController {
    CalendarView view ;
    int month;//= LocalDate.now().getMonthValue();
    int year;// = LocalDate.now().getYear();
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
        if (day < 7) {
            for (int i = 0; i < day; i++) {
                Color color = Color.decode("#F0F0F0");
                DayView dayview = new DayView();
                dayview.getLabelNumber().setBackground(color);
                view.getPanelCalendar().add(dayview);
            }
        }
        for (int i = 1; i <= days; i++) {
            DayView dayview = new DayView();
            dayview.getLabelNumber().setText(String.valueOf(i));
            view.getPanelCalendar().add(dayview);
        }
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
    
    public void addEvent(){
        view.getBtnEnter().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month = Integer.valueOf((String) view.getCbxMonth().getSelectedItem());
                year = Integer.parseInt(view.getTxtYear().getText());
                render(month, year);
            }
        });
    }
    
    
}
