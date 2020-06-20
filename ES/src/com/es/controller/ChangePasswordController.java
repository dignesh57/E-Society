package com.es.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.registration_page;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordController() {
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
		String formname = request.getParameter("formname");
		registration_page user = new registration_page();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			user = (registration_page) session.getAttribute("user");
		}
		if (action.equalsIgnoreCase("Submit")) {
			String password = request.getParameter(FormFieldUltilityconstant.changePassword[0]);
			String pass = null;
			try {
				System.out.println("IN try block");
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.toString().trim().getBytes());

				byte byteData[] = md.digest();

				StringBuffer hexString = new StringBuffer();

				for (int k = 0; k < byteData.length; k++) {
					String hex = Integer.toHexString(0xff & byteData[k]);
					if (hex.length() == 1)
						hexString.append('0');
					hexString.append(hex);
				}
				pass = hexString.toString().trim();
				System.out.println(pass);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			if (password == null) {
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			} else if (user.getPassword().equals(pass)) {
				request.getRequestDispatcher("ChangePassword1.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("Change")) {
			String pass1 = request.getParameter(FormFieldUltilityconstant.changePassword1[0]);
			String pass2 = request.getParameter(FormFieldUltilityconstant.changePassword1[1]);
			if (pass1.equals(pass2)) {
				String pass = null;
				try {
					System.out.println("IN try block");
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(pass1.toString().trim().getBytes());

					byte byteData[] = md.digest();

					StringBuffer hexString = new StringBuffer();

					for (int k = 0; k < byteData.length; k++) {
						String hex = Integer.toHexString(0xff & byteData[k]);
						if (hex.length() == 1)
							hexString.append('0');
						hexString.append(hex);
					}
					pass = hexString.toString().trim();
					System.out.println(pass);
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
				user.setPassword(pass);
				DbTransction dbt = new DbTransactionImpl();
				int flag = dbt.ChangePassword(user.getEmail_id(), user);
				String result = flag == 1 ? "Success.." : "Failed..";
				System.out.println(result);
				if (result.equalsIgnoreCase("Success..")) {
					if(session.getAttribute("user")!=null){
						registration_page userdata=(registration_page)session.getAttribute("user");
						if(userdata.getRole_name().equalsIgnoreCase("Admin")){
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}
						else if(userdata.getRole_name().equalsIgnoreCase("Society Member")) {
							request.getRequestDispatcher("WorUserProfile.jsp").forward(request, response);
						}else {
							request.getRequestDispatcher("Secretary.jsp").forward(request, response);
						}
					}
					
				}
			}
		}
	}
}
