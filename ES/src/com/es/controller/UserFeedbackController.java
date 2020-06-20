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
import com.es.model.tran_complain;
import com.es.model.tran_feedback;

/**
 * Servlet implementation class UserFeedbackController
 */
@WebServlet("/UserFeedbackController")
public class UserFeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFeedbackController() {
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
		String action=request.getParameter("action");
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		if(action.equalsIgnoreCase("Add")) {
			
		String userid=request.getParameter(FormFieldUltilityconstant.tran_feedback[0]);
		String feedbacktype=request.getParameter(FormFieldUltilityconstant.tran_feedback[1]);
		String feedbackdesc=request.getParameter(FormFieldUltilityconstant.tran_feedback[2]);
		
		tran_feedback userfeedback=new tran_feedback();
		userfeedback.setUser_id(userid);
		userfeedback.setFeedback_topic(feedbacktype);
		userfeedback.setFeedback_description(feedbackdesc);
		
		System.out.println(feedbacktype);
		
		
		DbTransction dbt=new DbTransactionImpl();
		int flag=dbt.insertUserFeedback(formname,userfeedback);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		}
	}
}
