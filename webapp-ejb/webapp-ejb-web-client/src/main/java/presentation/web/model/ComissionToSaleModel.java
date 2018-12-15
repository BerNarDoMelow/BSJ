package presentation.web.model;

import facade.handlers.ISaleServiceRemote;

public class ComissionToSaleModel extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ISaleServiceRemote SaleService;
	private int saleId;
	private double comission;
	
	public void setSaleService(ISaleServiceRemote SaleService){
		this.SaleService = SaleService;
	}

	public void setComission(double comission) {
		this.comission = comission;
	}
	
	public double getComission() {
		return comission;
	}
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
	public int getSaleId() {
		return saleId;
	}
}
