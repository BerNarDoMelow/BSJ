package business;

import dataaccess.PersistenceException;
import dataaccess.SaleRowDataGateway;
import facade.exceptions.ApplicationException;

import java.text.ParseException;

public class VendedorToSaleTransactionsScripts {

    public void vendedorToSale(int sale_id,int vendedor_id) throws ApplicationException,PersistenceException {
        try{
            SaleRowDataGateway sale = SaleRowDataGateway.find(sale_id);
            sale.update(sale_id,vendedor_id);
        }catch(PersistenceException e){
            throw new ApplicationException("sale nao existe");
        }

    }
}
