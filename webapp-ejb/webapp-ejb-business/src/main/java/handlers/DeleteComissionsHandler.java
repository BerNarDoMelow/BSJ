package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Vendedor;
import catalogs.VendedorCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class DeleteComissionsHandler {
	
	@EJB
	private VendedorCatalog vendedorCatalog;
	
	public void deleteComissions(int number) throws ApplicationException {
		Vendedor vendedor = vendedorCatalog.getVendedorByNumber(number);
		vendedorCatalog.deleteComission(vendedor);
	}
}

