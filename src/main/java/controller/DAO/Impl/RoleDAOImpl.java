package controller.DAO.Impl;



import controller.DAO.IRole;
import controller.Mapper.Impl.RoleMapper;
import model.Permission;
import model.Role;

import java.util.List;

public class RoleDAOImpl extends BaseDAOImpl<Role> implements IRole {
    @Override
    public int saveRole(Role role) {
        StringBuilder sql = new StringBuilder("INSERT INTO `role` (`Name` , `Desc`, `Code`  )");
        sql.append(" VALUES( ? , ? , ? )");
        return insert(sql.toString(),role.getNameRole(),role.getDesc(),role.getCodeRole());
    }

    @Override
    public int saveRole_Permission(int idRole, int idPermission) {
        StringBuilder sql = new StringBuilder("INSERT INTO `role_permission` (`RoleID`,`PermissionID`)");
        sql.append("VALUES(?,?)");
        return     insert(sql.toString(),idRole,idPermission);
    }

    @Override
    public int saveRoleUser(int idUser, int idRole) {
        String sql ="INSERT INTO `user_role`(`UserID`,`RoleID` ) VALUES (?,? )";
        return insert(sql,idUser,idRole);
    }

    @Override
    public void updateRole(Role role) {
        StringBuilder sql = new StringBuilder("UPDATE role SET `Name` = ?, `Code` = ?, `Desc` =? WHERE `ID` = ?");
        update(sql.toString(), role.getNameRole(),role.getCodeRole(),role.getDesc(),role.getIdRole());
    }

    @Override
    public void deleteRole(int id) {
        String sql = "DELETE FROM role as r" +
                "INNER JOIN `role_permission` as rp ON rp.RoleID=r.ID" +
                " WHERE `ID`` = ?";
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

    @Override
    public List<Role> getRoleByIdUser(int id) {
        String sql ="SELECT r.* FROM `user` as u " +
                "INNER JOIN `user_role` as ur ON u.ID= ur.UserID " +
                "INNER JOIN `role` as r ON r.ID= ur.RoleID " +
                "WHERE u.ID =?";
        return query(sql, new RoleMapper(), id);
    }
}
