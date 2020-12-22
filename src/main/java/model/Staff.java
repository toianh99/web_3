package model;

import java.io.Serializable;

public class Staff  extends User implements Serializable {
    private int idStaff;
    private String task;
    private String posittion;

    public Staff(int idStaff, String task, String posittion) {
        this.idStaff = idStaff;
        this.task = task;
        this.posittion = posittion;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPosittion() {
        return posittion;
    }

    public void setPosittion(String posittion) {
        this.posittion = posittion;
    }
}
