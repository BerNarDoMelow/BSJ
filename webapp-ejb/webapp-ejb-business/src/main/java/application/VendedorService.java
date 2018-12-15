package application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import facade.dto.VendedorDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.IVendedorServiceRemote;
import handler.UpdateTotalComissionsHandler;
import handlers.CreateVendedorHandler;
import handlers.DeleteComissionsHandler;
import handlers.ListVendedoresHandler;
import handlers.VendedorToSaleHandler;


@Stateless
public class VendedorService implements IVendedorServiceRemote{

	@EJB
	private CreateVendedorHandler createVendedorHandler;
	
	@EJB
	private VendedorToSaleHandler vendedorToSaleHandler;
	
	@EJB
	private ListVendedoresHandler listVendedoresHandler;
	
	@EJB
	private UpdateTotalComissionsHandler updateTotalComissionsHandler;
	
	@EJB
	private DeleteComissionsHandler deleteComissionsHandler;
	
	@Override
	public void vendedorToSale(int saleId, int number) throws ApplicationException {
		vendedorToSaleHandler.vendedorToSale(saleId, number);
	}
	
	@Override
	public void createVendedor(int number, String name, int phonenumber) throws ApplicationException {
		createVendedorHandler.createVendedor(number,name,phonenumber);
	}

	@Override
	public List<VendedorDTO> getVendedores() throws ApplicationException {
		return listVendedoresHandler.getVendedores();
	}

	@Override
	public void updateTotalComission(int number) throws ApplicationException {
		updateTotalComissionsHandler.updateTotalComissions(number);
	}

	@Override
	public void deleteComissions(int number) throws ApplicationException {
		deleteComissionsHandler.deleteComissions(number);
	}
	

}
