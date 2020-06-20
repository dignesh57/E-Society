package com.es.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

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
import com.es.dao.DbTransactionServices;
import com.es.dao.DbTransactionServicesImpl;
import com.es.dao.DbTransction;
import com.es.formDesignUltility.FormFieldUltilityconstant;
import com.es.model.mst_maintenance;
import com.es.model.register_society;
import com.es.model.registration_page;
import com.es.model.tran_maintainance;
import com.es.model.tran_user;

/**
 * Servlet implementation class Mainatenance_Add_Controller
 */
@WebServlet("/Mainatenance_Add_Controller")
public class Mainatenance_Add_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mainatenance_Add_Controller() {
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
		registration_page userdata = null;
		HttpSession session =request.getSession();
		if (session.getAttribute("user") != null) {

			userdata = (registration_page) session.getAttribute("user");
		}
		
		String action=request.getParameter("action");
		String formname=request.getParameter("formname");
		if(action.equalsIgnoreCase("Generate")) {
			tran_maintainance maintainance=new tran_maintainance();
			
			String soc_email=userdata.getEmail_id();
			
			String watchmanCharge=request.getParameter(FormFieldUltilityconstant.mst_maintenance[0]);
			String cleanerCharge=request.getParameter(FormFieldUltilityconstant.mst_maintenance[1]);
			String liftMain=request.getParameter(FormFieldUltilityconstant.mst_maintenance[2]);
			String waterCleaner=request.getParameter(FormFieldUltilityconstant.mst_maintenance[3]);
			String PricePrUnit=request.getParameter(FormFieldUltilityconstant.mst_maintenance[4]);
			String extraExpence=request.getParameter(FormFieldUltilityconstant.mst_maintenance[5]);
			String memberid=request.getParameter(FormFieldUltilityconstant.mst_maintenance[6]);
			String waterunit=request.getParameter(FormFieldUltilityconstant.mst_maintenance[7]);
			String watercharge=request.getParameter("water_charge");
			System.out.println(" "+watchmanCharge+" "+cleanerCharge+" "+liftMain+" "+waterCleaner+" "+extraExpence+" "+watercharge);
			
			DbTransction dbt=new DbTransactionImpl();
			register_society soc=dbt.getSocietyDetailsForMember(soc_email);
			String soc_address=soc.getAddress();
			String soc_address2=soc.getLandmark();
			String soc_address3=soc.getArea()+","+soc.getCity()+",";
			String soc_pincode=soc.getState()+","+soc.getPincode();
			
			tran_user user=dbt.getMemberInfo(memberid, soc.getSociety_name(), soc.getArea(), soc.getCity(), soc.getState());
			
			maintainance.setSoc_id(dbt.getSocietyID(soc_email));
			maintainance.setSoc_name(soc.getSociety_name());
			maintainance.setSoc_address(soc_address);
			maintainance.setSoc_address2(soc_address2);
			maintainance.setSoc_address3(soc_address3);
			maintainance.setSoc_pincode(soc_pincode);
			maintainance.setSoc_email(soc_email);
			maintainance.setMember_id(memberid);
			System.out.println(user.getName());
			maintainance.setMember_name(user.getName());
			maintainance.setMember_email(user.getEmail());
			maintainance.setCleaner_charge(cleanerCharge);
			maintainance.setWatchman_charge(watchmanCharge);
			maintainance.setLift_maintainance_charge(liftMain);
			maintainance.setWatertank_cleaner_charge(waterCleaner);
			maintainance.setPrice_per_unit(PricePrUnit);
			maintainance.setUnit(waterunit);
			maintainance.setWater_usage_charge(watercharge);
			maintainance.setExtra_expense(extraExpence);
			
			int total=Integer.parseInt(watercharge)+Integer.parseInt(extraExpence)+Integer.parseInt(waterCleaner)+Integer.parseInt(cleanerCharge)+Integer.parseInt(watchmanCharge)+Integer.parseInt(liftMain);
			String total_amt=Integer.toString(total);
			maintainance.setTotal_amount(total_amt);
			maintainance.setStatus("pending");
			
			LocalDateTime current = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = current.format(formatter);
			
			LocalDateTime due = LocalDateTime.now().plusDays(15);
			String duedate=due.format(formatter);
			maintainance.setGenerated_date(Date.valueOf(date));
			maintainance.setDue_date(Date.valueOf(duedate));
			maintainance.setEntered_by(soc_email);
			maintainance.setLast_updated_by(soc_email);
			
			int flag=dbt.insertUserMaintainance(maintainance);
			String result=flag==1?"Success":"Failed";
			System.out.println(result);
			if(result.equalsIgnoreCase("Success")) {
				final String Senderid = "esociety2020@gmail.com";
				final String password = "Mkm@15716";

				Properties props = new Properties();

				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");

				Session session1 = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Senderid, password);
					}
				});

				try {
					// Random rand = new Random();
					// int otp = rand.nextInt(900000) + 100000;
					Message message = new MimeMessage(session1);
					message.setFrom(new InternetAddress(Senderid));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));// to
																									// mail
																									// address.
					message.setSubject("Maintainance Alert");
					String msg1 = "<!DOCTYPE html><html><head></head><body><center><div style='background-color:#f8f8f8; width:500px; height:200px'><div style='background-color:#00e58b; width:500px; height:50px'><h3 style='color:white; padding-top:10px;'>esociety.tech </h3></div><p style='color:gray; margin-left:-300px;'>Dear "
							+ user.getName() + ",</p><br><p style='color:gray; margin-top:-10px;'>"
							+ "  Your Maintainance is gnenrated. Total Amount is : "+total_amt+" . Plz pay before due date otherwise charges will be apply.check more details on website.</p><div></center></body></html>";
					message.setContent(msg1, "text/html; charset=utf-8");

					Transport.send(message);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
				request.getRequestDispatcher("Generate_Maintenance.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("Page_not_found.jsp").forward(request, response);
			}
		}
		
		if(action.equalsIgnoreCase("Submit")) {
			mst_maintenance main=new mst_maintenance();
			
			String soc_email=userdata.getEmail_id();
			
			String watchmanCharge=request.getParameter(FormFieldUltilityconstant.mst_maintenance[0]);
			String cleanerCharge=request.getParameter(FormFieldUltilityconstant.mst_maintenance[1]);
			String liftMain=request.getParameter(FormFieldUltilityconstant.mst_maintenance[2]);
			String waterCleaner=request.getParameter(FormFieldUltilityconstant.mst_maintenance[3]);
			String PricePrUnit=request.getParameter(FormFieldUltilityconstant.mst_maintenance[4]);
			String extraExpence=request.getParameter(FormFieldUltilityconstant.mst_maintenance[5]);
			
			System.out.println(cleanerCharge);
			
			main.setSecre_email(soc_email);
			main.setWatchman_charge(watchmanCharge);
			main.setCleaner_charge(cleanerCharge);
			main.setLift_main(liftMain);
			main.setWatertank_cleaner(waterCleaner);
			main.setPrice_pr_unit(PricePrUnit);
			main.setExtra_expence(extraExpence);
			
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.insertMaintenance(formname, main);
			String result=flag==1?"Success":"Failed";
			System.out.println(result);
			request.getRequestDispatcher("mst_maintenance.jsp").forward(request, response);
		}
		
		if(action.equalsIgnoreCase("Update")) {
			mst_maintenance main=new mst_maintenance();
			
			String soc_email=userdata.getEmail_id();
			
			String watchmanCharge=request.getParameter(FormFieldUltilityconstant.mst_maintenance[0]);
			String cleanerCharge=request.getParameter(FormFieldUltilityconstant.mst_maintenance[1]);
			String liftMain=request.getParameter(FormFieldUltilityconstant.mst_maintenance[2]);
			String waterCleaner=request.getParameter(FormFieldUltilityconstant.mst_maintenance[3]);
			String PricePrUnit=request.getParameter(FormFieldUltilityconstant.mst_maintenance[4]);
			String extraExpence=request.getParameter(FormFieldUltilityconstant.mst_maintenance[5]);
			
			System.out.println(cleanerCharge);
			
			main.setSecre_email(soc_email);
			main.setWatchman_charge(watchmanCharge);
			main.setCleaner_charge(cleanerCharge);
			main.setLift_main(liftMain);
			main.setWatertank_cleaner(waterCleaner);
			main.setPrice_pr_unit(PricePrUnit);
			main.setExtra_expence(extraExpence);
			
			DbTransction dbt=new DbTransactionImpl();
			int flag=dbt.updateMaintenance(formname, main);
			String result=flag==1?"Success":"Failed";
			System.out.println(result);
			request.getRequestDispatcher("mst_maintenance.jsp").forward(request, response);
		}
	}
}