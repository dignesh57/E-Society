<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.model.tran_maintainance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Maintainance Receipt</title>
<link rel="stylesheet" href="css/maintainance.css" media="all" />
</head>
<body>
<%
registration_page userData = null;
if (session.getAttribute("user") != null) {
	userData = (registration_page) session.getAttribute("user");
}
int action=Integer.parseInt(request.getParameter("action"));
DbTransction dbt=new DbTransactionImpl();
tran_maintainance m=dbt.getMaintainaceInfo(userData.getEmail_id(),action); 
LocalDate date = (m.getGenerated_date()).toLocalDate();
LocalDate duedate = (m.getDue_date()).toLocalDate();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
String gen_date = date.format(formatter);
String due_date = duedate.format(formatter);
String status=(m.getStatus()==null)?"null":m.getStatus();
%>
<header class="clearfix">
      <div id="logo">
       	<h1 style="color: rgb(79, 191, 168);text-align: left;">E-Society</h1>
      </div>
      <h1 class="bill">MAINTAINANCE BILL</h1>
      <div id="company" class="clearfix">
        <div><%=m.getSoc_name() %></div>
        <div><%=m.getSoc_address() %></div>
        <div><%=m.getSoc_address2() %></div>
        <div><%=m.getSoc_address3() %></div>
        <div><%=m.getSoc_pincode() %></div>
        <div><a href="mailto:<%=m.getSoc_email() %>"><%=m.getSoc_email() %></a></div>
      </div>
      <div id="project">
        <div><span>MEMBER ID</span> <%=m.getMember_id() %></div>
        <div><span>NAME</span> <%=m.getMember_name() %></div>
        <div><span>EMAIL</span> <a href="mailto:<%=m.getMember_email() %>"><%=m.getMember_email() %></a></div>
        <div><span>DATE</span> <%=gen_date %></div>
        <div><span>DUE DATE</span> <%=due_date %></div>
        <div><span>STATUS</span> <%=m.getStatus() %></div>
      </div>
    </header>
    <main>
      <table>
        <thead>
          <tr>
            <th class="service">Maintainance Type</th>
            <th>PRICE</th>
            <th>UNIT</th>
            <th>TOTAL</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td class="service">Cleaner Charge</td>
            <td class="price"><%=m.getCleaner_charge() %></td>
            <td class="unit"></td>
            <td class="total"><%=m.getCleaner_charge() %></td>
          </tr>
          <tr>
            <td class="service">Watchman Charge</td>
            <td class="price"><%=m.getWatchman_charge() %></td>
            <td class="unit"></td>
            <td class="total"><%=m.getWatchman_charge() %></td>
          </tr>
          <tr>
            <td class="service">Lift Maintainance Charge</td>
            <td class="price"><%=m.getLift_maintainance_charge() %></td>
            <td class="unit"></td>
            <td class="total"><%=m.getLift_maintainance_charge() %></td>
          </tr>
          <tr>
            <td class="service">WatertankCleaner Charge</td>
            <td class="price"><%=m.getWatertank_cleaner_charge() %></td>
            <td class="unit"></td>
            <td class="total"><%=m.getWatertank_cleaner_charge() %></td>
          </tr>
          <tr>
            <td class="service">WatertanUsage charge</td>
            <td class="price"><%=m.getPrice_per_unit() %></td>
            <td class="unit"><%=m.getUnit() %></td>
            <td class="total"><%=m.getWater_usage_charge() %></td>
          </tr>
          <tr>
            <td colspan="3" class="grand total">GRAND TOTAL(RS)</td>
            <td class="grand2 total"><%=m.getTotal_amount() %> RS</td>
          </tr>
        </tbody>
      </table>
      <%if(status.equals("pending")){ 
    	  
    	  session.setAttribute("Date", m.getGenerated_date());
      	%>
      	
    	  <div id="button" style="text-align: center;">
          <form action="payuform.jsp" method="post">
          <input type="hidden" name="amount" value="<%=m.getTotal_amount() %>">
          	<input type="submit" name="action" value="Pay Now">
          </form>
          </div>
          
     <% }%>
      <div id="notices">
        <div>NOTICE:</div>
        <div class="notice">A finance charge of 1.5% will be made on unpaid balances after 30 days.</div>
      </div>
    </main>
    <footer>
      Maintainance Invoice was created on a computer and is valid without the signature and seal.
    </footer>
  </body>
</html>