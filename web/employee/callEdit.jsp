<%-- 
    Document   : callEdit
    Created on : 04/05/2022, 09:40:49
    Author     : Gustavo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored= "false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Chamada</title>

    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/report.css" rel="stylesheet" />

    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" />
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
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
          <a class="list-group-item-light-personalized-2" href="#!">BEIBE - Beauty Embuste Indústria de Beleza e Estética Rua do Embuste, nº 1212 Curitiba-PR, CEP 12122-123 Tel.: (41) 91212-1212</a>
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

        <!-- Page content (Conteúdo da página)-->
        <div class="container-fluid">
          <div class="page-title-wrapper">
                <h1 class="page-title"></h1>
          </div>
          <!-- Conteúdo da Página -->
        <div class="page-title-wrapper">
          <h1 class="page-title">EDITAR CHAMADA</h1>
        </div>
        <jsp:useBean id="ticket" class="beans.Ticket" scope="request" ></jsp:useBean>
          <div class="container-fluid d-flex justify-content-center">
              <div class="report-box roundy d-flex flex-column align-items-center">
                    <table>
                        <tbody>
                        <form action="TicketServlet?action=update"method="POST">
                            <input class="input-group-text alert-light" name = "id" value="<c:out value="${ticket.id}"/>" type="hidden" readonly/>
                            <input class="input-group-text alert-light" name = "product_id" value="<c:out value="${ticket.product_id}"/>" type="hidden" readonly/>
                            <input class="input-group-text alert-light" name = "type_id" value="<c:out value="${ticket.type_id}"/>" type="hidden" readonly/>
                            <input class="input-group-text alert-light" name = "user_id" value="<c:out value="${ticket.user_id}"/>" type="hidden" readonly/>
                            <tr><td><h3>Descrição</h3></td>
                                <td><input class="input-group-text alert-light" name="description" value="<c:out value="${ticket.description}"/>" type="text" /></td>
                            <tr><td><h3>Estado </h3></td>
                                <td><input class="input-group-text alert-light" name="state" value="<c:out value="${ticket.state}"/>" type="text" /></td>
                            <tr><td><h3>Solution </h3></td>
                                <td><input class="input-group-text alert-light" name="solution" value="<c:out value="${ticket.solution}"/>" type="text" /></td>
                            <tr>
                                <td><button id="select-action"  class="btn list-group-item-light-personalized">Salvar</button></td>  
                            </tr>
                            </form>
                        </tbody>  
                    </table>
              </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>

