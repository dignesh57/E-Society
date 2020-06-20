<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
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
<%String soc=request.getParameter("value"); %>
	<select class="custom-select" id="Wing" name="Wing">
										<%
											DbTransction dbt = new DbTransactionImpl();
													DbTransactionServices dbts = new DbTransactionServicesImpl();
													String stringToSplit = dbts.getSocWingbysoc(soc);
											        String[] tempArray;
											 
											        /* delimiter */
											        String delimiter = ",";
											 
											        /* given string will be split by the argument delimiter provided. */
											        tempArray = stringToSplit.split(delimiter);
													String[] getData = tempArray;												
										%>
										<option disabled selected>Choose..</option>
										<%
											for (int j = 0; j < getData.length; j++) {
										%>
										<option id="<%=getData[j]%>"><%=getData[j]%></option>
										<%
											}
										%>
								</select>
</body>
</html>