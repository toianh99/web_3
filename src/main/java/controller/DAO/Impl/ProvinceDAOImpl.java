package controller.DAO.Impl;

import controller.DAO.IProvince;
import controller.Mapper.Impl.ProvinceMapper;
import model.Province;

import java.util.List;

public class ProvinceDAOImpl extends BaseDAOImpl<Province> implements IProvince {
    @Override
    public List<Province> getProvince(int pagenum, int pagesize) {
        String sql="SELECT * FROM `province` LIMIT ? ,?";
        return query(sql,new ProvinceMapper(),pagenum,pagesize);
    }
}
