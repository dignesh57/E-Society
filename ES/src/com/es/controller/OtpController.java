package com.es.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.forgot_password;

/**
 * Servlet implementation class OtpController
 */
@WebServlet("/OtpController")
public class OtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String action=request.getParameter("action");
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		if(action.equalsIgnoreCase("submit")) {
			
		String uotp=request.getParameter(FormFieldUltilityconstant.otp[0]);
		int userotp=Integer.parseInt(uotp);
		int otp=0;
		
		HttpSession otpsession = request.getSession();
		if(otpsession.getAttribute("otp")!=null){
			otp=(int)otpsession.getAttribute("otp");
		}
		if(userotp==otp) {
		request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
		}
		else {
		request.getRequestDispatcher("otp.jsp").forward(request, response);
		}
		}
	}
}
