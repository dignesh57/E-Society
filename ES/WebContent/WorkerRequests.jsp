<%@page import="com.es.model.register_worker"%>
<%@page import="com.es.model.tran_req_services"%>
<%@page import="com.es.model.mst_status"%>
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
<title><%=FormFieldUltilityconstant.webConstant%></title>
</head>
<%registration_page rg=(registration_page)session.getAttribute("user"); 
if(rg.getRole_name().equalsIgnoreCase("Admin")){
%>
<body>
	<%
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		DbTransction dbt = new DbTransactionImpl();
		//tran_req_services reqservices = new tran_req_services();
		ArrayList<register_worker> getWorkers = dbt.getRequestedWorker();

		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<!-- Stats -->
			<div class="outer-w3-agile col-xl">
				<div class="work-progres">

					<form action="RequestedWorkerController" method="post">
						<div class="table-responsive">
							<table class="table table-striped">
								<tbody>
									<tr class="<%=hth.getWorkerRequest().getTableClass()%>">
										<th style="color: black;"><b><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getWorkerRequest(),
					ReportConstant.workerReq, dbts.getRequestedWorkerCount())%></b></th>
									</tr>
									<%
										for (int i = 0; i < getWorkers.size(); i++) {
											register_worker regWorker = dbt.getRequestedWorker().get(i);
									%>
									<tr>
										<td><%=regWorker.getRole()%></td>
										<td><%=regWorker.getService_type()%></td>

										<td><%=regWorker.getService_desc()%></td>

										<td><%=regWorker.getW_name()%></td>

										<td><%=regWorker.getW_email()%></td>

										<td><%=regWorker.getAddress()%></td>

										<td><%=regWorker.getArea()%></td>

										<td><%=regWorker.getCity()%></td>

										<td><%=regWorker.getState()%></td>

										<td><%=regWorker.getPincode()%></td>

										<td><%=regWorker.getW_phone()%></td>

										<td><%=regWorker.getW_gender()%></td>

										<td><%=regWorker.getAvailable_from()%></td>

										<td><%=regWorker.getAvailable_to()%></td>

										<td><%=regWorker.getId_proof()%></td>

										<td><%=regWorker.getId_number()%></td>

										<td><a
											href="images/workerid/<%=regWorker.getId_upload()%>"
											style="color: blue"><%=regWorker.getId_upload()%></a></td>

										<td colspan="2" style="text-align: center;"><button
												class="btn btn-link" type="submit" value="<%=regWorker.getW_email()%>"
												name="action" id="<%=i%>"
												formname=<%=FormFieldUltilityconstant.register_worker_name%>>
												<i class="fa fa-check" style="color: green; !important"></i>
											</button></td>

										<td colspan="2" style="text-align: center;"><button
												class="btn btn-link" type="submit" value="<%=regWorker.getW_email()%>"
												name="action1" id="<%=i%>"
												formname=<%=FormFieldUltilityconstant.register_worker_name%>>
												<i class="fa fa-times" style="color: red; !important"></i>
											</button></td>
										<%
											}
										%>
									</tr>
								</tbody>
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

<%}else{ 
	response.sendRedirect("Page_not_found.jsp");
} %>
</body>
</html>