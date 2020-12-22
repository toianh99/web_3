package controller.Mapper.Impl;

import controller.Mapper.RowMapper;
import model.Publisher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherMapper implements RowMapper<Publisher> {
    @Override
    public Publisher mapRow(ResultSet rs) throws SQLException {
        try{
            Publisher publisher = new Publisher();
            publisher.setId(rs.getInt("ID"));
            publisher.setName(rs.getString("Name"));
            publisher.setDesc(rs.getString("Desc"));
            return publisher;
        }catch (Exception  ex){
            System.out.println("lỗi mapper publisher");
        }
        return null;
    }
}
