<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	
	<title>Editable Invoice</title>
	
	<link rel='stylesheet' type='text/css' href='Invoice_Design/css/style.css' />
	<link rel='stylesheet' type='text/css' href='Invoice_Design/css/print.css' media="print" />
	<script type='text/javascript' src='Invoice_Design/js/jquery-1.3.2.min.js'></script>
	<script type='text/javascript' src='Invoice_Design/js/example.js'></script>
	
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta tag Keywords -->

<!-- Custom-Files -->
<link rel="stylesheet" href="User/css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="User/css/style.css" type="text/css"
	media="all" />
<!-- Style-CSS -->
<link href="User/css/font-awesome.min.css" rel="stylesheet">
<!-- Font-Awesome-Icons-CSS -->
<!-- //Custom-Files -->

<!-- Web-Fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
	rel="stylesheet">
<!-- //Web-Fonts -->


</head>

<body bgcolor="black">
<div class ="pageheader">
<jsp:include page="UserHeader.jsp"></jsp:include>
</div>
	<div id="page-wrap">
	<div class="mt-3">

	<center>	<textfield id="header" disabled="disabled" class="sm-5">INVOICE</textfield></center>
		
		<div id="identity">
		
            <textfield id="address" class="mt-5">Pushkar Residency
123 Appleseed Street
Appleville, WI 53719

Phone: (555) 555-5555</textfield>

            <div id="logo">

              <div id="logohelp">
                <input id="imageloc" type="text" size="50" value="" /><br />
                (max width: 540px, max height: 100px)
              </div>
             <!--  <img id="image" src="Invoice_Design/images/landing-logo.png" alt="logo" /> -->
            </div>
		
		</div>
		
		<div style="clear:both"></div>
		
		<div id="customer">

            <textfield id="customer-title">Widget Corp.
c/o Steve Widget</textfield>

            <table id="meta">
                <tr>
                    <td class="meta-head">Invoice #</td>
                    <td textarea>000123</textarea></td>
                </tr>
                <tr>

                    <td class="meta-head">Date</td>
                    <td textarea id="date"></textarea></td>
                </tr>
                <tr>
                    <td class="meta-head">Amount Due</td>
                    <td><div class="due">$875.00</div></td>
                </tr>

            </table>
		
		</div>
		
		<table id="items">
		
		  <tr>
		      <th>Item</th>
		      <th>Description</th>
		      <th>Unit Cost</th>
		      <th>Quantity</th>
		      <th>Price</th>
		  </tr>
		  
		  <tr class="item-row">
		      <td class="item-name"><div class="delete-wpr">Web Updates<!-- <a class="delete" href="javascript:;" title="Remove row">X</a> --></div></td>
		      <td class="description">Monthly web updates for http://widgetcorp.com (Nov. 1 - Nov. 30, 2009)</td>
		      <td textarea class="cost">$650.00</textarea></td>
		      <td textarea class="qty">1</textarea></td>
		      <td><span class="price">$650.00</span></td>
		  </tr>
		  
		  <tr class="item-row">
		      <td class="item-name"><div class="delete-wpr">SSL Renewals<!-- <a class="delete" href="javascript:;" title="Remove row">X</a> --></div></td>

		      <td class="description">Yearly renewals of SSL certificates on main domain and several subdomains</td>
		      <td textarea class="cost">$75.00</textarea></td>
		      <td textarea class="qty">3</textarea></td>
		      <td><span class="price">$225.00</span></td>
		  </tr>
		  
		  <tr id="hiderow">
		    <td colspan="5"><a id="addrow" href="javascript:;" title="Add a row">Add a row</a></td>
		  </tr>
		  
		  <tr>
		      <td colspan="2" class="blank"> </td>
		      <td colspan="2" class="total-line">Subtotal</td>
		      <td class="total-value"><div id="subtotal">$875.00</div></td>
		  </tr>
		  <tr>

		      <td colspan="2" class="blank"> </td>
		      <td colspan="2" class="total-line">GST</td>
		      <td class="total-value"><div id="total">$0.00</div></td>
		  </tr>
		  <tr>
		      <td colspan="2" class="blank"> </td>
		      <td colspan="2" class="total-line">Sub GST</td>

		      <td class="total-value" textarea id="paid">$0.00</textarea></td>
		  </tr>
		  <tr>
		      <td colspan="2" class="blank"> </td>
		      <td colspan="2" class="total-line balance">Total</td>
		      <td class="total-value balance"><div class="due">$875.00</div></td>
		  </tr>
		
		</table>
		
		<div id="terms">
		  <h5>Terms</h5>
		  <textarea>NET 30 Days. Extra Charge of 15% will be made on unpaid balances after 30 days.</textarea>
		</div>
	
	</div>
	<jsp:include page="UserFooter.jsp"></jsp:include>

</div>

		<!-- Bootstrap core JavaScript-->
		<script src="vendor/jquery/jquery.min.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
	
</body>

</html>