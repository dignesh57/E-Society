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
//import com.es.model.mst_mst_city;
import com.es.model.mst_mst_mst_area;
import com.es.model.registration_page;

/**
 * Servlet implementation class AreaController
 */
@WebServlet("/AreaController")
public class AreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AreaController() {
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
		String action = request.getParameter("action") == null ? "itsnull" : request.getParameter("action");
		String action1 = request.getParameter("action1");
		System.out.println("In Action " + action);
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		
		HttpSession session=request.getSession();
		registration_page rg=(registration_page)session.getAttribute("user");
		
		DbTransction dbt = new DbTransactionImpl();
		if (action.equalsIgnoreCase("Add")) {

			String statename = request.getParameter(FormFieldUltilityconstant.mst_mst_mst_area[0]);
			String cityname = request.getParameter(FormFieldUltilityconstant.mst_mst_mst_area[1]);
			String areaname = request.getParameter(FormFieldUltilityconstant.mst_mst_mst_area[2]);
			String pincode = request.getParameter(FormFieldUltilityconstant.mst_mst_mst_area[3]);

			mst_mst_mst_area area = new mst_mst_mst_area();
			area.setState_name(statename);
			area.setCity_name(cityname);
			area.setArea_name(areaname);
			area.setPincode(pincode);
			area.setEntered_by(rg.getUsername());
			System.out.println(statename + cityname);

			int flag = dbt.insertArea(formname, area);
			System.out.println(flag);
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);

			if (result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_mst_mst_area.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("Update")) {
			String oldname=request.getParameter("areahdn");
			String name=request.getParameter(FormFieldUltilityconstant.mst_mst_mst_area[2]);
			String pincode=request.getParameter(FormFieldUltilityconstant.mst_mst_mst_area[3]);
			
			mst_mst_mst_area area=new mst_mst_mst_area();
			area.setCity_name(oldname);
			area.setArea_name(name);
			area.setPincode(pincode);
			area.setLastupdate_by(rg.getUsername());
			
			int flag=dbt.updateArea(area);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_mst_mst_area.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		else if(action1!=null) {
			int flag=dbt.deletearea(formname, action1);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_mst_mst_area.jsp").forward(request, response);
			}
		}
	}

}
