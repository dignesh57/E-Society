<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.model.mst_maintenance"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.model.registration_page"%>
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
</head>
<body>
<% registration_page userData=(registration_page)session.getAttribute("user"); 
if(userData.getRole_name().equalsIgnoreCase("Secretary")){
%>
	<script type="text/javascript">
		function onChangeText(input) {
			var val1 = document.getElementById("id1");
			var val2 = document.getElementById("id2");
			val2.value = val1.value*<%=DbTransactionServicesImpl.getPrice_pr_unit(userData.getEmail_id())%>;
			console.log(val1.value);
			console.log(val2.value);
		}
	</script>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<form action="Mainatenance_Add_Controller" class="form-group"
				method="post">
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'"
							style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.generate_maintenance_title%></h4></th>
							</thead>
							<%
								for (int i = 0; i < FormFieldUltilityconstant.mst_maintenance.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_maintenance[i]%></td>

								<%
									DbTransction dbt = new DbTransactionImpl();
										ArrayList<String> getData = dbt.getMaintenanceDetails(userData.getEmail_id());

										if (FormFieldUltilityconstant.mst_maintenance[i].equalsIgnoreCase("Water Unit")) {
								%>
								<td><input type="text" class="form-control" id="id1"
									onkeyup="onChangeText(this)"
									name="<%=FormFieldUltilityconstant.mst_maintenance[i]%>"
									placeholder="please enter <%=FormFieldUltilityconstant.mst_maintenance[i]%>here">
								</td>
								<td><input type="text" class="form-control" id="id2"
									value="" readonly="readonly"
									name="water_charge"
									placeholder=""></td>
								<%
									} else if (FormFieldUltilityconstant.mst_maintenance[i].equalsIgnoreCase("Member Id")) {
								%>
								<td><select class="custom-select"
									id="<%=FormFieldUltilityconstant.mst_maintenance[i]%>"
									name="<%=FormFieldUltilityconstant.mst_maintenance[i]%>">
										<option selected>Choose...</option>
										<%
											ArrayList<String> getmemid = dbt.getmemberid(userData.getEmail_id());
													for (int k = 0; k < getmemid.size(); k++) {
										%>
										<option id="<%=getmemid.get(k)%>"><%=getmemid.get(k)%></option>
										<%
											}
										%>
								</select></td>
								<%
									} else {
								%>
								<td><input type="text" class="form-control"
									id="<%=FormFieldUltilityconstant.mst_maintenance[i]%>"
									name="<%=FormFieldUltilityconstant.mst_maintenance[i]%>"
									value="<%=getData.get(i)%>" readonly="readonly"
									placeholder="<%=getData.get(i)%>"></td>
								<%
									}
								%>
							<tr>
								<%
									}
								%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Generate"
									formname="<%=FormFieldUltilityconstant.generate_maintenance_name%>"
									name="action"></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>


	<div class="row">
		<div class="col-md-12">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>