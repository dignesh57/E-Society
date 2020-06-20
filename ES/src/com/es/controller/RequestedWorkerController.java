package com.es.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.register_worker;
import com.es.model.registration_page;

/**
 * Servlet implementation class RequestedWorkerController
 */
@WebServlet("/RequestedWorkerController")
public class RequestedWorkerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestedWorkerController() {
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
		String action1=request.getParameter("action1");
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		if(action!=null) {
			DbTransction dbt=new DbTransactionImpl();
			
			Random rand = new Random();
			int pass = rand.nextInt(900000000) + 100000000;
			String password=String.valueOf(pass);
			
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

			int flag=dbt.insertRegisteredworkeronAccept(action,pswd,formname);
			String result = flag==2?"Success":"Failed";
			System.out.println(result);
			
			
			if (result.equalsIgnoreCase("Success")) {
				// String uemail = request.getParameter("Email");
				// forgot_password f = new forgot_password();
				// society.setEmail(email);
				// DbTransction dao = new DbTransactionImpl();
				
				int flag1=dbt.DeleteRegisteredworker(action);
				String result1 = flag1==1?"SuccessDel":"FailedDel";
				System.out.println(result1);
				
				
				System.out.println("inner if");
				String emailid = action;
				String username = DbTransactionServicesImpl.getNameFromregi_page(action);
				String pass1=password;
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
							+ " Your Confirmation is Done. Now,You can login at role of secretary by your id is "+emailid+" and your Password is "+pass1+".You can change your password after chage password</p><div></center></body></html>";
					message.setContent(msg1, "text/html; charset=utf-8");

					Transport.send(message);

					request.getRequestDispatcher("WorkerRequests.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
		}
		else if(action1!=null) {
			
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.DeleteRegisteredworker(action1);
			String result = flag==1?"SuccessDel":"FailedDel";
			System.out.println(result);
			
			request.getRequestDispatcher("WorkerRequests.jsp").forward(request, response);
			}
		}
}
