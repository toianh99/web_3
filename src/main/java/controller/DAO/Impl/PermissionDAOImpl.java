package controller.DAO.Impl;


import controller.DAO.IPermission;
import controller.Mapper.Impl.PermissionMapper;
import model.Permission;

import java.util.List;


public class PermissionDAOImpl extends BaseDAOImpl<Permission> implements IPermission {
    @Override
    public int savePermission(Permission permission) {
        StringBuilder sql = new StringBuilder("INSERT INTO `permission` ( `Name`,`Code`,) ");
        sql.append(" VALUES ( ? , ?  ");
        return insert(sql.toString(),permission.getNamePermission(),permission.getCodePermisison());
    }

    @Override
    public void updatePermission(Permission permission) {
        String sql = "UPDATE permission SET `Name` = ? , `Code` = ? WHERE `ID` = ?";
        update(sql,permission.getNamePermission(),permission.getCodePermisison(),permission.getIdPermission());
    }

    @Override
    public void deletePermission(int id) {
        String sql = "DELETE * FROM `permission` WHERE `ID` = ?";
        update(sql,id);
    }

    @Override
    public List<Permission> findByIdRole(int idRole) {
        return null;
    }

    @Override
    public List<Permission> findByIdUser(int idUser) {
        return null;
    }

    @Override
    public List<Permission> getAll(int pagenum, int pagesize) {
        String sql = "SELECT * FROM `permission` LIMIT ?, ?";
        List<Permission> permissions = query(sql, new PermissionMapper(),pagenum,pagesize);
        return permissions.isEmpty() ? null : permissions;
    }

    @Override
    public Permission findById(int id) {
        String sql ="SELECT * FROM `permission` WHERE `ID` = ?";
        return query(sql,new PermissionMapper(),id).get(0);
    }

//    @Override
//    public Long savePermission(Permission permission) {
//        StringBuilder sql = new StringBuilder("INSERT INTO permission(namePermission codepermission desc )");
//        sql.append(" VALUES( ? , ? , ? )");
//        return insert(sql.toString(),permission.getNamePermission(),permission.getCodepermission(),permission.getDesc());
//    }
//
//    @Override
//    public void updatePermission(Permission permission) {
//        StringBuilder sql = new StringBuilder("UPDATE permission SET namePermission = ?, codepermission = ?, desc =? WHERE idRole = ?");
//        update(sql.toString(),permission.getNamePermission(),permission.getCodepermission(),permission.getDesc(),permission.getIdPermission());
//    }
//
//    @Override
//    public void deletePermission(int id) {
//        String sql = "DELETE FROM permission WHERE idPermission = ?";
//        update(sql, id);
//    }
//
//    @Override
//    public List<Permission> findByIdRole(int idRole) {
//       String sql = "select p.* from permission p\n" +
//               "inner join roles_permission rp on p.idPermission = rp.PermissionidPermission\n" +
//               "inner join roles r on rp.RoleidRole = r.idRole\n" +
//               "where r.idRole= ?";
//       try {
//           List<Permission> permissions = query(sql, new PermissionMapper(),idRole);
//           return permissions.isEmpty() ? null : permissions;
//       }catch (Exception e){
//           System.out.println(e);
//       }
//       return null;
//
//
//    }
//
//    @Override
//    public List<Permission> findByIdUser(int idUser) {
//        String sql = "Select  p.* from roles r\n" +
//                "inner join user_roles ur\n" +
//                "on r.idRole = ur.RoleidRole\n" +
//                "inner join users u\n" +
//                "on u.idUser = ur.UseridUser\n" +
//                "inner join roles_permission rp on r.idRole = rp.RoleidRole\n" +
//                "inner join permission p on rp.PermissionidPermission = p.idPermission\n" +
//                "where u.idUser =  ? ";
//        List<Permission> permissions = query(sql,new PermissionMapper(),idUser);
//        return permissions.isEmpty() ? null : permissions;
//    }
//
//    @Override
//    public List<Permission> getAll(int pagenum, int pagesize) {
//        String sql = "SELECT * FROM permission LIMIT ?,?";
//        return query(sql, new PermissionMapper(),pagenum,pagesize);
//    }
//
//    @Override
//    public Permission findById(int id) {
//        String sql = "SELECT * FROM permission WHERE idPermission = ?";
//        List<Permission> permissions = query(sql, new PermissionMapper(), id);
//        return permissions.isEmpty() ? null : permissions.get(0);
//    }
}
