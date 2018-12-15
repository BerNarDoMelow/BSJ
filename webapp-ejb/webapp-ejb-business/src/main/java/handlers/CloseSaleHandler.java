package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Sale;
import catalogs.SaleCatalog;
import catalogs.VendedorCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class CloseSaleHandler {
	
	@EJB
	private SaleCatalog saleCatalog;
	
	@EJB
	private VendedorCatalog vendedorCatalog;
	
	public void closeSale(int saleId) throws ApplicationException {
		Sale sale = saleCatalog.getSaleById(saleId);
		if(sale.isOpen()) {
			saleCatalog.closeSale(sale);
		}else {
			throw new ApplicationException("Sale does not exists");
		}
	}
}
