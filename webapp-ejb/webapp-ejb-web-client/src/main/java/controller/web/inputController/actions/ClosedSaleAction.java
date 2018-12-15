package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.CloseSaleModel;

@Stateless
public class ClosedSaleAction extends Action{

	@EJB
	private ISaleServiceRemote SaleService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CloseSaleModel model = createHelper(request);
		try {
			SaleService.closeSale(model.getSaleId());
			model.addMessage("Close sale sucess. Tk");
		}catch(Exception e) {
			model.addMessage("sale does not exist: " + model.getSaleId());
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/closeSale/closeSale.jsp").forward(request, response);
	}
	
	public CloseSaleModel createHelper(HttpServletRequest request) {
		CloseSaleModel model = new CloseSaleModel();
		model.setSaleId(intValue(request.getParameter("saleid")));
		return model;
	}
}
