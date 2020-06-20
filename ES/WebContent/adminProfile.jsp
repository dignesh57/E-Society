<%@page import="com.es.model.registration_page"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Page_not_found.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=FormFieldUltilityconstant.webConstant%></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Modernize Responsive web template, Bootstrap Web Temp,lates, Flat Web Templates, Android Compatible web template,
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<%
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
%>
<body>
<%if(userData.getRole_name().equalsIgnoreCase("Admin")){ %>
	<jsp:include page="header.jsp"></jsp:include>
	<%}else if(userData.getRole_name().equalsIgnoreCase("Secretary")){ %>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
<%} %>
	<div>
		<form action="RegistrationPageController" method="post">
			<table
				class="table table-responsive' data-height='450' data-width='200'
				data-show-columns='true' data-search='true'"
				style="border-collapse: inherit; !important">
				<thead>
					<!-- 	<tr><th colspan="2">State Master</th></tr> -->
					<th colspan="2"><h4
							class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.profile_title%></h4></th>
				</thead>
				<%
					for (int i = 0; i < FormFieldUltilityconstant.adminProfile.length; i++) {
				%>
				<tr>
					<td class="form-inline mx-auto"
						style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.adminProfile[i]%></td>
					<%
						DbTransction dbt = new DbTransactionImpl();
							ArrayList<String> getData = dbt.getRegistrationData(userData.getEmail_id());
								if (FormFieldUltilityconstant.adminProfile[i] == "Email") {
					%>
					<td><input type="text"
						id="<%=FormFieldUltilityconstant.adminProfile[i]%>"
						name="<%=FormFieldUltilityconstant.adminProfile[i]%>"
						value="<%=getData.get(i)%>" class="form-control" disabled="disabled"
						placeholder="<%=getData.get(i)%>"></td>
					<td><input type="text"
						id="<%=FormFieldUltilityconstant.adminProfile[i]%>"
						name="<%=FormFieldUltilityconstant.adminProfile[i]%>"
						value="<%=getData.get(i)%>" class="form-control" hidden="true"
						placeholder="<%=getData.get(i)%>"></td>
					<%
						} else {
					%>
					<td><input type="text"
						id="<%=FormFieldUltilityconstant.adminProfile[i]%>"
						name="<%=FormFieldUltilityconstant.adminProfile[i]%>"
						value="<%=getData.get(i)%>" class="form-control"
						placeholder="<%=getData.get(i)%>"></td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" class="btn btn-primary" value="Update" name="action"
						id="add" formname=<%=FormFieldUltilityconstant.adminProfile_name%>>
					</td>
					<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>