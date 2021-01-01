package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.StaffService;
import controller.SHARE.HttpUtil;
import model.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffAPI",urlPatterns = {"/api-v1-staff"})
public class StaffAPI extends HttpServlet {
    private StaffService staffService= new StaffService();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        if(id!=null){
           Staff staff= staffService.findStaffById(Integer.parseInt(id));
            mapper.writeValue(resp.getOutputStream(),staff);
        }
        else{
            List<Staff> staffs = staffService.findStaffByPage(0,100);
            mapper.writeValue(resp.getOutputStream(),staffs);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Staff staff = HttpUtil.of(req.getReader()).toModel(Staff.class);
        System.out.println(staff.getPassword());
        staffService.saveStaff(staff);
        mapper.writeValue(resp.getOutputStream(),staff);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Staff staff = HttpUtil.of(req.getReader()).toModel(Staff.class);
        staffService.updateStaff(staff);
        mapper.writeValue(resp.getOutputStream(),staff);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Staff staff = HttpUtil.of(req.getReader()).toModel(Staff.class);
        staffService.deleteStaff(staff.getIdStaff());
        mapper.writeValue(resp.getOutputStream(),"{}");
    }
}
