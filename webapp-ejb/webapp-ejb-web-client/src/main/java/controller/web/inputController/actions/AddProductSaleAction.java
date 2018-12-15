package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.AddProductSaleModel;

@Stateless
public class AddProductSaleAction extends Action{

	@EJB 
	private ISaleServiceRemote SaleService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddProductSaleModel model = new AddProductSaleModel();
		model.setSaleService(SaleService);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/addProductSale/addProductSale.jsp").forward(request, response);
	}
}

