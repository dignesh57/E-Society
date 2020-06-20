<%@page import="com.es.model.register_member"%>
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
<% registration_page userdata=(registration_page)session.getAttribute("user"); 
if(userdata.getRole_name().equalsIgnoreCase("Secretary")){
%>
	<%
		DbTransactionServices dbts = new DbTransactionServicesImpl();
		DbTransction dbt = new DbTransactionImpl();
		//tran_req_services reqservices = new tran_req_services();
		System.out.println(userdata.getUsername());
		ArrayList<register_member> getMember = dbt.getRequestedMember(userdata.getEmail_id());

		HtmlTableHeader hth = new HtmlTableHeader();
	%>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<!-- Stats -->
			<div class="outer-w3-agile col-xl">
				<div class="work-progres">

					<form action="RegisteredMemberController" method="post">
						<div class="table-responsive">
							<table class="table table-striped">
								<tbody>
									<tr class="<%=hth.getSocietyRequest().getTableClass()%>">
										<th style="color: black;"><b><%=HtmlReportHeaderDesign.getReoprtDesign(HtmlTableHeader.getMemberRequest(),
					ReportConstant.MemberReq, dbts.requestCount())%></b></th>
									</tr>
									<%
										for (int i = 0; i < getMember.size(); i++) {
											register_member regMember = getMember.get(i);
									%>
									<tr>
										<td><%=regMember.getRole()%></td>
										<td><%=regMember.getMember_id()%></td>
										<td><%=regMember.getName()%></td>
										<td><%=regMember.getEmail()%></td>
										<td><%=regMember.getPhone_no()%></td>
										<td><%=regMember.getGender()%></td>
										<td><%=regMember.getId_proof()%></td>
										<td><%=regMember.getId_number()%></td>
										<td><a
											href="images/memberid/<%=regMember.getId_upload()%>"
											style="color: blue"><%=regMember.getId_upload()%></a></td>

										<td colspan="2" style="text-align: center;"><button
												type="submit" value="<%=regMember.getEmail()%>"
												name="action" id="<%=i%>"
												formname=<%=FormFieldUltilityconstant.register_member_name%>>
												<i class="fa fa-check" style="color: green; !important"></i>
											</button></td>

										<td colspan="2" style="text-align: center;"><button
												type="submit" value="<%=regMember.getEmail()%>"
												name="action1" id="<%=i%>"
												formname=<%=FormFieldUltilityconstant.register_member_name%>>
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
