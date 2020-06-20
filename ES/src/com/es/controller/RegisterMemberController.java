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
import com.es.model.register_member;

/**
 * Servlet implementation class RegisterMemberController
 */
@WebServlet("/RegisterMemberController")
@MultipartConfig
public class RegisterMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterMemberController() {
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
		String formname = request.getParameter("formname");
		if (action.equalsIgnoreCase("Register Now")) {
			String state = request.getParameter(FormFieldUltilityconstant.register_member[1]);
			String city = request.getParameter(FormFieldUltilityconstant.register_member[2]);
			String area = request.getParameter(FormFieldUltilityconstant.register_member[3]);
			String soc_name = request.getParameter(FormFieldUltilityconstant.register_member[4]);
			String wing = request.getParameter(FormFieldUltilityconstant.register_member[5]);
			String houseType = request.getParameter(FormFieldUltilityconstant.register_member[6]);
			String house_num = request.getParameter(FormFieldUltilityconstant.register_member[7]);
			String member_id = wing + "-" + house_num;
			String name = request.getParameter(FormFieldUltilityconstant.register_member[8]);
			String email = request.getParameter(FormFieldUltilityconstant.register_member[9]);
			String phone_no = request.getParameter(FormFieldUltilityconstant.register_member[10]);
			String gender = request.getParameter(FormFieldUltilityconstant.register_member[11]);
			String id_proof = request.getParameter(FormFieldUltilityconstant.register_member[12]);
			String id_number = request.getParameter(FormFieldUltilityconstant.register_member[13]);
			
			Part part = request.getPart(FormFieldUltilityconstant.register_member[14]);
			String id_upload = part.getSubmittedFileName();
			String path = "E:\\01-02-2020\\ES\\WebContent\\images\\memberid" + File.separator + id_upload;
			System.out.println("path is" + path);

			DbTransactionServices dbs = new DbTransactionServicesImpl();
			boolean pic = dbs.saveFile(part.getInputStream(), path);
			System.out.println("pic is" + pic);
				
			register_member member = new register_member();
						
			String socMember = "Society Member";

			System.out.println(member_id);
			member.setId_upload(id_upload);
			member.setRole(socMember);
			member.setState(state);
			member.setCity(city);
			member.setArea(area);
			member.setSoc_name(soc_name);
			member.setWing(wing);
			member.setHouse_type(houseType);
			member.setHouse_num(house_num);
			member.setMember_id(member_id);
			member.setName(name);
			member.setEmail(email);
			member.setPhone_no(phone_no);
			member.setGender(gender);
			member.setId_proof(id_proof);
			member.setId_number(id_number);
			
			DbTransction dbt = new DbTransactionImpl();
			int flag = dbt.insertRegisterMember(formname, member);
			String result = flag == 1 ? "Success" : "Failed...";
			System.out.println(result);

			if (result.equalsIgnoreCase("Success")) {
				// String uemail = request.getParameter("Email");
				// forgot_password f = new forgot_password();
				// society.setEmail(email);
				// DbTransction dao = new DbTransactionImpl();
				System.out.println("inner if");
				String emailid = member.getEmail();
				String username = member.getName();
				System.out.println(username);
				final String Senderid = "esociety2020@gmail.com";
				final String password = "Mkm@15716";

				Properties props = new Properties();

				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Senderid, password);
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
							+ "  Thank you for your registration to our web application.After Verify your Member ship your Secretary we will send you your id and password.You can ask on this mail if any query.</p><div></center></body></html>";
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
			int flag1=dbt.deleteuser(action1);
			System.out.println(flag1);
			String result1 = flag1==1?"Success":"Failed";
			System.out.println(result1);
			
			if(result1.equalsIgnoreCase("Success")) {
				int flag2=dbt.deleteReg(action1);
				String result2 = flag2==1?"Success":"Failed";
				if(result1.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("SocietyMemberReport.jsp").forward(request, response);
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
