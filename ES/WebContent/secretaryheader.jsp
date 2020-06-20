<%@page import="com.es.model.registration_page"%>
<%@page import="com.es.dao.DbTransactionImpl"%>
<%@page import="com.es.controller.SuccessController"%>
<%@page import="com.es.formDesignUltility.FormFieldUltilityconstant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <title><%=FormFieldUltilityconstant.webConstant%></title>
    <!-- Meta Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Modernize Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />

 <!-- //Meta Tags -->

    <!-- Style-sheets -->
    <!-- Bootstrap Css -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Bootstrap Css -->
    <!-- Bars Css -->
    <link rel="stylesheet" href="css/bar.css">
    <!--// Bars Css -->
    <!-- Calender Css -->
    <link rel="stylesheet" type="text/css" href="css/pignose.calender.css" />
    <!--// Calender Css -->
    <!-- Common Css -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!--// Common Css -->
    <!-- Nav Css -->
    <link rel="stylesheet" href="css/style4.css">
    <!--// Nav Css -->
    <!-- Fontawesome Css -->
    <link href="css/fontawesome-all.css" rel="stylesheet">
    <!--// Fontawesome Css -->
    <!--// Style-sheets -->

    <!--web-fonts-->
    <link href="//fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <!--//web-fonts-->
</head>
<%

registration_page userdata=null;

	if(session.getAttribute("user")!=null){
		
		userdata=(registration_page)session.getAttribute("user");
	}
%>
<body>
<div class="se-pre-con"></div>
    <div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h1>
                    <a href="Secretary.jsp">E-Society</a>
                </h1>
                <span><a href="Secretary.jsp">E-S</a></span>
            </div>
            <div class="profile-bg"></div>
            <ul class="list-unstyled components">
                <li class="active">
                    <a href="Secretary.jsp">
                        Dashboard
                    </a>
                </li>
                
               <%--  <li>
                    <a href="#pageSubmenu1" data-toggle="collapse" aria-expanded="false">
                        <i class="far fa-user"></i>
                        Master Menu
                        <i class="fas fa-angle-down fa-pull-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="pageSubmenu1">
                        <li>
                            <a href="SuccessController?formname=<%=FormFieldUltilityconstant.register_society_name%>">Manage Society</a>
                            <a href="SuccessController?formname=<%=FormFieldUltilityconstant.mst_complain_name%>">Manage Complain</a>
                            
                            
                        </li>
                    </ul>
                </li> --%>
                <li>
                    <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false">
                        <i class="far fa-user"></i>
                        Manage <% %>
                        <i class="fas fa-angle-down fa-pull-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="pageSubmenu2">
                        <li>
                            <a href="mst_amenities.jsp">Manage Amenities</a>
                            <a href="mst_expense.jsp">Manage Expense</a>
                            <a href="notice.jsp"> Manage Notice </a>
                            <a href="mst_maintenance.jsp">Manage Maintenance </a>
                            <a href="mst_Security_Guard.jsp">Manage SecurityGuard </a>
                            <%-- <a href="SuccessController?formname=<%=FormFieldUltilityconstant.mst_tax_name%>">Manage Tax </a> --%>
                            <%-- <a href="SuccessController?formname=<%=FormFieldUltilityconstant.mst_bill_name%>">Manage Bill</a> --%>
                            <%-- <a href="SuccessController?formname=<%=FormFieldUltilityconstant.mst_expense_name%>">Manage Expense</a> --%>
                            <%-- <a href="SuccessController?formname=<%=FormFieldUltilityconstant.mst_visitor_name%>">Manage Visitor</a> --%>
                        	<!--  <a href="SecurityGuard.jsp">Security Guard</a> -->
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#pageSubmenu5" data-toggle="collapse" aria-expanded="false">
                        <i class="fa fa-bars"></i>
                        Reports
                        <i class="fas fa-angle-down fa-pull-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="pageSubmenu5">
                        <li>
                            <a href="secvisitordetails.jsp">Visitor Details Report</a>
                            <a href="secsidecomplain.jsp">Complaint Details Report</a>
                            <a href="pending-maintainance.jsp">Pending Maintainance Details Report</a>
                            <a href="generatedmaintainancereport.jsp">Current Month Maintainance Details</a>
                        </li>
                    </ul>
                </li>
				<!-- <li>
                    <a href="#pageSubmenu5" data-toggle="collapse" aria-expanded="false">
                        <i class="far fa-user"></i>
                        Customer
                        <i class="fas fa-angle-down fa-pull-right"></i>
                    </a>
                    <ul class="collapse list-unstyled" id="pageSubmenu5">
                        <li>
                        	<a href="user.jsp">user</a>
							<a href="Secretary.jsp">Secretary</a>
                            <a href="Report.jsp">Report</a>
                            <a href="UserReport.jsp">UserReport</a>
                            <a href="tran_req_service.jsp">Request Service</a>
                          
                            <a href="admin_master_menu.jsp">MASTER</a>
                        </li>
                    </ul>
                </li> -->
                
            </ul>
        </nav>

        <!-- Page Content Holder -->
        <div id="content">
            <!-- top-bar -->
            <nav class="navbar navbar-default mb-xl-5 mb-4">
                <div class="container-fluid">

                    <div class="navbar-header">
                        <button type="button" id="sidebarCollapse" class="btn btn-info navbar-btn">
                            <i class="fas fa-bars"></i>
                        </button>
                    </div>
                    <!-- Search-from --><%registration_page login=new registration_page();%>
                    
                    <form action="#" method="post" class="form-inline mx-auto search-form">
                    <h3>Welcome:<%=userdata.getUsername()%></h3>
                        
                    </form>
                    <!--// Search-from -->
                    <ul class="top-icons-agileits-w3layouts float-right">
                        
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                                <i class="far fa-user"></i>
                            </a>
                            <div class="dropdown-menu drop-3">
                                <div class="profile d-flex mr-o">
                                    <div class="profile-l align-self-center">
                                        <img src="images/profile.jpg" class="img-fluid mb-3" alt="Responsive image">
                                    </div>
                                    <div class="profile-r align-self-center">
                                        <h3 class="sub-title-w3-agileits"><%=userdata.getUsername() %></h3>
                                        <a href="mailto:info@example.com"><%=userdata.getEmail_id() %></a>
                                    </div>
                                </div>
                                <a href="adminProfile.jsp" class="dropdown-item mt-3">
                                    <h4>
                                        <i class="far fa-user mr-3"></i>My Profile</h4>
                                </a>
                                <a href="ChangePassword.jsp" class="dropdown-item mt-3">
                                    <h4>
                                        <i class="far fa-edit mr-3"></i>Change Password</h4>
								</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="logout.jsp">Logout</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <!--// top-bar -->
</body>
</html>