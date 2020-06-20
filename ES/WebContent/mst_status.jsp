<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=FormFieldUltilityconstant.webConstant %></title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-1"></div>
		<div class="col-md-5">

			<form action="StatusController" class="form-group" method="post">
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_status_title%></h4></th>
							</thead>
							<%
								for (int i = 0; i < FormFieldUltilityconstant.mst_status.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_status[i]%></td>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_status[i]%>"
									name="<%=FormFieldUltilityconstant.mst_status[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_status[i]%> Please"></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add" name="action"
									id="add"
									formname=<%=FormFieldUltilityconstant.mst_status_name%>>
								</td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<%-- <div class="col-md-6">
			<div class="col-md-12">
				<th>
					<h4>State Details</h4> <br>
				</th>
				<%
					DbTransction dbt = new DbTransactionImpl();
					ArrayList<mst_status> statedata = dbt.getStateModel();
				%><form action="">
					<table>
						<tr>
							<th>State Id</th>
							<th>State name</th>
						</tr>
						<%
							for (int i = 0; i < statedata.size(); i++) {
								mst_state state = statedata.get(i);
						%>
						<tr>
							<td><%=state.getState_id()%></td>
							<td><%=state.getState_name()%></td>
						</tr>
						<%
							}
						%>
						<%for(int i=0;i<get;i++) {%>
				<tr>
					<td><%=stateDeatils.get(i)%></td>
					<%i++; %>
					<td><%=stateDeatils.get(i) %></td>
				</tr>
				<% }%>
					</table>
				</form>
			</div>
		</div> --%>
	</div>

	<div class="row">
		<div class="col-md-12">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>

</body>
</html>