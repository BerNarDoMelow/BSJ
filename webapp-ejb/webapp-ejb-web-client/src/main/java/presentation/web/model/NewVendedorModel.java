package presentation.web.model;

import facade.handlers.IVendedorServiceRemote;

public class NewVendedorModel extends Model{
	
	private IVendedorServiceRemote VendedorService;
	
	private int phoneNumb;
	private String name;
	private int number;
	private double comission;

	
	public void setVendedorService(IVendedorServiceRemote VsendedorService) {
		this.VendedorService = VendedorService;
	}
	public int getPhoneNumb() {
		return phoneNumb;
	}
	public void setPhoneNumb(int phoneNumb) {
		this.phoneNumb = phoneNumb;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
