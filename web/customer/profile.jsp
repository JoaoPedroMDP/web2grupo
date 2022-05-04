<%-- Document : profile Created on : Mar 3, 2022, 8:41:51 PM Author : Ludimilla

--%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="./../css/styles.css" rel="stylesheet" />
        <link href="./../css/profile.css" rel="stylesheet" />

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading bg-light">BEIBE</div>

                <!-- INSIRA NA DIV ABAIXO OS ITENS DE MENU DA TELA -->
                <div class="list-group list-group-flush">
                    <a
                        class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
                        href="#!"
                        >Perfil</a
                    >
                    <a
                        class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
                        href="#!"
                        >Atendimentos</a
                    >
                    <a
                        class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
                        href="#!"
                        >Novo atendimento</a
                    >
                </div>

                <div
                    class="sidebar-footer sidebar-personalized"
                    style="text-align: justify"
                    >
                    <a class="list-group-item-light-personalized-2" href="#!"
                       >BEIBE - Beauty Embuste Indústria de Beleza e Estética Rua do
                        Embuste, nº 1212 Curitiba-PR, CEP 12122-123 Tel.: (41) 91212-1212</a
                    >
                </div>
            </div>

            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn" id="sidebarToggle">
                            <span class="material-icons">reorder</span>
                        </button>
                        <button
                            class="navbar-toggler"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent"
                            aria-expanded="false"
                            aria-label="Toggle navigation"
                            >
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item">
                                    <a class="nav-link" href="#!">${user.name}</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#!"
                                       ><span class="material-icons">logout</span></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <!-- Page content (Conteúdo da página)-->
                <div class="container-fluid">
                    <div class="page-content page-container" id="page-content">
                        <div class="padding">
                            <div class="row container d-flex justify-content-center">
                                <div class="col-xl-18 col-md-30">
                                    <div class="card user-card-full">
                                        <div class="row m-l-0 m-r-0">
                                            <div class="col-sm-8">
                                                <div class="card-block">
                                                    <h6 class="m-b-20 p-b-5 b-b-default f-w-600">
                                                        Information
                                                    </h6>
                                                    <div class="row mb-6">

                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">Name</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${user.name}
                                                            </h6>
                                                        </div>


                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">Surname</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${user.surname}
                                                            </h6>
                                                        </div>

                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">Email</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${user.email}
                                                            </h6>
                                                        </div>

                                                    </div>
                                                    <div class="row mb-6">

                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">CPF</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${user.cpf}
                                                            </h6>
                                                        </div>


                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">Phone</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${user.phone}
                                                            </h6>
                                                        </div>

                                                    </div>
                                                    <div class="row mb-6">
                                                        <h6 class="m-b-20 p-b-5 b-b-default f-w-600">
                                                            Address
                                                        </h6>
                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">Street</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${address.street}
                                                            </h6>
                                                        </div>


                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">Number</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${address.number}
                                                            </h6>
                                                        </div>

                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">Zip Code</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${address.zip_code}
                                                            </h6>
                                                        </div>

                                                    </div>
                                                    <div class="row mb-6">

                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">Complement</p>
                                                            <h6 class="text-muted f-w-400">
                                                                ${address.complement}
                                                            </h6>
                                                        </div>


                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">City</p>
                                                            <h6 class="text-muted f-w-400">

                                                            </h6>
                                                        </div>

                                                        <div class="col-sm-4">
                                                            <p class="m-b-10 f-w-600">State</p>
                                                            <h6 class="text-muted f-w-400">

                                                            </h6>
                                                        </div>
                                                    </div>
                                                    <div>
<!--                                                        <button
                                                            class="edit_button"
                                                            type="submit"
                                                            onclick="window.location = 'register.jsp'"
                                                            >
                                                            Edit profile
                                                        </button>-->

                                                        <a class="edit_button" type="submit" href="${pageContext.request.contextPath}/UserServlet?action=formUpdate&id=12">Edit Profile</a>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
