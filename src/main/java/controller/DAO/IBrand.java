package controller.DAO;

import model.Brand;

import java.util.ArrayList;
import java.util.List;

public interface IBrand extends IBaseDAO<Brand> {
    int saveBrand(Brand brand);
    void updateBrand(Brand brand);
    void deleteBrand(int id);
    int getCount();
    List<Brand> findBrand(int pagenum, int pagesize);
    Brand findByName(String name);
    Brand findById(int id);
    ArrayList<Brand> getBrand();
}
