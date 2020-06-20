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
import com.es.model.mst_amenities;
import com.es.model.mst_event;
import com.es.model.mst_expense;
import com.es.model.registration_page;

/**
 * Servlet implementation class ExpenseController
 */
@WebServlet("/ExpenseController")
public class ExpenseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpenseController() {
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
		//String action1=request.getParameter("action1");
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		
		HttpSession session = request.getSession();
		registration_page secretary=(registration_page) session.getAttribute("user");
		String secretaryid=secretary.getEmail_id();
//		String secretaryid="karanmmodi1998@gmail.com";
		DbTransction dbt = new DbTransactionImpl();
		String socid = dbt.getSocietyID(secretaryid);
		System.out.println(socid);
		
		if(action.equalsIgnoreCase("Add")) {
			
		String expensetype=request.getParameter(FormFieldUltilityconstant.mst_expense[0]);
		String price=request.getParameter(FormFieldUltilityconstant.mst_expense[1]);
		
	    mst_expense expense=new mst_expense();
		expense.setExp_type(expensetype);
		expense.setPrice(price);
		expense.setSoc_id(socid);
		expense.setEntered_by(secretaryid);
		expense.setLast_update_by(secretaryid);
		
		int flag=dbt.insertExpense(formname, expense);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		
		if(result.equalsIgnoreCase("Success")){
			request.getRequestDispatcher("mst_expense.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
		}
		}
		else if(action.equalsIgnoreCase("Update")) {
			
			mst_expense expense=new mst_expense();
			expense.setExp_type(request.getParameter(FormFieldUltilityconstant.mst_expense[0]));
			expense.setPrice(request.getParameter(FormFieldUltilityconstant.mst_expense[1]));
			expense.setLast_update_by(secretaryid);
			expense.setExp_id(request.getParameter("id"));
			
			int flag=dbt.updateExpense(expense);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_expense.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		
	}

}
