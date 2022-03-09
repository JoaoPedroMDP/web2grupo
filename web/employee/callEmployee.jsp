<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Atendimento</title>

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />

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
                    <a class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom" href="profile.jsp">Perfil</a>
                    <a class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom" href="callListEmployee.jsp">Atendimentos</a>
                    <a class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom" href="category.jsp">Categorias</a>
                    <a class="list-group-item list-group-item-action list-group-item-light-personalized p-3 border-bottom" href="product.jsp">Produtos</a>
                  </div>

                <div class="sidebar-footer sidebar-personalized" style="text-align: justify;">
                    <a class="list-group-item-light-personalized-2" href="#!">BEIBE - Beauty Embuste Indústria de Beleza
                        e Estética Rua do Embuste, nº 1212 Curitiba-PR, CEP 12122-123 Tel.: (41) 91212-1212</a>
                </div>
            </div>

            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn" id="sidebarToggle"><span class="material-icons">reorder</span></button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation"><span
                                class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item"><a class="nav-link" href="#!">[User]</a></li>
                                <li class="nav-item"><a class="nav-link" href="#!"><span
                                            class="material-icons">logout</span></a></li>
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
                                    <div class="mb-3 col-md-7">
                                        <p class="fst-italic fs-3"><strong>Título:</strong> Caíram todos os meus cabelos
                                        </p>
                                    </div>
                                    <div class="mb-3 col-md-7">
                                        <p class="fst-italic fs-3"><strong>Produto:</strong> Shampoo Embuste
                                        </p>
                                    </div>
                                    <div class="mb-3 col-md-7">
                                        <p class="fst-italic fs-3"><strong>Cliente:</strong> Beltrano dos Santos
                                        </p>
                                    </div>
                                    <div class="mb-3 col-md-7">
                                        <p class="fst-italic fs-3"><strong>Tipo:</strong> Reclamação
                                        </p>
                                    </div>
                                    <div class="p-3 mb-2 bg-secondary rounded bg-opacity-25">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec tincidunt tempor tellus eu tristique. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a placerat massa, vitae finibus neque. Fusce interdum placerat urna, sit amet fringilla quam. Sed porttitor at leo et convallis. Fusce sodales quam in dui vehicula consectetur. Duis tempus nulla vel eros luctus, id accumsan nunc suscipit. Donec aliquet magna cursus finibus feugiat. Ut viverra volutpat ipsum, interdum tempor nisi ultricies a. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
                                    </div>
                                    <form action="" method="post">
                                        <div class="mb-3 col-md-12">
                                            <label class="form-label" for="resposta">Resposta:</label>
                                            <textarea class="form-control"
                                                id="resposta" rows="3" placeholder="Escrever Resposta"></textarea>
                                        </div>
                                        
                                        <div class="d-grid gap-2 d-md-flex">
                                            <a href="callListEmployee.jsp"
                                                class="btn btn-secondary d-flex align-items-center justify-content-center p-1 col-md-2"
                                                id="justify-content-start">
                                                <span class="material-icons m-sm-1">close</span>Voltar</a>
                                            <a href="callListEmployee.jsp"
                                                class="btn btn-success d-flex align-items-center justify-content-center p-1 col-md-2"
                                                id="justify-content-end">
                                                <span class="material-icons m-sm-1">post_add</span>Enviar</a>
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