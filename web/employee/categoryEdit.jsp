<%-- 
    Document   : category
    Created on : Mar 3, 2022, 8:43:05 PM
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Categoria</title>

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/css/report.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../js/scripts.js"></script>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading bg-light">BEIBE</div>

                <!-- INSIRA NA DIV ABAIXO OS ITENS DE MENU DA TELA -->
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom" href="profile.jsp">Perfil</a>
                    <a class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom" href="callListEmployee.jsp">Atendimentos</a>
                    <a class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom" href="category.jsp">Categorias</a>
                    <a class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom" href="product.jsp">Produtos</a>
                </div>

                <div class="sidebar-footer sidebar-personalized" style="text-align: justify;">
                    <a class="list-group-item-light-personalized-2" href="#!">BEIBE - Beauty Embuste Ind??stria de Beleza e Est??tica Rua do Embuste, n?? 1212 Curitiba-PR, CEP 12122-123 Tel.: (41) 91212-1212</a>
                </div>
            </div>

            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn" id="sidebarToggle"><span class="material-icons">reorder</span></button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item"><a class="nav-link" href="#!">[User]</a></li>
                                <li class="nav-item"><a class="nav-link" href="#!"><span class="material-icons">logout</span></a></li>
                                <!--<li class="nav-item active"><a class="nav-link" href="#!">Home</a></li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#!">Action</a>
                                        <a class="dropdown-item" href="#!">Another action</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="#!">Something else here</a>
                                    </div>
                                </li>-->
                            </ul>
                        </div>
                    </div>
                </nav>

                <!-- Page content (Conte??do da p??gina)-->
                <div class="container-fluid">
                    <div class="page-title-wrapper">
                        <h1 class="page-title"></h1>
                    </div>
                    <!-- Conte??do da P??gina -->
                    <div class="page-title-wrapper">
                        <h1 class="page-title">EDITAR CATEGORIA</h1>
                    </div>
                    <div class="container-fluid d-flex justify-content-center">
                        <div class="report-box roundy d-flex flex-column align-items-center">
                            <form action = "/web2grupo/CategoryServlet?action=update" name = "cadastroCategoria" method="POST">
                                <div class="row mb-4">
                                    <div class="col">
                                        <div class="form-outline">
                                            <label class="form-label" for="cadastroCategoria">Nome</label>
                                            <input type="text" id="form6Example1"name="name" value="${nome}" />
                                        </div>
                                    </div>  
                                </div>
                                <div class="d-flex justify-content-center">
                                    <input value="Salvar" class="btn-success nav-link active bg-sucess" type="submit"/>
                                    <!--                                        <button class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" type="submit" onclick="window.location = 'profile.jsp'" >Register</button>-->
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

