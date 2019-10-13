<%-- 
    Document   : JspForward
    Created on : 08/10/2019, 21:54:52
    Author     : joao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:forward page="LoginServlet">
            <jsp:param name="usuario" value="<%= request.getParameter("usuario") %>" />
            <jsp:param name="senha" value="<%= request.getParameter("senha") %>" />
        </jsp:forward>
    </body>
</html>
