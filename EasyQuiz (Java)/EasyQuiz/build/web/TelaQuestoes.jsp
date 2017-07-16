<%@page import="model.domain.QuestaoFechadaResposta"%>
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
    </head>
    <body>
        <jsp:include page ="Menu.jsp"/>

        <div class="container" >
<%
    if(request.getAttribute("listQuestao")!=null) {
        List<Questao> listQuestao = (List<Questao>) request.getAttribute("listQuestao");
        List<QuestaoFechada> listQuestaoFechada = (List<QuestaoFechada>) request.getAttribute("listQuestaoFechada");
        
        List<QuestaoFechadaResposta> listQuestaoFechadaResposta=null;
        if(request.getAttribute("listQuestaoFechadaResposta")!=null) {
            listQuestaoFechadaResposta = 
                (List<QuestaoFechadaResposta>) request.getAttribute("listQuestaoFechadaResposta");
        } else {
            listQuestaoFechadaResposta = 
                (List<QuestaoFechadaResposta>) request.getSession().getAttribute("listRespostaNaoLogado");
        }
        
        List<Questao> listQuestaoAbertaResposta=null;
        if(request.getSession().getAttribute("listTxtRespostaNaoLogado")!=null) {
            listQuestaoAbertaResposta = 
                    (List<Questao>) request.getSession().getAttribute("listTxtRespostaNaoLogado");
        }
        
        if((listQuestao.size()-(numeroPagina*5))<5) {
            maxQuestao=listQuestao.size();
        } else {
            maxQuestao=((numeroPagina*5)+5);
            showBotaoProximaPagina=true;
        }
        for(int i=(5*numeroPagina); i<maxQuestao; i++) {
            Questao questao = listQuestao.get(i);
            Long cod_Questao = questao.getId();
            if(questao.getIdTipo()=='F' && listQuestaoFechada!=null) {
                ArrayList<QuestaoFechada> alternativas = new ArrayList();
                for (QuestaoFechada object : listQuestaoFechada) {
                    if (object.getQuestao().getId() == cod_Questao) {
                        alternativas.add(object);
                    }
                }
                Long resposta=null;
                QuestaoFechadaResposta questaoFechadaResposta;
                if(logado==1) {
                    questaoFechadaResposta = new QuestaoFechadaResposta();
                    if(listQuestaoFechadaResposta!=null) {
                        for (QuestaoFechadaResposta object : listQuestaoFechadaResposta) {
                            if (object.getQuestao().getId() == cod_Questao) {
                                questaoFechadaResposta = object;
                            }
                        }
                    }
                    resposta = questaoFechadaResposta.getSeqQuestaoResposta();
                } else {
                    questaoFechadaResposta = new QuestaoFechadaResposta();
                    if(listQuestaoFechadaResposta!=null) {
                        for (QuestaoFechadaResposta object : listQuestaoFechadaResposta) {
                            if (object.getQuestao().getId() == cod_Questao) {
                                questaoFechadaResposta = object;
                            }
                        }
                    }
                    resposta = questaoFechadaResposta.getSeqQuestaoResposta();
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
                        <%
                            if(questao.getImgEnunciado()!=null) {
                        %>
                        <div class="card-image">
                            <img id='<%="imagem"+i%>' class="responsive-img" src="/EasyQuiz/servletweb?acao=CarregaImagem&questao=<%= questao.getId()%>">
                        </div>
                        <%
                            }
                        %>
                        <div class="card-content">
                            <div id='<%="enunciado"+i%>'>
                                <p><b><%= questao.getTxtEnunciado() %></b></p>
                            </div>
                            <div id='<%="alternativas"+i%>'>
                                <form method="post" name='<%="formInserirResposta"+i%>'>
                                    <input type='hidden' name='index' value='<%= i %>'>
                                    <input type='hidden' name='table' value='QuestaoFechadaResposta'>
                                    <input type='hidden' name='acao' value='gravar'>
                                    <input type='hidden' name='logado' value='<%= logado %>'>
                                    <input type='hidden' name='contadorRespostaQuestao' value='<%= contadorRespostaQuestao %>'>
                                    <input type='hidden' name='questao' value='<%= questao.getId() %>'>
                                    <input type='hidden' name='tipoQuestao' value='<%= questao.getIdTipo() %>'>
                                    <input type='hidden' name='respostaCorreta' value='<%= questao.getSeqQuestaoCorreta() %>'>
                                    <input type='hidden' name='resposta' id='<%="resposta"+i%>' value='<%= resposta %>'>
                                    
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
                                <script type="text/javascript">
                                        var form = document.getElementsByName('<%="formInserirResposta"+i%>')[0];
                                        var index = form.index.value;
                                        var resposta = document.getElementById("resposta"+index).value;
                                        if(resposta!='null') {
                                            var alternativa = "grupo<%=i%>alternativa"+(resposta-1);
                                            var radioAlternativa = document.getElementById(alternativa);
                                            radioAlternativa.checked = true;

                                            var respostaCorreta = form.respostaCorreta.value;
                                            var letra = 64;
                                            var letra = (letra+parseInt(respostaCorreta));
                                            if(resposta==respostaCorreta) {
                                                var resultado = document.querySelector("#resultado"+index);
                                                resultado.style.color='green';
                                                resultado.innerHTML="Parabéns! Você acertou!";
                                            } else {
                                                var resultado = document.querySelector("#resultado"+index);
                                                resultado.style.color='red';
                                                resultado.innerHTML="Você errou! Resposta: "+String.fromCharCode(letra);
                                            }
                                        }
                                </script>
                            </div>
                        </div>
                        <div class="card-action">
                            <button onclick="ResponderQuestao(document.<%="formInserirResposta"+i%>)" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important;" id='<%="responder"+i%>'>Responder</button>
                            <a id='<%="forum"+i%>' href="/EasyQuiz/servletweb?acao=ListarForum&questao=<%= questao.getId()%>"><b>Forum</b></a>
                        </div>
                    </div>
                </div>
            </div>
<%
            } else if(questao.getIdTipo()=='A') {
                String resposta=null;
                Questao questaoAbertaResposta = new Questao();
                    if(listQuestaoAbertaResposta!=null) {
                        for (Questao object : listQuestaoAbertaResposta) {
                            if (object.getId() == cod_Questao) {
                                questaoAbertaResposta = object;
                            }
                        }
                    }
                    resposta = questaoAbertaResposta.getTxtResposta();
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
                        <%
                            if(questao.getImgEnunciado()!=null) {
                        %>
                        <div class="card-image">
                            <img id='<%="imagem"+i%>' class="responsive-img" src="/EasyQuiz/servletweb?acao=CarregaImagem&questao=<%= questao.getId()%>">
                        </div>
                        <%
                            }
                        %>
                        <div class="card-content">
                            <div id='<%="enunciado"+i%>'>
                                <p><b><%= questao.getTxtEnunciado() %></b></p>
                            </div>
                            <div id='<%="respostaAberta"+i%>'>
                                <form method="post" name='<%="formInserirResposta"+i%>'>
                                    <input type='hidden' name='index' value='<%= i %>'>
                                    <input type='hidden' name='table' value='QuestaoAbertaResposta'>
                                    <input type='hidden' name='logado' value='<%= logado %>'>
                                    <input type='hidden' name='contadorRespostaQuestao' value='<%= contadorRespostaQuestao %>'>
                                    <input type='hidden' name='questao' value='<%= questao.getId() %>'>
                                    <input type='hidden' name='tipoQuestao' value='<%= questao.getIdTipo() %>'>
                                    <input type='hidden' name='respostaBase' value='<%= questao.getTxtResposta() %>'>
                                    <input type='hidden' name='resposta' id='<%="resposta"+i%>' value='<%= resposta %>'>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <textarea id='<%="textArea"+i%>' class="materialize-textarea"></textarea>
                                            <label for='<%="textArea"+i%>'>Resposta:</label>
                                        </div>
                                    </div>
                                </form>
                                <br>
                                <div id='<%="resultado"+i%>' class="row">
                                </div>
                                <script type="text/javascript">
                                        var form = document.getElementsByName('<%="formInserirResposta"+i%>')[0];
                                        var index = form.index.value;
                                        var resposta = document.getElementById("resposta"+index).value;
                                        if(resposta!='null') {
                                            var txtResposta = "<%="textArea"+i%>";
                                            var textAreaResposta = document.getElementById(txtResposta);
                                            textAreaResposta.innerHTML = resposta;

                                            var respostaBase = form.respostaBase.value;
                                            var resultado = document.querySelector("#resultado"+index);
                                            resultado.style.color='black';
                                            resultado.style.backgroundColor='lightgreen';
                                            resultado.innerHTML="<b>Resposta Base:</b><p>"+respostaBase+"</p>";
                                        }
                                </script>
                                    
                            </div>
                        </div>

                        <div class="card-action">
                            <button onclick="ResponderQuestao(document.<%="formInserirResposta"+i%>)" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important;" id='<%="responder"+i%>'>Responder</button>
                            <a id='<%="forum"+i%>' href="/EasyQuiz/servletweb?acao=ListarForum&questao=<%= questao.getId()%>"><b>Forum</b></a>
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
    </body>
</html>

