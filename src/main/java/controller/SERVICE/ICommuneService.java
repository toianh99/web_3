package controller.SERVICE;

import model.Commune;

import java.util.List;

public interface ICommuneService {
    int saveCommune(Commune commune);
    void updateCommune(Commune commune);
    void deleteCommune(String maxa);
    Commune findById(String maxa);
    List<Commune> getCommuneByIdDictrict(String id);
}
