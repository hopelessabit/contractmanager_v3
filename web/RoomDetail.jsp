<%-- 
    Document   : RoomDetail
    Created on : Mar 20, 2023, 6:15:31 AM
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

        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="MainController?action=Find2contracts" class="logo d-flex align-items-center">
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
                            <span class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.user.getFullName()}</span>
                        </a><!-- End Profile Image Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <h6>${sessionScope.user.getFullName()}</h6>

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
                    <a class="nav-link " href="MainController?action=Find2contracts">
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
                    <a class="nav-link collapsed" data-bs-target="#tables-nav" data-bs-toggle="collapse" href="#">
                        <i class="bi bi-layout-text-window-reverse"></i><span>Contract</span><i class="bi bi-chevron-down ms-auto"></i>
                    </a>
                    <ul id="tables-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                        <li>
                            <a href="MainController?action=View+Contract">
                                <i class="bi bi-circle"></i><span>View all contract</span>
                            </a>
                        </li>
                        <li>
                            <a href="CreateContract.jsp">
                                <i class="bi bi-circle"></i><span>Create new contract</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link collapsed" href="MainController?action=ViewAllRoom">
                        <i class="bi bi-house-add"></i>
                        <span>Room</span>
                    </a>
                </li>
                <!-- End Profile Page Nav -->


            </ul>

        </aside><!-- End Sidebar-->

        <main id="main" class="main">

            <div class="pagetitle">
                <h1>Dashboard</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="MainController?action=Find2contracts">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->
            <!------------------------------------------------------ Start Main ---------------------------------------------------->

            <section class="section dashboard">
                <c:set var="roomList" value="${requestScope.roomList}"/>
                <c:set var="imgList" value="${requestScope.imgList}"/>
                <div class="row">
                    <div class="col-md-2">
                        <form action="MainController" method="post">
                            <div class="col-lg-12">
                                <div class="col-lg-12 mb-3">
                                    <label class="form-label">Select your Room ID</label> 
                                    <select class="form-control" name="RoID">
                                        <c:forEach var="RoID" items="${roomList}">
                                            <option value="${RoID}">${RoID}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-lg-12 mb-3">
                                    <input type="hidden" value="GetRoomForImg" name="action"/>
                                    <button class="btn btn-primary w-100" type="submit" name="action" value="Search Room">Search</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-5">
                        <c:if test="${requestScope.thisRoID != null}">
                            <form method="post" action="AddRoomPictureServlet?RoID=${requestScope.thisRoID}" enctype="multipart/form-data">
                                <div class="col-lg-12">
                                    <label class="form-label">Upload room image</label> 
                                    <div class="col-lg-12 mb-3">
                                        <input class="form-control" type="file" name="picture" multiple>
                                    </div>
                                    <div class="col-lg-12 mb-3">
                                        <input class="btn btn-primary w-100" type="submit" value="Upload">
                                    </div>
                                </div>
                            </form>
                        </c:if>
                    </div>
                </div>
                <br>
                <div class="row">


                    <c:forEach var="img" items="${imgList}">

                        <div class="col-lg-4">

                            <!-- Card with an image on top -->
                            <div class="card">
                                <img src="room_images/${img}" class="card-img-top" alt="..." style="width: 100%; height: 300px;">
                                <form action="MainController" method="post">
                                    <div class="card-body">
                                        <h5 class="card-title"> ${contract.getName()}</h5>                                    

                                        <input class="btn btn-danger" type="submit" name="action" value="Delete this picture">
                                    </div>
                            </div>
                        </div>
                        <input type="hidden" name="img" value="${img}">
                        <input type="hidden" name="RoID" value="${requestScope.thisRoID}">
                        </form>

                    </c:forEach>
                    <p style="color:red;">${requestScope.imgListNoti}</p>







                    <br/>
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
