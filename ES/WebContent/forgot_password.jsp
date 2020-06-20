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
    <meta name="keywords" content="Modernize Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />


    <!-- Style-sheets -->
    <!-- Bootstrap Css -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Bootstrap Css -->
    <!-- Common Css -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!--// Common Css -->
    <!-- Fontawesome Css -->
    <link href="css/fontawesome-all.css" rel="stylesheet">
    <!--// Fontawesome Css -->
    <!--// Style-sheets -->

    <!--web-fonts-->
    <link href="//fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

</head>
<body>
	<%-- <jsp:include page="header.jsp"></jsp:include> --%>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
		
			<form action="ForgotPassword" class="form-group" method="post">
			<div class="row">
				<div class="col-md-12">
				<table class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'">
				<thead>
				<!-- 	<tr><th colspan="2">State Master</th></tr> -->
				<th colspan="2"><h4 class="main-title-w3layouts mb-2 text-center">Retrieve Password</h4></th>
				</thead>
				<% //String[] field = FormFieldUltilityconstant.forgot_password;
				for(int i=0;i<FormFieldUltilityconstant.forgot_password.length;i++){
				%>
					<tr>
						<td class="form-inline mx-auto" style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.forgot_password[i]%></td>
						<td><input type="text" id="<%=FormFieldUltilityconstant.forgot_password[i]%>" name="<%=FormFieldUltilityconstant.forgot_password[i]%>" class="form-control" placeholder="Your <%=FormFieldUltilityconstant.forgot_password[i]%> Please"></td>
					</tr>
					<%}%>
					<tr>
						<td colspan="2" style="text-align: center;"><input type="submit" class="btn btn-primary" value="submit" id="submit" name="action" formname="<%=FormFieldUltilityconstant.mst_role_name %>"></td>
					<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
					</tr>
				</table>
				</div></div>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
		</div>
	</div>
</body>
</html>