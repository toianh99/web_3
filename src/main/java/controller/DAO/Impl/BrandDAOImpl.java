package controller.DAO.Impl;


import controller.DAO.IBrand;
import controller.Mapper.Impl.BrandMapper;
import model.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandDAOImpl extends BaseDAOImpl<Brand> implements IBrand {
    @Override
    public int saveBrand(Brand brand) {
        StringBuilder sql = new StringBuilder("INSERT INTO brand (nameBrand, `desc`)");
        sql.append(" VALUES(?, ?)");
        return insert(sql.toString(),brand.getNameBrand(),brand.getCodeBrand());
    }

    @Override
    public void updateBrand(Brand brand) {
        StringBuilder sql = new StringBuilder("UPDATE brand SET nameBrand = ?, desc = ? WHERE idBrand = ?");
        update(sql.toString(), brand.getNameBrand(),brand.getCodeBrand(),brand.getIdBrand());
    }

    @Override
    public void deleteBrand(int id) {
        String sql = "DELETE FROM brand WHERE idBrand = ?";
        update(sql, id);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public List<Brand> findBrand(int pagenum, int pagesize) {
        String sql = "SELECT * FROM brand LIMIT ?,?";
        return query(sql, new BrandMapper(),pagenum,pagesize);
    }

    @Override
    public Brand findByName(String name) {
        String sql = "SELECT * FROM brand WHERE nameBrand = ?";
        List<Brand> brands = query(sql, new BrandMapper(), name);
        return brands.isEmpty() ? null : brands.get(0);
    }

    @Override
    public Brand findById(int id) {
        String sql = "SELECT * FROM brand WHERE idBrand = ?";
        List<Brand> brands = query(sql, new BrandMapper(),id);
        return brands.isEmpty() ? null : brands.get(0);
    }

    @Override
    public ArrayList<Brand> getBrand() {
        return null;
    }
}
