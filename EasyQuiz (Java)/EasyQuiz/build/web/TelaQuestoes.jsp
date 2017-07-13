<%@page import="model.domain.Perfil"%>
<%@page import="model.domain.Usuario"%>
<%@page import="model.service.ManterPerfil"%>
<%@page import="model.serviceimpl.ManterPerfilImpl"%>
<%@page import="model.daoimpl.PerfilDAOImpl"%>
<%@page import="model.serviceimpl.ManterUsuarioImpl"%>
<%@page import="model.service.ManterUsuario"%>
<%@page import="model.service.ManterUsuario"%>
<%@page import="model.daoimpl.UsuarioDAOImpl"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.time.Instant"%>
<%@page import="controller.Login"%>
<%@page import="model.domain.QuestaoFechada"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="model.domain.Questao"%>
<%@page import="java.util.List"%>
<%@page import="controller.ListarQuestao"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    /*
    ManterPerfil manterPerfil = new ManterPerfilImpl(PerfilDAOImpl.getInstance());
    Perfil perfil = manterPerfil.getPerfilById(new Long(2));
    ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
    Usuario usuario = new Usuario();
    usuario.setDat_Nascimento(java.sql.Date.valueOf("2017-07-09"));
    usuario.setNom_Usuario("Victor Gabriel");
    usuario.setPerfil(perfil);
    usuario.setTxt_Email("andromenus@gmail.com");
    usuario.setTxt_Senha("123");
    manterUsuario.cadastrarUsuario(usuario);
    */
    /*
    if(request.getSession().getAttribute("cod_Usuario")==null) {
        Login.execute(request);
    }
    */
    int logado = Login.validarSessao(request, response);
    int contadorRespostaQuestao = (Integer) request.getSession().getAttribute("contadorRespostaQuestao");
%>


<%
    if(request.getSession().getAttribute("numeroPagina")==null) {
        request.getSession().setAttribute("numeroPagina", 0);
    }
    int numeroPagina = (Integer) request.getSession().getAttribute("numeroPagina");
    int maxQuestao = 0;
    boolean showBotaoProximaPagina=false;
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>EasyQuiz</title>
        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/materialize.css"/>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <link rel="stylesheet" type="text/css" href="css/styleTelaQuestoes.css"/>
    </head>
    <body>
        <jsp:include page ="Menu.jsp"/>

        <div class="container" >
<%
    if(request.getAttribute("listQuestao")!=null) {
        List<Questao> listQuestao = (List<Questao>) request.getAttribute("listQuestao");
        List<QuestaoFechada> listQuestaoFechada = (List<QuestaoFechada>) request.getAttribute("listQuestaoFechada");
        
        if((listQuestao.size()-(numeroPagina*5))<5) {
            maxQuestao=listQuestao.size();
        } else {
            maxQuestao=((numeroPagina*5)+5);
            showBotaoProximaPagina=true;
        }
        for(int i=(5*numeroPagina); i<maxQuestao; i++) {
            Questao questao = listQuestao.get(i);
            if(questao.getIdTipo()=='F' && listQuestaoFechada!=null) {
                ArrayList<QuestaoFechada> alternativas = new ArrayList();
                Long cod_Questao = questao.getId();
                for (QuestaoFechada object : listQuestaoFechada) {
                    if (object.getQuestao().getId() == cod_Questao) {
                        alternativas.add(object);
                    }
                }
%>
            <div class="row" >
                <div class="col s12 m4" > 
                    <div class="card" >
                        <div class="card-panel #f4511e deep-orange darken-1 white-text">
                            <div>
                                <b style="padding-top: 0px">Disciplina: </b><span id='<%="disciplina"+i%>'><%= questao.getDisciplina().getNome() %></span>
                                <b style="padding-left:50%;padding-top: 0px">Dificuldade: </b><span id='<%="dificuldade"+i%>'><%= questao.getDificuldade().getDescricao() %></span>
                            </div>
                            <div>
                                <span id='<%="modulo"+i%>' style=""><b>Módulo: </b><%= questao.getModulo().getNome() %></span>
                            </div>
                        </div>
                        <div class="card-image">
                            <img id='<%="imagem"+i%>' class="responsive-img" src="img/Geladeira.png">
                        </div>
                        <div class="card-content">
                            <div id='<%="enunciado"+i%>'>
                                <p><b><%= questao.getTxtEnunciado() %></b></p>
                            </div>
                            <div id='<%="alternativas"+i%>'>
                                <form method="post" name='<%="formInserirResposta"+i%>'>
                                    <input type='hidden' name='table' value='QuestaoFechadaResposta'>
                                    <input type='hidden' name='acao' value='gravar'>
                                    <input type='hidden' name='logado' value='<%= logado %>'>
                                    <input type='hidden' name='contadorRespostaQuestao' value='<%= contadorRespostaQuestao %>'>
                                    <input type='hidden' name='questao' value='<%= questao.getId() %>'>
                                    <input type='hidden' name='tipoQuestao' value='<%= questao.getIdTipo() %>'>
                                    <input type='hidden' name='respostaCorreta' value='<%= questao.getSeqQuestaoCorreta() %>'>
                                    <input type='hidden' name='resposta' value=''>
<%
                                    char letra='a';
                                    for(int j=0; j<alternativas.size(); j++) {
                                        
%>
                                    <p>
                                        <input class="with-gap" name='<%="grupo"+i%>' type="radio" id='<%="grupo"+i+"alternativa"+j%>'  />
                                        <label id='<%="grupo"+i+"txtAlternativa"+j%>' for='<%="grupo"+i+"alternativa"+j%>'><b><%=((char)(letra+j))+")"%></b> <%= alternativas.get(j).getTxtAlternativa() %> </label>
                                    </p>
<%
                                    }
%>
                                </form>
                                <br>
                                <h6 id='<%="resultado"+i%>' ></h6>
                            </div>
                        </div>
                        <div class="card-action">
                            <button onclick="Responder(document.<%="formInserirResposta"+i%>)" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important;" id='<%="responder"+i%>'>Responder</button>
                            <a id='<%="forum"+i%>' href="#"><b>Forum</b></a>
                        </div>
                    </div>
                </div>
            </div>
<%
            } else if(questao.getIdTipo()=='A') {
%>
            <div class="row">
                <div class="col s12 m4">
                    <div class="card">
                        <div class="card-panel #f4511e deep-orange darken-1 white-text">
                            <div style="">
                                <b style="padding-top: 0px">Disciplina: </b><span id='<%="disciplina"+i%>'><%= questao.getDisciplina().getNome() %></span>
                                <b style="padding-left:50%;padding-top: 0px">Dificuldade: </b><span id='<%="dificuldade"+i%>'><%= questao.getDificuldade().getDescricao() %></span>
                            </div>
                            <div>
                                <span id='<%="modulo"+i%>' style=""><b>Módulo: </b><%= questao.getModulo().getNome() %></span>
                            </div>
                        </div>
                        <!--
                        <div class="card-image">
                            <img id="imagem2" class="responsive-img" src="">
                        </div>
                        -->
                        <div class="card-content">
                            <div id='<%="enunciado"+i%>'>
                                <p><b><%= questao.getTxtEnunciado() %></b></p>
                            </div>
                            <div id='<%="respostaAberta"+i%>'>
                                <form method="post" name='<%="formInserirResposta"+i%>'>
                                    <input type='hidden' name='table' value='QuestaoAbertaResposta'>
                                    <input type='hidden' name='logado' value='<%= logado %>'>
                                    <input type='hidden' name='contadorRespostaQuestao' value='<%= contadorRespostaQuestao %>'>
                                    <input type='hidden' name='questao' value='<%= questao.getId() %>'>
                                    <input type='hidden' name='tipoQuestao' value='<%= questao.getIdTipo() %>'>
                                    <input type='hidden' name='respostaBase' value='<%= questao.getTxtResposta() %>'>
                                    <input type='hidden' name='resposta' value=''>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <textarea id='<%="textArea"+i%>' class="materialize-textarea"></textarea>
                                            <label for='<%="textArea"+i%>'>Resposta:</label>
                                        </div>
                                    </div>
                                    <div id='<%="respostaBase"+i%>' class="row">
                                        
                                    </div>
                                    
                                </form>
                            </div>
                        </div>

                        <div class="card-action">
                            <button onclick="Responder(document.<%="formInserirResposta"+i%>)" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important;" id='<%="responder"+i%>'>Responder</button>
                            <a id='<%="forum"+i%>' href="#"><b>Forum</b></a>
                        </div>

                    </div>
                </div>
            </div>
<%
            }
        }
    } else {
%>
<h2 style="text-align: center;"><b> Não há questões cadastradas!</b></h2>
<%
        for(int i=0; i<20; i++) {
%>
<br>
<%
        }
    }
%>  
        </div>
        <div>
        <h6 style="text-align: center;">Página: <%=(numeroPagina+1)%></h6>
        <form name="formPagina" action='post'>
            <input type='hidden' name='acao' value=''>
            <input type='hidden' name='numeroPagina' value='<%=(numeroPagina+1)%>'>
            <input type='hidden' name='maxQuestao' value='<%=maxQuestao%>'>
            <div class="card-action">
            <%
                if(showBotaoProximaPagina) {
            %>
            
            <button onclick="proximaPagina(document.formPagina)" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important; " id="Próxima">Próxima Página</button>
            
            <%
                }
                if(numeroPagina>0) {
            %>
            <button onclick="paginaAnterior(document.formPagina)" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important; " id="Anterior">Página Anterior</button>
            
            <%
                }
            %>
            </div>
        </form>
        </div>
        <br>
        <br>
        
        
        <jsp:include page ="Footer.jsp"/>
        
        <!--Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/materialize.js"></script>
        <script type="text/javascript" language="JavaScript" src="js/init.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('select').material_select();
            });
            function mostrarform() {
                var element = document.getElementById("pesquisa");
                if (element.style.display =="none") {element.style.display = "block";} else {element.style.display = "none";}
            }
        </script>
    </body>
</html>

