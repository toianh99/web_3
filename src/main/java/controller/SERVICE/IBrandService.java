package controller.SERVICE;

import model.Brand;

import java.util.List;

public interface IBrandService {
    int saveBrand(Brand brand);
    void updateBrand(Brand brand);
    void deleteBrand(int id);
    Brand findBrandById(int id);
    List<Brand> getBrandByPage(int pagenum,int pagesize);
}
