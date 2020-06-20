package com.es.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransction;
import com.es.model.registration_page;

/**
 * Servlet implementation class PaymentSuccessController
 */
@WebServlet("/PaymentSuccessController")
public class PaymentSuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Date date=(Date) session.getAttribute("Date");
		registration_page userData=null;
		String email="";
		if (session.getAttribute("user") != null) {
			userData = (registration_page) session.getAttribute("user");
			email=userData.getEmail_id();
			request.setAttribute("msg", "success");
		}
		
		DbTransction dbt = new DbTransactionImpl();
		int flag=dbt.updatePayment(date, email);
		String result = flag == 1 ? "Success" : "Failed";
		if (result.equalsIgnoreCase("Success")) {
			request.getRequestDispatcher("maintainancehistory.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
		}
	}

}
