<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/WEB-INF/jspf/pageHead.jspf" %>
    <title>Atendimentos</title>
  </head>
  <body>
    <div class="d-flex" id="wrapper">
      <%@ include file="/WEB-INF/jspf/adminComponents/lateralMenu.jspf"%>

      <!-- Page content wrapper-->
      <div id="page-content-wrapper">
        <!-- Top navigation-->
        <%@ include file="/WEB-INF/jspf/navbar.jspf"%>

        <!-- Page content (Conteúdo da página)-->
        <div class="container-fluid">
          <div class="row">
            <div class="col-10 offset-1">
              <h1 style="text-align:center;margin:20px;">Atendimentos</h1>
                <%@ include file="/WEB-INF/jspf/tableComponent/table.jspf" %>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
