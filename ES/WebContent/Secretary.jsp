<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<%registration_page userData=(registration_page)session.getAttribute("user"); 
if(userData.getRole_name().equalsIgnoreCase("Secretary")){

DbTransactionServices dbts=new DbTransactionServicesImpl();%>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<div class="col-md-12">
		<!-- Stats -->
		<div>
			<div class="row">
				<div class="col-md-12">
					<br> <br>
					<div
						class="stat-grid p-3 d-flex align-items-center justify-content-between bg-primary">
						<div class="s-l">
							<a href="SocietyMemberReport.jsp"><h5>Member's Details</h5>
								<p class="paragraph-agileits-w3layouts text-white">View
									Details</p></a>
						</div>
						<div class="s-r">
							<h6>
								<%=dbts.getMemberCount(userData.getEmail_id())%> <i class="far fa-user"></i>
							</h6>
						</div>
					</div>
					<div
						class="stat-grid p-3 mt-3 d-flex align-items-center justify-content-between bg-danger">
						<div class="s-l">
							<a href="MemberRequests.jsp">
								<h5>Requested Member</h5>
								<p class="paragraph-agileits-w3layouts text-white">view
									details</p>
							</a>
						</div>
						<div class="s-r">
							<h6>
								<%=dbts.getRequestMemberCount(userData.getEmail_id()) %> <i class="fas fa-user-plus"></i>
							</h6>
						</div>
					</div>
					<div
						class="stat-grid p-3 mt-3 d-flex align-items-center justify-content-between bg-warning">
						<div class="s-l">
							<a href="Generate_Maintenance.jsp">
								<h5>Generate Maintenance</h5>
								<p class="paragraph-agileits-w3layouts text-white">view
									details</p>
							</a>
						</div>
						<div class="s-r">
							<h6>
								<i class="fas fa-tasks"></i>
							</h6>
						</div>
					</div>
					<div
						class="stat-grid p-3 mt-3 d-flex align-items-center justify-content-between bg-success">
						<div class="s-l">
						<a href="secsidecomplain.jsp">
							<h5>Complaints</h5>
							<p class="paragraph-agileits-w3layouts text-white">view
								details</p></a>
						</div>
						<div class="s-r">
							<h6>
								<i class="far fa-comment"></i>
							</h6>
						</div>
					</div>
				</div>
				<!-- banner -->
				<!-- <div class="col-md-6">
					<div class="banner_w3lspvt position-relative">
						<div class="container">
							<div class="d-md-flex">
								<div class="w3ls_banner_txt">
									<a href="User/extrapage/about.html"
										class="btn button-style mt-md-5 mt-4">Read More</a>
								</div>
								<div class="banner-img">
									<img src="images/IMG_5163.JPG" alt="" class="img-fluid">
								</div>
							</div>
						</div>
					</div>
				</div> -->
				<!-- banner -->
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>