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
import com.es.model.mst_expense;
import com.es.model.mst_id_type;
import com.es.model.mst_mst_mst_area;
import com.es.model.registration_page;

/**
 * Servlet implementation class IDTypeController
 */
@WebServlet("/IDTypeController")
public class IDTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDTypeController() {
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
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		DbTransction dbt=new DbTransactionImpl();
		HttpSession session=request.getSession();
		registration_page rg=(registration_page)session.getAttribute("user");
		
		if(action.equalsIgnoreCase("Add")) {
			
		String id_type=request.getParameter(FormFieldUltilityconstant.mst_id_type[0]).toString().trim();
		
	    mst_id_type idtype=new mst_id_type();
	    //idtype.setSoc_id("");
		idtype.setId_type(id_type);
		idtype.setEntered_by(rg.getUsername());
		int flag=dbt.insertIDType(formname, idtype);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		
		if(result.equalsIgnoreCase("Success")) {
			request.getRequestDispatcher("mst_id_type.jsp").forward(request, response);
			}
		else {
			request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
		}
		}
		else if(action.equalsIgnoreCase("Update")) {
			String oldname=request.getParameter("idhdn");
			String name=request.getParameter(FormFieldUltilityconstant.mst_id_type[0]);
			
			mst_id_type id=new mst_id_type();
			id.setId_type(name);
			id.setId_id(oldname);
			id.setLastupdate_by(rg.getUsername());
			
			int flag=dbt.updateID(id);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_id_type.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		else if(action1!=null) {
			int flag=dbt.deleteidtype(formname, action1);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_id_type.jsp").forward(request, response);
			}
		}
	}
}
