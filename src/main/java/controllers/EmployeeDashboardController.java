/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controller.employee.inforController;
import controllers.admin.OrderManagerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import main.Runner;
import models.Employee;
import utils.IconManager;
import views.EmployeeDashboardView;
import views.LoginView;
import views.admin.HomeView;
import views.admin.MenuItem;
import views.admin.OrderManagerView;
import views.employee.inforView;

/**
 *
 * @author Admin
 */
public class EmployeeDashboardController {

    private EmployeeDashboardView view;
    HomeView homePane = new HomeView();
    inforController ic = new inforController();
    inforView iv = new inforView();
    OrderManagerController orderManagerController = new OrderManagerController();
    OrderManagerView orderManagerPaneView = new OrderManagerView();
    SideBarController sideBarController = new SideBarController();
    JPanel[] cards = {homePane, orderManagerPaneView, iv};
    SideBarController.MenuBarEvent menuBarEvent = sideBarController.new MenuBarEvent() { // 
        @Override
        public void onSelectMenuItem(MenuItem item) {
            onMenuChange(item);
        }
    };

    public EmployeeDashboardController(EmployeeDashboardView view) {
        this.view = view;
        sideBarController.setPanelSideBar(view.getPanelSideBar());
        view.setVisible(true);
        initMenu();
        addEvent();
        Employee session = Runner.getSession();
        if (session != null) {
            view.getLbName().setText(session.getName());

        }
        view.setCards(cards);
        view.setPanel(homePane);
    }

    public EmployeeDashboardView getView() {
        return view;
    }

    public void setView(EmployeeDashboardView view) {
        this.view = view;
        sideBarController.setPanelSideBar(view.getPanelSideBar());
    }

    public void initMenu() {
        IconManager im = new IconManager();
        MenuItem inforE = new MenuItem("IE", im.getIcon("futures_25px.png"), "Thông tin");
        MenuItem menuBH = new MenuItem("BH", im.getIcon("shopping_cart_25px.png"), "Tạo hóa đơn");
        sideBarController.addMenu(menuBH, inforE);
        sideBarController.addMenuEvent(menuBarEvent);
    }

    public void addEvent() {
        view.getBtnLogout().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                view.dispose();
                Runner.setSession(null);
                new LoginController(new LoginView());
            }
        });
    }

    public void onMenuChange(MenuItem item) {
        switch (item.getId()) {
            case "BH":
//                ManagerController mc = orderManagerController;
//                ManagerPaneView pnl = orderManagerPaneView;
                view.setPanel(orderManagerPaneView);
                orderManagerController.setView(orderManagerPaneView);
                orderManagerController.updateDataByEmployee();
                break;
            case "IE":
                view.setPanel(iv);
                ic.setView(iv);
                break;

            default:
                view.setPanel(homePane);
        }
    }
}
