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
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.mst_visitor_name;
import com.es.model.registration_page;
import com.es.model.visitor_details;

/**
 * Servlet implementation class VisitorController
 */
@WebServlet("/VisitorController")
public class VisitorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VisitorController() {
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
		String formname = request.getParameter("formname") == null ? "formname" : request.getParameter("formname");
		
		registration_page userData=null;
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!=null) {
			userData=(registration_page)session.getAttribute("user");
		}
		
		DbTransction dbt = new DbTransactionImpl();
		
		if (action.equalsIgnoreCase("add")) {
			
			mst_visitor_name visitor = new mst_visitor_name();
			
			visitor.setVisitor_name(request.getParameter(FormFieldUltilityconstant.mst_visitor[0]));
			
			int flag = dbt.insertvisitor(formname, visitor);
			String result = flag == 1 ? "Success.." : "Failed..";
			
			System.out.println(result);
		} else if (action.equalsIgnoreCase("IN")) {

			String option = request.getParameter(FormFieldUltilityconstant.security_guard_table[0]);
			String name = request.getParameter(FormFieldUltilityconstant.security_guard_table[1]);
			String phone_number = request.getParameter(FormFieldUltilityconstant.security_guard_table[2]);
			String vehical_number = request.getParameter(FormFieldUltilityconstant.security_guard_table[3]);
			String house_number = request.getParameter(FormFieldUltilityconstant.security_guard_table[4]);
			String member_name = DbTransactionServicesImpl.getMemberName(house_number);
			String in_time_with_date = request.getParameter(FormFieldUltilityconstant.security_guard_table[5]);
			String purpose = request.getParameter(FormFieldUltilityconstant.security_guard_table[6]);

			visitor_details visite = new visitor_details();
			
			visite.setOptions(option);
			visite.setName(name);
			visite.setPhone_number(phone_number);
			visite.setVehical_number(vehical_number);
			visite.setHouse_number(house_number);
			visite.setMember_name(member_name);
			visite.setIn_time_with_date(in_time_with_date);
			visite.setPurpose(purpose);
			visite.setSoc_id(DbTransactionServicesImpl.getSocIdForVisitEntry(userData.getEmail_id()));
			String GuardName=userData.getUsername();

			int flag = dbt.insertvisitordetails(formname, visite,GuardName);
			String result = flag == 1 ? "Success.." : "Failed...";
			System.out.println(result);
			if (result.equalsIgnoreCase("Success..")) {
				request.getRequestDispatcher("SecurityGuard.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("OUT")) {
			
			visitor_details visite = new visitor_details();
			
			visite.setName(request.getParameter(FormFieldUltilityconstant.security_guard_table[1]));
			visite.setVehical_number(request.getParameter(FormFieldUltilityconstant.security_guard_table[3]));
			visite.setIn_time_with_date(request.getParameter(FormFieldUltilityconstant.security_guard_table[5]));
			visite.setSoc_id(DbTransactionServicesImpl.getSocIdForVisitEntry(userData.getEmail_id()));
			
			int flag=dbt.updateouttime(formname, visite);
			String result=flag==1?"SuccessOUT":"FiledOUT";
			System.out.println(result);
			if(result.equalsIgnoreCase("SuccessOUT")) {
				request.getRequestDispatcher("SecurityGuard.jsp").forward(request, response);
			}
		}

	}
}
