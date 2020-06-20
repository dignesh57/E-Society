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
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.mst_expense;
import com.es.model.registration_page;
import com.es.model.tran_feedback;

/**
 * Servlet implementation class FeedbackController
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedbackController() {
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
		String action = request.getParameter("action") == null ? "itsnull" : request.getParameter("action");
		// String action1=request.getParameter("action1");
		String formname = request.getParameter("formname") == null ? "" : request.getParameter("formname");

		if (action.equalsIgnoreCase("Send")) {
			String name = request.getParameter(FormFieldUltilityconstant.tran_feedback[0]);
			String email = request.getParameter(FormFieldUltilityconstant.tran_feedback[1]);
			String feedbacktopic = request.getParameter(FormFieldUltilityconstant.tran_feedback[2]);
			String msg = request.getParameter(FormFieldUltilityconstant.tran_feedback[3]);

			tran_feedback feedback = new tran_feedback();
			feedback.setName(name);
			feedback.setUser_id(email);
			feedback.setFeedback_topic(feedbacktopic);
			feedback.setFeedback_description(msg);

			DbTransction dbt = new DbTransactionImpl();
			int flag = dbt.insertUserFeedback(formname, feedback);
			System.out.println(flag);
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);

			if (result.equalsIgnoreCase("Success")) {
				String emailid = email;
				String username = name;
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
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailid));// to
																									// mail
					message.setSubject("OTP Request");
					String msg1 = "<!DOCTYPE html><html><head></head><body><center><div style='background-color:#f8f8f8; width:500px; height:200px'><div style='background-color:#00e58b; width:500px; height:50px'><h3 style='color:white; padding-top:10px;'>esociety.tech </h3></div><p style='color:gray; margin-left:-300px;'>Dear "
							+ username
							+ ",</p><br><p style='color:gray; margin-top:-10px;'>Thank you so much for your kind words,"
							+ username
							+ ". We really appreciate you taking the time out to share your experience with us. We count ourselves lucky for Users like you. We look forward to work on your feedback.</p><div></center></body></html>";
					message.setContent(msg1, "text/html; charset=utf-8");

					Transport.send(message);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				request.getRequestDispatcher("tran_feedback.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
	}
}
