package presentation.web.model;

import facade.handlers.IVendedorServiceRemote;

public class UpdateTotalComissionsModel extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4567295954549849446L;
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
