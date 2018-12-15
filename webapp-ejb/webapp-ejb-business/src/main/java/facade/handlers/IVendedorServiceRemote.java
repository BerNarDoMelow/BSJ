package facade.handlers;

import java.util.List;

import javax.ejb.Remote;

import facade.dto.VendedorDTO;
import facade.exceptions.ApplicationException;

@Remote
public interface IVendedorServiceRemote {

		public void vendedorToSale(int saleId, int number) throws ApplicationException;

		void createVendedor(int number, String name, int phonenumber) throws ApplicationException;

		public List<VendedorDTO> getVendedores() throws ApplicationException;

		public void updateTotalComission(int number) throws ApplicationException;

		public void deleteComissions(int number) throws ApplicationException;		
}
