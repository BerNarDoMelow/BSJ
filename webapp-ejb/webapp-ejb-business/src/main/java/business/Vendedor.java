package business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Vendedor.FIND_BY_NUMBER, query="SELECT v FROM Vendedor v WHERE v.number = :" + Vendedor.NUMBER),
	@NamedQuery(name=Vendedor.GET_ALL_VENDEDORES, query="SELECT v FROM Vendedor v")
})

public class Vendedor {
	
	public static final String FIND_BY_NUMBER = "Vendedor.findByNumber";
	public static final String NUMBER = "number";
	public static final String GET_ALL_VENDEDORES = "Vendedor.getAllVendedores";
	@Id @GeneratedValue 
	private int id;
	
	@Column(nullable = false, unique = true) 
	private int number;
	
	@Column(nullable = false) 
	private String name;
	
	@Column(nullable = false, unique = true) 
	private int phoneNumb;
	
	@Column(nullable = false) 
	private double totalComission;

	public Vendedor() {
		
	}
	
	public Vendedor(int number,String name, int phoneNumber) {
		this.number = number;
		this.name = name;
		this.phoneNumb = phoneNumber;
		this.totalComission = 0.0;
	}
	
	public int getId() {
		return id;
	}


	public int getNumber() {
		return number;
	}


	public String getName() {
		return name;
	}


	public int getPhoneNumb() {
		return phoneNumb;
	}



	public double getTotalComission() {
		return totalComission;
	}
	
	public void setTotalComission(double totalComission) {
		this.totalComission = totalComission;
	}
}
