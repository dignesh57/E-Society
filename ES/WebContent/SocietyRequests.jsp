<%@page import="com.es.model.register_society"%>
<%@page import="com.es.model.tran_req_services"%>
<%@page import="com.es.model.mst_status"%>
<%@page import="com.es.formDesignUltility.ReportConstant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeaderParam"%>
<%@page import="com.es.formDesignUltility.HtmlReportHeaderDesign"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=FormFieldUltilityconstant.webConstant%></title>
</head>
<body>
<%registration_page rg=(registration_page)session.getAttribute("user"); 
if(rg.getRole_name().equalsIgnoreCase("Admin")){
%>
	<%
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		DbTransction dbt = new DbTransactionImpl();
		//tran_req_services reqservices = new tran_req_services();
		ArrayList<register_society> getSociety = dbt.getRequestedSociety();

		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<!-- Stats -->
			<div class="outer-w3-agile col-xl">
				<div class="work-progres">

					<form action="RequestedSocietyController" method="post">
						<div class="table-responsive">
							<table class="table table-striped" class="table table-responsive">
								<tbody>
									<tr class="<%=hth.getSocietyRequest().getTableClass()%>">
										<th style="color: black;"><b><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getSocietyRequest(),
					ReportConstant.societyReq, dbts.getRequestedSocietyCount())%></b></th>
									</tr>
									<%
										for (int i = 0; i < getSociety.size(); i++) {
											register_society regSociety = dbt.getRequestedSociety().get(i);
									%>
									<tr>
										<td><%=regSociety.getRole()%></td>
										<td><%=regSociety.getSociety_name()%></td>
										<td><%=regSociety.getSociety_type()%></td>

										<td><%=regSociety.getAddress()%></td>

										<td><%=regSociety.getLandmark()%></td>

										<td><%=regSociety.getArea()%></td>

										<td><%=regSociety.getCity()%></td>

										<td><%=regSociety.getState()%></td>
										<td><%=regSociety.getPincode()%></td>

										<td><%=regSociety.getName_of_wings()%></td>

										<td><%=regSociety.getTotal_number_of_house()%></td>

										<td><%=regSociety.getName()%></td>

										<td><%=regSociety.getEmail()%></td>

										<td><%=regSociety.getPhone_no()%></td>

										<td><%=regSociety.getGender()%></td>

										<td><%=regSociety.getId_proof()%></td>

										<td><%=regSociety.getId_number()%></td>

										<td><a
											href="Society Images/<%=regSociety.getId_upload()%>"
											style="color: blue"><%=regSociety.getId_upload()%></a></td>

										<td colspan="2" style="text-align: center;"><button
												class="btn btn-link" type="submit" value="<%=regSociety.getEmail()%>"
												name="action" id="<%=i%>"
												formname=<%=FormFieldUltilityconstant.register_society_name%>>
												<i class="fa fa-check" style="color: green; !important"></i>
											</button></td>

										<td colspan="2" style="text-align: center;"><button
												class="btn btn-link" type="submit" value="<%=regSociety.getEmail()%>"
												name="action1" id="<%=i%>"
												formname=<%=FormFieldUltilityconstant.register_society_name%>>
												<i class="fa fa-times" style="color: red; !important"></i>
											</button></td>
										<%
											}
										%>
									</tr>
								</tbody>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>