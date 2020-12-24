package controller.SERVICE.Impl;

import controller.DAO.Impl.StaffDAOImpl;
import controller.DAO.Impl.UserDAOImpl;
import controller.SERVICE.IStaffService;
import model.Staff;
import model.User;

import java.util.List;

public class StaffService implements IStaffService {
    private StaffDAOImpl staffDAO = new StaffDAOImpl();
    private UserDAOImpl userDAO= new UserDAOImpl();
    @Override
    public int saveStaff(Staff staff) {
        User user = new User();
        user.setPassword(staff.getPassword());
        user.setUsername(staff.getUsername());
        return staffDAO.saveStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        User user = new User();
        user.setPassword(staff.getPassword());
            userDAO.updateUser(user);
        staffDAO.updateStaff(staff);
    }

    @Override
    public void deleteStaff(int id) {
        staffDAO.deleteStaff(id);
        Staff staff = staffDAO.findStaffById(id);
        userDAO.deleteUser(staff.getIdUser());
    }

    @Override
    public Staff findStaffById(int id) {
        Staff staff = staffDAO.findStaffById(id);
        User user =userDAO.findOne(id);
        staff.setUsername(user.getUsername());
        staff.setPassword(user.getPassword());
        staff.setRoles(user.getRoles());
        return staff;
    }

    @Override
    public List<Staff> findStaffByPage(int pagenum, int pagesize) {
        return staffDAO.findStaffByPage(pagenum,pagesize);
    }
}
