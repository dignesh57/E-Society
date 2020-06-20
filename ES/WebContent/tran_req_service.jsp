<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title><%=FormFieldUltilityconstant.webConstant %></title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Startup Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
	addEventListener("load", function() {
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

</head>
<%
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
%>
<body>
	<%
		String service = "";
	%>
	<jsp:include page="UserHeader.jsp"></jsp:include>
	<!-- main banner -->
	<div class="row" style="background-image: url('images/bg01.jpg');">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<form action="RequestServicesController" class="form-group"
				method="post" style="margin-top: 100px; !important">
				<script type="text/javascript">
					function OnSelectionService(select) {
						var selectedOption = select.options[select.selectedIndex];
				<%=service%>
					= selectedOption.value;
					}
				</script>
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.tran_req_service_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_tax;
								for (int i = 0; i < FormFieldUltilityconstant.tran_req_service.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.tran_req_service[i]%></td>
									<%if(FormFieldUltilityconstant.tran_req_service[i].equalsIgnoreCase("House No")){ %>
									<td><input type="text"
									id="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									name="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									class="form-control" disabled="disabled" required="required"
									value="<%=DbTransactionServicesImpl.getMemberIdUser(userData.getEmail_id())%>"
									placeholder="<%=DbTransactionServicesImpl.getMemberIdUser(userData.getEmail_id())%>"></td>
								<%
									} else if (FormFieldUltilityconstant.tran_req_service[i].equalsIgnoreCase("Society Name")) {
								%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									name="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									class="form-control" disabled="disabled" required="required"
									value="<%=DbTransactionServicesImpl.getSocName(userData.getEmail_id())%>"
									placeholder="<%=DbTransactionServicesImpl.getSocName(userData.getEmail_id())%>"></td>
								<%
									} else if (FormFieldUltilityconstant.tran_req_service[i].equalsIgnoreCase("Service Type")) {
								%>
								<td><select onchange="OnSelectionService (this)"
									class="custom-select"
									id="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									name="<%=FormFieldUltilityconstant.tran_req_service[i]%>">
										<%
											DbTransction dbt = new DbTransactionImpl();
													DbTransactionServices dbts = new DbTransactionServicesImpl();
													ArrayList<String> getServiceType = dbts.getService();
										%><option selected><%=getServiceType.get(0)%></option>
										<%
											for (int j = 1; j < getServiceType.size(); j++) {
										%>
										<option id="<%=getServiceType.get(j)%>"><%=getServiceType.get(j)%></option>
										<%
											}
										%>

								</select></td>
								<%
									} else if (FormFieldUltilityconstant.tran_req_service[i].equalsIgnoreCase("Date")) {
								%>
								<td><input type="date"
									id="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									name="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.tran_req_service[i]%> Please"></td>
								<%
									} else if ((FormFieldUltilityconstant.tran_req_service[i]
												.equalsIgnoreCase("Your Problem Description"))) {
								%>
								<td><textarea
										id="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
										name="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
										class="form-control" required="required"
										placeholder="<%=FormFieldUltilityconstant.tran_req_service[i]%> Please">
								</textarea></td>
								<%
									} else if (FormFieldUltilityconstant.tran_req_service[i].equalsIgnoreCase("Time From")
												|| (FormFieldUltilityconstant.tran_req_service[i].equalsIgnoreCase("To"))) {
								%>
								<td><input type="time"
									id="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									name="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.tran_req_service[i]%> Please"></td>
								<%
									} else {
								%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									name="<%=FormFieldUltilityconstant.tran_req_service[i]%>"
									class="form-control" required="required"
									placeholder="Your <%=FormFieldUltilityconstant.tran_req_service[i]%> Please"></td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Request"
									formname="<%=FormFieldUltilityconstant.tran_req_service_name%>"
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
	<jsp:include page="UserFooter.jsp"></jsp:include>
</body>
</html>