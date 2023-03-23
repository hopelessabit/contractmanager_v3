<%-- 
    Document   : ViewAllUser
    Created on : Mar 17, 2023, 12:02:03 AM
    Author     : mical
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
            <c:set var="viewUserType" value="${requestScope.viewUserType}"></c:set>
                <section class="section dashboard">
                    <div class="row">
                        <div class="col-lg-12">
                            <table>
                                <form action="MainController" method="POST">
                                    <tr>
                                        <td><input type="text" class="form-control" id="floatingInput" placeholder="Search by name" name="keyWord" value="${param.keyWord}"/></td>
                                    <td> 
                                        <select class="form-select" type="hidden" name="role">
                                            <c:if test="${(viewUserType == 'O')}">
                                                <option value="C">Customer</option>
                                                <option value="R">Resident</option>
                                                <option value="O" selected>Owner</option>
                                            </c:if>
                                            <c:if test="${(viewUserType == 'C')}">
                                                <option value="C" selected>Customer</option>
                                                <option value="R">Resident</option>
                                                <option value="O">Owner</option>
                                            </c:if>
                                            <c:if test="${(viewUserType == 'R')}">
                                                <option value="C">Customer</option>
                                                <option value="R" selected>Resident</option>
                                                <option value="O">Owner</option>
                                            </c:if>
                                            <c:if test="${(viewUserType == null)}">
                                                <option value="C" selected>Customer</option>
                                                <option value="R">Resident</option>
                                                <option value="O">Owner</option>
                                            </c:if>

                                            <c:if test="${userType == 'B'}">
                                                <c:if test="${(viewUserType == 'A')}">
                                                    <option  value="A" selected>Admin</option>
                                                </c:if>
                                                <c:if test="${(viewUserType != 'A')}">
                                                    <option  value="A">Admin</option>
                                                </c:if>
                                            </c:if>
                                        </select>
                                    </td>
                                    <td><input class="btn btn-primary" type="submit" name="action" value="Search User"/></td>
                                </tr>
                                <br/>
                            </form>
                        </table></div><br></br><br></br>

                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <c:if test="${(viewUserType == 'O')}">
                                    <h5 class="card-title">OWNER LIST ON SEVER</h5>
                                </c:if>
                                <c:if test="${(viewUserType == 'C')}">
                                    <h5 class="card-title">CUSTOMER LIST ON SEVER</h5>
                                </c:if>
                                <c:if test="${(viewUserType == 'R')}">
                                    <h5 class="card-title">RESIDENT LIST ON SEVER</h5>
                                </c:if>
                                <c:if test="${(viewUserType == 'A')}">
                                    <h5 class="card-title">ADMIN LIST ON SEVER</h5>
                                </c:if>

                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Phone Number</th>
                                            <th scope="col">Live Contract</th>
                                            <th scope="col">Status</th>
                                            <th scope="col">Action</th>
                                            <th scope="col"></th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        <c:forEach var="user" varStatus="count" items="${requestScope.list}">
                                            <c:if test="${(viewUserType == 'R') || (viewUserType == 'C')}">
                                                <c:set var="ID" value="${user.getUID()}"/>
                                            </c:if>
                                            <c:if test="${viewUserType == 'O'}">
                                                <c:set var="ID" value="${user.getOID()}"/>
                                            </c:if>
                                            <c:if test="${viewUserType == 'A'}">
                                                <c:set var="ID" value="${user.getAID()}"/>
                                            </c:if>

                                            <tr>
                                                <td>${ID}</td>
                                                <td>${user.getFullName()}</td>
                                                <td>${user.getEmail()}</td>
                                                <td>${user.getPhoneNumber()}</td>
                                                <td>
                                                    <c:if test="${requestScope.countContract[count.index] == null}">None</c:if>
                                                    <c:if test="${requestScope.countContract[count.index] != null}">${requestScope.countContract[count.index]}</c:if>
                                                    </td>
                                                    <td>${user.getStatus()}</td>
                                        <form action="MainController" method="post">
                                            <input type="hidden" name="status" value="${user.getStatus()}"/>
                                            <input type="hidden" name="viewUserType" value="${viewUserType}"/>
                                            <input type="hidden" name="keyWord" value="${requestScope.keyWord}"/>
                                            <td><input class="btn btn-danger" type="submit" name="action" value="BAN/UNBAN"/></td>
                                        </form>
                                        <form action="MainController" method="post">
                                            <input type="hidden" name="keyWord" value="${requestScope.keyWord}"/>
                                            <input type="hidden" name="id" value="${ID}"/>
                                            <input type="hidden" name="role" value="${viewUserType}"/>
                                            <td><input class="btn btn-danger" type="submit" name="action" value="EDIT"/></td>
                                        </form>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- End Table with stripped rows -->
                </div>
                <p>${requestScope.account.toString()}</p>
                <c:set var="account" value="${requestScope.account}"/>
                <form action="MainController" >
                    <div class="row mb-3">
                        <label for="fullName" class="col-md-4 col-lg-3 col-form-label">ID: </label>
                        <div class="col-md-8 col-lg-9">
                            <input name="txtFullName" type="text" class="form-control" id="fullName" value="${requestScope.accountID}">
                            <div style="color: red;">${requestScope.nameError}</div>
                        </div> 
                    </div> 
                    <div class="row mb-3">
                        <label for="fullName" class="col-md-4 col-lg-3 col-form-label">Full Name: </label>
                        <div class="col-md-8 col-lg-9">
                            <input name="txtFullName" type="text" class="form-control" id="fullName" value="${account.getFullName()}">
                            <div style="color: red;">${requestScope.nameError}</div>
                        </div> 
                    </div> 
                    <div class="row mb-3">
                        <label for="txtcid" class="col-md-4 col-lg-3 col-form-label ">CID</label>
                        <div class="col-md-8 col-lg-9">
                            <input name="txtcid" type="text" class="form-control" id="txtcid" value="${account.getCID()}">
                            <div style="color: red;">${requestScope.CIDError}</div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="Address" class="col-md-4 col-lg-3 col-form-label">Address</label>
                        <div class="col-md-8 col-lg-9">
                            <input name="txtAddress" type="text" class="form-control" id="Address" value="${account.getAddress()}">
                            <div style="color: red;">${requestScope.addressError}</div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="Phone" class="col-md-4 col-lg-3 col-form-label">Phone</label>
                        <div class="col-md-8 col-lg-9">
                            <input name="txtPhone" type="text" class="form-control" id="Address" value="${account.getPhoneNumber()}">
                            <div style="color: red;">${requestScope.phoneError}</div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label for="DateOfBirth" class="col-md-4 col-lg-3 col-form-label">Date Of Birth:</label>
                        <div class="col-md-8 col-lg-9">
                            <input name="txtDob" type="date" class="form-control" id="Address" value="${account.getDateOfBirth()}">
                            <div style="color: red;">${requestScope.dobError}</div>
                        </div>
                    </div>
                    <input type="hidden" name="id" value="${ID}"/>
                    <input type="hidden" name="viewUserType" value="${viewUserType}"/>
                    <input type="hidden" name="action" value="SaveProfileForUser"/>
                    <div class="text-center">
                        <button type="submit" value="Save Profile" class="btn btn-primary">Save Changes</button>
                    </div>
                </form>
            </section>
        </main>
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
