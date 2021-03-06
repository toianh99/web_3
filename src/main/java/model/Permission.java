package model;

import java.io.Serializable;

public class Permission implements Serializable {
    private int idPermission;
    private String namePermission;
    private String codePermisison;
    private String desc;

//    public Permission(int idPermission, String namePermission, String codePermisison) {
//        this.idPermission = idPermission;
//        this.namePermission = namePermission;
//        this.codePermisison = codePermisison;
//    }

    public Permission() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    public String getNamePermission() {
        return namePermission;
    }

    public void setNamePermission(String namePermission) {
        this.namePermission = namePermission;
    }

    public String getCodePermisison() {
        return codePermisison;
    }

    public void setCodePermisison(String codePermisison) {
        this.codePermisison = codePermisison;
    }
}
