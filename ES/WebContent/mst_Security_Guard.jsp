<%@page import="com.es.model.mst_security_guard"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<style type="text/css">
	.error{
		color: red;
 	}
</style>
</head>
<body>
<% registration_page userData=(registration_page)session.getAttribute("user"); 
if(userData.getRole_name().equalsIgnoreCase("Secretary")){
%>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<form action="SecurityGuardController" class="form-group" method="post" enctype="multipart/form-data" id="sgform">
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'"
							style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_Security_guard_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_security_guard;
								for (int i = 0; i < FormFieldUltilityconstant.mst_security_guard.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_security_guard[i]%></td>

								<%
									if (FormFieldUltilityconstant.mst_security_guard[i].equalsIgnoreCase("Gender")) {
								%>
								<td><select class="custom-select"
									id="<%=FormFieldUltilityconstant.mst_security_guard[i]%>"
									required="required"
									name="<%=FormFieldUltilityconstant.mst_security_guard[i]%>">
										<option disabled selected>Choose...</option>
										<option>Male</option>
										<option>Female</option>
										<option>Other</option>
								</select></td>
								<%
									} else if (FormFieldUltilityconstant.mst_security_guard[i].equalsIgnoreCase("ID Proof")) {
								%>
								<td><select class="custom-select"
									id="<%=FormFieldUltilityconstant.mst_security_guard[i]%>"
									required="required" name="<%=FormFieldUltilityconstant.mst_security_guard[i]%>">
										<%
											DbTransction dbt = new DbTransactionImpl();
													ArrayList<String> getData = dbt.getID();
										%>
										<option selected><%=getData.get(0)%></option>
										<%
											for (int j = 1; j < getData.size(); j++) {
										%>
										<option id="<%=getData.get(j)%>"><%=getData.get(j)%></option>
										<%
											}
										%>
								</select></td>
								<%
									} else if (FormFieldUltilityconstant.mst_security_guard[i].equalsIgnoreCase("Password")){
								%>
								<td><input type="password"
									id="<%=FormFieldUltilityconstant.mst_security_guard[i]%>"
									name="<%=FormFieldUltilityconstant.mst_security_guard[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.mst_security_guard[i]%> Please"></td>
								<%
									} else {
								%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_security_guard[i]%>"
									name="<%=FormFieldUltilityconstant.mst_security_guard[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.mst_security_guard[i]%> Please"></td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Submit"
									formname="<%=FormFieldUltilityconstant.security_guard_name%>"
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

	<div class="row">
		<div><h4>SecurityGuard Details</h4><br>
			<%
			String secretaryid=userData.getEmail_id();
//			String secretaryid="karanmmodi1998@gmail.com";
			DbTransction dbt = new DbTransactionImpl();
			String socid = dbt.getSocietyID(secretaryid);
			System.out.println(socid);

			ArrayList<mst_security_guard> getSecurity = dbt.getAllSecurity(socid);
			%>
			<form action="SecurityGuardController" class="form-group" method="post" enctype="multipart/form-data">
				<table class="table table-striped table-responsive">
					<tr>
						<th>No</th>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Action</th>
					</tr>
					<%
						for (int i = 0; i < getSecurity.size(); i++) {
							mst_security_guard security=getSecurity.get(i);
					%>
					<tr>
						<td><%=i+1%></td>
						<td><%=security.getName()%></td>
						<td><%=security.getEmail()%></td>
						<td><%=security.getPhone_no()%></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=security.getEmail()%>" name="action1"
								formname=<%=FormFieldUltilityconstant.mst_state_name%>>
								<i class="fa fa-trash" style="color: red; !important"></i>
							</button>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</form>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	
			<script src='js/jquery-2.2.3.min.js'></script>
			<script src="js/jquery.validate.min.js"></script>
			<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
			<script type="text/javascript">
			$(document).ready(function(){
			
				jQuery.validator.addMethod("lettersonly", function(value, element) {
					  return this.optional(element) || /^[a-z ]+$/i.test(value);
					}, "Letters and spaces only allowed please");
					
			console.log('in');
			$sgform = $('#sgform');
			
			if($sgform.length) {
				console.log('in2');
				$("#sgform").validate({
					rules: {
						Name: {
							required: true,
							lettersonly: true
						},
						Email: {
							required: true,
							email:true
						},
						Password: {
							required: true,
							minlength:8
						}
					},
					messages: {					
							Name: {
								required: 'Please Enter Your Name!'
							},
							Email: {
								required: 'Please Enter Your Email!'
							},
							Password: {
								required: 'Please Enter Your Password!',
								minlength: 'Please Enter minimum 8 characters...!'
							},
							highlight: function(element) {
						        $(element).css('background', '#ffdddd');
						    },
						    unhighlight: function(element) {
						        $(element).css('background', '#ffffff');
						    } 					
						}
					});
				
				}
			});
			</script>
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>