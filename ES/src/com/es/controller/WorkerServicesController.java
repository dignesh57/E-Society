package com.es.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import com.es.model.register_society;
import com.es.model.register_worker;

/**
 * Servlet implementation class WorkerServicesController
 */
@WebServlet("/WorkerServicesController")
@MultipartConfig
public class WorkerServicesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WorkerServicesController() {
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
		String action1=request.getParameter("action1");
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		if (action.equalsIgnoreCase("Register Now")) {
			String w_state = request.getParameter(FormFieldUltilityconstant.register_worker[1]);
			String w_city = request.getParameter(FormFieldUltilityconstant.register_worker[2]);
			String w_area = request.getParameter(FormFieldUltilityconstant.register_worker[3]);
			String address = request.getParameter(FormFieldUltilityconstant.register_worker[4]);
			String pincode = request.getParameter(FormFieldUltilityconstant.register_worker[5]);
			String ser_type = request.getParameter(FormFieldUltilityconstant.register_worker[6]);
			String ser_dis = request.getParameter(FormFieldUltilityconstant.register_worker[7]);
			String w_name = request.getParameter(FormFieldUltilityconstant.register_worker[8]);
			String w_email = request.getParameter(FormFieldUltilityconstant.register_worker[9]);
			String w_phone_no = request.getParameter(FormFieldUltilityconstant.register_worker[10]);
			String w_gender = request.getParameter(FormFieldUltilityconstant.register_worker[11]);
			String avail_from = request.getParameter(FormFieldUltilityconstant.register_worker[12]);
			String avail_to = request.getParameter(FormFieldUltilityconstant.register_worker[13]);
			String id_proof = request.getParameter(FormFieldUltilityconstant.register_worker[14]);
			String id_number = request.getParameter(FormFieldUltilityconstant.register_worker[15]);
			String worker = "Worker";

			Part part = request.getPart(FormFieldUltilityconstant.register_worker[16]);
			String id_upload = part.getSubmittedFileName();
			String path = "E:\\01-02-2020\\ES\\WebContent\\images\\workerid" + File.separator + id_upload;
			System.out.println("path is" + path);

			DbTransactionServices dbs = new DbTransactionServicesImpl();
			boolean pic = dbs.saveFile(part.getInputStream(), path);
			System.out.println("pic is" + pic);

			register_worker workerservicesdesc = new register_worker();

			workerservicesdesc.setRole(worker);
			workerservicesdesc.setState(w_state);
			workerservicesdesc.setCity(w_city);
			workerservicesdesc.setArea(w_area);
			workerservicesdesc.setAddress(address);
			workerservicesdesc.setPincode(pincode);
			workerservicesdesc.setService_type(ser_type);
			workerservicesdesc.setService_desc(ser_dis);
			workerservicesdesc.setAvailable_from(avail_from);
			workerservicesdesc.setAvailable_to(avail_to);
			workerservicesdesc.setW_name(w_name);
			workerservicesdesc.setW_email(w_email);
			workerservicesdesc.setW_gender(w_gender);
			workerservicesdesc.setW_phone(w_phone_no);
			workerservicesdesc.setId_proof(id_proof);
			workerservicesdesc.setId_number(id_number);
			workerservicesdesc.setId_upload(id_upload);

			System.out.println("<%if (FormFieldUltilityconstant.register_member[i] == \"State\") {%>\r\n" + 
					"									onchange=\"OnselectChangeState (this)\"\r\n" + 
					"									<%} else if (FormFieldUltilityconstant.register_member[i] == \"City\") {%>\r\n" + 
					"									onchange=\"OnselectChangeCity (this)\"\r\n" + 
					"									<%} else if (FormFieldUltilityconstant.register_member[i] == \"ID Proof\") {%>\r\n" + 
					"									onchange=\"OnSelectChangeIDProof (this)\"\r\n" + 
					"									<%} else if (FormFieldUltilityconstant.register_member[i] == \"Society Name\") {%>\r\n" + 
					"									onchange=\"OnSelectChangeSoc_name(this)\"\r\n" + 
					"									<%} else if (FormFieldUltilityconstant.register_member[i] == \"Wing\") {%>\r\n" + 
					"									onchange=\"OnSelectChangeSoc_wing (this)\" <%} else {%>\r\n" + 
					"									onchange=\"OnselectArea (this)\" <%}%>");

			DbTransction dbt = new DbTransactionImpl();
			int flag = dbt.insertWorkerService(formname, workerservicesdesc);
			System.out.println(flag);
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);

			if (result.equalsIgnoreCase("Success")) {
				// String uemail = request.getParameter("Email");
				// forgot_password f = new forgot_password();
				// society.setEmail(email);
				DbTransction dao = new DbTransactionImpl();

				String emailid = workerservicesdesc.getW_email();
				String username = workerservicesdesc.getW_name();
				System.out.println(username);
				final String Senderid = "esociety2020@gmail.com";
				final String password1 = "Mkm@15716";

				Properties props = new Properties();

				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Senderid, password1);
					}
				});

				try {
					// Random rand = new Random();
					// int otp = rand.nextInt(900000) + 100000;
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(Senderid));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailid));// to
																									// mail
																									// address.
					message.setSubject("Your Society Registration");
					String msg1 = "<!DOCTYPE html><html><head></head><body><center><div style='background-color:#f8f8f8; width:500px; height:200px'><div style='background-color:#00e58b; width:500px; height:50px'><h3 style='color:white; padding-top:10px;'>esociety.tech </h3></div><p style='color:gray; margin-left:-300px;'>Dear "
							+ username + ",</p><br><p style='color:gray; margin-top:-10px;'>"
							+ "  Thank you for your registration to our web application.After Verify your Service we will send you your id and password.You can ask on this mail if any query.</p><div></center></body></html>";
					message.setContent(msg1, "text/html; charset=utf-8");

					Transport.send(message);

					// HttpSession otpsession = request.getSession();
					// otpsession.setAttribute("otp", otp);
					// otpsession.setMaxInactiveInterval(10 * 60); /* Session Set for 10 minutes */
					// otpsession.setAttribute("UserData", f);

					request.getRequestDispatcher("home.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
		else if(action1!=null) {
			DbTransction dbt=new DbTransactionImpl();
			int flag1=dbt.deleteWorker(action1);
			System.out.println(flag1);
			String result1 = flag1==1?"Success":"Failed";
			System.out.println(result1);
			
			if(result1.equalsIgnoreCase("Success")) {
				int flag2=dbt.deleteReg(action1);
				String result2 = flag2==1?"Success":"Failed";
				if(result1.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("WorkerReport.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
				}
				}
			else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
	}
}
