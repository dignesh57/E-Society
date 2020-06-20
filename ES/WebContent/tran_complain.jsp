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
<%
	
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
%>
	<%
		String complain = "";
	%>
	<jsp:include page="UserHeader.jsp"></jsp:include>
		<!-- main banner -->
	<div class="container">
	<div class="row" style="margin-top: 100px; !important">
		<div class="col-md-3"></div>
		<div class="col-md-6">
		<%if(request.getAttribute("msg")!=null){ %>
		 	<h5 style="text-align: center;color:green  !important">${msg}</h5>
		 <%} %>
			<form action="UserComplainController" class="form-group" method="post" enctype="multipart/form-data">
			<script type="text/javascript">
					function OnSelectionComplain(select) {
					var selectedOption = select.options[select.selectedIndex];
					<%=complain%>
					= selectedOption.value;
					}
			</script>
			<div class="row">
				<div class="col-md-12">
				<table class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'">
				<thead>
				<!-- 	<tr><th colspan="2">State Master</th></tr> -->
				<th colspan="2"><h4 class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.tran_complain_title %></h4></th>
				</thead>
				<% //String[] field = FormFieldUltilityconstant.mst_tax;
				for(int i=0;i<FormFieldUltilityconstant.tran_complain.length;i++){
				%> 
					<tr>
						<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.tran_complain[i]%></td>
								<%
									if (FormFieldUltilityconstant.tran_complain[i] == "Complaint To") {
								%>
								<td><select onchange="OnSelectionComplain (this)"
									class="custom-select" required="required"
									id="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									name="<%=FormFieldUltilityconstant.tran_complain[i]%>">
									<option disabled="disabled">choose..</option>
									<option id="Admin">Admin</option>
									<option id="Secretary">Secretary</option>
								</select></td>
								<%}else if(FormFieldUltilityconstant.tran_complain[i].equals("Email")){%>
								<td><input type="text" readonly="readonly"
									id="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									name="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									class="form-control" required="required"
									value="<%=userData.getEmail_id()%>"
									placeholder="<%=userData.getEmail_id()%>"></td>
								<%}else if(FormFieldUltilityconstant.tran_complain[i].equals("Name")){%>
								<td><input type="text" readonly="readonly"
									id="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									name="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									class="form-control" required="required"
									value="<%=userData.getUsername()%>"
									placeholder="<%=userData.getUsername()%>"></td>
								<%
									} else if(FormFieldUltilityconstant.tran_complain[i].equals("Complaint Description")){
								%>
								<td><textarea 
									id="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									name="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.tran_complain[i]%> Please"></textarea></td>
								<%
									} else if(FormFieldUltilityconstant.tran_complain[i].equals("Document")){
								%>
								<td><input type="file"
									id="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									name="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.tran_complain[i]%> Please" required="required"></td>
								<%
									} else {
								%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									name="<%=FormFieldUltilityconstant.tran_complain[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.tran_complain[i]%> Please"></td>
								<%
									}
								%>
					</tr>
					<%}%>
					<tr>
						<td colspan="2" style="text-align: center;"><input type="submit" class="btn btn-primary" value="Add" formname="<%=FormFieldUltilityconstant.tran_complain_name %>" name="action"></td>
					<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
					</tr>
				</table>
				</div></div>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	</div>
	<jsp:include page="UserFooter.jsp"></jsp:include>
</body>
</html>