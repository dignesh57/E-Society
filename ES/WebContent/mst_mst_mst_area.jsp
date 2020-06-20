<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.mst_mst_mst_area"%>
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
<script src="../Resources/js/Filter.js" type="text/javascript"></script>
</head>
<body>
<%registration_page rg=(registration_page)session.getAttribute("user"); 
if(rg.getRole_name().equalsIgnoreCase("Admin")){
	String state = "";
		String city = "";
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
					function OnselectChangeCity(select) {
						var selectOptionCity = select.options[select.selectedIndex];
				<%=city%>
					= selectOptionCity;
					}
				</script>
				<div class="row">
					<div class="col-md-12" id="adddiv" class="top">
					<form action="AreaController" class="form-group" method="post" id="areaform">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">Area Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_mst_mst_area_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_Area;
								for (int i = 0; i < FormFieldUltilityconstant.mst_mst_mst_area.length; i++) {
									//System.out.println(FormFieldUltilityconstant.mst_mst_mst_area[i]);
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_mst_mst_area[i]%></td>
								<%
									if (FormFieldUltilityconstant.mst_mst_mst_area[i] == "State"
												|| FormFieldUltilityconstant.mst_mst_mst_area[i] == "City") {
								%>
								<td><select
									<%if (FormFieldUltilityconstant.mst_mst_mst_area[i] == "City") {%>
									onchange="OnselectChangeCity (this)" <%} else {%>
									onchange="OnselectChangeState (this)" <%}%>
									class="custom-select <%=FormFieldUltilityconstant.mst_mst_mst_area[i] == "City" ? "citylist" : "arealist"%>"
									id="<%=FormFieldUltilityconstant.mst_mst_mst_area[i]%>"
									name="<%=FormFieldUltilityconstant.mst_mst_mst_area[i]%>">
										<%
											DbTransction dbt = new DbTransactionImpl();
													ArrayList<String> getData = new ArrayList<String>();
													if (FormFieldUltilityconstant.mst_mst_mst_area[i] == "State") {
														getData = dbt.getState();
													} else {
														getData = dbt.getCity();
													}
										%>
										<option selected><%=getData.get(0)%></option>
										<%
											for (int j = 0; j < getData.size(); j++) {
										%>
										<option id="<%=getData.get(j)%>"><%=getData.get(j)%></option>
										<%
											}
										%>
								</select></td>
								<%
									} else {
								%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_mst_mst_area[i]%>"
									name="<%=FormFieldUltilityconstant.mst_mst_mst_area[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_mst_mst_area[i]%> Please" required="required"></td>
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
									id="add"
									formname="<%=FormFieldUltilityconstant.mst_area_name%>"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
						</form>
					</div>
					
					<!-- update -->
					<div class="col-md-12" id="updatediv" class="top">
					<form action="AreaController" class="form-group" method="post" id="areaformu">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">Area Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_mst_mst_area_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_Area;
								for (int i = 0; i < FormFieldUltilityconstant.mst_mst_mst_area.length; i++) {
									//System.out.println(FormFieldUltilityconstant.mst_mst_mst_area[i]);
							%>
							
								<%
									if (FormFieldUltilityconstant.mst_mst_mst_area[i] == "Area"
									||FormFieldUltilityconstant.mst_mst_mst_area[i] == "Pincode") {
								%>
								<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_mst_mst_area[i]%></td>
								<td><input type="text"
									id="U<%=FormFieldUltilityconstant.mst_mst_mst_area[i]%>"
									name="<%=FormFieldUltilityconstant.mst_mst_mst_area[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_mst_mst_area[i]%> Please" required="required"></td>
								</tr>
								<%
									}
								%>
							
							<%
								}
							%>
							<input type="hidden" id="UAreaHdn" name="areahdn" class="form-control">
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-success" value="Update" name="action"
									formname="<%=FormFieldUltilityconstant.mst_area_name%>"></td>
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
			<%
				DbTransction dbt = new DbTransactionImpl();
				ArrayList<mst_mst_mst_area> getArea = dbt.getAreaModel();
			%>
			<form action="AreaController" class="form-group" method="post">
				<table class="table table-striped" class="table table-responsive">
					<tr>
						<th>No.</th>
						<th>StateName</th>
						<th>CityName</th>
						<th>AreaName</th>
						<th>Pincode</th>
						<th colspan="2" style="text-align: center;">Action</th>
					</tr>
					<%
						for (int i = 0; i < getArea.size(); i++) { mst_mst_mst_area area=getArea.get(i);
					%>
					<tr id=<%=i+1%>>
						<td><%=i+1%></td>
						<td><%=area.getState_name()%></td>
						<td><%=area.getCity_name()%></td>
						<td data-target-name><%=area.getArea_name()%></td>
						<td data-target-pin><%=area.getPincode()%></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=i+1%>"
								id="update">
								<i class="fa fa-edit" style="color: green; !important"></i>
							</button></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=area.getArea_name()%>" name="action1"
								id="<%=area.getArea_name()%>"
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
						var area=$('#'+id).children('td[data-target-name]').text();
						var pincode=$('#'+id).children('td[data-target-pin]').text();
						console.log(id+area);
						
						$('#UArea').val(area);
						$('#UPincode').val(pincode);
						$('#UAreaHdn').val(area);
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
					}, "Letters and spaces only please");
				
			console.log('in');
			$areaform = $('#areaform');
			
			if($areaform.length) {
				console.log('in2');
				$("#areaform").validate({
						rules: {
							State: {
								required: true
							},
							City: {
								required: true				
							},
							Area: {
								required: true,
								minlength: 3,
								lettersonly: true
							},
							Pincode: {
								required: true,
								minlength: 6,
								maxlength: 6,
								number: true
							}
						},
						messages: {					
							State: {
								required: 'Please select state!'
							},
							City: {
								required: 'Please select city!'
							},
							Area: {
								required: 'Please Enter Area Name!',
								minlength: 'Area name must have more than 3 characters'
							},
							Pincode: {
								required: 'Please Enter pincode!',
								minlength: 'Pincode have only 6 digits',
								minlength: 'Pincode have only 6 digits',
								number: 'plz enter only numbers'
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
					  return this.optional(element) || /^[a-z ]+$/i.test(value);
					}, "Letters and spaces only please");
				
			console.log('in');
			$areaformu = $('#areaformu');
			
			if($areaformu.length) {
				console.log('in2');
				$("#areaformu").validate({
						rules: {
							State: {
								required: true
							},
							City: {
								required: true				
							},
							Area: {
								required: true,
								minlength: 3,
								lettersonly: true
							},
							Pincode: {
								required: true,
								minlength: 6,
								maxlength: 6,
								number: true
							}
						},
						messages: {					
							State: {
								required: 'Please select state!'
							},
							City: {
								required: 'Please select city!'
							},
							Area: {
								required: 'Please Enter Area Name!',
								minlength: 'Area name must have more than 3 characters'
							},
							Pincode: {
								required: 'Please Enter pincode!',
								minlength: 'Pincode have only 6 digits',
								minlength: 'Pincode have only 6 digits',
								number: 'plz enter only numbers'
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