package controller.DAO;

import model.Brand;

import java.util.ArrayList;

public interface IBrand extends IBaseDAO<Brand> {
    int save(Brand brand);
    void update(Brand brand);
    void delete(int id);
    int getCount();
    ArrayList<Brand> getBrand();
}
