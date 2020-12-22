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
            Payment payment = new Payment(rs.getInt("ID"), rs.getString("NamePayment"),rs.getString("Type"));
            return payment;
        }catch (Exception ex){
            System.out.println("lỗi mapper payment");
        }
        return null;
    }
}
