<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.model.mst_expense"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.model.registration_page"%>
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
	<%
		DbTransactionServices dbs = new DbTransactionServicesImpl();
		String socid = dbs.getMemberSocID(userData.getEmail_id());
		DbTransction dbt = new DbTransactionImpl();
		ArrayList<mst_expense> getExpense = dbt.getAllExpense(socid);
	%>
	<!-- Reference item-->
	<jsp:include page="UserHeader.jsp"></jsp:include>
	<section id="contact" data-animate="bounceIn"
		class="contact-section contact" style="margin-top: 100px; !important">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-9">
					<h3>All Expense Information</h3>
					</br>
					<table class="table table-striped table-responsive" style="">
						<tr>
							<th>No</th>
							<th>Expense Name</th>
							<th>Price</th>
							<th>Date & Time</th>
						</tr>
						<%
							for (int i = 0; i < getExpense.size(); i++) {
								mst_expense expense = getExpense.get(i);
						%>
						<tr>
							<td><%=i + 1%></td>
							<td><%=expense.getExp_type()%></td>
							<td><%=expense.getPrice()%></td>
							<td><%=expense.getEntered_on()%></td>
							<%-- <td><button
								type="submit" value="<%=expense.getExp_type()%>" name="action1"
								id="<%=expense.getExp_type()%>"
								formname=<%=FormFieldUltilityconstant.mst_expense_name%>>
								<i class="fa fa-trash" style="color: red; !important"></i>
							</button></td> --%>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
		</div>
	</section>
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