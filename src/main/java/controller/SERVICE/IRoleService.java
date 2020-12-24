package controller.SERVICE;

import model.Role;

import java.util.List;

public interface IRoleService {
    int saveRole(Role role);
    void updateRole(Role role);
    void deleteRole(int id);
    Role findById(int idRole);
    List<Role> getAll(int pagenum, int pagesize);
    int saveRolePermission(int idRole, int idPermission);
}
