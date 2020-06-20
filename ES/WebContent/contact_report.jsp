<%@page import="com.es.model.contact_us"%>
<%@page import="com.es.model.register_worker"%>
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
		ArrayList<contact_us> getContacts = dbt.getContactus();

		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<!-- Stats -->
			<div class="outer-w3-agile col-xl">
				<div class="work-progres">

						<div class="table-responsive">
							<table class="table table-striped">
								<tbody>
									<tr class="<%=hth.getWorkerRequest().getTableClass()%>">
										<th style="color: black;"><b><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getContactus(),
					ReportConstant.contactus, dbts.getRequestedWorkerCount())%></b></th>
									</tr>
									<%
										for (int i = 0; i < getContacts.size(); i++) {
											contact_us c = dbt.getContactus().get(i);
									%>
									<tr>
										<td><%=i+1%></td>
										<td><%=c.getF_name()%></td>
										<td><%=c.getL_name()%></td>
										<td><%=c.getEmail()%></td>
										<td><%=c.getPhone()%></td>
										<td><%=c.getMessage()%></td>
									</tr>
									<%
											}
									%>
								</tbody>
							</table>
						</div>
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