package com.es.formDesignUltility;

import java.util.ArrayList;

public class HtmlTableHeader {

	public static final HtmlTableHeaderParam SocietyMember() {

		ArrayList<HtmlTable> firstRow = new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center", "Role");
		HtmlTable col2 = new HtmlTable("", "1", "1", "text-center", "Member ID");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Name");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Email ID");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "Contact No");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Gender");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "ID Proof");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "ID Number");
		HtmlTable col9 = new HtmlTable("", "1", "1","text-center", "ID Upload");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		firstRow.add(col9);
		
		HtmlTableHeaderParam table = new HtmlTableHeaderParam("", "table table-striped", firstRow);
		return table;
	}
	public static final HtmlTableHeaderParam getUserRequest() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Status");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Worker's Name");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Service");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "User ID");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "Society Name");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Wing Name");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "House No");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "Problem Discription");
		HtmlTable col9 = new HtmlTable("", "1", "1","text-center", "Date");
		HtmlTable col10 = new HtmlTable("", "1", "1","text-center", "Time from");
		HtmlTable col11 = new HtmlTable("", "1", "1","text-center", "To Time ");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		firstRow.add(col9);
		firstRow.add(col10);
		firstRow.add(col11);
		
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-striped", firstRow);
		return table1;
	}
	
	public static final HtmlTableHeaderParam getSocietyRequest() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Role");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Society Name");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Society Type");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Address");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "Landmark");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Area");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "City");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "State");
		HtmlTable col9 = new HtmlTable("", "1", "1","text-center", "Pincode");
		HtmlTable col10 = new HtmlTable("", "1", "1","text-center", "Wings");
		HtmlTable col11 = new HtmlTable("", "1", "1","text-center", "Total House");
		HtmlTable col12 = new HtmlTable("", "1", "1","text-center", "Name");
		HtmlTable col13 = new HtmlTable("", "1", "1","text-center", "Email");
		HtmlTable col14 = new HtmlTable("", "1", "1","text-center", "Phone No");
		HtmlTable col15 = new HtmlTable("", "1", "1","text-center", "Gender");
		HtmlTable col16 = new HtmlTable("", "1", "1","text-center", "Id Proof");
		HtmlTable col17 = new HtmlTable("", "1", "1","text-center", "Id Number");
		HtmlTable col18 = new HtmlTable("", "1", "1","text-center", "Id Upload");
	//	HtmlTable col19 = new HtmlTable("", "1", "1","text-center", "");
	//	HtmlTable col20 = new HtmlTable("", "1", "1","text-center", "");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		firstRow.add(col9);
		firstRow.add(col10);
		firstRow.add(col11);
		firstRow.add(col12);
		firstRow.add(col13);
		firstRow.add(col14);
		firstRow.add(col15);
		firstRow.add(col16);
		firstRow.add(col17);
		firstRow.add(col18);
	//	firstRow.add(col19);
	//	firstRow.add(col20);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-striped", firstRow);
		return table1;
	}
	
	public static final HtmlTableHeaderParam getWorkerRequest() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Role");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Service Type");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Description");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "name");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "email");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Address");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "Area");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "City");
		HtmlTable col9 = new HtmlTable("", "1", "1","text-center", "State");
		HtmlTable col10 = new HtmlTable("", "1", "1","text-center", "Pincode");
		HtmlTable col11 = new HtmlTable("", "1", "1","text-center", "phone_no");
		HtmlTable col12 = new HtmlTable("", "1", "1","text-center", "gender");
		HtmlTable col13 = new HtmlTable("", "1", "1","text-center", "Available From");
		HtmlTable col14 = new HtmlTable("", "1", "1","text-center", "Available To");
		HtmlTable col15 = new HtmlTable("", "1", "1","text-center", "id_proof");
		HtmlTable col16 = new HtmlTable("", "1", "1","text-center", "id_number");
		HtmlTable col17 = new HtmlTable("", "1", "1","text-center", "id_upload");
		//HtmlTable col18 = new HtmlTable("", "1", "1","text-center", "Click Me");
	//	HtmlTable col19 = new HtmlTable("", "1", "1","text-center", "Click Me");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		firstRow.add(col9);
		firstRow.add(col10);
		firstRow.add(col11);
		firstRow.add(col12);
		firstRow.add(col13);
		firstRow.add(col14);
		firstRow.add(col15);
		firstRow.add(col16);
		firstRow.add(col17);
		//firstRow.add(col18);
		//firstRow.add(col19);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-striped", firstRow);
		return table1;
	}
	public static final HtmlTableHeaderParam getContactus() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","No");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Fname");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Lname");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Email");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "Phone");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Message");
		
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
			
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-striped", firstRow);
		return table1;
	}
	public static final HtmlTableHeaderParam getMemberRequest() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Role");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "House No.");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Name");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Email");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "Phone No");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Gender");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "Id Proof");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "Id Number");
		HtmlTable col9 = new HtmlTable("", "1", "1","text-center", "Id Upload");
	//	HtmlTable col10 = new HtmlTable("", "1", "1","text-center", "Click Me");
	//	HtmlTable col11 = new HtmlTable("", "1", "1","text-center", "Click Me");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		firstRow.add(col9);
	//	firstRow.add(col10);
	//	firstRow.add(col11);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-striped", firstRow);
		return table1;
	}
	
	public static final HtmlTableHeaderParam getComplaint() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Role");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Complaint By");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Complaint Type");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Complaint Description");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-striped", firstRow);
		return table1;
	}
	
	public static final HtmlTableHeaderParam getServiceRequest() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Name");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Address");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Phone No");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "email");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "problem Description");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Service Date");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "Time From");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "Time To");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-striped", firstRow);
		return table1;
	}
	public static final HtmlTableHeaderParam visitorEntry() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Options");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Name");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Phone Number");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Vehical Number");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "House_No");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "In Time With Date");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "Purpose");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "Click");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-bordered", firstRow);
		return table1;
	}
	public static final HtmlTableHeaderParam visitorOutEntry() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Options");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Name");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Phone Number");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Vehical Number");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "House_No");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Member Name");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "In Time With Date");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "Purpose");
		HtmlTable col9= new HtmlTable("", "1", "1","text-center", "Click");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		firstRow.add(col9);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-bordered", firstRow);
		return table1;
	}
	
	public static final HtmlTableHeaderParam visitorMemberDetails() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Options");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Name");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Phone Number");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Vehical Number");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "House_No");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Member Name");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "In Time With Date");
		HtmlTable col8 = new HtmlTable("", "1", "1","text-center", "Out Time With Date");
		HtmlTable col9 = new HtmlTable("", "1", "1","text-center", "Purpose");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		firstRow.add(col8);
		firstRow.add(col9);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-bordered", firstRow);
		return table1;
	}
	
	public static final HtmlTableHeaderParam secComplaintDetails() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","No");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Name");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "User ID");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Complaint Type");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "Complaint Decription");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Document");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-bordered", firstRow);
		return table1;
	}
	
	public static final HtmlTableHeaderParam PendingMaintainance(){
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","No");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Memberid");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "Name");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Total Amount");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "Status");
		HtmlTable col6 = new HtmlTable("", "1", "1","text-center", "Generated Date");
		HtmlTable col7 = new HtmlTable("", "1", "1","text-center", "due-date");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		firstRow.add(col6);
		firstRow.add(col7);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-bordered", firstRow);
		return table1;
	}
	
	public static final HtmlTableHeaderParam getServiceSchedule	() {
		ArrayList<HtmlTable> firstRow= new ArrayList<HtmlTable>();
		HtmlTable col1 = new HtmlTable("", "1", "1", "text-center","Name");
		HtmlTable col2 = new HtmlTable("", "1", "1","text-center", "Address");
		HtmlTable col3 = new HtmlTable("", "1", "1","text-center", "problem Description");
		HtmlTable col4 = new HtmlTable("", "1", "1","text-center", "Phone No");
		HtmlTable col5 = new HtmlTable("", "1", "1","text-center", "Arriving Time");
		
		firstRow.add(col1);
		firstRow.add(col2);
		firstRow.add(col3);
		firstRow.add(col4);
		firstRow.add(col5);
		
		HtmlTableHeaderParam table1 = new HtmlTableHeaderParam("", "table table-bordered", firstRow);
		return table1;
	}

}
