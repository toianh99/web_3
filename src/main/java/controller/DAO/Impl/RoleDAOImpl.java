package controller.DAO.Impl;



import controller.DAO.IRole;
import controller.Mapper.Impl.RoleMapper;
import model.Role;

import java.util.List;

public class RoleDAOImpl extends BaseDAOImpl<Role> implements IRole {
    @Override
    public int saveRole(Role role) {
        StringBuilder sql = new StringBuilder("INSERT INTO role(`Name` , `Desc`, `Code`  )");
        sql.append(" VALUES( ? , ? , ? )");
        return insert(sql.toString(),role.getNameRole(),role.getCodeRole(),role.getDesc());
    }

    @Override
    public void updateRole(Role role) {
        StringBuilder sql = new StringBuilder("UPDATE role SET `Name` = ?, `Code` = ?, `Desc` =? WHERE `ID`` = ?");
        update(sql.toString(), role.getNameRole(),role.getCodeRole(),role.getDesc(),role.getIdRole());
    }

    @Override
    public void deleteRole(int id) {
        String sql = "DELETE FROM role WHERE `ID`` = ?";
        update(sql, id);
    }

//    @Override
//    public List<Role> findByIdUser(int idUser) {
//        String sql = "Select  r.* from roles r\n" +
//                "inner join user_roles ur\n" +
//                "on r.idRole = ur.RoleidRole\n" +
//                "inner join users u\n" +
//                "on u.idUser = ur.UseridUser\n" +
//                "where u.idUser =  ?";
//        List<Role> roles = query(sql, new RoleMapper(),idUser);
//        return roles.isEmpty() ? null : roles;
//    }

    @Override
    public Role findById(int idRole) {
        String sql = "SELECT * FROM role WHERE `ID`` = ?";
        List<Role> roles = query(sql, new RoleMapper(), idRole);
        return roles.isEmpty() ? null : roles.get(0);
    }

    @Override
    public List<Role> getAll(int pagenum, int pagesize) {
        String sql = "SELECT * FROM role LIMIT ?,?";
        return query(sql, new RoleMapper(),pagenum,pagesize);
    }

    @Override
    public int saveRolePermission(int idRole, int idPermission) {
        StringBuilder sql = new StringBuilder("INSERT INTO role_permission( RoleID, PermissionID)");
        sql.append("VALUES( ? , ? )");
        return insert(sql.toString(),idRole,idPermission);
    }
}
