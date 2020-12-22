package controllers.popup;

import dao.FoodItemDao;
import java.text.DecimalFormat;
import models.FoodItem;
import models.OrderItem;
import views.popup.ToppingPopupView;

/**
 * createAt Dec 21, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class ToppingPopupController {

    FoodItemDao foodItemDao = new FoodItemDao();
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    interface Event {

        public abstract void onSelect(OrderItem item);
    }

    public void add(ToppingPopupView view, FoodItem foodItem, Event event) {
        view.setVisible(true);
        view.getLbFoodName().setText(foodItem.getName());
        view.getSpnFoodPrice().setValue(foodItem.getUnitPrice());
        try {
            //Lấy danh sách topping
            if (foodItem.getIdCategory() == 2) {
                //Nếu là trà sữa thì hiện topping
                for (FoodItem topping : foodItemDao.getByIdCategory(4)) {
                    view.getCboTopping().addItem(topping);
                }
            } else {
                view.getLbTopping().setVisible(false);
                view.getCboTopping().setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateAmount(view);
        view.getBtnOK().addActionListener(evt -> {
            event.onSelect(addItem(foodItem, view));
            view.dispose();
        });
        view.getBtnCancel().addActionListener(evt -> {
            view.dispose();
        });
        view.getSpnFoodPrice().addChangeListener(evt -> {
            updateAmount(view);
        });
        view.getSpnQuantity().addChangeListener(evt -> {
            updateAmount(view);
        });
        view.getCboTopping().addActionListener(evt -> {
            updateAmount(view);
        });
    }

    private void updateAmount(ToppingPopupView view) {
        int amount = (int) view.getSpnFoodPrice().getValue();
        FoodItem topping = (FoodItem) view.getCboTopping().getSelectedItem();
        if (topping != null) {
            amount += topping.getUnitPrice();
        }
        int quantity = (int) view.getSpnQuantity().getValue();
        amount *= quantity;
        view.getLbAmount().setText(formatter.format(amount));
    }

    public OrderItem addItem(FoodItem foodItem, ToppingPopupView view) {
        OrderItem orderItem = new OrderItem();
        try {
            orderItem.setFoodItem(foodItem);
            orderItem.setFoodPrice((int) view.getSpnFoodPrice().getValue());
            orderItem.setToppingItem((FoodItem) view.getCboTopping().getSelectedItem());
            orderItem.setToppingPrice(orderItem.getToppingItem().getUnitPrice());
            orderItem.setQuantity((int) view.getSpnQuantity().getValue());
            return orderItem;
        } catch (Exception e) {
            return orderItem;
        }
    }
}
