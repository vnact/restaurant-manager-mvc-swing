/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controller.employee.inforController;
import controllers.admin.OrderManagerController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.SessionManager;
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

    public EmployeeDashboardController(EmployeeDashboardView view) {
        this.view = view;
        sideBarController.setPanelSideBar(view.getPanelSideBar());
        view.setVisible(true);
        initMenu();
        addEvent();
        Employee session = SessionManager.getSession().getEmployee();
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
        sideBarController.addMenuEvent(this::onMenuChange);
    }

    public void addEvent() {
        view.getBtnLogout().addActionListener(evt -> {
            int confirm = JOptionPane.showConfirmDialog(view, "Bạn thực sự muốn đăng xuất?");
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            try {
                SessionManager.update();// Đẵng xuất
            } catch (SQLException ex) {
                view.showError(ex);
            }
            view.dispose();
            new LoginController(new LoginView());
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
