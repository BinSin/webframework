package kr.ac.hansung.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.hansung.model.Customer;
import kr.ac.hansung.service.CustomerService;

@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DoLogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("id");
		String Pwd = request.getParameter("pwd");
		
		CustomerService service = new CustomerService();
		Customer customerId = service.findCustomerId(Id);
		Customer customerPwd = service.findCustomerPwd(Pwd);
		
		request.setAttribute("customerId", customerId);
		request.setAttribute("customerPwd", customerPwd);
			
		String page;
		if(customerId != null && customerPwd != null) {
			// id와 pwd가 같으면 form.jsp로 이동
			if(customerId.getPwd() == customerPwd.getPwd())
				page = "/view/form.jsp";
			else
				page = "/view/error.jsp";
		}
		else {
			page = "/view/error.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request,  response);
	}

}
