package controller.DAO.Impl;

import controller.DAO.ICommune;
import controller.Mapper.Impl.CommuneMapper;
import model.Commune;

import java.util.List;

public class CommuneDAOImpl extends BaseDAOImpl<Commune> implements ICommune {
    @Override
    public List<Commune> getCommuneByIdDictrict(String idDictrict) {
        StringBuilder sql = new StringBuilder("SELECT * FROM commune WHERE `maph`= ? ");
        List<Commune> communes = query(sql.toString(), new CommuneMapper(),idDictrict);
       return communes.isEmpty() ?  null :  communes;
    }
}
