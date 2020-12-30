package controller.SERVICE.Impl;

import controller.DAO.Impl.RoleDAOImpl;
import controller.DAO.Impl.UserDAOImpl;
import controller.SERVICE.IUserService;
import model.Role;
import model.User;

import java.util.List;

public class UserService implements IUserService {
    private UserDAOImpl userDAO = new UserDAOImpl();
    private RoleDAOImpl roleDAO = new RoleDAOImpl();
    @Override
    public boolean deleteUser(int id) {
        userDAO.deleteUSerRole(id);
        userDAO.deleteUser(id);

        return true;
    }
    public User findById(int id){
        User u = userDAO.findOne(id);
        List<Role> roles = roleDAO.getRoleByIdUser(id);
       u.setRoles( roles);
       return u;
    }
}
