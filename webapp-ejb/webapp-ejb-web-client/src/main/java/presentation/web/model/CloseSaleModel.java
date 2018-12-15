package presentation.web.model;

import facade.handlers.ISaleServiceRemote;

public class CloseSaleModel extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int saleId;
	private ISaleServiceRemote SaleService;
	
		
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
	public void setSaleService(ISaleServiceRemote SaleService) {
		this.SaleService = SaleService;
	}

	public int getSaleId() {
		return saleId;
	}
}
