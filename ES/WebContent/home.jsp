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
    <link rel="stylesheet" href="User/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="User/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Google fonts - Roboto + Roboto Slab-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,700%7CRoboto:400,700,300">
    <!-- owl carousel-->
    <link rel="stylesheet" href="User/vendor/owl.carousel/assets/owl.carousel.css">
    <link rel="stylesheet" href="User/vendor/owl.carousel/assets/owl.theme.default.css">
    <!-- animate.css-->
    <link rel="stylesheet" href="User//vendor/animate.css/animate.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="User/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="User/css/custom.css">
    <!-- Leaflet CSS - For the map-->
    <link rel="stylesheet" href="User/ajax/libs/leaflet/1.4.0/leaflet.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="User/img/favicon.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>

<body>
<%
DbTransactionServices dbts=new DbTransactionServicesImpl();
%>
    <!-- Reference item-->
    <jsp:include page="HomeHeader.jsp"></jsp:include>
    <!-- Intro Image-->
    <section id="intro" style="background: url(User/img/home2.jpg) center center no-repeat; background-size: cover;" class="intro-section pb-2">
      <div class="container text-center">
        <div data-animate="fadeInDown" class="logo"><img src="User/img/landing-logo.png" alt="logo" width="130"></div>
        <h1 data-animate="fadeInDown" class="text-shadow mb-5">welcome to E-Society</h1>
        
      </div>
    </section>
    <!-- About-->
    <section id="about" class="about-section">
      <div class="container">
        <header class="text-center">
          <h2 data-animate="fadeInDown" class="title">About E-Society</h2>
        </header>
        <div class="row">
          <div data-animate="fadeInUp" class="col-lg-12">
            <p>E-society is a part of society modernization project which is stands up for <strong>Morden and Growing India.</strong></p>
            <p>This Web-application enables to track <strong>income and expenses, communicate updates</strong> over mobile, email etc. e-Society is one such Web-application which is helpful for an apartment management. With this solution we are trying to automate all the manual work regarding the housing societies.also e-society provides amenities and home-related services to user to book amenities and request for services</p>
            <p> By providing <strong>real-time information</strong> and a bevy of additional solutions, e-society is providing an avenue for people to stay connected and stay in the loop concerning some of the most recent occurrences that might be going on back home. With e-society, you re truly able to stay home, even while you’re away.</p>
          </div>
         <div data-animate="fadeInUp" class="col-sm-6 mx-auto mt-5"><img src="User/img/home3.jpg" alt="This is me - IT worker" class="image rounded-circle img-fluid"></div>
        </div>
      </div>
    </section>
    
    <section id="login" class="bg-gradient services-section">
      <div class="container">
        <header class="text-center">
          <h2 data-animate="fadeInDown" class="title">Login here..</h2>
        </header>
        <div class="row services text-center" style="align-items: center;">
          <div data-animate="fadeInUp" class="col-lg-12">
            <div class="icon"><i class="fa fa-sign-in"></i></div>
            <h3 class="heading mb-3 text-400">Login</h3>
            <p class="text-center description">You can login here and get the services that you want</p>	
            <p><a href="login.jsp" class="btn btn-outline-light link-scroll">Login</a></p>
<%--             <input type="submit" id="RegisterWorker" value="Register" name="action" formname="<%=FormFieldUltilityconstant.login_page_name %>" >--%>          </div>
        </div>
<!--         <hr data-animate="fadeInUp"> -->
      </div>
    </section>
    
    <section id="registration" class="bg-gradient services-section">
      <div class="container">
        <header class="text-center">
          <h2 data-animate="fadeInDown" class="title">Register here..</h2>
        </header>
        <div class="row services text-center">
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-home"></i></div>
            <h3 class="heading mb-3 text-400">Register As Society</h3>
            <p class="text-left description">your Society need to register here for use system functionalities like maintanance,notification,expense management etc.</p>
            <p><a href=register_society.jsp class="btn btn-outline-light link-scroll">Register</a></p>

            <%-- <input type="submit" id="RegisterSociety" value="Register" name="action" formname="<%=FormFieldUltilityconstant.login_page_name %>" > --%>
          </div>
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-sun-o"></i></div>
            <h3 class="heading mb-3 text-400">Register As Worker</h3>
            <p class="text-left description">As worker,you register first for getting work from home.</p>
            <p><a href="register_worker.jsp" class="btn btn-outline-light link-scroll">Register</a></p>
<%--             <input type="submit" id="RegisterWorker" value="Register" name="action" formname="<%=FormFieldUltilityconstant.login_page_name %>" >--%>          </div>
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-user-o"></i></div>
            <h3 class="heading mb-3 text-400">Register As Society Member</h3>
            <p class="text-left description">As Society member ,you need to registration first then your request goes to secretary.</p>
            <p><a href="register_member.jsp" class="btn btn-outline-light link-scroll">Register</a></p>
            <%-- <input type="submit" id="Register" value="Register" name="action" formname="<%=FormFieldUltilityconstant.login_page_name %>"> --%>
          </div>
        </div>
        <hr data-animate="fadeInUp">
        <div data-animate="fadeInUp" class="text-center">
          <p class="lead">Would you like to know more or just discuss something?</p>
          <p><a href="#contact" class="btn btn-outline-light link-scroll">Contact me</a></p>
        </div>
      </div>
    </section>
    
    <!-- Service-->
    <section id="services" class="bg-gradient services-section">
      <div class="container">
        <header class="text-center">
          <h2 data-animate="fadeInDown" class="title">Services</h2>
        </header>
        <div class="row services text-center">
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-home"></i></div>
            <h3 class="heading mb-3 text-400">Home-related Services</h3>
            <p class="text-left description">This System Provides home-related services like Carpenter,Plumber etc. to user.</p>
          </div>
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-book"></i></div>
            <h3 class="heading mb-3 text-400">Amenities</h3>
            <p class="text-left description">Societies have lots of assets and equipments for which they have to keep track and book.</p>
          </div>
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-money"></i></div>
            <h3 class="heading mb-3 text-400">Maintainance Payment</h3>
            <p class="text-left description">Pay your maintenance online through Payment Gateway.</p>
          </div>
        </div>
        <hr data-animate="fadeInUp">
        <div data-animate="fadeInUp" class="text-center">
          <p class="lead">Would you like to know more or just discuss something?</p>
          <p><a href="#contact" class="btn btn-outline-light link-scroll">Contact me</a></p>
        </div>
      </div>
    </section>
    
    <!-- Statistics-->
    <section id="statistics" data-dir="up" style="background: url(_img/parallax.html);" class="statistics-section text-white parallax parallax">
      <div class="container">
        <div class="row showcase text-center"> 
          <div data-animate="fadeInUp" class="col-lg-3 col-md-6">
            <div class="item">
              <div class="icon"><i class="fa fa-align-justify"></i></div>
              <h5 class="text-400 mt-4 text-uppercase"><span class="counter"><%=dbts.getStateCount() %></span><br>Collaboration With States</h5>
            </div>
          </div>
          <div data-animate="fadeInUp" class="col-lg-3 col-md-6">
            <div class="item">
              <div class="icon"><i class="fa fa-users"></i></div>
              <h5 class="text-400 mt-4 text-uppercase"><span class="counter"><%=dbts.getSocCount()%></span><br>Registered Societies</h5>
            </div>
          </div>
          <div data-animate="fadeInUp" class="col-lg-3 col-md-6">
            <div class="item">
              <div class="icon"><i class="fa fa-copy"></i></div>
              <h5 class="text-400 mt-4 text-uppercase"><span class="counter">3</span><br>Services Requests</h5>
            </div>
          </div>
          <div data-animate="fadeInUp" class="col-lg-3 col-md-6">
            <div class="item">
              <div class="icon"><i class="fa fa-font"></i></div>
              <h5 class="text-400 mt-4 text-uppercase"><span class="counter"><%=dbts.getUserCount()%></span><br>Joint Users</h5>
            </div>
          </div>
        </div>
      </div>
      <div class="dark-mask"></div>
    </section>
    
    <section id="features" class="bg-gradient services-section">
      <div class="container">
        <header class="text-center">
          <h2 data-animate="fadeInDown" class="title"> Features </h2>
        </header>
        <div class="row services text-center">
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-home"></i></div>
            <h3 class="heading mb-3 text-400">Custom Services listOut</h3>
            <h5>Carpenter</h5>
            <h5>Plumber</h5>
            <h5>Mechanic</h5>
            <h5>Electrician</h5>
            <h5>Cleaning</h5>
            <h5>Grocery</h5>
          </div>
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-calendar-o"></i></div>
            <h3 class="heading mb-3 text-400">Events And Blog</h3>
            <h5>Societies Events can manage easily for passing the notice and connect people with each other with blogs</h5>
            <h5>Society Member can upload their images on the blogs and also share their review on the blogs</h5>
          </div>
          <div data-animate="fadeInUp" class="col-lg-4">
            <div class="icon"><i class="fa fa-money"></i></div>
            <h3 class="heading mb-3 text-400">Online Bill Management</h3>
            <h5>Generate Maintenance bills online</h5>
            <h5>Member can easily pay their bills online </h5>
            <h5>Payment gateway is gone easy for the society member</h5>
          </div>
        </div>
        <hr data-animate="fadeInUp">
      </div>
    </section>
    <!--
    *** REFERENCES IMAGE ***
    _________________________________________________________
    -->
    <!-- Customers-->
    <section id="customers" class="customers-section bg-gray">
      <div class="container">
        <div class="col-md-12">
          <div class="row align-items-center">
            <div class="col-lg-2 col-md-4 col-sm-6">
              <div class="customer"><img src="User/img/customers/logo-1.jpg" title="brand logo" data-placement="bottom" data-toggle="tooltip" alt="" class="img-fluid d-block mx-auto"></div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-6">
              <div class="customer"><img src="User/img/customers/logo2.jpg" title="brand logo" data-placement="bottom" data-toggle="tooltip" alt="" class="img-fluid d-block mx-auto"></div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-6">
              <div class="customer"><img src="User/img/customers/logo3.jpg" title="brand logo" data-placement="bottom" data-toggle="tooltip" alt="" class="img-fluid d-block mx-auto"></div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-6">
              <div class="customer"><img src="User/img/customers/logo4.jpg" title="brand logo" data-placement="bottom" data-toggle="tooltip" alt="" class="img-fluid d-block mx-auto"></div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-6">
              <div class="customer"><img src="User/img/customers/logo5.png" title="brand logo" data-placement="bottom" data-toggle="tooltip" alt="" class="img-fluid d-block mx-auto"></div>
            </div>
            <div class="col-lg-2 col-md-4 col-sm-6">
              <div class="customer"><img src="User/img/customers/logo6.jpeg" title="brand logo" data-placement="bottom" data-toggle="tooltip" alt="" class="img-fluid d-block mx-auto"></div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Contact-->
    <section id="contact" data-animate="bounceIn" class="contact-section contact">
      <div class="container">
        <header class="text-center">
          <h2 class="title">Contact Us</h2>
        </header>
        <div class="row">
          <div class="col-lg-8 mx-auto">
            <form id="contact-form" method="post" action="ContactFormController">
              <div class="messages"></div>
              <div class="controls">
                <div class="row">
                  <div class="col-md-6">
                    <input type="text" name="name" placeholder="Your firstname *" required="required" class="form-control">
                  </div>
                  <div class="col-md-6">
                    <input type="text" name="surname" placeholder="Your lastname *" required="required" class="form-control">
                  </div>
                  <div class="col-md-6">
                    <input type="text" name="email" placeholder="Your email *" required="required" class="form-control">
                  </div>
                  <div class="col-md-6">
                    <input type="text" name="phone" placeholder="Your phone *" class="form-control">
                  </div>
                  <div class="col-md-12">
                    <textarea name="message" placeholder="Message for me *" rows="4" required="required" class="form-control"></textarea>
                  </div>
                  <div class="col-md-12 text-center">
                     <input type="submit" class="btn btn-outline-primary" name="action" value="Send message" id="Send message" formname="home.jsp">
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <!-- Map-->
   <!--  <div id="map"></div> -->
    
    <jsp:include page="UserFooter.jsp"></jsp:include>
    <!-- JavaScript files-->
    <script src="User/vendor/jquery/jquery.min.js"></script>
    <script src="User/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="User/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="User/vendor/owl.carousel/owl.carousel.min.js"></script>
    <script src="User/vendor/waypoints/lib/jquery.waypoints.min.js"></script>
    <script src="User/vendor/jquery.counterup/jquery.counterup.js"></script>
    <script src="User/ajax/libs/leaflet/1.4.0/leaflet.js"> </script>
    <script src="User/js/front.js"></script>
  </body>
</html>