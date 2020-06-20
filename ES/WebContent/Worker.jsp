<%@page import="com.es.model.RequestServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.formDesignUltility.ReportConstant"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeader"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeaderParam"%>
<%@page import="com.es.formDesignUltility.HtmlReportHeaderDesign"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>E-Society</title>
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
	<script type="text/javascript">
	
	document.getElementById("id1").onclick = function onWayClick() {
	    //disable
	    this.disabled = true;

	    //do some validation stuff
	}
	
		/* function onWayClick() {
			var onClick = document.getElementById("id1").disabled = "true";
		}
		function reachClick() {
			var onClick = document.getElementById("id2").disabled = "true";
		}
		function chechOutClick() {
			var onClick = document.getElementById("id3").disabled = "true";
		}
		function cancleClick() {
			var onClick = document.getElementById("id4").disabled = "true";
		} */
	</script>
	<%
		HtmlTableHeader hth = new HtmlTableHeader();
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		DbTransactionImpl dbt = new DbTransactionImpl();
		ArrayList<RequestServices> getServiceReq = dbt.getServiceToWorker(userData.getEmail_id());
		ArrayList<RequestServices> getServiceReq1 = dbt.getServiceForSchedule(userData.getEmail_id());
	%>
	<!-- Reference item-->
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<jsp:include page="WorkerHeader.jsp"></jsp:include>
			</div>
			<section id="home">
				<div class="container-fluid">
					<div class="col-md-12">
						<div class="row">
							<!-- Stats -->
							<div class="outer-w3-agile col-xl">
								<div class="work-progres">
									<table class="table table-striped"  style="margin-top: 50px; !important"
										class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'">
										<tr class="<%=hth.getWorkerRequest().getTableClass()%>">
											<th><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getServiceSchedule(),
					ReportConstant.schedule, 0)%></th>
										</tr>
										<%
											for (int i = 0; i < getServiceReq1.size(); i++) {
												RequestServices reqs = getServiceReq1.get(i);
										%>
										<form action="RequestServiceSchedule" method="post">										
											<div id="pgtn" class="table-responsive">
												<tbody>
													<tr>
														<td><%=reqs.getUser_name()%><input type="hidden"
															value="<%=reqs.getUser_name()%>" name="name" id="name"></td>
															
														<td><%=reqs.getAddress()%> <input type="hidden"
															value="<%=reqs.getAddress()%>" name="address"
															id="address"></td>
														<td><%=reqs.getProb_desc()%> <input type="hidden"
															value="<%=reqs.getProb_desc()%>" name="problem"
															id="problem"></td>
														<td><%=reqs.getUser_phone()%> <input type="hidden"
															value="<%=reqs.getUser_phone()%>" name="phone" id="phone"></td>
														<td><%=reqs.getReqservice_time_from()%> <input
															type="hidden" value="<%=reqs.getReqservice_time_from()%>"
															name="timef" id="timef"></td>
															
														<td><input type="submit" name="action" id="id1"
															value="On Way" onclick="onWayClick()"></td>
															
														<td><input type="submit"  name="action" 
															value="Done" onclick="reachClick()"></td>
														<td><input type="hidden"
															value="<%=reqs.getUser_email()%>" name="uemail"
															id="uemail"></td>
														<td><input type="hidden"
															value="<%=reqs.getReqservice_date()%>" name="date"
															id="date"></td>
													</tr>
												</tbody>
											</div>
										</form>
										<%
											}
										%>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- ----------------------------------------------------REQUEST------------------------------------------------------------ -->
			<section id="requests">
				<div class="container-fluid">
					<div class="col-md-12">
						<div class="row">
							<!-- Stats -->
							<div class="outer-w3-agile col-xl">
								<div class="work-progres">
									<table class="table table-striped"
										class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'">
										<tr class="<%=hth.getWorkerRequest().getTableClass()%>">
											<th><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getServiceRequest(), ReportConstant.worker,
					dbts.getRegisteredWorkerCount())%></th>
										</tr>
										<%
											for (int i = 0; i < getServiceReq.size(); i++) {
												RequestServices reqs = getServiceReq.get(i);
										%>
										<form action="RequestServiceSchedule" method="post">
											<div id="pgtn" class="table-responsive">
												<tbody>
													<tr>
														<td><%=reqs.getUser_name()%><input type="hidden"
															id="<%=i%>" value="<%=reqs.getUser_name()%>" name="name"></td>
														<td><%=reqs.getAddress()%><input type="hidden"
															id="<%=i%>" value="<%=reqs.getAddress()%>" name="address"></td>
														<td><%=reqs.getUser_phone()%><input type="hidden"
															id="<%=i%>" value="<%=reqs.getUser_phone()%>"
															name="phone"></td>
														<td><%=reqs.getUser_email()%><input type="hidden"
															id="<%=i%>" value="<%=reqs.getUser_email()%>"
															name="useremail"></td>
														<td><%=reqs.getProb_desc()%><input type="hidden"
															id="<%=i%>" value="<%=reqs.getProb_desc()%>"
															name="problem"></td>
														<td><%=reqs.getReqservice_date()%><input
															type="hidden" value="<%=reqs.getReqservice_date()%>"
															id="<%=i%>" name="date"></td>
														<td><%=reqs.getReqservice_time_from()%><input
															type="hidden" id="<%=i%>" name="timef"
															value="<%=reqs.getReqservice_time_from()%>"></td>
														<td><%=reqs.getReqservice_time_to()%><input
															type="hidden" id="<%=i%>" name="timet"
															value="<%=reqs.getReqservice_time_to()%>"></td>
														<td><input type="submit" name="action" value="Accept"></td>
														<td><input type="submit" name="action" value="Decline"></td>
													</tr>
												</tbody>
											</div>
										</form>
										<%
											}
										%>

									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- ----------------------------------------------------/REQUEST------------------------------------------------------------ -->
		</div>
	</div>
	<!--
    *** REFERENCES IMAGE ***
    _________________________________________________________
    -->
	<!-- Contact-->
	<!-- <section id="contact" data-animate="bounceIn"
		class="contact-section contact">
		<div class="container">
			<header class="text-center">
				<h2 class="title">Contact me</h2>
			</header>
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<form id="contact-form" method="post"
						action="ContactFormController">
						<div class="messages"></div>
						<div class="controls">
							<div class="row">
								<div class="col-md-6">
									<input type="text" name="name" placeholder="Your firstname *"
										required="required" class="form-control">
								</div>
								<div class="col-md-6">
									<input type="text" name="surname" placeholder="Your lastname *"
										required="required" class="form-control">
								</div>
								<div class="col-md-6">
									<input type="text" name="email" placeholder="Your email *"
										required="required" class="form-control">
								</div>
								<div class="col-md-6">
									<input type="text" name="phone" placeholder="Your phone *"
										class="form-control">
								</div>
								<div class="col-md-12">
									<textarea name="message" placeholder="Message for me *"
										rows="4" required="required" class="form-control"></textarea>
								</div>
								<div class="col-md-12 text-center">
									<input type="submit" class="btn btn-outline-primary"
										name="action" value="Send message" id="Send message"
										formname="home.jsp">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section> -->
	<!-- Map-->
	<!--  <div id="map"></div> -->
	<div class="col-md-12">
		 <%-- <jsp:include page="UserFooter.jsp"></jsp:include> --%>
	</div>
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