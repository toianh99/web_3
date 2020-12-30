package controller.SERVICE.Impl;

import controller.DAO.IBrand;
import controller.DAO.Impl.BrandDAOImpl;
import controller.SERVICE.IBrandService;
import model.Brand;

import java.util.List;

public class BrandService implements IBrandService {
    private BrandDAOImpl brandDAO = new BrandDAOImpl();
    @Override
    public int saveBrand(Brand brand) {
       int id= brandDAO.saveBrand(brand);
        return id>0 ? id : 0;
    }

    @Override
    public void updateBrand(Brand brand) {
        brandDAO.updateBrand(brand);
    }

    @Override
    public void deleteBrand(int id) {
        brandDAO.deleteBrand(id);
    }

    @Override
    public Brand findBrandById(int id) {
        return brandDAO.findById(id);
    }

    @Override
    public List<Brand> getBrandByPage(int pagenum, int pagesize) {
        return brandDAO.findBrand(pagenum,pagesize);
    }
}
