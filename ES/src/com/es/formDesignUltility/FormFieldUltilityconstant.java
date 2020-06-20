package com.es.formDesignUltility;


public class FormFieldUltilityconstant {

	public static String[] mst_state = { "Id", "Name" };
	public static String[] mst_mst_city = { "State", "City" };
	public static String[] mst_mst_mst_area = { "State", "City", "Area" ,"Pincode"};
	public static String[] register_society = {"Role","State", "City", "Area", "Address","Landmark", "pincode","Society Name","Society Type"
			,"Name of Wings","Totla Number Of House","Name","Email","Phone No","Gender","ID Proof","ID Number","ID Upload"};
	public static String[] mst_amenities = { "role", "Amenities Name","Rent per day"};
	public static String[] mst_amenitiesupdate = { "role", "Name","Rent"};
	public static String[] mst_amenitiesinsert = { "role", "Name","Rent"};
	public static String[] mst_service = { "role", "Name" };
	public static String[] mst_problem_type = { "service", "problem type" };
	public static String[] mst_role = { "Role Name" };
	public static String[] mst_tax = { "Tax Name", "Percent" };
	public static String[] mst_bill = { "Bill Type" };
	public static String[] mst_event = { "Event Name" };
	public static String[] mst_expense = { "Expense Type","Price" };
	public static String[] mst_expenseupdate = { "Expense","Price" };
	public static String[] mst_complain = { "NaemOfUser", "Complain Type" };
	public static String[] mst_id_type = { "ID Type" };
	public static String[] mst_status = { "Status" };
	public static String[] mst_maintenance= {"Watchman Charge","Cleaner Charge","Lift Maintenance","Watertank Cleaner","Price Pr Unit","Extra Expence","Member Id","Water Unit"};

	public static String[] registration_page = { "Role", "Name", "Contact No", "Gender", "Email", "ID Proof",
			"ID Number", "Password" };
	public static String[] login = { "Role Type", "Email", "Password" };
	
	public static String[] member ={"Role","House No.","Name","Email","Phone No","Gender","ID Proof","ID Number","ID Upload"};
	//public static String[] forgot_password = { "Email" };

	/**
	 * @author Karan Modi on 9/11/2019 web title for all jsp pages
	 */
	public static String webConstant = "E-Society";

	/**
	 * @author Karan Modi on 09/11/2019 page title of jsp page
	 */
	public static String mst_state_title = "State Master";
	public static String mst_status_title = "Stuatus Master";
	public static String mst_mst_city_title = "City Master";
	public static String mst_mst_mst_area_title = "Area Master";
	public static String mst_service_title = "Service Master";
	public static String mst_problem_type_title = "Problem Type";
	public static String mst_complain_title = "Complain Master";
	public static String mst_event_title = "Event Master";
	public static String mst_expense_title = "Expense Master";
	public static String mst_id_title = "ID Master";
	public static String mst_role_title = "Role Master";
	public static String register_society_title = "Society Registration";
	public static String mst_tax_title = "Tax Master";
	public static String mst_maintenance_title="Maintenance Master";
	public static String registration_page_title = "Sign Up";
	public static String login_page_title = "Sign In";
	public static String forgot_pass_title = "Retrieve Password";
	public static String mst_amenities_title = "Amenities Master";
	public static String generate_maintenance_title="Genetrate Maintenance";
	public static String mst_bill_title = "Bill Master";
	public static String profile_title="Your Profile";
	public static String change_password_title="Verify";
	public static String change_password1_title="Change Password";

	/**
	 * @author Karan Modi on 11/11/2019 formname of jsp page button
	 */
	public static String mst_state_name = "mst_state";
	public static String mst_city_name = "mst_mst_city";
	public static String mst_area_name = "mst_mst_mst_area";
	public static String mst_service_name = "mst_service";
	public static String mst_problem_type__name = "mst_problem_type";
	public static String mst_complain_name = "mst_complain";
	public static String register_society_name = "register_society";
	public static String mst_role_name = "mst_role";
	public static String mst_amenities_name = "mst_amenities";
	public static String mst_tax_name = "mst_tax";
	public static String mst_bill_name = "mst_bill";
	public static String mst_event_name = "mst_event";
	public static String mst_expense_name = "mst_expense";
	public static String mst_notice_name="mst_notice";
	public static String mst_maintenance_name="mst_maintenance_name";
	public static String generate_maintenance_name="generate_maintenance";
	public static String mst_id_name = "mst_id";
	public static String mst_status_name = "mst_status";
	public static String registration_page_name = "registration_page";
	//public static String login_page_name = "login_page";
	public static String forgot_password_name = "forgot_password";
	public static String ServiceRequestPage = "ServiceRequestPage";
	public static String adminProfile_name="adminProfile";
	
	public static String society_report_name="SocietyReport";
	public static String worker_report_name="WorkerReport";
	public static String change_password_name="Change_Password";
	public static String change_password1_name="Change_Password";

	/**
	 * @author Karan Modi on 28-12-2019 for transfer userName to the database
	 */
	/* public static String enterBy="NaemOfUser"; */

	/**
	 * @author Dignesh Fultariya on 31/12/2019 userpage field name constants
	 */

	public static String[] tran_req_service = { "House No", "Society Name","Service Type","Your Problem Description", "Date", "Time From", "To" };
	public static String[] tran_req_amenities = { "Amenities Type", "House No", "Society Name","Date","Rent Per Day"};
	public static String[] tran_complain = { "Name","Email","Complaint To","Complaint Type", "Complaint Description","Document" };
	public static String[] tran_feedback = { "Name","Email", "Feedback Topic", "Message" };
	public static String[] tran_maintainance = { "User ID", "Maintainance Amount"};
	public static String[] register_worker = {"Role","State", "City", "Area","Address","Pincode", "Service Type",
			"Service Description","Name","Email","Phone No","Gender","Available From", "Available To","ID Proof","ID Number","ID Upload"};
	public static String[] register_member ={"Role","State", "City", "Area","SocietyName","Wing","House Type","House Number",
			"Name","Email","Phone No","Gender","ID Proof","ID Number","ID Upload"};
	/**
	 * @author Dignesh Fultariya on 31/12/2019
	 * @description page title of jsp page
	 */
	public static String tran_req_service_title = "Request Home Related Service";
	public static String tran_req_amenities_title = "Request Amenities";
	public static String tran_complain_title = "Complain";
	public static String tran_feedback_title = "Feedback";
	public static String tran_maintainance_title = "Pay Maintainance";
	public static String register_worker_title = "Request For Service";
	public static String register_member_title="Request For Member";
	/**
	 * @author Dignesh Fultariya on 31/12/2019
	 * @description this is used in button for formname in jsp page
	 */
	public static String tran_req_service_name = "tran_req_service";
	public static String tran_req_amenities_name = "tran_req_amenities";
	public static String tran_complain_name = "tran_complain";
	public static String tran_feedback_name = "tran_feedback";
	public static String tran_maintainance_name = "tran_maintainance";
	public static String register_worker_name = "register_worker";
	public static String register_member_name="register_member";
	/**
	 * for Service Request and pass it to the worker for assign
	 */
	public static String[] ServiceRequest = { "status", "Worker's name", "Service", "User id", "Society Name", "Wing Name",
			"House No", "Problem Discription", "Date", "Time from", "to Tima"};
	
	/**
	 * declare the method for email
	 */
	public static String login_page_name="login_page";
	public static String otp_name="otp";
	public static String updatepassword_name="updatepassword";
	public static String otp_title="Otp";
	public static String updatepassword_title="Change Password";
	public static String[] forgot_password= {"Email"};
	public static String[] otp= {"Enter OTP"};
	public static String[] updatepassword= {"Enter New Password","Re-enter New Password"};
	
	/**
	 * @author Karan Modi on 16-01-2020 
	 * @description SECRATORY adding the value 
	 */
	/**
	 * Secretary field constant formname in jsp page 
	 */
	public static String mst_visitor_name ="mst_visitor_name";
	/**
	 * Secretary field page of title
	 */
	public static String mst_visitor_title="Visitor Master";
	/**
	 * Secretary form field constant  
	 */
	public static String[] mst_visitor= {"Visitor Name"};
	/**
	 * For Profile Update 
	 */
	public static String[] adminProfile= {"Name","Email","Phone Number","Gender"};
	
	public static String[] notice= {"Notice"};
	
	public static String notice_title= "Add Notice";
	
	public static String notice_name="Notice";
	
	public static String[] changePassword= {"Old Password"};
	
	public static String[] changePassword1= {"New Password","Confirm Password"};
	
	public static String worker_details_title="Services Providers";
	
	public static String security_guard_name="mst_Security_guard_name";
	public static String mst_Security_guard_title="Add Security Guard";
	public static String[] mst_security_guard= {"Name","Phone No","Email","Gender","ID Proof","ID Number","Password"};
	public static String security_guard_table[]= {"Option","Name","Phone No","Vehical No","House No","In Time","Purpose"};
	
	/**
	 * For worker Profile
	 */
	public static String workerProfile[] = {"Name", "Email", "Phone_No", "Gender", "Available_From", "Availabel_To"};
}
