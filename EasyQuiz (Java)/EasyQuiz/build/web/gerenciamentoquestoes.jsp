<%-- 
    Document   : gerenciamentoquestoes
    Created on : 16/07/2017, 14:14:42
    Author     : Luiz
--%>

<%@page import="controller.Login"%>
<%@page import="model.domain.QuestaoFechadaResposta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.domain.QuestaoFechada"%>
<%@page import="model.domain.Questao"%>
<%@page import="java.util.List"%>
<%
    int logado = Login.validarSessao(request, response);
%>
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
        <!--- Javascrip -->

        <!-- nav cor #EE6363 -->
        <jsp:include page ="Menu.jsp"/>

        <div class="container">
            <div class="container">
                <h4>Questões cadastradas:</h4>
            </div>
            <div class="row">
                <div class="col s8 m9 l9" id="divQuestoes">
                    <%
                        if (request.getAttribute("listQuestao") != null) {
                            List<Questao> listQuestao = (List<Questao>) request.getAttribute("listQuestao");
                            List<QuestaoFechada> listQuestaoFechada = (List<QuestaoFechada>) request.getAttribute("listQuestaoFechada");
                            List<QuestaoFechadaResposta> listQuestaoFechadaResposta = null;
                            if (request.getAttribute("listQuestaoFechadaResposta") != null) {
                                listQuestaoFechadaResposta
                                        = (List<QuestaoFechadaResposta>) request.getAttribute("listQuestaoFechadaResposta");
                            } else {
                                listQuestaoFechadaResposta
                                        = (List<QuestaoFechadaResposta>) request.getSession().getAttribute("listRespostaNaoLogado");
                            }

                            List<Questao> listQuestaoAbertaResposta = null;
                            if (request.getSession().getAttribute("listTxtRespostaNaoLogado") != null) {
                                listQuestaoAbertaResposta
                                        = (List<Questao>) request.getSession().getAttribute("listTxtRespostaNaoLogado");
                            }
                            for (int i = 0; i < listQuestao.size(); i++) {
                                Questao questao = listQuestao.get(i);
                                Long id = questao.getId();
                    %>
                    <div class="container questao" id='<%=i%>'>	
                        <div class="deep-orange darken-1 white-text cabecalho">
                            <strong><%=questao.getDisciplina().getNome()%></strong> > <%=questao.getModulo().getNome()%>
                        </div>
                        <div class="content-questao">
                            <%
                                if (questao.getImgEnunciado() != null) {
                            %>
                            <div class="container" id='<%="containerImg" + i%>'>
                                <img id='<%="imagem" + i%>' class="responsive-img center" src="/EasyQuiz/servletweb?acao=CarregaImagem&questao=<%= questao.getId()%>">
                            </div>
                            <%
                                }
                            %>
                            <form action="#" id='<%="form" + i%>'>
                                <div>
                                    <div id='<%="enunciado" + i%>'>
                                        <p class="enun"><%=questao.getTxtEnunciado()%></p>
                                    </div>
                                    <%
                                        if (questao.getIdTipo() == 'F' && listQuestaoFechada != null) {
                                            ArrayList<QuestaoFechada> alternativas = new ArrayList();
                                            for (QuestaoFechada object : listQuestaoFechada) {
                                                if (object.getQuestao().getId() == id) {
                                                    alternativas.add(object);
                                                }
                                            }
                                            Long resposta = null;
                                            QuestaoFechadaResposta questaoFechadaResposta;
                                            if (logado == 1) {
                                                questaoFechadaResposta = new QuestaoFechadaResposta();
                                                if (listQuestaoFechadaResposta != null) {
                                                    for (QuestaoFechadaResposta object : listQuestaoFechadaResposta) {
                                                        if (object.getQuestao().getId() == id) {
                                                            questaoFechadaResposta = object;
                                                        }
                                                    }
                                                }
                                                resposta = questaoFechadaResposta.getSeqQuestaoResposta();
                                            } else {
                                                questaoFechadaResposta = new QuestaoFechadaResposta();
                                                if (listQuestaoFechadaResposta != null) {
                                                    for (QuestaoFechadaResposta object : listQuestaoFechadaResposta) {
                                                        if (object.getQuestao().getId() == id) {
                                                            questaoFechadaResposta = object;
                                                        }
                                                    }
                                                }
                                                resposta = questaoFechadaResposta.getSeqQuestaoResposta();
                                            }
                                    %>

                                    <div id='<%="alternativas" + i%>'>
                                        <%
                                            char letra = 'a';
                                            for (int j = 0; j < alternativas.size(); j++) {
                                        %>
                                        <p>
                                            <input class="with-gap" name='<%="grupo" + i%>' type="radio" id='<%="grupo" + i + "alternativa" + j%>'  />
                                            <label for='<%="grupo" + i + "alternativa" + j%>'><b><%=((char) (letra + j)) + ")"%></b><%=alternativas.get(j).getTxtAlternativa()%> </label>
                                        </p>
                                        <%
                                            }
                                        %>
                                    </div>
                                    <%
                                    } else if (questao.getIdTipo() == 'A') {
                                    %>
                                    <div id='<%="resposta-aberta" + i%>'>
                                        <p><%=questao.getTxtResposta()%></p>
                                    </div>
                                    <%
                                        }
                                    %>
                                    <br>
                                    <div class="row">
                                        <div class="col s6" name="divEditar">
                                            <a class="waves-effect waves-light btn deep-orange darken-1" onclick="editarquestao('<%="questao" + i%>', this)"><i class="material-icons left">edit</i>Editar questão</a>
                                        </div>
                                        <div class="col s6" name="divExcluir">
                                            <a class="waves-effect waves-light btn deep-orange darken-1" href="/EasyQuiz/servletweb?acao=ExcluirQuestao&questao=<%= questao.getId()%>"><i class="material-icons left">delete</i>Excluir questão</a>
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>
                    </div>
                    <%
                        }
                    %>

                    <%
                    } else {
                    %>
                    <h2 style="text-align: center;"><b> Não há questões cadastradas!</b></h2>
                    <%
                        for (int i = 0; i < 20; i++) {
                    %>
                    <br>
                    <%
                            }
                        }
                    %>  


                </div>
                <div class="col s4 m3 l3">
                    <a class="waves-effect waves-light btn deep-orange darken-1" href="/EasyQuiz/servletweb?acao=AdicionarQuestao"><i class="material-icons left">add</i>Adicionar questão</a><!-- mudar cor -->
                </div>	
            </div>
        </div>
        <br><br>

        <!--  Scripts-->
        <script src="js/gq.js"></script>
        <jsp:include page ="Footer.jsp"/>
    </body>
</html>
