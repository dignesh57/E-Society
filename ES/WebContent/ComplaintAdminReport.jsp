<%@page import="com.es.model.tran_complain"%>
<%@page import="com.es.model.mst_society"%>
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
<meta charset="ISO-8859-1">
<title><%=FormFieldUltilityconstant.webConstant%></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Modernize Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />

<!-- Style-sheets -->
<!-- Bootstrap Css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Bootstrap Css -->
<!-- Common Css -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--// Common Css -->
<!-- Fontawesome Css -->
<link href="css/fontawesome-all.css" rel="stylesheet">
<!--// Fontawesome Css -->
<!--// Style-sheets -->

<!--web-fonts-->
<link href="//fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">
</head>
<body>
<%registration_page rg=(registration_page)session.getAttribute("user"); 
if(rg.getRole_name().equalsIgnoreCase("Admin")){
%>
	<%
		DbTransction dbt = new DbTransactionImpl();
		DbTransactionServices dbts = new DbTransactionServicesImpl();
	%>

	<jsp:include page="header.jsp"></jsp:include>
	<%
		HtmlTableHeader hth = new HtmlTableHeader();
	%>
		<div class="container-fluid">
		<div class="row">
			<!-- Stats -->
			<div class="outer-w3-agile col-xl">
				<div class="work-progres">

					
		<form action="">
		
			<table class="table table-striped" class="table table-responsive">
				<%-- <tr>
				<%
					for (int i = 0; i < hth.getUserReoprt().getFirstRow().size(); i++) {
				%>
				<th><%=%></th>
				<%
					}
				%>
			</tr> --%>
			<tbody>
				<tr class="<%=hth.getComplaint().getTableClass()%>">
					<th><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.secComplaintDetails(),
					ReportConstant.complaintAdmin,dbts.getComplainCount())%></th>
				</tr>
			
				<%
					for (int i = 0; i < dbt.getAdminComplaintData().size(); i++) {
						tran_complain complain=dbt.getAdminComplaintData().get(i);
				%>
				<tr>
					<td><%=i+1 %></td>
					<td><%=complain.getName()%></td>
					<td><%=complain.getUser_id()%></td>
					<td><%=complain.getComplain_type()%></td>
					<td><%=complain.getComplain_description()%></td>
					<td><a href="Society Images/complaintdocs/<%=complain.getDocument()%>"
							style="color: blue"><%=complain.getDocument()%></a></td>
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</form>
	</div>
	</div>
	</div>
	</div>
	<!-- <div id="pg1">
		<form action="">
			<table>
			</table>
		</form>
	</div>
 -->
	<%-- <div align="center">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#1st">Previous</a></li>
				<%
					for (int i = 1; i <= dbts.pagination(dbts.getUserCount()); i++) {
				%>
				<li class="page-item"><a class="page-link" href="#pgtn"><%=i%></a></li>
				<%
					}
				%>
				<li class="page-item"><a class="page-link" href="#2nd">Next</a></li>
			</ul>
		</nav>
	</div>
 --%>
	<div class="row">
		<div class="col-md-12">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>