package com.es.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.register_member;
import com.es.model.register_society;
import com.es.model.registration_page;

/**
 * Servlet implementation class RegisteredMemberController
 */
@WebServlet("/RegisteredMemberController")
public class RegisteredMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisteredMemberController() {
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
		/*
		 * String action=request.getParameter("action"); System.out.println(action);
		 * String
		 * formname=request.getParameter("formname")==null?"":request.getParameter(
		 * "formname"); if(action.equalsIgnoreCase("accept")) {
		 * 
		 * registration_page userdata=null; HttpSession session=request.getSession();
		 * if(session.getAttribute("user")!=null){
		 * 
		 * userdata=(registration_page)session.getAttribute("user"); }
		 * 
		 * DbTransction dbt = new DbTransactionImpl(); register_society
		 * getSocietyDetails=dbt.getSocietyDetailsForMember(userdata.getUsername());
		 * 
		 * 
		 * String role=request.getParameter(FormFieldUltilityconstant.member[0]); String
		 * soc_name=getSocietyDetails.getSociety_name(); String
		 * area=getSocietyDetails.getArea(); String city=getSocietyDetails.getCity();
		 * String state=getSocietyDetails.getState(); String
		 * memberid=request.getParameter(FormFieldUltilityconstant.member[1]); String
		 * a[]=memberid.split("-"); String wing=a[0]; String houseno=a[1]; String
		 * wing="A"; String houseno="402"; String
		 * name=request.getParameter(FormFieldUltilityconstant.member[2]); String
		 * email=request.getParameter(FormFieldUltilityconstant.member[3]); String
		 * phone=request.getParameter(FormFieldUltilityconstant.member[4]); String
		 * gender=request.getParameter(FormFieldUltilityconstant.member[5]); String
		 * idproof=request.getParameter(FormFieldUltilityconstant.member[6]); String
		 * idnumber=request.getParameter(FormFieldUltilityconstant.member[7]); String
		 * idupload=request.getParameter(FormFieldUltilityconstant.member[8]);
		 * 
		 * String
		 * role=request.getParameter(FormFieldUltilityconstant.register_society[0]);
		 * String
		 * soc_name=request.getParameter(FormFieldUltilityconstant.register_society[1]);
		 * String
		 * soc_type=request.getParameter(FormFieldUltilityconstant.register_society[2]);
		 * String
		 * address=request.getParameter(FormFieldUltilityconstant.register_society[3]);
		 * String
		 * landmark=request.getParameter(FormFieldUltilityconstant.register_society[4]);
		 * String
		 * area=request.getParameter(FormFieldUltilityconstant.register_society[5]);
		 * String
		 * city=request.getParameter(FormFieldUltilityconstant.register_society[6]);
		 * String
		 * state=request.getParameter(FormFieldUltilityconstant.register_society[7]);
		 * String
		 * pincode=request.getParameter(FormFieldUltilityconstant.register_society[8]);
		 * String
		 * wings=request.getParameter(FormFieldUltilityconstant.register_society[9]);
		 * String
		 * houses=request.getParameter(FormFieldUltilityconstant.register_society[10]);
		 * String
		 * name=request.getParameter(FormFieldUltilityconstant.register_society[11]);
		 * String
		 * email=request.getParameter(FormFieldUltilityconstant.register_society[12]);
		 * String
		 * phone=request.getParameter(FormFieldUltilityconstant.register_society[13]);
		 * String
		 * gender=request.getParameter(FormFieldUltilityconstant.register_society[14]);
		 * String
		 * idproof=request.getParameter(FormFieldUltilityconstant.register_society[15]);
		 * String
		 * idnumber=request.getParameter(FormFieldUltilityconstant.register_society[16])
		 * ; String
		 * idupload=request.getParameter(FormFieldUltilityconstant.register_society[17])
		 * ;
		 * 
		 * register_member Member=new register_member(); Member.setRole(role);
		 * Member.setSoc_name(soc_name); Member.setArea(area); Member.setCity(city);
		 * Member.setState(state); Member.setWing(wing); Member.setHouse_num(houseno);
		 * Member.setMember_id(memberid); Member.setName(name); Member.setEmail(email);
		 * Member.setPhone_no(phone); Member.setGender(gender);
		 * Member.setId_proof(idproof); Member.setId_number(idnumber);
		 * Member.setId_upload(idupload);
		 * 
		 * int flag=dbt.insertRegisteredMember(formname,Member); String result
		 * =flag==1?"Success":"Failed"; System.out.println(result);
		 * 
		 * if(result.equals("Success")) { Random rand = new Random(); int pass
		 * =rand.nextInt(900000000) + 100000000; String password=String.valueOf(pass);
		 * registration_page registration=new registration_page();
		 * registration.setRole_name(role); registration.setUsername(name);
		 * registration.setEmail_id(email); registration.setContact_no(phone);
		 * registration.setGender(gender); registration.setPassword(password);
		 * 
		 * int res=dbt.insertSecretary(formname,registration); String reg
		 * =res==1?"SuccessReg":"FailedReg"; System.out.println(reg);
		 * 
		 * request.getRequestDispatcher("MemberRequests.jsp").forward(request,
		 * response);
		 * 
		 * } }
		 */
		String action = request.getParameter("action");
		System.out.println(action);
		String action1 = request.getParameter("action1");
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");

		DbTransction dbt = new DbTransactionImpl();

		if (action != null) {
			HttpSession session = request.getSession();
			registration_page admindata = (registration_page) session.getAttribute("user");
			Random rand = new Random();
			int pass = rand.nextInt(900000000) + 100000000;
			String password = String.valueOf(pass);
			String admin = admindata.getUsername();

			String pswd = null;
			try {
				System.out.println("IN try block");
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.toString().trim().getBytes());

				byte byteData[] = md.digest();

				StringBuffer hexString = new StringBuffer();

				for (int k = 0; k < byteData.length; k++) {
					String hex = Integer.toHexString(0xff & byteData[k]);
					if (hex.length() == 1)
						hexString.append('0');
					hexString.append(hex);
				}
				pswd = hexString.toString().trim();
				System.out.println(pswd);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}

			
			int flag = dbt.insertMemberOnAccept(action, pswd, formname, admin);
			String resultinout = flag == 2 ? "SuccessINOUT" : "FailedINOUT";
			System.out.println(resultinout);

			if (resultinout.equalsIgnoreCase("SuccessINOUT")) {
				
				int flagv=dbt.DeleteRegisteredMemberFromRegMem(action);
				String resul=flagv==1?"Succfinal":"FailedFin";
				System.out.println(resul);
				
				System.out.println("inner if");
				String emailid = action;
				String username = DbTransactionServicesImpl.getNameFromregi_page(action);
				System.out.println(username);
				final String Senderid = "esociety2020@gmail.com";
				final String password1 = "Mkm@15716";

				Properties props=new Properties();

				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session1 = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Senderid, password1);
					}
				});

				try {
					// Random rand = new Random();
					// int otp = rand.nextInt(900000) + 100000;
					Message message = new MimeMessage(session1);
					message.setFrom(new InternetAddress(Senderid));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailid));// to
					// mail
					// address.
					message.setSubject("Your Society Registration");
					String msg1 = "<!DOCTYPE html><html><head></head><body><center><div style='background-color:#f8f8f8; width:500px; height:200px'><div style='background-color:#00e58b; width:500px; height:50px'><h3 style='color:white; padding-top:10px;'>esociety.tech </h3></div><p style='color:gray; margin-left:-300px;'>Dear "
							+ username + ",</p><br><p style='color:gray; margin-top:-10px;'>"
							+ " Your Confirmation is Done. Now,You can login at role of secretary by your id is "
							+ emailid + " and your Password is " + password
							+ ".You can change your password after chage password</p><div></center></body></html>";

					Transport.send(message);

					// HttpSession otpsession = request.getSession();
					// otpsession.setAttribute("otp", otp);
					// otpsession.setMaxInactiveInterval(10 * 60); /* Session Set for 10 minutes */
					// otpsession.setAttribute("UserData", f);
					
					request.getRequestDispatcher("MemberRequests.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				
			}
			request.getRequestDispatcher("MemberRequests.jsp").forward(request, response);
		} else if (action1 != null) {
			int flag=dbt.DeleteRegisteredMemberFromRegMem(action1);
			String resul=flag==1?"Succfinal":"FailedFin";
			System.out.println(resul);
			
			request.getRequestDispatcher("MemberRequests.jsp").forward(request, response);
		}
	}
}