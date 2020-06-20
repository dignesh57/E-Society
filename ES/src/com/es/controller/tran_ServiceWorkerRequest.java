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
import com.es.formDesignUltility.HtmlTable;
import com.es.model.tran_ServiceRequest;
import com.es.model.register_worker;

/**
 * Servlet implementation class tran_ServiceWorkerRequest
 */
@WebServlet("/tran_ServiceWorkerRequest")
public class tran_ServiceWorkerRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tran_ServiceWorkerRequest() {
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
		String formname=request.getParameter("formname");
		if(action.equalsIgnoreCase("Assign")) {
			String status=request.getParameter(FormFieldUltilityconstant.ServiceRequest[0]);
			String worker_name=request.getParameter(FormFieldUltilityconstant.ServiceRequest[1]);
			String service=request.getParameter(FormFieldUltilityconstant.ServiceRequest[2]);
			String user_id=request.getParameter(FormFieldUltilityconstant.ServiceRequest[3]);
			String society_name=request.getParameter(FormFieldUltilityconstant.ServiceRequest[4]);
			String wing_name=request.getParameter(FormFieldUltilityconstant.ServiceRequest[5]);
			String house_no=request.getParameter(FormFieldUltilityconstant.ServiceRequest[6]);
			String problem_dis=request.getParameter(FormFieldUltilityconstant.ServiceRequest[7]);
			String req_date=request.getParameter(FormFieldUltilityconstant.ServiceRequest[8]);
			String req_time_from=request.getParameter(FormFieldUltilityconstant.ServiceRequest[9]);
			String req_to_time=request.getParameter(FormFieldUltilityconstant.ServiceRequest[10]);
			
			tran_ServiceRequest serviceReq=new tran_ServiceRequest();
			serviceReq.setStatus(status);
			serviceReq.setWorker_name(worker_name);
			serviceReq.setService(service);
			serviceReq.setUser_id(user_id);
			serviceReq.setSociety_Name(society_name);
			serviceReq.setWing_Name(wing_name);
			serviceReq.setHouse_No(house_no);
			serviceReq.setProblem_Discription(problem_dis);
			serviceReq.setDate(req_date);
			serviceReq.setTime_from(req_time_from);
			serviceReq.setTo_Tima(req_to_time);
			
			System.out.println(society_name);
			System.out.println(worker_name);
			
			//tran_ServiceRequest ServiceReq=new tran_ServiceRequest();
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.insertRequestWorker(formname,serviceReq);
			String result=flag==1?"Success..":"failed..";
			System.out.println(result);
		}
	}
}