<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.mst_mst_city"%>
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
	String state = "";
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

				<script type="text/javascript">
				function OnselectChangeState(select) {
					var selectOptionState = select.options[select.selectedIndex];
			<%=state%>
				= selectOptionState;
				}
				</script>
				<div class="row">
					<div class="col-md-12" id="adddiv" class="top">
					<form action="CityController" class="form-group" method="post" id="cityform">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_mst_city_title%></h4></th>
							</thead>

							<%
								//String[] field = FormFieldUltilityconstant.mst_mst_city;
								for (int i = 0; i < FormFieldUltilityconstant.mst_mst_city.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_mst_city[i]%></td>
								<%
									if (FormFieldUltilityconstant.mst_mst_city[i] == "State") {
								%>
								<td><select onchange="OnselectChangeState (this)"
									class="custom-select"
									id="<%=FormFieldUltilityconstant.mst_mst_city[0]%>"
									name="<%=FormFieldUltilityconstant.mst_mst_city[0]%>">
										<%
											DbTransction dbt = new DbTransactionImpl();
													ArrayList<String> getStateData = dbt.getState();
										%><option selected><%=getStateData.get(0)%></option>
										<%
											for (int j = 1; j < getStateData.size(); j++) {
										%>
										<option id="<%=getStateData.get(j)%>"><%=getStateData.get(j)%></option>
										<%
											}
										%>

								</select></td>
								<%
									} else {
								%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_mst_city[i]%>"
									name="<%=FormFieldUltilityconstant.mst_mst_city[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_mst_city[i]%> Please" required="required"></td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" name="action" value="Add"
									id="add" formname=<%=FormFieldUltilityconstant.mst_city_name%>></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
						</form>
					</div>
				
				<!-- update div -->
				<div class="col-md-12" id="updatediv" class="top">
				<form action="CityController" class="form-group" method="post" id="cityformu">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_mst_city_title%></h4></th>
							</thead>

							<%
								//String[] field = FormFieldUltilityconstant.mst_mst_city;
								for (int i = 0; i < FormFieldUltilityconstant.mst_mst_city.length; i++) {
							%>
							
								<%
									if (FormFieldUltilityconstant.mst_mst_city[i] == "City") {
								%>
								<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_mst_city[i]%></td>
								<td><input type="text"
									id="U<%=FormFieldUltilityconstant.mst_mst_city[i]%>"
									name="<%=FormFieldUltilityconstant.mst_mst_city[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_mst_city[i] %> Please" required="required"></td>
									<input type="hidden" id="UCityHdn" name="cityhdn" class="form-control">
								</tr>
								<%
									}
								%>
							
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-success" name="action" value="Update"
									formname=<%=FormFieldUltilityconstant.mst_city_name%>>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
	<div class="col-md-6">
		<div>
			<%
				DbTransction dbt = new DbTransactionImpl();
				ArrayList<mst_mst_city> getCity = dbt.getCityModel();
			%>
			<form action="CityController" class="form-group" method="post">
				<table class="table table-striped" class="table table-responsive">
					<tr>
						<th>No.</th>
						<th>StateName</th>
						<th>CityName</th>
						<th colspan="2" style="text-align: center;">Action</th>
					</tr>
					<%
						for (int i = 0; i < getCity.size(); i++) {
							mst_mst_city city=getCity.get(i);
					%>
					<tr id=<%=i+1%>>
						<td><%=i+1%></td>
						<td><%=city.getState_name()%></td>
						<td data-target-name><%=city.getCity_name()%></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=i+1%>"
								id="update">
								<i class="fa fa-edit" style="color: green; !important"></i>
							</button></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=city.getCity_name()%>" name="action1"
								id="<%=city.getCity_name()%>"
								formname=<%=FormFieldUltilityconstant.mst_city_name%>>
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
			<jsp:include page="footer.jsp"></jsp:include>
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
						var city=$('#'+id).children('td[data-target-name]').text();
						console.log(id+city);
						
						$('#UCity').val(city);
						$('#UCityHdn').val(city);
						
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
			$cityform = $('#cityform');
			
			if($cityform.length) {
				console.log('in2');
				$("#cityform").validate({
						rules: {
							State: {
								required: true
							},
							City: {
								required: true,
								minlength: 3,
								lettersonly: true
							}				
						},
						messages: {					
							State: {
								required: 'Please select state!'
							},
							City: {
								required: 'Please enter city name!',
								minlength: 'City must have 3 characters plz enter valid state name'
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
			$cityformu = $('#cityformu');
			
			if($cityformu.length) {
				console.log('in2');
				$("#cityformu").validate({
						rules: {
							State: {
								required: true
							},
							City: {
								required: true,
								minlength: 3,
								lettersonly: true
							}				
						},
						messages: {					
							State: {
								required: 'Please select state!'
							},
							City: {
								required: 'Please enter city name!',
								minlength: 'City must have 3 characters plz enter valid state name'
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