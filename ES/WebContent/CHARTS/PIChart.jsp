<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		DbTransction dbt = new DbTransactionImpl();
		ArrayList<String> getArea = dbt.getArea();
		DbTransactionServices dbts = new DbTransactionServicesImpl();
	%>
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/variable-pie.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>

	<div>
		<figure class="highcharts-figure">
			<div id="container1"></div>
		</figure>
	</div>

	<script type="text/javascript">
Highcharts.chart('container1', {
	   chart: {
	       type: 'variablepie'
	   },
	   title: {
	       text: 'Society compared by area and total city.'
	   },
	   tooltip: {
	       headerFormat: '',
	       pointFormat: '<span style="color:{point.color}">\u25CF</span> <b> {point.name}</b><br/>' +
	           'Total Society as pr city: <b>{point.y}</b><br/>' +
	           'Total area of city: <b>{point.z}</b><br/>'
	   },
	   series: [{
	       minPointSize: 10,
	       innerSize: '20%',
	       zMin: 0,
	       name: 'countries',
	       data: [
	        <%for (int i = 0; i < dbt.getCity().size(); i++) {%>
	        {
	        <%System.out.println(dbt.getCity().get(i) + "****" + dbts.getSocCount(dbt.getCity().get(i)) + "******"
						+ dbts.getAreaCount(dbt.getCity().get(i)));%>
	           name : '<%=dbt.getCity().get(i)%>',
	           y: <%=dbts.getSocCount(dbt.getCity().get(i))%>,
	           z: <%=dbts.getAreaCount(dbt.getCity().get(i))%>
	       }, <%}%>
	       ]
	   }]
	});
</script>
</body>
</html>