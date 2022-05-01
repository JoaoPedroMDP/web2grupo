<%-- 
    Document   : componentsTesting
    Created on : Apr 27, 2022, 12:31:10 PM
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.frontHelpers.ClickableItem"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/WEB-INF/jspf/pageHead.jspf"%>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ClickableItem lateral_items[] = {
                new ClickableItem("Usuários", "admin/userList.jsp"),
                new ClickableItem("Produtos", "products.jsp"),
                new ClickableItem("Atendimentos", "tickets.jsp")
            };

            pageContext.setAttribute("lateral_items", lateral_items);
        %>
        <%@ include file="/WEB-INF/jspf/lateralMenu.jspf"%>
    </body>
</html>
