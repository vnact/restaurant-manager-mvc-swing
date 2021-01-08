package controllers.popup;

import dao.CustomerDao;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JFrame;
import models.Customer;
import views.popup.CustomerPopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class CustomerPopupController {

    CustomerDao customerDao = new CustomerDao();
    JFrame previousView;

    public void add(CustomerPopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getBtnOK().addActionListener(evt -> {
            try {
                addCustomer(view);
                view.dispose();
                view.showMessage("Thêm khách hàng thành công");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });
    }

    public void edit(CustomerPopupView view, Customer customer, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getLbTitle().setText("Sửa khách hàng - " + customer.getId());
        view.getTxtName().setText(customer.getName());
        view.getTxtPhoneNumber().setText(customer.getPhoneNumber());
        view.getTxtAddress().setText(customer.getAddress());
        if (customer.getBirthday() != null) {
            view.getCbUnknownBirthday().setSelected(false);
            view.getSpnBirthday().setValue(new Date(customer.getBirthday().getTime()));
        } else {
            view.getCbUnknownBirthday().setSelected(true);
        }
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(evt -> {
            try {
                editCustomer(view, customer);
                view.dispose();
                view.showMessage("Sửa thông tin khách hàng thành công");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public void addCustomer(CustomerPopupView view) throws Exception {
        String name = view.getTxtName().getText(), address = view.getTxtAddress().getText(), phoneNumber = view.getTxtPhoneNumber().getText();
        if (phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        Customer c = new Customer();
        c.setAddress(address);
        c.setName(name);
        c.setPhoneNumber(phoneNumber);
        if (!view.getCbUnknownBirthday().isSelected()) {
            Date dateUtil = (Date) view.getSpnBirthday().getValue();
            c.setBirthday(new Timestamp(dateUtil.getTime()));
        }
        customerDao.save(c);
        return;
    }

    public boolean editCustomer(CustomerPopupView view, Customer c) throws Exception {
        String name = view.getTxtName().getText(), address = view.getTxtAddress().getText(), phoneNumber = view.getTxtPhoneNumber().getText();
        if (phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        c.setAddress(address);
        c.setName(name);
        c.setPhoneNumber(phoneNumber);
        if (!view.getCbUnknownBirthday().isSelected()) {
            Date dateUtil = (Date) view.getSpnBirthday().getValue();
            c.setBirthday(new Timestamp(dateUtil.getTime()));
        }
        customerDao.update(c);
        return true;
    }

//    public void add(CustomerManagerController parrent, CustomerPopupView view) {
//        setView(view);
//        view.getBtnOK().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                try {
//                    boolean addSuccess = addCustomer();
//                    if (addSuccess) {
//                        view.dispose();
//                        parrent.updateData();
//                        view.showMessage("Thêm khách hàng thành công!");
//                    }
//                } catch (Exception ex) {
//                    parrent.getView().showError(ex);
//                }
//            }
//        });
//
//    })
//    public void edit(CustomerManagerController parrent, CustomerPopupView view, Customer customer) {
//        setView(view);
//        view.getLbTitle().setText("Sửa khách hàng - " + customer.getId());
//        view.getTxtName().setText(customer.getName());
//        view.getTxtPhoneNumber().setText(customer.getPhoneNumber());
//        if (customer.getBirthday() != null) {
//            view.getCbUnknownBirthday().setSelected(false);
//            view.getSpnBirthday().setValue(new Date(customer.getBirthday().getTime()));
//        } else {
//            view.getCbUnknownBirthday().setSelected(true);
//        }
//        view.getBtnOK().setText("Cập nhật");
//        view.getBtnOK().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                try {
//                    boolean editSuccess = editCustomer(customer);
//                    if (editSuccess) {
//                        view.dispose();
//                        parrent.updateData();
//                        view.showMessage("Sửa khách hàng thành công!");
//                    }
//                } catch (Exception ex) {
//                    parrent.getView().showError(ex);
//                }
//            }
//        });
//
//    }
//    public boolean addCustomer() throws Exception {
//        CustomerPopupView view = (CustomerPopupView) this.getView();
//        String name = view.getTxtName().getText(), address = view.getTxtAddress().getText(), phoneNumber = view.getTxtPhoneNumber().getText();
//        if (phoneNumber.isEmpty()) {
//            throw new Exception("Vui lòng điền đầy đủ thông tin");
//        }
////        if (customerDao.findByUsername(username) != null) {
////            throw new Exception("Tài khoản đã tồn tại");
////        }
//        Customer c = new Customer();
//        c.setAddress(address);
//        c.setName(name);
//        c.setPhoneNumber(phoneNumber);
//        if (!view.getCbUnknownBirthday().isSelected()) {
//            Date dateUtil = (Date) view.getSpnBirthday().getValue();
//            c.setBirthday(new Timestamp(dateUtil.getTime()));
//        }
//        customerDao.save(c);
//        return true;
//    }
//    public boolean editCustomer(Customer c) throws Exception {
//        CustomerPopupView view = (CustomerPopupView) this.getView();
//        String name = view.getTxtName().getText(), address = view.getTxtAddress().getText(), phoneNumber = view.getTxtPhoneNumber().getText();
//        if (phoneNumber.isEmpty()) {
//            throw new Exception("Vui lòng điền đầy đủ thông tin");
//        }
//        c.setAddress(address);
//        c.setName(name);
//        c.setPhoneNumber(phoneNumber);
//        if (!view.getCbUnknownBirthday().isSelected()) {
//            Date dateUtil = (Date) view.getSpnBirthday().getValue();
//            c.setBirthday(new Timestamp(dateUtil.getTime()));
//        }
//        customerDao.update(c);
//        return true;
//    }
}
