package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.UpdateTotalComissionsModel;

@Stateless
public class UpdateTotalComissionsFormAction extends Action{

	@EJB
	private IVendedorServiceRemote VendedorService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateTotalComissionsModel model = new UpdateTotalComissionsModel();
		model.setVendedorService(VendedorService);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/updateTotalComissions/updateTotalComissions.jsp").forward(request, response);
	}

}
