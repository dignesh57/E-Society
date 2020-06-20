<%@page import="com.es.model.visitor_details"%>
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
if(rg.getRole_name().equalsIgnoreCase("Secretary")){
%>
	<%
		DbTransction dbt = new DbTransactionImpl();
		DbTransactionServices dbts = new DbTransactionServicesImpl();
	%>

	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<%
		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<div class="container-fluid">
	<div class="row">
                    <!-- Stats -->
                    <div class="outer-w3-agile col-xl">
                        <div class="work-progres">

		<form action="" method="post">
			<div class="table-responsive">
			<table class="table table-striped">
			<tbody>
				<tr class="<%=hth.SocietyMember().getTableClass()%>">
													<th style="text-align: center;"><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.visitorMemberDetails(),
					ReportConstant.visitorDetails, 0)%></th>
												</tr>
												<%  String socid = dbt.getSocietyID(rg.getEmail_id());
													ArrayList<visitor_details> getVisitorMember = dbt
															.getVisitorMember(socid);
													for (int i = 0; i < getVisitorMember.size(); i++) {
														visitor_details visit = getVisitorMember.get(i);
												%>
												<tr>
													<td><%=visit.getOptions()%></td>
													<td><%=visit.getName()%></td>
													<td><%=visit.getPhone_number()%></td>
													<td><%=visit.getVehical_number()%></td>
													<td><%=visit.getHouse_number()%></td>
													<td><%=visit.getMember_name()%></td>
													<td><%=visit.getIn_time_with_date()%></td>
													<td><%=visit.getOut_time_with_date()%></td>
													<td><%=visit.getPurpose()%></td>
												</tr>
												<%
													}
												%>
											</tbody>
			</table></div>
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
	</div> -->

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
	<div class="container-fluid">
         <div class="row">
            
         </div>
    </div>
			<jsp:include page="footer.jsp"></jsp:include>
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
}%>
</body>
</html>