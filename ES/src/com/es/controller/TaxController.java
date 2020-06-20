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
import com.es.model.mst_id_type;
import com.es.model.mst_tax;

/**
 * Servlet implementation class TaxController
 */
@WebServlet("/TaxController")
public class TaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaxController() {
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
		String action=request.getParameter("action").toString().trim();
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		if(action.equalsIgnoreCase("Add")) {
			
		String taxname=request.getParameter(FormFieldUltilityconstant.mst_tax[0]).toString().trim();
		String taxpercent=request.getParameter(FormFieldUltilityconstant.mst_tax[1]).toString().trim();
		
	    mst_tax tax=new mst_tax();
		tax.setTax_name(taxname);
		tax.setTax_percent(taxpercent);
		
		DbTransction dbt=new DbTransactionImpl();
		int flag=dbt.insertTax(formname, tax);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		}
	}

}
