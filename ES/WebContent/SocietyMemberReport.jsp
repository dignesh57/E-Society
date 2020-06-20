<%@page import="com.es.model.tran_user"%>
<%@page import="com.es.model.register_society"%>
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
<% registration_page userValue=(registration_page)session.getAttribute("user"); 
if(userValue.getRole_name().equalsIgnoreCase("Secretary")){
%>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<%
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		ArrayList<tran_user> userdata = dbts.getSocMemberReport(userValue.getEmail_id());
		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<div class="container-fluid">
		<div class="row">
			<!-- Stats -->
			<div class="outer-w3-agile col-xl">
				<div class="work-progres">

						<div class="table-responsive">

							<table
								class="table table-striped table table-responsive table-sm">
								<tbody>
									<tr class="<%=hth.SocietyMember().getTableClass()%>">
										<th><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.SocietyMember(), ReportConstant.report1, 0)%></th>
									</tr>

									<%
										for (int j = 0; j < userdata.size(); j++) {
											tran_user tr = userdata.get(j);
									%>
									<tr>
									<form action="RegisterMemberController" method="post">
										<td><%=tr.getRole()%></td>
										<td><%=tr.getMember_id()%></td>
										<td><%=tr.getName()%></td>
										<td><%=tr.getEmail()%></td>
										<td><%=tr.getPhone_no()%></td>
										<td><%=tr.getGender()%></td>
										<td><%=tr.getId_proof()%></td>
										<td><%=tr.getId_number()%></td>
										<td><%=tr.getId_upload()%></td>
										<td><button class="btn btn-link"
								type="submit" value="<%=tr.getEmail()%>" name="action1"
								id="<%=tr.getEmail()%>">
								<i class="fa fa-trash" style="color: red; !important"></i>
							</button>
						</td>
						</form>
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
