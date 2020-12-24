package controller.SERVICE;

import model.Staff;

import java.util.List;

public interface IStaffService {
    int saveStaff(Staff staff);
    void updateStaff(Staff staff);
    void deleteStaff(int id);
    Staff findStaffById(int id);
    List<Staff> findStaffByPage(int pagenum, int pagesize);
}
