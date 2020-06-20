<%@page import="com.es.model.notice"%>
<%@page import="com.es.model.registration_page"%>
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
<% registration_page userData=(registration_page)session.getAttribute("user"); 
if(userData.getRole_name().equalsIgnoreCase("Secretary")){
%>
<body>

	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<form action="NoticeController" class="form-group" method="post" id="noticeform">
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.notice_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_expense;
								for (int i = 0; i < FormFieldUltilityconstant.notice.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.notice[i]%></td>
								<td><textarea
									id="<%=FormFieldUltilityconstant.notice[i]%>"
									name="<%=FormFieldUltilityconstant.notice[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.notice[i]%> Please"></textarea></td>
								
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add"
									formname="<%=FormFieldUltilityconstant.notice_name%>"
									name="action"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div><h4>Notice Details</h4><br>
			
			<%
			String secretaryid=userData.getEmail_id();
//			String secretaryid="karanmmodi1998@gmail.com";
			DbTransction dbt = new DbTransactionImpl();
			String socid = dbt.getSocietyID(secretaryid);
			System.out.println(socid);
			ArrayList<notice> getnotices = dbt.getNotices(socid);
					%>
					<form action="NoticeController" class="form-group" method="post">
						<table class="table table-striped table-responsive">
							<tr>
								<th>No</th>
								<th>Notice</th>
								<th>Entered on</th>
								<th>Action</th>
							</tr>
							<%
								for (int i = 0; i < getnotices.size(); i++) {
									notice ntc = getnotices.get(i);
							%>
							<tr>
								<td><%=i+1%></td>
								<td><%=ntc.getNotice()%></td>
								<td><%=ntc.getEntered_on()%></td>
								<td><button class="btn btn-link"
								type="submit" value="<%=ntc.getNotice_id()%>" name="action1"
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
			<script src="js/jquery.validate.min.js"></script>
			<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
			<script type="text/javascript">
			$(document).ready(function(){
			
				
			console.log('in');
			$noticeform = $('#noticeform');
			
			if($noticeform.length) {
				console.log('in2');
				$("#noticeform").validate({
					rules: {
						Notice: {
							required: true,
							minlength:10
						}				
					},
					messages: {					
							Notice: {
								required: 'Please Enter Your Notice!',
								minlength: 'Please Enter minimum 10 characters...!'
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