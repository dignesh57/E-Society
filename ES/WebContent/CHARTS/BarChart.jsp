<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="java.util.ArrayList"%>
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
	<script src="https://code.highcharts.com/modules/data.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>

	<div class="col-mod-6">
		<div>
			<figure class="highcharts-figure">
				<div id="container"></div>
				<table id="datatable">
					<thead hidden="true">
						<tr>
							<th>City</th>
							<th>Area</th>
							<th>Society</th>
						</tr>
					</thead>
					<tbody hidden="true">
						<%
							for (int i = 0; i < dbt.getCity().size(); i++) {
						%>
						<tr>
							<th><%=dbt.getCity().get(i)%></th>
							<td><%=dbts.getAreaCount(dbt.getCity().get(i))%></td>
							<td><%=dbts.getSocCount(dbt.getCity().get(i))%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</figure>
		</div>
	</div>
	<script type="text/javascript">
		Highcharts.chart('container', {
			data : {
				table : 'datatable'
			},
			chart : {
				type : 'column'
			},
			title : {
				text : 'Relation of society with area Citywise'
			},
			yAxis : {
				allowDecimals : false,
				title : {
					text : 'Units'
				}
			},
			tooltip : {
				formatter : function() {
					return '<b>' + this.series.name + '</b><br/>'
							+ this.point.y + ' '
							+ this.point.name.toLowerCase();
				}
			}
		});
	</script>
</body>
</html>