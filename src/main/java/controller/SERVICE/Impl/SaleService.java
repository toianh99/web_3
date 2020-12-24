package controller.SERVICE.Impl;

import controller.DAO.Impl.SaleDAOIpml;
import controller.SERVICE.ISaleService;
import model.Sale;

import java.util.List;

public class SaleService implements ISaleService {
    private SaleDAOIpml saleDAOIpml = new SaleDAOIpml();
    @Override
    public int saveSale(Sale sale) {
        return saleDAOIpml.saveSale(sale);
    }

    @Override
    public void updateSale(Sale sale) {
        saleDAOIpml.updateSale(sale);
    }

    @Override
    public void deleteSale(int id) {
        saleDAOIpml.deleteSale(id);
    }

    @Override
    public Sale findById(int id) {
        return saleDAOIpml.findById(id);
    }

    @Override
    public List<Sale> getSalePage(int pagenum, int pagesize) {
        return null;
    }
}
