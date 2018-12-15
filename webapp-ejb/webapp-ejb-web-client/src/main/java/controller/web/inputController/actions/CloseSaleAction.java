package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentation.web.model.CloseSaleModel;

@Stateless
public class CloseSaleAction extends Action{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CloseSaleModel model = new CloseSaleModel();
		request.setAttribute("model", model);
		request.getRequestDispatcher("/closeSale/closeSale.jsp").forward(request, response);
	}
}
