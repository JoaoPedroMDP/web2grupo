<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.frontHelpers.table.Table"%>
<%@page import="utils.frontHelpers.table.Row"%>
<%@page import="utils.frontHelpers.table.Column"%>
<%@page import="utils.frontHelpers.table.Cell"%>
<%@page import="utils.frontHelpers.table.Action"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/WEB-INF/jspf/pageHead.jspf" %>
    <title>Atendimentos</title>
  </head>
  <body>
    <div class="d-flex" id="wrapper">
      <%@ include file="/WEB-INF/jspf/customerComponents/lateralMenu.jspf"%>

      <!-- Page content wrapper-->
      <div id="page-content-wrapper">
        <!-- Top navigation-->
        <%@ include file="/WEB-INF/jspf/navbar.jspf"%>

        <!-- Page content (Conteúdo da página)-->
        <div class="container-fluid">
          <div class="row">
            <div class="col-10 offset-1">
              <h1 style="text-align:center;margin:20px;">Atendimentos</h1>
                <%-- <%
                  Column cols[] = {
                    new Column(""),
                    new Column("Data de abertura"),
                    new Column("Título"),
                    new Column("Status"),
                    new Column("Avaliação"),
                    new Column("Ações")
                  };

                  Action actions[] = {
                    new Action("Editar", "editCall.jsp", false),
                    new Action("Excluir", "deleteCall.jsp", true),
                    new Action("Visualizar", "viewCall.jsp", true),
                  };

                  Cell firstRowCells[] = {
                    new Cell("1", true),
                    new Cell("06/03/2022 13:15", false),
                    new Cell("Problema com a entrega do produto B-2145", false),
                    new Cell("Pendente", false),
                    new Cell("-", false),
                    new Cell("-", false, actions)
                  };

                  Cell secondRowCells[] = {
                    new Cell("1", true),
                    new Cell("06/03/2022 13:15", false),
                    new Cell("Problema com a entrega do produto B-2145", false),
                    new Cell("Pendente", false),
                    new Cell("8", false),
                    new Cell("-", false, actions)
                  };

                  Row rows[] = {
                    new Row(firstRowCells),
                    new Row(secondRowCells)
                  };

                  Table table = new Table(cols, rows);
                  pageContext.setAttribute("table_items", table);
                %> --%>
                <%@ include file="/WEB-INF/jspf/tableComponent/table.jspf" %>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
