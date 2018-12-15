package business;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import enums.SaleStatus;
import facade.exceptions.ApplicationException;
import utilities.DateUtils;

/**
 * A sale
 *	
 * @author fmartins
 * @version 1.1 (17/04/2015)
 * 
 */
@Entity 
@NamedQueries({
	@NamedQuery(name=Sale.FIND_BY_ID, query="SELECT s FROM Sale s WHERE s.id = :" + Sale.SALE_ID),
	@NamedQuery(name=Sale.GET_ALL_SALES, query="SELECT s FROM Sale s"),
	@NamedQuery(name=Sale.GET_ALL_SALES_BY_VENDEDOR_NUMB,query="SELECT s FROM Sale s WHERE s.vendedor = :" + Sale.VENDEDOR)
})
public class Sale {

	public static final String GET_ALL_SALES = "Sale.getAllSales";
	
	public static final String FIND_BY_ID = "Sale.findById";
	public static final String SALE_ID = "saleid";

	public static final String GET_ALL_SALES_BY_VENDEDOR_NUMB = "Sale.getAllSalesByVendedorNumb";
	public static final String VENDEDOR = "vendedor";
	/**
	 * Sale primary key. Needed by JPA. Notice that it is not part of the
	 * original domain model.
	 */
	@Id	@GeneratedValue private int id;
	
	/**
	 * The date the sale was made 
	 */
	//@Temporal(TemporalType.DATE)
    @Convert(converter = DateUtils.class)
	private LocalDate date;

	/**
	 * Whether the sale is open or closed. 
	 */
	@Enumerated(STRING) private SaleStatus status;
	
	@ManyToOne private Customer customer;
	
	@ManyToOne private Vendedor vendedor;
	
	@Column(nullable = true)
	private double comission;
	/**
	 * The products of the sale
	 */
	@OneToMany(cascade = ALL) @JoinColumn
	private List<SaleProduct> saleProducts;
	
	@Version
	private int version;
	
	// 1. constructor

	/**
	 * Constructor needed by JPA.
	 */
	Sale () {
	}
	
	/**
	 * Creates a new sale given the date it occurred and the customer that
	 * made the purchase.
	 * 
	 * @param date The date that the sale occurred
	 * @param customer The customer that made the purchase
	 */
	public Sale(LocalDate date, Customer customer) {
		this.date = date;
		this.customer = customer;
		this.status = SaleStatus.OPEN;
		this.saleProducts = new LinkedList<SaleProduct>();
	}

	
	// 2. getters and setters

	/**
	 * @return The sale's total 
	 */
	public double total() {
		double total = 0;
		for (SaleProduct sp : saleProducts)
			total += sp.getSubTotal();
		return total;
	}

	/**
	 * @return The sale's amount eligible for discount
	 */
	public double eligibleDiscountTotal () {
		double total = 0;
		for (SaleProduct sp : saleProducts)
			total += sp.getEligibleSubtotal();
		return total;
	}
	
	/**
	 * @return Computes the sale's discount amount based on the discount type of the customer.
	 */
	public double discount () {
		Discount discount = customer.getDiscountType();
		return discount.computeDiscount(this);
	}

	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @return Whether the sale is open
	 */
	public boolean isOpen() {
		return status == SaleStatus.OPEN;
	}

	/**
	 * Adds a product to the sale
	 * 
	 * @param product The product to sale
	 * @param qty The amount of the product being sold
	 * @throws ApplicationException 
	 */
	public void addProductToSale(Product product, double qty) 
			throws ApplicationException {
		if (!isOpen())
			throw new ApplicationException("Cannot add products to a closed sale.");

		// if there is enough stock
		if (product.getQty() >= qty) {
			// adds product to sale
			product.setQty(product.getQty() - qty);
			saleProducts.add(new SaleProduct(product, qty));
		} else
			throw new ApplicationException("Product " + product.getProdCod() + " has stock ("  + 
							product.getQty() + ") which is insuficient for the current sale");
	}

	public LocalDate getDate() {
		return date;
	}
	
	public List<SaleProduct> getSaleProducts() {
		return saleProducts;
	}
	
	public int getId() {
		return id;
	}
	
	public void setStatus(SaleStatus status) {
		this.status = status;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setComission(double comission) {
		this.comission = comission;
	}
	
	public double getComission() {
		return comission;
	}
}
