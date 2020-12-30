package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.RoleService;
import controller.SHARE.HttpUtil;
import model.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoleAPI",urlPatterns = {"/api-v1-role"})
public class RoleAPI  extends HttpServlet {
    private RoleService roleService = new RoleService();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        List<Role> roles= roleService.getAll(0,100);
        mapper.writeValue(resp.getOutputStream(),roles);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Role role = HttpUtil.of(req.getReader()).toModel(Role.class);
        roleService.saveRole(role);
        mapper.writeValue(resp.getOutputStream(),role);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Role role = HttpUtil.of(req.getReader()).toModel(Role.class);
        roleService.updateRole(role);
        mapper.writeValue(resp.getOutputStream(),role);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Role role = HttpUtil.of(req.getReader()).toModel(Role.class);
        roleService.deleteRole(role.getIdRole());
        mapper.writeValue(resp.getOutputStream(),"{}");
    }
}
