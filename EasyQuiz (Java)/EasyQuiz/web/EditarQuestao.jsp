<%-- 
    Document   : EditarQuestao
    Created on : 17/07/2017, 13:54:46
    Author     : Luiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EasyQuiz</title>
    </head>
    <body>
        <jsp:include page ="Menu.jsp"/>
        <div class="container">
            <h4>Questão Editada Com Sucesso!</h4>
            <a class="waves-effect waves-light btn deep-orange darken-1" href="/EasyQuiz/servletweb?acao=GerenciarQuestoes">Voltar</a>
        </div>
        
        <jsp:include page ="Footer.jsp"/>
    </body>
</html>
