<%-- Document : userList Created on : Mar 3, 2022, 8:43:49 PM Author : joao --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.frontHelpers.table.Table"%>
<%@page import="utils.frontHelpers.table.Row"%>
<%@page import="utils.frontHelpers.table.Column"%>
<%@page import="utils.frontHelpers.table.Cell"%>
<%@page import="utils.frontHelpers.table.Action"%>

<!DOCTYPE html>
<html>
  <head>
    <%-- <title>Usuários</title> --%>
    <%@ include file="/WEB-INF/jspf/pageHead.jspf" %>
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

        <%
          Column cols[] = {
            new Column("Primeira"),
            new Column("Segunda"),
            new Column("Terceira"),
          };

          Action actions[] = {
            new Action("Editar", "edit.jsp", false),
            new Action("Excluir", "delete.jsp", true),
          };

          Cell firstRowCells[] = {
            new Cell("1 1", true),
            new Cell("1 2", false),
            new Cell("1 3", false, actions)
          };

          Cell secondRowCells[] = {
            new Cell("2 1", true),
            new Cell("2 2", false),
            new Cell("2 3", false, actions)
          };

          Row rows[] = {
            new Row(firstRowCells),
            new Row(secondRowCells)
          };

          Table table = new Table("Tabela 1", cols, rows);
          pageContext.setAttribute("table", table);
        %>
        <%@ include file="/WEB-INF/jspf/tableComponent/table.jspf" %>

      </div>
    </div>
  </body>
</html>
