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
<title>E-Society</title>
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
<link rel="stylesheet" type="text/css" href="User/vendor/jquery/jquery-ui.min.css">
</head>
<body>
	<%
	
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
	
	DbTransction dbt = new DbTransactionImpl();
	String soc_id=dbt.getSocietyIDofUser(userData.getEmail_id());
%>
	
	<jsp:include page="UserHeader.jsp"></jsp:include>
	<!-- main banner -->
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<%if(request.getAttribute("msg")!=null){ %>
		 	<h5 style="text-align: center;color:<%if(request.getAttribute("msg")=="success"){ %>green<%}else {%>red<%} %>  !important"><%if(request.getAttribute("msg")=="success"){ %>Booked Successfully Successful<%}else {%>Booking Failed<%} %></h5>
			 <%} %>
			<form action="datepicker.jsp" class="form-group"
				method="post" style="margin-top: 100px; !important">
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.tran_req_amenities_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_tax;
								for (int i = 0; i < FormFieldUltilityconstant.tran_req_amenities.length; i++) {
							%>
							
								<%
									if (FormFieldUltilityconstant.tran_req_amenities[i] == "Amenities Type") {
								%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.tran_req_amenities[i]%></td>
								<td><select
									class="custom-select"
									id="amenities"
									name="<%=FormFieldUltilityconstant.tran_req_amenities[i]%>">
										<%
													DbTransactionServices dbts = new DbTransactionServicesImpl();
													ArrayList<String> getAmenitiesType = dbts.getAmenitiesBySocid(soc_id);
										%><option selected disabled="disabled">select</option>
										<%
											for (int j = 0; j < getAmenitiesType.size(); j++) {
										%>
										<option id="<%=getAmenitiesType.get(j)%>"><%=getAmenitiesType.get(j)%></option>
										<%
											}
										%>

								</select></td>
								
							</tr>
							<%
								}}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Next"
									formname="<%=FormFieldUltilityconstant.tran_req_amenities_name%>"
									name="action"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	<jsp:include page="UserFooter.jsp"></jsp:include>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	
</body>
</html>