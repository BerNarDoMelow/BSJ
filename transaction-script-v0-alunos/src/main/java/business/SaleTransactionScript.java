package business;

import facade.exceptions.ApplicationException;
import dataaccess.*;

import java.util.Date;
import java.util.Optional;

public class SaleTransactionScript {


    public int newSale(int vat) throws ApplicationException, PersistenceException {
        try(CustomerRowDataGateway customer = CustomerRowDataGateway.findWithVATNumber(vat)){
            int customerId = customer.getCustomerId();
            SaleRowDataGateway sale = new SaleRowDataGateway(customerId,new Date());
            sale.insert();
            return 0;
        }catch(ApplicationException e){
            throw new ApplicationException ("Invalid VAT number: " + vat);
        }
    }

    public double getSaleDiscount(int saleId) throws ApplicationException {
        Optional<SaleRowDataGateway> sale = SaleRowDataGateway.getSaleById(saleId);
        if(sale.isPresent()) {
            double discont = sale.get().getDiscount();
            return discont;
        }else{
            throw new ApplicationException("invalid sale id: "+saleId);
        }
    }
}

