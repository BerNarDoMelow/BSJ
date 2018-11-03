package dataaccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import business.SaleStatus;
import java.sql.SQLException;
/**
 * An in-memory representation of a customer table record. 
 *	
 * Notes:
 * 1. See the notes for the CustomerRowGateway class
 * 
 * 2. Java makes available two Date classes (in fact, more in Java 8, 
 * but we will address it later (with JPA)): one in the package 
 * java.util, which is the one we normally use, and another in
 * java.sql, which is a subclass of java.util.date and that 
 * transforms the milliseconds representation according to the
 * "Date type of databases". For more information refer to 
 * http://download.oracle.com/javase/6/docs/api/java/sql/Date.html.
 * 
 * 3. When creating a new sale, we only pass the date and customer id 
 * parameters to the constructor. Moreover, attribute open is always 
 * set to 'O'. The remaining attributes are either set automatically (id) 
 * or when closing the sale (totalSale and totalDiscount). Also, the open 
 * attribute is set to 'C' upon payment. 
 * 
 * @author fmartins
 * @Version 1.2 (13/02/2015)
 *
 */
public class SaleRowDataGateway {

	private static int id;
	private static java.sql.Date date;
	private static String status;
	private static double total;
	private static double discount;
	private static int customerId;
	private static int vendedorId;
	private static double comissao;


	private static final String OPEN = "O";
	private static final String CLOSED = "C";
	/**
	 * The select a sale by Id SQL statement
	 */
	private static final String GET_SALE_SQL = 
			"select * from sale s where s.id = ?"; // TODO: program me!

	/**
	 * The insert sale SQL statement
	 */
	private static final String INSERT_SALE_SQL = 
			"insert into sale(date,status,total,discount_total,customer_id,vendedor_id,comissao) values (?,?,?,?,?,?,?)"; // TODO: program me!

	// Constants for conversion of status

	// 1. constructor 

	/**
	 * Creates a new sale given the customer Id and the date it occurs.
	 * 
	 * @param customerId The customer Id the sale belongs to
	 * @param date The date the sale took place
	 */
	public SaleRowDataGateway(int customerId, Date date, double comissao) {
		this.customerId = customerId;
		this.date = new java.sql.Date(date.getTime());
		status = OPEN;
		total = 0.0;
		discount = 0.0;
		vendedorId = 0;
		this.comissao = comissao;
	}

	// 2. getters and setters

	public int getId() {
		return id;
	}

	public SaleStatus getStatus() {
		return  (status == "O")?SaleStatus.OPEN:SaleStatus.CLOSED;
	}

	public int getCustomerId() {
		return customerId;
	}

	public double getDiscount() {
		return discount;
	}

	public double getComissao(){ return comissao; }

	public int getVendedorId(){ return vendedorId; }

	// 3. interaction with the repository (a memory map in this simple example)

	/**
	 * Stores the information in the repository
	 */
	public void insert () throws PersistenceException{
		try(PreparedStatement statement = DataSource.INSTANCE.prepareGetGenKey(INSERT_SALE_SQL)){
			statement.setDate(1,date);
			statement.setString(2,status);
			statement.setDouble(3,total);
			statement.setDouble(4,discount);
			statement.setInt(5,customerId);
			statement.setInt(6,vendedorId);
			statement.setDouble(7,comissao);
			statement.executeUpdate();
			try(ResultSet resultSet = statement.getGeneratedKeys()){
				resultSet.next();
				id = resultSet.getInt(1);
			}
		}catch (SQLException e) {
			throw new PersistenceException ("Internal error!", e);
		}
	}

	/**
	 * Gets a sale by its id 
	 * 
	 * @param id The sale id to search for
	 * @return The new object that represents an in-memory sale
	 * @throws PersistenceException In case there is an error accessing the database.
	 */
	public static SaleRowDataGateway find (int id) throws PersistenceException {
		try(PreparedStatement statement = DataSource.INSTANCE.prepare(INSERT_SALE_SQL)){
			statement.setInt(1,id);
			try(ResultSet resultSet = statement.executeQuery()){
				SaleRowDataGateway saleRDG = load(resultSet);
				return saleRDG;
			}
		}catch (SQLException e){
			throw new PersistenceException("errro: "+ e.getErrorCode());
		}
	}


	public static SaleRowDataGateway load(ResultSet rs) throws RecordNotFoundException{
		try {
			rs.next();
			SaleRowDataGateway saleRDG = new SaleRowDataGateway(rs.getInt("custumer_id"),rs.getDate("date"),rs.getDouble("comissao"));
			saleRDG.total = rs.getDouble("total");
			saleRDG.discount = rs.getDouble("discount_total");
			return saleRDG;
		} catch (SQLException e) {
			throw new RecordNotFoundException ("Customer does not exist", e);
		}
	}

	private static final String SQLCommandUpdateVendedor = "update sale s set s.vendedor_id = ? where s.id = ?";

	public static void updateVendedor(int saleId,int vendedorId) throws PersistenceException{
		try(PreparedStatement statement = DataSource.INSTANCE.prepareGetGenKey(SQLCommandUpdateVendedor)){
			statement.setInt(1,vendedorId);
			statement.setInt(2,saleId);
			statement.executeUpdate();
		}catch (SQLException e) {
			throw new PersistenceException("Internal error!", e);
		}
	}

	private static final String SQLCommandUpdateComissao = "update sale s set s.comissao = ? where s.id = ?";

	public static void updateComissao(int saleId,double comissao) throws PersistenceException{
		try(PreparedStatement statement = DataSource.INSTANCE.prepareGetGenKey(SQLCommandUpdateComissao)){
			statement.setDouble(1,comissao);
			statement.setInt(2,saleId);
			statement.executeUpdate();
		}catch (SQLException e) {
			throw new PersistenceException("Internal error!", e);
		}
	}
}
