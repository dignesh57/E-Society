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
import com.es.model.mst_role;
import com.es.model.mst_service;
import com.es.model.mst_state;
import com.es.model.registration_page;

/**
 * Servlet implementation class ServiceContrroller
 */
@WebServlet("/ServiceContrroller")
public class ServiceContrroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceContrroller() {
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
		String action=request.getParameter("action")==null?"itsnull":request.getParameter("action");
		String action1=request.getParameter("action1");
		System.out.println(action1);
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		HttpSession session=request.getSession();
		registration_page rg=(registration_page)session.getAttribute("user");
		
		if(action.equalsIgnoreCase("Add")) {
			String service_type=request.getParameter(FormFieldUltilityconstant.mst_service[1]);
			
			mst_service service=new mst_service();
			service.setService_type(service_type);
			service.setEntered_by(rg.getUsername());
			
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.insertService(formname,service);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if (result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_service.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("Update")) {
			String oldname=request.getParameter("servicehdn");
			String name=request.getParameter(FormFieldUltilityconstant.mst_service[1]);
			
			mst_service s=new mst_service();
			s.setService_type(name);
			s.setService_id(oldname);
			s.setLastupdate_by(rg.getUsername());
			
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.updateService(s);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_service.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		else if(action1!=null) {
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.deleteservice(formname, action1);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_service.jsp").forward(request, response);
			}
		}
	}
}
