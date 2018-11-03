package dataaccess;

import java.util.Set;

/**
 * An in-memory representation of a row gateway for the products composing a sale.	
 * 
 * @author 
 * @version 
 *
 */
public class SaleProductRowDataGateway {
	
	// 1. Sale product attributes 
	private static int id;
	private static double qty;
	private static int productId;
	private static int saleId;


	/**
	 * The insert product in a sale SQL statement
	 */
	private static final String INSERT_PRODUCT_SALE_SQL = 
			"insert into saleproduct (qty,product_id,sale_id) values (?,?,?)"; // TODO: program me!

	
	/**
	 * The select the products of a sale by sale Id SQL statement
	 */
	private static final String GET_SALE_PRODUCTS_SQL = 
			"select * from saleproduct sp where sp.id = ?"; // TODO: program me!

	// 2. constructor
	public SaleProductRowDataGateway(double qty,int product_id,int sale_id){
		this.qty = qty;
		this.productId = product_id;
		this.saleId = sale_id;
	}

	// 3. getters and setters
	public int getProductId() {
		return productId;
	}

	public double getQty() {
		return qty;
	}

	// 4. interaction with the repository (a relational database in this simple example)

	public SaleProductRowDataGateway(int id, int productId, double qty) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Inserts the record in the products sale 
	 */
	public void insert () throws PersistenceException {
		// TODO: program me!
	}
	
	
	/**
	 * Gets the products of a sale by its sale id 
	 * 
	 * @param saleId The sale id to get the products of
	 * @return The set of products that compose the sale
	 * @throws PersistenceException When there is an error obtaining the
	 *         information from the database.
	 */
	public static Set<SaleProductRowDataGateway> findSaleProducts (int saleId) throws PersistenceException {
		return null;
		// TODO: program me!
	}	
}
