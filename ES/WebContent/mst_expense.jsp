<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.mst_expense"%>
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
<% registration_page userData=(registration_page)session.getAttribute("user"); 
if(userData.getRole_name().equalsIgnoreCase("Secretary")){
%>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<div class="row">
					<div class="col-md-12" id="adddiv" class="top">
					<form action="ExpenseController" class="form-group" method="post" id="expenseform">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_expense_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_expense;
								for (int i = 0; i < FormFieldUltilityconstant.mst_expense.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_expense[i]%></td>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_expense[i]%>"
									name="<%=FormFieldUltilityconstant.mst_expense[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.mst_expense[i]%> Please"></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add"
									formname="<%=FormFieldUltilityconstant.mst_expense_name%>"
									name="action"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
						</form>
					</div>
					
					<div class="col-md-12" id="updatediv" class="top">
					<form action="ExpenseController" class="form-group" method="post" id="expenseformu">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_expense_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_expense;
								for (int i = 0; i < FormFieldUltilityconstant.mst_expense.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_expense[i]%></td>
								<td><input type="text"
									id="U<%=FormFieldUltilityconstant.mst_expenseupdate[i]%>"
									name="<%=FormFieldUltilityconstant.mst_expense[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.mst_expense[i]%> Please"></td>
							</tr>
							<%
								}
							%>
							<input type="hidden" id="UIdHdn" name="id" class="form-control">
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-success" value="Update"
									formname="<%=FormFieldUltilityconstant.mst_expense_name%>"
									name="action"></td>
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
		<div><h4>Expense Details</h4><br>
			<%
			String secretaryid=userData.getEmail_id();
//			String secretaryid="karanmmodi1998@gmail.com";
			DbTransction dbt = new DbTransactionImpl();
			String socid = dbt.getSocietyID(secretaryid);
			System.out.println(socid);

			ArrayList<mst_expense> getExpense = dbt.getAllExpense(socid);
			%>
			<form action="ExpenseController" class="form-group" method="post">
				<table class="table table-striped table-responsive">
					<tr>
						<th>No</th>
						<th>Expense Name</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<%
						for (int i = 0; i < getExpense.size(); i++) {
							mst_expense expense=getExpense.get(i);
					%>
					<tr id=<%=expense.getExp_id()%>>
						<td><%=i+1%></td>
						<td data-target-name><%=expense.getExp_type()%></td>
						<td data-target-price><%=expense.getPrice()%></td>
						<td><button class="btn btn-link"
								type="button" value="<%=expense.getExp_id()%>"
								id="update">
								<i class="fa fa-edit" style="color: green; !important"></i>
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
						var price=$('#'+id).children('td[data-target-price]').text();
						console.log(id);
						
						$('#UExpense').val(name);
						$('#UPrice').val(price);
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
					  return this.optional(element) || /^[a-z]+$/i.test(value);
					}, "Letters only please");
				
			console.log('in');
			$expenseform = $('#expenseform');
			
			if($expenseform.length) {
				console.log('in2');
				$("#expenseform").validate({
					rules: {
						Price: {
							required: true,
							number: true
						}				
					},
					messages: {					
							Price: {
								required: 'Please Enter Price!',
								number: 'Please Enter Digits only...!'
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
			$expenseformu = $('#expenseformu');
			
			if($expenseformu.length) {
				console.log('in2');
				$("#expenseformu").validate({
						rules: {
							Expense:{
								required:true
							},
							Price: {
								required: true,
								number: true
							}				
						},
						messages: {	
							Expense:{
								required: 'please eneter expense type'
							},
							Price: {
								required: 'Please Enter Price!',
								number: 'Please Enter Digits only...!'
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