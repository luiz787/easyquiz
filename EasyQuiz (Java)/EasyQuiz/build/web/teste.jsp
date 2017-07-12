<%-- 
    Document   : teste
    Created on : 12/07/2017, 01:32:31
    Author     : playc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Nome:<input type="text" size="50" value="<%= request.getAttribute("nome") %>"><br>
        Email:<input type="text" size="50" value="<%= request.getAttribute("email") %>"><br>
        Data:<input type="text" size="50" value="<%= request.getAttribute("data") %>"><br>
        Escolaridade:<input type="text" size="50" value="<%= request.getAttribute("escolaridade") %>"><br>
        Senha:<input type="text" size="50" value="<%= request.getAttribute("senha") %>"><br>
    </body>
</html>
