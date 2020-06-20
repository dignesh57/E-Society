<%@page import="com.es.model.visitor_details"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.formDesignUltility.ReportConstant"%>
<%@page import="com.es.formDesignUltility.HtmlTableHeader"%>
<%@page import="com.es.formDesignUltility.HtmlReportHeaderDesign"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=FormFieldUltilityconstant.webConstant %></title>
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
			<jsp:include page="SecurityHeader.jsp"></jsp:include></div>

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
												<tr class="<%=hth.SocietyMember().getTableClass()%>">
													<th style="text-align: center;"><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.visitorMemberDetails(),
					ReportConstant.visitorDetails, 0)%></th>
												</tr>
												<%
													DbTransction dbt = new DbTransactionImpl();
													ArrayList<visitor_details> getVisitorMember = dbt
															.getVisitorMember(DbTransactionServicesImpl.getSocIdForVisitEntry(userData.getEmail_id()));
													for (int i = 0; i < getVisitorMember.size(); i++) {
														visitor_details visit = getVisitorMember.get(i);
												%>
												<tr>
													<td><%=visit.getOptions()%></td>
													<td><%=visit.getName()%></td>
													<td><%=visit.getPhone_number()%></td>
													<td><%=visit.getVehical_number()%></td>
													<td><%=visit.getHouse_number()%></td>
													<td><%=visit.getMember_name()%></td>
													<td><%=visit.getIn_time_with_date()%></td>
													<td><%=visit.getOut_time_with_date()%></td>
													<td><%=visit.getPurpose()%></td>
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