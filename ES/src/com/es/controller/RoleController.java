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
import com.es.model.mst_mst_city;
import com.es.model.mst_mst_mst_area;
import com.es.model.mst_role;
import com.es.model.registration_page;

/**
 * Servlet implementation class RoleController
 */
@WebServlet("/RoleController")
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleController() {
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
		String action=request.getParameter("action")==null?"itsnull":request.getParameter("action");
		String action1=request.getParameter("action1");
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		HttpSession session=request.getSession();
		registration_page rg=(registration_page)session.getAttribute("user");
		
		DbTransction dbt = new DbTransactionImpl();
		if (action.equalsIgnoreCase("Add")) {

			String rolename = request.getParameter(FormFieldUltilityconstant.mst_role[0]);

			mst_role role = new mst_role();
			role.setRole_name(rolename);
			role.setEntered_by(rg.getUsername());
			int flag = dbt.insertRole(formname, role);
			System.out.println(flag);
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);

			if (result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_role.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("Update")) {
			String oldname=request.getParameter("rolehdn");
			String name=request.getParameter(FormFieldUltilityconstant.mst_role[0]);
			
			mst_role r=new mst_role();
			r.setRole_name(name);
			r.setRole_id(oldname);
			r.setLast_update_by(rg.getUsername());
			int flag=dbt.updateRole(r);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_role.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		else if(action1!=null) {
			int flag=dbt.deleterole(formname, action1);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_role.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
	}
}