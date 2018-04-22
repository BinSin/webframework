package kr.ac.hansung.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.hansung.service.OrderService;

@WebServlet("/doPurchase")
public class DoPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoPurchase() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cardNumber = request.getParameter("cardNumber");
		String repeat = request.getParameter("repeat");
		
		OrderService service = new OrderService();

		String page;
		// 입력한 card number가 같으면 order.jsp로 이동
		if (service.checkCardNumber(cardNumber, repeat)) {
			page = "/view/order.jsp";
		} else {
			page = "/view/errorNumber.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

}
