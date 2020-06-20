package com.es.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.servlet.http.HttpSession;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.mst_security_guard;
import com.es.model.registration_page;

/**
 * Servlet implementation class SecurityGuardController
 */
@WebServlet("/SecurityGuardController")
@MultipartConfig
public class SecurityGuardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SecurityGuardController() {
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

		registration_page userData = null;
		DbTransction dbt = new DbTransactionImpl();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			userData = (registration_page) session.getAttribute("user");
		}
		String action=request.getParameter("action")==null?"itsnull":request.getParameter("action");
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		String action1=request.getParameter("action1");
		
		if (action.equalsIgnoreCase("submit")) {
			String name = request.getParameter(FormFieldUltilityconstant.mst_security_guard[0]);
			String phone_no = request.getParameter(FormFieldUltilityconstant.mst_security_guard[1]);
			String email = request.getParameter(FormFieldUltilityconstant.mst_security_guard[2]);
			String gender = request.getParameter(FormFieldUltilityconstant.mst_security_guard[3]);
			String id_proof = request.getParameter(FormFieldUltilityconstant.mst_security_guard[4]);
			String id_number = request.getParameter(FormFieldUltilityconstant.mst_security_guard[5]);
			String password = request.getParameter(FormFieldUltilityconstant.mst_security_guard[7]);
			String enterName = userData.getUsername();
			String useremail=userData.getEmail_id();
			
						
			mst_security_guard security = new mst_security_guard();
			security.setName(name);
			security.setEmail(email);
			security.setGender(gender);
			security.setPhone_no(phone_no);
			security.setId_proof(id_proof);
			security.setId_number(id_number);
			
			String soc_id=dbt.getSocietyID(useremail);
			security.setSoc_id(soc_id);
			
			String passs = null;
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
				passs = hexString.toString().trim();
				System.out.println(passs);
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			
			security.setPassword(passs);
			
			int flag = dbt.insertSecurityGuard(formname, security, enterName);
			String result = flag == 1 ? "Success.." : "Faieled..";
			if (result.equalsIgnoreCase("Success..")) {
				registration_page login=new registration_page();
				String role_name="Security Guard";
				String uname = request.getParameter(FormFieldUltilityconstant.mst_security_guard[0]);
				String uphone_no = request.getParameter(FormFieldUltilityconstant.mst_security_guard[1]);
				String uemail = request.getParameter(FormFieldUltilityconstant.mst_security_guard[2]);
				String ugender = request.getParameter(FormFieldUltilityconstant.mst_security_guard[3]);

				
				login.setRole_name(role_name);
				login.setUsername(uname);
				login.setEmail_id(uemail);
				login.setContact_no(uphone_no);
				login.setGender(ugender);
				login.setPassword(passs);
				
				int res = dbt.insertSecretary(formname, login);
				String reg = res == 1 ? "SuccessReg" : "FailedReg";
				System.out.println(reg);
				if(reg.equalsIgnoreCase("SuccessReg")) {
					final String Senderid = "esociety2020@gmail.com";
					final String password1 = "Mkm@15716";

					Properties props = new Properties();

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
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));// to
																										// mail
																										// address.
						message.setSubject("Your Society Registration");
						String msg1 = "<!DOCTYPE html><html><head></head><body><center><div style='background-color:#f8f8f8; width:500px; height:200px'><div style='background-color:#00e58b; width:500px; height:50px'><h3 style='color:white; padding-top:10px;'>esociety.tech </h3></div><p style='color:gray; margin-left:-300px;'>Dear "
								+ name + ",</p><br><p style='color:gray; margin-top:-10px;'>"
								+ " Your Confirmation is Done. Now,You can login at role of secretary by your id is "
								+ email + " and your Password is " + password
								+ ".You can change your password after chage password</p><div></center></body></html>";
						message.setContent(msg1, "text/html; charset=utf-8");

						Transport.send(message);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e);
					}
				response.sendRedirect("mst_Security_Guard.jsp");
					
				}
			}
		}
		else if(action1!=null) {
			System.out.println("in del");
			int flag=dbt.deleteSecurity(action1);
			System.out.println(flag);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equalsIgnoreCase("Success")) {
				int flag1=dbt.deleteSecurityRg(action1);
				System.out.println(flag1);
				String result1 = flag1==1?"Success":"Failed";
				if(result1.equalsIgnoreCase("Success")) {
				request.getRequestDispatcher("mst_Security_Guard.jsp").forward(request, response);
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