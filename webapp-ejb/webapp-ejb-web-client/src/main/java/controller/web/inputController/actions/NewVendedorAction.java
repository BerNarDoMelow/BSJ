package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.NewSaleModel;
import presentation.web.model.NewVendedorModel;


@Stateless
public class NewVendedorAction extends Action{

	private IVendedorServiceRemote VendedorService;

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewVendedorModel model = new NewVendedorModel();
		model.setVendedorService(VendedorService);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/newVendedor/newVendedor.jsp").forward(request, response);
	}
}
