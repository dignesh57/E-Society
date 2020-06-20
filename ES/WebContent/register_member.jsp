<%@page import="com.es.model.mst_society"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.model.register_society"%>
<%@page import="com.es.model.mst_complain"%>
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
<link rel="stylesheet" type="text/css" href="User/vendor/jquery/jquery-ui.min.css">
<style type="text/css">
	.error{
		color: red;
 	}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>

<body>

	<%
		String state = "", city = "", area = "", id = "", soc_name = "", soc_wing = "";
	%>

	<!-- main banner -->
	<div class="row" style="background-color:rgb(79, 191, 168);">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<form action="RegisterMemberController" class="form-group"
				method="post" enctype="multipart/form-data" id="memform">
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'"
							style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.register_member_title%></h4></th>
							</thead>
							<tr>
								<td><input type="hidden"
									id="<%=FormFieldUltilityconstant.register_member[0]%>"
									name="<%=FormFieldUltilityconstant.register_member[0]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.register_member[0]%> Please"></td>
							</tr>
							<%
								//String[] field = FormFieldUltilityconstant.mst_tax;
								for (int i = 1; i < FormFieldUltilityconstant.register_member.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.register_member[i]%></td>

								<%
									if (FormFieldUltilityconstant.register_member[i] == "State"
												|| FormFieldUltilityconstant.register_member[i] == "City"
												|| FormFieldUltilityconstant.register_member[i] == "Area"
												|| FormFieldUltilityconstant.register_member[i] == "ID Proof"
												|| FormFieldUltilityconstant.register_member[i] == "Wing"
												|| FormFieldUltilityconstant.register_member[i] == "SocietyName") {
								%>
								<td <%if (FormFieldUltilityconstant.register_member[i] == "Wing"){%>id="wing"
								<%} else if (FormFieldUltilityconstant.register_member[i] == "City"){%>id="cityd"
								<%} else if (FormFieldUltilityconstant.register_member[i] == "SocietyName"){%>id="soc"
								<%} else if (FormFieldUltilityconstant.register_member[i] == "Area"){%>id="aread"<%} %>><select class="custom-select"
									id="<%=FormFieldUltilityconstant.register_member[i]%>"
									name="<%=FormFieldUltilityconstant.register_member[i]%>">
										<%
											DbTransction dbt = new DbTransactionImpl();
													DbTransactionServices dbts = new DbTransactionServicesImpl();

													ArrayList<String> getData = dbt.getState();
													if (FormFieldUltilityconstant.register_member[i] == "State") {
														getData = dbt.getState();
													} else if (FormFieldUltilityconstant.register_member[i] == "City") {
														getData = dbt.getCity();
													} else if (FormFieldUltilityconstant.register_member[i] == "Service Type") {
														getData = dbts.getService();
													} else if (FormFieldUltilityconstant.register_member[i] == "ID Proof") {
														getData = dbt.getID();
													} else if (FormFieldUltilityconstant.register_member[i] == "SocietyName") {
														getData = dbts.getSocName();
													} else if (FormFieldUltilityconstant.register_member[i] == "Wing") {
														getData = dbts.getSocWing();
													} else {
														getData = dbt.getArea();
													}
										%>
										<option disabled selected>Choose..</option>
										<%
											for (int j = 0; j < getData.size(); j++) {
										%>
										<option id="<%=getData.get(j)%>"><%=getData.get(j)%></option>
										<%
											}
										%>
								</select></td>
								<%
									} else if (FormFieldUltilityconstant.register_member[i] == "Gender") {
								%>
								<td><select class="custom-select"
									onchange="OnselectGender (this)"
									id="<%=FormFieldUltilityconstant.register_member[i]%>"
									required="required"
									name="<%=FormFieldUltilityconstant.register_member[i]%>">
										<option disabled selected>Choose...</option>
										<option>Male</option>
										<option>Female</option>
										<option>Other</option>
								</select></td>
								<%
									} else if (FormFieldUltilityconstant.register_member[i] == "ID Upload") {
								%>
								<td><input type="file"
									id="<%=FormFieldUltilityconstant.register_member[i]%>"
									name="<%=FormFieldUltilityconstant.register_member[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.register_member[i]%> Please" required="required"></td>
								<%
									} else {
								%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.register_member[i]%>"
									name="<%=FormFieldUltilityconstant.register_member[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.register_member[i]%> Please" required="required"></td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-dark" value="Register Now"
									id="add"
									formname="<%=FormFieldUltilityconstant.register_member_name%>"
									name="action"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
					</div>
				</div>
			</form>
			<div class="col-md-3"></div>
		</div></div>
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script>
        $(document).ready(function(){
            $('#State').on('change',function(){
            	event.preventDefault();
    			var option=$(this).val();
    			$.ajax({
    				type: 'POST',
    			    url: 'city.jsp',
    			    data: {value:option},
    			  	success: function(data){
    				 	
    				 	$('#cityd').html(data);
    				}	  
    			});
    		});
            
            })
    </script>
	<script src="js/jquery.validate.min.js"></script>
			<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
			<script type="text/javascript">
			$(document).ready(function(){
			
				jQuery.validator.addMethod("lettersonly", function(value, element) {
					  return this.optional(element) || /^[a-z ]+$/i.test(value);
					}, "Letters and spaces only please");
				
			console.log('in');
			$memform = $('#memform');
			
			if($memform.length) {
				console.log('in2');
				$("#memform").validate({
					rules: {
						State: {
							required: true
						},
						City: {
							required: true
						},
						Area: {
							required: true
						},
						SocietyName: {
							required: true
						},
						Wing: {
							required: true
						},
						Pincode: {
							required: true,
							minlength:6,
							maxlength:6
						},
						Name: {
							required: true,
							minlength:4,
							lettersonly:true
						},
						Email: {
							required: true,
							email:true
						},
						Gender: {
							required: true
						}
					},
					messages: {					
							State: {
								required: 'Please Select State!'
							},
							City: {
								required: 'Please Select City!'
							},
							Area: {
								required: 'Please Select Area!'
							},
							SocietyName: {
								required: 'Please Enter Your Society Address!'
							},
							Wing: {
								required: 'Please Enter Landmark!'
							},
							Name: {
								required: 'Please Enter Your Name!',
								minlength: 'Please Enter minimum 4 characters...!'
							},
							Email: {
								required: 'Please Enter Your Email!',
								email: 'Please Enter valid Email'
							},
							Gender: {
								required: 'Please Select Gender!'
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
		
</body>
</html>