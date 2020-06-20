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
import com.es.model.mst_bill;
import com.es.model.notice;
import com.es.model.registration_page;

/**
 * Servlet implementation class NoticeController
 */
@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeController() {
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
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		String action1=request.getParameter("action1");
		
		if (action.equalsIgnoreCase("Add")) {
			System.out.println("In Controller");
			String notice = request.getParameter(FormFieldUltilityconstant.notice[0]);
			
			HttpSession session = request.getSession();
			registration_page secretary=(registration_page) session.getAttribute("user");
			String secretaryid=secretary.getEmail_id(); 
			/* String secretaryid="karanmmodi1998@gmail.com"; */
			DbTransction dbt = new DbTransactionImpl();
			String socid = dbt.getSocietyID(secretaryid);
			System.out.println(socid);
			
			notice ntc = new notice();
			ntc.setNotice(notice);
			ntc.setSecretary_id(secretaryid);
			ntc.setEntered_by(secretaryid);
			ntc.setLast_updated_by(secretaryid);
			ntc.setSoc_id(socid);
			
			int flag = dbt.insertNotice(formname, ntc);
			System.out.println(flag);
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")){
				request.getRequestDispatcher("notice.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		else if(action1!=null) {
			DbTransction dbt = new DbTransactionImpl();
			int flag=dbt.deleteNotice(action1);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("notice.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
	}

}
