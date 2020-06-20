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
	<meta name="keywords" content="Startup Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script>
		addEventListener("load", function () {
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
	<link rel="stylesheet" href="User/css/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link href="User/css/font-awesome.min.css" rel="stylesheet">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //Custom-Files -->

	<!-- Web-Fonts -->
	<link href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
	 rel="stylesheet">
	<!-- //Web-Fonts -->

</head>
<body>
	<jsp:include page="UserHeader.jsp"></jsp:include>
		<!-- main banner -->
	<div class="row" style="background-color: lightgreen;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
		 
			<form action="TaxController" class="form-group" method="post">
			
			<div class="row">
				<div class="col-md-12">
				<table class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'">
				<thead>
				<!-- 	<tr><th colspan="2">State Master</th></tr> -->
				<th colspan="2"><h4 class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.tran_maintainance_title %></h4></th>
				</thead>
				<% //String[] field = FormFieldUltilityconstant.mst_tax;
				for(int i=0;i<FormFieldUltilityconstant.tran_maintainance.length;i++){
				%> 
					<tr>
						<td class="form-inline mx-auto" 
									style="font-size: medium; !importatnt" ><%=FormFieldUltilityconstant.tran_maintainance[i]%></td>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.tran_maintainance[i]%>"
									name="<%=FormFieldUltilityconstant.tran_maintainance[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.tran_maintainance[i]%> Please..."></td>
					</tr>
					<%}%>
					<tr> 
						<td colspan="2" style="text-align: center;"><input type="submit" class="btn btn-primary" value="Add" formname="<%=FormFieldUltilityconstant.tran_maintainance_name %>" name="action"></td>
					<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
					</tr>
				</table>
				</div></div>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	<jsp:include page="UserFooter.jsp"></jsp:include>
</body>
</html>