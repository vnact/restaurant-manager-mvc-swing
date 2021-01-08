package controllers.popup;

import dao.FoodCategoryDao;
import dao.FoodItemDao;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import models.FoodCategory;
import models.FoodItem;
import utils.ImageManager;
import utils.StringToSlug;
import views.ChooseImageView;
import views.popup.FoodItemPopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 * Popup controller mẫu
 */
public class FoodItemPopupController {

    FoodItemDao foodItemDao = new FoodItemDao();
    FoodCategoryDao foodCategoryDao = new FoodCategoryDao();
    ChooseImageView chooseImageView = new ChooseImageView();
    ImageManager imageManager = new ImageManager();
    String resourcesPath = getClass().getResource("/images/").getPath();
    JFrame previousView;

    private ActionListener eventShowChooseFileDialog(FoodItemPopupView view) {
        return evt -> {
            int otp = chooseImageView.showOpenDialog(view);
            switch (otp) {
                case JFileChooser.APPROVE_OPTION:
                    File file = chooseImageView.getSelectedFile();
                    BufferedImage bi;
                    try {
                        bi = ImageIO.read(file);
                        String name = StringToSlug.convert(view.getTxtName().getText());
                        String pth = imageManager.saveImage(bi, name);
                        view.getTxtUrlImage().setText(pth);
                        renderPreviewImage(view);
                    } catch (Exception e) {
                        view.showError(e);
                    }
                    break;
                case JFileChooser.CANCEL_OPTION:
                    view.getTxtUrlImage().setText("");
                    break;

            }
        };
    }

    private void renderPreviewImage(FoodItemPopupView view) throws Exception {
        String urlImage = view.getTxtUrlImage().getText();
        ImageIcon icon = urlImage.isEmpty() ? null : imageManager.getImage(urlImage);
        view.getLbPreviewImage().setIcon(icon);
        view.pack();
    }

    private void initComboBox(FoodItemPopupView view) { //Khởi tạo danh mục loai mon
        try {
            for (FoodCategory foodCategory : foodCategoryDao.getAll()) {
                view.getFoodCategoryComboBoxModel().addElement(foodCategory);
            }
        } catch (Exception e) {
        }
    }

    public void add(FoodItemPopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        initComboBox(view);
        view.getBtnChooseImage().addActionListener(eventShowChooseFileDialog(view));
        view.getBtnOK().addActionListener(evt -> {
            try {
                addFoodItem(view);
                view.dispose();
                view.showMessage("Thêm món ăn thành công!");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public boolean isExistsImage(String imagePath) {
        try {
            if (imagePath.isEmpty()) {
                return false;
            }
            File f = new File(resourcesPath + imagePath);
            return f.exists() && !f.isDirectory();
        } catch (Exception e) {
            return false;
        }
    }

    public void edit(FoodItemPopupView view, FoodItem foodItem, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        initComboBox(view);
        view.getLbTitle().setText("Sửa món ăn - " + foodItem.getId());
        view.getBtnOK().setText("Cập nhật");

        if (foodItem == null) {
            view.showError("Món không tồn tại");
        }
        view.getTxtName().setText(foodItem.getName());
        view.getTxtDescription().setText(foodItem.getDescription());
        view.getTxtUrlImage().setText(foodItem.getUrlImage());
        view.getTxtUnitName().setText(foodItem.getUnitName());
        view.getTxtUnitPrice().setText(foodItem.getUnitPrice() + "");

        FoodCategory fc = new FoodCategory();
        fc.setId(foodItem.getIdCategory());
        view.getCboCategory().setSelectedItem(fc);
        if (isExistsImage(foodItem.getUrlImage())) {
            view.getTxtUrlImage().setText(foodItem.getUrlImage());
        } else {
            view.getTxtUrlImage().setText("");
        }
        try {
            renderPreviewImage(view);
        } catch (Exception e) {
            ec.onError(e);
        }
        view.getBtnChooseImage().addActionListener(eventShowChooseFileDialog(view));
        view.getBtnOK().addActionListener(evt -> {
            try {
                editFoodItem(view, foodItem);
                view.dispose();
                view.showMessage("Sửa món ăn thành công!");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public boolean addFoodItem(FoodItemPopupView view) throws Exception {
        FoodItem foodItem = new FoodItem();
        FoodCategory selectCategory = (FoodCategory) view.getCboCategory().getSelectedItem();
        String name = view.getTxtName().getText(), unitName = view.getTxtUnitName().getText(),
                unitPrice = view.getTxtUnitPrice().getText(), urlImage = view.getTxtUrlImage().getText(),
                description = view.getTxtDescription().getText();
        if (name.isEmpty() || unitName.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        foodItem.setName(name);
        foodItem.setDescription(unitName);
        foodItem.setUnitName(unitName);
        foodItem.setUnitPrice(Integer.parseInt(unitPrice));
        foodItem.setUrlImage(urlImage);
        foodItem.setDescription(description);
        foodItem.setIdCategory(selectCategory.getId());
        foodItemDao.save(foodItem);
        return true;
    }

    public boolean editFoodItem(FoodItemPopupView view, FoodItem foodItem) throws Exception {
        FoodCategory selectCategory = (FoodCategory) view.getCboCategory().getSelectedItem();
        String name = view.getTxtName().getText(), unitName = view.getTxtUnitName().getText(),
                unitPrice = view.getTxtUnitPrice().getText(), urlImage = view.getTxtUrlImage().getText(),
                description = view.getTxtDescription().getText();
        if (name.isEmpty() || unitName.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        foodItem.setName(name);
        foodItem.setDescription(description);
        foodItem.setUnitName(unitName);
        foodItem.setUnitPrice(Integer.parseInt(unitPrice));
        foodItem.setUrlImage(urlImage);
        foodItem.setDescription(description);
        foodItem.setIdCategory(selectCategory.getId());
        foodItemDao.update(foodItem);
        return true;
    }

//    public void add(FoodItemManagerController parrent, FoodItemPopupView view) {
//        setView(view);
//        initComboBox(view);
//        view.getBtnChooseImage().addActionListener(eventShowChooseFileDialog(view));
//        view.getBtnOK().addActionListener(evt -> {
//            try {
//                boolean addSuccess = addFoodItem();
//                if (addSuccess) {
//                    view.dispose();
//                    parrent.updateData();
//                    view.showMessage("Thêm món ăn thành công!");
//                }
//            } catch (Exception ex) {
//                view.showError(ex);
//            }
//        });
//
//    }
//
//    public void edit(FoodItemManagerController parrent, FoodItemPopupView view, FoodItem foodItem) {
//        setView(view);
//        initComboBox(view);
//        view.getLbTitle().setText("Sửa món ăn - " + foodItem.getId());
//        view.getBtnOK().setText("Cập nhật");
//
//        if (foodItem == null) {
//            view.showError("Món không tồn tại");
//        }
//        try {
//            view.getTxtName().setText(foodItem.getName());
//            view.getTxtDescription().setText(foodItem.getDescription());
//            view.getTxtUrlImage().setText(foodItem.getUrlImage());
//            view.getTxtUnitName().setText(foodItem.getUnitName());
//            view.getTxtUnitPrice().setText(foodItem.getUnitPrice() + "");
//            FoodCategory fc = new FoodCategory();
//            fc.setId(foodItem.getIdCategory());
//            view.getCboCategory().setSelectedItem(fc);
//            if (!foodItem.getUrlImage().isEmpty()) {
//                File f = new File(resourcesPath + foodItem.getUrlImage());
//                if (f.exists() && !f.isDirectory()) {
//                    view.getTxtUrlImage().setText(foodItem.getUrlImage());
//                } else {
//                    view.getTxtUrlImage().setText("");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        view.getBtnChooseImage().addActionListener(eventShowChooseFileDialog(view));
//        view.getBtnOK().addActionListener(evt -> {
//            try {
//                boolean editSuccess = editFoodItem(foodItem);
//                if (editSuccess) {
//                    view.dispose();
//                    parrent.updateData();
//                    view.showMessage("Sửa món ăn thành công!");
//                }
//            } catch (Exception ex) {
//                view.showError(ex);
//            }
//        });
//
//    }
//
//    public boolean addFoodItem() throws Exception {
//        FoodItemPopupView view = (FoodItemPopupView) this.getView();
//        FoodItem foodItem = new FoodItem();
//        FoodCategory selectCategory = (FoodCategory) view.getCboCategory().getSelectedItem();
//        String name = view.getTxtName().getText(), unitName = view.getTxtUnitName().getText(),
//                unitPrice = view.getTxtUnitPrice().getText(), urlImage = view.getTxtUrlImage().getText(),
//                description = view.getTxtDescription().getText();
//        if (name.isEmpty() || unitName.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
//            throw new Exception("Vui lòng điền đầy đủ thông tin");
//        }
//        foodItem.setName(name);
//        foodItem.setDescription(unitName);
//        foodItem.setUnitName(unitName);
//        foodItem.setUnitPrice(Integer.parseInt(unitPrice));
//        foodItem.setUrlImage(urlImage);
//        foodItem.setDescription(description);
//        foodItem.setIdCategory(selectCategory.getId());
//        foodItemDao.save(foodItem);
//        return true;
//    }
//
//    public boolean editFoodItem(FoodItem foodItem) throws Exception {
//        FoodItemPopupView view = (FoodItemPopupView) this.getView();
//        FoodCategory selectCategory = (FoodCategory) view.getCboCategory().getSelectedItem();
//        String name = view.getTxtName().getText(), unitName = view.getTxtUnitName().getText(),
//                unitPrice = view.getTxtUnitPrice().getText(), urlImage = view.getTxtUrlImage().getText(),
//                description = view.getTxtDescription().getText();
//        if (name.isEmpty() || unitName.isEmpty() || unitPrice.isEmpty() || selectCategory == null) {
//            throw new Exception("Vui lòng điền đầy đủ thông tin");
//        }
//        foodItem.setName(name);
//        foodItem.setDescription(description);
//        foodItem.setUnitName(unitName);
//        foodItem.setUnitPrice(Integer.parseInt(unitPrice));
//        foodItem.setUrlImage(urlImage);
//        foodItem.setDescription(description);
//        foodItem.setIdCategory(selectCategory.getId());
//        foodItemDao.update(foodItem);
//        return true;
//    }
}
