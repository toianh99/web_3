package controller.SERVICE.Impl;

import controller.DAO.Impl.CustomerDAOImpl;
import controller.DAO.Impl.UserDAOImpl;
import controller.SERVICE.ICustomerService;
import model.Customer;
import model.Role;
import model.User;

import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    private UserDAOImpl userDAO = new UserDAOImpl();
    private User user = new User();
    @Override
    public int saveCustomer(Customer customer) {
        user.setPassword(customer.getPassword());
        user.setUsername(customer.getUsername());
        Role roleCus = new Role();
        roleCus.setIdRole(2);
        user.setRoles(roleCus);
        int idUser = userDAO.saveUser(user);
        customer.setIdCustomer(idUser);
        int a = customerDAO.saveCustomer(customer);
        return a;

    }

    @Override
    public void updateCustomer(Customer customer) {
        user.setUsername(customer.getUsername());
        user.setPassword(customer.getPassword());
        user.setIdUser(customer.getIdCustomer());
        userDAO.updateUser(user);
        customerDAO.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        userDAO.deleteUser(id);
        customerDAO.deleteCustomer(id);
    }

    @Override
    public List<Customer> getCustomer(int pagenum, int pagesize) {
       return customerDAO.getCustomer(pagenum,pagesize);
    }

    @Override
    public Customer findById(int id) {
       return customerDAO.findById(id);
    }
}
