package controller.DAO.Impl;


import controller.DAO.IPayment;
import controller.Mapper.Impl.PaymentMapper;
import model.Payment;

import java.util.List;

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
        String sql = "UPDATE `payment` SET `NamePayment` = ? , `Type` = ? , `Desc` = ? WHERE `ID` = ?";
        update(sql,payment.getNamePayment(),payment.getType(),payment.getDesc(),payment.getIdPayment());
    }

    @Override
    public void deletePayment(int id) {
        String sql ="DELETE * FROM payment WHERE `ID` = ?";
        update(sql,id);
    }

    @Override
    public List<Payment> getPayment() {
        String sql ="SELECT * FROM `payment`";
        return query(sql,new PaymentMapper());
    }
}
