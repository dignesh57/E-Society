package com.es.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.mst_wings;

/**
 * Servlet implementation class WingsController
 */
@WebServlet("/WingsController")
public class WingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WingsController() {
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
		PrintWriter out=response.getWriter();
		String action=request.getParameter("action");
		//String formname=request.getParameter("formname")==null?"":request.getParameter(FormFieldUltilityconstant.mst_society_name);
		if(action.equalsIgnoreCase("next")) {
			/*
			 * String
			 * no_of_wing=request.getParameter(FormFieldUltilityconstant.mst_society[9]);
			 * String
			 * wing_name=request.getParameter(FormFieldUltilityconstant.mst_society[10]);
			 * String
			 * house_type=request.getParameter(FormFieldUltilityconstant.mst_society[11]);
			 * String
			 * house_number=request.getParameter(FormFieldUltilityconstant.mst_society[12]);
			 */
			
			mst_wings wings=new mst_wings();
			/*
			 * wings.setNo_of_wings(no_of_wing); wings.setName_of_wings(wing_name);
			 * wings.setType_of_house(house_type); wings.setHouse_number(house_number);
			 * System.out.println(no_of_wing);
			 */
			System.out.println("In Controle.....");
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.insertWings(" ", wings);
			
			if(flag==1) {
				out.print("Success");
				System.out.println("SUccesss");
			}else
			{
				out.print("UNSuccess");
				System.out.println("unSUccesss");
			}
			}
		}
	}
