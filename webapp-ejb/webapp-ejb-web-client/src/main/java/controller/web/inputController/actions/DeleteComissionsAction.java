package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.DeleteComissionsModel;

@Stateless
public class DeleteComissionsAction extends Action{

	@EJB
	private IVendedorServiceRemote VendedorService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeleteComissionsModel model = createHelper(request);
		try {
			VendedorService.deleteComissions(model.getNumber());
			model.addMessage("OKKKKKK");
		}catch(ApplicationException e) {
			model.addMessage("nepspspspsppsppsps");
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/deleteComissions/deleteComissions.jsp").forward(request, response);
	}
	
	private DeleteComissionsModel createHelper(HttpServletRequest request) {
		DeleteComissionsModel model = new DeleteComissionsModel();
		model.setNumber(intValue(request.getParameter("number")));
		model.setVendedorService(VendedorService);
		return model;
	}
}
