package catalogs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import business.Sale;
import business.Vendedor;
import facade.exceptions.ApplicationException;

@Stateless
public class VendedorCatalog {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public Vendedor newVendedor (int number,String name, int phoneNumber) throws ApplicationException {
		Vendedor vendedor = new Vendedor(number,name,phoneNumber);
		em.persist(vendedor);
		return vendedor;
	}
	
	public Vendedor getVendedorByNumber(int number) throws ApplicationException {
		TypedQuery<Vendedor> query = em.createNamedQuery(Vendedor.FIND_BY_NUMBER, Vendedor.class);
		query.setParameter(Vendedor.NUMBER, number);
		try {
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new ApplicationException ("vendedor not found.");
		}
	}
	
	public List<Vendedor> getVendedores() throws ApplicationException{
		TypedQuery<Vendedor> query = em.createNamedQuery(Vendedor.GET_ALL_VENDEDORES, Vendedor.class);
		try {
			return query.getResultList();
		}catch(PersistenceException e) {
			throw new ApplicationException("Some error", e);
		}
	}
	
	public void setComission(Vendedor vendedor, double total) {
		vendedor.setTotalComission(total);
		em.persist(vendedor);
	}
	
	public void deleteComission(Vendedor vendedor) {
		vendedor.setTotalComission(0.0);
		em.persist(vendedor);
	}
}
