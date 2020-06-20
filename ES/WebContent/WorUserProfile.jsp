<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.tran_worker"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeader"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><%=FormFieldUltilityconstant.webConstant%></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet"
	href="User/vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="User/vendor/font-awesome/css/font-awesome.min.css">
<!-- Google fonts - Roboto + Roboto Slab-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,700%7CRoboto:400,700,300">
<!-- owl carousel-->
<link rel="stylesheet"
	href="User/vendor/owl.carousel/assets/owl.carousel.css">
<link rel="stylesheet"
	href="User/vendor/owl.carousel/assets/owl.theme.default.css">
<!-- animate.css-->
<link rel="stylesheet" href="User//vendor/animate.css/animate.css">
<!-- myOwn.css -->
<link rel="stylesheet" href="User//vendor/own.css/myOwn.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="User/css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="User/css/custom.css">
<!-- Leaflet CSS - For the map-->
<link rel="stylesheet" href="User/ajax/libs/leaflet/1.4.0/leaflet.css">
<!-- Favicon-->
<link rel="shortcut icon" href="User/img/favicon.png">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
<%
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
%>
<body>
	<%
		DbTransction dbt = new DbTransactionImpl();
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		HtmlTableHeader hth = new HtmlTableHeader();
		ArrayList<String> showDetails = null;
		if (userData.getRole_name().equalsIgnoreCase("Worker")) {
			showDetails = dbt.getWorkerDetails(userData.getEmail_id());
		} else if (userData.getRole_name().equalsIgnoreCase("Society Member")) {
			showDetails = dbt.getUserDetails(userData.getEmail_id());
		} else if (userData.getRole_name().equalsIgnoreCase("Security Guard")) {
			showDetails = dbt.getUserDetails(userData.getEmail_id());
		}
	%>

	<script type="text/javascript">
		function replaceDiv(target, source) {
			document.getElementById(target).innerHTML = document
					.getElementById(source).innerHTML;
		}
	</script>
	<%
		if (userData.getRole_name().equalsIgnoreCase("Worker")) {
	%>
	<jsp:include page="WorkerHeader.jsp"></jsp:include>
	<%
		} else if (userData.getRole_name().equalsIgnoreCase("Society Member")) {
	%>
	<jsp:include page="UserHeader.jsp"></jsp:include>
	<%
		}else if(userData.getRole_name().equalsIgnoreCase("Security Guard")){%>
	<jsp:include page="SecurityHeader.jsp"></jsp:include>
	<% }
	%>
	<div id="target">
		<section class="bg-gradient services-section">

			<div class="container">
				<form action="RequestServiceSchedule" method="post"
					data-animate="fadeInUp">
					<header class="main-title-w3layouts mb-2 text-center">
						<h4 data-animate="fadeInDown" class="title" style="margin-top: 50px; !important">My Profile</h4>
						<%
							for (int i = 0; i < showDetails.size(); i++) {
						%>
						<div class="col-md-6">
							<div class="span3" style="text-align: left;">
								<h5 data-animate="fadeInDown"><%=FormFieldUltilityconstant.workerProfile[i]%></h5>
								<%
									if (showDetails.get(i).equalsIgnoreCase(userData.getEmail_id())) {
								%>
								<input type="text" name="Email" value="<%=showDetails.get(i)%>"
									readonly="readonly" placeholder="<%=showDetails.get(i)%>"
									class="form-control">
								<%
									} else {
								%>
								<input type="text" required="required"
									name="<%=FormFieldUltilityconstant.workerProfile[i]%>"
									value="<%=showDetails.get(i)%>"
									placeholder="<%=showDetails.get(i)%>" class="form-control">
								<%
									}
								%>
							</div>
						</div>
						<%
							}
						%>
						<div class="col-md-12 text-center">
							<input type="submit" class="btn btn-outline-light link-scroll"
								name="action" value="Update" id="Update" formname="home.jsp">
						</div>
						<div class="col-md-12 text-center">
							<input type="submit" class="btn btn-outline-light link-scroll"
								name="action" value="Change Password" id="PassChange"
								formname="home.jsp">
						</div>
					</header>
				</form>
			</div>
		</section>
	</div>

	<%-- <div style="display: none;">
		<div id="replace_target">
			<section id="pass" class="bg-gradient services-section">

				<div class="container">
					<form action="RequestServiceSchedule" method="post"
						data-animate="fadeInUp">
						<header class="main-title-w3layouts mb-2 text-center">
							<h4 data-animate="fadeInDown" class="title">Update Password</h4>
							<%
								for (int i = 0; i < FormFieldUltilityconstant.changePassword.length; i++) {
							%>
							<div class="col-md-6">
								<div class="span3" style="text-align: left;">
									<h5 data-animate="fadeInDown"><%=FormFieldUltilityconstant.changePassword[i]%></h5>
									<input type="password"
										name="<%=FormFieldUltilityconstant.changePassword[i]%>"
										id="<%=FormFieldUltilityconstant.changePassword[i]%>"
										placeholder="Enter Your <%=FormFieldUltilityconstant.changePassword[i]%>"
										class="form-control">
								</div>
							</div>
							<%
								}
							%>
							<div class="col-md-12 text-center">
								<input type="submit" class="btn btn-outline-light link-scroll"
									name="action" value="Change Now" id="pass">
							</div>
						</header>
					</form>
				</div>
			</section>
		</div>
	</div> --%>
	<%-- <jsp:include page="UserFooter.jsp"></jsp:include> --%>
	<!-- JavaScript files-->
	<script src="User/vendor/jquery/jquery.min.js"></script>
	<script src="User/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="User/vendor/jquery.cookie/jquery.cookie.js">
		
	</script>
	<script src="User/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="User/vendor/waypoints/lib/jquery.waypoints.min.js"></script>
	<script src="User/vendor/jquery.counterup/jquery.counterup.js"></script>
	<script src="User/ajax/libs/leaflet/1.4.0/leaflet.js">
		
	</script>
	<script src="User/js/front.js"></script>
</body>
</html>