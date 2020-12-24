package controller.SERVICE.Impl;

import controller.DAO.Impl.RoleDAOImpl;
import controller.SERVICE.IRoleService;
import model.Permission;
import model.Role;

import java.util.List;

public class RoleService implements IRoleService {
    private RoleDAOImpl roleDAO = new RoleDAOImpl();
    @Override
    public int saveRole(Role role) {
        int idRole =  roleDAO.saveRole(role);
        for (Permission p : role.getPermissions()) {
            roleDAO.saveRole_Permission(idRole,p.getIdPermission());
        }
        return idRole;
    }

    @Override
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Override
    public void deleteRole(int id) {
        roleDAO.deleteRole(id);
    }

    @Override
    public Role findById(int idRole) {
        return roleDAO.findById(idRole);
    }

    @Override
    public List<Role> getAll(int pagenum, int pagesize) {
        return roleDAO.getAll(pagenum, pagesize);
    }

    @Override
    public int saveRolePermission(int idRole, int idPermission) {
        return 0;
    }
}
