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
import com.es.model.mst_state;
import com.es.model.registration_page;

/**
 * Servlet implementation class StateController
 */
@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
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
		mst_state state=new mst_state();
		DbTransction dbt=new DbTransactionImpl();
		
		HttpSession session=request.getSession();
		registration_page rg=(registration_page)session.getAttribute("user");
		
		if(action.equalsIgnoreCase("Add")) {
			String id=request.getParameter(FormFieldUltilityconstant.mst_state[0]);
			String name=request.getParameter(FormFieldUltilityconstant.mst_state[1]);
			
			//EsUtiModelGetter state=new EsUtiModelGetter();
			
			/*
			 * state.setCount1(id); state.setCount2(name);
			 */
			state.setState_id(id);
			state.setState_name(name);
			state.setEntered_by(rg.getUsername());
			System.out.println(id);
			System.out.println(name);
			int flag=dbt.insertState(formname,state);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			/*
			 * if(flag==1) { System.out.println("Success"); }else {
			 * System.out.println("Failed"); }
			 */
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_state.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("Update")) {
			String id=request.getParameter(FormFieldUltilityconstant.mst_state[0]);
			String name=request.getParameter(FormFieldUltilityconstant.mst_state[1]);
			
			//EsUtiModelGetter state=new EsUtiModelGetter();
			
			/*
			 * state.setCount1(id); state.setCount2(name);
			 */
			state.setState_id(id);
			state.setState_name(name);
			state.setLast_updated_by(rg.getUsername());
			System.out.println(id);
			System.out.println(name);
			int flag=dbt.updateState(state);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			/*
			 * if(flag==1) { System.out.println("Success"); }else {
			 * System.out.println("Failed"); }
			 */
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_state.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		else if(action1!=null) {
			int flag=dbt.deleteState(formname, action1);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_state.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
	}
}
