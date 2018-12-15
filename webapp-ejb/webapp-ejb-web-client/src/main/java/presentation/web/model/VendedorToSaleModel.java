package presentation.web.model;

import facade.handlers.IVendedorServiceRemote;

public class VendedorToSaleModel extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IVendedorServiceRemote VendedorService;
	
	private int saleid;
	private int number;
	
	public void setVendedorService(IVendedorServiceRemote VendedorService) {
		this.VendedorService = VendedorService;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setSaleid(int saleid) {
		this.saleid = saleid;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getSaleId() {
		return saleid;
	}
}
