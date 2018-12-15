package handlers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import business.Sale;
import business.SaleProduct;
import business.Vendedor;
import catalogs.SaleCatalog;
import catalogs.VendedorCatalog;
import facade.dto.CustomerDTO;
import facade.dto.SaleDTO;
import facade.dto.SaleProductDTO;
import facade.dto.VendedorDTO;
import facade.exceptions.ApplicationException;

@Stateless
public class GetSaleHandler {
	
	/**
	 * The customer's catalog
	 */
	@EJB
	private SaleCatalog saleCatalog;
	
	@EJB
	private VendedorCatalog vendedorCatalog;
	
	public SaleDTO getSale(int id) throws ApplicationException {
		
		try {
			Sale sale = saleCatalog.getSaleById(id);
			CustomerDTO cDTO = new CustomerDTO(sale.getCustomer().getVATNumber(),sale.getCustomer().getPhoneNumber(),sale.getCustomer().getDesignation(),sale.getCustomer().getId());
			try {
				Vendedor v = vendedorCatalog.getVendedorByNumber(sale.getVendedor().getNumber());
				VendedorDTO vDTO = new VendedorDTO(v.getNumber(),v.getName(),v.getPhoneNumb(),v.getTotalComission());
				List<SaleProductDTO> ls = new ArrayList<>();
				for(SaleProduct s: sale.getSaleProducts()){
					ls.add(new SaleProductDTO(s.getProduct().getDescription(), s.getQty()));
				}
				return new SaleDTO(cDTO,sale.getDate(),sale.isOpen(),ls,sale.getId(),vDTO,sale.getComission());
			}catch(Exception e) {
				List<SaleProductDTO> ls = new ArrayList<>();
				for(SaleProduct s: sale.getSaleProducts()){
					ls.add(new SaleProductDTO(s.getProduct().getDescription(), s.getQty()));
				}
				System.out.println("sale comission:   " + sale.getComission());
				return new SaleDTO(cDTO,sale.getDate(),sale.isOpen(),ls,sale.getId(),null,sale.getComission());
			}				

		
		} catch (Exception e) {

			/**
			 * 
			 */
			throw new ApplicationException ("Error getting customer with id " + id, e);
		}
	}

	public List<SaleDTO> getSales() throws ApplicationException {
		try {
			List<SaleDTO> allSales = new LinkedList<>();
			for (Sale s : saleCatalog.getSales())
				allSales.add(getSale(s.getId()));
			return allSales;			
		} catch (Exception e) {
			throw new ApplicationException ("Error", e);
		}  
	}
}

