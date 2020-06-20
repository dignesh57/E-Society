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
<body>
	<%
		String status = "", worker = "";
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		DbTransction dbt = new DbTransactionImpl();
		//tran_req_services reqservices = new tran_req_services();
		ArrayList<tran_req_services> getwork = dbt.getRequestDetails();
		ArrayList<String> getAllStatus = dbts.getStatus();
		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div>
		<form action="tran_ServiceWorkerRequest" method="post">
			<script type="text/javascript">
				function OnselectChangeStatus(select) {
					var selectOptionStatus = select.option[select.selectdIndex];
			<%=status%>
				= selectOptionStatus;
				}
				function OnselectChangeWorker(select) {
					var selectOptionWorker = select.option[select.selecedIndex];
			<%=worker%>
				= selectOptionWorker;
				}
			</script>
			<table class="table table-responsive' data-height='450' data-width='200'
				data-show-columns='true' data-search='true'"
				style="border-collapse: inherit; !important">
				<tr class="<%=hth.getUserRequest().getTableClass()%>">
					<th style="color: black;"><b><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getUserRequest(), ReportConstant.report2,dbts.requestCount())%></b></th>
				</tr>
				<%
					for (int i = 0; i < getwork.size(); i++) {
						tran_req_services workerRequest = dbt.getRequestDetails().get(i);
				%>
				<tr>
					<td><select class="custom-select"
						onchange="OnselectChangeStatus (this)"
						id="<%=FormFieldUltilityconstant.ServiceRequest[0]%>"
						name="<%=FormFieldUltilityconstant.ServiceRequest[0]%>">
							<option selected><%=getAllStatus.get(2)%></option>
							<%
								for (int j = 0; j < getAllStatus.size(); j++) {
							%>
							<option id="<%=getAllStatus.get(j)%>"><%=getAllStatus.get(j)%></option>
							<%
								}
							%>
					</select></td>
					<td><select class="custom-select"
						onchange="OnselectChangeWorker (this)"
						id="<%=FormFieldUltilityconstant.ServiceRequest[1]%>"
						name="<%=FormFieldUltilityconstant.ServiceRequest[1]%>">
							<%
								ArrayList<String> getWorker = dbts.getServiceWorker(workerRequest.getService_name());
							%>
							<option selected>Select</option>
							<%
								for (int j = 0; j < getWorker.size(); j++) {
							%>
							<option id="<%=getWorker.get(j)%>"><%=getWorker.get(j)%></option>
							<%
								}
							%>
					</select></td>
					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[2]%>"
						class="input-group" disabled="disabled" 
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getService_name()%>"
						value="<%=workerRequest.getService_name()%>"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[2]%>"
						class="input-group" hidden="true"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getService_name()%>"
						value="<%=workerRequest.getService_name()%>"></td>

					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[3]%>"
						class="input-group" disabled="disabled"
						style="border: 0; background-color: white; color: black;  !important"
						value="<%=workerRequest.getUser_id()%>"
						placeholder="<%=workerRequest.getUser_id()%>"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[3]%>"
						class="input-group" hidden="true"
						style="border: 0; background-color: white; color: black;  !important"
						value="<%=workerRequest.getUser_id()%>"
						placeholder="<%=workerRequest.getUser_id()%>"></td>

					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[4]%>"
						disabled="disabled" class="input-group"
						value="<%=workerRequest.getSociety_name()%>"
						style="border: 0; background-color: white; color: black;!important"
						placeholder="<%=workerRequest.getSociety_name()%>"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[4]%>"
						hidden="true" class="input-group"
						value="<%=workerRequest.getSociety_name()%>"
						style="border: 0; background-color: white; color: black;!important"
						placeholder="<%=workerRequest.getSociety_name()%>"></td>

					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[5]%>"
						class="input-group" value="<%=workerRequest.getWing_name()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getWing_name()%>"
						disabled="disabled"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[5]%>"
						class="input-group" value="<%=workerRequest.getWing_name()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getWing_name()%>" hidden="true"></td>

					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[6]%>"
						class="input-group" disabled="disabled" value="<%=workerRequest.getHouse_no() %>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getHouse_no()%>"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[6]%>"
						class="input-group" hidden="true" value="<%=workerRequest.getHouse_no() %>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getHouse_no()%>"></td>

					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[7]%>"
						class="input-group" value="<%=workerRequest.getProb_desc()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getProb_desc()%>"
						disabled="disabled"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[7]%>"
						class="input-group" value="<%=workerRequest.getProb_desc()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getProb_desc()%>" hidden="true"></td>

					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[8]%>"
						class="input-group" disabled="disabled"
						value="<%=workerRequest.getReqservice_date()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getReqservice_date()%>"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[8]%>"
						class="input-group" hidden="true"
						value="<%=workerRequest.getReqservice_date()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getReqservice_date()%>"></td>

					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[9]%>"
						class="input-group" disabled="disabled"
						value="<%=workerRequest.getReqservice_time_from()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getReqservice_time_from()%>"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[9]%>"
						class="input-group" hidden="true"
						value="<%=workerRequest.getReqservice_time_from()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getReqservice_time_from()%>"></td>

					<td><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[10]%>"
						class="input-group" disabled="disabled"
						value="<%=workerRequest.getReqservice_time_to()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getReqservice_time_to()%>"></td>
					<td hidden="true"><input type="text"
						name="<%=FormFieldUltilityconstant.ServiceRequest[10]%>"
						class="input-group" hidden="true"
						value="<%=workerRequest.getReqservice_time_to()%>"
						style="border: 0; background-color: white; color: black;  !important"
						placeholder="<%=workerRequest.getReqservice_time_to()%>"></td>
						
					<td colspan="2" style="text-align: center;"><input
						type="submit" class="btn btn-success" value="Assign" name="action"
						id=<%=i%>
						formname=<%=FormFieldUltilityconstant.ServiceRequestPage%>>
					</td>
					<%
						}
					%>
				</tr>
			</table>
		</form>
	</div>
	<div class="row">
		<div class="col-md-12">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>
