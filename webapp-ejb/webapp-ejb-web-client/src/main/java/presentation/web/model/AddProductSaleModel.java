package presentation.web.model;

import facade.handlers.ISaleServiceRemote;

public class AddProductSaleModel extends Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int saleId;
	private double qty;
	private int productId;
	
	private ISaleServiceRemote saleService;
	
	public int getSaleId(){
		return saleId; 
	}
	
	public void setSaleId(int saleId){
		this.saleId = saleId;
	}
	
	public double getQty(){
		return qty; 
	}
	
	public void setQty(double qty){
		this.qty = qty;
	}
	
	
	public int getProductId(){
		return productId; 
	}
	
	public void setProductId(int productId){
		this.productId = productId;
	}
	
	public void setProductSaleService(ISaleServiceRemote saleService){
		this.setSaleService(saleService);
	}

	public void setSaleService(ISaleServiceRemote saleService) {
		this.saleService = saleService;
	}
	
	
	
	
	
}

