package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.PaymentService;
import controller.SHARE.HttpUtil;
import model.Payment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "PaymentAPI",urlPatterns = {"/api-v1-payment"})
public class PaymentAPI extends HttpServlet {
    private PaymentService paymentService = new PaymentService();
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if(id!=null){
           Payment payment= paymentService.findPaymentById(Integer.parseInt(id));
            mapper.writeValue(resp.getOutputStream(),payment);
        }else{
            List<Payment> payments = paymentService.getPayment();
            mapper.writeValue(resp.getOutputStream(),payments);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Payment payment=   HttpUtil.of(req.getReader()).toModel(Payment.class);
        paymentService.savepayment(payment);
        mapper.writeValue(resp.getOutputStream(),payment);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Payment payment=HttpUtil.of(req.getReader()).toModel(Payment.class);
        paymentService.updatePayment(payment);
        mapper.writeValue(resp.getOutputStream(),payment);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Payment payment=    HttpUtil.of(req.getReader()).toModel(Payment.class);
        paymentService.deletePayment(payment.getIdPayment());
        mapper.writeValue(resp.getOutputStream(),"{xóa thành công}");
    }
}
