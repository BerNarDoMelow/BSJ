package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Sale;
import business.Vendedor;
import catalogs.SaleCatalog;
import catalogs.VendedorCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class VendedorToSaleHandler {
	
	@EJB
	private VendedorCatalog vendedorCatalog;
	
	@EJB
	private SaleCatalog saleCatalog;
	
	public void vendedorToSale(int saleId, int number) throws ApplicationException {
		Sale sale = saleCatalog.getSaleById(saleId);
		if(sale.isOpen()) {
			try {
				Vendedor vendedor = vendedorCatalog.getVendedorByNumber(number);
				saleCatalog.updateVendedor(sale, vendedor);
			}catch(Exception e) {
				throw new ApplicationException("some went wrong", e);
			}
		}else {
			throw new ApplicationException("Sale is closed");
		}
	}
}
