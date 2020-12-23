package controller.SERVICE.Impl;

import controller.DAO.Impl.CommuneDAOImpl;
import controller.SERVICE.ICommuneService;
import model.Commune;

import java.util.List;

public class CommuneService implements ICommuneService {
    private CommuneDAOImpl communeDAO = new CommuneDAOImpl();

    @Override
    public int saveCommune(Commune commune) {
        return 0;
    }

    @Override
    public void updateCommune(Commune commune) {

    }

    @Override
    public void deleteCommune(String maxa) {

    }

    @Override
    public Commune findById(String maxa) {
        return null;
    }

    @Override
    public List<Commune> getCommuneByIdDictrict(String id) {
        return communeDAO.getCommuneByIdDictrict(id);
    }
}
