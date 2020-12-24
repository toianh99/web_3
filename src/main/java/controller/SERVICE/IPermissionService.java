package controller.SERVICE;

import model.Permission;

import java.util.List;

public interface IPermissionService {
    int savePermission(Permission permission);
    void updatePermission(Permission permission);
    void deletePermission(int id);
    List<Permission> findByIdRole(int idRole);
    List<Permission> findByIdUser (int idUser);
    List<Permission> getAll(int pagenum,int pagesize);
    Permission findById(int id);
}
