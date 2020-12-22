package controllers;

import controllers.admin.CustomerManagerController;
import controllers.admin.EmployeeManagerController;
import controllers.admin.FoodCategoryManagerController;
import controllers.admin.FoodItemManagerController;
import controllers.admin.OrderManagerController;
import controllers.admin.TableManagerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import main.Runner;
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
            customerManagerController = new CustomerManagerController();

    HomeView homePane = new HomeView();
    ManagerPaneView employeeManagerPane = new EmployeeManagerView(), // View
            tableManagerPane = new TableManagerView(),
            foodCategoryManagerView = new FoodCategoryManagerView(),
            foodItemManagerView = new FoodItemManagerView(),
            orderManagerView = new OrderManagerView(),
            customerManagerPane = new CustomerManagerView();

    JPanel[] cards = {homePane, employeeManagerPane, tableManagerPane, customerManagerPane, foodCategoryManagerView, orderManagerView, foodItemManagerView};

    SideBarController sideBarController = new SideBarController();
    SideBarController.MenuBarEvent menuBarEvent = sideBarController.new MenuBarEvent() { // 
        @Override
        public void onSelectMenuItem(MenuItem item) {
            onMenuChange(item);
        }
    };

    public AdminDashboardController(AdminDashboardView view) {
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
        menuQLDH.addSubMenu(new MenuItem("QLS", im.getIcon("truck_25px.png"), "Quản lý giao hàng"));
        MenuItem menuTKNV = new MenuItem("TKNV", im.getIcon("user_25px.png"), "Thống kê nhân viên");
        menuTK.addSubMenu(menuTKNV);
        menuTK.addSubMenu(new MenuItem("TKHH", null, "Thống kê hàng hóa"));
        menuTK.addSubMenu(new MenuItem("TKDT", null, "Thống kê doanh thu"));
        menuTKNV.addSubMenu(new MenuItem("TKDN", null, "Thống kê phiên làm việc"));
        sideBarController.addMenu(menuQLNV, menuQLHH, menuQLDH, menuTK);
        sideBarController.addMenuEvent(menuBarEvent);
    }

    // Tạo sự kiện
    private void addEvent() {
//        for (MenuItem menuItem : view.getMenuItems()) {
//            menuItem.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    menuItem.collapseSubMenu();
//                    onMenuChange(menuItem);
//                }
//            });
//        }

        view.getBtnLogout().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                view.dispose();
                Runner.setSession(null);
                new LoginController(new LoginView());
            }
        });
    }

    private void onMenuChange(MenuItem item) {
        ManagerPaneView pnl = null; //View Panel
        ManagerController mc = null; //Controller Panel
        System.out.println("Chon menu: " + item.getId());
        switch (item.getId()) {
            case "QLNV":
                pnl = employeeManagerPane;
                mc = employeeManagerController;
                break;
            case "QLDDH":
                pnl = orderManagerView;
                mc = orderManagerController;
                break;
            case "QLB":
                pnl = tableManagerPane;
                mc = tableManagerController;
                break;
            case "QLKH":
                pnl = customerManagerPane;
                mc = customerManagerController;
                break;
            case "QLLM":
                pnl = foodCategoryManagerView;
                mc = foodCategoryManagerController;
                break;
            case "QLMA":
                pnl = foodItemManagerView;
                mc = foodItemManagerController;
                break;
            case "QLHH":
            case "QLDH":
            case "TK":
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
