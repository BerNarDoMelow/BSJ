package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Sale;
import catalogs.SaleCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class ComissionToSaleHandler {

	@EJB
	private SaleCatalog saleCatalog;
	
	public void comissionToSale(int saleId, double comission) throws ApplicationException {
		Sale sale = saleCatalog.getSaleById(saleId);
		if(sale.isOpen()) {
			saleCatalog.updateComissao(sale, comission);
		}else {
			throw new ApplicationException("Some error");
		}
	}
}
