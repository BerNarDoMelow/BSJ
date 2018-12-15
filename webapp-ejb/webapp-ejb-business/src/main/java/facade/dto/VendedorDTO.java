package facade.dto;

import java.io.Serializable;

public class VendedorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int number;
	private final String name;
	private final int phoneNumber;
	private final double comission;
	
	public VendedorDTO(int number,String name, int phoneNumber, double comission) {
		this.number = number;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.comission = comission;
	}

	public double getTotalComission() {
		return comission;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}

}
