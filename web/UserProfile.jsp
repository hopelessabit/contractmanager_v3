<%-- 
    Document   : UserProfile
    Created on : Mar 16, 2023, 6:52:48 PM
    Author     : mical
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Users / Profile - NiceAdmin Bootstrap Template</title>
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

        <!-- ======= Header ======= -->
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
                        </a><!-- End Profile Iamge Icon -->

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
                            <a href="MainController?action=Pending+contract">
                                <i class="bi bi-circle"></i><span>Pending contract</span>
                            </a>
                        </li>
                    </ul>
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
                        <li class="breadcrumb-item">Users</li>
                        <li class="breadcrumb-item active">Profile</li>

                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section profile">
                <div class="row">
                    <div class="col-xl-4">

                        <div class="card">
                            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">

                                <img src="images/${sessionScope.user.getAvatar()}" alt="Profile" class="rounded-circle">
                                <h2>${sessionScope.user.getFullName()}</h2>

                            </div>

                            <div class="d-flex flex-column align-items-center">     
                                <div class="p-2">
                                    <form method="post" action="SetAvatarServlet" enctype="multipart/form-data">
                                        <div>
                                            <label for="avatar" class="custom-file-upload">
                                                <i class="btn btn-primary btn-sm bi bi-upload"></i>
                                            </label>

                                            <input class="form-control" type="file" id="avatar" name="avatar" style="opacity: 0; position: absolute; left: -9999px;" />

                                            <input class="btn btn-primary btn-sm" type="submit" value="UPDATE AVATAR">
                                        </div>
                                    </form>
                                </div>

                                <style>
                                    .custom-file-upload {
                                        display: inline-block;
                                        padding: 6px 12px;
                                        cursor: pointer;
                                        color: #fff;

                                    }
                                </style>
                                <div class="p-2">
                                    <form method="post" action="MainController">
                                        <label>

                                            <input class="btn btn-danger btn-sm" type="submit" value="REMOVE AVATAR">
                                            <input type="hidden" value="Delete Avatar" name="action"> 
                                        </label>
                                    </form> 
                                </div>



                            </div>  

                        </div>

                    </div>

                    <div class="col-xl-8">

                        <div class="card">
                            <div class="card-body pt-3">
                                <!-- Bordered Tabs -->
                                <ul class="nav nav-tabs nav-tabs-bordered">

                                    <li class="nav-item">
                                        <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview">Overview</button>
                                    </li>

                                    <li class="nav-item">
                                        <button  class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">Edit Profile</button>
                                    </li>

                                    <li class="nav-item">
                                        <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password">Change Password</button>
                                    </li>

                                </ul>
                                <div class="tab-content pt-2">

                                    <div class="tab-pane fade show active profile-overview" id="profile-overview">
                                        <h5 class="card-title">Profile Details</h5>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label ">Full Name</div>
                                            <div class="col-lg-9 col-md-8"> ${sessionScope.user.getFullName()}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Nation ID</div>
                                            <div class="col-lg-9 col-md-8">${sessionScope.user.getCID()}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Birthday</div>
                                            <div class="col-lg-9 col-md-8">${sessionScope.user.getDateOfBirth()} </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Address</div>
                                            <div class="col-lg-9 col-md-8">${sessionScope.user.getAddress()}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Phone</div>
                                            <div class="col-lg-9 col-md-8">${sessionScope.user.getPhoneNumber()}</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Email</div>
                                            <div class="col-lg-9 col-md-8">${sessionScope.user.getEmail()}</div>
                                        </div>
                                        <div style="color: green;">${requestScope.noti}</div>






                                    </div>
                                    <!-- Profile Edit Form -->
                                    <c:set var="profileType" value="${requestScope.profileType}"></c:set>
                                    <c:set var="edit" value="${requestScope.edit}"></c:set>
                                        <div class="tab-pane fade profile-edit pt-3 text-dark" id="profile-edit">

                                            <table>
                                            <c:if test="${edit == 'true'}">

                                                <form action="MainController">


                                                    <div class="row mb-3">
                                                        <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Full Name: </label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="txtFullName" type="text" class="form-control" id="fullName" value="${sessionScope.user.getFullName()}">
                                                            <div style="color: red;">${requestScope.nameError}</div>
                                                        </div> 
                                                    </div>
                                                    <c:if test="${(profileType == 'C')}">   
                                                        <div class="row mb-3">
                                                            <label for="txtcid" class="col-md-4 col-lg-3 col-form-label ">CID</label>
                                                            <div class="col-md-8 col-lg-9">
                                                                <input name="txtcid" type="text" class="form-control" id="txtcid" value="${requestScope.viewProfile.getCID()}">
                                                                <div style="color: red;">${requestScope.CIDError}</div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${(profileType == 'O')}">   
                                                        <div class="row mb-3">
                                                            <label for="txtcid" class="col-md-4 col-lg-3 col-form-label">CID</label>
                                                            <div class="col-md-8 col-lg-9">
                                                                <input name="txtcid" type="text" class="form-control" id="txtcid" value="${requestScope.viewProfile.getOCID()}">
                                                                <div style="color: red;">${requestScope.CIDError}</div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${(profileType == 'R')}">   
                                                        <div class="row mb-3">
                                                            <label for="txtcid" class="col-md-4 col-lg-3 col-form-label">CID</label>
                                                            <div class="col-md-8 col-lg-9">
                                                                <input name="txtcid" type="text" class="form-control" id="txtcid" value="${requestScope.viewProfile.getRCID()}">
                                                                <div style="color: red;">${requestScope.CIDError}</div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${(profileType == 'S')}">   
                                                        <div class="row mb-3">
                                                            <label for="txtcid" class="col-md-4 col-lg-3 col-form-label">CID</label>
                                                            <div class="col-md-8 col-lg-9">
                                                                <input name="txtcid" type="text" class="form-control" id="txtcid" value="${requestScope.viewProfile.getSCID()}">
                                                                <div style="color: red;">${requestScope.CIDError}</div>
                                                            </div>
                                                        </div>
                                                    </c:if>

                                                    <div class="row mb-3">
                                                        <label for="txtDate" class="col-md-4 col-lg-3 col-form-label">DOB</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="txtDate" type="date" class="form-control" id="company" value="${requestScope.txtDate}">
                                                            <div style="color: red;">${requestScope.DoBError}</div>
                                                        </div>
                                                    </div>

                                                    <div class="row mb-3">
                                                        <label for="Address" class="col-md-4 col-lg-3 col-form-label">Address</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="txtAddress" type="text" class="form-control" id="Address" value="${requestScope.address}">
                                                            <div style="color: red;">${requestScope.addressError}</div>
                                                        </div>
                                                    </div>



                                                  



                                                    <div class="text-center">
                                                        <button type="submit" name="action" value="Save Profile" class="btn btn-primary">Save Changes</button>
                                                    </div>

                                                </form>


                                                <!-- End Profile Edit Form -->
                                            </c:if>

                                        </table>


                                    </div>


                                    <div class="tab-pane fade pt-3" id="profile-change-password">
                                        <!-- Change Password Form -->

                                        <form action="MainController" method="post">
                                            <div class="row mb-3">
                                                <label for="password" class="col-md-4 col-lg-3 col-form-label">Old password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input type="password" name="oldPasstxt" class="form-control" required>
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="password" class="col-md-4 col-lg-3 col-form-label">New password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input type="password" name="newPasstxt" class="form-control" required>
                                                    <div style="color: red;">${err.passwordErr}</div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <label for="password" class="col-md-4 col-lg-3 col-form-label">Confirm new password</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <div style="color: red;">${err.confirmErr}</div>
                                                    <input type="password" name="confirmPasstxt" class="form-control" id="renewPassword">
                                                </div><br></br>
                                                <div class="text-center">
                                                    <button type="submit" value="Change password" class="btn btn-primary">Change Password</button>
                                                </div>
                                                <input type="hidden" name="txtPassword" value="${sessionScope.user.getPassword()}"/>
                                                <input type="hidden" name="durl" value="UserProfile.jsp"/>
                                                <input type="hidden" name="action" value="userChangePass"/>


                                                ${requestScope.noti} 
                                            </div>  
                                    </div>                                      


                                    </form>
                                    </form><!-- End Change Password Form -->

                                </div>

                            </div><!-- End Bordered Tabs -->

                        </div>
                    </div>

                </div>
                </div>
            </section>

        </main><!-- End #main -->

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