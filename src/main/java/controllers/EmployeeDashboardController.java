/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controller.employee.InforController;
import controllers.admin.CustomerManagerController;
import controllers.admin.OrderManagerController;
import controllers.admin.ShipmentManagerController;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.SessionManager;
import models.Employee;
import utils.IconManager;
import views.EmployeeDashboardView;
import views.LoginView;
import views.admin.CustomerManagerView;
import views.admin.HomeView;
import views.admin.ManagerPaneView;
import views.admin.MenuItem;
import views.admin.OrderManagerView;
import views.admin.ShipmentManagerView;
import views.employee.InforView;

/**
 *
 * @author Admin
 */
public class EmployeeDashboardController {

    private EmployeeDashboardView view;
    HomeView homePane = new HomeView();
    InforController ic = new InforController();
    InforView iv = new InforView();
    ManagerController orderManagerController = new OrderManagerController(),
            shipmentManagerController = new ShipmentManagerController(),
            customerManagerController = new CustomerManagerController();
    ManagerPaneView orderManagerPaneView = new OrderManagerView(),
            shipmentManagerView = new ShipmentManagerView(),
            customerManagerPane = new CustomerManagerView();
    SideBarController sideBarController = new SideBarController();
    JPanel[] cards = {homePane, orderManagerPaneView, customerManagerPane, shipmentManagerView, iv};

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
        MenuItem menuKH = new MenuItem("QLKH", im.getIcon("technical_support_25px.png"), "Quản lý khách hàng");
        MenuItem menuGH = new MenuItem("QLGH", im.getIcon("truck_25px.png"), "Quản lý giao hàng");
        sideBarController.addMenu(menuBH, menuKH, menuGH, inforE);
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
        ManagerPaneView pnl = null; //View Panel
        ManagerController mc = null; //Controller Panel
        System.out.println("Chon menu: " + item.getId());
        switch (item.getId()) {
            case "BH":
                mc = orderManagerController;
                pnl = orderManagerPaneView;
                break;
            case "IE":
                view.setPanel(iv);
                ic.setView(iv);
                break;
            case "QLKH":
                mc = customerManagerController;
                pnl = customerManagerPane;
                break;
            case "QLGH":
                mc = shipmentManagerController;
                pnl = shipmentManagerView;
                break;
            default:
                view.setPanel(homePane);
        }
        if (pnl != null) {
            view.setPanel(pnl);
            if (mc != null) {
                mc.setView(pnl);
                mc.updateData();
            }
        }
    }
}
