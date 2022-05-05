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
        <title>Categorias</title>

        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/icon?family=Material+Icons"
            />

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
                    <div class="page-title-wrapper">
                        <h1 class="page-title">CATEGORIAS</h1>
                    </div>
                    <!-- Conteúdo da Página -->
                    <div style="display:flex; justify-content: center; flex-direction: column; align-items: center">
                        <%@ include file="/WEB-INF/jspf/tableComponent/table.jspf" %>
                        <form style="padding:30px" action="CategoryServlet?action=formNew" name="novo" method="POST">
                            <input class="btn btn-dark" type="submit" value="Adicionar Categoria">
                        </form>
                        <form action="../home.jsp" method="POST">
                            <input class="btn btn-dark" type="submit" value="Voltar">
                        </form>
                    </div>
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
    </body>
</html>
