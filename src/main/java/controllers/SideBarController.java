package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import views.admin.MenuItem;

/**
 * createAt Dec 18, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 * Quản lý menu sidebar
 */
public class SideBarController {

    JPanel panelSideBar;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private MenuItem activeMenuItem = null; // item vừa chọn
    private MenuItem parentMenu = null;

    abstract class MenuBarEvent {

        public abstract void onSelectMenuItem(MenuItem item);
    }

    public SideBarController() {

    }

    public SideBarController(JPanel panelSideBar) {
        this.panelSideBar = panelSideBar;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public JPanel getPanelSideBar() {
        return panelSideBar;
    }

    public void setPanelSideBar(JPanel panelSideBar) {
        this.panelSideBar = panelSideBar;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    // Thêm dropdown menu
    public void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            MenuItem item = menu[i];
            menuItems.add(item);
            item.setActive(false);
            panelSideBar.add(item);
            ArrayList<MenuItem> subMenus = item.getSubMenu();
            for (MenuItem subMenu : subMenus) {
                addMenu(subMenu);
                subMenu.setVisible(false);
            }
        }
    }

    public void addMenuEvent(MenuBarEvent mbe) { // Thêm event mỗi khi click vào 1 item 
        for (MenuItem menuItem : menuItems) {
            menuItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
//                    if(parentMenu.equals(activeMenuItem))
//                        parentMenu.setActive(false);
                     if (!menuItem.equals(activeMenuItem)) { // Nếu click lại thì bỏ qua
                        //activeMenuItem.setActive(false);
                      //activeMenuItem=menuItem;
                      mbe.onSelectMenuItem(menuItem);
                      parentMenu= menuItem;
                      
                    }
                    
                    setMenu(menuItem);
//                    mbe.onSelectMenuItem(menuItem);

                }
            });
        }
    }

    public void closeSubMenu(MenuItem parrent) { // Đóng menu con
        if (!parrent.isActive()) {
            //Nếu cha chưa chọn thì chắc chắn con chưa chọn
            return;
        }
        for (MenuItem child : parrent.getSubMenu()) {
            if (child.hasSubMenu()) {
                closeSubMenu(child);
            }
            child.setActive(false); // Nếu đang active thì bỏ đi
            child.setVisible(false); // Nếu 
        }
    }

    public void setMenu(MenuItem item) {//Chọn menu
//        if (!item.equals(activeMenuItem) && activeMenuItem != null && !activeMenuItem.hasChild(item)) { // Đóng menu cũ nếu không phải cha menu vừachonj
//
//            // Đóng menu con lại
//            MenuItem root = null;
//            do {
//                root = activeMenuItem.getParentMenu();
//            } while (root != null);
//            closeSubMenu(activeMenuItem);
//            activeMenuItem.setActive(false); // Bỏ chọn
//        }

        if (item.isActive()) {//Nếu item đã được chọn
            // Đóng menu con lại
            parentMenu=null;
            closeSubMenu(item);
            item.setActive(false); // Bỏ chọn

        } else {// Item chưa được chọn
            // Hiển thị menu con
            for (MenuItem subItem : item.getSubMenu()) {
                subItem.setVisible(true);
            }
            item.setActive(true); // Chọn
        }
        activeMenuItem = item;

    }

}
