<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="/WEB-INF/jspf/pageHead.jspf" %>
    <title>Dashboard</title>
  </head>
  <body>
    <div class="d-flex" id="wrapper">
      <%@ include file="/WEB-INF/jspf/adminComponents/lateralMenu.jspf"%>
      <div id="page-content-wrapper">
        <%@ include file="/WEB-INF/jspf/navbar.jspf"%>
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
