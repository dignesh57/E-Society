<%@page import="com.es.model.register_society"%>
<%@page import="com.es.model.mst_complain"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=FormFieldUltilityconstant.webConstant%></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Modernize Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />


<!-- Style-sheets -->
<!-- Bootstrap Css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Bootstrap Css -->
<!-- Common Css -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--// Common Css -->
<!-- Fontawesome Css -->
<link href="css/fontawesome-all.css" rel="stylesheet">
<!--// Fontawesome Css -->
<!--// Style-sheets -->

<!--web-fonts-->
<link href="//fonts.googleapis.com/css?family=Poiret+One"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="secretaryheader.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-1"></div>
		<div class="col-md-5">
			<form action="VisitorController" class="form-group" method="post">
				<div class="row">
					<div class="col-md-12" id="add" class="top">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_visitor_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_state;
								for (int i = 0; i < FormFieldUltilityconstant.mst_visitor.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_visitor[i]%></td>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_visitor[i]%>"
									name="<%=FormFieldUltilityconstant.mst_visitor[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_visitor[i]%> Please"></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add" name="action"
									id="add" formname=<%=FormFieldUltilityconstant.mst_visitor_name%>>
								</td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-6">
			<%-- <div class="col-md-12">
				<th>
					<h4>State Details</h4> <br>
				</th>
				<form action="">
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
							<td colspan="2" style="text-align: center;"><input
								type="submit" class="btn btn-success" value="Edit" name="action"
								id="Edit" formname=<%=FormFieldUltilityconstant.mst_state_name%>>
							</td>
							<td><i class="fa fa-trash" style="color: red; !important"></i></td>
							<!--<td><i class="glyphicon glyphicon-pencil" aria-hidden="true"
								style="color: green; !important"></i></td> -->
						</tr>
						<%
							}
						%>
					</table>
				</form>
			</div> --%>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

</body>
</html>