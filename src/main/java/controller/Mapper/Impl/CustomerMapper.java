package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs) throws SQLException {
        try {
            Customer customer = new Customer();
            customer.setIdCustomer(rs.getInt("UserID"));
            customer.setEmail(rs.getString("Email"));
            customer.setFirstName(rs.getString("FirstName"));
            customer.setLastname(rs.getString("LastName"));
            customer.setPhoneNumber(rs.getString("PhoneNumber"));
            return customer;
        }catch (Exception e){
            System.out.println("lỗi mapper customer");
        }
        return null;
    }
}
