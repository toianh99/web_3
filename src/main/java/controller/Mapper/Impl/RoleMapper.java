package controller.Mapper.Impl;



import controller.Mapper.RowMapper;
import model.Role;

import java.sql.ResultSet;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs) {
        try {
            Role role = new Role();
            role.setIdRole(rs.getInt("ID"));
            role.setNameRole(rs.getString("Name"));
            role.setDesc(rs.getString("Desc"));
            role.setCodeRole(rs.getString("Code"));
            return role;
        }catch (Exception e){
            System.out.println("lỗi map roles");
        }
        return null;
    }
}
