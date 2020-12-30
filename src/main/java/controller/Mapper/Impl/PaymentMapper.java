package controller.Mapper.Impl;

import com.mysql.cj.result.Row;
import controller.Mapper.RowMapper;
import model.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMapper implements RowMapper<Payment> {
    @Override
    public Payment mapRow(ResultSet rs) throws SQLException {
        try{
            Payment payment = new Payment( rs.getString("NamePayment"),rs.getString("Type"),rs.getString("Desc"));
            payment.setIdPayment(rs.getInt("ID"));
            return payment;
        }catch (Exception ex){
            System.out.println("lỗi mapper payment");
        }
        return null;
    }
}
