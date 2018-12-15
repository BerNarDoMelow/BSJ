package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.VendedorToSaleModel;


@Stateless
public class VendedorToSaleFormAction extends Action{

	@EJB
	private IVendedorServiceRemote VendedorService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VendedorToSaleModel model = new VendedorToSaleModel();
		model.setVendedorService(VendedorService);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/vendedorToSale/vendedorToSale.jsp").forward(request, response);
	}
}
