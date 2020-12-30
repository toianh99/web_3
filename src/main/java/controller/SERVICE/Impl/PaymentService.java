package controller.SERVICE.Impl;

import controller.DAO.Impl.PaymentDAOImpl;
import controller.SERVICE.IPaymentService;
import model.Payment;

import java.util.List;

public class PaymentService implements IPaymentService {
    private PaymentDAOImpl paymentDAO = new PaymentDAOImpl();
    @Override
    public int savepayment(Payment payment) {
       return paymentDAO.savePayment(payment);

    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDAO.updatePayment(payment);
    }

    @Override
    public void deletePayment(int id) {
        paymentDAO.deletePayment(id);
    }

    @Override
    public List<Payment> getPayment() {
        return paymentDAO.getPayment();
    }

    @Override
    public Payment findPaymentById(int id) {
        return paymentDAO.finPaymentById(id);
    }
}
