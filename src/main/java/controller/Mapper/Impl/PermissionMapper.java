package controller.Mapper.Impl;


import controller.Mapper.RowMapper;
import model.Permission;

import java.sql.ResultSet;

public class PermissionMapper implements RowMapper<Permission> {
    @Override
    public Permission mapRow(ResultSet rs) {
        try {
            Permission permission = new Permission();
            permission.setIdPermission(rs.getInt("ID"));
            permission.setNamePermission(rs.getString("Name"));
            permission.setCodePermisison(rs.getString("Code"));
//            permission.se(rs.getString("desc"));
            return permission;
        }catch (Exception e){
            System.out.println("lỗi mapper permission");
        }
        return null;
    }
}
