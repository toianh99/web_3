package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.CustomerService;
import controller.SERVICE.Impl.UserService;
import controller.SHARE.HttpUtil;
import model.Customer;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerAPI",urlPatterns = {"/api-v1-customer"})
public class CustomerAPI extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();
    private CustomerService customerService = new CustomerService();
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        if(id!=null){
            Customer customer = customerService.findById(Integer.parseInt(id));
            User user= userService.findById(Integer.parseInt(id));
            customer.setUsername(user.getUsername());
            customer.setPassword(user.getPassword());
            customer.setRoles(user.getRoles());
            mapper.writeValue(resp.getOutputStream(),customer);
        }
        else{
            List<Customer> customers = customerService.getCustomer(0,100000);
            mapper.writeValue(resp.getOutputStream(),customers);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Customer customer = HttpUtil.of(req.getReader()).toModel(Customer.class);
        customerService.saveCustomer(customer);
        mapper.writeValue(resp.getOutputStream(),customer);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Customer customer = HttpUtil.of(req.getReader()).toModel(Customer.class);
        customerService.updateCustomer(customer);
        mapper.writeValue(resp.getOutputStream(),customer);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Customer customer = HttpUtil.of(req.getReader()).toModel(Customer.class);
        customerService.deleteCustomer(customer.getIdCustomer());
        userService.deleteUser(customer.getIdCustomer());
        mapper.writeValue(resp.getOutputStream(),"{Xoa thanh cong}");
    }
}
