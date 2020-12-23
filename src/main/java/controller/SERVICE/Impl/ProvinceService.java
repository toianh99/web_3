package controller.SERVICE.Impl;

import controller.DAO.Impl.ProvinceDAOImpl;
import controller.SERVICE.IProductService;
import model.Province;

import java.util.List;

public class ProvinceService implements IProductService {
    private ProvinceDAOImpl provinceDAO = new ProvinceDAOImpl();
    @Override
    public List<Province> getProvince() {
        return provinceDAO.getProvince(0,100);
    }
}
