package application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import facade.dto.DiscountDTO;
import facade.dto.SaleDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import handlers.AddProductSaleHandler;
import handlers.CalculateDiscountHandler;
import handlers.CloseSaleHandler;
import handlers.ComissionToSaleHandler;
import handlers.GetSaleHandler;
import handlers.NewSaleHandler;

@Stateless 
public class SaleService implements ISaleServiceRemote {

	@EJB
	private NewSaleHandler newSaleHandler;
	
	@EJB
	private AddProductSaleHandler addProductSaleHandler;

	@EJB
	private CloseSaleHandler closeSaleHandler;
	
	@EJB
	private GetSaleHandler getSaleHandler;
	
	@EJB
	private CalculateDiscountHandler calculateDiscountHandler;
	
	@EJB
	private ComissionToSaleHandler comissionToSaleHandler;
	
	@Override
	public SaleDTO newSale(int vat) throws ApplicationException {
		return newSaleHandler.newSale(vat);
	}
	
	@Override
	public void addProductSale(int saleId, int productId, double qty) throws ApplicationException{
		addProductSaleHandler.addProductSale(saleId, productId, qty);
	}
	
	@Override
	public void closeSale(int saleId) throws ApplicationException {
		closeSaleHandler.closeSale(saleId);
	}

	@Override
	public Iterable<SaleDTO> listSales() throws ApplicationException {
		return getSaleHandler.getSales();
	}

	@Override
	public DiscountDTO calculateDiscount(int saleId) throws ApplicationException {
		return calculateDiscountHandler.calculateDiscount(saleId);
	}

	@Override
	public void comissionToSale(int saleId, double comission) throws ApplicationException {
		comissionToSaleHandler.comissionToSale(saleId, comission);
	}
}
