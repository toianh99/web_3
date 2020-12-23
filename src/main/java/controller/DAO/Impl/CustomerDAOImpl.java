package controller.DAO.Impl;

import controller.DAO.IBaseDAO;
import controller.DAO.ICustomer;
import controller.Mapper.Impl.CustomerMapper;
import model.Customer;

import java.util.List;

public class CustomerDAOImpl extends BaseDAOImpl<Customer> implements ICustomer {
    @Override
    public int saveCustomer(Customer customer) {
        StringBuilder sql = new StringBuilder("INSERT INTO customer (FirstName,LastName,Email,PhoneNumber,UserID)");
        sql.append(" VALUES(?, ? , ?)");
        return insert(sql.toString(),customer.getFirstName(),customer.getLastname(),customer.getEmail(),customer.getPhoneNumber(),customer.getIdUser());
    }

    @Override
    public void updateCustomer(Customer customer) {
        StringBuilder sql = new StringBuilder("UPDATE customer SET `Email` =?,`PhoneNumber`=?,`UserID`=?,`FirstName`=?,`LastName`=? WHERE `ID`=?");
        update(sql.toString(),customer.getEmail(),customer.getPhoneNumber(),customer.getIdUser(),customer.getFirstName(),customer.getLastname(),customer.getIdCustomer());
    }

    @Override
    public void deleteCustomer(int id) {
        StringBuilder sql = new StringBuilder("DELETE FROM customer WHERE `ID`=?");
        update(sql.toString(),id);
    }

    @Override
    public Customer findById(int id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM customer WHERE `ID`=?");
        Customer customer = query(sql.toString(),new CustomerMapper(),id).get(0);
        return  customer;
    }

    @Override
    public Customer findByString(String str) {
        return null;
    }

    @Override
    public List<Customer> getCustomer(int pagenum, int pagesize) {
        StringBuilder sql = new StringBuilder("SELECT * FROM customer LIMIT ?, ?");
        List<Customer> customers = query(sql.toString(),new CustomerMapper(),pagenum,pagesize);
        return customers.isEmpty() ? null : customers;
    }
}
