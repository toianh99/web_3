package controller.DAO.Impl;

import controller.DAO.ISale;
import controller.Mapper.Impl.SaleMapper;
import model.Sale;

import java.util.List;

public class SaleDAOIpml extends BaseDAOImpl<Sale> implements ISale {
    @Override
    public int saveSale(Sale sale) {
        StringBuilder sql = new StringBuilder("INSERT INTO `sale` (`Name`,`Percent`,`Desc` ) ");
        sql.append("VALUES( ?, ? , ? )");
        return insert(sql.toString(),sale.getNameSale(),sale.getPercent(),sale.getDesc());
    }

    @Override
    public void updateSale(Sale sale) {
        String sql ="UPDATE `sale` SET `Name` = ? ,`Percent`=?,`Desc` =? WHERE `ID` =?";
        update(sql,sale.getNameSale(),sale.getPercent(),sale.getDesc(),sale.getIdSale());
    }

    @Override
    public void deleteSale(int id) {
        String sql = "DELETE * FROM `sale` WHERE `ID` = ? ";
        update(sql,id);
    }

    @Override
    public Sale findById(int id) {
        String sql ="SELECT * FROM `sale` WHERE `ID` = ? ";
        return query(sql, new SaleMapper(),id).get(0);
    }

    @Override
    public List<Sale> getSalePage(int pagenum, int pagesize) {
        String sql = " SELECT * FROM `sale` LIMIT ? , ? ";
        List<Sale> sales = query(sql, new SaleMapper(),pagenum,pagesize);
        return sales.isEmpty() ? null : sales;
    }
}
