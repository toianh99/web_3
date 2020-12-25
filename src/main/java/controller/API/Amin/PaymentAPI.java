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
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "PaymentAPI",urlPatterns = {"/api-v1-payment"})
public class PaymentAPI extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();
    private PaymentService paymentService = new PaymentService();
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Payment payment = HttpUtil.of(request.getReader()).toModel(Payment.class);
        paymentService.savepayment(payment);
        mapper.writeValue(response.getOutputStream(),payment);
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Payment payment = HttpUtil.of(request.getReader()).toModel(Payment.class);
        List<Payment> lists =paymentService.getPayment();
        mapper.writeValue(response.getOutputStream(),lists);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Payment payment = HttpUtil.of(request.getReader()).toModel(Payment.class);
        paymentService.updatePayment(payment);
        mapper.writeValue(response.getOutputStream(),payment);

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Payment payment = HttpUtil.of(request.getReader()).toModel(Payment.class);
        paymentService.deletePayment(payment.getIdPayment());
        mapper.writeValue(response.getOutputStream(),"Xoa thanh cong ");


    }
}
