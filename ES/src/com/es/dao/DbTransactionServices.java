package com.es.dao;

import java.io.InputStream;
import java.util.ArrayList;

import com.es.model.blog;
import com.es.model.mst_society;
import com.es.model.registration_page;
import com.es.model.tran_user;

public interface DbTransactionServices {

	public int getSocCount();
	public int getSocCount(String city);
	public int getAreaCount(String city);
	public int getWorkerRequestCount();
	public int getRequestCount();
	public int getComplainCount();
	public int getUserCount();
	public int requestCount();
	public int getStateCount();
	public int getWorkerCount();
	public int getMemberCount(String email);
	public int getRequestMemberCount(String email);
	public int getRegisteredSocietyCount();
	public int getRegisteredWorkerCount();
	public int getRequestedSocietyCount();
	public int getRequestedWorkerCount();
	
	//public ArrayList<String> getSoc_Name();
	public ArrayList<String> getService();
	public ArrayList<String> getComplain();
	public ArrayList<String> getAmenities();
	public ArrayList<String> getStatus();
	public ArrayList<String> getServiceWorker(String service);
	public ArrayList<String> getSocName();
	public ArrayList<String> getSocWing();
	public String getSocWingbysoc(String soc);
	public ArrayList<String> getCityforSelect(String state);
	public ArrayList<String> getAreaforSelect(String city);
	public ArrayList<String> getSocforSelect(String area);
	public int insertTranWorker(String workerName);
	public ArrayList<String> getAmenitiesBySocid(String socid);
	/**
	 * @author Karan Modi on 02-01-2020
	 * @param userCount
	 * @return
	 */
	public int pagination(int totalRecords);
	public int pagination2(int totalRecords);
	/**
	 * getting visitor name form mst_visitor_name for secutiry Guard
	 */
	public ArrayList<String> getVisitorName();
	
	/**
	 * All Query For updates 
	 */
	public int updateRegistrationData(String formname,registration_page registration);
	
	/**
	 * Getting the Society member data for report
	 */
	public ArrayList<tran_user> getSocMemberReport(String email);
	public String getMemberSocID(String email);
	public ArrayList<blog> getAllPosts(String socid);
	/*for save the file in blog*/
	public boolean saveFile(InputStream is, String path);
	
	public ArrayList<String> getSelectedDates(String type,String socid);
	public String getRentAmount(String type,String socid);
	public int updateMst_SocietyData(String formname, mst_society soc);
	
	/**
	 * Get the message data for chat application
	 */
	public ArrayList<String> getMsg(String email);
	public ArrayList<String> getSendMsg(String email);
}