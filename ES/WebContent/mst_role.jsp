<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.mst_role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
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
<style type="text/css">
	.error{
		color: red;
 	}
</style>
</head>
<body>
<%registration_page rg=(registration_page)session.getAttribute("user"); 
if(rg.getRole_name().equalsIgnoreCase("Admin")){
%>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

				<div class="row">
				<div class="col-md-12" id="adddiv" class="top">
				<form action="RoleController" class="form-group" method="post" id="roleform">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_role_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_role;
								for (int i = 0; i < FormFieldUltilityconstant.mst_role.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_role[i]%></td>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_role[i]%>"
									name="<%=FormFieldUltilityconstant.mst_role[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_role[i]%> Please" required="required"></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add" name="action"
									id="add"
									formname="<%=FormFieldUltilityconstant.mst_role_name%>"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
						</form>
					</div>
				<div class="col-md-12" id="updatediv" class="top">
				<form action="RoleController" class="form-group" method="post" id="roleformu">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_role_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_role;
								for (int i = 0; i < FormFieldUltilityconstant.mst_role.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_role[i]%></td>
								<td><input type="text"
									id="URole"
									name="<%=FormFieldUltilityconstant.mst_role[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_role[i]%> Please" required="required"></td>
							</tr>
							<%
								}
							%>
							<input type="hidden" id="URoleHdn" name="rolehdn" class="form-control">
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-success" value="Update" name="action"
									formname="<%=FormFieldUltilityconstant.mst_role_name%>"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							<td><button class="btn btn-primary"
								type="submit" value="addrfs"
								id="addrfs" style="color:white">
								<i class="fa fa-plus" !important"></i>
							</button></td>
							</tr>
						</table>
						</form>
					</div>
				</div>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div>
			<%
				DbTransction dbt = new DbTransactionImpl();
				ArrayList<mst_role> getRoleDetails = dbt.getAllRole();
			%>
			<form action="RoleController" class="form-group" method="post">
				<table class="table table-striped" class="table table-responsive">
					<tr>
						<th>No</th>
						<th>RoleName</th>
						<th colspan="2" style="text-align: center;">Action</th>
					</tr>
					<%
						for (int i = 0; i < getRoleDetails.size(); i++) {
							mst_role role=getRoleDetails.get(i);
					%>
					<tr id=<%=i+1%>>
						<td><%=i+1%></td>
						<td data-target-name><%=role.getRole_name()%></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=i+1%>"
								id="update">
								<i class="fa fa-edit" style="color: green; !important"></i>
							</button></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=role.getRole_id()%>" name="action1"
								id="<%=role.getRole_id()%>"
								formname=<%=FormFieldUltilityconstant.mst_area_name%>>
								<i class="fa fa-trash" style="color: red; !important"></i>
							</button></td>
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
			<script type="text/javascript">
				$(document).ready(function(){
					$('#adddiv').fadeIn("slow");
					$('#updatediv').hide();
					
					$(document).on('click','#update',function(){
						console.log("hii");
						event.preventDefault();
						$('#adddiv').hide();
						$('#updatediv').fadeIn("slow");
						
						var id=$(this).val();
						var role=$('#'+id).children('td[data-target-name]').text();
						console.log(id+role);
						
						$('#URole').val(role);
						$('#URoleHdn').val(role);
						$(location).attr('href','#updatediv');
					})
					
					$(document).on('click','#addrfs',function(){
						console.log("hii");
						event.preventDefault();
						$('#adddiv').show();
						$('#updatediv').fadeIn("slow");
						
					})
				});
			</script>
			<script src="js/jquery.validate.min.js"></script>
			<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
			<script type="text/javascript">
			$(document).ready(function(){
			
			console.log('in');
			$roleform = $('#roleform');
			
			if($roleform.length) {
				console.log('in2');
				$("#roleform").validate({
						
					});
				
				}
			});
			</script>
			<script type="text/javascript">
			$(document).ready(function(){
			
			console.log('in');
			$roleformu = $('#roleformu');
			
			if($roleformu.length) {
				console.log('in2');
				$("#roleformu").validate({
						
					});
				
				}
			});
			</script>
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>