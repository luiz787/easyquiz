<%-- 
    Document   : cadastro
    Created on : 16/07/2017, 20:02:46
    Author     : Luiz
--%>

<%@page import="model.domain.Disciplina"%>
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
                Questao questao = new Questao();
                String enunciado = request.getParameter("enunciado");
                System.out.println(enunciado);
                String tipo = request.getParameter("tipo");
                System.out.println(tipo);
                String dificuldade = request.getParameter("dificuldade");
                System.out.println(dificuldade);
                String disciplina = request.getParameter("disciplina");
                System.out.println(disciplina);/*
                List<Dificuldade> listDificuldade = (List<Dificuldade>) request.getAttribute("listDificuldade");
                for (int i=0; i<listDificuldade.size(); i++){
                    if (dificuldade.equals(listDificuldade.get(i).getDescricao())){
                        questao.setDificuldade(listDificuldade.get(i));
                    }
                }
                List<Disciplina> listDisciplina = (List<Disciplina>) request.getAttribute("listDisciplina");
                for (int i=0; i<listDisciplina.size(); i++){
                    if (disciplina.equals(listDisciplina.get(i).getNome())){
                        questao.setDisciplina(listDisciplina.get(i));
                    }
                }*/
                
                questao.setTxtEnunciado(enunciado);
                if (tipo.equals("aberta")){
                    questao.setIdTipo('A');
                    String resposta = request.getParameter("txtresposta");
                    questao.setTxtResposta(resposta);
                    System.out.println(resposta);
                } else if (tipo.equals("fechada")){
                    questao.setIdTipo('F');
                    String[] alternativas = new String[4];
                    for (int i=0; i<alternativas.length; i++){
                        alternativas[i] = request.getParameter("alt"+i);
                        System.out.println(alternativas[i]);
                    }
                    int seqCorreta = Integer.parseInt(request.getParameter("group1"))+1;
                    questao.setSeqQuestaoCorreta(new Long(seqCorreta));
                    System.out.println(seqCorreta);
                }
                /*TODO: carregar listas de dificuldade, disciplina e modulo
                comparar a entrada com elementos da lista
                setar
                chamar o servico para persistir a questao*/
        %>    
        <h3>Questão cadastrada com sucesso!</h3>
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
