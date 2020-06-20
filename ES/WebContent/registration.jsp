<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Sign Up</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Login/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Login/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="Login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Login/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="Login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="Login/css/util.css">
	<link rel="stylesheet" type="text/css" href="Login/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	<%
		String role = "", id = "", gender = "";
	%>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" action="RegistrationPageController" method="post">
					<span class="login100-form-title p-b-49">
						Sign Up
					</span>
					<%
								//String[] field = FormFieldUltilityconstant.registration_page;
						for (int i = 0; i < FormFieldUltilityconstant.registration_page.length; i++) {
					%>
					<%
						if (FormFieldUltilityconstant.registration_page[i] == "ID Proof"|| FormFieldUltilityconstant.registration_page[i] == "Role") {
					%>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100"><%=FormFieldUltilityconstant.registration_page[i]%></span>
						<select class="input100"
									<%if (FormFieldUltilityconstant.registration_page[i] == "Role") {%>
									onchange="onChangeOptionrole (this)" <%} else {%>
									onchange="onChangeOptionID (this)" <%}%>
									id="<%=FormFieldUltilityconstant.registration_page[i]%>"
									name="<%=FormFieldUltilityconstant.registration_page[i]%>">
										<option selected>Choose..</option>
										<%
											DbTransction dbt = new DbTransactionImpl();
													ArrayList<String> getData = dbt.getRole();
													if (FormFieldUltilityconstant.registration_page[i] == "Role") {
														getData = dbt.getRole();
													} else {
														getData = dbt.getID();
													}
													for (int j = 0; j < getData.size(); j++) {
										%>
										<option id="<%=getData.get(j)%>"><%=getData.get(j)%></option>
										<%
											}
										%>
								</select>
								
					</div>
					<%
									} else if (FormFieldUltilityconstant.registration_page[i] == "Gender") {
					%>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100"><%=FormFieldUltilityconstant.registration_page[i]%></span>
						<select class="input100" onchange="onChangeGender (this)"
										id="<%=FormFieldUltilityconstant.registration_page[i]%>"
										name="<%=FormFieldUltilityconstant.registration_page[i]%>">
										<option selected>Choose...</option>
										<option>Male</option>
										<option>Female</option>
										<option>Other</option>
						</select>
								
					</div>
						<%
									} else if (FormFieldUltilityconstant.registration_page[i] == "Password") {
					%>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100"><%=FormFieldUltilityconstant.registration_page[i]%></span>
						<input class="input100" type="password" name="<%=FormFieldUltilityconstant.registration_page[i] %>" id="<%=FormFieldUltilityconstant.registration_page[i] %>" placeholder="Type your <%=FormFieldUltilityconstant.registration_page[i] %>">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					<%}else{ %>
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100"><%=FormFieldUltilityconstant.registration_page[i]%></span>
						<input class="input100" type="text" name="<%=FormFieldUltilityconstant.registration_page[i] %>" id="<%=FormFieldUltilityconstant.registration_page[i] %>" placeholder="Type your <%=FormFieldUltilityconstant.registration_page[i] %>">
						
					</div>
					<%} %>
					<%
						}
							%>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<input type="submit" class="login100-form-btn" id="Add" name="action" value="Add" style="background: transparent; !important" >
							
							<!-- <input type="submit" id="Login" class="login100-form-btn" name="action" value="Login"> -->
						</div>
					</div>

					<div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17">
							Already Registered?
						</span>

						<a href="login.jsp" class="txt2">
							Login
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
				<script type="text/javascript">
					function onChangeOptionrole(String) {
						var changeRole = select.option[select.selectedIndex];
				<%=role%>
					= changeRole;
					}
					function onChangeOptionID(String) {
						var changeID = select.option[select.selectedIndex];
				<%=id%>
					= changeID;
					}
					function onChangeGender(String) {
						var changeGender = select.options[select.selectedIndex];
				<%=gender%>
					= changeGender.value;
					}
				</script>
	
<!--===============================================================================================-->
	<script src="Login/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="Login/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="Login/vendor/bootstrap/js/popper.js"></script>
	<script src="Login/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="Login/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="Login/vendor/daterangepicker/moment.min.js"></script>
	<script src="Login/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="Login/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="Login/js/main.js"></script>

</body>
</html>