<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.mst_state"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@page import="com.sun.tools.javac.code.Attribute.Array"%> --%>
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
		DbTransction dbt = new DbTransactionImpl();
		ArrayList<mst_state> statedata = dbt.getStateModel();
%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<div class="row">
					<div class="col-md-12" id="adddiv" class="top">
					<form action="StateController" class="form-group" method="post" id="stateform">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_state_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_state;
								for (int i = 0; i < FormFieldUltilityconstant.mst_state.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_state[i]%></td>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_state[i]%>"
									name="<%=FormFieldUltilityconstant.mst_state[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_state[i]%> Please" required="required"></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add" name="action"
									id="add-form" formname=<%=FormFieldUltilityconstant.mst_state_name%>>
								</td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
						</form>
					</div>
					<div class="col-md-12" id="updatediv" class="top">
					<form action="StateController" class="form-group" method="post" id="stateformu">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_state_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_state;
								for (int i = 0; i < FormFieldUltilityconstant.mst_state.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_state[i]%></td>
								<td><input type="text"
									id="U<%=FormFieldUltilityconstant.mst_state[i]%>"
									name="<%=FormFieldUltilityconstant.mst_state[i]%>"
									class="form-control" <% if(FormFieldUltilityconstant.mst_state[i]=="Id") {%> readonly="readonly" <%} %>
									required="required"></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-success" value="Update" name="action"
									id="update-form" formname=<%=FormFieldUltilityconstant.mst_state_name%>>
								</td>
								<td><button class="btn btn-primary"
								type="submit" value="addrfs"
								id="addrfs" style="color:white">
								<i class="fa fa-plus" !important"></i>
							</button></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
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
				<th>
					<h4>State Details</h4><br>
				</th>
				<form action="StateController" class="form-group" method="post">
					<table class="table table-striped" class="table table-responsive">
						<tr>
							<th>No</th>
							<th>State Id</th>
							<th>State name</th>
							<th colspan="2" style="text-align: center;">Action</th>
							
						</tr>
						<%
							for (int i = 0; i < statedata.size(); i++) {
								mst_state state = statedata.get(i);
						%>
						<tr id=<%=state.getState_id()%>>
							<td><%=i+1 %></td>
							<td data-target-id><%=state.getState_id()%></td>
							<td data-target-name><%=state.getState_name()%></td>
							<%-- <td colspan="2" style="text-align: center;"><input
								type="submit" class="btn btn-success" value="Edit" name="action"
								id="Edit" formname=<%=FormFieldUltilityconstant.mst_state_name%>>
							</td>--%>
						<td><button class="btn btn-link"
								type="button" value="<%=state.getState_id()%>"
								id="update">
								<i class="fa fa-edit" style="color: green; !important"></i>
							</button>
						</td>
						<td><button class="btn btn-link"
								type="submit" value="<%=state.getState_id()%>" name="action1"
								id="<%=state.getState_id()%>"
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
	
			<jsp:include page="footer.jsp"></jsp:include>
			<script src='js/jquery-2.2.3.min.js'></script>
			<script src="js/jquery.validate.min.js"></script>
			<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
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
						var state=$('#'+id).children('td[data-target-name]').text();
						console.log(id+state);
						
						$('#UId').val(id);
						$('#UName').val(state);
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
			<script type="text/javascript">
			$(document).ready(function(){
			
				jQuery.validator.addMethod("lettersonly", function(value, element) {
					  return this.optional(element) || /^[a-z]+$/i.test(value);
					}, "Letters only please");
				
			console.log('in');
			$stateform = $('#stateform');
			
			if($stateform.length) {
				console.log('in2');
				$("#stateform").validate({
						rules: {
							Id: {
								required: true,
								number: true
							},
							Name: {
								required: true,
								minlength: 3,
								lettersonly: true
							}				
						},
						messages: {					
							Id: {
								required: 'Please enter state id!',
								number: 'plz enter number only for state id'
							},
							Name: {
								required: 'Please enter state name!',
								minlength: 'State must have 3 characters plz enter valid state name'
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
			<script type="text/javascript">
			$(document).ready(function(){
			
				jQuery.validator.addMethod("lettersonly", function(value, element) {
					  return this.optional(element) || /^[a-z]+$/i.test(value);
					}, "Letters only please");
				
			console.log('in');
			$stateformu = $('#stateformu');
			
			if($stateformu.length) {
				console.log('in2');
				$("#stateformu").validate({
						rules: {
							Id: {
								required: true,
								number: true
							},
							Name: {
								required: true,
								minlength: 3,
								lettersonly: true
							}				
						},
						messages: {					
							Id: {
								required: 'Please enter state id!',
								number: 'plz enter number only for state id'
							},
							Name: {
								required: 'Please enter state name!',
								minlength: 'State must have 3 characters plz enter valid state name'
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