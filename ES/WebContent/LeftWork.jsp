<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.model.RequestServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeader"%>
<%@page import="com.es.formDesignUltility.HtmlReportHeaderDesign"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.formDesignUltility.ReportConstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
	HtmlTableHeader hth = new HtmlTableHeader();
%>
<body>
	<div class="row">
		<div class="col-md-12">
			<jsp:include page="WorkerHeader.jsp"></jsp:include></div>

		<section id="requests">
			<div class="container-fluid">
				<div class="col-md-12">
					<div class="row">
						<!-- Stats -->
						<div class="outer-w3-agile col-xl">
							<div class="work-progres">
								<form action="" style="margin-top: 50px; !important">
									<div id="pgtn" class="table-responsive">
										<table class="table table-striped">
											<tbody>
												<tr class="<%=hth.getWorkerRequest().getTableClass()%>">
													<th><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getServiceRequest(), ReportConstant.leftWork,0)%></th>
												</tr>
												<%
													DbTransction dbt = new DbTransactionImpl();
													ArrayList<RequestServices> getComplWork = dbt.getLeftWork(userData.getEmail_id());
															
													for (int i = 0; i < getComplWork.size(); i++) {
														RequestServices reqs = getComplWork.get(i);
												%>
												<tr>
													<td><%=reqs.getUser_name()%><input type="hidden"
														id="<%=i%>" value="<%=reqs.getUser_name()%>" name="name"></td>
													<td><%=reqs.getAddress()%><input type="hidden"
														id="<%=i%>" value="<%=reqs.getAddress()%>" name="address"></td>
													<td><%=reqs.getUser_phone()%><input type="hidden"
														id="<%=i%>" value="<%=reqs.getUser_phone()%>" name="phone"></td>
													<td><%=reqs.getUser_email()%><input type="hidden"
														id="<%=i%>" value="<%=reqs.getUser_email()%>"
														name="useremail"></td>
													<td><%=reqs.getProb_desc()%><input type="hidden"
														id="<%=i%>" value="<%=reqs.getProb_desc()%>"
														name="problem"></td>
													<td><%=reqs.getReqservice_date()%><input type="hidden"
														value="<%=reqs.getReqservice_date()%>" id="<%=i%>"
														name="date"></td>
													<td><%=reqs.getReqservice_time_from()%><input
														type="hidden" id="<%=i%>" name="timef"
														value="<%=reqs.getReqservice_time_from()%>"></td>
													<td><%=reqs.getReqservice_time_to()%><input
														type="hidden" id="<%=i%>" name="timet"
														value="<%=reqs.getReqservice_time_to()%>"></td>
												</tr>
												<%
													}
												%>
											</tbody>
										</table>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>