package com.es.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.register_society;
import com.es.model.registration_page;
import com.es.model.tran_req_amenities;
import com.es.model.tran_user;

/**
 * Servlet implementation class RequestAmeniitiesController
 */
@WebServlet("/RequestAmeniitiesController")
public class RequestAmeniitiesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestAmeniitiesController() {
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
		registration_page userdata = null;
		HttpSession session =request.getSession();
		DbTransction dbt=new DbTransactionImpl();
		if (session.getAttribute("user") != null) {

			userdata = (registration_page) session.getAttribute("user");
		}
		
		String action=request.getParameter("action");
		String formname=request.getParameter("formname");
		String soc_email=dbt.getSocietyEmailofUser(userdata.getEmail_id());
		if(action.equalsIgnoreCase("Book Now")) {
			tran_req_amenities amenitie=new tran_req_amenities();
			
			String memberid=request.getParameter(FormFieldUltilityconstant.tran_req_amenities[1]);
			String type=request.getParameter(FormFieldUltilityconstant.tran_req_amenities[0]);
			String date=request.getParameter(FormFieldUltilityconstant.tran_req_amenities[3]);
			String amount=request.getParameter(FormFieldUltilityconstant.tran_req_amenities[4]);
			System.out.println(date);
			
			register_society soc=dbt.getSocietyDetailsForMember(soc_email);
			String soc_address=soc.getAddress();
			String soc_address2=soc.getLandmark();
			String soc_address3=soc.getArea()+","+soc.getCity()+",";
			String soc_pincode=soc.getState()+","+soc.getPincode();
			
			tran_user user=dbt.getMemberInfo(memberid, soc.getSociety_name(), soc.getArea(), soc.getCity(), soc.getState());
			
			amenitie.setAmenities_type(type);
			amenitie.setAmount(amount);
			amenitie.setSoc_id(dbt.getSocietyID(soc_email));
			amenitie.setSoc_name(soc.getSociety_name());
			amenitie.setSoc_address(soc_address);
			amenitie.setSoc_address2(soc_address2);
			amenitie.setSoc_address3(soc_address3);
			amenitie.setSoc_pincode(soc_pincode);
			amenitie.setSoc_email(soc_email);
			amenitie.setMember_id(memberid);
			amenitie.setMember_name(user.getName());
			amenitie.setMember_email(user.getEmail());
			amenitie.setStatus("pending");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate current = LocalDate.parse(date,formatter);
			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String fdate = current.format(formatter1);
			
			amenitie.setReqamenities_date(Date.valueOf(fdate));
			amenitie.setEntered_by(soc_email);
			amenitie.setLast_updated_by(soc_email);
			
			int flag=dbt.insertRequestAmenities(formname, amenitie);
			String result=flag==1?"Success":"Failed";
			System.out.println(result);
			if(result.equalsIgnoreCase("Success")) {
			request.setAttribute("msg", "success");
			request.getRequestDispatcher("tran_req_amenities.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
	}
}
