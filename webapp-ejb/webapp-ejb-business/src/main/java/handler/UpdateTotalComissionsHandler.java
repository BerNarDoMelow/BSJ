package handler;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Sale;
import business.Vendedor;
import catalogs.SaleCatalog;
import catalogs.VendedorCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class UpdateTotalComissionsHandler {
	
	@EJB
	private VendedorCatalog vendedorCatalog;
	
	@EJB
	private SaleCatalog saleCatalog;
	
	public void updateTotalComissions(int number) throws ApplicationException {
		Vendedor vendedor = vendedorCatalog.getVendedorByNumber(number);
		double total = vendedor.getTotalComission();
		List<Sale> sales = saleCatalog.getSalesByVendedorNumb(vendedor);
		for(Sale sale: sales) {
			if (!sale.isOpen()) {
				total += (sale.total() - sale.discount()) * 1/sale.getComission();
			}
		}
		vendedorCatalog.setComission(vendedor,total);
	}
}
