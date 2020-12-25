package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.PaymentService;
import controller.SERVICE.Impl.PermissionService;
import controller.SHARE.HttpUtil;
import model.Payment;
import model.Permission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PermissionAPI", urlPatterns = {"/api-v1-permission"})
public class PermissionAPI extends HttpServlet {
    private ObjectMapper mapper = new ObjectMapper();
    private PermissionService permissionService = new PermissionService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
       Permission permission = HttpUtil.of(request.getReader()).toModel(Permission.class);
        permissionService.savePermission(permission);
        mapper.writeValue(response.getOutputStream(),permission);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Permission permission = HttpUtil.of(request.getReader()).toModel(Permission.class);

        List<Permission> permissionList = permissionService.getAll(0,100);
        mapper.writeValue(response.getOutputStream(),permissionList);
    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Permission permission = HttpUtil.of(request.getReader()).toModel(Permission.class);
        permissionService.updatePermission(permission);
        mapper.writeValue(response.getOutputStream(),permission);
        System.out.println();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Permission permission = HttpUtil.of(request.getReader()).toModel(Permission.class);
        permissionService.deletePermission(permission.getIdPermission());
        mapper.writeValue(response.getOutputStream(),"Xoa thanh cong");


    }
}
