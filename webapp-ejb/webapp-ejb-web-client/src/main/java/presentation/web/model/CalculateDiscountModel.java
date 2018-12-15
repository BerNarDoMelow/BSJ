package presentation.web.model;

import facade.dto.DiscountDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;

public class CalculateDiscountModel extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ISaleServiceRemote SaleService;
	private int saleId;

	public void setSaleService(ISaleServiceRemote SaleService) {
		this.SaleService = SaleService;
	}
	
	public DiscountDTO getDiscount(int saleId) throws ApplicationException {
		return SaleService.calculateDiscount(saleId);
	}
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
	public int getSaleId() {
		return saleId;
	}
}
