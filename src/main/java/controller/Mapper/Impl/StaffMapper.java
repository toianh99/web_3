package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffMapper implements RowMapper<Staff> {
    @Override
    public Staff mapRow(ResultSet rs) throws SQLException {
        try {
            Staff staff = new Staff();
            staff.setIdStaff(rs.getInt("UserID"));
            staff.setPosittion(rs.getString("Posittion"));
            staff.setTask(rs.getString("Task"));
            return staff;
        }catch (Exception e){
            System.out.println("lỗi mapper staff");
        }
        return null;
    }
}
