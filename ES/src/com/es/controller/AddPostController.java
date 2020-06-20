package com.es.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServices;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.blog;
import com.es.model.mst_amenities;
import com.es.model.registration_page;

/**
 * Servlet implementation class AddPostController
 */
@WebServlet("/AddPostController")
@MultipartConfig
public class AddPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPostController() {
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
		String action = request.getParameter("action");
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		if (action.equalsIgnoreCase("Add Post")) {

			String message = request.getParameter("message");
			
			Part part = request.getPart("pic");
			
			HttpSession session = request.getSession();
			registration_page user = (registration_page) session.getAttribute("user");
			String userid = user.getEmail_id();
			String username = user.getUsername();

			DbTransactionServices dbs=new DbTransactionServicesImpl();
			DbTransction dbt = new DbTransactionImpl();
			String socid = dbs.getMemberSocID(userid);

			/* #e9ecef */
			blog newpost = new blog();
			newpost.setSoc_id(socid);
			newpost.setUserid(userid);
			newpost.setUsername(username);
			newpost.setMessage(message);
			newpost.setImage(part.getSubmittedFileName());
			
			String path = "E:\\01-02-2020\\ES\\WebContent" +File.separator+ "blog_pics" + File.separator + part.getSubmittedFileName();
			System.out.println("path is"+path);
			boolean pic=dbs.saveFile(part.getInputStream(), path);
            System.out.println("pic is"+pic);
            
			int flag = dbt.insertPost(formname, newpost);
			System.out.println(flag);
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		}
		request.getRequestDispatcher("MainBlog.jsp").forward(request, response);
	}
}
