/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.admin;

import dao.FoodCategoryDao;
import dao.StatisticalDao;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import models.FoodCategory;
import models.Statistical;
import views.admin.StatisticalFoodView;

/**
 *
 * @author Admin
 */
public class StatisticalFoodController {

    private StatisticalFoodView view;

    public StatisticalFoodController() {

    }

    public void init() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        view.getEndDate().setCalendar(c);
        c.add(Calendar.DATE, -30);
        view.getStartDate().setCalendar(c);
        try {
            view.getCbxCategory().removeAllItems();
            FoodCategoryDao foodDao = new FoodCategoryDao();
            ArrayList<FoodCategory> List = foodDao.getAll();
            for (FoodCategory f : List) {
                view.getCbxCategory().addItem(f.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        render();
        addEvent();
    }

    public void setView(StatisticalFoodView view) {
        this.view = view;
    }

    public void addEvent() {

        view.getBtnEnter().addActionListener((e) -> {
            render();
        });

    }

    public void render() {

        Date startDate = view.getStartDate().getDate();
        Date endDate = view.getEndDate().getDate();
        if (startDate.after(endDate)) {
            view.showError("Ngày bắt đầu không thể sau ngày kết thúc");
            return;
        }
        int idCategoryFood = view.getCbxCategory().getSelectedIndex() + 1;
        try {
            StatisticalDao statisticalDao = new StatisticalDao();
            ArrayList<Statistical.ProductIncome> list = statisticalDao.getQuantityItemByCategory(new Timestamp(startDate.getTime()), new Timestamp(endDate.getTime()), idCategoryFood);
            view.setTableData(list);
        } catch (Exception e) {
            //System.out.println("lõi cmnr");
            e.printStackTrace();
        }

    }
}
