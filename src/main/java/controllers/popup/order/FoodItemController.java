package controllers.popup.order;

import dao.FoodCategoryDao;
import dao.FoodItemDao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import models.FoodCategory;
import models.FoodItem;
import views.popup.order.FoodCategoryPane;
import views.popup.order.FoodItemPane;

/**
 * createAt Dec 21, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class FoodItemController {

    FoodCategoryDao foodCategoryDao = new FoodCategoryDao();
    FoodItemDao foodItemDao = new FoodItemDao();

    public interface Event {

        public abstract void onChange(JPanel pnl);
    }

    public FoodItemController() {
    }

    public void renderCategory(JPanel panelFoodCategory, Event event) throws Exception {
        panelFoodCategory.removeAll();
        for (FoodCategory foodCategory : foodCategoryDao.getAll()) {
            FoodCategoryPane pnl = new FoodCategoryPane(foodCategory);
            panelFoodCategory.add(pnl);
            pnl.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    event.onChange(pnl);
                }
            });
        }
        panelFoodCategory.updateUI();
    }

    public void renderFoodItem(JPanel panelFoodItem, int idCategory, Event event) throws Exception {
        panelFoodItem.removeAll();
        for (FoodItem foodItem : foodItemDao.getByIdCategory(idCategory)) {
            FoodItemPane pnl = new FoodItemPane(foodItem);
            panelFoodItem.add(pnl);
            pnl.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    event.onChange(pnl);
                }
            });
        }
        panelFoodItem.updateUI();
    }

}
