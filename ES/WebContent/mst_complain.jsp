<%@page import="com.es.model.mst_complain"%>
<%@page import="com.es.model.registration_page"%>
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
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="row" style="background-color: white;">
		<div class="col-md-3"></div>
		<div class="col-md-6">

			<form action="ComplainController" class="form-group" method="post">
				<%-- <script type="text/javascript">
					function getName(String) {
						var getname = select.options[select.selectedIndex];
				<%=enterBy%>=getname.value;
					}
				</script> --%>
				<div class="row">
					<div class="col-md-12">
						<table
							class="table table-responsive' data-height='450' data-width='200' data-show-columns='true' data-search='true'" style="border-collapse: inherit; !important">
							<thead>
								<!-- 	<tr><th colspan="2">State Master</th></tr> -->
								<th colspan="2"><h4
										class="main-title-w3layouts mb-2 text-center"><%=FormFieldUltilityconstant.mst_complain_title%></h4></th>
							</thead>
							<%
								//String[] field = FormFieldUltilityconstant.mst_complain;
								for (int i = 0; i < FormFieldUltilityconstant.mst_complain.length; i++) {
							%>
							<tr>
								<td class="form-inline mx-auto"
									style="font-size: medium; !importatnt"><%=FormFieldUltilityconstant.mst_complain[i]%></td>
								<td><input type="text"
									id="<%=FormFieldUltilityconstant.mst_complain[i]%>"
									name="<%=FormFieldUltilityconstant.mst_complain[i]%>"
									class="form-control"
									placeholder="Your <%=FormFieldUltilityconstant.mst_complain[i]%> Please"></td>
							</tr>
							<%
								}
							%>
							<tr>
								<td colspan="2" style="text-align: center;"><input
									type="submit" class="btn btn-primary" value="Add" name="action"
									formname="<%=FormFieldUltilityconstant.mst_complain_name%>"></td>
								<!-- 	<td><input type="submit" class="btn btn-warning" value="Update"></td>
						<td><input type="submit" class="btn btn-danger" value="Delete"></td> -->
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div>
		<%
			DbTransction dbt = new DbTransactionImpl();
			ArrayList<mst_complain> getComp = dbt.getAllComp();
		%>
		<form action="">
			<table>
				<tr>
					<th>Complain ID</th>
					<th>Complain Type</th>
				</tr>
				<%
					for (int i = 0; i < getComp.size(); i++) {
						mst_complain comp=getComp.get(i);
				%>
				<tr>
					<td><%=comp.getComp_id()%></td>
					<td><%=comp.getComp_type()%></td>
					<td><i class="fa fa-trash" aria-hidden="true"
						style="color: red; !important"></i></td>
					<!-- <td><i class="glyphicon glyphicon-pencil" aria-hidden="true"
						style="color: green; !important"></i></td> -->
				</tr>
				<%
					}
				%>
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