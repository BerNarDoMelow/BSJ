package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.ListVendedoresModel;

@Stateless
public class ListVendedoresAction extends Action{

	@EJB
	private IVendedorServiceRemote VendedorService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListVendedoresModel model = createHelper(request);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/listVendedores/listVendedores.jsp").forward(request, response);
	}
	
	public ListVendedoresModel createHelper(HttpServletRequest request) {
		ListVendedoresModel model = new ListVendedoresModel();
		model.setVendedorService(VendedorService);
		return model;
	}

}
