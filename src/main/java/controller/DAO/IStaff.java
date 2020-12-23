package controller.DAO;

import model.Staff;

import java.util.List;

public interface IStaff extends IBaseDAO<Staff> {
    int saveStaff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(int id);
    Staff findStaffById(int id);
    List<Staff> findStaffByPage(int pagenum,int pagesize);
}
