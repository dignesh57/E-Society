package com.es.controller;

import java.io.IOException;
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
import com.es.dao.DbTransction;
import com.es.model.contact_us;
import com.es.model.forgot_password;

/**
 * Servlet implementation class ContactFormController
 */
@WebServlet("/ContactFormController")
public class ContactFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactFormController() {
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
		String action = request.getParameter("action");
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");
		if (action.equalsIgnoreCase("send message")) {
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String msg = request.getParameter("message");
			
			contact_us c=new contact_us();
			c.setF_name(name);
			c.setL_name(surname);
			c.setEmail(email);
			c.setPhone(phone);
			c.setMessage(msg);
			
			DbTransction dao = new DbTransactionImpl();
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.insertContactFormData(formname,c);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if(result.equals("Success")) {
				String emailid = c.getEmail();
				String username = c.getF_name();
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
					Random rand = new Random();
					int otp = rand.nextInt(900000) + 100000;
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(Senderid));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Senderid));// to
																									// mail
																									// address.
					message.setSubject("Contact us Data");
					String msg1 = "<!DOCTYPE html><html><head></head><body><center><div style='background-color:#f8f8f8; width:500px; height:500px'><div style='background-color:#00e58b; width:500px; height:50px'><h3 style='color:white; padding-top:10px;'>esociety.tech</h3></div><p style='color:gray; margin-left:-300px;'>Dear Admin "
							+ ",</p><br><p style='color:gray; margin-top:-10px;'>" + name+""+surname 
							+ "<br>Phone:"+phone+"<br>Email:"+email+" <br><br>"+msg+"</p></div></center></body></html>";
					message.setContent(msg1, "text/html; charset=utf-8");

					Transport.send(message);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
	}
}
