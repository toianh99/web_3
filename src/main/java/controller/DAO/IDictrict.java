package controller.DAO;

import model.Dictrict;

import java.util.List;

public interface IDictrict extends IBaseDAO<Dictrict> {
    List<Dictrict> getAllDictrictByIDProvince(String idProvince);

}
