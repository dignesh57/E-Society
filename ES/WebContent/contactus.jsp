<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>E-Society</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Startup Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script>
		addEventListener("load", function () {
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
	<link rel="stylesheet" href="User/css/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link href="User/css/font-awesome.min.css" rel="stylesheet">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //Custom-Files -->

	<!-- Web-Fonts -->
	<link href="http://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=devanagari,latin-ext"
	 rel="stylesheet">
	<!-- //Web-Fonts -->

</head>
<body>
	
	<jsp:include page="UserHeader.jsp"></jsp:include>
	
	<!-- contact -->
	<div class="contact py-5" id="contact">
		<div class="container pb-xl-5 pb-lg-3">
			<div class="row">
				<div class="col-lg-6">
					<img src="User/images/b2.png" alt="image" class="img-fluid" />
				</div>
				<div class="col-lg-6 mt-lg-0 mt-5">
					<!-- contact form grid -->
					<div class="contact-top1">
						<form action="#" method="post" class="contact-wthree-do">
							<div class="form-group">
								<div class="row">
									<div class="col-md-6">
										<label>
											First name
										</label>
										<input class="form-control" type="text" placeholder="Anderson" name="name" required="">
									</div>
									<div class="col-md-6 mt-md-0 mt-4">
										<label>
											Last name
										</label>
										<input class="form-control" type="text" placeholder="John" name="name" required="">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-md-6">
										<label>
											Mobile
										</label>
										<input class="form-control" type="text" placeholder="xxxx xxxx xx" name="mobile" required="">
									</div>
									<div class="col-md-6 mt-md-0 mt-4">
										<label>
											Email
										</label>
										<input class="form-control" type="email" placeholder="example@mail.com" name="email" required="">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<div class="col-md-12">
										<label>
											Your message
										</label>
										<textarea placeholder="Add your Description here" name="message" class="form-control"></textarea>
									</div>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<button type="submit" class="btn btn-cont-w3 btn-block mt-4">Send</button>
								</div>
							</div>
						</form>
					</div>
					<!-- //contact form grid ends here -->
				</div>
			</div>
		</div>
	</div>
	<!-- //contact-->
<!---728x90--->
	<!-- map -->
	<div class="w3l-map p-4">
		<iframe src="https://www.google.com/maps/place/TOPS+Technologies+Learn+Python+Java+PHP+Web+Designing+Graphic+Design+Courses/@22.9975249,72.6078923,17z/data=!3m1!4b1!4m5!3m4!1s0x395e85c2fc005927:0x918e69150ca1c935!8m2!3d22.99752!4d72.610081"></iframe>
	</div>
	<!-- //map -->
	
	<jsp:include page="UserFooter.jsp"></jsp:include>
	
</body>
</html>