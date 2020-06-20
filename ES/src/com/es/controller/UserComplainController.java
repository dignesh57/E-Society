package com.es.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServices;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.tran_complain;
import com.es.model.tran_req_services;

/**
 * Servlet implementation class UserComplainController
 */
@WebServlet("/UserComplainController")
@MultipartConfig
public class UserComplainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserComplainController() {
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
			DbTransction dbt=new DbTransactionImpl();
		
		String name=request.getParameter(FormFieldUltilityconstant.tran_complain[0]);
		String userid=request.getParameter(FormFieldUltilityconstant.tran_complain[1]);
		String Complainto=request.getParameter(FormFieldUltilityconstant.tran_complain[2]);
		String Complaintype=request.getParameter(FormFieldUltilityconstant.tran_complain[3]);
		String Complaindesc=request.getParameter(FormFieldUltilityconstant.tran_complain[4]);
		String soc_id=dbt.getSocietyIDofUser(userid);
		
		Part part=request.getPart(FormFieldUltilityconstant.tran_complain[5]);
		String file=part.getSubmittedFileName();
		if(file!=null) {
		String path = "E:\\01-02-2020\\ES\\WebContent\\Society Images\\complaintdocs" + File.separator + file;
		System.out.println("path is"+path);
		
		DbTransactionServices dbs=new DbTransactionServicesImpl();
		boolean pic=dbs.saveFile(part.getInputStream(), path);
        System.out.println("pic is"+pic);
		System.out.println("path = "+file);
		}
		else {
			file="not submit";
		}
		
		tran_complain usercomplain=new tran_complain();
		usercomplain.setUser_id(userid);
		usercomplain.setName(name);
		usercomplain.setComplain_to(Complainto);
		usercomplain.setComplain_type(Complaintype);
		usercomplain.setComplain_description(Complaindesc);
		usercomplain.setDocument(file);
		usercomplain.setSoc_id(soc_id);
		System.out.println(Complaintype);
		
		int flag=dbt.insertUserComplain(formname,usercomplain);
		System.out.println(flag);
		String result = flag==1?"Success":"Failed";
		System.out.println(result);
		if(result.equalsIgnoreCase("Success")) {
			request.setAttribute("msg", "Your complaint registered Successfully");
		}else {
			request.setAttribute("msg", "Your complaint not registered Successfully");
		}
			request.getRequestDispatcher("tran_complain.jsp").forward(request, response);
		}
	}
}
