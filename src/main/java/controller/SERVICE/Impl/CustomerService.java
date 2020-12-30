package controller.SERVICE.Impl;

import controller.DAO.Impl.CustomerDAOImpl;
import controller.DAO.Impl.RoleDAOImpl;
import controller.DAO.Impl.UserDAOImpl;
import controller.SERVICE.ICustomerService;
import model.Customer;
import model.Role;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    private UserDAOImpl userDAO = new UserDAOImpl();
    private User user = new User();
    private RoleDAOImpl roleDAO = new RoleDAOImpl();
    @Override
    public int saveCustomer(Customer customer) {
        user.setPassword(customer.getPassword());
        user.setUsername(customer.getUsername());
        Role roleCus = new Role();
        roleCus.setIdRole(2);
        List<Role> roles = new ArrayList<>();
        roles.add(roleCus);
        user.setRoles(roles);

        int idUser = userDAO.saveUser(user);
        System.out.println(idUser);
        roleDAO.saveRoleUser(idUser,3);
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
        List<Customer> customers = customerDAO.getCustomer(pagenum,pagesize);
        for (int i=0;i<customers.size();i++){
            User u= userDAO.findOne(customers.get(i).getIdCustomer());
            customers.get(i).setUsername(u.getUsername());
            customers.get(i).setPassword(u.getPassword());
        }
       return customers;
    }

    @Override
    public Customer findById(int id) {
       return customerDAO.findById(id);
    }
}
