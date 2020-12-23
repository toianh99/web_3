package controller.SERVICE.Impl;

import controller.DAO.Impl.DictrictDAOImpl;
import controller.SERVICE.IDictrictService;
import model.Dictrict;

import java.util.List;

public class DictrictService implements IDictrictService {
    private DictrictDAOImpl dictrictDAO= new DictrictDAOImpl();
    @Override
    public List<Dictrict> finđictrictByIdProvince(String id) {
        return dictrictDAO.getAllDictrictByIDProvince(id);
    }
}
