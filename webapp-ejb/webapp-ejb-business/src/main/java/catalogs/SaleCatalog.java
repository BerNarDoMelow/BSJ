package catalogs;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import business.Customer;
import business.Product;
import business.Sale;
import business.SaleProduct;
import business.Vendedor;
import enums.SaleStatus;
import facade.exceptions.ApplicationException;

@Stateless
public class SaleCatalog {
	
	/**
	 * Entity manager for accessing the persistence service 
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * The customer's catalog
	 */
	@EJB
	private CustomerCatalog customerCatalog;
	
	/**
	 * Creates new sale
	 * 
	 * @param vat The VAT number of the customer for this sale
	 * @return The newly created Sale object 
	 * @throws ApplicationException When the customer with the vat number is not found 
	 *         or the sale could not be creaetd.
	 */
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public Sale newSale (int vat) throws ApplicationException {
		Customer customer = customerCatalog.getCustomer(vat);
		Sale sale = new Sale(LocalDate.now(), customer);
		em.persist(sale);
		return sale;
	}
	
	public Sale getSaleById(int saleId) throws ApplicationException{
		TypedQuery<Sale> query = em.createNamedQuery(Sale.FIND_BY_ID, Sale.class);
		query.setParameter(Sale.SALE_ID, saleId);
		try {
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new ApplicationException ("Sale not found.");
		}
	}
	
	public List<Sale> getSales() throws ApplicationException{
		TypedQuery<Sale> query = em.createNamedQuery(Sale.GET_ALL_SALES, Sale.class);
		try {
			return query.getResultList();
		}catch(PersistenceException e) {
			throw new ApplicationException("Some error", e);
		}
	}
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void addProductSale(Product product, double qty){
		SaleProduct saleprod = new SaleProduct(product, qty);
		em.persist(saleprod);
	}
	
	public void closeSale(Sale sale) {
		sale.setStatus(SaleStatus.CLOSED);
		em.persist(sale);
	}
	
	
	public void updateVendedor(Sale sale, Vendedor vendedor) {
		sale.setVendedor(vendedor);
		em.persist(sale);
	}
	
	public void updateComissao(Sale sale, double comission) {
		sale.setComission(comission);
		em.persist(sale);
	}
	
	public List<Sale> getSalesByVendedorNumb(Vendedor vendedor) throws ApplicationException{
		TypedQuery<Sale> query = em.createNamedQuery(Sale.GET_ALL_SALES_BY_VENDEDOR_NUMB, Sale.class);
		query.setParameter(Sale.VENDEDOR, vendedor);
		try {
			return query.getResultList();
		}catch(PersistenceException e) {
			throw new ApplicationException("Some error", e);
		}
	}

}
