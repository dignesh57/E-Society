<%@page import="com.es.model.mst_society"%>
<%@page import="com.es.formDesignUltility.ReportConstant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeaderParam"%>
<%@page import="com.es.formDesignUltility.HtmlReportHeaderDesign"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<body>
<%registration_page rg=(registration_page)session.getAttribute("user"); 
if(rg.getRole_name().equalsIgnoreCase("Admin")){
%>
	<%
		DbTransction dbt = new DbTransactionImpl();
		DbTransactionServices dbts = new DbTransactionServicesImpl();
	%>

	<jsp:include page="header.jsp"></jsp:include>
	<%
		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<div class="container-fluid">
	<div class="row">
                    <!-- Stats -->
                    <div class="outer-w3-agile col-xl">
                        <div class="work-progres">

		
			<div class="table-responsive">
			<table class="table table-striped">
			<tbody>
				<tr class="<%=hth.getSocietyRequest().getTableClass()%>">
					<th><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getSocietyRequest(),
					ReportConstant.society,dbts.getRegisteredSocietyCount())%></th>
				</tr>
				<%
					for (int i = 0; i < dbt.getRegisteredSocietyData().size(); i++) {
						mst_society society=dbt.getRegisteredSocietyData().get(i);
				%>
				<tr id=<%=society.getEmail()%>>
				<form action="SocietyController" method="post">
					<td><%=society.getRole()%></td>
					<td><%=society.getSociety_name()%></td>
					<td><%=society.getSociety_type()%></td>
					<td><%=society.getAddress()%></td>
					<td><%=society.getLandmark()%></td>
					<td><%=society.getArea()%></td>
					<td><%=society.getCity()%></td>
					<td><%=society.getState()%></td>
					<td><%=society.getPincode()%></td>
					<td><%=society.getName_of_wings()%></td>
					<td><%=society.getTotal_number_of_house()%></td>
					<td><%=society.getName()%></td>
					<td><%=society.getEmail()%></td>
					<td><%=society.getPhone_no()%></td>
					<td><%=society.getGender()%></td>
					<td><%=society.getId_proof()%></td>
					<td><%=society.getId_number()%></td>
					<td><%=society.getId_upload()%></td>
					<td>
						<td><button class="btn btn-link"
								type="submit" value="<%=society.getEmail()%>" name="action1"
								id="<%=society.getEmail()%>">
								<i class="fa fa-trash" style="color: red; !important"></i>
							</button>
						</td>
						</form>
				</tr>
				<%
					}
				%>
				</tbody>
			</table></div>
		
	</div>
	</div>
	</div>
	</div>

	
<!--     update modal
			<div class="modal fade" id="addpostmodal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Update Details</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">

							<form id="addpostform" action="SocietyController" method="post"
								enctype="multipart/form-data">

								
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Email:</label>
          	 	 					<input type="text" class="form-control" id="Uemail" readonly="readonly">
								</div>
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Name:</label>
          	 	 					<input type="text" class="form-control" id="Uname">
								</div>
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Phone:</label>
          	 	 					<input type="text" class="form-control" id="Uphone">
								</div>
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Society Name:</label>
          	 	 					<input type="text" class="form-control" id="Usoc">
								</div>
								<div class="container text-center">
									<button type="submit" class="btn btn-outline-primary"
										name="action" value="update">Update</button>
								</div>

							</form>


						</div>

					</div>
				</div>
			</div>
			update modal end -->
			<jsp:include page="footer.jsp"></jsp:include>
			<!-- <script src='js/jquery-2.2.3.min.js'></script>
			<script type="text/javascript">
				$(document).ready(function(){
					$(document).on('click','#update',function(){
						console.log("hii");
						event.preventDefault();
						
						var id=$(this).val();
						console.log(id);
						var name=$('#'+id).children('td[data-target-name]').text();
						var phone=$('#'+id).children('td[data-target-phone]').text();
						var soc=$('#'+id).children('td[data-target-soc]').text();
						console.log(id+state);
						
						$('#Uemail').val(id);
						$('#Uname').val(name);
						$('#Usoc').val(soc);
						$('#Uphone').val(phone);
					})
					
				});
			</script> -->
<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>

</body>
</html>