package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Customer;
import catalogs.VendedorCatalog;
import facade.dto.CustomerDTO;
import facade.exceptions.ApplicationException;

@Stateless
public class CreateVendedorHandler {
	
	@EJB
	private VendedorCatalog vendedorCatalog;
	
	
	public void createVendedor(int number, String name, int phoneNumber) throws ApplicationException {
		try {
			vendedorCatalog.newVendedor(number, name, phoneNumber);
		} catch (Exception e) {
			throw new ApplicationException ("Error adding vendedor with number " + number, e);
		}
	}
	
}
