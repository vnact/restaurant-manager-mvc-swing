package controllers.popup;

import controllers.PopupController;
import controllers.admin.CustomerManagerController;
import dao.CustomerDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import models.Customer;
import views.popup.CustomerPopupView;

/**
 * createAt Dec 17, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class CustomerPopupController extends PopupController {

//    EmployeeDao employeeDao = new EmployeeDao();
    CustomerDao customerDao = new CustomerDao();

    public void add(CustomerManagerController parrent, CustomerPopupView view) {
        setView(view);
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean addSuccess = addCustomer();
                    if (addSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Thêm khách hàng thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public void edit(CustomerManagerController parrent, CustomerPopupView view, Customer customer) {
        setView(view);
        view.getLbTitle().setText("Sửa khách hàng - " + customer.getId());
        view.getTxtName().setText(customer.getName());
        view.getTxtPhoneNumber().setText(customer.getPhoneNumber());
        if (customer.getBirthday() != null) {
            view.getCbUnknownBirthday().setSelected(false);
            view.getSpnBirthday().setValue(new Date(customer.getBirthday().getTime()));
        } else {
            view.getCbUnknownBirthday().setSelected(true);
        }
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    boolean editSuccess = editCustomer(customer);
                    if (editSuccess) {
                        view.dispose();
                        parrent.updateData();
                        view.showMessage("Sửa khách hàng thành công!");
                    }
                } catch (Exception ex) {
                    parrent.getView().showError(ex);
                }
            }
        });

    }

    public boolean addCustomer() throws Exception {
        CustomerPopupView view = (CustomerPopupView) this.getView();
        String name = view.getTxtName().getText(), address = view.getTxtAddress().getText(), phoneNumber = view.getTxtPhoneNumber().getText();
        if (phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
//        if (customerDao.findByUsername(username) != null) {
//            throw new Exception("Tài khoản đã tồn tại");
//        }
        Customer c = new Customer();
        c.setAddress(address);
        c.setName(name);
        c.setPhoneNumber(phoneNumber);
        if (!view.getCbUnknownBirthday().isSelected()) {
            Date dateUtil = (Date) view.getSpnBirthday().getValue();
            c.setBirthday(new Timestamp(dateUtil.getTime()));
        }
        customerDao.save(c);
        return true;
    }

    public boolean editCustomer(Customer c) throws Exception {
        CustomerPopupView view = (CustomerPopupView) this.getView();
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
}
