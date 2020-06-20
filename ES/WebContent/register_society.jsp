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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" />
	<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body style="background-color: blue;">
	<style type="text/css">
        .mul-select{
            width: 100%;
        }
    </style>
    <style type="text/css">
	.error{
		color: red;
 	}
</style>
	<%
		String state = "", city = "", area = "", id = "";
		//ArrayList<String> soc_type=new ArrayList<String>();
	%>
	<div class="row" style="background-color:rgb(79, 191, 168);">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<form action="SocietyController" class="form-group" method="post" enctype="multipart/form-data" id="socform">
				
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'"
							style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.register_society_title%></h4></th>
							</thead>
							<tr>
								<td><input type="hidden"
									id="<%=FormFieldUltilityconstant.register_society[0]%>"
									name="<%=FormFieldUltilityconstant.register_society[0]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.register_society[0]%> Please"></td>
							</tr>
							<%
								//String[] field = FormFieldUltilityconstant.register_society;

								for (int i = 1; i < FormFieldUltilityconstant.register_society.length; i++) {
							%>

							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.register_society[i]%></td>
								<%
									if (FormFieldUltilityconstant.register_society[i] == "State"
												|| FormFieldUltilityconstant.register_society[i] == "City"
												|| FormFieldUltilityconstant.register_society[i] == "Area"
												|| FormFieldUltilityconstant.register_society[i] == "ID Proof") {
								%>
								<td <%if (FormFieldUltilityconstant.register_society[i] == "City"){%>id="cityd"
								<%} else if (FormFieldUltilityconstant.register_society[i] == "Area"){%>id="aread"<%} %>><select class="custom-select"
									id="<%=FormFieldUltilityconstant.register_society[i]%>"
									name="<%=FormFieldUltilityconstant.register_society[i]%>" required="required">
										<%
											DbTransction dbt = new DbTransactionImpl();
													ArrayList<String> getData = dbt.getState();
													if (FormFieldUltilityconstant.register_society[i] == "State") {
														getData = dbt.getState();
													} else if (FormFieldUltilityconstant.register_society[i] == "City") {
														getData = dbt.getCity();
													} else if (FormFieldUltilityconstant.register_society[i] == "ID Proof") {
														getData = dbt.getID();
													} else {
														getData = dbt.getArea();
													}
										%>
										<option selected="selected" disabled="disabled">choose...</option>
										<%
											for (int j = 0; j < getData.size(); j++) {
										%>
										<option id="<%=getData.get(j)%>"><%=getData.get(j)%></option>
										<%
											}
										%>
								</select></td>
								<%
									} else if (FormFieldUltilityconstant.register_society[i] == "Gender") {
								%>
								<td><select class="custom-select"
									id="<%=FormFieldUltilityconstant.register_society[i]%>"
									required="required"
									name="<%=FormFieldUltilityconstant.register_society[i]%>">
										<option disabled selected>Choose...</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
										<option value="Other">Other</option>
								</select></td>
								<%
									} else if (FormFieldUltilityconstant.register_society[i] == "Society Type") {
								%>
								<td><select class="custom-select"
									required="required"
									name="<%=FormFieldUltilityconstant.register_society[i]%>">
										<option disabled selected>Choose...</option>
										<%
											for (int v = 1; v <= 10; v++) {
										%>
										<option id="<%=v%>BHK"><%=v%>BHK
										</option>
										<%
											}
										%>
								</select></td>
								<%
									} else if (FormFieldUltilityconstant.register_society[i] == "Name of Wings") {
								%>
								<td><select class="mul-select" multiple="true"
									id="<%=FormFieldUltilityconstant.register_society[i]%>"
									required="required"
									name="<%=FormFieldUltilityconstant.register_society[i]%>" multiple>
										<%
											for (char j = 'A'; j < 'G'; j++) {
										%>
										<option value="<%=j%>"><%=j%></option>
										<%
											}
										%>
								</select></td>
								<%
									} else if(FormFieldUltilityconstant.register_society[i]=="ID Upload") {
								%>
									<td><input type="file"
									id="<%=FormFieldUltilityconstant.register_society[i]%>"
									name="<%=FormFieldUltilityconstant.register_society[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.register_society[i]%> Please" required="required"></td>
								<%
									}else{
								%>
									<td><input type="text"
									id="<%=FormFieldUltilityconstant.register_society[i]%>"
									name="<%=FormFieldUltilityconstant.register_society[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.register_society[i]%> Please" required="required"></td>								
								<%} %>
							</tr>
							<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							<%
								}
							%>

							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-dark" value="Register Now"
									formname="<%=FormFieldUltilityconstant.register_society_name%>"
									name="action"></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		
	<script>
        $(document).ready(function(){
            $(".mul-select").select2({
                    placeholder: "select wings", //placeholder
                    tags: true,
                    tokenSeparators: ['/',',',';'," "] 
                });
            
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
			$socform = $('#socform');
			
			if($socform.length) {
				console.log('in2');
				$("#socform").validate({
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
						Address: {
							required: true,
							minlength:10
						},
						LandMark: {
							required: true,
							minlength:4
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
							Address: {
								required: 'Please Enter Your Society Address!',
								minlength: 'Please Enter minimum 10 characters...!'
							},
							Landmark: {
								required: 'Please Enter Landmark!',
								minlength: 'Please Enter minimum 4 characters...!'
							},
							Pincode: {
								required: 'Please Enter Pincode!',
								minlength: 'Please Enter 6 characters...!',
								maxlength: 'Please Enter 6 characters...!'
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