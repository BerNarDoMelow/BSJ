package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.ComissionToSaleModel;

@Stateless
public class ComissionToSaleFormAction extends Action{

	@EJB
	private ISaleServiceRemote SaleService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComissionToSaleModel model = new ComissionToSaleModel();
		model.setSaleService(SaleService);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/comissionToSale/comissionToSale.jsp").forward(request, response);
	}

}
