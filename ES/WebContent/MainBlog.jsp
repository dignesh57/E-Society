<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.es.model.blog"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.es.dao.DbTransction"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionServicesImpl"%>
<%@page import="com.es.dao.DbTransactionServices"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>E-Society</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet"
	href="User/vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="User/vendor/font-awesome/css/font-awesome.min.css">
<!-- Google fonts - Roboto + Roboto Slab-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,700%7CRoboto:400,700,300">
<!-- owl carousel-->
<link rel="stylesheet"
	href="User/vendor/owl.carousel/assets/owl.carousel.css">
<link rel="stylesheet"
	href="User/vendor/owl.carousel/assets/owl.theme.default.css">
<!-- animate.css-->
<link rel="stylesheet" href="User//vendor/animate.css/animate.css">
<!-- theme stylesheet-->
<link rel="stylesheet" href="User/css/style.default.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="User/css/custom.css">
<!-- Leaflet CSS - For the map-->
<link rel="stylesheet" href="User/ajax/libs/leaflet/1.4.0/leaflet.css">
<!-- Favicon-->
<link rel="shortcut icon" href="User/img/favicon.png">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>

<body>
	<%
	registration_page userData = null;
	if (session.getAttribute("user") != null) {
		userData = (registration_page) session.getAttribute("user");
	}
	System.out.print(userData);
	
	String userid=userData.getEmail_id();
	DbTransactionServices dbs=new DbTransactionServicesImpl();
	String socid = dbs.getMemberSocID(userid);
	%>
	<!-- Reference item-->
	<jsp:include page="UserHeader.jsp"></jsp:include>

	<div class="container" style="margin-top: 100px; !important">
		<div class="col-lg-12 col-md-12 col-xs-12 col-sm-12">
			<!-- Button to Open the Modal -->
			<hr>
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#addpostmodal" style="color: white !important">Add
				Post</button>
			<br>
			<hr>

			<!-- add post modal -->
			<div class="modal fade" id="addpostmodal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Share Your
								Thoughts and Memories..</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">

							<form id="addpostform" action="AddPostController" method="post"
								enctype="multipart/form-data">

								<div class="form-group">
									<textarea name="message" class="form-control"
										style="height: 150px;" placeholder="Enter your message.." required="required"></textarea>
								</div>
								<div class="form-group">
									<label>Select your pic..</label> <br> <input type="file"
										name="pic">
								</div>

								<div class="container text-center">
									<button type="submit" class="btn btn-outline-primary"
										name="action" value="Add Post">Add Post</button>
								</div>

							</form>


						</div>

					</div>
				</div>
			</div>
			<!-- end add post modal -->
			<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			<%
			ArrayList<blog> allPost=dbs.getAllPosts(socid);
			%>
			<%for(blog post:allPost){ %>
			
			<div class="card mx-auto" style="border-color: #4fbfa8;color:white !important">
				<div class="card-header" style="background-color: #4fbfa8; !important">
					<%=post.getUsername() %>
				</div>
				<%if(post.getImage()!=null){ %>
				<img class="card-img-top"
					src="blog_pics/<%=post.getImage() %>" alt="image.."/>
				<%} %>
				<div class="card-body" style="background-color:#e9ecef">
					<p class="card-text"><%=post.getMessage() %></p>
				</div>
			</div>
			<br>

			<%} %>
			</div>
			<div class="col-md-3"></div>
			</div>
		</div>
	</div>

	<jsp:include page="UserFooter.jsp"></jsp:include>
	<!-- JavaScript files-->
	<script src="User/vendor/jquery/jquery.min.js"></script>
	<script src="User/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="User/vendor/jquery.cookie/jquery.cookie.js">
	</script>

	<script src="User/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="User/vendor/waypoints/lib/jquery.waypoints.min.js"></script>
	<script src="User/vendor/jquery.counterup/jquery.counterup.js"></script>
	<script src="User/ajax/libs/leaflet/1.4.0/leaflet.js"></script>
	<script src="User/js/front.js"></script>
</body>
</html>