<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%String col="white",font="sans-serif",font_col="black"; %>
<script type="text/javascript">
	var bgcol="",fonts="",col="";
	function changecolors(input) {
		document.getElementById('color1').style.backgroundColor = '#d81b60';
		document.getElementById('modaldiv').style.backgroundColor = '#d81b60';
		document.getElementById('color1').style.fontFamily = 'cursive';
		document.getElementById('color1').style.color = 'white';
		console.log("In Script**********88");
		
		bgcol=document.getElementById('color1').style.backgroundColor;
		fonts=document.getElementById('color1').style.fontFamily;
		cols=document.getElementById('color1').style.color;
		console.log(bgcol+fonts+cols);
		
		<%-- <%=col%>=bgcol;
		<%=font%>=fonts;
		<%=font_col%>=cols; --%>	
	}
	function changecolors1(input) {
		document.getElementById('color1').style.backgroundColor = '#512da8';
		document.getElementById('modaldiv').style.backgroundColor = '#512da8';
		document.getElementById('color1').style.fontFamily = 'sans-serif';
		document.getElementById('color1').style.color = 'white';
		console.log("In Script**********88");
		
		bgcol=document.getElementById('color1').style.backgroundColor;
		fonts=document.getElementById('color1').style.fontFamily;
		cols=document.getElementById('color1').style.color;
		console.log(bgcol+fonts+cols);
		<%-- <%=col%>=bgcol;
		<%=font%>=fonts;
		<%=font_col%>=cols;	
		 --%>
	}
	function changecolors2(input) {
		document.getElementById('color1').style.backgroundColor = '#ffff00';
		document.getElementById('modaldiv').style.backgroundColor = '#ffff00';
		document.getElementById('color1').style.fontFamily = 'serif';
		document.getElementById('color1').style.color = 'black';
		console.log("In Script**********88");
		
		bgcol=document.getElementById('color1').style.backgroundColor;
		fonts=document.getElementById('color1').style.fontFamily;
		cols=document.getElementById('color1').style.color;
		console.log(bgcol+fonts+cols);
		<%-- <%=col%>=bgcol;
		<%=font%>=fonts;
		<%=font_col%>=cols;	
		 --%>
	}
	function changecolors3(input) {
		document.getElementById('color1').style.backgroundColor = '#ffcdd2';
		document.getElementById('modaldiv').style.backgroundColor = '#ffcdd2';
		document.getElementById('color1').style.fontFamily = 'fantasy';
		document.getElementById('color1').style.color = 'black';
		console.log("In Script**********88");
		
		bgcol=document.getElementById('color1').style.backgroundColor;
		fonts=document.getElementById('color1').style.fontFamily;
		cols=document.getElementById('color1').style.color;
		console.log(bgcol+fonts+cols);
		<%-- <%=col%>=bgcol;
		<%=font%>=fonts;
		<%=font_col%>=cols;	
	 --%>
	}
	function changecolors4(input) {
		document.getElementById('color1').style.backgroundColor = '#4dd0e1';
		document.getElementById('modaldiv').style.backgroundColor = '#4dd0e1';
		document.getElementById('color1').style.fontFamily = 'monospace';
		document.getElementById('color1').style.color = 'black';
		console.log("In Script**********88");
		
		bgcol=document.getElementById('color1').style.backgroundColor;
		fonts=document.getElementById('color1').style.fontFamily;
		cols=document.getElementById('color1').style.color;
		console.log(bgcol+fonts+cols);
		<%-- <%=col%>=bgcol;
		<%=font%>=fonts;
		<%=font_col%>=cols; --%>	
	}
</script>
<body>
	<div class="container mt-3">
		<h2>Modal Example</h2>
		<!-- Button to Open the Modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">Open modal</button>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal2">Event</button>

		<!-- The Modal -->
		<form action="AddPostController" method="post">
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Share Your Thoughts!!</h4>
						<button type="button" class="close" data-dismiss="modal">×</button>
					</div>

					<!-- Modal body -->
					
					<div class="modal-body" id="modaldiv">
						<input type="text" id="color1" name="message"
							placeholder="enter your message..."
							class="input-group border-0" required>
					</div>
					
					<!-- Modal footer -->
					<div class="modal-footer">
						<input type="button" id="grey"
							class="rounded-circle border border-dark"
							onclick="changecolors(this)"
							style="background-color: #d81b60; width: 30px; !important">
						<input type="button" class="rounded-circle border border-dark"
							onclick="changecolors1(this)"
							style="background-color: #512da8; width: 30px; !important">
						<input type="button" class="rounded-circle border border-dark"
							onclick="changecolors2(this)"
							style="background-color: #ffff00; width: 30px; !important">
						<input type="button" class="rounded-circle border border-dark"
							onclick="changecolors3(this)"
							style="background-color: #ffcdd2; width: 30px; !important">
						<input type="button" class="rounded-circle border border-dark"
							onclick="changecolors4(this)"
							style="background-color: #4dd0e1; width: 30px; !important">
						<input type="submit" class="btn btn-success" name="action" value="add" id="add">
						<button type="button" class="btn btn-danger" data-dismiss="modal">cancel</button>
					</div>
				</div>
			</div>
		</div>
		<%session.setAttribute("colorcode", col);
		session.setAttribute("font", font);
		session.setAttribute("fontcol", font_col);
		%>
		</form>
	</div>
	<script type="text/javascript">
	</script>
</body>
</html>