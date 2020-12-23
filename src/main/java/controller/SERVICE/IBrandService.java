package controller.SERVICE;

import model.Brand;

public interface IBrandService {
    int saveBrand(Brand brand);
    void updateBrand(Brand brand);
    void deleteBrand(int id);
    Brand findBrandById(int id);
}
