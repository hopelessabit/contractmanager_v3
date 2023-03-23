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
                            <span class="d-none d-md-block dropdown-toggle ps-2"></span>
                        </a><!-- End Profile Iamge Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <h6></h6>

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

                <li class="nav-item">
                    <a class="nav-link collapsed" href="AddNewAdmin.jsp">
                        <i class="bi bi-person-add"></i>
                        <span>Add new admin</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="ViewAllContract.jsp">
                        <i class="bi bi-layout-text-window-reverse"></i>
                        <span>All contract on server</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="MainController?action=GetOwner&CID=">
                        <i class="bi bi-house-add"></i>
                        <span>Add room</span>
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
                        <li class="breadcrumb-item"><a href="MainController?action=getInfo">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->
            <!------------------------------------------------------ Start Main ---------------------------------------------------->


            <section class="section dashboard">
                <div class="row">
                    <div class="col-lg-12">
                        <table>
                            <form action="MainController" method="post">
                            <tr>
                                <td><input type="text" class="form-control" id="floatingInput" placeholder="INPUT OWNER CID" name="CID" value="${CID}"/></td>

                                <td>
                                    <input class="btn btn-primary" type="submit" value="Search Owner"/>
                                    <input type="hidden" value="GetOwner" name="action"/>
                                </td>
                                </form>
                        </table>
                                
                                <c:set var="roomFreeList" value="${requestScope.roomFreeList}"/>
                                <c:set var="ownerList" value="${requestScope.ownerList}"/>
                                <table class="table table-striped">
                                    <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">CID</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Room</th>
                                    <th scope="col">Action</th>
                                   
                                </tr>
                                    </thead>
                                    <tbody>
                                <c:forEach var="owner" items="${ownerList}">
                                    <tr>
                                        <td>${owner.getOID()}</td>
                                        <td>${owner.getFullName()}</td>
                                        <td>${owner.getCID()}</td>
                                        <td>${owner.getPhoneNumber()}</td>
                                    <form action="MainController" method="post">
                                        <td>
                                            <select name="RoID">
                                                <c:forEach var="RoID" items="${roomFreeList}">
                                                    <option value="${RoID}">${RoID}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td><input class="btn btn-success" type="submit" value="Add Room"</td>
                                        <input type="hidden" value="AddRoom" name="action"/>
                                        <input type="hidden" value="${owner.getOID()}" name="OID"/>
                                        <input type="hidden" value="${CID}" name="CID"/>
                                    </form>
                                    </tr>
                                </c:forEach>
                                    </tbody>
                                    <tr ><div style="color:green;">${requestScope.noti}</div></td></tr>
                            </table>
                            </section>

                            </main><!-- End #main -->
                            <!-- End #main --------------------------------------------------------------------------------------------------------------->












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





