package controller.DAO;

import model.Sale;

import java.util.List;

public interface ISale extends IBaseDAO<Sale>{
    int saveSale(Sale sale);
    void updateSale(Sale sale);
    void deleteSale(int id);
    Sale findById(int id);
    List<Sale> getSalePage(int pagenum,int pagesize);
}
