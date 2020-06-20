<%@page import="com.es.model.tran_worker"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>E-Society</title>
<title><%=FormFieldUltilityconstant.webConstant%></title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Startup Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta tag Keywords -->

<!-- Custom-Files -->
<link rel="stylesheet" href="User/css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="User/css/style.css" type="text/css"
	media="all" />
<!-- Style-CSS -->
<link href="User/css/font-awesome.min.css" rel="stylesheet">
<!-- Font-Awesome-Icons-CSS -->
<!-- //Custom-Files -->

<!-- Web-Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
	rel="stylesheet">
<!-- //Web-Fonts -->

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
		ArrayList<tran_worker> getWorker = dbt.workerDetails(userData.getEmail_id());
	%>
	<jsp:include page="UserHeader.jsp"></jsp:include>
	<div class="row" style="background-image: url('images/bg01.jpg');">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<section>
				<header class="main-title-w3layouts mb-2 text-center">
					<h2 data-animate="fadeInDown" class="title"><%=FormFieldUltilityconstant.worker_details_title%></h2>
				</header>
			</section>
			<%
				for (int i = 0; i < getWorker.size(); i++) {
					tran_worker wor = getWorker.get(i);
			%>
			<form action="RequestServicesController" class="form-group"
				method="post" style="">
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'">
							<tr>
								<td style="margin-top: 1px; !important">
									<section>
										<div class="container">
											<div class="row services text-center">
												<div data-animate="fadeInUp" class="col-lg-12">
													<header class="main-title-w3layouts mb-2 text-center">
														<h4 class="main-title-w3layouts mb-2 text-left">
															Name :
															<%=wor.getW_name()%></h4>
														<h4 class="main-title-w3layouts mb-2 text-left">
															Email :<%=wor.getW_email()%></h4>
														<h4 class="main-title-w3layouts mb-2 text-left">
															Service Type :<%=wor.getService_type()%></h4>
														<h4 class="main-title-w3layouts mb-2 text-left">
															Phone No :<%=wor.getW_phone()%></h4>
														<h4 class="main-title-w3layouts mb-2 text-left">
															Working Time :<%=wor.getAvailable_from()%>
															From To
															<%=wor.getAvailable_to()%></h4>
														<h4 class="main-title-w3layouts mb-2 text-left">
															Description :<%=wor.getService_desc()%></h4>
													</header>
													<!-- <td colspan="2" style="text-align: center;"> -->
													<input type="submit" class="btn btn-primary"
														value="Request Now"
														formname="<%=FormFieldUltilityconstant.tran_req_service_name%>"
														name="action"> <input type="hidden"
														value="<%=wor.getW_email()%>" id="action1" name="action1">
												</div>
											</div>
											<hr data-animate="fadeInUp">
										</div>
									</section>
							</tr>
							<tr></tr>
						</table>
					</div>
				</div>
			</form>
			<%
				}
			%>
		</div>
		<div class="col-md-3"></div>
	</div>
	<jsp:include page="UserFooter.jsp"></jsp:include>
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