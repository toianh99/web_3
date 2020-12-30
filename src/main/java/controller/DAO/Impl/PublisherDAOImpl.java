package controller.DAO.Impl;

import controller.DAO.Ipublisher;
import controller.Mapper.Impl.PublisherMapper;
import model.Publisher;

import java.util.List;

public class PublisherDAOImpl extends BaseDAOImpl<Publisher> implements Ipublisher {
    @Override
    public int savePublisher(Publisher publisher) {
        StringBuilder sql = new StringBuilder("INSERT INTO `publisher` ( `Name`,`Desc` )");
        sql.append("VALUES( ? , ?)");
        return insert(sql.toString(),publisher.getName(),publisher.getDesc());
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        String sql="UPDATE `publisher` SET `Name`= ? , `Desc` = ? WHERE `ID` =?" ;
        update(sql,publisher.getName(),publisher.getDesc(),publisher.getId());
    }

    @Override
    public void deletePublisher(int id) {
        String sql="DELETE FROM `publisher` WHERE `ID`=?";
        update(sql,id);
    }

    @Override
    public Publisher getPublisherById(int id) {
        String sql = " SELECT * FROM `publisher` WHERE `ID` = ? ";
       return query(sql,new PublisherMapper(),id).get(0);
    }

    @Override
    public List<Publisher> getPublisher(int pagenum, int pagesize) {
        String sql ="SELECT * FROM `publisher` LIMIT ?,?";
        return query(sql,new PublisherMapper(),pagenum,pagesize);
    }
}
