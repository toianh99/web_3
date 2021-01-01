package controller.SERVICE.Impl;

import controller.DAO.Impl.PermissionDAOImpl;
import controller.DAO.Impl.RoleDAOImpl;
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
    private RoleDAOImpl roleDAO = new RoleDAOImpl();
    private PermissionDAOImpl permissionDAO= new PermissionDAOImpl();
    @Override
    public int saveStaff(Staff staff) {
        User user = new User();
        user.setPassword(staff.getPassword());
        user.setUsername(staff.getUsername());
//        Role roleCus = new Role();
//        roleCus.setIdRole(1);
        List<Role> roles = new ArrayList<>();
//        roles.add(roleCus);
        roles=staff.getRoles();
        System.out.println(roles.get(0).getNameRole()+"okkk");
        user.setRoles(roles);
        int idUser = userDAO.saveUser(user);
        for (Role r: roles) {
            roleDAO.saveRoleUser(idUser,r.getIdRole());
        }

        staff.setIdStaff(idUser);
        staff.setIdUser(idUser);
        return staffDAO.saveStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        User user = new User();
        user.setPassword(staff.getPassword());
        user.setIdUser(staff.getIdStaff());
        List<Role> listRole = roleDAO.getRoleByIdUser(staff.getIdStaff());
        List<Role> roles = staff.getRoles();
        Boolean flag;
        for (Role r:roles) {
            flag= false;
            for (Role role : listRole){
                if(r.getIdRole()==role.getIdRole()){
                    flag=true;
                }
            }
            if (flag==false){
                System.out.println(r.getNameRole());
                roleDAO.saveRoleUser(staff.getIdStaff(),r.getIdRole());
                roles.remove(r);
            }
        }
        for (Role role:listRole) {
            flag= false;
            for (Role r:roles) {
                if (role.getIdRole()==r.getIdRole()){
                    flag=true;
                }
            }
            if (flag==false){
                System.out.println(role.getNameRole()+"okkkk");
                System.out.println(staff.getIdStaff());
                System.out.println(role.getIdRole());
                roleDAO.deleteUserRole(staff.getIdStaff(),role.getIdRole());
            }
        }

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
        List<Role> roles = roleDAO.getRoleByIdUser(id);
        user.setRoles(roles);
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
            for (int j = 0; j <roles.size() ; j++) {
               List<Permission> permissions = permissionDAO.findByIdRole(roles.get(j).getIdRole());
               roles.get(j).setPermissions(permissions);
            }
            staff.get(i).setIdUser(u.getIdUser());
            staff.get(i).setPassword(u.getPassword());
            staff.get(i).setUsername(u.getUsername());
            staff.get(i).setRoles(roles);
        }
        return staff;
    }
}
