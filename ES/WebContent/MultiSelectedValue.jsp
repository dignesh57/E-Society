<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet"
	href="https://cdnjs-cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css	">
<script src="/CSS_BOOTStrap/bootstrap.min.js"></script>
<script src="/CSS_BOOTStrap/bootstrap-grid.min.css"></script>
<script>
	function Multiple() {
		var spanresult = document.getElementById("result");
		spanresult.value = "";
		var x = document.getElementById("sel");
		for (var i = 0; i < x.options.length; i++) {
			if (x.options[i].selected === true) {
				spanresult.value += x.options[i].value + "";
				document.getElementById("result").innerHTML = spanresult.value;
				document.getElementById("result").style.color = "green";
				console.log(x.options[i].value);
			}
		}
		if (document.getElementById("result").value == "") {
			document.getElemetnById("result").innerHTML = "**Please Select At least One value"
		}
	}
</script>
</head>
<body>
	<div class="container">
		<form action="MultSelected" method="post">

			<div class="form-group">
				<label>Select...</label> <select id="sel" name="framework[]"
					id="framework" multiple class="form-control">
					<option selected="selected">
					<option value="Java">Java</option>
					<option value="PHP">PHP</option>
					<option value="C#">C#</option>
					<option value="Python">Python</option>
					<option value=".Net">.Net</option>
				</select> <span id="result"></span>
			</div>
			<div class="form-group">
				<input type="submit" name="submit" value="Submit"
					onclick="Multiple();" class="btn btn-info" />
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {
		$('#sel').multiselect({
			nonSelectedtext : 'Select Language',
			enableFiltering : true,
			enableCaseInsensitiveFiltering : true,
			buttonWidth : '400px',
		});

		$('#framework_form').on('submit', function(event) {
			event.preventDefault();
			var form_data = $(this).serialize();
			$.ajax({
				url : "MultiSelectedValue.jsp",
				method : "POST",
				data : form_data,
				success : function(data) {
					$('#sel option:selected').each(function() {
						$(this).prop('selected', false);
					});
					$('#sel').multiselect('refresh');
					alert(data);
					console.log(form_data.value);
				}
			})
		})
	});
</script>
</html>
