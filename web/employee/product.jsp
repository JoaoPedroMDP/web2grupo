<%-- Document : category Created on : Mar 3, 2022, 8:43:05 PM Author : joao --%>
<%@page import="utils.frontHelpers.ClickableItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <link href="<c:out value="${pageContext.request.contextPath}"/>/css/global.css" rel="stylesheet" />
        <link href="<c:out value="${pageContext.request.contextPath}"/>/css/report.css" rel="stylesheet" />

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:out value="${pageContext.request.contextPath}"/>/css/styles.css" rel="stylesheet" />
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="<c:out value="${pageContext.request.contextPath}"/>/js/scripts.js"></script>
    </head>
    <body>
        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <%
                ClickableItem lateral_items[] = {
                    new ClickableItem("Perfil", "profile.jsp"),
                    new ClickableItem("Atendimentos", "TicketServlet?action=listTickets"),
                    new ClickableItem("Categorias", "CategoryServlet?action=list"),
                    new ClickableItem("Produtos", "/ProductsServlet?action=list")
                };
                pageContext.setAttribute("lateral_items", lateral_items);
            %>
            <%@ include file="/WEB-INF/jspf/lateralMenu.jspf" %>

            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <%@ include file="/WEB-INF/jspf/navbar.jspf" %>

                <!-- Page content (Conteúdo da página)-->
                <div class="container-fluid">

                    <!-- Conteúdo da Página -->
                    <div class="page-title-wrapper">
                        <h1 class="page-title"><c:choose><c:when test="${requestScope.action == 'new'}">Adicionar Produto</c:when><c:when test="${requestScope.action == 'update'}">Editar Produto</c:when></c:choose> </h1>
                            </div>
                            <div style="display:flex; justify-content: center; align-items: center;">
                                <div class="text-center mt-5" >   
                                    <div style="display:flex; justify-content: center; flex-direction: column; align-items: center">
                                            <form class="row g-3" name="form" action="ProductServlet?id=${idUpdate}&action=${requestScope.action}" method="POST">
                                    <div class="row mb-4">
                                        <div class="col">
                                            <div class="col-md">
                                                <label for="Nome" class="form-label">Nome</label>
                                                <input name="id" type="hidden" value="<c:out value="${changes.id}"/>">
                                                <input name="name" type="text" class="form-control" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${changes.name}"/></c:if>" required>
                                                </div>
                                                <div class="col-md">
                                                    <label for="Nome" class="form-label">Link da Imagem</label>
                                                    <input name="img" type="text" class="form-control" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${changes.image}"/></c:if>" required>
                                                </div>
                                                <div class="col-md">
                                                    <label for="Nome" class="form-label">Peso</label>
                                                    <input name="weight" type="text" class="form-control" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${changes.weight}"/></c:if>" required>
                                                </div>
                                                <div class="col-md">
                                                    <label for="Nome" class="form-label">Categoria</label>
                                                    <input name="category" type="text" class="form-control" value="<c:if test="${requestScope.action == 'update'}"><c:out value="${category.name}"/></c:if>" required>
                                                </div>
                                            </div>  
                                        </div>
                                    <c:if test="${requestScope.action == 'update'}">
                                        <div class="col-12">
                                            <input class="btn btn-dark" type="submit" value="Alterar">
                                        </div>
                                    </c:if>
                                    <c:if test="${requestScope.action == 'new'}">
                                        <div class="col-12">
                                            <input class="btn btn-dark" type="submit" value="Criar">

                                        </div>
                                    </c:if>

                                </form>

                                <c:if test="${!empty msg}">
                        <div class="mt-3" style="display:flex; justify-content: center; flex-direction: column; align-items: center">
                            <p>
                                <c:out value="${requestScope.msg}"/>
                            </p>
                        </div>
                    </c:if>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
