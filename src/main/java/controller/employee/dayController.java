/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import dao.OrderDao;
import views.employee.dayView;

/**
 *
 * @author Admin
 */
public class dayController {
    
    dayView view;

    public dayController(dayView view) {
        this.view = view;
    }
    public dayController(dayView view,String date){
        this.view =view;
    }

    public void addEvent() {
        view.getLabelNumber().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    OrderDao oderDao = new OrderDao();
                    
                } catch (Exception e) {
                }
            }
        });
    }
    

    public dayView getView() {
        return view;
    }

    public void setView(dayView view) {
        this.view = view;
    }

}
