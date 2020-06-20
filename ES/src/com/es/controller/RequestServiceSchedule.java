package com.es.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServices;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.RequestServices;
import com.es.model.registration_page;
import com.es.model.tran_user;
import com.es.model.tran_worker;

/**
 * Servlet implementation class RequestServiceSchedule
 */
@WebServlet("/RequestServiceSchedule")
public class RequestServiceSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestServiceSchedule() {
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
		String action = request.getParameter("action") == null ? "action" : request.getParameter("action");
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		HttpSession session = request.getSession();
		registration_page userData = null;
		if (session.getAttribute("user") != null) {
			userData = (registration_page) session.getAttribute("user");
		}
		DbTransction dbt = new DbTransactionImpl();
		DbTransactionServices dbts = new DbTransactionServicesImpl();

		if (action.equalsIgnoreCase("Accept")) {

			String id = request.getParameter("idid");
			System.out.println("ID IS " + id);
			System.out.println("In Controller");

			RequestServices reqs = new RequestServices();

			String date = request.getParameter("date");
			String timef = request.getParameter("timef");

			// String id=request.getParameter(arg0)
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String problem = request.getParameter("problem");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String timet = request.getParameter("timet");
			String userEmail = request.getParameter("useremail");
			String w_email = userData.getEmail_id();
			String w_name = userData.getUsername();

			System.out.println(date + "AND " + address);

			reqs.setUser_email(email);
			reqs.setUser_name(name);
			reqs.setUser_phone(phone);
			reqs.setAddress(address);
			reqs.setProb_desc(problem);
			reqs.setReqservice_time_to(timet);
			reqs.setW_email(w_email);
			reqs.setW_name(w_name);
			reqs.setUser_email(userEmail);
			reqs.setReqservice_date(date);
			reqs.setReqservice_time_from(timef);

			int flag = dbt.scheduleService(w_email, reqs);
			String result = flag == 1 ? "Succ" : "Failed";
			System.out.println(result);
			if (result.equalsIgnoreCase("Succ")) {
				int flag1 = dbt.updateRequest(reqs);
				String result1 = flag1 == 1 ? "SuccUpdate" : "FailedUPdate";
				System.out.println(result1);
				response.sendRedirect("Worker.jsp");
			}
		}else if(action.equalsIgnoreCase("Decline")) {
			
			RequestServices reqs = new RequestServices();

			reqs.setReqservice_date(request.getParameter("date"));
			reqs.setReqservice_time_from(request.getParameter("timef"));
			reqs.setUser_email(request.getParameter("useremail"));
			
			int flag = dbt.updateDecline(reqs);

			String res = flag == 1 ? "Successupdate" : "UpdateFailed";
			System.out.println(res);
			if (res.equalsIgnoreCase("Successupdate")) {
				response.sendRedirect("Worker.jsp");
			}else {
				response.sendRedirect("Worker.jsp");
			} 
			
		}else if (action.equalsIgnoreCase("On Way")) {
			RequestServices reqs = new RequestServices();
			System.out.println("ONWAY Controller");
			String date = request.getParameter("date");
			String timef = request.getParameter("timef");
			String u_email = request.getParameter("uemail");

			reqs.setReqservice_date(date);
			reqs.setReqservice_time_from(timef);
			reqs.setUser_email(u_email);

			int flag = dbt.updateScheduleOnWay(reqs);

			String res = flag == 1 ? "Successupdate" : "UpdateFailed";
			System.out.println(res);
			if (res.equalsIgnoreCase("Successupdate")) {
				response.sendRedirect("Worker.jsp");
			}else {
				response.sendRedirect("Worker.jsp");
			}
		} else if (action.equalsIgnoreCase("Done")) {
			RequestServices reqs = new RequestServices();

			String date = request.getParameter("date");
			String timef = request.getParameter("timef");
			String u_email = request.getParameter("uemail");

			reqs.setReqservice_date(date);
			reqs.setReqservice_time_from(timef);
			reqs.setUser_email(u_email);
			int flag = dbt.updateScheduleCancle(reqs);
			String res = flag == 1 ? "Successupdate" : "UpdateFailed";
			System.out.println(res);
			if (res.equalsIgnoreCase("Successupdate")) {
				int flag1 = dbt.removeonCancle(reqs);
				String res1 = flag1 == 1 ? "Successupdate" : "UpdateFailed";
				System.out.println(res1);
				response.sendRedirect("Worker.jsp");
			}
		} else if (action.equalsIgnoreCase("Change Now")) {
			String oldpass = request.getParameter(FormFieldUltilityconstant.changePassword[0]);
			String pass = null;
			System.out.println("Old pass is" + oldpass);
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(oldpass.toString().trim().getBytes());

				byte byteData[] = md.digest();

				StringBuffer hexString = new StringBuffer();

				for (int k = 0; k < byteData.length; k++) {
					String hex = Integer.toHexString(0xff & byteData[k]);
					if (hex.length() == 1)
						hexString.append('0');
					hexString.append(hex);
				}
				pass = hexString.toString().trim();
				System.out.println("Enxtrypted :" + pass);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			if (userData.getPassword().equalsIgnoreCase(pass)) {
				response.sendRedirect("ChangePassword1.jsp");
			} else if (oldpass.equalsIgnoreCase("null")) {
				response.sendRedirect("ChangePassword.jsp");
			} else {
				response.sendRedirect("ChangePassword.jsp");
			}
		} else if (action.equalsIgnoreCase("Update")) {
			
			String name = request.getParameter(FormFieldUltilityconstant.workerProfile[0]);
			String email = request.getParameter(FormFieldUltilityconstant.workerProfile[1]);
			String phoneno = request.getParameter(FormFieldUltilityconstant.workerProfile[2]);
			String gender = request.getParameter(FormFieldUltilityconstant.workerProfile[3]);

			registration_page registration = new registration_page();
			registration.setUsername(name);
			registration.setEmail_id(email);
			registration.setContact_no(phoneno);
			registration.setGender(gender);

			int flagvalue = dbts.updateRegistrationData(formname, registration);
			System.out.println(flagvalue);
			String result = flagvalue == 1 ? "SuccessRegistration" : "FailedRegistration";
			System.out.println(result);
			
			if (userData.getRole_name().equalsIgnoreCase("Worker")) {
				String availFrom = request.getParameter(FormFieldUltilityconstant.workerProfile[4]);
				String availTo = request.getParameter(FormFieldUltilityconstant.workerProfile[5]);

				tran_worker wor = new tran_worker();
				wor.setW_name(name);
				wor.setW_email(email);
				wor.setW_phone(phoneno);
				wor.setW_gender(gender);
				wor.setAvailable_from(availFrom);
				wor.setAvailable_to(availTo);

				int flag = dbt.updateWorkerProfile(formname, wor);
				String resul = flag == 1 ? "Success" : "Failed";
				System.out.println("worUpdate" + resul);

				int flag1 = dbts.updateRegistrationData(formname, registration);
				String resul1 = flag1 == 1 ? "RegiUpdateSucWor" : "RegiUpdaFailWor";
				System.out.println(resul1);

				response.sendRedirect("WorUserProfile.jsp");
			} else if (userData.getRole_name().equalsIgnoreCase("Society Member")) {

				tran_user user = new tran_user();
				
				user.setName(name);
				user.setEmail(email);
				user.setPhone_no(phoneno);
				user.setGender(gender);

				int flag = dbt.updateMemberProfile(user);
				String resultvalue = flag == 1 ? "succupdate" : "failupdate";
				System.out.println("Update MEmber " + resultvalue);

				int flag1 = dbts.updateRegistrationData(formname, registration);
				String result1 = flag1 == 1 ? "RegiUpdateSucUser" : "RegiUpdateSucUser";
				System.out.println("Update MEmber " + result1);

				response.sendRedirect("WorUserProfile.jsp");
			}
		} else if (action.equalsIgnoreCase("Change Password")) {
			response.sendRedirect("ChangePassword.jsp");
		}
	}
}