package business;

import dataaccess.PersistenceException;
import dataaccess.SaleRowDataGateway;
import business.ApplicationException;

import java.sql.SQLException;
import java.text.ParseException;

public class VendedorToSaleTransactionsScripts {


    public void vendedorToSale(int sale_id,int funcNumb) throws ApplicationException, PersistenceException {
        ///PRIMEIRO IR BUSCAR O CLIENT COM FUNCNUMB!!!
        
        try{
            SaleRowDataGateway sale = SaleRowDataGateway.find(sale_id);
            if(sale.getStatus() == SaleStatus.OPEN){
                sale.updateVendedor(sale_id,vendedor_id);
            }
        }catch(PersistenceException e){
            throw new ApplicationException("sale nao existe");
        }
    }
}
