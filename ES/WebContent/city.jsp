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
<%String state=request.getParameter("value"); %>
	<select class="custom-select" id="City" name="City">
										<%
											DbTransction dbt = new DbTransactionImpl();
													DbTransactionServices dbts = new DbTransactionServicesImpl();
													ArrayList<String> getData = dbts.getCityforSelect(state);												
										%>
										<option disabled selected>Choose..</option>
										<%
											for (int j = 0; j < getData.size(); j++) {
										%>
										<option id="<%=getData.get(j)%>"><%=getData.get(j)%></option>
										<%
											}
										%>
								</select>
		<script type="text/javascript">		
				$('#City').on('change',function(){
					
    			event.preventDefault();
    			var option=$(this).val();
    			$.ajax({
    				type: 'POST',
    			    url: 'area.jsp',
    			    data: {value:option},
    			  	success: function(data){
    				 	
    				 	$('#aread').html(data);
    				}	  
    			});
    		});
				</script>
</body>
</html>