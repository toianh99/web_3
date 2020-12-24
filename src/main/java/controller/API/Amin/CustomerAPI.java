package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.CustomerService;
import controller.SERVICE.Impl.UserService;
import controller.SHARE.HttpUtil;
import model.Customer;

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
        List<Customer> customers = customerService.getCustomer(0,100);
        mapper.writeValue(resp.getOutputStream(),customers);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
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
        System.out.println(customer.getIdCustomer());
        customerService.deleteCustomer(customer.getIdCustomer());
        userService.deleteUser(customer.getIdCustomer());
        mapper.writeValue(resp.getOutputStream(),"{Xoa thanh cong}");
    }
}
