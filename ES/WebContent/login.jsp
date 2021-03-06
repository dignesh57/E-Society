<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
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
		String role = "";
	%>
	<div class="limiter">
		<div class="container-login100" style="background-color:rgb(79, 191, 168);">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" action="loginController" method="post">
					<span class="login100-form-title p-b-49">
						Login
					</span>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Role</span>
						<select onchange="onChangeRole (this)"
									class="input100"
									id="<%=FormFieldUltilityconstant.login[0]%>"
									name="<%=FormFieldUltilityconstant.login[0]%>">
										<option selected>Choose...</option>
										<%
											DbTransction dbt = new DbTransactionImpl();
													ArrayList<String> getRoleData = dbt.getRole();
													for (int j = 0; j < getRoleData.size(); j++) {
										%>
										<option id="<%=getRoleData.get(j)%>"><%=getRoleData.get(j)%></option>
										<%
											}
										%>
						</select>
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" name="<%=FormFieldUltilityconstant.login[1] %>" id="<%=FormFieldUltilityconstant.login[1] %>" placeholder="Type your <%=FormFieldUltilityconstant.login[1] %>">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="<%=FormFieldUltilityconstant.login[2] %>" id="<%=FormFieldUltilityconstant.login[2] %>" placeholder="Type your <%=FormFieldUltilityconstant.login[2] %>">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="text-right p-t-8 p-b-31">
						<a href="forgot_password.jsp">
							Forgot password?
						</a>
					</div>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<input type="submit" class="login100-form-btn" id="Login" name="action" value="Login" style="background: transparent; !important" >
							
							<!-- <input type="submit" id="Login" class="login100-form-btn" name="action" value="Login"> -->
						</div>
					</div>

					<div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17">
							Sign Up Using
						</span>

						<a href="home.jsp" class="txt2">
							Sign Up
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
				<script type="text/javascript">
					function onChangeRole(select) {
						var selectedrole = select.options[select.selectedIndex];
						/* alert("Your selected option is " + selectedrole.value); */
				<%=role%>
					= selectedrole.value;
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