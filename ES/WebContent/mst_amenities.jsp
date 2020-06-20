<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.mst_amenities"%>
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

</head>
<style type="text/css">
	.error{
		color: red;
 	}
</style>
<body>
<% registration_page userData=(registration_page)session.getAttribute("user"); 
if(userData.getRole_name().equalsIgnoreCase("Secretary")){
%>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

				<div class="row">
					<div class="col-md-12" id="adddiv" class="top">
					<form action="AmenitiesController" class="form-group" method="post" id="amenitiesform">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'"
							style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_amenities_title%></h4></th>
							</thead>
							<%-- <tr>
								<td><input type="hidden"
									id="<%=FormFieldUltilityconstant.mst_society[0]%>"
									name="<%=FormFieldUltilityconstant.mst_society[0]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_society[0]%> Please"></td>
								</td>
							</tr> --%>
							<%
								//String[] field = FormFieldUltilityconstant.mst_amenities;
								for (int i = 1; i < FormFieldUltilityconstant.mst_amenities.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_amenities[i]%></td>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_amenitiesinsert[i]%>"
									name="<%=FormFieldUltilityconstant.mst_amenities[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.mst_amenities[i]%> Please"></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add" name="action"
									formname="<%=FormFieldUltilityconstant.mst_amenities_name%>"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
							
						</table>
						</form>
					</div>
					<!-- update div -->
					<div class="col-md-12" id="updatediv" class="top">
					<form action="AmenitiesController" class="form-group" method="post" id="amenitiesformu">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'"
							style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_amenities_title%></h4></th>
							</thead>
							<%
								for (int i = 1; i < FormFieldUltilityconstant.mst_amenities.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_amenities[i]%></td>
								<td><input type="text"
									id="U<%=FormFieldUltilityconstant.mst_amenitiesupdate[i]%>"
									name="<%=FormFieldUltilityconstant.mst_amenities[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_amenities[i]%> Please" required="required"></td>
							</tr>
							<%
								}
							%>
							<input type="hidden" id="UIdHdn" name="id" class="form-control">
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-success" value="Update" name="action"
									formname="<%=FormFieldUltilityconstant.mst_amenities_name%>"></td>
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
		<h4>Amenities Details</h4><br>
			
					<%
			String secretaryid=userData.getEmail_id();
//			String secretaryid="karanmmodi1998@gmail.com";
			DbTransction dbt = new DbTransactionImpl();
			String socid = dbt.getSocietyID(secretaryid);
			System.out.println(socid);
			ArrayList<mst_amenities> getAmenities = dbt.getAmenitiesDetails(socid);
					%>
					<form action="AmenitiesController" class="form-group" method="post">
					<table class="table table-striped" class="table table-responsive">
							<tr>
								<th>No</th>
								<th>Amenities Name</th>
								<th>Rent per Day</th>
								<th colspan="2" style="text-align: center;">Action</th>
							</tr>
							<%
								for (int i = 0; i < getAmenities.size(); i++) {
									mst_amenities ameniti = getAmenities.get(i);
							%>
							<tr id=<%=ameniti.getAmenities_id()%>>
								<td><%=i+1 %></td>
								<td data-target-name><%=ameniti.getAmenities_name()%></td>
								<td data-target-rent><%=ameniti.getRent()%></td>
								<td><button class="btn btn-link"
								type="button" value="<%=ameniti.getAmenities_id()%>"
								id="update">
								<i class="fa fa-edit" style="color: green; !important"></i>
							</button>
						</td>
						<td><button class="btn btn-link"
								type="submit" value="<%=ameniti.getAmenities_id()%>" name="action1"
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
			<script type="text/javascript">
				$(document).ready(function(){
					$('#adddiv').fadeIn("slow");
					$('#updatediv').hide();
					
					$(document).on('click','#update',function(){
						console.log("hii");
						event.preventDefault();
						$('#adddiv').hide();
						$('#updatediv').fadeIn("slow");;
						
						var id=$(this).val();
						var name=$('#'+id).children('td[data-target-name]').text();
						var rent=$('#'+id).children('td[data-target-rent]').text();
						console.log(id+name+rent);
						
						$('#UName').val(name);
						$('#URent').val(rent);
						$('#UIdHdn').val(id);
						
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
					  return this.optional(element) || /^[a-z ]+$/i.test(value);
					}, "Letters and Spaces only please");
				
			console.log('in');
			$amenitiesform = $('#amenitiesform');
			
			if($amenitiesform.length) {
				console.log('amenitiesform');
				
				$("#amenitiesform").validate({
						rules: {
							Name: {
								required: true,
								minlength: 3,
								lettersonly: true
							},
							Rent: {
								required: true,
								number: true
							}				
						},
						messages: {					
							Name: {
								required: 'Please Enter Amenties name!',
								minlength: 'Amenities name must have 3 characters plz enter valid state name'
							},
							Rent: {
								required: 'Please enter rent of amenities!',
								number: 'please enter only numbers'
								
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
				
			console.log('in4');
			$amenitiesformu = $('#amenitiesformu');
			
			if($amenitiesformu.length) {
				console.log('in2');
				$("#amenitiesformu").validate({
						rules: {
							Name: {
								required: true
							},
							Rent: {
								required: true,
								minlength: 3
							}				
						},
						messages: {					
							Name: {
								required: 'Please select state!'
							},
							Rent: {
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