<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@page import="com.es.model.registration_page"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Page_not_found.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=FormFieldUltilityconstant.webConstant %></title>
</head>
<%
registration_page userdata=null;
if(session.getAttribute("user")!=null){
	userdata=(registration_page)session.getAttribute("user");
}
%>
<body>
<%if(userdata.getRole_name().equalsIgnoreCase("Admin")){ %>
	<jsp:include page="header.jsp"></jsp:include>
	<%}else if(userdata.getRole_name().equalsIgnoreCase("Secretary")){ %>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
<%} %>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">
		<form action="ChangePasswordController" method="post">
			<table
				class="table table-responsive' data-height='450' data-width='200'
				data-show-columns='true' data-search='true'"
				style="border-collapse: inherit; !important">
				<thead>
					<!-- 	<tr><th colspan="2">State Master</th></tr> -->
					<th colspan="2"><h4
							class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.profile_title%></h4></th>
				</thead>
				<%
					for (int i = 0; i < FormFieldUltilityconstant.changePassword1.length; i++) {
				%>
				<tr>
					<td class="form-inline mx-auto"
						style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.changePassword1[i]%></td>
					<td><input type="password"
						id="<%=FormFieldUltilityconstant.changePassword1[i]%>"
						name="<%=FormFieldUltilityconstant.changePassword1[i]%>"
						class="form-control"
						placeholder="Enter Your <%=FormFieldUltilityconstant.changePassword1[i]%> here" required="required"></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" class="btn btn-primary" value="Change" name="action"
						id="Change" formname=<%=FormFieldUltilityconstant.change_password_name%>>
					</td>
					<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
				</tr>
			</table>
		</form>
	</div>
	<div class="col-md-3"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>