package com.es.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.es.dbutil.DbConnectionProvider;
import com.es.dbutil.DbConnectionProviderImpl;
import com.es.dbutil.DbQueryConstants;
import com.es.model.RequestServices;
import com.es.model.blog;
import com.es.model.chatApplication;
import com.es.model.contact_us;
import com.es.model.forgot_password;
import com.es.model.mst_amenities;
import com.es.model.mst_bill;
import com.es.model.mst_complain;
import com.es.model.mst_event;
import com.es.model.mst_expense;
import com.es.model.mst_id_type;
import com.es.model.mst_maintenance;
import com.es.model.mst_mst_city;
import com.es.model.mst_mst_mst_area;
import com.es.model.mst_problem_type;
import com.es.model.mst_role;
import com.es.model.mst_security_guard;
import com.es.model.mst_service;
import com.es.model.mst_society;
import com.es.model.register_society;
import com.es.model.mst_state;
import com.es.model.mst_status;
import com.es.model.mst_tax;
import com.es.model.mst_visitor_name;
import com.es.model.mst_wings;
import com.es.model.notice;
import com.es.model.register_member;
import com.es.model.registration_page;
import com.es.model.tran_ServiceRequest;
import com.es.model.tran_complain;
import com.es.model.tran_feedback;
import com.es.model.tran_maintainance;
import com.es.model.tran_req_amenities;
import com.es.model.tran_req_services;
import com.es.model.tran_user;
import com.es.model.tran_worker;
import com.es.model.register_worker;
import com.es.model.visitor_details;

public class DbTransactionImpl implements DbTransction {

	public static String entered_on() {
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String dateTime = current.format(formatter);
		return dateTime;
	}
	
	public static String current_date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String date1 = sdf.format(date);
		return date1;
	}
	
	public static String updated_on() {
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String dateTime = current.format(formatter);
		return dateTime;
	}

	DbConnectionProvider dao = new DbConnectionProviderImpl();
	int flag = 0;
	Connection con = dao.getConnetion();

	@Override
	public int insertState(String formname, mst_state state) {
		String q = DbQueryConstants.mst_state;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			// String mname="getCount"+i;
//			List<Method> getterMethod =new ArrayList<Method>();
//				Method[] method = state.getClass().getMethods();
//				for(int i=0;i<method.length;i++) {
//					if(method[i].getParameterCount()==0) {
//						getterMethod.add(method[i]);
//						System.out.println(getterMethod);
//					}
//
//				}
//				System.out.println(getterMethod);
//				//String getCount=state.getCount1();
			/*
			 * for(int i=0,j=1;i<FormFieldUltilityconstant.mst_state.length;i++,j++) {
			 * System.out.println(getterMethod.get(i));
			 * ps.setString(j,getterMethod.get(i).toString().trim()); }
			 */

			ps.setString(1, state.getState_id());
			ps.setString(2, state.getState_name());
			ps.setString(3, state.getEntered_by());
			ps.setString(4, state.getEntered_by());
			

			System.out.println(q);
			flag = ps.executeUpdate();
			if (flag == 1) {
				System.out.println("Success");
			} else {
				System.out.println("Failed");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertCity(String formname, mst_mst_city city) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_mst_city;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);
			/*
			 * ps.setString(1, city.getState_id()); ps.setString(1, city.getState_name());
			 */
			ps.setString(1, city.getState_name());
			// ps.setString(2, city.getCity_id());
			ps.setString(2, city.getCity_name());
			ps.setString(3, city.getEntered_by());
			ps.setString(4, city.getEntered_by());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertSociety(String formname, register_society society) {
		String q = DbQueryConstants.register_society;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, society.getRole());
			ps.setString(2, society.getState());
			ps.setString(3, society.getCity());
			ps.setString(4, society.getArea());
			ps.setString(5, society.getAddress());
			ps.setString(6, society.getLandmark());
			ps.setString(7, society.getPincode());
			ps.setString(8, society.getSociety_name());
			ps.setString(9, society.getSociety_type());
			ps.setString(10, society.getName_of_wings());
			ps.setString(11, society.getTotal_number_of_house());
			ps.setString(12, society.getName());
			ps.setString(13, society.getEmail());
			ps.setString(14, society.getPhone_no());
			ps.setString(15, society.getGender());
			ps.setString(16, society.getId_proof());
			ps.setString(17, society.getId_number());
			ps.setString(18, society.getId_upload());
			ps.setString(19, society.getName());
			ps.setString(20, society.getName());

			flag = ps.executeUpdate();
			System.out.println("In IMPL" + flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertWings(String formname, mst_wings wings) {
		String q = DbQueryConstants.mst_wing;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, wings.getNo_of_wings());
			ps.setString(2, wings.getName_of_wings());
			ps.setString(3, wings.getType_of_house());
			ps.setString(4, wings.getHouse_number());
			flag = ps.executeUpdate();
			System.out.println("In try block");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Unsuccess" + e);
		}
		return flag;
	}

	@Override
	public int insertService(String formname, mst_service service) {
		String q = DbQueryConstants.mst_service;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, service.getService_type());
			ps.setString(2, service.getEntered_by());
			ps.setString(3, service.getEntered_by());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertProblemType(String formname, mst_problem_type problemtype) {
		int flag = 0;
		String q = DbQueryConstants.mst_problem;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, problemtype.getService_type());
			ps.setString(2, problemtype.getProblem_type());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertArea(String formname, mst_mst_mst_area area) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_mst_mst_area;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(2, area.getCity_name());
			ps.setString(1, area.getState_name());
			ps.setString(3, area.getArea_name());
			ps.setString(4, area.getPincode());
			ps.setString(5, area.getEntered_by());
			ps.setString(6, area.getEntered_by());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertRole(String formname, mst_role role) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_role;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, role.getRole_name());
			ps.setString(2, role.getEntered_by());
			ps.setString(3, role.getEntered_by());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public int insertAmenities(String formname, mst_amenities amenities) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_amenities;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, amenities.getSoc_id());
			ps.setString(2, amenities.getAmenities_name());
			ps.setString(3, amenities.getRent());
			ps.setString(4, amenities.getEntered_by());
			ps.setString(5, amenities.getLast_update_by());

			System.out.println(q);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertBilltype(String formname, mst_bill bill) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_bill;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, bill.getBill_type());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertComplain(String formname, mst_complain complain) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_complain;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, complain.getComp_type());
			ps.setString(2, complain.getEntered_by());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertEvent(String formname, mst_event event) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_event;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, event.getEvent_name());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertExpense(String formname, mst_expense expense) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_expense;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, expense.getSoc_id());
			ps.setString(2, expense.getExp_type());
			ps.setString(3, expense.getPrice());
			ps.setString(4, expense.getEntered_by());
			ps.setString(5, expense.getLast_update_by());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public int insertIDType(String formname, mst_id_type idtype) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_id_type;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			// ps.setString(1, idtype.getSoc_id());
			ps.setString(1, idtype.getId_type());
			ps.setString(2, idtype.getEntered_by());
			ps.setString(3, idtype.getEntered_by());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertTax(String formname, mst_tax tax) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.mst_tax;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, tax.getTax_name());
			ps.setString(2, tax.getTax_percent());

			System.out.println(q);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public int insertStatus(String formname, mst_status status) {
		int flag = 0;
		String q = DbQueryConstants.mst_status;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, status.getStatus_name());
			System.out.println(q);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * String pass = null; try { MessageDigest md =
	 * MessageDigest.getInstance("MD5");
	 * md.update(registration.getPassword().toString().trim().getBytes());
	 * 
	 * byte byteData[] = md.digest();
	 * 
	 * StringBuffer hexString = new StringBuffer();
	 * 
	 * for (int k = 0; k < byteData.length; k++) { String hex =
	 * Integer.toHexString(0xff & byteData[k]); if (hex.length() == 1)
	 * hexString.append('0'); hexString.append(hex); } pass =
	 * hexString.toString().trim(); System.out.println(pass); } catch
	 * (NoSuchAlgorithmException e1) { e1.printStackTrace(); }
	 */

	/**
	 * inserting for request for service
	 */
	@Override
	public int insertRequestServices(String formname, tran_req_services reqservices) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.tran_req_services;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, reqservices.getUser_id());
			ps.setString(2, reqservices.getUser_email());
			ps.setString(3, reqservices.getSociety_name());
			ps.setString(4, reqservices.getService_name());
			ps.setString(5, reqservices.getProb_desc());
			ps.setString(6, reqservices.getReqservice_date());
			ps.setString(7, reqservices.getReqservice_time_from());
			ps.setString(8, reqservices.getReqservice_time_to());
			ps.setString(9, reqservices.getEntered_by());
			ps.setString(10, reqservices.getLast_updated_by());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertRequestAmenities(String formname, tran_req_amenities reqamenities) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.tran_req_amenities;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, reqamenities.getSoc_id());
			ps.setString(2, reqamenities.getSoc_name());
			ps.setString(3, reqamenities.getSoc_email());
			ps.setString(4, reqamenities.getSoc_address());
			ps.setString(5, reqamenities.getSoc_address2());
			ps.setString(6, reqamenities.getSoc_address3());
			ps.setString(7, reqamenities.getSoc_pincode());
			ps.setString(8, reqamenities.getMember_id());
			ps.setString(9, reqamenities.getMember_name());
			ps.setString(10, reqamenities.getMember_email());
			ps.setString(11, reqamenities.getAmenities_type());
			ps.setDate(12, reqamenities.getReqamenities_date());
			ps.setString(13, reqamenities.getAmount());
			ps.setString(14, reqamenities.getStatus());
			ps.setString(15, reqamenities.getEntered_by());
			ps.setString(16, reqamenities.getEntered_by());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertUserComplain(String formname, tran_complain complain) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.tran_complain;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, complain.getName());
			ps.setString(2, complain.getUser_id());
			ps.setString(3, complain.getComplain_to());
			ps.setString(4, complain.getComplain_type());
			ps.setString(5, complain.getComplain_description());
			ps.setString(6, complain.getDocument());
			ps.setString(7, complain.getSoc_id());
			ps.setString(8, complain.getName());
			ps.setString(9, complain.getName());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertUserFeedback(String formname, tran_feedback feedback) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.tran_feedback;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, feedback.getName());
			ps.setString(2, feedback.getUser_id());
			ps.setString(3, feedback.getFeedback_topic());
			ps.setString(4, feedback.getFeedback_description());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertWorkerService(String formname, register_worker workerservicedesc) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.tran_worker_service;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, workerservicedesc.getRole());
			ps.setString(2, workerservicedesc.getState());
			ps.setString(3, workerservicedesc.getCity());
			ps.setString(4, workerservicedesc.getArea());
			ps.setString(5, workerservicedesc.getAddress());
			ps.setString(6, workerservicedesc.getPincode());
			ps.setString(7, workerservicedesc.getService_type());
			ps.setString(8, workerservicedesc.getService_desc());
			ps.setString(9, workerservicedesc.getW_name());
			ps.setString(10, workerservicedesc.getW_email());
			ps.setString(11, workerservicedesc.getW_gender());
			ps.setString(12, workerservicedesc.getW_phone());
			ps.setString(13, workerservicedesc.getAvailable_from());
			ps.setString(14, workerservicedesc.getAvailable_to());
			ps.setString(15, workerservicedesc.getId_proof());
			ps.setString(16, workerservicedesc.getId_number());
			ps.setString(17, workerservicedesc.getId_upload());
			ps.setString(18, workerservicedesc.getW_name());
			ps.setString(19, workerservicedesc.getW_name());

			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertRegisterMember(String formname, register_member registerworker) {
		int flag = 0;
		String q = DbQueryConstants.register_member;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, registerworker.getRole());
			ps.setString(2, registerworker.getState());
			ps.setString(3, registerworker.getCity());
			ps.setString(4, registerworker.getArea());
			ps.setString(5, registerworker.getSoc_name());
			ps.setString(6, registerworker.getWing());
			ps.setString(7, registerworker.getHouse_type());
			ps.setString(8, registerworker.getHouse_num());
			ps.setString(9, registerworker.getMember_id());
			ps.setString(10, registerworker.getName());
			ps.setString(11, registerworker.getEmail());
			ps.setString(12, registerworker.getPhone_no());
			ps.setString(13, registerworker.getGender());
			ps.setString(14, registerworker.getId_proof());
			ps.setString(15, registerworker.getId_number());
			ps.setString(16, registerworker.getId_upload());
			ps.setString(17, registerworker.getName());
			ps.setString(18, registerworker.getName());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertRequestWorker(String formname, tran_ServiceRequest serviceReq) {
		int flag = 0;
		String q = DbQueryConstants.tran_req_worker;
		try {
			System.out.println("In try block");
			System.out.println(serviceReq.getDate());
			System.out.println(serviceReq.getWorker_name());
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, serviceReq.getStatus());
			ps.setString(2, serviceReq.getWorker_name());
			ps.setString(3, serviceReq.getService());
			ps.setString(4, serviceReq.getUser_id());
			ps.setString(5, serviceReq.getSociety_Name());
			ps.setString(6, serviceReq.getWing_Name());
			ps.setString(7, serviceReq.getHouse_No());
			ps.setString(8, serviceReq.getProblem_Discription());
			ps.setString(9, serviceReq.getDate());
			ps.setString(10, serviceReq.getTime_from());
			ps.setString(11, serviceReq.getTo_Tima());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return flag;
	}
	//////////////////////////////////////////////////////////////////////////////////////

	/**
	 * @author Karan Modi
	 * @return Checking the availability of the users for login
	 */
	@Override
	public registration_page cklogin(registration_page login) {
		String pass = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(login.getPassword().toString().trim().getBytes());

			byte byteData[] = md.digest();

			StringBuffer hexString = new StringBuffer();

			for (int k = 0; k < byteData.length; k++) {
				String hex = Integer.toHexString(0xff & byteData[k]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			pass = hexString.toString().trim();
			System.out.println(pass);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		registration_page lgn = null;
		System.out.println("Login Method Called...");
		DbConnectionProvider dbp = new DbConnectionProviderImpl();
		Connection con = dbp.getConnetion();
		String query = DbQueryConstants.checklogin;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, login.getRole_name());
			ps.setString(2, login.getEmail_id());
			ps.setString(3, pass);
			// String pass = login.getPassword();
			System.out.println("passWord is = " + pass);

			rs = ps.executeQuery();
			if (rs.next()) {
				lgn = new registration_page();
				lgn.setRole_name(rs.getString(2));
				lgn.setUsername(rs.getString(3));
				lgn.setEmail_id(rs.getString(4));
				lgn.setPassword(rs.getString(7));
				lgn.setContact_no(rs.getString(5));
				System.out.println("Login Successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Login Failed..." + e);
		}
		return lgn;
	}
	/*
	 * @author karan modi on 13/11/2019 get the state name form mst_state table
	 */

	@Override
	public ArrayList<String> getState() {

		ArrayList<String> getStateName = new ArrayList<String>();
		String q = DbQueryConstants.getState;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getStateName.add(rs.getString("state_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getStateName;
	}

	public ArrayList<String> getStateID() {
		// TODO Auto-generated method stub
		ArrayList<String> stateid = new ArrayList<String>();
		String q = DbQueryConstants.getStateId;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			System.out.println("In try block me bedu...");
			while (rs.next()) {
				stateid.add(rs.getString("state_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stateid;
	}

	/*
	 * @author karan modi on 13/11/2019 get the city name form mst_mst_city table
	 */
	@Override
	public ArrayList<String> getAllState() {
		ArrayList<String> getStateDetails = new ArrayList<String>();
		String q = DbQueryConstants.getState;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getStateDetails.add(rs.getString("state_id"));
				getStateDetails.add(rs.getString("state_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getStateDetails;
	}

	@Override
	public ArrayList<String> getCity() {
		ArrayList<String> getCityName = new ArrayList<String>();
		String q = DbQueryConstants.getCity;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getCityName.add(rs.getString("city_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCityName;
	}

	/*
	 * @author karan modi on 13/11/2019 get the role name form mst_role table
	 */
	@Override
	public ArrayList<String> getRole() {

		ArrayList<String> getRoleData = new ArrayList<String>();
		String q = DbQueryConstants.getRole;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getRoleData.add(rs.getString("role_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getRoleData;
	}

	@Override
	public ArrayList<String> getID() {
		ArrayList<String> getID = new ArrayList<String>();
		String q = DbQueryConstants.getId;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getID.add(rs.getString("id_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getID;
	}

	@Override
	public ArrayList<String> getArea() {
		ArrayList<String> getArea = new ArrayList<String>();
		String q = DbQueryConstants.getArea;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getArea.add(rs.getString("area_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getArea;
	}

	/*
	 * @Override public ArrayList<String> getCityID() { ArrayList<String> getCityid
	 * = new ArrayList<String>(); String q = DbQueryConstants.getCityId; try {
	 * PreparedStatement ps = con.prepareStatement(q); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) {
	 * getCityid.add(rs.getString("city_id")); } } catch (SQLException e) {
	 * e.printStackTrace(); } return getCityid; }
	 * 
	 * @Override public ArrayList<String> getStateIDFromCity() { ArrayList<String>
	 * getStateId = new ArrayList<String>(); String q =
	 * DbQueryConstants.getStateIDFromCity; try { PreparedStatement ps =
	 * con.prepareStatement(q); ResultSet rs = ps.executeQuery(); while
	 * ((rs.next())) { getStateId.add(rs.getString("state_id")); } } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return getStateId; }
	 * 
	 * @Override public ArrayList<String> getStateFromCity() { // TODO
	 * Auto-generated method stub ArrayList<String> getStateName = new
	 * ArrayList<String>();
	 * 
	 * DbConnectionProvider dbcon = new DbConnectionProviderImpl(); Connection con =
	 * dbcon.getConnetion(); String sql = DbQueryConstants.getStateNameFromCity; try
	 * { PreparedStatement ps = con.prepareStatement(sql); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) {
	 * getStateName.add(rs.getString("state_name")); }
	 * System.out.println(getStateName); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return getStateName; }
	 */
///////////////////////////CITY/////////////
	@Override
	public ArrayList<mst_mst_city> getCityModel() {
		// TODO Auto-generated method stub
		ArrayList<mst_mst_city> getcityInfo = new ArrayList<mst_mst_city>();
		String q = DbQueryConstants.getCityData;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_mst_city city = new mst_mst_city();
				// city.setState_id(rs.getString("state_id"));
				city.setState_name(rs.getString("state_name"));
				// city.setCity_id(rs.getString("city_id"));
				city.setCity_name(rs.getString("city_name"));
				getcityInfo.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getcityInfo;
	}

///////////////////////////AREA/////////////////////
	@Override
	public ArrayList<mst_mst_mst_area> getAreaModel() {
		// TODO Auto-generated method stub
		ArrayList<mst_mst_mst_area> getAreaInfo = new ArrayList<mst_mst_mst_area>();
		String q = DbQueryConstants.getAreaData;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_mst_mst_area area = new mst_mst_mst_area();

				area.setState_name(rs.getString("state_name"));
				area.setCity_name(rs.getString("city_name"));
				area.setArea_name(rs.getString("area_name"));
				area.setPincode(rs.getString("pincode"));
				getAreaInfo.add(area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getAreaInfo;
	}

	@Override
	public ArrayList<mst_state> getStateModel() {
		// TODO Auto-generated method stub
		ArrayList<mst_state> getAreaInfo = new ArrayList<mst_state>();
		String q = DbQueryConstants.getStateData;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_state state = new mst_state();
				state.setState_id(rs.getString("state_id"));
				state.setState_name(rs.getString("state_name"));

				getAreaInfo.add(state);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getAreaInfo;
	}
	/*
	 * @Override public ArrayList<String> getStateIDFromArea() { // TODO
	 * Auto-generated method stub ArrayList<String> getStateID = new
	 * ArrayList<String>();
	 * 
	 * DbConnectionProvider dbcon = new DbConnectionProviderImpl(); Connection con =
	 * dbcon.getConnetion(); String sql = DbQueryConstants.getStateIDFromArea; try {
	 * PreparedStatement ps = con.prepareStatement(sql); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) {
	 * getStateID.add(rs.getString("state_id")); } System.out.println(getStateID); }
	 * catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return getStateID; }
	 * 
	 * @Override public ArrayList<String> getStateFromArea() { // TODO
	 * Auto-generated method stub ArrayList<String> getStateName = new
	 * ArrayList<String>();
	 * 
	 * DbConnectionProvider dbcon = new DbConnectionProviderImpl(); Connection con =
	 * dbcon.getConnetion(); String sql = DbQueryConstants.getStateNameFromArea; try
	 * { PreparedStatement ps = con.prepareStatement(sql); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) {
	 * getStateName.add(rs.getString("state_name")); }
	 * System.out.println(getStateName); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return getStateName; }
	 * 
	 * @Override public ArrayList<String> getCityIDFromArea() { // TODO
	 * Auto-generated method stub ArrayList<String> getCityID = new
	 * ArrayList<String>();
	 * 
	 * DbConnectionProvider dbcon = new DbConnectionProviderImpl(); Connection con =
	 * dbcon.getConnetion(); String sql = DbQueryConstants.getCityIDFromArea; try {
	 * PreparedStatement ps = con.prepareStatement(sql); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) {
	 * getCityID.add(rs.getString("city_id")); } System.out.println(getCityID); }
	 * catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return getCityID; }
	 * 
	 * @Override public ArrayList<String> getCityFromArea() { // TODO Auto-generated
	 * method stub ArrayList<String> getCityName = new ArrayList<String>();
	 * 
	 * DbConnectionProvider dbcon = new DbConnectionProviderImpl(); Connection con =
	 * dbcon.getConnetion(); String sql = DbQueryConstants.getCityNameFromArea; try
	 * { PreparedStatement ps = con.prepareStatement(sql); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) {
	 * getCityName.add(rs.getString("city_name")); }
	 * System.out.println(getCityName); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return getCityName; }
	 * 
	 * @Override public ArrayList<String> getAreaID() { // TODO Auto-generated
	 * method stub ArrayList<String> getAreaID = new ArrayList<String>();
	 * 
	 * String sql = DbQueryConstants.getAreaID; try { PreparedStatement ps =
	 * con.prepareStatement(sql); ResultSet rs = ps.executeQuery(); while
	 * (rs.next()) { getAreaID.add(rs.getString("area_id")); }
	 * System.out.println(getAreaID); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return getAreaID; }
	 */

	@Override
	public ArrayList<mst_society> getAllSocietyDetails() {
		ArrayList<mst_society> getSocietyDetails = new ArrayList<mst_society>();
		String q = DbQueryConstants.getAllSociety;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_society society = new mst_society();

				society.setSoc_id(rs.getString("soc_id"));
				society.setRole(rs.getString("role"));
				society.setState(rs.getString("state"));
				society.setCity(rs.getString("city"));
				society.setArea(rs.getString("area"));
				society.setAddress(rs.getString("address"));
				society.setLandmark(rs.getString("landmark"));
				society.setPincode(rs.getString("pincode"));
				society.setSociety_name(rs.getString("society_name"));
				society.setSociety_type(rs.getString("society_type"));
				society.setName_of_wings(rs.getString("name_of_wings"));
				society.setTotal_number_of_house(rs.getString("total_number_of_house"));
				society.setName(rs.getString("name"));
				society.setEmail(rs.getString("email"));
				society.setPhone_no(rs.getString("phone_no"));
				society.setGender(rs.getString("gender"));
				society.setId_proof(rs.getString("id_proof"));
				society.setId_number(rs.getString("id_number"));
				society.setId_upload(rs.getString("in_upload"));

				getSocietyDetails.add(society);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getSocietyDetails;
	}

	@Override
	public ArrayList<mst_role> getAllRole() {
		// TODO Auto-generated method stub
		ArrayList<mst_role> getRole = new ArrayList<mst_role>();

		String sql = DbQueryConstants.getRoleDetails;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_role role = new mst_role();
				role.setRole_id(rs.getString("role_id"));
				role.setRole_name(rs.getString("role_name"));
				getRole.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getRole;
	}

	@Override
	public ArrayList<String> getAllTax() {
		// mst_tax tax=null;
		ArrayList<String> getTaxValue = new ArrayList<String>();
		String q = DbQueryConstants.getTax;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getTaxValue.add(rs.getString("tax_id"));
				getTaxValue.add(rs.getString("tax_name"));
				getTaxValue.add(rs.getString("tax_percent"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getTaxValue;
	}

	@Override
	public ArrayList<mst_service> getAllService() {
		ArrayList<mst_service> getServices = new ArrayList<mst_service>();
		String q = DbQueryConstants.getService;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_service service = new mst_service();
				service.setService_id(rs.getString("service_id"));
				service.setService_type(rs.getString("service_type"));
				getServices.add(service);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getServices;
	}
	
	@Override
	public ArrayList<mst_service> getServiceModel() {
		ArrayList<mst_service> getServices = new ArrayList<mst_service>();
		String q = DbQueryConstants.getServiceData;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_service service = new mst_service();
				service.setService_id(rs.getString("service_id"));
				service.setService_type(rs.getString("service_type"));
				getServices.add(service);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getServices;
	}

	
	@Override
	public ArrayList<mst_bill> getAllBillDetails() {
		ArrayList<mst_bill> getBill = new ArrayList<mst_bill>();
		String q = DbQueryConstants.getBill;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_bill bill = new mst_bill();
				bill.setBill_id(rs.getString("bill_id"));
				bill.setBill_type(rs.getString("bill_type"));
				getBill.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getBill;
	}

	@Override
	public ArrayList<mst_complain> getAllComp() {
		ArrayList<mst_complain> getComplaint = new ArrayList<mst_complain>();
		String q = DbQueryConstants.getComplaint;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mst_complain comp = new mst_complain();
				comp.setComp_id(rs.getString("comp_id"));
				comp.setComp_type(rs.getString("comp_type"));
				getComplaint.add(comp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getComplaint;
	}

	@Override
	public ArrayList<mst_amenities> getAmenitiesDetails(String socid) {
		ArrayList<mst_amenities> amenities = new ArrayList<mst_amenities>();
		String q = DbQueryConstants.getAmenities;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_amenities ameniti = new mst_amenities();
				ameniti.setAmenities_id(rs.getString("amenities_id"));
				ameniti.setAmenities_name(rs.getString("amenities_name"));
				ameniti.setRent(rs.getString("rent"));
				amenities.add(ameniti);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amenities;
	}

	@Override
	public ArrayList<mst_expense> getAllExpense(String socid) {
		// TODO Auto-generated method stub
		ArrayList<mst_expense> getExpenseInfo = new ArrayList<mst_expense>();
		String q = DbQueryConstants.getExpense;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_expense expense = new mst_expense();
				expense.setExp_id(rs.getString("exp_id"));
				expense.setExp_type(rs.getString("exp_type"));
				expense.setPrice(rs.getString("price"));
				expense.setEntered_on(rs.getString("entered_on"));
				getExpenseInfo.add(expense);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getExpenseInfo;
	}

	@Override
	public ArrayList<notice> getNotices(String socid) {
		// TODO Auto-generated method stub
		ArrayList<notice> getNoticeInfo = new ArrayList<notice>();
		String q = DbQueryConstants.getnotices;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				notice ntc = new notice();
				ntc.setNotice_id(rs.getString("notice_id"));
				ntc.setNotice(rs.getString("notice"));
				ntc.setEntered_on(rs.getString("entered_on"));
				getNoticeInfo.add(ntc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getNoticeInfo;

	}

	@Override
	public ArrayList<String> getExpenseID() {
		ArrayList<String> getExpenseID = new ArrayList<String>();
		String q = DbQueryConstants.getExpenseID;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getExpenseID.add(rs.getString("exp_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getExpenseID;
	}

	@Override
	public ArrayList<String> getExpenseName() {
		ArrayList<String> getExpenseType = new ArrayList<String>();
		String q = DbQueryConstants.getExpenseType;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getExpenseType.add(rs.getString("exp_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getExpenseType;
	}

	/*
	 * @Override public ArrayList<registration_page> getRegistrationData() {
	 * ArrayList<registration_page> getUserDetails = new
	 * ArrayList<registration_page>(); String q = DbQueryConstants.getUserData; try
	 * { PreparedStatement ps = con.prepareStatement(q); ResultSet rs =
	 * ps.executeQuery(); while (rs.next()) { registration_page user = new
	 * registration_page(); user.setUser_id(rs.getString("user_id"));
	 * user.setRole_name(rs.getString("role_name"));
	 * user.setUsername(rs.getString("username"));
	 * user.setGender(rs.getString("gender"));
	 * user.setContact_no(rs.getString("contact_no"));
	 * user.setEmail_id(rs.getString("email_id")); getUserDetails.add(user); } }
	 * catch (SQLException e) { e.printStackTrace(); } return getUserDetails; }
	 */
	@Override
	public ArrayList<mst_id_type> getAllID() {
		ArrayList<mst_id_type> idtype = new ArrayList<mst_id_type>();
		String q = DbQueryConstants.getIDDetails;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_id_type typeid = new mst_id_type();
				typeid.setId_id(rs.getString("id_id"));
				typeid.setId_type(rs.getString("id_type"));
				idtype.add(typeid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idtype;
	}

	/*
	 * @description methods for the update the data from jsp page...
	 */
	@Override
	public ArrayList<String> getUpdateState(String stateid) {
		ArrayList<String> data = new ArrayList<String>();
		String q = DbQueryConstants.getupdateState;
		try {
			System.out.println("In try block");
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, stateid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data.add(rs.getString("state_id"));
				data.add(rs.getString("state_name"));
			}
			System.out.println(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public int updateState(String formname, mst_state state) {
		int flag = 0;
		String q = DbQueryConstants.updateState;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, state.getState_name());
			ps.setString(2, state.getState_id());
			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * passing the soc_name for getting the value of service,name of worker as
	 * user's request
	 */
	@Override
	public ArrayList<tran_req_services> getRequestDetails() {
		ArrayList<tran_req_services> getworker = new ArrayList<tran_req_services>();
		String q = DbQueryConstants.getRequest;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tran_req_services reqService = new tran_req_services();

				reqService.setService_name(rs.getString("service_name"));
				reqService.setUser_id(rs.getString("user_id"));
				reqService.setSociety_name(rs.getString("society_name"));
				reqService.setWing_name(rs.getString("wing_name"));
				reqService.setHouse_no(rs.getString("house_no"));
				reqService.setProb_desc(rs.getString("prob_desc"));
				reqService.setReqservice_date(rs.getString("reqservice_date"));
				reqService.setReqservice_time_from(rs.getString("reqservice_time_from"));
				reqService.setReqservice_time_to(rs.getString("reqservice_time_to"));

				getworker.add(reqService);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getworker;
	}

	/**
	 * processing method for email
	 */
	@Override
	public int updatePassword(String formname, forgot_password fp) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.update_password;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, fp.getPassword());
			ps.setString(2, fp.getEmail());

			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public forgot_password checkEmail(forgot_password forgot) {
		// TODO Auto-generated method stub
		forgot_password fp = null;
		System.out.println("Login Method Called...");
		String query = DbQueryConstants.checkemail;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, forgot.getEmail());
			rs = ps.executeQuery();
			if (rs.next()) {
				fp = new forgot_password();
				fp.setUsername(rs.getString(4));
				fp.setEmail(rs.getString(7));
				System.out.println("forgot Successfully");
				System.out.println("Useer :" + fp.getUsername());
			}
			System.out.println(fp.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("forgot Failed..." + e);
		}
		return forgot;
	}

	/**
	 * input method for visitor insert by Secretary and all details by Secutiyr
	 * Guard
	 */
	@Override
	public int insertvisitor(String formname, mst_visitor_name visitor) {
		int flag = 0;
		String q = DbQueryConstants.insertVisitor;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, visitor.getVisitor_name());
			flag = ps.executeUpdate();
			System.out.println("NAme" + visitor.getVisitor_name());
			String result = flag == 1 ? "Success.." : "Failed..";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertvisitordetails(String formname, visitor_details visite) {
		int falg = 0;
		String q = DbQueryConstants.insertVisitorDetails;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, visite.getOptions());
			ps.setString(2, visite.getName());
			ps.setString(3, visite.getPhone_number());
			ps.setString(4, visite.getVehical_number());
			ps.setString(5, visite.getWing_name());
			ps.setString(6, visite.getHouse_number());
			ps.setString(7, visite.getMember_name());
			ps.setString(8, visite.getPurpose());
			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public ArrayList<register_society> getRequestedSociety() {
		// TODO Auto-generated method stub
		ArrayList<register_society> getRequestedSoc = new ArrayList<register_society>();
		String q = DbQueryConstants.getRegisteredSociety;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				register_society reqSociety = new register_society();

				reqSociety.setRole(rs.getString("role_type"));
				reqSociety.setState(rs.getString("state"));
				reqSociety.setCity(rs.getString("city"));
				reqSociety.setArea(rs.getString("area"));
				reqSociety.setAddress(rs.getString("address"));
				reqSociety.setLandmark(rs.getString("landmark"));
				reqSociety.setPincode(rs.getString("pincode"));
				reqSociety.setSociety_name(rs.getString("society_name"));
				reqSociety.setSociety_type(rs.getString("society_type"));
				reqSociety.setName_of_wings(rs.getString("name_of_wings"));
				reqSociety.setTotal_number_of_house(rs.getString("total_number_of_house"));
				reqSociety.setName(rs.getString("name"));
				reqSociety.setEmail(rs.getString("email"));
				reqSociety.setPhone_no(rs.getString("phone_no"));
				reqSociety.setGender(rs.getString("gender"));
				reqSociety.setId_proof(rs.getString("id_proof"));
				reqSociety.setId_number(rs.getString("id_number"));
				reqSociety.setId_upload(rs.getString("id_upload"));
				getRequestedSoc.add(reqSociety);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getRequestedSoc;
	}

	@Override
	public int insertRegisteredSociety(String formname, register_society society) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.mst_society;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, society.getRole());
			ps.setString(2, society.getState());
			ps.setString(3, society.getCity());
			ps.setString(4, society.getArea());
			ps.setString(5, society.getAddress());
			ps.setString(6, society.getLandmark());
			ps.setString(7, society.getPincode());
			ps.setString(8, society.getSociety_name());
			ps.setString(9, society.getSociety_type());
			ps.setString(10, society.getName_of_wings());
			ps.setString(11, society.getTotal_number_of_house());
			ps.setString(12, society.getName());
			ps.setString(13, society.getEmail());
			ps.setString(14, society.getPhone_no());
			ps.setString(15, society.getGender());
			ps.setString(16, society.getId_proof());
			ps.setString(17, society.getId_number());
			ps.setString(18, society.getId_upload());

			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int insertUser(String formname, registration_page society) {
		// TODO Auto-generated method stub
		int flag = 0;
		String pass = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(society.getPassword().toString().trim().getBytes());

			byte byteData[] = md.digest();

			StringBuffer hexString = new StringBuffer();

			for (int k = 0; k < byteData.length; k++) {
				String hex = Integer.toHexString(0xff & byteData[k]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			pass = hexString.toString().trim();
			System.out.println(pass);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		String q = DbQueryConstants.registration_page;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, society.getRole_name());
			ps.setString(2, society.getUsername());
			ps.setString(3, society.getEmail_id());
			ps.setString(4, society.getContact_no());
			ps.setString(5, society.getGender());
			ps.setString(6, pass);
			System.out.println(pass);
			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int insertSociety(String formname, String email) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.getAcceptedSociety;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				register_society reqSociety = new register_society();

				reqSociety.setRole(rs.getString("role_type"));
				reqSociety.setState(rs.getString("state"));
				reqSociety.setCity(rs.getString("city"));
				reqSociety.setArea(rs.getString("area"));
				reqSociety.setAddress(rs.getString("address"));
				reqSociety.setLandmark(rs.getString("landmark"));
				reqSociety.setPincode(rs.getString("pincode"));
				reqSociety.setSociety_name(rs.getString("society_name"));
				reqSociety.setSociety_type(rs.getString("society_type"));
				reqSociety.setName_of_wings(rs.getString("name_of_wings"));
				reqSociety.setTotal_number_of_house(rs.getString("total_number_of_house"));
				reqSociety.setName(rs.getString("name"));
				reqSociety.setEmail(rs.getString("email"));
				reqSociety.setPhone_no(rs.getString("phone_no"));
				reqSociety.setGender(rs.getString("gender"));
				reqSociety.setId_proof(rs.getString("id_proof"));
				reqSociety.setId_number(rs.getString("id_number"));
				reqSociety.setId_upload(rs.getString("id_upload"));

				String query = DbQueryConstants.mst_society;
				try {
					ps = con.prepareStatement(query);
					ps.setString(1, reqSociety.getRole());
					ps.setString(2, reqSociety.getState());
					ps.setString(3, reqSociety.getCity());
					ps.setString(4, reqSociety.getArea());
					ps.setString(5, reqSociety.getAddress());
					ps.setString(6, reqSociety.getLandmark());
					ps.setString(7, reqSociety.getPincode());
					ps.setString(8, reqSociety.getSociety_name());
					ps.setString(9, reqSociety.getSociety_type());
					ps.setString(10, reqSociety.getName_of_wings());
					ps.setString(11, reqSociety.getTotal_number_of_house());
					ps.setString(12, reqSociety.getName());
					ps.setString(13, reqSociety.getEmail());
					ps.setString(14, reqSociety.getPhone_no());
					ps.setString(15, reqSociety.getGender());
					ps.setString(16, reqSociety.getId_proof());
					ps.setString(17, reqSociety.getId_number());
					ps.setString(18, reqSociety.getId_upload());

					flag = ps.executeUpdate();
					String result = flag == 1 ? "Success" : "Failed";
					System.out.println(result);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return flag;

	}

	@Override
	public int insertRegisteredMember(String formname, register_member member) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.tran_user;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, member.getRole());
			ps.setString(2, member.getState());
			ps.setString(3, member.getCity());
			ps.setString(4, member.getArea());
			ps.setString(5, member.getSoc_name());
			ps.setString(6, member.getWing());
			ps.setString(7, member.getHouse_num());
			ps.setString(8, member.getMember_id());
			ps.setString(9, member.getName());
			ps.setString(10, member.getEmail());
			ps.setString(11, member.getPhone_no());
			ps.setString(12, member.getGender());
			ps.setString(13, member.getId_proof());
			ps.setString(14, member.getId_number());
			ps.setString(15, member.getId_upload());
			System.out.println("SOC" + member.getSoc_name());

			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("KAran Modi" + e);
		}

		return flag;
	}

	@Override
	public int insertRegisteredworker(String formname, register_worker worker) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.tran_worker;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, worker.getRole());
			ps.setString(2, worker.getState());
			ps.setString(3, worker.getCity());
			ps.setString(4, worker.getArea());
			ps.setString(5, worker.getAddress());
			ps.setString(6, worker.getPincode());
			ps.setString(7, worker.getService_type());
			ps.setString(8, worker.getService_desc());
			ps.setString(9, worker.getW_name());
			ps.setString(10, worker.getW_email());
			ps.setString(11, worker.getW_gender());
			ps.setString(12, worker.getW_phone());
			ps.setString(13, worker.getAvailable_from());
			ps.setString(14, worker.getAvailable_to());
			ps.setString(15, worker.getId_proof());
			ps.setString(16, worker.getId_number());
			ps.setString(17, worker.getId_upload());

			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int insertSecretary(String formname, registration_page registration) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.registration_page;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, registration.getRole_name());
			ps.setString(2, registration.getUsername());
			ps.setString(3, registration.getEmail_id());
			ps.setString(4, registration.getContact_no());
			ps.setString(5, registration.getGender());
			ps.setString(6, registration.getPassword());

			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public int insertContactFormData(String formname, contact_us c) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.contact_us;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, c.getF_name());
			ps.setString(2, c.getL_name());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getPhone());
			ps.setString(5, c.getMessage());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public ArrayList<String> getRegistrationData(String email) {
		ArrayList<String> getRegData = new ArrayList<String>();
		String q = DbQueryConstants.getRequestedSociety;
		try {
			registration_page reg = new registration_page();
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			System.out.println("YOUR EMAIL :" + email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getRegData.add(rs.getString("username"));
				getRegData.add(rs.getString("email_id"));
				getRegData.add(rs.getString("contact_no"));
				getRegData.add(rs.getString("gender"));
				getRegData.add(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getRegData;
	}

	/**
	 * Inserting method for the maintenance report generate
	 */
	@Override
	public int insertMaintenance(String formname, mst_maintenance main) {
		int flag = 0;
		String q = DbQueryConstants.getSocietyofMember;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, main.getSecre_email());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				// mst_maintenance main1=new mst_maintenance();
				main.setSoc_name(rs.getString("society_name"));
				main.setSoc_id(rs.getString("soc_id"));
				String query = DbQueryConstants.insertMaintenance;
				try {
					ps = con.prepareStatement(query);
					ps.setString(1, main.getSoc_id());
					ps.setString(2, main.getSoc_name());
					ps.setString(3, main.getSecre_email());
					ps.setString(4, main.getCleaner_charge());
					ps.setString(5, main.getWatchman_charge());
					ps.setString(6, main.getLift_main());
					ps.setString(7, main.getWatertank_cleaner());
					ps.setString(8, main.getPrice_pr_unit());
					ps.setString(9, main.getExtra_expence());

					flag = ps.executeUpdate();
					String result = flag == 1 ? "Success" : "Failed";
					System.out.println(result);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return flag;
	}
	@Override
	public int updateMaintenance(String formname, mst_maintenance main) {
		int flag = 0;
		String q = DbQueryConstants.getSocietyofMember;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, main.getSecre_email());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				// mst_maintenance main1=new mst_maintenance();
				main.setSoc_name(rs.getString("society_name"));
				main.setSoc_id(rs.getString("soc_id"));
				String query = DbQueryConstants.updateMaintainanc;
				try {
					ps = con.prepareStatement(query);
					ps.setString(1, main.getCleaner_charge());
					ps.setString(2, main.getWatchman_charge());
					ps.setString(3, main.getLift_main());
					ps.setString(4, main.getWatertank_cleaner());
					ps.setString(5, main.getPrice_pr_unit());
					ps.setString(6, main.getExtra_expence());
					ps.setString(7, "dignesh");
					ps.setString(8, DbTransactionImpl.entered_on());
					ps.setString(9, main.getSoc_id());
							
					flag = ps.executeUpdate();
					String result = flag == 1 ? "Success" : "Failed";
					System.out.println(result);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return flag;
	}
	/*
	 * int flag = 0;
	 * 
	 * List<String> get = new ArrayList<String>(); String q1 =
	 * DbQueryConstants.getSocietyofMember; try { PreparedStatement ps1 =
	 * con.prepareStatement(q1); ps1.setString(1, main.getSoc_id());
	 * System.out.println(main.getSoc_id()); ResultSet rs = ps1.executeQuery();
	 * while (rs.next()) { main.setSoc_name(rs.getString("society_name"));
	 * System.out.println("SSOCN"+rs.getString("society_name"));
	 * 
	 * 
	 * 
	 * String q = DbQueryConstants.insertMaintenance; try { PreparedStatement ps =
	 * con.prepareStatement(q); ps.setString(1, main.getSoc_name()); ps.setString(1,
	 * main.getCleaner_charge()); ps.setString(2, main.getWatchman_charge());
	 * ps.setString(3, main.getLift_main()); ps.setString(4,
	 * main.getWatertank_cleaner()); ps.setString(5, main.getPrice_pr_unit());
	 * ps.setString(6, main.getExtra_expence());
	 * 
	 * flag = ps.executeUpdate(); System.out.println(flag); } catch (SQLException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } } catch
	 * (SQLException e1) { // TODO Auto-generated catch block e1.printStackTrace();
	 * }
	 * 
	 * return flag; }
	 */

	@Override
	public ArrayList<mst_society> getRegisteredSocietyData() {
		// TODO Auto-generated method stub
		ArrayList<mst_society> getRegisteredSoc = new ArrayList<mst_society>();
		String q = DbQueryConstants.getFinalSociety;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_society regSociety = new mst_society();
				regSociety.setSoc_id("soc_id");
				regSociety.setRole(rs.getString("role_type"));
				regSociety.setState(rs.getString("state"));
				regSociety.setCity(rs.getString("city"));
				regSociety.setArea(rs.getString("area"));
				regSociety.setAddress(rs.getString("address"));
				regSociety.setLandmark(rs.getString("landmark"));
				regSociety.setPincode(rs.getString("pincode"));
				regSociety.setSociety_name(rs.getString("society_name"));
				regSociety.setSociety_type(rs.getString("society_type"));
				regSociety.setName_of_wings(rs.getString("name_of_wings"));
				regSociety.setTotal_number_of_house(rs.getString("total_number_of_house"));
				regSociety.setName(rs.getString("name"));
				regSociety.setEmail(rs.getString("email"));
				regSociety.setPhone_no(rs.getString("phone_no"));
				regSociety.setGender(rs.getString("gender"));
				regSociety.setId_proof(rs.getString("id_proof"));
				regSociety.setId_number(rs.getString("id_number"));
				regSociety.setId_upload(rs.getString("id_upload"));
				getRegisteredSoc.add(regSociety);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getRegisteredSoc;
	}

	@Override
	public ArrayList<tran_worker> getRegisteredWorkerData() {
		// TODO Auto-generated method stub
		ArrayList<tran_worker> getWorkers = new ArrayList<tran_worker>();
		// int start=currentpage*recordsperpage-recordsperpage;
		// System.out.println(start);
		String q = DbQueryConstants.getRegisteredWorker;
		try {
			PreparedStatement ps = con.prepareStatement(q);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tran_worker regWorker = new tran_worker();

				regWorker.setRole(rs.getString("role"));
				regWorker.setState(rs.getString("state"));
				regWorker.setCity(rs.getString("city"));
				regWorker.setArea(rs.getString("area"));
				regWorker.setAddress(rs.getString("address"));
				regWorker.setPincode(rs.getString("pincode"));
				regWorker.setService_type(rs.getString("service_type"));
				regWorker.setService_desc(rs.getString("service_desc"));
				regWorker.setW_name(rs.getString("w_name"));
				regWorker.setW_email(rs.getString("w_email"));
				regWorker.setW_gender(rs.getString("w_gender"));
				regWorker.setW_phone(rs.getString("w_phone"));
				regWorker.setAvailable_from(rs.getString("available_from"));
				regWorker.setAvailable_to(rs.getString("available_to"));
				regWorker.setId_proof(rs.getString("id_proof"));
				regWorker.setId_number(rs.getString("id_number"));
				regWorker.setId_upload(rs.getString("id_upload"));
				getWorkers.add(regWorker);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getWorkers;
	}

	@Override
	public ArrayList<tran_complain> getAdminComplaintData() {
		// TODO Auto-generated method stub
		ArrayList<tran_complain> getComplaintdata = new ArrayList<tran_complain>();
		String q = DbQueryConstants.getAdminComplaint;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tran_complain complaint = new tran_complain();

				complaint.setName(rs.getString("name"));
				complaint.setSoc_id(rs.getString("soc_id"));
				complaint.setUser_id(rs.getString("user_id"));
				complaint.setComplain_to(rs.getString("complain_to"));
				complaint.setComplain_type(rs.getString("complain_type"));
				complaint.setComplain_description(rs.getString("complain_description"));
				complaint.setDocument(rs.getString("document"));
				
				getComplaintdata.add(complaint);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getComplaintdata;
	}

	@Override
	public ArrayList<tran_complain> getSecComplaintData(String socid) {
		// TODO Auto-generated method stub
		ArrayList<tran_complain> getComplaintdata = new ArrayList<tran_complain>();
		String q = DbQueryConstants.getSecComplaint;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tran_complain complaint = new tran_complain();

				complaint.setName(rs.getString("name"));
				complaint.setSoc_id(rs.getString("soc_id"));
				complaint.setUser_id(rs.getString("user_id"));
				complaint.setComplain_to(rs.getString("complain_to"));
				complaint.setComplain_type(rs.getString("complain_type"));
				complaint.setComplain_description(rs.getString("complain_description"));
				complaint.setDocument(rs.getString("document"));
				
				getComplaintdata.add(complaint);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getComplaintdata;
	}

	@Override
	public ArrayList<tran_maintainance> getPendingMaintainance(String socid) {
		// TODO Auto-generated method stub
		ArrayList<tran_maintainance> getdata = new ArrayList<tran_maintainance>();
		String q = DbQueryConstants.getPendingMaintainance;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tran_maintainance maintainance = new tran_maintainance();

				maintainance.setMember_id(rs.getString("member_id"));
				maintainance.setMember_name(rs.getString("member_name"));
				maintainance.setTotal_amount(rs.getString("total_amount"));
				maintainance.setStatus(rs.getString("status"));
				maintainance.setDue_date(rs.getDate("due_date"));
				maintainance.setGenerated_date(rs.getDate("generated_date"));
				
				getdata.add(maintainance);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getdata;
	}

	@Override
	public ArrayList<tran_maintainance> getGeneratedMaintainance(String socid) {
		// TODO Auto-generated method stub
		LocalDate todaydate = LocalDate.now();
		System.out.println("Months first date in yyyy-mm-dd: " +todaydate.withDayOfMonth(1));
		LocalDate dt=todaydate.withDayOfMonth(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = dt.format(formatter);
		
		ArrayList<tran_maintainance> getdata = new ArrayList<tran_maintainance>();
		String q = DbQueryConstants.getGenMaintainance;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tran_maintainance maintainance = new tran_maintainance();

				maintainance.setMember_id(rs.getString("member_id"));
				maintainance.setMember_name(rs.getString("member_name"));
				maintainance.setTotal_amount(rs.getString("total_amount"));
				maintainance.setStatus(rs.getString("status"));
				maintainance.setDue_date(rs.getDate("due_date"));
				maintainance.setGenerated_date(rs.getDate("generated_date"));
				
				getdata.add(maintainance);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getdata;
	}

	@Override
	public int insertSociety(String formname, mst_society society) {
		String q = DbQueryConstants.mst_society;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, society.getState());
			ps.setString(2, society.getCity());
			ps.setString(3, society.getArea());
			ps.setString(4, society.getSociety_name());
			ps.setString(5, society.getSociety_type());
			ps.setString(6, society.getAddress());
			ps.setString(7, society.getLandmark());
			ps.setString(8, society.getPincode());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public register_society getSocietyDetailsForMember(String secretaryId) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.getSocietyofMember;
		register_society reqSociety = new register_society();
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, secretaryId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reqSociety.setRole(rs.getString("role_type"));
				reqSociety.setState(rs.getString("state"));
				reqSociety.setCity(rs.getString("city"));
				reqSociety.setArea(rs.getString("area"));
				reqSociety.setAddress(rs.getString("address"));
				reqSociety.setSociety_name(rs.getString("society_name"));
				reqSociety.setLandmark(rs.getString("landmark"));
				reqSociety.setPincode(rs.getString("pincode"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return reqSociety;
	}

	@Override
	public ArrayList<register_worker> getRequestedWorker() {
		// TODO Auto-generated method stub
		ArrayList<register_worker> getWorkers = new ArrayList<register_worker>();
		String q = DbQueryConstants.getRequestedWorker;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				register_worker reqWorker = new register_worker();

				reqWorker.setRole(rs.getString("role"));
				reqWorker.setState(rs.getString("state"));
				reqWorker.setCity(rs.getString("city"));
				reqWorker.setArea(rs.getString("area"));
				reqWorker.setAddress(rs.getString("address"));
				reqWorker.setPincode(rs.getString("pincode"));
				reqWorker.setService_type(rs.getString("service_type"));
				reqWorker.setService_desc(rs.getString("service_desc"));
				reqWorker.setW_name(rs.getString("w_name"));
				reqWorker.setW_email(rs.getString("w_email"));
				reqWorker.setW_gender(rs.getString("w_gender"));
				reqWorker.setW_phone(rs.getString("w_phone"));
				reqWorker.setAvailable_from(rs.getString("available_from"));
				reqWorker.setAvailable_to(rs.getString("available_to"));
				reqWorker.setId_proof(rs.getString("id_proof"));
				reqWorker.setId_number(rs.getString("id_number"));
				reqWorker.setId_upload(rs.getString("id_upload"));
				getWorkers.add(reqWorker);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getWorkers;
	}

	@Override
	public int removeMember() {
		int flag = 0;
		String q = DbQueryConstants.removeworker;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public ArrayList<register_member> getRequestedMember(String email) {
		String q = DbQueryConstants.getRequestedMember;
		ArrayList<register_member> getRequestedMember = new ArrayList<register_member>();
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				register_member reqWorker = new register_member();

				reqWorker.setRole(rs.getString("role"));
				reqWorker.setState(rs.getString("state"));
				reqWorker.setCity(rs.getString("city"));
				reqWorker.setArea(rs.getString("area"));
				// reqWorker.setAddress(rs.getString("address"));
				// reqWorker.setLandmark(rs.getString("landmark"));
				// reqWorker.setPincode(rs.getString("pincode"));
				reqWorker.setSoc_name(rs.getString("soc_name"));
				reqWorker.setHouse_num(rs.getString("house_num"));
				reqWorker.setWing(rs.getString("wing"));
				reqWorker.setMember_id(rs.getString("member_id"));
				// reqWorker.setSociety_type(rs.getString("society_type"));
				// reqWorker.setName_of_wings(rs.getString("name_of_wings"));
				// reqWorker.setTotal_number_of_house(rs.getString("total_number_of_house"));
				reqWorker.setName(rs.getString("name"));
				reqWorker.setEmail(rs.getString("email"));
				reqWorker.setPhone_no(rs.getString("phone_no"));
				reqWorker.setGender(rs.getString("gender"));
				reqWorker.setId_proof(rs.getString("id_proof"));
				reqWorker.setId_number(rs.getString("id_number"));
				reqWorker.setId_upload(rs.getString("id_upload"));
				System.out.println(rs.getString("soc_name"));
				getRequestedMember.add(reqWorker);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getRequestedMember;
	}

	@Override
	public ArrayList<String> getMaintenanceDetails(String email) {
		ArrayList<String> getMainData = new ArrayList<String>();
		String q = DbQueryConstants.getMainDetails;
		
		try {
			System.out.println("INMAINTENANXC");
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getMainData.add(rs.getString("watchman_charge"));
				getMainData.add(rs.getString("cleaner_charge"));
				getMainData.add(rs.getString("lift_main"));
				getMainData.add(rs.getString("watertank_cleaner"));
				getMainData.add(rs.getString("price_pr_unit"));
				getMainData.add(rs.getString("extra_expence"));
				System.out.println(rs.getString("watertank_cleaner"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getMainData;
	}

	@Override
	public ArrayList<String> getmemberid(String email) {
		ArrayList<String> getmemberid = new ArrayList<String>();
		String q = DbQueryConstants.getmemberid;
		PreparedStatement ps;
		try {
			LocalDate todaydate = LocalDate.now();
			System.out.println("Months first date in yyyy-mm-dd: " +todaydate.withDayOfMonth(1));
			LocalDate dt=todaydate.withDayOfMonth(1);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String date = dt.format(formatter);
			
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);
			ps.setString(5,date);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getmemberid.add(rs.getString("member_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getmemberid;
	}

	@Override
	public ArrayList<String> getmemberidvis(String email) {
		ArrayList<String> getmemberid = new ArrayList<String>();
		String q = DbQueryConstants.getmemberidinvis;
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getmemberid.add(rs.getString("member_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getmemberid;
	}

	
	/**
	 * NEW methods for the getting reuesting pagets
	 */
	@Override
	public int insertRegisteredworkeronAccept(String emailid, String pass, String formname) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.getAcceptedWorkerData;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, emailid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				register_worker worker = new register_worker();

				worker.setRole(rs.getString("role"));
				worker.setState(rs.getString("state"));
				worker.setCity(rs.getString("city"));
				worker.setArea(rs.getString("area"));
				worker.setAddress(rs.getString("address"));
				worker.setPincode(rs.getString("pincode"));
				worker.setService_type(rs.getString("service_type"));
				worker.setService_desc(rs.getString("service_desc"));
				worker.setAvailable_from(rs.getString("available_from"));
				worker.setAvailable_to(rs.getString("available_to"));
				worker.setW_email(rs.getString("w_name"));
				worker.setW_email(rs.getString("w_email"));
				worker.setW_phone(rs.getString("w_phone"));
				worker.setW_gender(rs.getString("w_gender"));
				worker.setId_proof(rs.getString("id_proof"));
				worker.setId_number(rs.getString("id_number"));
				worker.setId_upload(rs.getString("id_upload"));

				String query = DbQueryConstants.addWorkerOnAccept;
				try {
					ps = con.prepareStatement(query);
					ps.setString(1, worker.getRole());
					ps.setString(2, worker.getState());
					ps.setString(3, worker.getCity());
					ps.setString(4, worker.getArea());
					ps.setString(5, worker.getAddress());
					ps.setString(6, worker.getPincode());
					ps.setString(7, worker.getService_type());
					ps.setString(8, worker.getService_desc());
					ps.setString(9, worker.getW_name());
					ps.setString(10, worker.getW_email());
					ps.setString(11, worker.getW_gender());
					ps.setString(12, worker.getW_phone());
					ps.setString(13, worker.getAvailable_from());
					ps.setString(14, worker.getAvailable_to());
					ps.setString(15, worker.getId_proof());
					ps.setString(16, worker.getId_number());
					ps.setString(17, worker.getId_upload());

					flag = ps.executeUpdate();
					String result = flag == 1 ? "Success" : "Failed";
					System.out.println(result);
					if (result.equals("Success")) {
						registration_page registration = new registration_page();
						registration.setRole_name(worker.getRole());
						registration.setUsername(worker.getW_name());
						registration.setEmail_id(worker.getW_email());
						registration.setContact_no(worker.getW_phone());
						registration.setGender(worker.getW_gender());
						registration.setPassword(pass);

						DbTransction dbt = new DbTransactionImpl();
						int res = dbt.insertSecretary(formname, registration);
						String reg = res == 1 ? "SuccessReg" : "FailedReg";
						System.out.println(reg);

						if (reg.equals("SuccessReg")) {
							flag = 2;
						}

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println(flag);
		return flag;
	}

	@Override
	public int insertSocietyOnAccept(String emailid, String pass, String formname, String admin) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.addAcceptedSoc;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, admin);
			ps.setString(2, admin);
			ps.setString(3, emailid);

			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);

			if (result.equals("Success")) {
				String query = DbQueryConstants.insertSecretaryOnReg;
				ps = con.prepareStatement(query);
				ps.setString(1, pass);
				ps.setString(2, admin);
				ps.setString(3, admin);
				ps.setString(4, emailid);

				int res = ps.executeUpdate();
				String reg = res == 1 ? "SuccessReg" : "FailedReg";
				System.out.println(reg);

				if (reg.equals("SuccessReg")) {
					flag = 2;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(flag);
		return flag;
	}

	@Override
	public int DeleteRegisteredSocFromRegSoc(String emailid) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteSocietyRequest;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, emailid);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int DeleteRegisteredworker(String workerid) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteWorkerRequest;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, workerid);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertMemberOnAccept(String email, String pass, String formname, String adminname) {
		int flag = 0;
		// TODO Auto-generated method stub
		String q = DbQueryConstants.addAcceptedMember;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, adminname);
			ps.setString(2, adminname);
			ps.setString(3, email);

			flag = ps.executeUpdate();
			String resultadd = flag == 1 ? "SuccessAdd" : "FailedAdd";
			System.out.println(resultadd);

			if (resultadd.equalsIgnoreCase("SuccessAdd")) {
				String query = DbQueryConstants.insertMemberOnReg;
				ps = con.prepareStatement(query);
				ps.setString(1, pass);
				ps.setString(2, adminname);
				ps.setString(3, adminname);
				ps.setString(4, email);

				int res = ps.executeUpdate();
				String reg = res == 1 ? "SuccessReg" : "FailedReg";
				System.out.println(reg);

				if (reg.equals("SuccessReg")) {
					flag = 2;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int DeleteRegisteredMemberFromRegMem(String email) {
		String q = DbQueryConstants.deleteMemberRequest;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			flag = ps.executeUpdate();
			String resultdel = flag == 1 ? "SuccessDel" : "FailedDel";
			System.out.println(resultdel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * @Override public int insertSecretary(String formname, registration_page
	 * registration) { // TODO Auto-generated method stub int flag = 0; String q =
	 * DbQueryConstants.registration_page; try { PreparedStatement ps =
	 * con.prepareStatement(q); ps.setString(1, registration.getRole_name());
	 * ps.setString(2, registration.getUsername()); ps.setString(3,
	 * registration.getEmail_id()); ps.setString(4, registration.getContact_no());
	 * ps.setString(5, registration.getGender()); ps.setString(6,
	 * registration.getPassword());
	 * 
	 * flag = ps.executeUpdate(); String result = flag == 1 ? "Success" : "Failed";
	 * System.out.println(result); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * return flag; }
	 */
	@Override
	public String getSocietyID(String email) {
		// TODO Auto-generated method stub
		String socid = "";
		String q = DbQueryConstants.getsocietyid;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				socid = rs.getString("soc_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socid;
	}
	
	@Override
	public String getSocietyIDofUser(String email) {
		// TODO Auto-generated method stub
		String socid = "";
		String q = DbQueryConstants.getsocidofuser;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				socid = rs.getString("soc_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socid;
	}

	@Override
	public String getSocietyEmailofUser(String email) {
		// TODO Auto-generated method stub
		String socid = "";
		String q = DbQueryConstants.getsocemailofuser;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				socid = rs.getString("email");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socid;
	}

	
	@Override
	public int insertNotice(String formname, notice ntc) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.insertnotice;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, ntc.getSoc_id());
			ps.setString(2, ntc.getSecretary_id());
			ps.setString(3, ntc.getNotice());
			ps.setString(4, ntc.getEntered_by());
			ps.setString(5, ntc.getLast_updated_by());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteState(String formname, String stateid) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deletestate;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, stateid);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deletecity(String formname, String cityname) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deletecity;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, cityname);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deletearea(String formname, String areaname) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteArea;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, areaname);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleterole(String formname, String roleid) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteRole;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, roleid);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteidtype(String formname, String idindex) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteidtype;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, idindex);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteExpense(String formname, String exptype, String socid) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteExpense;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, socid);
			ps.setString(2, exptype);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int ChangePassword(String email, registration_page login) {
		int flag = 0;
		String q = DbQueryConstants.changePass;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, login.getPassword());
			ps.setString(2, email);

			flag = ps.executeUpdate();

			String result = flag == 1 ? "Perfect" : "NotPerfect";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public ArrayList<tran_worker> workerDetails(String email) {
		String q = DbQueryConstants.getWorkerDetails;
		ArrayList<tran_worker> workerDetails = new ArrayList<tran_worker>();
		try {

			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tran_worker wor = new tran_worker();
				wor.setW_name(rs.getString("w_name"));
				wor.setW_email(rs.getString("w_email"));
				wor.setW_phone(rs.getString("w_phone"));
				wor.setService_type(rs.getString("service_type"));
				wor.setService_desc(rs.getString("service_desc"));
				wor.setAvailable_from(rs.getString("available_from"));
				wor.setAvailable_to(rs.getString("available_to"));
				workerDetails.add(wor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workerDetails;
	}

	@Override
	public ArrayList<RequestServices> getServiceToWorker(String email) {
		ArrayList<RequestServices> getServiceReq = new ArrayList<RequestServices>();
		String q = DbQueryConstants.getServiceToWorker;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RequestServices reqs = new RequestServices();
				reqs.setUser_name(rs.getString("user_name"));
				reqs.setAddress(rs.getString("address"));
				reqs.setUser_phone(rs.getString("user_phone"));
				reqs.setUser_email(rs.getString("user_email"));
				reqs.setProb_desc(rs.getString("prob_desc"));
				reqs.setReqservice_date(rs.getString("reqservice_date"));
				reqs.setReqservice_time_from(rs.getString("reqservice_time_from"));
				reqs.setReqservice_time_to(rs.getString("reqservice_time_to"));
				getServiceReq.add(reqs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getServiceReq;
	}

	@Override
	public int insertWorrequestService(String formname, RequestServices reqs) {
		int flag = 0;

		String q = DbQueryConstants.insertWorkerreq;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, reqs.getUser_name());
			ps.setString(2, reqs.getUser_email());
			ps.setString(3, reqs.getUser_phone());
			ps.setString(4, reqs.getAddress());
			ps.setString(5, reqs.getProb_desc());
			ps.setString(6, reqs.getReqservice_date());
			ps.setString(7, reqs.getReqservice_time_from());
			ps.setString(8, reqs.getReqservice_time_to());
			ps.setString(9, reqs.getService_type());
			ps.setString(10, reqs.getW_email());
			ps.setString(11, reqs.getW_name());
			ps.setString(12, reqs.getEntered_by());
			ps.setString(13, reqs.getLast_updated_by());
			
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int insertPost(String formname, blog post) {
		// TODO Auto-generated method stub
		int flag = 0;

		String q = DbQueryConstants.insertBlog;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, post.getSoc_id());
			ps.setString(2, post.getUsername());
			ps.setString(3, post.getUserid());
			ps.setString(4, post.getMessage());
			ps.setString(5, post.getImage());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public tran_user getMemberInfo(String memberid, String socname, String area, String city, String state) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.getMemberInfo;
		tran_user member = new tran_user();
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, memberid);
			ps.setString(2, socname);
			ps.setString(3, area);
			ps.setString(4, city);
			ps.setString(5, state);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				member.setMember_id(rs.getString("member_id"));
				member.setPhone_no(rs.getString("phone_no"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				System.out.println(member.getName()+member.getEmail());
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return member;
	}

	@Override
	public int insertUserMaintainance(tran_maintainance m) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.insertUserMaintainance;

		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, m.getSoc_id());
			ps.setString(2, m.getSoc_name());
			ps.setString(3, m.getSoc_email());
			ps.setString(4, m.getSoc_address());
			ps.setString(5, m.getSoc_address2());
			ps.setString(6, m.getSoc_address3());
			ps.setString(7, m.getSoc_pincode());
			ps.setString(8, m.getMember_id());
			ps.setString(9, m.getMember_name());
			ps.setString(10, m.getMember_email());
			ps.setString(11, m.getCleaner_charge());
			ps.setString(12, m.getWatchman_charge());
			ps.setString(13, m.getLift_maintainance_charge());
			ps.setString(14, m.getWatertank_cleaner_charge());
			ps.setString(15, m.getPrice_per_unit());
			ps.setString(16, m.getUnit());
			ps.setString(17, m.getWater_usage_charge());
			ps.setString(18, m.getExtra_expense());
			ps.setString(19, m.getTotal_amount());
			ps.setString(20, m.getStatus());
			ps.setDate(21, m.getGenerated_date());
			ps.setDate(22, m.getDue_date());
			ps.setString(23, m.getEntered_by());
			ps.setString(24, m.getLast_updated_by());
			
			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public tran_maintainance getMaintainaceInfo(String memberemail,int id) {
		// TODO Auto-generated method stub
		tran_maintainance m=new tran_maintainance();
		String q = DbQueryConstants.getMaintainanceDetails;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, memberemail);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m.setInvoice_id(rs.getString("invoice_id"));
				m.setSoc_name(rs.getString("soc_name"));
				m.setSoc_email(rs.getString("soc_email"));
				m.setSoc_address(rs.getString("soc_address"));
				m.setSoc_address2(rs.getString("soc_address2"));
				m.setSoc_address3(rs.getString("soc_address3"));
				m.setSoc_id(rs.getString("soc_id"));
				m.setSoc_pincode(rs.getString("soc_pincode"));
				m.setMember_id(rs.getString("member_id"));
				m.setMember_email(rs.getString("member_email"));
				m.setMember_name(rs.getString("member_name"));
				m.setCleaner_charge(rs.getString("cleaner_charge"));
				m.setWatchman_charge(rs.getString("watchman_charge"));
				m.setDue_date(rs.getDate("due_date"));
				m.setExtra_expense(rs.getString("extra_expense"));
				m.setGenerated_date(rs.getDate("generated_date"));
				m.setLift_maintainance_charge(rs.getString("lift_maintainance_charge"));
				m.setPrice_per_unit(rs.getString("price_per_unit"));
				m.setTotal_amount(rs.getString("total_amount"));
				m.setStatus(rs.getString("status"));
				m.setUnit(rs.getString("unit"));
				m.setWater_usage_charge(rs.getString("water_usage_charge"));
				m.setWatertank_cleaner_charge(rs.getString("watertank_cleaner_charge"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return m;
	}

	@Override
	public ArrayList<tran_maintainance> getAllMaintainaceInfo(String memberemail) {
		// TODO Auto-generated method stub
		ArrayList<tran_maintainance> allmaintainance=new ArrayList<tran_maintainance>();
		
		String q = DbQueryConstants.getAllMaintainanceDetails;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, memberemail);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tran_maintainance m=new tran_maintainance();
				m.setInvoice_id(rs.getString("invoice_id"));
				m.setSoc_id(rs.getString("soc_id"));
				m.setDue_date(rs.getDate("due_date"));
				m.setGenerated_date(rs.getDate("generated_date"));
				m.setTotal_amount(rs.getString("total_amount"));
				m.setStatus(rs.getString("status"));
				allmaintainance.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return allmaintainance;
	}
	
	@Override
	public int updateState(mst_state s) {
			String q = "update mst_state set state_name=?,last_updated_by=?,last_updated_on='"+DbTransactionImpl.entered_on()+"' where state_id=?";
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(q);

				ps.setString(1, s.getState_name());
				ps.setString(2, s.getLast_updated_by());
				ps.setString(3, s.getState_id());

				flag = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;

	}
	
	@Override
	public int updateCity(mst_mst_city c) {
			String q = "update mst_mst_city set city_name=?,last_updated_by=?,last_updated_on='"+DbTransactionImpl.entered_on()+"' where city_name=?";
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(q);

				ps.setString(1, c.getCity_name());
				ps.setString(2, c.getLast_update_by());
				ps.setString(3, c.getState_name());

				flag = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	@Override
	public int updateArea(mst_mst_mst_area a) {
			String q = "update mst_mst_mst_area set area_name=?,pincode=?,last_updated_by=?,last_updated_on='"+DbTransactionImpl.entered_on()+"' where area_name=?";
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(q);

				ps.setString(1, a.getArea_name());
				ps.setString(2, a.getPincode());
				ps.setString(3, a.getLastupdate_by());
				ps.setString(3, a.getCity_name());

				flag = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	@Override
	public int updateRole(mst_role r) {
			String q = "update mst_role set role_name=?,last_updated_by=?,last_updated_on='"+DbTransactionImpl.entered_on()+"' where role_name=?";
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(q);

				ps.setString(1, r.getRole_name());
				ps.setString(2, r.getLast_update_by());
				ps.setString(3, r.getRole_id());

				flag = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	@Override
	public int updateID(mst_id_type i) {
			String q = "update mst_id_type set id_type=?,last_updated_by=?,last_updated_on='"+DbTransactionImpl.entered_on()+"' where id_type=?";
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(q);

				ps.setString(1, i.getId_type());
				ps.setString(2, i.getLastupdate_by());
				ps.setString(3, i.getId_id());

				flag = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	@Override
	public ArrayList<contact_us> getContactus() {
		// TODO Auto-generated method stub
		ArrayList<contact_us> getContacts = new ArrayList<contact_us>();
		String q = DbQueryConstants.getContactus;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				contact_us contact = new contact_us();

				contact.setF_name(rs.getString("f_name"));
				contact.setL_name(rs.getString("l_name"));
				contact.setEmail(rs.getString("email"));
				contact.setMessage(rs.getString("message"));
				contact.setPhone(rs.getString("phone"));
				
				getContacts.add(contact);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return getContacts;
	}
	
	@Override
	public int deleteservice(String formname, String serviceid) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteService;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, serviceid);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int updateService(mst_service s) {
			String q = "update mst_service set service_type=?,last_updated_by=?,last_updated_on='"+DbTransactionImpl.entered_on()+"' where service_type=?";
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(q);

				ps.setString(1, s.getService_type());
				ps.setString(2, s.getLastupdate_by());
				ps.setString(3, s.getService_id());

				flag = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	@Override
	public int insertSecurityGuard(String formname, mst_security_guard security, String name) {
		int flag = 0;
		String q = DbQueryConstants.insertSecurityGuard;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, security.getSoc_id());
			ps.setString(2, security.getName());
			ps.setString(3, security.getPhone_no());
			ps.setString(4, security.getEmail());
			ps.setString(5, security.getGender());
			ps.setString(6, security.getId_proof());
			ps.setString(7, security.getId_number());
			ps.setString(8, security.getPassword());
			ps.setString(9, name);
			ps.setString(10, name);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteAmenities(String id) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteAmenities;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, id);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteSecurity(String email) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteSecurity;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, email);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int deleteSecurityRg(String email) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteSecurityRg;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, email);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	@Override
	public int updateAmenities(mst_amenities a) {
			String q = "update mst_amenities set amenities_name=?,rent=?,last_updated_by=?,last_updated_on='"+DbTransactionImpl.entered_on()+"' where amenities_id=?";
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(q);

				ps.setString(1, a.getAmenities_name());
				ps.setString(2, a.getRent());
				ps.setString(3, a.getLast_update_by());
				ps.setString(4, a.getAmenities_id());

				flag = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flag;
	}
	
	@Override
	public int updateExpense(mst_expense e) {
			String q = "update mst_expense set exp_type=?,price=?,last_updated_by=?,last_updated_on='"+DbTransactionImpl.entered_on()+"' where exp_id=?";
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(q);

				ps.setString(1, e.getExp_type());
				ps.setString(2, e.getPrice());
				ps.setString(3, e.getLast_update_by());
				ps.setString(4, e.getExp_id());

				flag = ps.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return flag;
	}
	
	@Override
	public int deleteNotice(String id) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteNotice;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, id);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public String getSecretaryEmail(String email) {
		String mail = null;
		String q = DbQueryConstants.getSecretaryEmail;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mail = rs.getString("email");
			}
			System.out.println("Secretary email:" + mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mail;
	}
	/**
	 * getting the info for the OUTintg the Visitor
	 */

	@Override
	public ArrayList<visitor_details> getValuesForOUT(String soc_id) {
		// TODO Auto-generated method stub
		ArrayList<visitor_details> getOUTDetails =new ArrayList<visitor_details>();
		String q=DbQueryConstants.getOUTDetails;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, soc_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				visitor_details visit=new visitor_details();
				
				visit.setOptions(rs.getString("options"));
				visit.setName(rs.getString("name"));
				visit.setPhone_number(rs.getString("phone_no"));
				visit.setVehical_number(rs.getString("vehical_no"));
				visit.setHouse_number(rs.getString("house_no"));
				visit.setMember_name(rs.getString("member_name"));
				visit.setIn_time_with_date(rs.getString("in_time"));
				visit.setPurpose(rs.getString("purpose"));
				
				getOUTDetails.add(visit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getOUTDetails;
	}

	@Override
	public ArrayList<visitor_details> getVisitorMember(String soc_id) {
		// TODO Auto-generated method stub
		ArrayList<visitor_details> getOUTDetails =new ArrayList<visitor_details>();
		String q=DbQueryConstants.getvisitormember;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, soc_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				visitor_details visit=new visitor_details();
				
				visit.setOptions(rs.getString("options"));
				visit.setName(rs.getString("name"));
				visit.setPhone_number(rs.getString("phone_no"));
				visit.setVehical_number(rs.getString("vehical_no"));
				visit.setHouse_number(rs.getString("house_no"));
				visit.setMember_name(rs.getString("member_name"));
				visit.setIn_time_with_date(rs.getString("in_time"));
				visit.setOut_time_with_date(rs.getString("out_time"));
				visit.setPurpose(rs.getString("purpose"));
				
				getOUTDetails.add(visit);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getOUTDetails;
	}
	
	@Override
	public int insertvisitordetails(String formname, visitor_details visite, String GuardName) {
		// int falg = 0;
		String q = DbQueryConstants.insertVisitorDetails;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, visite.getSoc_id());
			ps.setString(2, visite.getOptions());
			ps.setString(3, visite.getName());
			ps.setString(4, visite.getPhone_number());
			ps.setString(5, visite.getVehical_number());
			ps.setString(6, visite.getHouse_number());
			ps.setString(7, visite.getMember_name());
			ps.setString(8, visite.getPurpose());
			ps.setString(9, GuardName);
			ps.setString(10, GuardName);

			flag = ps.executeUpdate();
			String result = flag == 1 ? "Success" : "Failed";
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int updateouttime(String formname, visitor_details visit) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.updateOutTime;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			
			ps.setString(1, visit.getIn_time_with_date());
			ps.setString(2, visit.getVehical_number());
			ps.setString(3, visit.getName());
			ps.setString(4, visit.getSoc_id());

			System.out.println(visit.getName()+" IN TIME..."+visit.getVehical_number()+visit.getIn_time_with_date());
			System.out.println(visit.getSoc_id()+"SOC ID THAT");
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("IN Method Exception"+e);
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
	}
	
	@Override
	public ArrayList<mst_security_guard> getAllSecurity(String socid) {
		// TODO Auto-generated method stub
		ArrayList<mst_security_guard> getSecurityInfo = new ArrayList<mst_security_guard>();
		String q = DbQueryConstants.getSecurity;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mst_security_guard sg = new mst_security_guard();
				sg.setId(rs.getString("secu_id"));
				sg.setEmail(rs.getString("email"));
				sg.setPhone_no(rs.getString("phone_no"));
				sg.setName(rs.getString("name"));
				getSecurityInfo.add(sg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getSecurityInfo;
	}
	
	@Override
	public int deleteSoc(String email) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deletesoc;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, email);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public int deleteReg(String email) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deletereg;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, email);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public int deleteWorker(String email) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteworker;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, email);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public int deleteuser(String email) {
		// TODO Auto-generated method stub
		String q = DbQueryConstants.deleteuser;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);

			ps.setString(1, email);

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public ArrayList<String> getWorkerDetails(String email) {
		ArrayList<String> getWorDetails = new ArrayList<String>();
		String q = DbQueryConstants.getWorDetails;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getWorDetails.add(rs.getString("w_name"));
				getWorDetails.add(rs.getString("w_email"));
				getWorDetails.add(rs.getString("w_phone"));
				getWorDetails.add(rs.getString("w_gender"));
				getWorDetails.add(rs.getString("available_from"));
				getWorDetails.add(rs.getString("available_to"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getWorDetails;
	}

	@Override
	public ArrayList<String> getUserDetails(String email) {
		// TODO Auto-generated method stub
		ArrayList<String> getUserDetails = new ArrayList<String>();
		String q = DbQueryConstants.getUserDetails;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getUserDetails.add(rs.getString("name"));
				getUserDetails.add(rs.getString("email"));
				getUserDetails.add(rs.getString("phone_no"));
				getUserDetails.add(rs.getString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getUserDetails;
	}
	/**
	 * method for inserting chats
	 */
	@Override
	public int insertChat(chatApplication chat) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.insertChatMsg;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, chat.getSoc_id());
			ps.setString(2, chat.getName());
			ps.setString(3, chat.getEmail());
			ps.setString(4, chat.getMsg());
			ps.setString(5, chat.getName());
			ps.setString(6, chat.getName());

			System.out.println("Insert method Socid" + chat.getSoc_id());
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ArrayList<RequestServices> getCompletedWork(String email) {
		// TODO Auto-generated method stub
		ArrayList<RequestServices> getDetails=new ArrayList<RequestServices>();
		String q=DbQueryConstants.getComplatedWork;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RequestServices reqs = new RequestServices();
				reqs.setUser_name(rs.getString("user_name"));
				reqs.setAddress(rs.getString("address"));
				reqs.setUser_phone(rs.getString("user_phone"));
				reqs.setUser_email(rs.getString("user_email"));
				reqs.setProb_desc(rs.getString("prob_desc"));
				reqs.setReqservice_date(rs.getString("reqservice_date"));
				reqs.setReqservice_time_from(rs.getString("reqservice_time_from"));
				reqs.setReqservice_time_to(rs.getString("reqservice_time_to"));
				getDetails.add(reqs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDetails;
	}
	@Override
	public ArrayList<RequestServices> getLeftWork(String email) {
		// TODO Auto-generated method stub
		ArrayList<RequestServices> getDetails=new ArrayList<RequestServices>();
		String q=DbQueryConstants.getLeftWork;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RequestServices reqs = new RequestServices();
				reqs.setUser_name(rs.getString("user_name"));
				reqs.setAddress(rs.getString("address"));
				reqs.setUser_phone(rs.getString("user_phone"));
				reqs.setUser_email(rs.getString("user_email"));
				reqs.setProb_desc(rs.getString("prob_desc"));
				reqs.setReqservice_date(rs.getString("reqservice_date"));
				reqs.setReqservice_time_from(rs.getString("reqservice_time_from"));
				reqs.setReqservice_time_to(rs.getString("reqservice_time_to"));
				getDetails.add(reqs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDetails;
	}

	@Override
	public int updateDecline(RequestServices reqs) {
		int flag = 0;
		String q = DbQueryConstants.updateDecline;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);
			
			System.out.println("reqs.getUser_email() is" + reqs.getUser_email());
			System.out.println("date is" + reqs.getReqservice_date());
			System.out.println("Time is" + reqs.getReqservice_time_from());
			
			ps.setString(1, "Decline");
			ps.setString(2, reqs.getUser_email());
			ps.setString(3, reqs.getReqservice_date());
			ps.setString(4, reqs.getReqservice_time_from());
			
			flag = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return flag;
	}

	@Override
	public ArrayList<RequestServices> getDeclineWork(String email) {
		ArrayList<RequestServices> getDetails=new ArrayList<RequestServices>();
		
		String q=DbQueryConstants.getDeclineWork;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				RequestServices reqs = new RequestServices();
				reqs.setUser_name(rs.getString("user_name"));
				reqs.setAddress(rs.getString("address"));
				reqs.setUser_phone(rs.getString("user_phone"));
				reqs.setUser_email(rs.getString("user_email"));
				reqs.setProb_desc(rs.getString("prob_desc"));
				reqs.setReqservice_date(rs.getString("reqservice_date"));
				reqs.setReqservice_time_from(rs.getString("reqservice_time_from"));
				reqs.setReqservice_time_to(rs.getString("reqservice_time_to"));
				getDetails.add(reqs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDetails;
	}
	/**
	 * inserting scheduling the Worker Services
	 */
	@Override
	public int scheduleService(String email, RequestServices reqs) {
		int flag = 0;
		String reqID = null;
		String worID = null;
		String service = null;
		String q1 = DbQueryConstants.getreqSerID;
		PreparedStatement ps1;
		try {
			System.out.println("in TRY");
			ps1 = con.prepareStatement(q1);
			ps1.setString(1, reqs.getUser_email());
			ps1.setString(2, reqs.getReqservice_date());
			ps1.setString(3, reqs.getReqservice_time_from());

			System.out.println(reqs.getUser_email());
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				reqID = rs.getString("reqservice_id");
				System.out.println("REQ ID" + reqID);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
			e1.printStackTrace();
		}
		String q2 = DbQueryConstants.getworid;
		try {
			PreparedStatement ps2 = con.prepareStatement(q2);
			ps2.setString(1, reqs.getW_email());
			ResultSet rs1 = ps2.executeQuery();
			while (rs1.next()) {
				worID = rs1.getString("worker_id");
				service = rs1.getString("service_type");
			}
		} catch (SQLException e2) {
			System.out.println(e2);
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String q = DbQueryConstants.scheduleService;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, service);
			ps.setString(2, reqID);
			ps.setString(3, worID);
			ps.setString(4, reqs.getW_email());
			ps.setString(5, reqs.getReqservice_date());
			ps.setString(6, reqs.getReqservice_time_from());
			ps.setString(7, reqs.getW_name());
			ps.setString(8, reqs.getW_name());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public ArrayList<RequestServices> getServiceForSchedule(String email) {
		ArrayList<RequestServices> getServiceReq = new ArrayList<RequestServices>();
		String q = DbQueryConstants.getServiceSchedule;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RequestServices reqs = new RequestServices();

				reqs.setUser_name(rs.getString("user_name"));
				reqs.setAddress(rs.getString("address"));
				reqs.setProb_desc(rs.getString("prob_desc"));
				reqs.setUser_phone(rs.getString("user_phone"));
				reqs.setReqservice_time_from(rs.getString("schedule_time"));
				reqs.setUser_email(rs.getString("user_email"));
				reqs.setReqservice_date(rs.getString("reqservice_date"));
				getServiceReq.add(reqs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getServiceReq;
	}
	@Override
	public int updateRequest(RequestServices reqs) {
		int flag = 0;
		String q = DbQueryConstants.updateRequestService;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, reqs.getUser_email());
			ps.setString(2, reqs.getReqservice_date());
			ps.setString(3, reqs.getReqservice_time_from());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int updateScheduleOnWay(RequestServices reqs) {
		int flag = 0;
		String q = DbQueryConstants.updateScheduleOnWay;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			
			System.out.println("reqs.getUser_email() is" + reqs.getUser_email());
			System.out.println("date is" + reqs.getReqservice_date());
			System.out.println("Time is" + reqs.getReqservice_time_from());
			
			ps.setString(1, reqs.getUser_email());
			ps.setString(2, reqs.getReqservice_date());
			ps.setString(3, reqs.getReqservice_time_from());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * @Override public int updateScheduleReach(RequestServices reqs) { int flag =
	 * 0; String q = DbQueryConstants.updateScheduleReach; PreparedStatement ps; try
	 * { ps = con.prepareStatement(q); ps.setString(1, reqs.getUser_email());
	 * ps.setString(2, reqs.getReqservice_date()); ps.setString(3,
	 * reqs.getReqservice_time_from()); flag = ps.executeUpdate(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return flag; }
	 * 
	 * @Override public int updateScheduleCheckOut(RequestServices reqs) { // TODO
	 * Auto-generated method stub int flag = 0; String q =
	 * DbQueryConstants.updateScheduleCheckOut; PreparedStatement ps; try { ps =
	 * con.prepareStatement(q); ps.setString(1, reqs.getUser_email());
	 * ps.setString(2, reqs.getReqservice_date()); ps.setString(3,
	 * reqs.getReqservice_time_from()); flag = ps.executeUpdate(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return flag; }
	 */
	@Override
	public int updateScheduleCancle(RequestServices reqs) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.updateScheduleCancle;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, reqs.getUser_email());
			ps.setString(2, reqs.getReqservice_date());
			ps.setString(3, reqs.getReqservice_time_from());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int removeonCancle(RequestServices reqs) {
		int flag = 0;
		String q = DbQueryConstants.removeOnCancle;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, reqs.getUser_email());
			ps.setString(2, reqs.getReqservice_date());
			ps.setString(3, reqs.getReqservice_time_from());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * Implements methods for the update DATA
	 */

	@Override
	public int updateRegistrationData(String formname, registration_page registration) {
		int flag = 0;
		String q = DbQueryConstants.update_admin_profile;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, registration.getUsername());
			ps.setString(2, registration.getContact_no());
			ps.setString(3, registration.getGender());
			ps.setString(4, registration.getEmail_id());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int updateMst_SocietyData(String formname, mst_society soc) {
		int flag = 0;
		String q = DbQueryConstants.update_mst_society;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, soc.getName());
			ps.setString(2, soc.getPhone_no());
			ps.setString(3, soc.getGender());
			ps.setString(4, soc.getEmail());
			
			flag = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public int updateWorkerProfile(String formname, tran_worker wor) {
		int flag = 0;
		String q = DbQueryConstants.updateWorkerProfile;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, wor.getW_name());
			ps.setString(2, wor.getW_phone());
			ps.setString(3, wor.getW_gender());
			ps.setString(4, wor.getAvailable_from());
			ps.setString(5, wor.getAvailable_to());
			ps.setString(6, wor.getW_email());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int updateMemberProfile(tran_user mem) {
		// TODO Auto-generated method stub
		int flag = 0;
		String q = DbQueryConstants.updateUserProfile;
		try {
			System.out.println("Name :"+mem.getName());
			System.out.println("Phone :"+mem.getPhone_no());
			System.out.println("Gender :"+mem.getGender());
			System.out.println("Email :"+mem.getEmail());
			
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, mem.getName());
			ps.setString(2, mem.getPhone_no());
			ps.setString(3, mem.getGender());
			ps.setString(4, mem.getEmail());

			flag = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

@Override
public int updatePayment(Date date,String email) {
	// TODO Auto-generated method stub
	String q = DbQueryConstants.payment_success;
	PreparedStatement ps = null;
	
	try {
		ps = con.prepareStatement(q);
		/*
		 * ps.setString(1, city.getState_id()); ps.setString(1, city.getState_name());
		 */
		ps.setDate(1, date);
		// ps.setString(2, city.getCity_id());
		ps.setString(2, email);
		System.out.println(q);
		flag = ps.executeUpdate();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
}
}