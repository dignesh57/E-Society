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
<title><%=FormFieldUltilityconstant.webConstant%></title>
</head>
<%
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
%>
<body>
	<%
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		ArrayList<String> getVisitor = dbts.getVisitorName();
		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<div class="row">
		<div class="col-md-12">
			<jsp:include page="SecurityHeader.jsp"></jsp:include></div>
	</div>
	<!-- --------------------------------------HOME ------------------------------------------------------ -->
	<section id="home">
		<div class="container-fluid">
			<div class="col-md-12">
				<div class="row">
					<!-- Stats -->
					<div class="outer-w3-agile col-xl">
						<div class="work-progres">
							<form action="VisitorController" method="post"
								style="margin-top: 50px; !important">
								<div id="pgtn" class="table-responsive">
									<table class="table table-striped">
										<tbody>
											<tr class="<%=hth.SocietyMember().getTableClass()%>">
												<th style="text-align: center;"><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.visitorEntry(), ReportConstant.visitor,
						0)%></th>
											</tr>
											<tr>
												<%
													for (int j = 0; j < FormFieldUltilityconstant.security_guard_table.length; j++) {
													if (FormFieldUltilityconstant.security_guard_table[j].equalsIgnoreCase("Option")) {
												%>
												<td><select class="custom-select" class="form-control"
													id="<%=FormFieldUltilityconstant.security_guard_table[j]%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[j]%>">
														<option selected>Select</option>
														<%
															for (int i = 0; i < getVisitor.size(); i++) {
														%>
														<option id="<%=getVisitor.get(i)%>"><%=getVisitor.get(i)%></option>
														<%
															}
														%>
												</select></td>
												<%
													} else if ((FormFieldUltilityconstant.security_guard_table[j].equalsIgnoreCase("In Time"))) {
												%>
												<td><input type="text"
													id="<%=FormFieldUltilityconstant.security_guard_table[j]%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[j]%>"
													class="form-control"
													value="<%=DbTransactionImpl.entered_on()%>"
													readonly="readonly"
													formname="<%=FormFieldUltilityconstant.security_guard_table%>"></td>
												<%
													} else if (FormFieldUltilityconstant.security_guard_table[j].equalsIgnoreCase("House No")) {
												%>
												<td><select class="custom-select" id="text3"
													class="form-control" onblur="onChangeText(this)"
													name="<%=FormFieldUltilityconstant.security_guard_table[j]%>">
														<option selected>Choose...</option>
														<%
															DbTransction dbt = new DbTransactionImpl();
																		String secretaryEmail = dbt.getSecretaryEmail(userData.getEmail_id());
																		ArrayList<String> getmemberid = dbt.getmemberidvis(secretaryEmail);
																		for (int k = 0; k < getmemberid.size(); k++) {
														%>
														<option id="<%=getmemberid.get(k)%>"><%=getmemberid.get(k)%></option>
														<%
															}
														%>
												</select></td>
												<%
													} else {
												%>
												<td><input type="text"
													id="<%=FormFieldUltilityconstant.security_guard_table[j]%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[j]%>"
													class="form-control"
													formname="<%=FormFieldUltilityconstant.security_guard_table%>"></td>
												<%
													}
														}
												%>
												<td style="text-align: center;"><input
													onclick="refresh (this)" type="submit"
													class="btn btn-primary" value="IN" name="action" id="In"
													formname="<%=FormFieldUltilityconstant.security_guard_table%>"></td>
											</tr>
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
	<!-- --------------------------------------/HOME ------------------------------------------------------ -->
	<!-- --------------------------------------Exit Table ------------------------------------------------------ -->
	<section id="requests">
		<div class="container-fluid">
			<div class="col-md-12">
				<div class="row">
					<!-- Stats -->
					<div class="outer-w3-agile col-xl">
						<div class="work-progres">
							
							<form action="VisitorController" method="post">
								<div id="pgtn" class="table-responsive">
									<table class="table table-striped">
										<tbody>
								
											<tr class="<%=hth.SocietyMember().getTableClass()%>">
												<th style="text-align: center;"><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.visitorOutEntry(),
							ReportConstant.exitvisitor, 0)%></th>
											</tr>
													<%
								DbTransction dbt = new DbTransactionImpl();
								ArrayList<visitor_details> getOutDetails = dbt
										.getValuesForOUT(DbTransactionServicesImpl.getSocIdForVisitEntry(userData.getEmail_id()));
									for (int i = 0; i < getOutDetails.size(); i++) {
										visitor_details visit = getOutDetails.get(i);
							%>
											<tr>
												<td><%=visit.getOptions()%><input type="hidden"
													id="<%=i%>" value="<%=visit.getOptions()%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[0]%>"></td>
												<td><%=visit.getName()%><input type="hidden"
													id="<%=i%>" value="<%=visit.getName()%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[1]%>"></td>
												<td><%=visit.getPhone_number()%><input type="hidden"
													id="<%=i%>" value="<%=visit.getPhone_number()%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[2]%>"></td>
												<td><%=visit.getVehical_number()%><input type="hidden"
													id="<%=i%>" value="<%=visit.getVehical_number()%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[3]%>"></td>
												<td><%=visit.getHouse_number()%><input type="hidden"
													id="<%=i%>" value="<%=visit.getHouse_number()%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[4]%>"></td>
												<td><%=visit.getMember_name()%><input type="hidden"
													value="<%=visit.getMember_name()%>" id="<%=i%>"
													name="Member Name"></td>
												<td><%=visit.getIn_time_with_date()%><input
													type="hidden" id="<%=i%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[5]%>"
													value="<%=visit.getIn_time_with_date()%>"></td>
												<td><%=visit.getPurpose()%><input type="hidden"
													id="<%=i%>"
													name="<%=FormFieldUltilityconstant.security_guard_table[6]%>"
													value="<%=visit.getPurpose()%>"></td>
												<td style="text-align: center;"><input type="submit"
													class="btn btn-primary" name="action" value="OUT"></td>
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


	<!-- --------------------------------------/Exit Table ------------------------------------------------------ -->
	<script type="text/javascript">
		function updateFun(formid) {
			document.getElementById(formid).innerHTML
			console.log("HEllo")
		}
	</script>
	<div class="col-md-12">
		<jsp:include page="UserFooter.jsp"></jsp:include></div>
</body>
</html>