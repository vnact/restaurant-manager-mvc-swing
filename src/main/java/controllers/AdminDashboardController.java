package controllers;

import controllers.admin.CustomerManagerController;
import controllers.admin.EmployeeManagerController;
import controllers.admin.FoodCategoryManagerController;
import controllers.admin.FoodItemManagerController;
import controllers.admin.OrderManagerController;
import controllers.admin.ShipmentManagerController;
import controllers.admin.StatisticalController;
import controllers.admin.StatisticalFoodController;
import controllers.admin.TableManagerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.SessionManager;
import models.Employee;
import utils.IconManager;
import views.AdminDashboardView;
import views.LoginView;
import views.admin.CustomerManagerView;
import views.admin.EmployeeManagerView;
import views.admin.FoodCategoryManagerView;
import views.admin.FoodItemManagerView;
import views.admin.HomeView;
import views.admin.ManagerPaneView;
import views.admin.MenuItem;
import views.admin.OrderManagerView;
import views.admin.ShipmentManagerView;
import views.admin.StatisticalFoodView;
import views.admin.StatisticalView;
import views.admin.TableManagerView;

/**
 * createAt Dec 15, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class AdminDashboardController {

    private AdminDashboardView view;
    ManagerController employeeManagerController = new EmployeeManagerController(), // Controller
            tableManagerController = new TableManagerController(),
            foodCategoryManagerController = new FoodCategoryManagerController(),
            foodItemManagerController = new FoodItemManagerController(),
            orderManagerController = new OrderManagerController(),
            shipmentManagerController = new ShipmentManagerController(),
            customerManagerController = new CustomerManagerController();
    StatisticalController statisticalController = new StatisticalController();
    StatisticalFoodController statisticalFoodController = new StatisticalFoodController();

    HomeView homePane = new HomeView();
    ManagerPaneView employeeManagerPane = new EmployeeManagerView(), // View
            tableManagerPane = new TableManagerView(),
            foodCategoryManagerView = new FoodCategoryManagerView(),
            foodItemManagerView = new FoodItemManagerView(),
            orderManagerView = new OrderManagerView(),
            shipmentManagerView = new ShipmentManagerView(),
            customerManagerPane = new CustomerManagerView();
    StatisticalView statisticalView = new StatisticalView();
    StatisticalFoodView statisticalFoodView = new StatisticalFoodView();

    JPanel[] cards = {
        homePane, employeeManagerPane, tableManagerPane, customerManagerPane,
        foodCategoryManagerView, orderManagerView, foodItemManagerView, shipmentManagerView,
        statisticalView, statisticalFoodView
    };

    SideBarController sideBarController = new SideBarController();

    public AdminDashboardController(AdminDashboardView view) {
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

    public AdminDashboardView getView() {
        return view;
    }

    public void setView(AdminDashboardView view) {
        this.view = view;
        sideBarController.setPanelSideBar(view.getPanelSideBar());
    }

    private void initMenu() {
        IconManager im = new IconManager();
        MenuItem menuQLNV = new MenuItem("QLNV", im.getIcon("user_groups_25px.png"), "Quản lý nhân viên");
        MenuItem menuQLHH = new MenuItem("QLHH", im.getIcon("cardboard_box_25px.png"), "Quản lý hàng hóa");
        MenuItem menuQLDH = new MenuItem("QLDH", im.getIcon("shopping_cart_25px.png"), "Quản lý đặt hàng");
        MenuItem menuTK = new MenuItem("TK", im.getIcon("increase_25px.png"), "Thống kê");
        menuQLHH.addSubMenu(new MenuItem("QLLM", null, "Quản lý loại món"));
        menuQLHH.addSubMenu(new MenuItem("QLMA", im.getIcon("food_25px.png"), "Quản lý món ăn"));
        menuQLDH.addSubMenu(new MenuItem("QLB", im.getIcon("table_25px.png"), "Quản lý bàn"));
        menuQLDH.addSubMenu(new MenuItem("QLKH", im.getIcon("technical_support_25px.png"), "Quản lý khách hàng"));
        menuQLDH.addSubMenu(new MenuItem("QLDDH", im.getIcon("purchase_order_25px.png"), "Quản lý đơn đặt hàng"));
        menuQLDH.addSubMenu(new MenuItem("QLGH", im.getIcon("truck_25px.png"), "Quản lý giao hàng"));
        MenuItem menuTKNV = new MenuItem("TKNV", im.getIcon("user_25px.png"), "Thống kê nhân viên");
        menuTK.addSubMenu(menuTKNV);
        menuTK.addSubMenu(new MenuItem("TKHH", null, "Thống kê hàng hóa"));
        menuTK.addSubMenu(new MenuItem("TKDT", null, "Thống kê doanh thu"));
        menuTKNV.addSubMenu(new MenuItem("TKDN", null, "Thống kê phiên làm việc"));
        sideBarController.addMenu(menuQLNV, menuQLHH, menuQLDH, menuTK);
        sideBarController.addMenuEvent(this::onMenuChange);
    }

    // Tạo sự kiện
    private void addEvent() {
        view.getBtnLogout().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
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
            }
        });
    }

    private void onMenuChange(MenuItem item) {
        ManagerPaneView pnl = null; //View Panel
        ManagerController mc = null; //Controller Panel
        System.out.println("Chon menu: " + item.getId());
        switch (item.getId()) {
            case "QLNV"://Nhân viên
                pnl = employeeManagerPane;
                mc = employeeManagerController;
                break;
            case "QLDDH"://Đơn đặt hàng
                pnl = orderManagerView;
                mc = orderManagerController;
                break;
            case "QLB"://Quản lý bàn
                pnl = tableManagerPane;
                mc = tableManagerController;
                break;
            case "QLKH"://Quản lý khách hàng
                pnl = customerManagerPane;
                mc = customerManagerController;
                break;
            case "QLLM"://Quản lý loại món
                pnl = foodCategoryManagerView;
                mc = foodCategoryManagerController;
                break;
            case "QLMA"://Quản lý món ăn
                pnl = foodItemManagerView;
                mc = foodItemManagerController;
                break;
            case "QLGH"://Quản lý giao hàng
                pnl = shipmentManagerView;
                mc = shipmentManagerController;
                break;
            case "QLHH":

            case "QLDH":
                break;
            case "TK":
                view.setPanel(statisticalView);
                statisticalController.setView(statisticalView);
                statisticalController.addEvent();
                statisticalController.initData();
                break;
            case "TKHH":
                view.setPanel(statisticalFoodView);
                statisticalFoodController.setView(statisticalFoodView);
                statisticalFoodController.init();
                break;
            default:
                view.setPanel(homePane);
                break;
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
