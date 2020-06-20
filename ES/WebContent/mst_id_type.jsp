<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.mst_id_type"%>
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
}
	<jsp:include page="header.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

				<div class="row">
					<div class="col-md-12" id="adddiv" class="top">
					<form action="IDTypeController" class="form-group" method="post" id="idform">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_id_title %></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_id_type;
								for (int i = 0; i < FormFieldUltilityconstant.mst_id_type.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_id_type[i]%></td>
								<%
									if (FormFieldUltilityconstant.mst_id_type[i] == "State") {
								%>
								<td><select class="custom-select" id="inputGroupSelect01">
										<option selected>Choose...</option>

								</select></td>
								<%}else{%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_id_type[i]%>"
									name="<%=FormFieldUltilityconstant.mst_id_type[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_id_type[i]%> Please" required="required"></td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add" name="action"
									id="add" formname="<%=FormFieldUltilityconstant.mst_id_name %>"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
						</form>
					</div>
					<div class="col-md-12" id="updatediv" class="top">
					<form action="IDTypeController" class="form-group" method="post" id="idformu">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_id_title %></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_id_type;
								for (int i = 0; i < FormFieldUltilityconstant.mst_id_type.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_id_type[i]%></td>
								<%
									if (FormFieldUltilityconstant.mst_id_type[i] == "ID Type") {
								%>
								<td><input type="text"
									id="UIdtype"
									name="<%=FormFieldUltilityconstant.mst_id_type[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_id_type[i]%> Please" required="required"></td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<input type="hidden" id="UIDHdn" name="idhdn" class="form-control">
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-success" value="Update" name="action"
									formname="<%=FormFieldUltilityconstant.mst_id_name %>"></td>
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
			<%DbTransction dbt=new DbTransactionImpl();
		ArrayList<mst_id_type> getID=dbt.getAllID();
		
		%>
			<form action="IDTypeController" class="form-group" method="post">
				<table class="table table-striped" class="table table-responsive">
					<tr>
						<th>No</th>
						<th>IDName</th>
						<th colspan="2" style="text-align: center;">Action</th>
					</tr>
					<%for(int i=0;i<getID.size();i++){
						mst_id_type idtype=getID.get(i);
					%>
					<tr id=<%=i+1%>>
						<td><%=i+1 %></td>
						<td data-target-name><%=idtype.getId_type()%></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=i+1%>"
								id="update">
								<i class="fa fa-edit" style="color: green; !important"></i>
							</button></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=idtype.getId_id()%>" name="action1"
								id="<%=idtype.getId_id()%>"
								formname=<%=FormFieldUltilityconstant.mst_id_name%>>
								<i class="fa fa-trash" style="color: red; !important"></i>
							</button></td>
					</tr>
					<%} %>
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
						var idtype=$('#'+id).children('td[data-target-name]').text();
						console.log(id+idtype);
						
						$('#UIdtype').val(idtype);
						$('#UIDHdn').val(idtype);
						$(location).attr('href','#updatediv');
					})
					
					$(document).on('click','#addrfs',function(){
						console.log("hii");
						event.preventDefault();
						$('#adddiv').fadeIn("slow");
						$('#updatediv').hide();
						
					})
				});
			</script>
			<script src="js/jquery.validate.min.js"></script>
			<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
			
			<script type="text/javascript">
			
			$(document).ready(function(){
				
				jQuery.validator.addMethod("lettersonly", function(value, element) {
					  return this.optional(element) || /^[a-z]+$/i.test(value);
					}, "Letters only please"); 
				
			console.log('in');
			$idform = $('#idform');
			
			if($idform.length) {
				console.log('in2');
				$("#idform").validate({
						
					});
				
				}
			});
			</script>
			<script type="text/javascript">
			
			$(document).ready(function(){
				
				jQuery.validator.addMethod("lettersonly", function(value, element) {
					  return this.optional(element) || /^[a-z]+$/i.test(value);
					}, "Letters only please"); 
				
			console.log('in');
			$idformu = $('#idformu');
			
			if($idformu.length) {
				console.log('in2');
				$("#idformu").validate({
						
					});
				
				}
			});
			</script>
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>