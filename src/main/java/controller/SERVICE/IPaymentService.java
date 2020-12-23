package controller.SERVICE;

import model.Payment;

import java.util.List;

public interface IPaymentService {
    int savepayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(int id);
    List<Payment> getPayment();
}
