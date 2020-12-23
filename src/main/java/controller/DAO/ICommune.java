package controller.DAO;

import model.Commune;

import java.util.List;

public interface ICommune extends IBaseDAO<Commune> {
    List<Commune> getCommuneByIdDictrict(String idDictrict);
}
