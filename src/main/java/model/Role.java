package model;

import java.io.Serializable;

public class Role implements Serializable {
    private int idRole;
    private String nameRole;
    private String codeRole;
    private String desc;

    public Role(int idRole, String nameRole, String codeRole, String desc) {
        this.idRole = idRole;
        this.nameRole = nameRole;
        this.codeRole = codeRole;
        this.desc = desc;
    }

    public Role() {
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public String getCodeRole() {
        return codeRole;
    }

    public void setCodeRole(String codeRole) {
        this.codeRole = codeRole;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
