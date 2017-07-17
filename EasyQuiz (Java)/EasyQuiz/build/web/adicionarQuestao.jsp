<%-- 
    Document   : adicionarQuestao
    Created on : 16/07/2017, 13:33:05
    Author     : Luiz
--%>

<%@page import="controller.Login"%>
<%@page import="model.domain.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int logado = Login.validarSessao(request, response);
%>

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
        <script type="text/javascript">
            function mostrarform() {
                var element = document.getElementById("pesquisa");
                if (element.style.display == "none") {
                    element.style.display = "block";
                } else {
                    element.style.display = "none";
                }
            }
        </script>

        <!-- nav cor #EE6363 -->
        <jsp:include page ="Menu.jsp"/>
        <%
            if (logado != 0) {
                System.out.println(request.getAttribute("listDificuldade"));
        %>        


        <div class="container" style=" z-index: 1">
            <form name="cadastro" id="cadastro" method="GET" action="Cadastro.jsp">
                <input type="hidden" name="acao" value="Cadastro" />
                <div>
                    <h3>Cadastrar questão</h3>
                    Tipo da questão:
                    <p>
                        <input class="with-gap" name="tipo" type="radio" id="tipoAberta" value="aberta" onclick="questaoAberta()"/>
                        <label for="tipoAberta">Aberta</label>
                    </p>
                    <p>
                        <input class="with-gap" name="tipo" type="radio" id="tipoFechada" value="fechada" checked="checked" onclick="window.location.reload()"/>
                        <label for="tipoFechada">Fechada</label>
                    </p>
                </div>
                <div id="dados">
                    <div class="input-field">
                        <select id="disciplina" name="disciplina">
                            <option value="" disabled selected>Escolha a disciplina</option>
                            <option value="Física">Física</option>
                            <option value="Matemática">Matemática</option>
                            <option value="Sistemas Operacionais">Sistemas Operacionais</option>
                        </select>
                        <label>Disciplina</label>
                    </div>
                    <div class="input-field">
                        <select id="modulo" name="modulo">
                            <option value="" disabled selected>Escolha o módulo</option>
                            <option value="Máquinas térmicas">Máquinas térmicas</option>
                            <option value="Óptica">Óptica</option>
                            <option value="Termodinâmica">Termodinâmica</option>
                        </select>
                        <label>Módulo</label>
                    </div>
                    <div class="input-field">
                        <select id="dificuldade" name="dificuldade">
                            <option value="" disabled selected>Escolha a dificuldade</option>
                            <option value="Fácil">Fácil</option>
                            <option value="Médio">Médio</option>
                            <option value="Difícil">Difícil</option>
                            <option value="Desafio">Desafio</option>
                        </select>
                        <label>Módulo</label>
                    </div>
                </div>
                <div id="divEnunciado">
                    <h5>Enunciado</h5>
                    <div class="row">
                        <div class="input-field col s12">
                            <textarea name="enunciado" id="enunciado" class="materialize-textarea"></textarea>
                            <label for="enunciado">Enunciado</label>
                        </div>
                    </div>
                </div>
                <div id="divAlternativas">
                    <h5>Alternativas</h5>
                    <div class="row">
                        <div class="input-field col s2">
                            <input class="with-gap" name="group1" type="radio" id="test1" value="0" />
                            <label for="test1">Correta</label>
                        </div>
                        <div class="input-field col s7">
                            <textarea name="alt0" id="alt0" class="materialize-textarea"></textarea>
                            <label for="textarea1">Alternativa</label>
                        </div>
                        <div class="col s3">
                            <a class="waves-effect waves-light btn deep-orange darken-1 disabled" onclick="excluirAlternativa(this)"><i class="material-icons left">delete</i>Excluir</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s2">
                            <input class="with-gap" name="group1" type="radio" id="test2" value="1"/>
                            <label for="test2">Correta</label>
                        </div>
                        <div class="input-field col s7">
                            <textarea name="alt1" id="alt1" class="materialize-textarea"></textarea>
                            <label for="textarea1">Alternativa</label>
                        </div>
                        <div class="col s3">
                            <a class="waves-effect waves-light btn deep-orange darken-1 disabled" onclick="excluirAlternativa(this)"><i class="material-icons left">delete</i>Excluir</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s2">
                            <input class="with-gap" name="group1" type="radio" id="test3" value="2"/>
                            <label for="test3">Correta</label>
                        </div>
                        <div class="input-field col s7">
                            <textarea name="alt2" id="alt2" class="materialize-textarea"></textarea>
                            <label for="textarea1">Alternativa</label>
                        </div>
                        <div class="col s3">
                            <a class="waves-effect waves-light btn deep-orange darken-1 disabled" onclick="excluirAlternativa(this)"><i class="material-icons left">delete</i>Excluir</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s2">
                            <input class="with-gap" name="group1" type="radio" id="test4" value="3"/>
                            <label for="test4">Correta</label>
                        </div>
                        <div class="input-field col s7">
                            <textarea name="alt3" id="alt3" class="materialize-textarea disabled"></textarea>
                            <label for="textarea1">Alternativa</label>
                        </div>
                        <div class="col s3">
                            <a class="waves-effect waves-light btn deep-orange darken-1 disabled" onclick="excluirAlternativa(this)"><i class="material-icons left">delete</i>Excluir</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col s12">
                            <a class="waves-effect waves-light btn deep-orange darken-1 disabled" onclick="addAlternativa(this)"><i class="material-icons left">add</i>Adicionar alternativa</a>
                        </div>
                    </div>
                </div>
                <div class="row" id="linhafinal">
                    <div class="col s6">
                        <button class="btn waves-effect waves-light deep-orange darken-1" type="button" onclick="AdicionarQuestao(document.cadastro)" name="actionn">Confirmar
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                    <div class="col s6">
                        <a class="waves-effect waves-light btn deep-orange darken-1" href="gerenciamentoquestoes.html"><i class="material-icons left">cancel</i>Cancelar</a>
                    </div>
                </div>
            </form>
        </div>
        <%
        } else {
        %>
        <div class="container">
            <h4>Funcionalidade exclusiva para professores.</h4>
            <a class="waves-effect waves-light btn deep-orange darken-1" href="index.jsp">Voltar</a>
        </div>
        <%
            }
        %>    
        <br><br>
        <jsp:include page ="Footer.jsp"/>
        <!--  Scripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>
        <script src="js/addQuestao.js"></script>
        <script src="js/webvalida.js"></script>
        <script type="text/javascript">
                                            $(document).ready(function () {
                                                $('select').material_select();
                                            });
        </script>
    </body>
</html>
