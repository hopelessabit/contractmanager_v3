
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <title>CONTRACT MANAGEMENT</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/index_style.css">
    
    </head>
      <!-- Spinner Start -->
    <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner"></div>
    </div>
    <!-- Spinner End -->
    <body>
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <h2 class="heading-section">CONTRACT MANAGEMENT</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-12 col-lg-10">
                        <div class="wrap d-md-flex">
                            <div class="img" style="background-image: url(images/bg-1.jpg);">
                            </div>
                            <div class="login-wrap p-4 p-md-5">
                                <div class="d-flex">
                                    <div class="w-100">
                                        <h3 class="mb-4">Sign In</h3>
                                    </div>
                                    <div class="w-100">
                                        <p class="social-media d-flex justify-content-end">
                                            <a href="https://www.facebook.com/duonggg01/" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
                                            <a href="https://www.facebook.com/duonggg01/" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
                                        </p>
                                    </div>
                                </div>
                                <div style="color:red;"> ${requestScope.notification} </div>
                                <form action="MainController" method="post" class="signin-form">
                                    <div class="form-group mb-3">
                                        <label class="label" for="name">Username</label>
                                        <input type="text" name="emailtxt" value="${param.emailtxt}" class="form-control" placeholder="Username" required>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label class="label" for="password">Password</label>
                                        <input type="password" name="passwordtxt" class="form-control" placeholder="Password" required>
                                    </div>
                                   
                                    
                                    
                                    <div class="form-group">
                                        <button type="submit" value="Login" name="action" class="form-control btn btn-primary rounded submit px-3">Sign In</button>
                                    </div>
                                    <div class="form-group d-md-flex">
                                        <div class="w-50 text-left">
                                            <label class="checkbox-wrap checkbox-primary mb-0">Remember Me
                                                <input type="checkbox" checked>
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                      
                                    </div>
                                </form>
                                <p class="text-center">Not a member? <a  href="Registration.jsp">Sign Up</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js_index/jquery.min.js"></script>
        <script src="js_index/popper.js"></script>
        <script src="js_index/bootstrap.min.js"></script>
        <script src="js_index/main.js"></script>

    </body>
</html>


