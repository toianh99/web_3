package controller.DAO;



import model.Permission;

import java.util.List;

public interface IPermission extends IBaseDAO<Permission> {
    Long savePermission(Permission permission);
    void updatePermission(Permission permission);
    void deletePermission(int id);
    List<Permission> findByIdRole(int idRole);
    List<Permission> findByIdUser (int idUser);
    List<Permission> getAll(int pagenum,int pagesize);
    Permission findById(int id);
}
