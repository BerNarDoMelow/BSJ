package presentation.web.model;

import java.util.LinkedList;
import java.util.List;

import business.Vendedor;
import facade.dto.SaleDTO;
import facade.dto.SaleProductDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;

public class ListSalesModel extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ISaleServiceRemote SaleService;

	
	public void setSaleService(ISaleServiceRemote SaleService) {
		this.SaleService = SaleService;
	}
		
	public Iterable<SaleDTO> getSales() throws ApplicationException{
		return SaleService.listSales();
	}
	
	
	public List<SaleProductDTO> getSaleProducts(int saleId) throws ApplicationException{
		List<SaleProductDTO> list = new LinkedList<>();
		for(SaleDTO sale: getSales()) {
			if(sale.getId() == saleId) {
				for(SaleProductDTO sp: sale.getSaleProducts()) {
					list.add(sp);
				}
			}
		}return list;
	}

}
