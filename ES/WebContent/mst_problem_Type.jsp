<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
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

			<form action="ProblemTypeController" class="form-group" method="post">
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_problem_type_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_state;
								for (int i = 0; i < FormFieldUltilityconstant.mst_problem_type.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_problem_type[i]%></td>
								<%
									if (FormFieldUltilityconstant.mst_problem_type[i]=="service") {
								%>
								<td><select onchange="OnSelectionChange (this)"
									class="custom-select"
									id="<%=FormFieldUltilityconstant.mst_mst_city[0]%>">
										<%
										DbTransactionServices dbts=new DbTransactionServicesImpl();
										ArrayList getService=dbts.getService();
										%><option selected><%=getService.get(0)%></option>
										<%
											for (int j = 1; j < getService.size(); j++) {
										%>
										<option id="<%=getService.get(j)%>"><%=getService.get(j)%></option>
										<%
											}
										%>

								</select></td>
								<%
									} else {
								%>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_problem_type[i]%>"
									name="<%=FormFieldUltilityconstant.mst_problem_type[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_problem_type[i]%> Please"></td>
								<%
									}
								%>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add" name="action"
									id="add" formname=<%=FormFieldUltilityconstant.mst_problem_type%>>
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
					ArrayList<mst_state> statedata = dbt.getStateModel();
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
							<td><i class="fa fa-trash" aria-hidden="true"
								style="color: red; !important"></i></td>
							<td><i class="glyphicon glyphicon-pencil" aria-hidden="true"
								style="color: green; !important"></i></td>
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