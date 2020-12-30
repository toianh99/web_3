package controller.DAO;


import model.Payment;

import java.util.List;

public interface IPayment {
    int savePayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(int id);
    List<Payment> getPayment();
    Payment finPaymentById(int id);
}
