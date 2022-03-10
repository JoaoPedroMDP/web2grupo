<%-- Document : userList Created on : Mar 3, 2022, 8:43:49 PM Author : joao --%>
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
    <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />

    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet" />

    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
  </head>
  <body>
    <div class="d-flex" id="wrapper">
      <div class="bg-white" id="sidebar-wrapper">
        <div class="sidebar-heading bg-light">BEIBE</div>
        <div class="list-group list-group-flush">
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="report.jsp"
            >Relatórios</a
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

        <!-- Page content (Conteúdo da página)-->
        <div class="container-fluid">
          <div class="container-fluid">
            <div class="row">
              <div class="col-10 offset-1">
                <h1 style="text-align: center; margin: 20px">Usuários</h1>
                <table class="table table-striped table-bordered">
                  <thead class="table-light text-center">
                    <tr>
                      <th scope="col" class="col-0"></th>
                      <th scope="col" class="col-2">Nome</th>
                      <th scope="col" class="col-6">Cargo</th>
                      <th scope="col" class="col-1">Ação</th>
                    </tr>
                  </thead>
                  <tbody class="align-items-center">
                    <tr class="align-text-bottom">
                      <th scope="row" class="text-center">1</th>
                      <td class="text-center">Fulano da Silva</td>
                      <td>Cliente</td>
                      <td class="text-center">
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-primary btn-sm"
                          ><span class="material-icons m-sm-0">edit</span></a
                        >
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-danger btn-sm"
                          ><span class="material-icons m-sm-0">delete</span></a
                        >
                      </td>
                    </tr>
                    <tr class="align-text-bottom">
                      <th scope="row" class="text-center">2</th>
                      <td class="text-center">Fulano da Silva</td>
                      <td>Cliente</td>
                      <td class="text-center">
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-primary btn-sm"
                          ><span class="material-icons m-sm-0">edit</span></a
                        >
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-danger btn-sm"
                          ><span class="material-icons m-sm-0">delete</span></a
                        >
                      </td>
                    </tr>
                    <tr class="align-text-bottom">
                      <th scope="row" class="text-center">3</th>
                      <td class="text-center">Fulano da Silva</td>
                      <td>Funcionário</td>
                      <td class="col-1 text-center">
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-primary btn-sm"
                          ><span class="material-icons m-sm-0">edit</span></a
                        >
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-danger btn-sm"
                          ><span class="material-icons m-sm-0">delete</span></a
                        >
                        <!--<button type="button" class="btn btn-primary btn-sm"><span class="material-icons m-sm-0">edit</span></button>
                            <button type="button" class="btn btn-danger btn-sm"><span class="material-icons m-sm-0">delete</span></button>-->
                      </td>
                    </tr>
                    <tr class="align-text-bottom">
                      <th scope="row" class="text-center">4</th>
                      <td class="text-center">Fulano da Silva</td>
                      <td>Funcionário</td>
                      <td class="col-1 text-center">
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-primary btn-sm"
                          ><span class="material-icons m-sm-0">edit</span></a
                        >
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-danger btn-sm"
                          ><span class="material-icons m-sm-0">delete</span></a
                        >
                      </td>
                    </tr>
                    <tr class="align-text-bottom">
                      <th scope="row" class="text-center">5</th>
                      <td class="text-center">Fulano da Silva</td>
                      <td>Funcionário</td>
                      <td class="col-1 text-center">
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-primary btn-sm"
                          ><span class="material-icons m-sm-0">edit</span></a
                        >
                        <a
                          href="../customer/profile.jsp"
                          class="btn btn-danger btn-sm"
                          ><span class="material-icons m-sm-0">delete</span></a
                        >
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
