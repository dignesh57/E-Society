<%@page import="java.util.ArrayList"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.es.model.tran_maintainance"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.model.registration_page"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>E-Society</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Startup Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
<!-- //Meta tag Keywords -->

<!-- Custom-Files -->
<link rel="stylesheet" href="User/css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="User/css/style.css" type="text/css"
	media="all" />
<!-- Style-CSS -->
<link href="User/css/font-awesome.min.css" rel="stylesheet">
<!-- Font-Awesome-Icons-CSS -->
<!-- //Custom-Files -->

<!-- Web-Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
	rel="stylesheet">
<!-- //Web-Fonts -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>
<body>
	<%
	
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
	
	DbTransction dbt=new DbTransactionImpl();
	ArrayList<tran_maintainance> allmaintainance=dbt.getAllMaintainaceInfo(userData.getEmail_id()); 
	
%>

	<jsp:include page="UserHeader.jsp"></jsp:include>
	<div class="row" style="margin-top: 100px; !important">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		<%if(request.getAttribute("msg")!=null){ %>
		 	<h5 style="text-align: center;color:<%if(request.getAttribute("msg")=="success"){ %>green<%}else {%>red<%} %>  !important"><%if(request.getAttribute("msg")=="success"){ %>Payment Successful<%}else {%>Payment Failed<%} %></h5>
		 <%} %>
		<h4 class="main-title-w3layouts mb-2 text-center">Your Maintainance Details</h4><br>
			<table id="example" class="table table-striped table-responsive" style="width: 100%">
				<thead>
					<tr>
						<th>No</th>
						<th>Amount</th>
						<th>Generated Date</th>
						<th>Due Date</th>
						<th>status</th>
						<th>Receipt</th>
					</tr>
				</thead>
				<tbody>
				<%for(int i=0;i<allmaintainance.size();i++){ 
					tran_maintainance m=allmaintainance.get(i);
					LocalDate date = (m.getGenerated_date()).toLocalDate();
					LocalDate duedate = (m.getDue_date()).toLocalDate();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
					String gen_date = date.format(formatter);
					String due_date = duedate.format(formatter);
				%>
					<tr>
						<form action="MaintainanceReciept.jsp" class="form-group" method="post">
						<td><%=i+1 %></td>
						<td><%=m.getTotal_amount() %></td>
						<td><%=gen_date %></td>
						<td><%=due_date %></td>
						<td><%=m.getStatus() %></td>
						<td><button class="btn btn-link"
								type="submit" value="<%=m.getInvoice_id()%>" name="action"
								id="<%=m.getInvoice_id()%>">
								<i class="fa fa-info-circle" style="color: green; !important"></i>
							</button></td>
						</form>
					</tr>
				<%} %>
				</tbody>
			</table>
		</div>
	</div><br>
	<jsp:include page="UserFooter.jsp"></jsp:include>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function() {
        $('#example').DataTable({searching: false, paging: false, info: false});
    } );
    </script>
</body>
</html>