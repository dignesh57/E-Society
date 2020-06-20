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
import com.es.model.mst_bill;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
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
			
			String p1=request.getParameter(FormFieldUltilityconstant.updatepassword[0]);
			String p2=request.getParameter(FormFieldUltilityconstant.updatepassword[1]);
			System.out.println(p1+"*****P2 "+p2);
			String updatepass;
			System.out.println(p1.equals(p2));
			if(p1.equals(p2)) {
				updatepass=p1;
				
				HttpSession otpsession = request.getSession();
				forgot_password f=null;
				if(otpsession.getAttribute("UserData")!=null){
					f=(forgot_password) otpsession.getAttribute("UserData");
					f.setPassword(updatepass);
					System.out.println(f.getPassword());
				}
				
				
				DbTransction dbt=new DbTransactionImpl();
				int flag=dbt.updatePassword(formname, f);
				System.out.println(flag);
				String result = flag==1?"Success":"Failed";
				System.out.println(result);
				
				request.getRequestDispatcher("login_page.jsp").forward(request, response);
				
			}
			else {
				request.getRequestDispatcher("updatepassword.jsp").forward(request, response);
			}
		}
	}
}
