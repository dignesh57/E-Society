package com.es.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServices;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.mst_society;
import com.es.model.registration_page;

/**
 * Servlet implementation class RegistrationPageController
 */
@WebServlet("/RegistrationPageController")
public class RegistrationPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationPageController() {
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
		String action = request.getParameter("action") == null ? "" : request.getParameter("action");
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		registration_page userData = null;
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null) {
			userData =(registration_page) session.getAttribute("user");
		}
		
		if (action.equalsIgnoreCase("Update")) {

			String uname = request.getParameter(FormFieldUltilityconstant.adminProfile[0]).toString().trim();
			String email = request.getParameter(FormFieldUltilityconstant.adminProfile[1]).toString().trim();
			String contactno = request.getParameter(FormFieldUltilityconstant.adminProfile[2]).toString().trim();
			String gender = request.getParameter(FormFieldUltilityconstant.adminProfile[3]).toString().trim();

			registration_page registration = new registration_page();

			registration.setUsername(uname);
			registration.setContact_no(contactno);
			registration.setGender(gender);
			registration.setEmail_id(email);

			DbTransactionServices dbts = new DbTransactionServicesImpl();
			int flag = dbts.updateRegistrationData(formname, registration);
			System.out.println(flag);
			String result = flag == 1 ? "SuccessRegistration" : "FailedRegistration";
			System.out.println(result);
			
			request.getRequestDispatcher("adminProfile.jsp").forward(request, response);

			if(userData.getRole_name().equalsIgnoreCase("Secretary")) {
				mst_society soc=new mst_society();
				
				soc.setName(uname);
				soc.setPhone_no(contactno);
				soc.setGender(gender);
				soc.setEmail(email);
				
				int flag1 = dbts.updateMst_SocietyData(formname, soc);
				System.out.println(flag1);
				String result1 = flag == 1 ? "Successmst_society" : "FailedMst_Society";
				System.out.println(result1);
				
				request.getRequestDispatcher("adminProfile.jsp").forward(request, response);
			}else if(userData.getRole_name().equalsIgnoreCase("")) {
				
			}
		}
	}
}
