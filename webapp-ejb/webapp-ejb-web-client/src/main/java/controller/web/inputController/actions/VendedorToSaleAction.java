package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.VendedorToSaleModel;


@Stateless
public class VendedorToSaleAction extends Action{

	@EJB
	private IVendedorServiceRemote VendedorService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VendedorToSaleModel model = createHelper(request);
		try {
			VendedorService.vendedorToSale(model.getSaleId(),model.getNumber());
			model.addMessage("Successfully added to sale: "+ model.getSaleId());
		}catch(ApplicationException e) {
			model.addMessage("Sale or customer dont exist or sale is closed");
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/vendedorToSale/vendedorToSale.jsp").forward(request, response);
	}
	
	private VendedorToSaleModel createHelper(HttpServletRequest request) {
		VendedorToSaleModel model = new VendedorToSaleModel();
		model.setVendedorService(VendedorService);
		model.setNumber(intValue(request.getParameter("number")));
		model.setSaleid(intValue(request.getParameter("saleid")));
		return model;
	}
}
