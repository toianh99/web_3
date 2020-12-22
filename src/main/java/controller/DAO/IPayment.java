package controller.DAO;


import model.Payment;

public interface IPayment {
    int savePayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(int id);
}
