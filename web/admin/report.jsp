<%-- Document : report Created on : Mar 3, 2022, 8:44:11 PM Author : joao --%>

<%-- <%@include file="/WEB-INF/jspf/middlewares/mustBeAdminMiddleware.jspf" %> --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.frontHelpers.ClickableItem"%>

<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/WEB-INF/jspf/pageHead.jspf" %>
    <title>Relatórios</title>
    <script src="../js/admin/report.js"></script>
    <link href="../css/global.css" rel="stylesheet" />
    <link href="../css/admin/report.css" rel="stylesheet" />
  </head>
  <body>
    <div class="d-flex" id="wrapper">
      <%@ include file="/WEB-INF/jspf/adminComponents/lateralMenu.jspf"%>

      <!-- Page content wrapper-->
      <div id="page-content-wrapper">
        <!-- Top navigation-->
        <%@ include file="/WEB-INF/jspf/navbar.jspf"%>

        <div class="page-title-wrapper">
          <h1 class="page-title">RELATÓRIOS</h1>
        </div>
        <div class="container-fluid d-flex justify-content-center">
          <div class="report-box roundy d-flex flex-column">
            <h3 class="box-title">Selecione um relatório</h3>
            <%
              ClickableItem list_group_items[] = {
                  new ClickableItem("Atendimentos", "ReportsServlet?report=tickets"),
                  new ClickableItem("Funcionários", "ReportsServlet?report=employees"),
                  new ClickableItem("Produtos", "ReportsServlet?report=products"),
              };

              pageContext.setAttribute("list_group_items", list_group_items);
            %>
            <%@ include file="/WEB-INF/jspf/listGroup.jspf"%>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script
  </body>
</html>
