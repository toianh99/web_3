package controller.DAO.Impl;

import controller.DAO.IStaff;
import controller.Mapper.Impl.StaffMapper;
import model.Staff;

import java.util.List;

public class StaffDAOImpl extends BaseDAOImpl<Staff> implements IStaff {
    @Override
    public int saveStaff(Staff staff) {
       StringBuilder sql = new StringBuilder("INSERT INTO `staff`(`Posittion`,`Task`,`UserID`)");
       sql.append("VALUES( ?, ?, ?)");
       return insert(sql.toString(),staff.getPosittion(),staff.getTask(),staff.getIdUser());
    }

    @Override
    public void updateStaff(Staff staff) {
        String sql ="UPDATE `staff` SET `Posittion`=?,`Task`=? WHERE `UserID`=?";
        update(sql,staff.getPosittion(),staff.getTask(),staff.getIdUser());
    }

    @Override
    public void deleteStaff(int id) {
        String sql ="DELETE * from `staff` WHERE `UserID` =?";
        update(sql,id);
    }

    @Override
    public Staff findStaffById(int id) {
        String sql ="SELECT * FROM `staff` WHERE `UserID` = ? ";
        return query(sql,new StaffMapper(),id).get(0);
    }

    @Override
    public List<Staff> findStaffByPage(int pagenum, int pagesize) {
        String sql ="SELECT * FROM `staff` LIMIT ?,?";
        return query(sql,new StaffMapper(),pagenum,pagesize);
    }
}
