package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.ListSalesModel;


@Stateless
public class ListSalesAction extends Action{

	@EJB
	private ISaleServiceRemote SaleService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListSalesModel model = createHelper(request);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/listSales/listSales.jsp").forward(request, response);
	}
	
	private ListSalesModel createHelper(HttpServletRequest request) {
		ListSalesModel model = new ListSalesModel();
		model.setSaleService(SaleService);
		return model;
	}
	
}
