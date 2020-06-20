<%@page import="com.es.model.tran_worker"%>
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
<%registration_page rg=(registration_page)session.getAttribute("user"); 
if(rg.getRole_name().equalsIgnoreCase("Admin")){
%>
<body>
	
	<%
		DbTransction dbt = new DbTransactionImpl();
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<!-- Stats -->
			<div class="outer-w3-agile col-xl">
				<div class="work-progres">

					
						<div id="pgtn" class="table-responsive">
							<table class="table table-striped">
								<tbody>
									<tr class="<%=hth.getWorkerRequest().getTableClass()%>">
										<th><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getWorkerRequest(), ReportConstant.worker,
					dbts.getRegisteredWorkerCount())%></th>
									</tr>
									<%
										for (int i = 0; i < dbt.getRegisteredWorkerData().size(); i++) {
											tran_worker worker = dbt.getRegisteredWorkerData().get(i);
									%>
									<tr>
									<form action="WorkerServicesController" method="post">
										<td><%=worker.getRole()%></td>
										<td><%=worker.getService_type()%></td>
										<td><%=worker.getService_desc()%></td>
										<td><%=worker.getW_name()%></td>
										<td><%=worker.getW_email()%></td>
										<td><%=worker.getAddress()%></td>
										<td><%=worker.getArea()%></td>
										<td><%=worker.getCity()%></td>
										<td><%=worker.getState()%></td>
										<td><%=worker.getPincode()%></td>
										<td><%=worker.getW_phone()%></td>
										<td><%=worker.getW_gender()%></td>
										<td><%=worker.getAvailable_from()%></td>
										<td><%=worker.getAvailable_to()%></td>
										<td><%=worker.getId_proof()%></td>
										<td><%=worker.getId_number()%></td>
										<td><%=worker.getId_upload()%></td>
										<td><button class="btn btn-link"
								type="submit" value="<%=worker.getW_email()%>" name="action1"
								id="<%=worker.getW_email()%>">
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

	
	<jsp:include page="footer.jsp"></jsp:include>
	
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>