package facade.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import business.Vendedor;

public class SaleDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final CustomerDTO customer;
	private final LocalDate saleDate;
	private final boolean isOpen;
	private final List<SaleProductDTO> saleProducts;
	private final int id;
	private final VendedorDTO vendedor;
	private final double comission;
	
	public SaleDTO(CustomerDTO customer, LocalDate saleDate, boolean isOpen, 
			       List<SaleProductDTO> saleProducts, int id,VendedorDTO vendedor,double comission) {
		this.customer = customer;
		this.saleDate = saleDate;
		this.isOpen = isOpen;
		this.saleProducts = saleProducts;
		this.id = id;
		this.vendedor = vendedor;
		this.comission = comission;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public List<SaleProductDTO> getSaleProducts() {
		return saleProducts;
	}
	
	public int getId() {
		return id;
	}
	
	public VendedorDTO getVendedor() {
		return vendedor;
	}

	public double getComission() {
		return comission;
	}
}
