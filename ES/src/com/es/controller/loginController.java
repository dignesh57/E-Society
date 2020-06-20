package com.es.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.register_society;
import com.es.model.registration_page;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginController() {
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
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("login")) {
			System.out.println("In login controller..");

			registration_page lgn = new registration_page();
			
			register_society rs=new register_society();
			
			String role = request.getParameter(FormFieldUltilityconstant.login[0]);
			String email = request.getParameter(FormFieldUltilityconstant.login[1]);
			String password = request.getParameter(FormFieldUltilityconstant.login[2]);

			lgn.setRole_name(role);
			lgn.setEmail_id(email);
			lgn.setPassword(password);

			System.out.println(role + email + password);
			
			ArrayList<Object> al=new ArrayList<Object>();
			al.add(lgn);
			al.add(rs);
			
			DbTransction dbt = new DbTransactionImpl();
			registration_page rg = dbt.cklogin(lgn);
			//al=(ArrayList<Object>) dbt.cklogin(lgn);
			
			if (email.equalsIgnoreCase(" ") || password.equalsIgnoreCase(" ")) {
				request.setAttribute("emailmissing", "your email or password is missing");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else if (rg == null) {
				request.setAttribute("emailincorrect", "your email or password is incorrect");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				// out.print("your email or password is incorrect");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", rg);
				System.out.println(rg.getRole_name());
				String page = rg.getRole_name().equalsIgnoreCase("Admin") ? "index.jsp"
						: (rg.getRole_name().equalsIgnoreCase("Secretary")) ? "Secretary.jsp"
								: (rg.getRole_name().equalsIgnoreCase("Society Member")) ? "userPage.jsp"
										: (rg.getRole_name().equalsIgnoreCase("Security Guard")) ? "SecurityGuard.jsp"
												: (rg.getRole_name().equalsIgnoreCase("Worker")) ? "Worker.jsp"
														: "Page_not_found.jsp";

				System.out.println(page);
				request.getRequestDispatcher(page).forward(request, response);
			}
		}
	}
}
;