package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.DeleteComissionsModel;

@Stateless
public class DeleteComissionsFormAction extends Action{

	@EJB
	private IVendedorServiceRemote VendedorService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeleteComissionsModel model = new DeleteComissionsModel();
		model.setVendedorService(VendedorService);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/deleteComissions/deleteComissions.jsp").forward(request, response);
	}

}
