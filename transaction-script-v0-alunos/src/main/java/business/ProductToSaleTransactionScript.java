package business;

import dataaccess.SaleProductRowDataGateway;
import dataaccess.SaleRowDataGateway;
import facade.exceptions.ApplicationException;

import java.util.Optional;

public class ProductToSaleTransactionScript {

    public void addProductToSale(int saleId, int productCode, int qty)
            throws ApplicationException {
        Optional<SaleRowDataGateway> sale = SaleRowDataGateway.getSaleById(saleId);
        if (sale.isPresent()) {
            SaleProductRowDataGateway salePRDG = new SaleProductRowDataGateway(saleId, productCode, qty);
            salePRDG.insert();
        } else {
            throw new ApplicationException("Nao existe essa sale");
        }
    }
}