package com.es.controller;

import java.io.File;
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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.es.dao.DbTransactionImpl;
import com.es.dao.DbTransactionServices;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.forgot_password;
import com.es.model.register_member;
import com.es.model.register_society;

/**
 * Servlet implementation class SocietyController
 */
@WebServlet("/SocietyController")
@MultipartConfig
public class SocietyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocietyController() {
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
		String action=request.getParameter("action")==null?"itsnull":request.getParameter("action");
		String action1=request.getParameter("action1");
		System.out.println(action1);
		String formname=request.getParameter("formname")==null?"":request.getParameter("formname");
		if(action.equalsIgnoreCase("Register Now")) {
			String soc_state=request.getParameter(FormFieldUltilityconstant.register_society[1]);
			String soc_city=request.getParameter(FormFieldUltilityconstant.register_society[2]);
			String soc_area=request.getParameter(FormFieldUltilityconstant.register_society[3]);
			String soc_address=request.getParameter(FormFieldUltilityconstant.register_society[4]);
			String soc_landmark=request.getParameter(FormFieldUltilityconstant.register_society[5]);
			String soc_pincode=request.getParameter(FormFieldUltilityconstant.register_society[6]);
			String soc_name=request.getParameter(FormFieldUltilityconstant.register_society[7]);
			String soc_type=request.getParameter(FormFieldUltilityconstant.register_society[8]);
			String[] name_of_wing=request.getParameterValues(FormFieldUltilityconstant.register_society[9]);
			String total_num_house=request.getParameter(FormFieldUltilityconstant.register_society[10]);
			String name=request.getParameter(FormFieldUltilityconstant.register_society[11]);
			String email=request.getParameter(FormFieldUltilityconstant.register_society[12]);
			String phone_no=request.getParameter(FormFieldUltilityconstant.register_society[13]);
			String gender=request.getParameter(FormFieldUltilityconstant.register_society[14]);
			String id_proof=request.getParameter(FormFieldUltilityconstant.register_society[15]);
			String id_number=request.getParameter(FormFieldUltilityconstant.register_society[16]);
			String secre="Secretary";
			
			System.out.println(soc_state+soc_city+soc_area+soc_address+soc_landmark+soc_pincode+soc_name+soc_type+name_of_wing+total_num_house+name+gender);
			Part part=request.getPart(FormFieldUltilityconstant.register_society[17]);
			String id_upload = part.getSubmittedFileName();
			String path = "E:\\01-02-2020\\ES\\WebContent\\Society Images" + File.separator + id_upload;
			System.out.println("path is"+path);
			
			DbTransactionServices dbs=new DbTransactionServicesImpl();
			boolean pic=dbs.saveFile(part.getInputStream(), path);
            System.out.println("pic is"+pic);
			System.out.println("path = "+id_upload);
				
			register_society society=new register_society();
			System.out.println("Society Type"+soc_type);
			
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<name_of_wing.length;i++) {
				sb.append(name_of_wing[i]+",");
			}
			String wings=sb.toString();
			
			society.setRole(secre);
			society.setState(soc_state);
			society.setCity(soc_city);
			society.setArea(soc_area);
			society.setAddress(soc_address);
			society.setLandmark(soc_landmark);
			society.setPincode(soc_pincode);
			society.setSociety_name(soc_name);
			society.setSociety_type(soc_type);
			society.setName_of_wings(wings);
			society.setTotal_number_of_house(total_num_house);
			society.setName(name);
			society.setEmail(email);
			society.setPhone_no(phone_no);
			society.setGender(gender);
			society.setId_proof(id_proof);
			society.setId_number(id_number);
			society.setId_upload(id_upload);
			
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.insertSociety(formname,society);
			String result = flag==1?"Success":"Failed";
			System.out.println(result);
			
			if (result.equalsIgnoreCase("Success")) {
				//String uemail = request.getParameter("Email");
				//forgot_password f = new forgot_password();
				//society.setEmail(email);
				DbTransction dao = new DbTransactionImpl();
				
					String emailid = society.getEmail();
					String username = society.getName();
					System.out.println(username);
					final String Senderid = "esociety2020@gmail.com";
					final String password = "Mkm@15716";

					Properties props=new Properties();

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
						//Random rand = new Random();
						//int otp = rand.nextInt(900000) + 100000;
						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress(Senderid));
						message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailid));// to
																										// mail
																										// address.
						message.setSubject("Your Society Registration");
						String msg1 = "<!DOCTYPE html><html><head></head><body><center><div style='background-color:#f8f8f8; width:500px; height:200px'><div style='background-color:#00e58b; width:500px; height:50px'><h3 style='color:white; padding-top:10px;'>esociety.tech </h3></div><p style='color:gray; margin-left:-300px;'>Dear "
								+ username + ",</p><br><p style='color:gray; margin-top:-10px;'>"
								+ "  Thank you for your registration to our web application.After Verify your society we will send you your id and password.You can ask on this mail if any query.</p><div></center></body></html>";
						message.setContent(msg1, "text/html; charset=utf-8");

						Transport.send(message);

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
				int flag1=dbt.deleteSoc(action1);
				System.out.println(flag1);
				String result1 = flag1==1?"Success":"Failed";
				System.out.println(result1);
				
				if(result1.equalsIgnoreCase("Success")) {
					int flag2=dbt.deleteReg(action1);
					String result2 = flag2==1?"Success":"Failed";
					if(result1.equalsIgnoreCase("Success")) {
					request.getRequestDispatcher("SocietyReport.jsp").forward(request, response);
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