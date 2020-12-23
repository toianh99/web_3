package controller.DAO.Impl;

import controller.DAO.IDictrict;
import controller.Mapper.Impl.DictrictMapper;
import model.Dictrict;

import java.util.List;

public class DictrictDAOImpl extends BaseDAOImpl<Dictrict> implements IDictrict {
    @Override
    public List<Dictrict> getAllDictrictByIDProvince(String idProvince) {
        StringBuilder sql = new StringBuilder("SELECT * FROM `dictrict` WHERE `maptp` = ?");
        List<Dictrict> dictricts = query(sql.toString(), new DictrictMapper(),idProvince);
        return dictricts.isEmpty() ? null : dictricts;
    }
}
