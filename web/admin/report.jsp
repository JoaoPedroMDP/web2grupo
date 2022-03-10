<%-- Document : report Created on : Mar 3, 2022, 8:44:11 PM Author : joao --%>
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

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="../js/admin/report.js"></script>
    <link href="../css/global.css" rel="stylesheet" />
    <link href="../css/admin/report.css" rel="stylesheet" />

    <!-- BOOTSTRAP -->
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
        <link
        rel="stylesheet"
        href="https://fonts.googleapis.com/icon?family=Material+Icons"
        />
        <link href="../css/styles.css" rel="stylesheet" />

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <script src="../js/scripts.js"></script>
  </head>
  <body>
    <div class="d-flex" id="wrapper">
      <!-- Navbar -->
      <div class="bg-white" id="sidebar-wrapper">
        <div class="sidebar-heading bg-light">BEIBE</div>
        <div class="list-group list-group-flush">
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="userList.jsp"
            >Usuários</a
          >
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="#!"
            >Produtos</a
          >
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="#!"
            >Atendimentos</a
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
                <li class="nav-item">
                  <a class="nav-link" href="#!">[User]</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#!"
                    ><span class="material-icons">logout</span></a
                  >
                </li>
              </ul>
            </div>
          </div>
        </nav>

        <div class="page-title-wrapper">
          <h1 class="page-title">RELATÓRIOS</h1>
        </div>
        <div class="container-fluid d-flex justify-content-center">
          <div class="report-box roundy d-flex flex-column align-items-center">
            <div class="box-header roundy d-flex flex-column align-items-center">
              <h3 class="box-title">Selecione um relatório</h3>
              <!-- DROPDOWN -->
              <div class="dropdown">
                <button
                  class="btn btn-secondary dropdown-toggle"
                  type="button"
                  id="report-selection"
                  data-selected="None"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  Selecione
                </button>
                <div class="dropdown-menu" aria-labelledby="report-selection">
                  <button class="dropdown-item" type="button">Funcionários</button>
                  <button class="dropdown-item" type="button">
                    Produtos
                  </button>
                  <button class="dropdown-item" type="button">
                    Atendimentos
                  </button>
                  <button class="dropdown-item" type="button">
                    Reclamações
                  </button>
                </div>
              </div>
            </div>
            <button id="select-action" class="btn btn-secondary">Gerar relatório</button>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script
  </body>
</html>
