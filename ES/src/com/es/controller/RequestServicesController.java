package com.es.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.dbutil.DbConnectionProvider;
import com.es.dbutil.DbConnectionProviderImpl;
import com.es.dbutil.DbQueryConstants;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.RequestServices;
import com.es.model.registration_page;
import com.es.model.tran_req_services;

/**
 * Servlet implementation class RequestServicesController
 */
@WebServlet("/RequestServicesController")
public class RequestServicesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestServicesController() {
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
		DbConnectionProvider dao = new DbConnectionProviderImpl();
		Connection con = dao.getConnetion();
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		registration_page userData = null;
		DbTransction dbt = new DbTransactionImpl();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			userData = (registration_page) session.getAttribute("user");
		}
		if (action.equalsIgnoreCase("Request")) {

			String userid = DbTransactionServicesImpl.getMemberIdUser(userData.getEmail_id());
			String userEmail = userData.getEmail_id();
			String socname = DbTransactionServicesImpl.getSocName(userData.getEmail_id());
			String servicetype = request.getParameter(FormFieldUltilityconstant.tran_req_service[2]);
			String probdesc = request.getParameter(FormFieldUltilityconstant.tran_req_service[3]);
			String date = request.getParameter(FormFieldUltilityconstant.tran_req_service[4]);
			String timefrom = request.getParameter(FormFieldUltilityconstant.tran_req_service[5]);
			String timeto = request.getParameter(FormFieldUltilityconstant.tran_req_service[6]);

			tran_req_services reqservice = new tran_req_services();

			reqservice.setUser_id(userid);
			reqservice.setUser_email(userEmail);
			reqservice.setService_name(servicetype);
			reqservice.setSociety_name(socname);
			reqservice.setProb_desc(probdesc);
			reqservice.setReqservice_date(date);
			reqservice.setReqservice_time_from(timefrom);
			reqservice.setReqservice_time_to(timeto);
			reqservice.setEntered_by(userData.getUsername());
			reqservice.setLast_updated_by(userData.getUsername());
			System.out.println(servicetype);
			System.out.println(socname);

			int flag = dbt.insertRequestServices(formname, reqservice);
			// dbt.getSociety(formname, reqservice);
			System.out.println(flag);
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
			if (result.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("WorkerDetails.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("tran_req_service.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("Request Now")) {
			String email = userData.getEmail_id();
			String w_email = request.getParameter("action1");

			RequestServices reqs = new RequestServices();

			String q = DbQueryConstants.getUserDetails;
			try {
				PreparedStatement ps = con.prepareStatement(q);
				System.out.println("In getUserDetails");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					reqs.setMember_id(rs.getString("member_id"));
					reqs.setUser_name(rs.getString("name"));
					reqs.setUser_phone(rs.getString("phone_no"));
					reqs.setUser_email(email);
					reqs.setEntered_by(userData.getUsername());
					reqs.setLast_updated_by(userData.getUsername());
				}
				String q1 = DbQueryConstants.getWorDetails;
				try {
					System.out.println("In getworkerDetals");
					PreparedStatement ps1 = con.prepareStatement(q1);
					ps1.setString(1, w_email);
					System.out.println("Worker Email " + w_email);
					ResultSet rs1 = ps1.executeQuery();
					while (rs1.next()) {
						reqs.setW_email(w_email);
						reqs.setW_name(rs1.getString("w_name"));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				String q2 = DbQueryConstants.getMemAddress;
				try {
					System.out.println("getMemberadd");
					PreparedStatement ps2 = con.prepareStatement(q2);
					ps2.setString(1, email);
					ps2.setString(2, email);
					ps2.setString(3, email);
					ps2.setString(4, email);
					ResultSet rs2 = ps2.executeQuery();
					while (rs2.next()) {

						reqs.setSociety_name(rs2.getString("society_name"));
						reqs.setState(rs2.getString("state"));
						reqs.setCity(rs2.getString("city"));
						reqs.setArea(rs2.getString("area"));
						reqs.setAddress(rs2.getString("address"));
						reqs.setLandmark(rs2.getString("landmark"));
						reqs.setPincode(rs2.getString("pincode"));

						String Address = reqs.getMember_id() + "," + reqs.getSociety_name() + "," + reqs.getAddress()
								+ "," + reqs.getLandmark() + "," + reqs.getPincode() + "," + reqs.getArea() + ","
								+ reqs.getCity() + "," + reqs.getState();
						System.out.println("Your Address ::" + Address);

						reqs.setAddress(Address);
					}
					String q3 = DbQueryConstants.getreqDetails;
					try {
						PreparedStatement ps3 = con.prepareStatement(q3);
						ps3.setString(1, email);
						ResultSet rs3 = ps3.executeQuery();
						while (rs3.next()) {
							reqs.setService_type(rs3.getString("service_name"));
							reqs.setProb_desc(rs3.getString("prob_desc"));
							reqs.setReqservice_date(rs3.getString("reqservice_date"));
							reqs.setReqservice_time_from(rs3.getString("reqservice_time_from"));
							reqs.setReqservice_time_to(rs3.getString("reqservice_time_to"));
						}
					} catch (Exception e) {
						System.out.println(e + "IN getRequest catch");
					}

				} catch (Exception e) {
					System.out.println(e + "IN catch");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int flag = dbt.insertWorrequestService(formname, reqs);
			String res = flag == 1 ? "Success.." : "Failed..";
			System.out.println(res);
			if (res.equalsIgnoreCase("Success..")) {
				request.getRequestDispatcher("userPage.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("WorkerDetails.jsp").forward(request, response);
			}
		}
	}
}