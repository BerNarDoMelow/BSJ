package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import presentation.web.model.ComissionToSaleModel;

@Stateless
public class ComissionToSaleAction extends Action{

	@EJB
	private ISaleServiceRemote SaleService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComissionToSaleModel model = createHelper(request);
		try {
			SaleService.comissionToSale(model.getSaleId(),model.getComission());
			model.addMessage("comission was added to " + model.getSaleId());
		}catch(ApplicationException e){
			model.addMessage("Sale does not exists");
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/comissionToSale/comissionToSale.jsp").forward(request, response);
	}
	
	public ComissionToSaleModel createHelper(HttpServletRequest request) {
		ComissionToSaleModel model = new ComissionToSaleModel();
		model.setSaleService(SaleService);
		model.setComission(Double.parseDouble(request.getParameter("comission")));
		model.setSaleId(intValue(request.getParameter("saleid")));
		return model;
	}

}
