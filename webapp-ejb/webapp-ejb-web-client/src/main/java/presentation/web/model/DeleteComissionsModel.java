package presentation.web.model;

import facade.handlers.IVendedorServiceRemote;

public class DeleteComissionsModel extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872647717320124372L;
	private IVendedorServiceRemote VendedorService;
	private int number;
	
	public void setVendedorService(IVendedorServiceRemote VendedorService) {
		this.VendedorService = VendedorService;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}
