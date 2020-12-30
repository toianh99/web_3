package controller.DAO;

import model.User;

public interface IUser extends  IBaseDAO<User> {
    User Login(User user);
    User findOne(int id);
    int saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    int getCountUser();
    void deleteUSerRole(int id);

}
