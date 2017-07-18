<%@page import="java.time.ZoneId"%>
<%@page import="model.serviceimpl.ManterUsuarioImpl"%>
<%@page import="model.daoimpl.UsuarioDAOImpl"%>
<%@page import="model.daoimpl.UsuarioDAOImpl"%>
<%@page import="model.service.ManterUsuario"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.Instant"%>
<%@page import="model.domain.Usuario"%>
<%@page import="model.daoimpl.PostDAOImpl"%>
<%@page import="model.serviceimpl.ManterPostImpl"%>
<%@page import="model.service.ManterPost"%>
<%@page import="model.serviceimpl.ManterQuestaoImpl"%>
<%@page import="model.daoimpl.QuestaoDAOImpl"%>
<%@page import="model.service.ManterQuestao"%>
<%@page import="model.domain.Post"%>
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
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">  
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>  
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>  
        <script type="text/javascript">

            $(document).ready(function () {
                $('select').material_select();
            });

        </script>
        <script type="text/javascript">

            function escondeDiv(codigoPost) {
                document.getElementById(codigoPost).style.display = "none";
            }

            function exibeFormResposta(codigoPost) {
                if (document.getElementById(codigoPost).style.display === "block") {
                    document.getElementById(codigoPost).style.display = "none";
                } else {
                    document.getElementById(codigoPost).style.display = "block";
                }
            }

        </script>

    </head>

    <body>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>  
        <script type="text/javascript" src="js/materialize.min.js"></script>  
        <jsp:include page ="Menu.jsp"/>
        <!--- Javascrip -->
        <script type="text/javascript">

            $(document).ready(function () {
                $('select').material_select();
            });


            function mostrarform() {
                var element = document.getElementById("pesquisa");
                if (element.style.display == "none") {
                    element.style.display = "block";
                } else {
                    element.style.display = "none";
                }
            }

        </script>

        <%
            Long cod_Questao = (Long) request.getAttribute("cod_Questao");
            ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
            Questao questao = manterQuestao.getQuestaoById(cod_Questao);
            
            String questaoStr = request.getParameter("questao");
            Long code = Long.parseLong(questaoStr);
        %>

        <H4 style="color: #47525E; padding-left: 5%;">Fórum</H4>
        <div class="container" style="padding-left: 8%; padding-right: 8%">
            <div class="container #f4511e deep-orange darken-1 white-text">
                <p><H8 style="color: #000000; display: inline; padding-left: 7%">  Disciplina: </H8> <H8><text style="color: #fbe9e7; display: inline;" name="Disciplina"/><%= questao.getDisciplina().getNome()%></H8>
                <H8 style="color: #000000; display: inline; padding-left: 25%;">Dificuldade: </H8><H8><text name="Dificuldade" style="color: #fbe9e7; display: inline;"/><%= questao.getDificuldade().getDescricao()%></H8>
                <H8 style="color: #000000; display: inline; padding-left: 25%">Módulo: </H8><H8><text name="Módulo" style="color: #fbe9e7; display: inline;"/><%= questao.getModulo().getNome()%></H8>
            </div>


            <div class="container">
                <p><H8><text name="Enunciado"/><%= questao.getTxtEnunciado()%></H8>
                <br>
                <%
                    if (questao.getImgEnunciado() != null) {
                %>
                <div class="card-image">
                    <center>
                        <img id='imagem<%= questao.getId()%>' class="responsive-img" src="/EasyQuiz/servletweb?acao=CarregaImagem&questao=<%= questao.getId()%>">
                    </center>
                </div>
                <%
                    }
                %>
                <br>
            </div>

            <div class="container">
                <p><h8 class="deep-orange-text text-deep-orange"><b>Resposta correta: </b></h8>
                    <% 
                                        if (questao.getIdTipo() == 'F') {
                                            char letra='a';
                                        
                    %>             
                <h8>
                    <b>
                        <text name="RespostaCorretaFechada"/><%= (char) (letra + questao.getSeqQuestaoCorreta()-1)%>
                    </b>
                </h8>
                <% } else if (questao.getIdTipo() == 'A') {%>
                <h8><b><text name="RespostaCorretaAberta"/><%= questao.getTxtResposta()%></b></h8>
                        <% } %>
                <br>
                <br>
                <hr>
            </div>

            <br>

            <div class="container">

                <%
                    ManterPost manterPost = new ManterPostImpl(PostDAOImpl.getInstance());
                    List<Post> listPost = (List<Post>) manterPost.getAllByQuestao(cod_Questao);
                    if (listPost.size() != 0) {
                        for (int i = 0; i < listPost.size(); i++) {
                            Post post = listPost.get(i);
                            Usuario usuario = post.getAutor();
                            Long cod = post.getCodigo();
                %>

                <h5 style="color: #C55353" href="" name="nomeUsuario"><%=usuario.getNome()%></h5>
                <h8 style="color: #696969" name="dataPost"> em <%= post.getDatCriacao().atZone(ZoneId.of("GMT-3"))%></h8>
                <br>
                <p>
                    <% String[] com = post.getTxtConteudo().split("//");
                        if (com.length == 1) {
                    %>
                <p id="comentarioOriginal" ><% out.print(com[0]); %></p>
                <% } else { %>
                <div class="card-panel red lighten-2">
                    <div>
                    <i><p class="white-text" id="comentarioOriginal" ><% out.print(com[0]); %></p></i>
                    </div>
                </div>
                <p id="comentarioResposta" ><% out.print(com[1]);%></p>
                <% }%>
                <br> 

                <div align="right">

                    <br>

                    <a id="btnResponder" class="btn waves-effect waves-light" type="submit" name="action" 
                       onclick="exibeFormResposta(<%= post.getCodigo()%>);">Responder<i class="material-icons right">send</i></a></li>

                    <form action="servletweb">
                        <div id="<%= post.getCodigo()%>" style="display:none">        

                            <div class="input-field col s12">
                                <input type="hidden" name="CodQuestaoPostResposta" value="<%= questao.getId() %>"/>
                                <input type="hidden" name="CodigoPostOriginal" value="<%= cod %>" />
                                <input type="text" name="ComentarioResposta" class="materialize-textarea"/>
                                <label for="ComentarioResposta">Insira aqui sua resposta:</label>
                            </div>
                            <button class="btn waves-effect waves-light" type="submit" name="acao" value="GravarPostResposta" 
                                    onclick="escondeDiv(<%= post.getCodigo() + "resposta"%>), Materialize.toast('Comentário enviado com sucesso!', 4000);">
                                Enviar <i class="material-icons right">send</i></button>
                        </div>
                    </form>
                    <br>
                    <br>
                    <hr>
                </div>

                <br>

                <%
                    }
                } else {
                %>  

                <div class="container" align="center">
                    <h5>Não há nenhum comentário sobre essa questão ainda. Seja o primeiro!</h5>
                    <br>
                </div>

                <% }%>

            </div>

            <br>

            <H5 style="color: #47525E; padding-left: 180px;">Participe da discussão!</H5>

            <div class="container">
                <form class="col s12" action="servletweb">
                    <div class="row">
                        <div class="input-field col s12">
                            <input type="hidden" name="CodQuestaoPostAvulso" value="<%= questao.getId() %>"/>
                            <input type="text" name="Comentario" class="materialize-textarea"/>
                            <label for="Comentario">Insira aqui seu comentário:</label>

                        </div>
                    </div>

                    <br>
                    <div align="right">
                        <button class="btn waves-effect waves-light"  type="submit" name="acao" value="GravarPostAvulso" onclick="Materialize.toast('Comentário enviado com sucesso!', 4000)">Enviar
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <br>
        <br>

        <jsp:include page ="Footer.jsp"/>
        <!--  Scripts-->

        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="../js/materialize.js"></script>
        <script src="../js/init.js"></script>

    </body>
</html>