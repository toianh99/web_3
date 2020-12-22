package controller.Mapper.Impl;



import controller.Mapper.RowMapper;
import model.User;

import java.sql.ResultSet;
import java.util.HashSet;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs) {
        try {
            User user = new User();
            user.setIdUser(rs.getInt("ID"));
            user.setUsername(rs.getString("Username"));
            user.setPassword(rs.getString("Password"));
        }catch (Exception e){
            System.out.println("lỗi mapper user");
        }
        return null;
    }
}
