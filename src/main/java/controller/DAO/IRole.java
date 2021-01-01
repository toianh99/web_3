package controller.DAO;

import model.Permission;
import model.Role;

import java.util.List;

public interface IRole {
    int saveRole(Role role);
    int saveRole_Permission(int idRole, int idPermisison);
    int saveRoleUser(int idUser, int idRole);
    void updateRole(Role role);
    void deleteRole(int id);
    Role findById(int idRole);
    List<Role> getAll(int pagenum, int pagesize);
    int saveRolePermission(int idRole, int idPermission);
    List<Role> getRoleByIdUser(int id);
    void deleteUserRole(int idUser,int idRole);
}
