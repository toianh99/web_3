package controller.DAO;

import model.Province;

import java.util.List;

public interface IProvince extends IBaseDAO<Province> {
    List<Province> getProvince(int pagenum, int pagesize);
}
