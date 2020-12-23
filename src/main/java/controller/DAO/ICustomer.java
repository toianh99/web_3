package controller.DAO;

import model.Customer;

import java.util.List;

public interface ICustomer extends IBaseDAO<Customer> {
    int saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer findById(int id);
    Customer findByString(String str);
    List<Customer> getCustomer(int pagenum, int pagesize);
}
