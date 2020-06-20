package com.es.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.mst_event;

/**
 * Servlet implementation class EventController
 */
@WebServlet("/EventController")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
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
		String action=request.getParameter("action")==null?"":request.getParameter("action");
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		if(action.equalsIgnoreCase("Add")) {
			
		String eventname=request.getParameter(FormFieldUltilityconstant.mst_event[0]).toString().trim();
		
	    mst_event event=new mst_event();
		event.setEvent_name(eventname);
		
		DbTransction dbt=new DbTransactionImpl();
		int flag=dbt.insertEvent(formname, event);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		}
	}

}
