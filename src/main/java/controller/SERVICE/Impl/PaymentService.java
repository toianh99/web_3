package controller.SERVICE.Impl;

import controller.DAO.Impl.PaymentDAOImpl;
import controller.SERVICE.IPaymentService;
import model.Payment;

import java.util.List;

public class PaymentService implements IPaymentService {
    private PaymentDAOImpl paymentDAO = new PaymentDAOImpl();
    @Override
    public int savepayment(Payment payment) {
        return 0;
    }

    @Override
    public void updatePayment(Payment payment) {

    }

    @Override
    public void deletePayment(int id) {

    }

    @Override
    public List<Payment> getPayment() {
        return paymentDAO.getPayment();
    }
}
