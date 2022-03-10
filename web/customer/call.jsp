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
    <title>Atendimentos</title>

    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
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
            href="callList.jsp"
            >Atendimentos</a
          >
          <a
            class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom"
            href="call.jsp"
            >Novo Atendimento</a
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
          <div class="row">
            <div class="col-10 offset-1">
              <div class="card">
                <div class="card-header">
                  <h2 class="m-0 text-center">Atendimento Nº XXXXXXX</h2>
                </div>

                <div class="card-body">
                  <form action="" method="post">
                    <div class="mb-3 col-md-7">
                      <label class="form-label" for="motivo">Motivo:</label>
                      <input type="text" name="motivo" class="form-control" />
                    </div>
                    <div class="mb-3 col-md-3">
                      <label class="form-label" for="produto">Produto:</label>
                      <input type="text" name="produto" class="form-control" />
                    </div>
                    <div class="mb-3 col-md-12">
                      <label class="form-label" for="descricao"
                        >Descrição do problema:</label
                      >
                      <textarea
                        class="form-control"
                        id="descricao"
                        rows="3"
                      ></textarea>
                    </div>
                    <div class="mb-3 col-md-12">
                      <label class="form-label" for="resposta">Resposta:</label>
                      <textarea
                        class="form-control"
                        placeholder="Campo não permitido"
                        id="resposta"
                        rows="3"
                        disabled="true"
                      ></textarea>
                    </div>
                    <div class="mb-3 col-md-3">
                      <br />
                      <label class="form-label" for="resposta"
                        >Nota do atendimento:</label
                      >
                      <select
                        class="form-select"
                        aria-label="Default select example"
                      >
                        <option selected>
                          Selecione a nota do atendimento
                        </option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                      </select>
                      <br />
                    </div>
                    <div class="d-grid gap-2 d-md-flex">
                      <a
                        href="callList.jsp"
                        class="btn btn-danger d-flex align-items-center justify-content-center p-1 col-md-2"
                        id="justify-content-start"
                      >
                        <span class="material-icons m-sm-1">close</span
                        >Cancelar</a
                      >
                      <a
                        href="callList.jsp"
                        class="btn btn-primary d-flex align-items-center justify-content-center p-1 col-md-2"
                        id="justify-content-end"
                      >
                        <span class="material-icons m-sm-1">post_add</span
                        >Cadastrar Atendimento</a
                      >
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
