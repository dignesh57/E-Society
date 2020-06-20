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
import com.es.model.mst_bill;
import com.es.model.mst_complain;
import com.es.model.registration_page;

/**
 * Servlet implementation class ComplainController
 */
@WebServlet("/ComplainController")
public class ComplainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainController() {
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
		registration_page userdata = null;
		HttpSession session =request.getSession();
		if (session.getAttribute("user") != null) {

			userdata = (registration_page) session.getAttribute("user");
		}
		String action=request.getParameter("action")==null?"":request.getParameter("action");
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		if(action.equalsIgnoreCase("Add")) {
			System.out.println("In controller..");

		String enterBy=userdata.getUsername();	
		String complaintype=request.getParameter(FormFieldUltilityconstant.mst_complain[1]);
		
		mst_complain complain=new mst_complain();
		complain.setComp_type(complaintype);
		complain.setEntered_by(enterBy);
		System.out.println(complaintype);
		System.out.println(enterBy);
		
		DbTransction dbt=new DbTransactionImpl();
		int flag=dbt.insertComplain(formname, complain);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		}
	}
}
