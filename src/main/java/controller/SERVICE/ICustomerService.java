package controller.SERVICE;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    int saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
    List<Customer> getCustomer(int pagenum,int pagesize);
    Customer findById(int id);
}
