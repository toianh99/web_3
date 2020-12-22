package controller.DAO.Impl;


import controller.DAO.IPayment;
import model.Payment;

public class PaymentDAOImpl extends BaseDAOImpl<Payment> implements IPayment {
    @Override
    public int savePayment(Payment payment) {
        StringBuilder sql = new StringBuilder("INSERT INTO payment (NamePayment, Type, Desc)");
        sql.append(" VALUES(?, ? , ?)");
        int a = insert(sql.toString(),payment.getNamePayment(),payment.getType(),payment.getDesc());
        return a;
    }

    @Override
    public void updatePayment(Payment payment) {

    }

    @Override
    public void deletePayment(int id) {

    }
}