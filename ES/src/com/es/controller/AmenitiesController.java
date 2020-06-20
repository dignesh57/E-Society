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
//import com.es.model.mst_mst_city;
import com.es.model.mst_amenities;
import com.es.model.registration_page;

/**
 * Servlet implementation class AmenitiesController
 */
@WebServlet("/AmenitiesController")
public class AmenitiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmenitiesController() {
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
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		String action1=request.getParameter("action1");
		
		DbTransction dbt = new DbTransactionImpl();
		
		HttpSession session = request.getSession();
		registration_page secretary=(registration_page) session.getAttribute("user");
		String secretaryid=secretary.getEmail_id();
		if(action.equalsIgnoreCase("Add")) {
			
		String amentiesname=request.getParameter(FormFieldUltilityconstant.mst_amenities[1]);
		String rent=request.getParameter(FormFieldUltilityconstant.mst_amenities[2]);
		
		 
			/* String secretaryid="karanmmodi1998@gmail.com"; */
		String socid = dbt.getSocietyID(secretaryid);
		System.out.println(socid);
		
		mst_amenities amenities=new mst_amenities();
		amenities.setAmenities_name(amentiesname);
		amenities.setRent(rent);
		amenities.setSoc_id(socid);
		amenities.setEntered_by(secretaryid);
		amenities.setLast_update_by(secretaryid);
		
		int flag=dbt.insertAmenities(formname,amenities);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		
		if(result.equalsIgnoreCase("Success")) {
			request.getRequestDispatcher("mst_amenities.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
		}
		
	}
	else if(action.equalsIgnoreCase("Update")) {
		
		mst_amenities amenities=new mst_amenities();
		amenities.setAmenities_id(request.getParameter("id"));
		amenities.setAmenities_name(request.getParameter(FormFieldUltilityconstant.mst_amenities[1]));
		amenities.setRent(request.getParameter(FormFieldUltilityconstant.mst_amenities[2]));
		amenities.setLast_update_by(secretaryid);
		
		int flag=dbt.updateAmenities(amenities);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		/*
		 * if(flag==1) { System.out.println("Success"); }else {
		 * System.out.println("Failed"); }
		 */
		if(result.equalsIgnoreCase("Success")) {
			request.getRequestDispatcher("mst_amenities.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
		}
	}
	else if(action1!=null) {
		int flag=dbt.deleteAmenities(action1);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		
		if(result.equalsIgnoreCase("Success")) {
			request.getRequestDispatcher("mst_amenities.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
		}
	}
}
}
