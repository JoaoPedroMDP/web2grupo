<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Produtos</title>

    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />

    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet" />
    <link href="../css/global.css" rel="stylesheet" />
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
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="profile.jsp"
            >Perfil</a
          >
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="callListEmployee.jsp"
            >Atendimentos</a
          >
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="category.jsp"
            >Categorias</a
          >
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="product.jsp"
            >Produtos</a
          >
        </div>

        <div
          class="sidebar-footer sidebar-personalized"
          style="text-align: justify"
        >
          <span class="list-group-item-light-personalized-2">
            BEIBE - Beauty Embuste Indústria de Beleza e Estética Rua do Embuste, nº 1212 Curitiba-PR, CEP 12122-123 Tel.: (41) 91212-1212
          </span>
        </div>
      </div>

      <!-- Page content wrapper-->
      <div id="page-content-wrapper">
        <!-- Top navigation-->
        <nav
          class="navbar navbar-expand-lg navbar-light bg-light border-bottom"
        >
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
                <c:if test="${empty sessionScope.login}" >
                  <jsp:forward page="/index.html"></jsp:forward>
                </c:if>
                <li class="nav-item"><a class="nav-link" href="../customer/profile.jsp">${sessionScope.login.name}</a></li>
                <li class="nav-item"><a class="nav-link" href="../LogoutServlet" role="button"><span class="material-icons">logout</span></a></li>
              </ul>
            </div>
          </div>
        </nav>

        <!-- Page content (Conteúdo da página)-->
        <div class="container-fluid">
          <div class="page-title-wrapper">
            <h1 class="page-title">PRODUTOS</h1>
          </div>
          <!-- Conteúdo da Página -->
          <table
            class="container-fluid d-flex justify-content-center justify-content-around"
          >
            <tbody>
              <tr>
                <th>Produtos</th>
                <th>Categorias</th>
                <th></th>
              </tr>

              <tr>
                <td
                  class="container-fluid d-print-table list-group-item-light-personalized"
                >
                  Produto
                </td>
                <td
                  class="container-fluid d-print-table list-group-item-light-personalized"
                >
                  Shampoo
                </td>
                <td><a class="dropdown-item" href="#!">Editar</a></td>
                <td><a class="dropdown-item" href="#!">Remover</a></td>
              </tr>
              <tr>
                <td
                  class="container-fluid d-print-table list-group-item-light-personalized"
                >
                  Produto
                </td>
                <td
                  class="container-fluid d-print-table list-group-item-light-personalized"
                >
                  Condicionador
                </td>
                <td><a class="dropdown-item" href="#!">Editar</a></td>
                <td><a class="dropdown-item" href="#!">Remover</a></td>
              </tr>
              <tr>
                <td
                  class="container-fluid d-print-table list-group-item-light-personalized"
                >
                  Produto
                </td>
                <td
                  class="container-fluid d-print-table list-group-item-light-personalized"
                >
                  Sabonete
                </td>
                <td><a class="dropdown-item" href="#!">Editar</a></td>
                <td><a class="dropdown-item" href="#!">Remover</a></td>
              </tr>
              <tr>
                <td class="report-box roundy d-flex m-4">
                  <button
                    id="select-action"
                    class="btn list-group-item-light-personalized"
                    href="#!"
                  >
                    Voltar
                  </button>
                </td>
                <td></td>
                <td>
                  <button
                    id="select-action"
                    class="btn list-group-item-light-personalized align-content-end"
                    href="#!"
                  >
                    Adicionar Produto
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </body>
</html>
