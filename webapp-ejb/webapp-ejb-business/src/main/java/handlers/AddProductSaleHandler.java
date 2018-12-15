package handlers;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Product;
import business.Sale;
import catalogs.ProductCatalog;
import catalogs.SaleCatalog;
import facade.exceptions.ApplicationException;

@Stateless
public class AddProductSaleHandler {
	
	@EJB
	private SaleCatalog saleCatalog;
	
	@EJB
	private ProductCatalog productCatalog;
	
	public void addProductSale(int saleId,int productId, double qty) throws ApplicationException{
		Sale sale = saleCatalog.getSaleById(saleId);
		if(!sale.isOpen()){
			throw new ApplicationException("Sale is closed");
		}
		Product product = productCatalog.getProduct(productId);
		if(product.getQty() >= qty){
			try{
				product.setQty(product.getQty() - qty);
				sale.addProductToSale(product, qty);
				saleCatalog.addProductSale(product,qty);
			}catch(Exception e){
				throw new ApplicationException("Something went wrong");
			}
		}else{
			throw new ApplicationException("Stock error");
		}
	}
}
