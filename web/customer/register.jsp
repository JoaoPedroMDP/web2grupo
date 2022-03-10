<%-- 
    Document   : register
    Created on : Mar 3, 2022, 8:42:03 PM
    Author     : Ludimilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="./../css/styles.css" rel="stylesheet" />

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </head>
    <body>
        <!-- Page content (Conteúdo da página)-->

        <div class="container-fluid">
            <!--                    <section class="vh-100 bg-image" style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">-->
            <section class="vh-100 bg-image" style="background-image: linear-gradient(315deg, #63d471 0%, #233329 74%);">

                <div class="mask d-flex align-items-center h-100 gradient-custom-3">
                    <div class="container h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                                <div class="card" style="border-radius: 15px;">
                                    <div class="card-body p-5">
                                        <h2 class="text-uppercase text-center mb-5">Create an account</h2>

                                        <form>

                                            <div class="form-outline mb-4">
                                                <input type="text" id="form3Example1cg" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example1cg">Your Name</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="email" id="form3Example3cg" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example3cg">Your Email</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="password" id="form3Example4cg" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example4cg">Password</label>
                                            </div>

                                            <div class="form-outline mb-4">
                                                <input type="password" id="form3Example4cdg" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example4cdg">Repeat your password</label>
                                            </div>

                                            <!--                                                    <div class="form-check d-flex justify-content-center mb-5">-->
                                            <div class="col-md-9 pe-5" >

                                                <input class="form-control form-control-lg" id="formFileLg" type="file" />
                                                <label class="form-label" for="form3Example4cdg" class="small text-muted mt-2">Profile picture </label>
                                                <div class="small text-muted "> Max file size 50 MB</div>

                                            </div>
                                            <div class="d-flex justify-content-center">
                                                <button class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" type="submit" onclick="window.location = 'profile.jsp'" >Register</button>
                                            </div>

                                            <p class="text-center text-muted mt-3 mb-0">Have already an account? <a href="../login.html" class="fw-bold text-body"><u>Login here</u></a></p>
                                            <p class="text-center text-muted mt-3 mb-0" <a href="#" ><u>Voltar</u></a></p>

                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </body>
</html>
