package controller.SERVICE.Impl;

import controller.DAO.Impl.PermissionDAOImpl;
import controller.DAO.Impl.RoleDAOImpl;
import controller.SERVICE.IPermissionService;
import model.Permission;
import model.Role;

import java.util.List;

public class PermissionService implements IPermissionService {
        private PermissionDAOImpl permissionDAO = new PermissionDAOImpl();
        private RoleDAOImpl roleDAO = new RoleDAOImpl();
    @Override
    public int savePermission(Permission permission) {
        return permissionDAO.savePermission(permission);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionDAO.updatePermission(permission);
    }

    @Override
    public void deletePermission(int id) {
        permissionDAO.deletePermission(id);
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
       return permissionDAO.getAll(pagenum, pagesize);
    }

    @Override
    public Permission findById(int id) {
        return permissionDAO.findById(id);
    }
}
