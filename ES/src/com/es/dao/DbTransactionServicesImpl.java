package com.es.dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.es.dbutil.DbConnectionProvider;
import com.es.dbutil.DbConnectionProviderImpl;
import com.es.dbutil.DbQueryConstants;
import com.es.model.blog;
import com.es.model.mst_society;
import com.es.model.registration_page;
import com.es.model.tran_user;

public class DbTransactionServicesImpl implements DbTransactionServices {

	static DbConnectionProvider dbt = new DbConnectionProviderImpl();
	static Connection con = dbt.getConnetion();
	static DbTransactionServices dbts = new DbTransactionServicesImpl();

	@Override
	public int getStateCount() {
		int count=0;
		// TODO Auto-generated method stub
		String q=DbQueryConstants.getstateCount;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				count =rs.getInt("stateCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	
	@Override
	public int getSocCount() {
		int count = 0;
		String q = DbQueryConstants.getSocCount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("socCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int getSocCount(String city) {
		int count = 0;
		String q = DbQueryConstants.getSocCountCityWise;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("socCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int getAreaCount(String city) {
		int count = 0;
		String q = DbQueryConstants.getAreaCount;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("areaCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int getWorkerRequestCount() {
		int count = 0;
		String q = DbQueryConstants.getWorkerRequestCount;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("workerCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public int getWorkerCount() {
		int count = 0;
		String q = DbQueryConstants.getWorkerCount;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("workerCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int getRequestCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getComplainCount() {
		int count = 0;
		String q = DbQueryConstants.getComplainCount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("complainCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int getUserCount() {
		int count = 0;
		String q = DbQueryConstants.getUserCount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("userCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * Passing the data from userRegistration Pagination
	 */
	@Override
	public int pagination(int totalRecords) {
		int dataCount = totalRecords;
		int totalPage;
		int page = dataCount / 5;
		double inum;
		double fnum;
		inum = (double) page;
		System.out.println(inum + "INUM**************");
		fnum = page - inum;
		System.out.println("********FNUM" + fnum);
		if (inum == 0.0) {
			totalPage = page;
		} else {
			totalPage = page + 1;
		}
		System.out.println("TotalPage**************" + totalPage);
		return totalPage;
	}

	@Override
	public int pagination2(int totalRecords) {
		int dataCount = totalRecords;
		int totalPage = dataCount / 5;
		if(dataCount%5>0) {
			totalPage++;
		}
		System.out.println("TotalPage**************" + totalPage);
		return totalPage;
	}
	
	@Override
	public int requestCount() {
		int count = 0;
		String q = DbQueryConstants.getRequestCount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("requestCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * @return receive the data for user's pages
	 */

	@Override
	public ArrayList<String> getAmenities() {
		// TODO Auto-generated method stub
		ArrayList<String> getAmenitiesData = new ArrayList<String>();
		String q = DbQueryConstants.getAmenitieslist;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getAmenitiesData.add(rs.getString("amenities_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getAmenitiesData;
	}

	@Override
	public ArrayList<String> getAmenitiesBySocid(String socid) {
		// TODO Auto-generated method stub
		ArrayList<String> getAmenitiesData = new ArrayList<String>();
		String q = DbQueryConstants.getAmenitieslistbyid;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getAmenitiesData.add(rs.getString("amenities_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getAmenitiesData;
	}
	
	@Override
	public ArrayList<String> getComplain() {
// TODO Auto-generated method stub
		ArrayList<String> getComplaintData = new ArrayList<String>();
		String q = DbQueryConstants.getComplaintlist;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getComplaintData.add(rs.getString("comp_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getComplaintData;
	}

	@Override
	public ArrayList<String> getService() {
		// TODO Auto-generated method stub
		ArrayList<String> getServiceData = new ArrayList<String>();
		String q = DbQueryConstants.getServiceslist;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getServiceData.add(rs.getString("service_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return getServiceData;
	}

	@Override
	public ArrayList<String> getStatus() {
		ArrayList<String> getStatusDetails = new ArrayList<String>();
		String q = DbQueryConstants.getStatus;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getStatusDetails.add(rs.getString("status_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("In catch block" + e);
		}
		return getStatusDetails;
	}
	/*
	 * @Override public ArrayList<String> getSoc_Name() { ArrayList<String>
	 * getsonnme=new ArrayList<String>(); String q=DbQueryConstants.getSocName;
	 * return null; }
	 */

	@Override
	public ArrayList<String> getServiceWorker(String service) {
		ArrayList<String> getRelatedWorker = new ArrayList<String>();
		String q = DbQueryConstants.getRelateWorker;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, service);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getRelatedWorker.add(rs.getString("u_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getRelatedWorker;
	}
	@Override
	public ArrayList<String> getSocName() {
		ArrayList<String> getsocName=new ArrayList<String>();
		String q=DbQueryConstants.getsocName;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				getsocName.add(rs.getString("society_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getsocName;
	}
	public static String getSocName(String email) {
		String socName=null;
		String q=DbQueryConstants.getsocNameUser;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				socName=rs.getString("soc_name");
				System.out.println(socName);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socName;
	}
	
	public static String getMemberIdUser(String email) {
		String MemberId=null;
		String q=DbQueryConstants.getMemberIdUser;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MemberId=rs.getString("member_id");
				System.out.println(MemberId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return MemberId;
	}
	@Override
	public ArrayList<String> getSocWing() {
		ArrayList<String> getsocWing=new ArrayList<String>();
		String q=DbQueryConstants.getsocWing;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			//ps.setString(1, soc_name);
			//System.out.println(soc_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				getsocWing.add(rs.getString("name_of_wings"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getsocWing;
	}
	
	@Override
	public String getSocWingbysoc(String soc) {
		String getsocWing="";
		String q=DbQueryConstants.getsocWingbysoc;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, soc);
			//System.out.println(soc_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				getsocWing=rs.getString("name_of_wings");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getsocWing;
	}
	
	@Override
	public ArrayList<String> getCityforSelect(String state) {
		
		ArrayList<String> getCities=new ArrayList<String>();
		String q=DbQueryConstants.getCities;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, state);
			//System.out.println(soc_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				getCities.add(rs.getString("city_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getCities;
	}
	
	@Override
	public ArrayList<String> getAreaforSelect(String city) {
		
		ArrayList<String> getAreas=new ArrayList<String>();
		String q=DbQueryConstants.getAreas;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, city);
			//System.out.println(soc_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				getAreas.add(rs.getString("area_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getAreas;
	}
	@Override
	public ArrayList<String> getSocforSelect(String area) {
		
		ArrayList<String> getSoc=new ArrayList<String>();
		String q=DbQueryConstants.getSoc;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, area);
			//System.out.println(soc_name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				getSoc.add(rs.getString("society_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getSoc;
	}
	@Override
	public int insertTranWorker(String workerName) {
		/*
		 * int flag=0; String q=DbQueryConstants.tran_req_worker; try {
		 * System.out.println("In try block");
		 * 
		 * PreparedStatement ps=con.prepareStatement(q); ps.setString(1,
		 * serviceReq.getStatus()); ps.setString(2, serviceReq.getWorker_name());
		 * ps.setString(3, serviceReq.getService()); ps.setString(4,
		 * serviceReq.getUser_id()); ps.setString(5, serviceReq.getSociety_Name());
		 * ps.setString(6, serviceReq.getWing_Name()); ps.setString(7,
		 * serviceReq.getHouse_No()); ps.setString(8,
		 * serviceReq.getProblem_Discription()); ps.setString(9, serviceReq.getDate());
		 * ps.setString(10, serviceReq.getTime_from()); ps.setString(11,
		 * serviceReq.getTo_Tima());
		 * 
		 * flag=ps.executeUpdate(); } catch (SQLException e) { System.out.println(e); }
		 */
		return 0;
	}

	@Override
	public ArrayList<String> getVisitorName() {
		ArrayList<String> getVisitor=new ArrayList<String>();
		String q=DbQueryConstants.getVisitor;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				getVisitor.add(rs.getString("visitor_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getVisitor;
	}
	/**
	 * Implements methods for the update DATA
	 */

	@Override
	public int updateRegistrationData(String formname, registration_page registration) {
		int flag=0;
		String q=DbQueryConstants.update_admin_profile;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, registration.getUsername());
			ps.setString(2, registration.getContact_no());
			ps.setString(3, registration.getGender());
			ps.setString(4, registration.getEmail_id());
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * getting the report of Society Member
	 */
	@Override
	public ArrayList<tran_user> getSocMemberReport(String email) {
		// TODO Auto-generated method stub
		ArrayList<tran_user> getData=new ArrayList<tran_user>();
		String q=DbQueryConstants.getSocMemberReport;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				tran_user tr=new tran_user();
				
				System.out.println("IN WHILE");
				tr.setRole(rs.getString("role"));
				tr.setState(rs.getString("state"));
				tr.setCity(rs.getString("city"));
				tr.setArea(rs.getString("area"));
				tr.setSoc_name(rs.getString("soc_name"));
				tr.setWing(rs.getString("wing"));
				tr.setHouse_num(rs.getString("house_num"));
				tr.setHouse_type(rs.getString("house_type"));
				tr.setMember_id(rs.getString("member_id"));
				tr.setName(rs.getString("name"));
				tr.setEmail(rs.getString("email"));
				tr.setPhone_no(rs.getString("phone_no"));
				tr.setGender(rs.getString("gender"));
				tr.setId_proof(rs.getString("id_proof"));
				tr.setId_number(rs.getString("id_number"));
				tr.setId_upload(rs.getString("id_upload"));
				System.out.println("STATE:"+rs.getString("member_id"));
				getData.add(tr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getData;
	}
	public static int getPrice_pr_unit(String email) {
		int price=0;
		String q=DbQueryConstants.getprice_pr_unit;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				price=Integer.valueOf(rs.getString("price_pr_unit"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
	public static String getNameFromregi_page (String email) {
		String str=null;
		String q=DbQueryConstants.getNamefromemail;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				str=rs.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public int getMemberCount(String email) {
		int flag=0;
		String q=DbQueryConstants.getMembercount;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				flag=rs.getInt("memberCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int getRequestMemberCount(String email) {
		int flag=0;
		String q=DbQueryConstants.getRequestMemberCount;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				flag=rs.getInt("memberCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int getRegisteredSocietyCount() {
		// TODO Auto-generated method stub
		int count = 0;
		String q = DbQueryConstants.getRegisteredSocietyCount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("socCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int getRegisteredWorkerCount() {
		// TODO Auto-generated method stub
		int count = 0;
		String q = DbQueryConstants.getRegisteredWorkerCount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("workerCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int getRequestedSocietyCount() {
		// TODO Auto-generated method stub
		int count = 0;
		String q = DbQueryConstants.getRequestedSocietyCount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("socCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int getRequestedWorkerCount() {
		// TODO Auto-generated method stub
		int count = 0;
		String q = DbQueryConstants.getRequestedWorkerCount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("workerCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public String getMemberSocID(String email) {
		String socid="";
		String q=DbQueryConstants.getMemberSocID;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			ps.setString(2, email);
			ps.setString(3, email);
			ps.setString(4, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				socid=rs.getString("soc_id");
				System.out.println(socid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return socid;
	}
	
	@Override
	public ArrayList<blog> getAllPosts(String socid) {
		// TODO Auto-generated method stub
		ArrayList<blog> allPost=new ArrayList<blog>();
		String q=DbQueryConstants.getAllPosts;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				blog post=new blog();
				post.setPost_id(rs.getString("post_id"));
				post.setSoc_id(rs.getString("soc_id"));
				post.setUsername(rs.getString("username"));
				post.setUserid(rs.getString("userid"));
				post.setMessage(rs.getString("message"));
				post.setImage(rs.getString("image"));
				post.setEntered_on(rs.getString("entered_on"));
				
				allPost.add(post);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allPost;
	}
	
	@Override
	public boolean saveFile(InputStream is, String path) {
        boolean f = false;

        try {
            byte b[] = new byte[is.available()];

            is.read(b);

            FileOutputStream fos = new FileOutputStream(path);

            fos.write(b);

            fos.flush();
            fos.close();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
	}
	
	@Override
	public ArrayList<String> getSelectedDates(String type,String socid) {
		// TODO Auto-generated method stub
		ArrayList<String> dates=new ArrayList<String>();
		String q=DbQueryConstants.getAllDates;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, type);
			ps.setString(2, socid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				dates.add(rs.getString("reqamenities_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(dates.toString());
		return dates;
	}
	
	public static String getSocIdForVisitEntry(String email) {
		String soc_id="null";
		String q=DbQueryConstants.getSocidfromSecurityGuard;
		try {
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				soc_id=rs.getString("soc_id");
			}
			System.out.println("Soc_id for visitor"+soc_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soc_id;
	}
	
	public static String getMemberName(String memID) {
		// TODO Auto-generated method stub
		String memName=null;
		String q=DbQueryConstants.getMemberName;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, memID);
			System.out.println("Member Id is"+memID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				memName=rs.getString("name");
			}
			System.out.println("Member Name:"+memName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memName;
	}
	
	@Override
	public String getRentAmount(String type, String socid) {
		
		String amount=null;
		String q=DbQueryConstants.getAmount;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			ps.setString(1, socid);
			ps.setString(2, type);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				amount=rs.getString("rent");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
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
	
	/**
	 * getting the current status of the services for user
	 */
	public static ArrayList<String> getServiceStatus(String email) {
		ArrayList<String> status = new ArrayList<String>();
		String q = DbQueryConstants.getServiceStatus;
		try {
			PreparedStatement ps = con.prepareStatement(q);
			System.out.println("User EMail" +email);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status.add(rs.getString("service_type"));
				status.add(rs.getString("status"));

				System.out.println("SERV" + rs.getString("service_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public ArrayList<String> getMsg(String email) {
		// TODO Auto-generated method stub
		ArrayList<String> getMessage = new ArrayList<String>();
		String soc_id = getMemberSocID(email);
		String q = DbQueryConstants.getMsgForChat;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, soc_id);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				getMessage.add(rs.getString("name"));
				getMessage.add(rs.getString("msg"));
				System.out.println("MSG =" + rs.getString("msg"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getMessage;
	}

	@Override
	public ArrayList<String> getSendMsg(String email) {
		// TODO Auto-generated method stub
		ArrayList<String> getMessage = new ArrayList<String>();
		String soc_id = getMemberSocID(email);
		String q = DbQueryConstants.getSendMsgForChat;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(q);
			ps.setString(1, soc_id);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//getMessage.add(rs.getString("name"));
				getMessage.add(rs.getString("msg"));
				System.out.println("MSG =" + rs.getString("msg"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getMessage;
	}
}