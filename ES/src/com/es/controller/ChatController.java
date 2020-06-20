package com.es.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServices;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.model.chatApplication;
import com.es.model.registration_page;

/**
 * Servlet implementation class ChatController
 */
@WebServlet("/ChatController")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChatController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		HttpSession session = request.getSession();
		registration_page userData = null;
		if (session.getAttribute("user") != null) {
			userData = (registration_page) session.getAttribute("user");
		}
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		DbTransction dbt = new DbTransactionImpl();
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("Send")) {
			chatApplication chat = new chatApplication();
			String socID = dbts.getMemberSocID(userData.getEmail_id());
			
			
			System.out.println("SOCID"+socID);

			chat.setName(userData.getUsername());
			chat.setSoc_id(socID);
			chat.setMsg(request.getParameter("message"));
			chat.setEmail(userData.getEmail_id());
			System.out.println("Recive msg="+chat.getMsg());
			int flag = dbt.insertChat(chat);
			String result = flag == 1 ? "SuccessInsert" : "FailedInsert..";
			System.out.println(result);

			if (result.equalsIgnoreCase("SuccessInsert")) {
				//request.getRequestDispatcher("userPage.jsp#communication").forward(request, response);
				response.sendRedirect("userPage.jsp#communication");
			}else {
				response.sendRedirect("userPage.jsp#communication");
			}
		}
	}
}
