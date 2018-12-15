package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.dto.SaleDTO;
import facade.exceptions.ApplicationException;
import facade.handlers.ISaleServiceRemote;
import presentation.web.model.AddProductSaleModel;
import presentation.web.model.Model;
import presentation.web.model.NewSaleModel;


@Stateless
public class AddedProductSaleAction extends Action{
	@EJB 
	private ISaleServiceRemote SaleService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		// the other data, date and status will be created by the handler
		AddProductSaleModel model = createHelper(request);
		
		try {
			//Sera qe tem de ser dentro do bean(model)?
			SaleService.addProductSale(model.getSaleId(),model.getProductId(),model.getQty());
			model.addMessage("Add complete. Tk");
		} catch (ApplicationException e) {
			model.addMessage("sale does not exist: " + model.getSaleId());
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/addProductSale/addProductSale.jsp").forward(request, response);
	}
	
	
	public AddProductSaleModel createHelper(HttpServletRequest request){
		AddProductSaleModel model = new AddProductSaleModel();
		
		model.setQty(Double.parseDouble(request.getParameter("qty")));
		model.setProductId(intValue(request.getParameter("productid")));
		model.setSaleId(intValue(request.getParameter("saleid")));
		
		return model;
	}
}
