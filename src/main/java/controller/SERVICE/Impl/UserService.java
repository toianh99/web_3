package controller.SERVICE.Impl;

import controller.DAO.Impl.UserDAOImpl;
import controller.SERVICE.IUserService;

public class UserService implements IUserService {
    private UserDAOImpl userDAO = new UserDAOImpl();
    @Override
    public boolean deleteUser(int id) {
        userDAO.deleteUser(id);
        return true;
    }
}
