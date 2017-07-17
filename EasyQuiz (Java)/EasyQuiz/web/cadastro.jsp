<%-- 
    Document   : cadastro
    Created on : 16/07/2017, 20:02:46
    Author     : Luiz
--%>

<%@page import="model.domain.Disciplina"%>
<%@page import="model.domain.Modulo"%>
<%@page import="model.domain.Dificuldade"%>
<%@page import="java.util.List"%>
<%@page import="model.domain.Questao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>EasyQuiz</title>

  <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
	<link rel="stylesheet" href="css/gq.css">

    </head>
    <body>
        <jsp:include page ="Menu.jsp"/>
        
        <%
            if (request!=null){
                
                /*TODO:
                comparar a entrada com elementos da lista
                setar
                chamar o servico para persistir a questao*/
        %>    
        <div class="container"><h3>Questão cadastrada com sucesso! Id da questão: </h3></div>
        <%
            }
        %>
        <jsp:include page ="Footer.jsp"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>
	<script type="text/javascript">
            $(document).ready(function() {
                $('select').material_select();
            });
	</script>
    </body>
</html>
