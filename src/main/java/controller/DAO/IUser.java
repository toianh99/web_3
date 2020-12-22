package controller.DAO;

import model.User;

public interface IUser extends  IBaseDAO<User> {
    User Login(User user);
    User findOne(int id);
    Long save(User user);
    void update(User user);
    void delete(int id);
    int getCountUser();

}
