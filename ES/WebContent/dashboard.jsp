<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title><%=FormFieldUltilityconstant.webConstant%></title>
<link href="css/chart.css" rel="stylesheet" type="text/css" />
<link href="css/piChart.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
		DbTransction dbt = new DbTransactionImpl();
		ArrayList<String> getArea = dbt.getArea();
		DbTransactionServices dbts = new DbTransactionServicesImpl();
	%>
	<div class="container-fluid">
		<div class="col-md-12">
			<!-- Stats -->
			<div>
				<div class="row">
					<div class="col-md-6">
						<div
							class="stat-grid p-3 d-flex align-items-center justify-content-between bg-primary">

							<div class="s-l">
							<a href="SocietyReport.jsp">
								<h5>Registred Society</h5>
								<p class="paragraph-agileits-w3layouts text-white">View
									Details</p></a>
							</div>
							<div class="s-r">
								<h6><%=dbts.getRegisteredSocietyCount()%>
									<i class="far fa-edit"></i>
								</h6>
							</div>
						</div>
						<div
							class="stat-grid p-3 mt-3 d-flex align-items-center justify-content-between bg-success">
							<div class="s-l">
							<a href="WorkerRequests.jsp">
								<h5>Workers Request</h5>
								<p class="paragraph-agileits-w3layouts">view details</p></a>
							</div>
							<div class="s-r">
								<h6><%=dbts.getRequestedWorkerCount()%>
									<i class="far fa-smile"></i>
								</h6>
							</div>
						</div>
						<div
							class="stat-grid p-3 mt-3 d-flex align-items-center justify-content-between bg-danger">
							<div class="s-l">
							<a href="SocietyRequests.jsp">
								<h5>Society Request</h5>
								<p class="paragraph-agileits-w3layouts">view details</p></a>
							</div>
							<div class="s-r">
								<h6><%=dbts.getRequestedSocietyCount() %>
									 <i class="fas fa-tasks"></i>
								</h6>
							</div>
						</div>
						<div
							class="stat-grid p-3 mt-3 d-flex align-items-center justify-content-between bg-warning">
							<div class="s-l">
							<a href="ComplaintAdminReport.jsp">
								<h5>Complaints</h5>
								<p class="paragraph-agileits-w3layouts">view details</p></a>
							</div>
							<div class="s-r">
								<h6><%=dbts.getComplainCount()%>
									<i class="fas fa-users"></i>
								</h6>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<jsp:include page="CHARTS/PIChart.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>

		<div>
			<jsp:include page="CHARTS/BarChart.jsp"></jsp:include>
		</div>
</body>
</html>