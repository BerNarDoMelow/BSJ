package presentation.web.model;

import java.util.List;

import facade.dto.VendedorDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IVendedorServiceRemote;

public class ListVendedoresModel extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3815250664730238003L;
	
	private IVendedorServiceRemote VendedorService;
	
	public void setVendedorService(IVendedorServiceRemote VendedorService) {
		this.VendedorService = VendedorService;
	}
	
	public List<VendedorDTO> getVendedores() throws ApplicationException{
		return VendedorService.getVendedores();
	}
}
