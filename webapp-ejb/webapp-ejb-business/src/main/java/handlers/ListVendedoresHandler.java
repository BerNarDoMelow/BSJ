package handlers;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Vendedor;
import catalogs.VendedorCatalog;
import facade.dto.VendedorDTO;
import facade.exceptions.ApplicationException;

@Stateless
public class ListVendedoresHandler {

	@EJB
	private VendedorCatalog vendedorCatalog;
	
	
	public List<VendedorDTO> getVendedores() throws ApplicationException{
		List<VendedorDTO> list = new LinkedList<>();
		for(Vendedor vendedor: vendedorCatalog.getVendedores()) {
			list.add(new VendedorDTO(vendedor.getNumber(), vendedor.getName(), vendedor.getPhoneNumb(), vendedor.getTotalComission()));
		}return list;
	}
}
