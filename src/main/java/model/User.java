package model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private int idUser;
    private String username;
    private String password;
    private Role roles;

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public Role getRoles() {
        return roles;
    }

    public User() {
    }
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
