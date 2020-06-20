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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<script type="text/javascript">
	function onChangeMaster(select){
		var manageValue= select.options[select.selectedIndex];
	}	
	</script>
	<div>
		<form action="" method="post">
			<table
				class="table table-responsive' data-height='450' data-width='200'
				data-show-columns='true' data-search='true'"
				style="border-collapse: inherit; !important">
				<thead>
					<!-- 	<tr><th colspan="2">State Master</th></tr> -->
					<th colspan="2"><h4
							class="main-title-w3layouts mb-2 text-center">Manage Master</h4></th>
				</thead>
				<tr>
					<td><select class="custom-select"
						onchange="OnselectGender (this)" id="Manage" required="required"
						name="Manage">
							<option disabled selected>Choose...</option>
							<option id="state">Manage State</option>
							<option id="city">Manage City</option>
							<option>Manage Area</option>
							<option>Manage Role</option>
							<option>Manage ID</option>
					</select></td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
