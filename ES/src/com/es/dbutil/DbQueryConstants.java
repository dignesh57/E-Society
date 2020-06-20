package com.es.dbutil;

import com.es.dao.DbTransactionImpl;

public class DbQueryConstants {

	public static final String mst_state = "insert into mst_state(state_id,state_name,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on()
			+ "','Y')";
	public static final String mst_mst_city = "insert into mst_mst_city"
			+ "(state_name,city_name,entered_by,entered_on,last_updated_by,"
			+ "last_updated_on,is_active_Y_N)" + "values (?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String mst_mst_mst_area = "insert into mst_mst_mst_area(state_name,city_name,area_name,pincode,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on()
			+ "','Y')";
	public static final String mst_role = "insert into mst_role(role_name,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values(?,?,'" + DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String mst_amenities = "insert into mst_amenities(soc_id,amenities_name,rent,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values(?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String mst_bill = "insert into mst_bill(soc_id,bill_type,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values('',?,'','" + DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on()
			+ "','Y')";
	public static final String mst_complain = "insert into mst_complain(soc_id,comp_type,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values('',?,?,'" + DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.updated_on() + "','Y')";
	public static final String mst_event = "insert into mst_event(soc_id,event_name,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values('',?,'','" + DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on()
			+ "','Y')";
	public static final String mst_expense = "insert into mst_expense(soc_id,exp_type,price,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values(?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on()
			+ "','Y')";
	public static final String mst_id_type = "insert into mst_id_type(id_type,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values(?,?,'" + DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on()
			+ "','Y')";
	public static final String mst_tax = "insert into mst_tax(tax_name,tax_percent,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values(?,?,'','" + DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String registration_page = "insert into registration_page(role_name,username,email_id,contact_no,gender,password,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values(?,?,?,?,?,?,'','" + DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on()
			+ "','Y')";

	public static final String register_society = "insert into register_society(role_type,state,city,area,address,landmark,pincode,society_name,society_type,name_of_wings,total_number_of_house,name,email,phone_no,gender,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String register_member = "insert into register_member(role,state,city,area,soc_name,wing,house_type,house_num,member_id,name,email,phone_no,gender,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";

	public static final String mst_wing = "insert into mst_wings(no_of_wings,name_of_wings,type_of_house,house_number,entered_by,entered_on,lastupdate_by,lastupdate_on,is_active_Y_N)"
			+ "values (?,?,?,?,'','" + DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on()
			+ "','Y')";
	public static final String mst_service = "insert into mst_service(service_type,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values(?,?,'" + DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String mst_problem = "insert into mst_pro_type(service_type,problem_type,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values(?,?,'','" + DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String mst_status = "insert into mst_status(status_name,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N) values(?,'','"
			+ DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on() + "','Y')";
	/**
	 * @author Dignesh Fultariya on 08/11/19
	 * @description static insert query for all user webpages
	 */
	public static final String tran_req_services = "insert into tran_req_service(user_id,user_email,society_name,service_name,prob_desc,reqservice_date,reqservice_time_from,reqservice_time_to,status,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,'pending',?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String tran_req_amenities = "insert into tran_req_amenities(soc_id,soc_name,soc_email,soc_address,soc_address2,soc_address3,soc_pincode,member_id,member_name,member_email,amenities_type,reqamenities_date,amount,status,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String tran_complain = "insert into tran_complain(name,user_id,complain_to,complain_type,complain_description,document,soc_id,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String tran_feedback = "insert into tran_feedback(name,user_id,feedback_topic,feedback_description,status,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,'pending','','" + DbTransactionImpl.entered_on() + "','','"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String tran_worker_service = "insert into register_worker(role,state,city,area,address,pincode,service_type,service_desc,w_name,w_email,w_gender,w_phone,available_from,available_to,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String tran_req_worker = "insert into tran_req_worker(status,worker_name,service,user_id,society_name,wing_name,house_no,problem_dis,request_date,req_time_from,req_time_to,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,'','" + DbTransactionImpl.entered_on() + "','','"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String contact_us = "insert into contact_us(f_name,l_name,email,phone,message)"
			+ "values (?,?,?,?,?)";

	public static final String tran_worker = "insert into tran_worker(role,state,city,area,address,pincode,service_type,service_desc,w_name,w_email,w_gender,w_phone,available_from,available_to,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'','" + DbTransactionImpl.entered_on() + "','','"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String removeworker = "update register_worker set is_active_Y_N='N'";
	public static final String tran_user = "insert into tran_user(role,state,city,area,soc_name,wing,house_num,member_id,name,email,phone_no,gender,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'','" + DbTransactionImpl.entered_on() + "','','"
			+ DbTransactionImpl.entered_on() + "','Y')";

	// public static final String send_tran_req_worker="insert into tran_req_worker
	// (worker , flag ) select columnName from tableName)";
	/**
	 * @author Karan Modi on 13/11/2019 Query for insert Drop down values
	 */
	public static final String getState = "select state_name from mst_state";
	public static final String getStateId = "select state_id from mst_state";
	public static final String getCity = "select city_name from mst_mst_city";
	public static final String getCityId = "select city_id from mst_mst_city";
	public static final String getRole = "select * from mst_role";
	public static final String getId = "select id_type from mst_id_type";
	public static final String getArea = "select area_name from mst_mst_mst_area";

	/**
	 * @author karan modi 17-12-2019 Query for getting count form database
	 */
	public static final String getstateCount = "select count(*)stateCount from mst_state";
	public static final String getSocCount = "select count(*)socCount from mst_society";
	public static final String getSocCountCityWise = "select count(*)socCount from mst_society where city=?";
	public static final String getAreaCount = "select count(*)areaCount from mst_mst_mst_area where city_name=?";
	public static final String getWorkerRequestCount = "select count(*)workerCount from register_worker";
	public static final String getWorkerCount = "select count(*)workerCount from tran_worker";
	public static final String getComplainCount = "select count(*)complainCount from tran_complain";
	public static final String getUserCount = "select count(*)userCount from registration_page";
	public static final String getMembercount = "select count(*)memberCount from tran_user t WHERE t.state=(SELECT DISTINCT state FROM mst_society WHERE email=?)"
			+ " AND t.city=(SELECT DISTINCT city FROM mst_society WHERE email=?) AND"
			+ "  t.area=(SELECT DISTINCT AREA FROM mst_society WHERE email=?) AND t.soc_name=(SELECT DISTINCT society_name FROM mst_society WHERE email=?)";
	public static final String getRequestMemberCount = "select count(*)memberCount from register_member t WHERE t.state=(SELECT DISTINCT state FROM mst_society WHERE email=?)"
			+ " AND t.city=(SELECT DISTINCT city FROM mst_society WHERE email=?) AND"
			+ "  t.area=(SELECT DISTINCT AREA FROM mst_society WHERE email=?) AND t.soc_name=(SELECT DISTINCT society_name FROM mst_society WHERE email=?)";
	/**
	 * getting count and values from user's page
	 */
	public static final String getRequestCount = "select count(*)requestCount from mst_society";
	public static final String getServiceslist = "select * from mst_service";
	public static final String getAmenitieslist = "select amenities_name from mst_amenities";
	public static final String getAmenitieslistbyid = "select amenities_name from mst_amenities where soc_id=?";
	public static final String getComplaintlist = "select comp_type from mst_complain";
	public static final String getStatus = "select * from mst_status";
	/**
	 * @author Karan Modi
	 * @return query for checking the login on jsp
	 */
	public static final String checklogin = "select * from registration_page where role_name=? and email_id=? and password=?";

	/**
	 * @author Karan Modi on 23-12-2019 getting the values from database for table
	 */

	// public static final String getStateIDFromCity="select state_id from
	// mst_mst_city";
	// public static final String getStateNameFromCity="select state_name from
	// mst_mst_city";
	public static final String getCityData = "select state_name,city_name from mst_mst_city where is_active_Y_N='Y'";
	public static final String getCityName = "select city_name from mst_mst_city";

	/*
	 * public static final String
	 * getStateIDFromArea="select state_id from mst_mst_mst_area"; public static
	 * final String getStateNameFromArea="select state_name from mst_mst_mst_area";
	 * public static final String
	 * getCityIDFromArea="select city_id from mst_mst_mst_area"; public static final
	 * String getCityNameFromArea="select city_name from mst_mst_mst_area"; public
	 * static final String getAreaID="select area_id from mst_mst_mst_area"; public
	 * static final String getAreaName="select area_name from mst_mst_mst_area";
	 */

	public static final String getAreaData = "select * from mst_mst_mst_area where is_active_Y_N='Y'";
	public static final String getStateData = "select * from mst_state where is_active_Y_N='Y'";

	public static final String getAllSociety = "select * from mst_society";

	public static final String getRoleDetails = "select role_id,role_name from mst_role where is_active_Y_N='Y'";

	public static final String getIDDetails = "select id_id,id_type from mst_id_type where is_active_Y_N='Y'";

	public static final String getService = "select service_id,service_type from mst_service";
	public static final String getServiceData = "select service_id,service_type from mst_service  where is_active_Y_N='Y'";
	public static final String getTax = "select tax_id,tax_name,tax_percent from mst_tax";
	public static final String getExpense="select * from mst_expense where is_active_Y_N='Y' and soc_id=? order by exp_id desc";
	public static final String getSecurity="select * from mst_security where is_active_Y_N='Y' and soc_id=? order by secu_id desc";
	public static final String getExpenseID = "select exp_id from mst_expense";
	public static final String getExpenseType = "select exp_type from mst_expense";

	public static final String getBill = "select bill_id,bill_type from mst_bill";

	public static final String getComplaint = "select comp_id,comp_type from mst_complain";

	public static final String getAmenities = "select amenities_id,amenities_name,rent from mst_amenities where is_active_Y_N='Y' and soc_id=?";
	
	public static final String getUserData = "select user_id,role_name,username,gender,contact_no,email_id,id_type,id_number,password from registration_page";

	public static final String getnotices = "select * from notice where is_active_Y_N='Y' and soc_id=? order by notice_id desc";
	/**
	 * getting value for the visitor entry
	 */
	public static final String getVisitor = "select * from mst_visitor_name";
	/**
	 * @author Karan Modi on 09-01-2020
	 * @description query for update the values in db
	 */
	public static final String getupdateState = "select * from mst_state where state_id=?";
	public static final String updateState = "update mst_state set state_id=?,state_name=? WHERE state_id=?";
	public static final String getstate = "select * from mst_state";
	/**
	 * getting the value of society Name from registered Society
	 */
	public static final String getsocName = "select society_name from mst_society";
	public static final String getsocWing = "select name_of_wings from mst_society";
	public static final String getsocWingbysoc = "select name_of_wings from mst_society where society_name=?";
	/**
	 * Query for getting name and services of worker as per user request
	 */
	public static final String getRelateWorker = "select u_name from tran_worker_service where service_type=?";
	public static final String getRequest = "select * from tran_req_service";
	public static final String query = "select service_type,u_name from tran_worker_service r where r.area_name=(select distinct(area_name) from mst_society s where s.soc_name=?)";
	/**
	 * query for email
	 */
	public static final String checkemail = "select * from registration_page where email_id=?";
	public static final String update_password = "UPDATE registration_page set password=? where email_id=?";

	/**
	 * Query for update the profile
	 */
	public static final String update_admin_profile = "update registration_page set username=?,contact_no=?,gender=? where email_id=?";
	/**
	 * Query for inserting visitor name by Secretary
	 */
	public static final String insertVisitor = "insert into mst_visitor_name (visitor_name,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N) values(?,'','"
			+ DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on() + "','Y')";
	
	public static String register_society_name = "register_society";

	public static final String getRequestedSociety = "select * from registration_page where email_id= ? ";
	public static final String mst_society = "insert into mst_society(role_type,state,city,area,address,landmark,pincode,society_name,society_type,name_of_wings,total_number_of_house,name,email,phone_no,gender,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'','" + DbTransactionImpl.entered_on() + "','','"
			+ DbTransactionImpl.entered_on() + "','Y')";
	/**
	 * getting the value of society member's details
	 */
	public static final String getSocMemberReport = "SELECT * FROM tran_user t WHERE t.state=(SELECT DISTINCT state FROM mst_society WHERE email=?)"
			+ " AND t.city=(SELECT DISTINCT city FROM mst_society WHERE email=?) AND"
			+ "  t.area=(SELECT DISTINCT AREA FROM mst_society WHERE email=?) AND t.soc_name=(SELECT DISTINCT society_name FROM mst_society WHERE email=?) AND t.is_active_Y_N='Y'";

	/**
	 * query for the maintenance report
	 */
	public static final String insertMaintenance = "insert into mst_maintenance(soc_id,soc_name,email,cleaner_charge,watchman_charge,lift_main,watertank_cleaner,price_pr_unit,extra_expence,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N) values(?,?,?,?,?,?,?,?,?,'','"
			+ DbTransactionImpl.entered_on() + "','','" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String updateMaintainanc="update mst_maintenance set cleaner_charge=?,watchman_charge=?,lift_main=?,watertank_cleaner=?,price_pr_unit=?,extra_expence=?,last_updated_by=?,last_updated_on=? where soc_id=?";
	/**
	 * get registered society from mst_society
	 */
	public static final String getRegisteredSociety = "select * from register_society";
	public static final String getFinalSociety = "select * from mst_society where is_active_Y_N='Y'";
	public static final String getRegisteredWorker = "select * from tran_worker where is_active_Y_N='Y'";
	public static final String getAdminComplaint = "select * from tran_complain where complain_to='Admin'";
	public static final String getSecComplaint = "select * from tran_complain where complain_to='Secretary' and soc_id=?";
	public static final String getPendingMaintainance = "select * from tran_maintainance where soc_id=?";
	public static final String getGenMaintainance = "select * from tran_maintainance where soc_id=? and generated_date>=?";
	public static final String getRegisteredSocietyCount = "select count(*)socCount from mst_society";
	public static final String getRegisteredWorkerCount = "select count(*)workerCount from tran_worker";
	public static final String getRequestedSocietyCount = "select count(*)socCount from register_society";
	public static final String getRequestedWorkerCount = "select count(*)workerCount from register_worker";
	
	public static final String getAdminComplaintCount = "select count(*)complainCount from tran_complain";

	public static final String getRequestedMember = "SELECT * FROM register_member r WHERE r.state=(SELECT DISTINCT state FROM mst_society WHERE email=?)"
			+ " AND r.city=(SELECT DISTINCT city FROM mst_society WHERE email=?) AND "
			+ " r.area=(SELECT DISTINCT AREA FROM mst_society WHERE email=?) AND"
			+ " r.soc_name=(SELECT DISTINCT society_name FROM mst_society WHERE email=?)";
	/**
	 * All the method for the maintenance
	 */
	public static final String getMainDetails = "select * from mst_maintenance where email=?";
	public static final String getmemberid = "SELECT member_id FROM tran_user u WHERE u.state=(SELECT DISTINCT state FROM mst_society WHERE email=?)"
			+ "AND u.city=(SELECT DISTINCT city FROM mst_society WHERE email=?) AND "
			+ "u.area=(SELECT DISTINCT AREA FROM mst_society WHERE email=?) AND "
			+ "u.soc_name=(SELECT DISTINCT society_name FROM mst_society WHERE email=?) AND "
			+ "u.member_id NOT IN (SELECT member_id FROM tran_maintainance WHERE generated_date>=?)";
	public static final String getmemberidinvis = "SELECT member_id FROM tran_user u WHERE u.state=(SELECT DISTINCT state FROM mst_society WHERE email=?)"
			+ "AND u.city=(SELECT DISTINCT city FROM mst_society WHERE email=?) AND "
			+ "u.area=(SELECT DISTINCT AREA FROM mst_society WHERE email=?) AND "
			+ "u.soc_name=(SELECT DISTINCT society_name FROM mst_society WHERE email=?)";
	public static final String getprice_pr_unit = "select price_pr_unit from mst_maintenance where email=?";
	public static final String getNamefromemail = "select username from registration_page where email_id=?";
	/**
	 * 
	 */
	public static final String getAcceptedSociety = "select * from register_society where email=?";
	public static final String getSocietyofMember = "select * from mst_society where email=?";
	public static final String getRequestedWorker = "select * from register_worker where is_active_Y_N='Y'";
	public static final String getContactus="select * from contact_us";
	/**
	 * New query for pass the value by accept
	 */
	public static final String deleteWorkerRequest = "delete from register_worker where w_email=?";

	public static final String addWorkerOnAccept = "insert into tran_worker(role,state,city,area,address,pincode,service_type,service_desc,w_name,w_email,w_gender,w_phone,available_from,available_to,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'','" + DbTransactionImpl.entered_on() + "','','"
			+ DbTransactionImpl.entered_on() + "','Y')";

	public static final String getAcceptedWorkerData = "select * from register_worker where w_email=?";
	
	public static final String getMemberInfo="select * from tran_user where member_id=? and soc_name=? and area=? and city=? and state=?";
	/*
	 * public static final String registration_page =
	 * "insert into registration_page(role_name,username,email_id,contact_no,gender,password,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
	 * + "values(?,?,?,?,?,?,'','" + DbTransactionImpl.entered_on() + "','','" +
	 * DbTransactionImpl.entered_on() + "','Y')";
	 */

	public static final String addAcceptedSoc = "INSERT INTO mst_society(role_type,state,city,area,address,landmark,pincode,society_name,society_type,name_of_wings,total_number_of_house,name,email,phone_no,gender,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)\r\n"
			+ "SELECT role_type,state,city,area,address,landmark,pincode,society_name,society_type,name_of_wings,total_number_of_house,name,email,phone_no,gender,id_proof,id_number,id_upload,?,'"
			+ DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on()
			+ "','Y' FROM register_society WHERE email=?;";
	public static final String insertSecretaryOnReg = "INSERT INTO registration_page(role_name,username,email_id,contact_no,gender,PASSWORD,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "SELECT role_type,name,email,phone_no,gender,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y' FROM mst_society WHERE email=?;";

	public static final String addAcceptedMember = "INSERT INTO tran_user(role,state,city,AREA,soc_name,wing,house_type,house_num,member_id,NAME,email,phone_no,gender,id_proof,id_number,id_upload,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)\r\n"
			+ "			SELECT role,state,city,AREA,soc_name,wing,house_type,house_num,member_id,NAME,email,phone_no,gender,id_proof,id_number,id_upload,?,'"
			+ DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on()
			+ "','Y' FROM register_member WHERE email=?";

	public static final String insertMemberOnReg = "INSERT INTO registration_page(role_name,username,email_id,contact_no,gender,PASSWORD,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "SELECT role,name,email,phone_no,gender,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y' FROM tran_user WHERE email=?";

	public static final String deleteSocietyRequest = "delete from register_society where email=?";
	public static final String deleteMemberRequest = "delete from register_member where email=?";
	
	public static final String getsocietyid="select soc_id from mst_society where email=?";
	public static final String getsocidofuser="SELECT soc_id FROM mst_society r WHERE r.state=(SELECT distinct state FROM tran_user WHERE email=?)"
			+ "AND r.city=(SELECT distinct city FROM tran_user WHERE email=?) "
			+ "AND r.area=(SELECT distinct AREA FROM tran_user WHERE email=?) "
			+ "AND r.society_name=(SELECT distinct soc_name FROM tran_user WHERE email=?)";
	public static final String getsocemailofuser="SELECT email FROM mst_society r WHERE r.state=(SELECT distinct state FROM tran_user WHERE email=?)"
			+ "AND r.city=(SELECT distinct city FROM tran_user WHERE email=?) "
			+ "AND r.area=(SELECT distinct AREA FROM tran_user WHERE email=?) "
			+ "AND r.society_name=(SELECT distinct soc_name FROM tran_user WHERE email=?)";
	public static final String insertnotice="insert into notice(soc_id,secretary_id,notice,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N) "
			+ "values(?,?,?,?,'"+DbTransactionImpl.entered_on()+"',?,'"+DbTransactionImpl.entered_on()+"','Y') ";
	
	public static final String deletestate="update mst_state set is_active_Y_N='N' where state_id=?";
	public static final String deletesoc="update mst_society set is_active_Y_N='N' where email=?";
	public static final String deleteworker="update tran_worker set is_active_Y_N='N' where w_email=?";
	public static final String deleteuser="update tran_user set is_active_Y_N='N' where email=?";
	public static final String deletereg="delete from registration_page where email_id=?";
	public static final String deletecity="update mst_mst_city set is_active_Y_N='N' where city_name=?";
	public static final String deleteArea="update mst_mst_mst_area set is_active_Y_N='N' where area_name=?";
	public static final String deleteRole="update mst_role set is_active_Y_N='N' where role_id=?";
	public static final String deleteService="update mst_service set is_active_Y_N='N' where service_id=?";
	public static final String deleteidtype="update mst_id_type set is_active_Y_N='N' where id_id=?";
	public static final String deleteExpense="update mst_expense set is_active_Y_N='N' where soc_id=? and exp_type=?";
	public static final String changePass = "UPDATE registration_page SET password=? WHERE email_id=?";
	public static final String getMemberIdUser = "select member_id from tran_user where email=?";
	public static final String getsocNameUser = "select soc_name from tran_user where email=?";

	public static final String getWorkerDetails = "SELECT * FROM tran_worker r WHERE r.state=(SELECT distinct state FROM tran_user WHERE email=?)"
			+ "AND r.city=(SELECT distinct city FROM tran_user WHERE email=?) "
			+ "AND r.area=(SELECT distinct AREA FROM tran_user WHERE email=?) "
			+ "AND r.service_type=(SELECT distinct service_name FROM tran_req_service WHERE user_email=?)";
	
	public static final String getServiceToWorker="select * from request_service where w_email=? and is_active_Y_N='Y'";
	public static final String getUserDetails="SELECT * FROM tran_user WHERE email=?";
	public static final String getWorDetails="select * from tran_worker where w_email=?";
	public static final String getreqDetails="select * from tran_req_service where user_email=?";
	public static final String getMemAddress="SELECT * FROM mst_society u WHERE u.state=(SELECT DISTINCT state FROM tran_user WHERE email=?)" + 
			"AND u.city=(SELECT DISTINCT city FROM tran_user WHERE email=?) AND " + 
			"u.area=(SELECT DISTINCT AREA FROM tran_user WHERE email=?) AND " + 
			"u.society_name=(SELECT DISTINCT soc_name FROM tran_user WHERE email=?)";
	
	public static final String insertBlog="insert into blog(soc_id,username,userid,message,image,entered_by,entered_on,last_update_by,last_update_on,is_active_Y_N)"
			+"values(?,?,?,?,?,'parth','"+ DbTransactionImpl.entered_on() + "','parth','" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String insertWorkerreq="insert into request_service(user_name,user_email,user_phone,address,prob_desc,reqservice_date,reqservice_time_from,reqservice_time_to,service_type,status,w_email,w_name,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+"values(?,?,?,?,?,?,?,?,?,'panding',?,?,?,'"+ DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String getMemberSocID = "SELECT soc_id FROM mst_society m WHERE m.state=(SELECT DISTINCT state FROM tran_user WHERE email=?)"
			+ " AND m.city=(SELECT DISTINCT city FROM tran_user WHERE email=?) AND "
			+ " m.area=(SELECT DISTINCT AREA FROM tran_user WHERE email=?) AND"
			+ " m.society_name=(SELECT DISTINCT soc_name FROM tran_user WHERE email=?)";

	public static final String getAllPosts = "select * from blog where soc_id=? order by post_id desc";
	public static final String getAllDates = "select * from tran_req_amenities where amenities_type=? and soc_id=?";
	
	public static final String insertUserMaintainance = "insert into tran_maintainance(soc_id,soc_name,soc_email,soc_address,soc_address2,soc_address3,soc_pincode,member_id,member_name,member_email,cleaner_charge,watchman_charge,lift_maintainance_charge,watertank_cleaner_charge,price_per_unit,unit,water_usage_charge,extra_expense,total_amount,status,generated_date,due_date,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";
	
	public static final String getMaintainanceDetails="select * from tran_maintainance where member_email=? and invoice_id=?";
	public static final String getAllMaintainanceDetails="select * from tran_maintainance where member_email=? order by invoice_id desc";
	public static final String insertSecurityGuard = "insert into mst_security(soc_id,name,phone_no,email,gender,id_proof,id_number,password,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N) values(?,?,?,?,?,?,?,?,?,'"
			+ DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.entered_on() + "','Y')";
	public static final String deleteAmenities="update mst_amenities set is_active_Y_N='N' where amenities_id=?";
	public static final String deleteNotice="update notice set is_active_Y_N='N' where notice_id=?";
	public static final String getSecretaryEmail = "SELECT email FROM `mst_society` WHERE soc_id=(SELECT soc_id FROM `mst_security` WHERE email=?)";
	public static final String getMemberName = "SELECT NAME FROM tran_user WHERE member_id=? ";
	public static final String getOUTDetails="select * from visitor_entry where soc_id=? and out_time='0' and is_active_Y_N='Y'";
	public static final String getvisitormember="select * from visitor_entry where soc_id=? and out_time!='0' and is_active_Y_N='Y'";
	public static final String getSocidfromSecurityGuard = "select soc_id from mst_security where email=?";
	public static final String deleteSecurity="update mst_security set is_active_Y_N='N' where email=?";
	public static final String deleteSecurityRg="delete from registration_page where email_id=?";
	public static final String getAmount="select * from mst_amenities where soc_id=? and amenities_name=?;";
	public static final String updateOutTime = "update visitor_entry set out_time='" + DbTransactionImpl.entered_on() + "' where in_time=? and vehical_no=? and name=? and soc_id=? and is_active_Y_N='Y'";
	public static final String insertVisitorDetails = "insert into visitor_entry(soc_id,options,name,phone_no,vehical_no,house_no,member_name,in_time,out_time,purpose,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N) values(?,?,?,?,?,?,?,'"
			+ DbTransactionImpl.entered_on() + "','0',?,?,'" + DbTransactionImpl.entered_on() + "',?,'"
			+ DbTransactionImpl.entered_on() + "','Y')";
	public static final String update_mst_society="update mst_society set name=?,phone_no=?,gender=? where email=?";
	
	public static final String getMemberSCA = "select distinct * from tran_user where email=?";
	public static final String getSocid = "select soc_id from mst_society where state=? and city=? and area=? and society_name=?";
	public static final String insertChatMsg = "insert into chat_application(soc_id,name,email,msg,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N) values (?,?,?,?,?,'"
			+ DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.updated_on() + "','Y')";
	public static final String getMsgForChat = "select name,msg from chat_application where soc_id=? and email != ? ";
	public static final String getSendMsgForChat = "select name,msg from chat_application where soc_id=? and email=?";
	
	public static final String getComplatedWork="select * from request_service where w_email=? and status='Done'";
	public static final String getLeftWork="select * from request_service where w_email=? and status='panding'";
	public static final String getDeclineWork="select * from request_service where w_email=? and status='Decline'";
	public static final String updateDecline = "update request_service set status=?,is_active_Y_N='N' where is_active_Y_N='Y' and status='panding' and user_email=? and reqservice_Date=? and reqservice_time_from=?";
	
	/**
	 * inserting for scheduling the worker services
	 */
	public static final String scheduleService = "insert into tran_service_schedule(service_name,reqservice_id,worker_id,worker_email,schedule_date,schedule_time,entered_by,entered_on,last_updated_by,last_updated_on,is_active_Y_N) values(?,?,?,?,?,?,?,'"
			+ DbTransactionImpl.entered_on() + "',?,'" + DbTransactionImpl.updated_on() + "','Y')";
	public static final String getreqSerID = "select reqservice_id from request_service where user_email=? and reqservice_date=? and reqservice_time_from=?";
	public static final String getworid = "select * from tran_worker where w_email=?";
	public static final String updateRequestService = "update request_service set is_active_Y_N='N' where user_email=? and reqservice_Date=? and reqservice_time_from=?";
	public static final String updateScheduleOnWay = "update request_service set status='On The Way' where user_email=? and reqservice_Date=? and reqservice_time_from=?";
	//public static final String updateScheduleReach = "update request_service set status='Reached' where user_email=? and reqservice_Date=? and reqservice_time_from=?";
	//public static final String updateScheduleCheckOut = "update request_service set status='Done' where user_email=? and reqservice_Date=? and reqservice_time_from=?";
	public static final String updateScheduleCancle = "update request_service set status='Done' where user_email=? and reqservice_Date=? and reqservice_time_from=?";
	public static final String removeOnCancle = "update request_service set is_active_Y_N='N' where user_email=? and reqservice_Date=? and reqservice_time_from=?";
	public static final String getServiceSchedule = "SELECT rs.user_name ,rs.reqservice_date, rs.user_email, rs.user_phone , rs.address, rs.prob_desc , sch.schedule_time FROM  request_service rs , tran_service_schedule sch ,tran_worker worker where sch.reqservice_id=rs.reqservice_id AND worker.worker_id = sch.worker_id and sch.schedule_date='"
			+ DbTransactionImpl.current_date() + "' and sch.worker_email=? and rs.status !='Done' and rs.status!='Decline'";
	
	/**
	 * Query for update the profile
	 */
	public static final String updateWorkerProfile = "update tran_worker set w_name=?, w_phone=?, w_gender=?,available_from=?, available_to=? where w_email=?";
	public static final String updateUserProfile = "update tran_user set name=?, phone_no=?, gender=? where email=?";
	public static final String getServiceStatus = "select * from request_service where user_email=? and is_active_Y_N='Y'";
	
	//multiselect query
	public static final String getCities = "select distinct city_name from mst_mst_city where state_name=?";
	public static final String getAreas = "select distinct area_name from mst_mst_mst_area where city_name=?";
	public static final String getSoc = "select distinct society_name from mst_society where area=?";
	public static final String payment_success = "update tran_maintainance set status='success' where generated_date=? and member_email=?";
	
}