package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Customer;
import business.Sale;
import catalogs.SaleCatalog;
import facade.dto.DiscountDTO;
import facade.exceptions.ApplicationException;

@Stateless
public class CalculateDiscountHandler {
	
	@EJB
	private SaleCatalog saleCatalog;
	
	
	public DiscountDTO calculateDiscount(int saleId) throws ApplicationException {
		Sale sale = saleCatalog.getSaleById(saleId);
		Customer customer = sale.getCustomer();
		int id = customer.getDiscountType().getId();
		String description = customer.getDiscountType().getDescription();
		double total = sale.discount();
		System.out.println("total: " + total);
		DiscountDTO dDTO = new DiscountDTO(id, description, total);
		return dDTO;
	}
}
