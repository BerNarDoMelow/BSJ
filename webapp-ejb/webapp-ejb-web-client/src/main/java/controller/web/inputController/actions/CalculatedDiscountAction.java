package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.ISaleServiceRemote;
import presentation.web.model.CalculateDiscountModel;

@Stateless
public class CalculatedDiscountAction extends Action{

	@EJB
	private ISaleServiceRemote SaleService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CalculateDiscountModel model = createHelper(request);
		model.addMessage("ok");
		request.setAttribute("model", model);
		request.getRequestDispatcher("/calculateDiscount/calculateDiscount.jsp").forward(request, response);	
	}
	
	public CalculateDiscountModel createHelper(HttpServletRequest request) {
		CalculateDiscountModel model = new CalculateDiscountModel();
		model.setSaleService(SaleService);
		model.setSaleId(intValue(request.getParameter("saleid")));
		return model;
	}

}
