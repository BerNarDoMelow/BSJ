package business;

import dataaccess.PersistenceException;
import dataaccess.SaleRowDataGateway;



public class ComissaoToSaleTransactionsScripts {

    public void comissaoToSale(int sale_id, int comissao) throws ApplicationException, PersistenceException{
        try{
            SaleRowDataGateway sale = SaleRowDataGateway.find(sale_id);
            if(sale.getStatus() == SaleStatus.OPEN){
                sale.updateComissao(sale_id,comissao);
            }
        }catch(PersistenceException e){
            throw new ApplicationException("sale nao existe");
        }
    }
}
