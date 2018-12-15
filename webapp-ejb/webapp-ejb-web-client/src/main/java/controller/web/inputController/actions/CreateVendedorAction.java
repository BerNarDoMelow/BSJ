package controller.web.inputController.actions;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facade.exceptions.ApplicationException;
import facade.handlers.IVendedorServiceRemote;
import presentation.web.model.NewVendedorModel;


@Stateless
public class CreateVendedorAction extends Action{

	@EJB
	private IVendedorServiceRemote VendedorService;
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		NewVendedorModel model = createHelper(request);
		try {
			VendedorService.createVendedor(model.getNumber(),model.getName(),model.getPhoneNumb());
			model.addMessage("Sucessfully added. Tk" + model.getName());
		}catch(ApplicationException e) {
			model.addMessage("Some error");
		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("/newVendedor/newVendedor.jsp").forward(request, response);
	}
	
	public NewVendedorModel createHelper(HttpServletRequest request) {
		NewVendedorModel model = new NewVendedorModel();
		model.setName(request.getParameter("name"));
		model.setNumber(intValue(request.getParameter("number")));
		model.setPhoneNumb(intValue(request.getParameter("phonenumber")));
		model.setVendedorService(VendedorService);
		return model;
	}
}
