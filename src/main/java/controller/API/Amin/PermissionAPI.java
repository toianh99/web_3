package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.PermissionService;
import controller.SHARE.HttpUtil;
import model.Permission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name ="PermissionAPI",urlPatterns = {"/api-v1-permission"})
public class PermissionAPI extends HttpServlet {
    private PermissionService permissionService = new PermissionService();
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        List<Permission> permissions = permissionService.getAll(0,100);
        mapper.writeValue(resp.getOutputStream(),permissions);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Permission permission = HttpUtil.of(req.getReader()).toModel(Permission.class);
        permissionService.savePermission(permission);
        mapper.writeValue(resp.getOutputStream(),permission);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Permission permission = HttpUtil.of(req.getReader()).toModel(Permission.class);
        permissionService.updatePermission(permission);
        mapper.writeValue(resp.getOutputStream(),permission);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Permission permission = HttpUtil.of(req.getReader()).toModel(Permission.class);
        permissionService.deletePermission(permission.getIdPermission());
        mapper.writeValue(resp.getOutputStream(),"{xóa thành công");
    }
}
