<%-- 
    Document   : AdminIndex
    Created on : Mar 16, 2023, 9:41:20 PM
    Author     : mical
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Dashboard - NiceAdmin Bootstrap Template</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">
        <link href="landing page/css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">

        <!-- =======================================================
        * Template Name: NiceAdmin - v2.5.0
        * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>
    <body>

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="MainController?action=getInfo" class="logo d-flex align-items-center">
                    <img src="assets/img/logo.png" alt="">
                    <span class="d-none d-lg-block">ContractM</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->
  <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">
            

                    <li class="nav-item dropdown pe-3">

                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                            <img src="images/${sessionScope.user.getAvatar()}" alt="Profile" class="rounded-circle">
                            <span class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.admin.fullName}</span>
                        </a><!-- End Profile Iamge Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <h6>${sessionScope.admin.fullName}</h6>

                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="MainController?action=View+Profile">
                                    <i class="bi bi-person"></i>
                                    <span>My Profile</span>
                                </a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>


                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <form action="MainController" method="post">
                                    <a class="dropdown-item d-flex align-items-center" href="MainController?action=Logout" >
                                        <i class="bi bi-box-arrow-right"></i>
                                        <span>Sign Out</span>
                                    </a>
                                </form>  
                            </li>

                        </ul><!-- End Profile Dropdown Items -->
                    </li><!-- End Profile Nav -->

                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">

                <li class="nav-item">
                    <a class="nav-link " href="MainController?action=getInfo">
                        <i class="bi bi-grid"></i>
                        <span>Dashboard</span>
                    </a>
                </li><!-- End Dashboard Nav -->









                <li class="nav-heading">Pages</li>

            <li class="nav-item">
                    <a class="nav-link collapsed" href="MainController?action=View+Profile">
                        <i class="bi bi-person-badge"></i>
                        <span>Profile</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="ViewAllUser.jsp">
                        <i class="bi bi-person-lines-fill"></i><span>All user on sever</span>
                    </a>

                </li>
                <c:if test="${sessionScope.userType == 'B'}">
                    <li class="nav-item">
                    <a class="nav-link collapsed" href="AddNewAdmin.jsp">
                        <i class="bi bi-person-add"></i>
                        <span>Add new admin</span>
                    </a>
                </li>  
                </c:if>

                 <li class="nav-item">
                    <a class="nav-link collapsed" href="ViewAllContract.jsp">
                        <i class="bi bi-layout-text-window-reverse"></i>
                        <span>All contract on server</span>
                    </a>
                </li>
                 <c:if test="${sessionScope.userType == 'B'}">
                    <li class="nav-item">
                    <a class="nav-link collapsed" href="AddRoom.jsp">
                        <i class="bi bi-house-add"></i>
                        <span>Add room</span>
                    </a>
                </li>  
                </c:if>
                <!-- End Profile Page Nav -->


            </ul>

        </aside><!-- End Sidebar-->

        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Dashboard</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="MainController?action=getInfo">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->
            <!------------------------------------------------------ Start Main ---------------------------------------------------->
            <c:set var="user" value="${sessionScope.user}"></c:set>
            <c:if test="${(user.getAID()) != null}">
                <section class="section dashboard">
                    <section class="section dashboard">
                        <div class="row">

                            <!-- Left side columns -->
                            <div class="col-lg-12">
                                <div class="row">

                                    <!-- Sales Card -->
                                    <div class="col-xxl-3 col-md-6">
                                        <div class="card info-card sales-card">



                                            <div class="card-body">
                                                <h5 class="card-title">Avalible contract <span>| All time</span></h5>

                                                <div class="d-flex align-items-center">
                                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                        <i class="bi bi-patch-check"></i>
                                                    </div>
                                                    <div class="ps-3">
                                                        <h6>${requestScope.customerAvailable}</h6>


                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div><!-- End Sales Card -->

                                    <!-- Revenue Card -->
                                    <div class="col-xxl-3 col-md-6">
                                        <div class="card info-card customers-card">



                                            <div class="card-body">
                                                <h5 class="card-title">Unavalible contract <span>| All time</span></h5>

                                                <div class="d-flex align-items-center">
                                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                        <i class="bi-patch-exclamation"></i>
                                                    </div>
                                                    <div class="ps-3">
                                                        <h6>${requestScope.contractUnavailable}</h6>


                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div><!-- End Revenue Card -->

                                    <!-- Customers Card -->
                                    <div class="col-xxl-6 col-md-6">
                                        <div class="card info-card revenue-card">



                                            <div class="card-body">
                                                <h5 class="card-title">Revenue <span>| All time</span></h5>

                                                <div class="d-flex align-items-center">
                                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                        <i class="bi bi-currency-dollar"></i>
                                                    </div>
                                                    <div class="ps-3 text-center">
                                                        <h6>${revenue}</h6>


                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-xxl-3 col-xl-12">

                                        <div class="card info-card customers-card">



                                            <div class="card-body">
                                                <h5 class="card-title">Active user <span>| All time</span></h5>

                                                <div class="d-flex align-items-center">
                                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                        <i class="bi bi-person-check"></i>
                                                    </div>
                                                    <div class="ps-3">
                                                        <h6>${requestScope.customerAvailable + requestScope.residentAvailable + requestScope.ownerAvailable} </h6>


                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-xxl-3 col-xl-12">

                                        <div class="card info-card customers-card">



                                            <div class="card-body">
                                                <h5 class="card-title">Unactive user <span>| All time</span></h5>

                                                <div class="d-flex align-items-center">
                                                    <div class="card-icon rounded-circle d-flex align-items-center justify-content-center">
                                                        <i class="bi bi-person-x"></i>
                                                    </div>
                                                    <div class="ps-3">
                                                        <h6>${requestScope.ownerUnavailable + requestScope.customerUnavailable + requestScope.residentUnavaiable}</h6>


                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                    </div>

                                    <!-- End Customers Card -->





                                </div><!-- End Right side columns -->

                            </div>
                    </section>

            </main><!-- End #main -->
            <!-- End #main --------------------------------------------------------------------------------------------------------------->





        </c:if>




        <c:if test="${(user.getAID()) == null}">
            <h1>Access Denied</h1>
            <a href="LoginIndex.jsp">Back to login page</a>
        </c:if>    

        <!-- ======= Footer ======= -->
        <footer id="footer" class="footer">
            <div class="copyright">
                &copy; Copyright <strong><span>Contract Management</span></strong>. All Rights Reserved
            </div>
            <div class="credits">

                Designed by <a href="https://youtube.com">Contract Management team</a>
            </div>
        </footer><!-- End Footer -->

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.umd.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

    </body>


</html>


