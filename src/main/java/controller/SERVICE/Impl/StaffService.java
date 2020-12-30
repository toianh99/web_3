package controller.SERVICE.Impl;

import controller.DAO.Impl.PermissionDAOImpl;
import controller.DAO.Impl.StaffDAOImpl;
import controller.DAO.Impl.UserDAOImpl;
import controller.SERVICE.IStaffService;
import model.Permission;
import model.Role;
import model.Staff;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class StaffService implements IStaffService {
    private StaffDAOImpl staffDAO = new StaffDAOImpl();
    private UserService userService= new UserService();
    private UserDAOImpl userDAO = new UserDAOImpl();
    private PermissionDAOImpl permissionDAO= new PermissionDAOImpl();
    @Override
    public int saveStaff(Staff staff) {
        User user = new User();
        user.setPassword(staff.getPassword());
        user.setUsername(staff.getUsername());
        Role roleCus = new Role();
        roleCus.setIdRole(1);
        List<Role> roles = new ArrayList<>();
        roles.add(roleCus);
        user.setRoles(roles);
        int idUser = userDAO.saveUser(user);
        staff.setIdStaff(idUser);
        staff.setIdUser(idUser);
        return staffDAO.saveStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        User user = new User();
        user.setPassword(staff.getPassword());
        user.setIdUser(staff.getIdStaff());
            userDAO.updateUser(user);
        staffDAO.updateStaff(staff);
    }

    @Override
    public void deleteStaff(int id) {
        staffDAO.deleteStaff(id);
//        Staff staff = staffDAO.findStaffById(id);
        userDAO.deleteUser(id);
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
        List<Staff> staff = staffDAO.findStaffByPage(pagenum,pagesize);
        for (int i = 0; i < staff.size() ; i++) {
            User u = userService.findById(staff.get(i).getIdStaff());
            List<Role> roles = u.getRoles();
//            for (int j = 0; j <roles.size() ; j++) {
//               List<Permission> permissions = permissionDAO.findByIdRole(roles.get(i).getIdRole());
//                System.out.println(permissions.get(0));
//               roles.get(i).setPermissions(permissions);
//            }
            staff.get(i).setIdUser(u.getIdUser());
            staff.get(i).setPassword(u.getPassword());
            staff.get(i).setUsername(u.getUsername());
            staff.get(i).setRoles(roles);
        }
        return staff;
    }
}
