package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.UpdateTotalComissionsModel;

@Stateless
public class UpdateTotalComissionsAction extends Action{

	@EJB
	private IVendedorServiceRemote VendedorService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateTotalComissionsModel model = createHelper(request);
		try {
			VendedorService.updateTotalComission(model.getNumber());
			model.addMessage("great!! Tk");
		}catch(ApplicationException e) {
			model.addMessage("Nope da meu amigo");
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/updateTotalComissions/updateTotalComissions.jsp").forward(request, response);
	}
	
	public UpdateTotalComissionsModel createHelper(HttpServletRequest request) {
		UpdateTotalComissionsModel model = new UpdateTotalComissionsModel();
		model.setVendedorService(VendedorService);
		model.setNumber(intValue(request.getParameter("number")));
		return model;
	}

}
