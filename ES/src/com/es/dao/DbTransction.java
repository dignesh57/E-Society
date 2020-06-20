package com.es.dao;
import java.sql.Date;
import java.util.ArrayList;
import com.es.model.*;

public interface DbTransction {
	
	/**
	 * @author Karan Modi 
	 * @param formname
	 * @param state
	 * @return pass the value which get from controller for inserting into database
	 */

	public int insertState(String formname,mst_state state);
	public int insertCity(String formname,mst_mst_city city);
	public int insertSociety(String formname,register_society society);
	public int insertWings(String formname,mst_wings wings);
	public int insertService(String formname,mst_service service);
	public int insertProblemType(String formname,mst_problem_type problemtype);
	public int insertArea(String formname,mst_mst_mst_area area);
	public int insertRole(String formname,mst_role role);
	public int insertAmenities(String formname,mst_amenities amenities);
	public int insertBilltype(String formname,mst_bill bill);
	public int insertComplain(String formname,mst_complain complain);
	public int insertEvent(String formname,mst_event event);
	public int insertExpense(String formname,mst_expense expense);
	public int insertIDType(String formname,mst_id_type idtype);
	public int insertStatus(String formname,mst_status status);
	public int insertTax(String formname,mst_tax tax);
	
	/**
	* @author Dignesh Fultariya on 01/01/2020
	* @description insert methods on userside pages
	* @param formname : to pass webpages name
	* @param reqservice : reference of model
	* @return
	*/

	public int insertRequestServices(String formname,tran_req_services reqservices);
	public int insertRequestAmenities(String formname,tran_req_amenities reqamenities);
	public int insertUserComplain(String formname,tran_complain complain);
	public int insertUserFeedback(String formname,tran_feedback feedback);
	public int insertWorkerService(String formname, register_worker workerservicedesc);
	public int insertRegisterMember(String formname, register_member registerworker);
	public int insertRequestWorker(String formname,tran_ServiceRequest serviceReq);
	
	public int insertSecretary(String formname,registration_page registration);
	
	/**
	 * @param login
	 * @return return the object with validation.It can be null or login information 
	 */
	public  registration_page cklogin(registration_page login);
	
	/**
	 * @author Karan Modi
	 * @return method for retrive the data from database for shows on table
	 */
	
	public ArrayList<String> getState();
	public ArrayList<mst_state> getStateModel();
	
	//public ArrayList<String> getStateID();
	
	public ArrayList<String> getAllState();

	//public ArrayList<String> getStateIDFromCity();
	//public ArrayList<String> getStateFromCity();
	//public ArrayList<String> getCityID();
	public ArrayList<String> getCity();

	public ArrayList<mst_mst_city> getCityModel(); 
	
	/*
	 * public ArrayList<String> getStateIDFromArea(); public ArrayList<String>
	 * getStateFromArea(); public ArrayList<String> getCityIDFromArea(); public
	 * ArrayList<String> getCityFromArea(); public ArrayList<String> getAreaID();
	 */
	public ArrayList<mst_mst_mst_area> getAreaModel();
	
	public ArrayList<String> getArea();

	public ArrayList<mst_society> getAllSocietyDetails();

	public ArrayList<mst_role> getAllRole();
	
	public ArrayList<String> getRole();

	public ArrayList<mst_id_type> getAllID();
	
	public ArrayList<String> getID();

	public ArrayList<String> getAllTax();
	
	public ArrayList<mst_service> getAllService();
	public ArrayList<mst_service> getServiceModel();
	
	public ArrayList<mst_bill> getAllBillDetails();
	
	public ArrayList<mst_complain> getAllComp();
	
	public ArrayList<mst_amenities> getAmenitiesDetails(String socid);
	public ArrayList<mst_expense> getAllExpense(String socid);
	public ArrayList<notice> getNotices(String socid);
	public ArrayList<String> getExpenseID();
	public ArrayList<String> getExpenseName();

	
	public ArrayList<String> getRegistrationData(String email);
	
	/**
	 * @author Karan Modi on 09-01-2020
	 * @description methods for the update into database  
	 */
	
	public int updateState(String formname,mst_state state);
	public ArrayList<String> getUpdateState(String stateid);
	
	public ArrayList<tran_req_services> getRequestDetails();
	/**
	 * Method for email
	 */
	public int updatePassword(String formname, forgot_password fp);
	public forgot_password checkEmail(forgot_password forgot);
	
	/**
	 * Secratary enter visitors name fields And All Details of visitor by Security Guard
	 */
	public int insertvisitor(String formname,mst_visitor_name visitor);
	public int insertvisitordetails(String formname,visitor_details visite);
	
	public ArrayList<register_society> getRequestedSociety();
	public int insertRegisteredSociety(String formname, register_society society);
	public int insertUser(String formname, registration_page society);
	
	public int insertSociety(String formname, String email);
	public int insertRegisteredworker(String formname,register_worker worker);
	public int insertRegisteredMember(String formname,register_member member);
	public int insertContactFormData(String formname, contact_us c);
	
	/**
	 * insert for the maintenance report
	 */
	public int insertMaintenance(String formname,mst_maintenance main);
	public int updateMaintenance(String formname, mst_maintenance main);
	/**
	 * get registered society detais for report
	 * @return
	 */
	public ArrayList<mst_society> getRegisteredSocietyData();
	public ArrayList<tran_worker> getRegisteredWorkerData();
	public ArrayList<tran_complain> getAdminComplaintData();
	public ArrayList<tran_complain> getSecComplaintData(String socid);
	public ArrayList<tran_maintainance> getPendingMaintainance(String socid);
	public ArrayList<tran_maintainance> getGeneratedMaintainance(String socid);
	public int insertSociety(String formname, mst_society society);
	
	public register_society getSocietyDetailsForMember(String secretaryId);
	public ArrayList<register_worker> getRequestedWorker();
	public ArrayList<contact_us> getContactus();
	public int removeMember();
	
	public ArrayList<String> getMaintenanceDetails(String email); 
	public ArrayList<String> getmemberid(String email);
	public ArrayList<String> getmemberidvis(String email);
	
	public ArrayList<register_member> getRequestedMember(String email);
	
	/**
	 * New Methods for Accept
	 */
	public int insertSocietyOnAccept(String emailid,String pass,String formname,String admin);
	public int insertMemberOnAccept(String email,String pass,String formname,String adminname);
	public int DeleteRegisteredSocFromRegSoc(String emailid);
	public int DeleteRegisteredMemberFromRegMem(String email);
	public int DeleteRegisteredworker(String workerid);
	public int insertRegisteredworkeronAccept(String emailid,String pass,String formname);
	//public int insertSecretary(String formname,registration_page registration);
	public String getSocietyID(String email);
	public int insertNotice(String formname,notice ntc);
	
	public int deleteState(String formname,String stateid);
	public int deletecity(String formname, String cityname);
	public int deletearea(String formname, String areaname);
	public int deleterole(String formname, String roleid);
	public int deleteidtype(String formname, String idindex);
	public int deleteExpense(String formname, String exptype,String socid);
	
	public int ChangePassword(String email, registration_page login);
	public ArrayList<tran_worker> workerDetails(String email);
	public ArrayList<RequestServices> getServiceToWorker(String email);
	public int insertWorrequestService(String formname, RequestServices reqs);
	
	public int insertPost(String formname,blog post);
	
	public tran_user getMemberInfo(String memberid,String socname,String area,String city,String state);
	
	public int insertUserMaintainance(tran_maintainance m);
	
	public tran_maintainance getMaintainaceInfo(String meberid,int id);
	public ArrayList<tran_maintainance> getAllMaintainaceInfo(String meberid);
	public int updateState(mst_state s);
	public int updateCity(mst_mst_city c);
	public int updateArea(mst_mst_mst_area a);
	public int updateID(mst_id_type i);
	public int updateRole(mst_role r);
	public int updateService(mst_service s);
	public int deleteservice(String formname, String serviceid);
	public int insertSecurityGuard(String formname, mst_security_guard security, String name);
	public int updateAmenities(mst_amenities a);
	public int deleteAmenities(String id);
	public int updateExpense(mst_expense e);
	public int deleteNotice(String id);
	public String getSecretaryEmail(String email);
	public ArrayList<visitor_details> getValuesForOUT(String soc_id);
	public ArrayList<visitor_details> getVisitorMember(String soc_id);
	public int insertvisitordetails(String formname, visitor_details visite, String GuardName);
	public int updateouttime(String formname, visitor_details visit);
	public ArrayList<mst_security_guard> getAllSecurity(String socid);
	public int deleteSecurity(String email);
	public int deleteSecurityRg(String email);
	public String getSocietyIDofUser(String email);
	public String getSocietyEmailofUser(String email);
	public int deleteSoc(String email);
	public int deleteReg(String email);
	public int deleteWorker(String email);
	public int deleteuser(String email);
	
	/**
	 * getting the worker information for update profile
	 */
	public ArrayList<String> getWorkerDetails(String email);
	public ArrayList<String> getUserDetails(String email);
	/**
	 * inserting chats for ChatApplication
	 */
	public int insertChat(chatApplication chat);
	
	/**
	 * Getting the Secretary Email For getting the value of member's id
	 */
	
	public ArrayList<RequestServices> getCompletedWork(String email);
	public ArrayList<RequestServices> getLeftWork(String email);
	public ArrayList<RequestServices> getDeclineWork(String email);
	
	public int updateDecline(RequestServices reqs);
	/**
	 * scheduling the service for worker
	 */
	public int scheduleService(String email,RequestServices reqs);
	public ArrayList<RequestServices> getServiceForSchedule(String email);
	public int updateRequest(RequestServices reqs);
	public int updateScheduleOnWay(RequestServices reqs);
	//public int updateScheduleReach(RequestServices reqs);
	//public int updateScheduleCheckOut(RequestServices reqs);
	public int updateScheduleCancle(RequestServices reqs);
	public int removeonCancle(RequestServices reqs);
	
	/**
	 * All Query For updates 
	 */
	public int updateRegistrationData(String formname,registration_page registration);
	public int updateMst_SocietyData(String formname,mst_society soc);
	public int updateWorkerProfile(String formname,tran_worker wor);
	public int updateMemberProfile(tran_user mem);
	public int updatePayment(Date date,String email);
}