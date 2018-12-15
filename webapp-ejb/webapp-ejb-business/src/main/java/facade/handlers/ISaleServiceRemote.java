package facade.handlers;

import javax.ejb.Remote;

import facade.dto.DiscountDTO;
import facade.dto.SaleDTO;
import facade.exceptions.ApplicationException;

@Remote
public interface ISaleServiceRemote {
	
	public SaleDTO newSale (int vat) throws ApplicationException;
	
	public void addProductSale(int saleId, int productId, double qty) throws ApplicationException;

	void closeSale(int saleId) throws ApplicationException;

	public Iterable<SaleDTO> listSales() throws ApplicationException;

	public DiscountDTO calculateDiscount(int saleId) throws ApplicationException;

	public void comissionToSale(int saleId, double comission) throws ApplicationException;
}
