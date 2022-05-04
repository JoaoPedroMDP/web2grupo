<%-- Document : user Created on : Mar 3, 2022, 8:44:00 PM Author : joao --%>
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

    <link href="../css/global.css" rel="stylesheet" />

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
    <!-- Core theme JS-->
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
        <div class="page-title-wrapper">
          <h1 class="page-title">USUÁRIO</h1>
        </div>
        <div class="container d-flex justify-content-center main-content">
            
            <form class="form">
                <div class="form-group row">
                  <label for="inputLogin" class="col-sm-2 col-form-label">Login</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="" id="inputLogin">
                  </div>
                </div>
                <div class="form-group row">
                  <label for="inputPassword" class="col-sm-2 col-form-label">Senha</label>
                  <div class="col-sm-10">
                    <input type="password" class="form-control" placeholder="" id="inputPassword">
                  </div>
                </div>
                <div class="form-group row">
                    <label for="inputName" class="col-sm-2 col-form-label">Nome completo</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputName">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputEmail">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputCpf" class="col-sm-2 col-form-label">Cpf</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputCpf">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputAddress" class="col-sm-2 col-form-label">Endereço</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputAddress">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputDistrict" class="col-sm-2 col-form-label">Bairro</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputDistrict">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputCity" class="col-sm-2 col-form-label">Cidade</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputCity">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputState" class="col-sm-2 col-form-label">Estado</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputState">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputTelephone" class="col-sm-2 col-form-label">Telefone</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputTelephone">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="inputCep" class="col-sm-2 col-form-label">CEP</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" placeholder="" id="inputCep">
                    </div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary mb-2">Cancelar</button>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary mb-2">Salvar</button>
                    </div>
                </div>
        </div>
      </div>
    </div>
  </body>
</html>
