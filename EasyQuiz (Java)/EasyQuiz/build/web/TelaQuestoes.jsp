<%@page import="model.domain.QuestaoFechada"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="model.domain.Questao"%>
<%@page import="java.util.List"%>
<%@page import="controller.ListarQuestao"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%
    ListarQuestao.execute(request);
    List<Questao> listQuestao = (List<Questao>) request.getAttribute("listQuestao");
    List<QuestaoFechada> listQuestaoFechada = (List<QuestaoFechada>) request.getAttribute("listQuestaoFechada");
    
    int numeroPagina = (Integer) request.getAttribute("numeroPagina");
    System.out.println("NumeroPagina: "+numeroPagina);
    int maxQuestao;
    if((listQuestao.size()-(numeroPagina*5))<5) {
        maxQuestao=listQuestao.size();
    } else {
        maxQuestao=((numeroPagina*5)+5);
    }
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <script type="text/javascript" language="JavaScript" src="js/webvalida.js"></script>
        <title>EasyQuiz</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/materialize.css"/>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>

        <style type="text/css">
            [type="radio"].with-gap:checked + label:before,
            [type="radio"].with-gap:checked + label:after {
              border: 2px solid #f4511e;
            }

            [type="radio"].with-gap:checked + label:after {
              background-color: #f4511e;
            }
            .row {
              z-index: 1;
            }
            .card {
              width: 700px;
              z-index: 0;
            }
            .card-panel {
              width: 100%;
              height: 45px;
              padding-top: 0%;
            }
            .card-image {
              height: 250px;
            }
            .card-image img {
              max-height: 100%;
              max-width: 100%;
            }
            .card-content {
                height: 60%;
            }
            .card-action {
              height: 70px;
            }
            .container{
              width: 100%;
            }
            label{
              color: black;
            }
        </style>
    </head>
    <body>
        <nav class="nav-extended" style="background-color:#FFFFFF;">
            <div class="container" style="display: inline; margin-left: 50px;">
                <a id="logo-container" href="#" style="color:#47525E; font-size: 32px;">EasyQuiz</a>
                <ul id="side-nav" class="right hide-on-med-and-down">
                    <li> 
                        <input id="email" placeholder="email" type="email" class="form-control" style="color: #696969;border-color:#D3D3D3;">
                    </li>
                    <li>&ensp;</li>
                    <li>
                        <input id="password" placeholder="senha" type="password" class="validate" style="color: #696969;border-color:#D3D3D3;">
                    </li>
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" href="#">Login</a>
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" href="#">Cadastrar</a>
                </ul>
            </div>
            <div class="row" style="background-color: #EE6363; margin-top: 15px;" >
                <div class="col s8" >Matérias comuns:
                    <a id="botao-matematica" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E">Matemática</a>
                    <a id="botao-portugues" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E">Português</a>
                    <a id="botao-fisica" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top:    2px; background-color: #E5E9F2; color: #47525E">Física</a>
                </div>
                <div class="col s4">
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" onclick="mostrarform()">Filtrar</a></li>  			
                </div>
            </div>
            <div class="row " id="pesquisa" style="display: none; position: absolute;   width: 47%; background: rgba(255, 255, 255, 0.7);">
                <div class="col s12 offset-s12" id="pesquisa" style="border: 4px solid; border-color:#D3D3D3; background: rgba(255, 255, 255, 1.0); ; text-align:center;border-radius: 10px; z-index: 2;" >
                    <form>
                        <input id="search" type="search" placeholder="Busque por palavras chave" style="color: #696969;">
                        <div class="row">
                            <div class="input-field col s6">
                                <select id="nivel">
                                    <option value="" disabled selected>Escolha uma Dificuldade</option>
                                    <option value="1">Fácil</option>
                                    <option value="2">Médio</option>
                                    <option value="3">Difícil</option>
                                    <option value="4">Desafio</option>
                                    <option value="0">Nenhum</option>
                                </select>
                            </div>
                            <div class="input-field col s6">
                                <select id="materia">
                                    <option value="" disabled selected>Escolha uma Matéria</option>
                                    <option value="1">Matemática</option>
                                    <option value="2">Português</option>
                                    <option value="3">Física</option>
                                    <option value="4">Geografia</option>
                                    <option value="5">História</option>
                                    <option value="6">Química</option>
                                    <option value="7">Inglês</option>
                                    <option value="0">Nenhum</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <select id="tipo">
                                    <option value="" disabled selected>Escolha um tipo</option>
                                    <option value="1">Aberta</option>
                                    <option value="2">Fechada</option>
                                    <option value="3">Nenhum</option>
                                </select>
                            </div>
                            <div class="input-field col s6">
                                <select id="materia">
                                    <option value="" disabled selected>Escolha um módulo</option>
                                    <option value="0">Nenhum</option>
                                </select>
                            </div>
                        </div>
                    </form>
                    <button class="btn-large waves-effect waves-light grey darken-2" type="submit" name="action">avançar 
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </div>
        </nav>

        <div class="container" >
<%
        int idAlternativa=0;
        for(int i=(5*numeroPagina); i<maxQuestao; i++) {
            Questao questao = listQuestao.get(i);
            if(questao.getCod_Tipo()=='F') {
                ArrayList<QuestaoFechada> alternativas = new ArrayList();
                Long cod_Questao = questao.getCod_Questao();
                for (QuestaoFechada object : listQuestaoFechada) {
                    if (object.getQuestao().getCod_Questao() == cod_Questao) {
                        alternativas.add(object);
                    }
                }
%>
            <div class="row" >
                <div class="col s12 m4" > 
                    <div class="card" >
                        <div class="card-panel #f4511e deep-orange darken-1 white-text">
                            <div>
                                <b style="padding-top: 0px">Disciplina: </b><span id='<%="disciplina"+i%>'><%= questao.getDisciplina().getNom_Disciplina() %></span>
                                <b style="padding-left:50%;padding-top: 0px">Dificuldade: </b><span id='<%="dificuldade"+i%>'><%= questao.getDificuldade().getDes_Dificuldade() %></span>
                            </div>
                            <div>
                                <span id='<%="modulo"+i%>' style=""><b>Módulo: </b><%= questao.getModulo().getNom_Modulo() %></span>
                            </div>
                        </div>
                        <div class="card-image">
                            <img id='<%="imagem"+i%>' class="responsive-img" src="img/Geladeira.png">
                        </div>
                        <div class="card-content">
                            <div id='<%="enunciado"+i%>'>
                                <p><b><%= questao.getTxt_Enunciado() %></b></p>
                            </div>
                            <div id='<%="alternativas"+i%>'>
                                <form method="post" id='<%="form"+i%>'>
<%
                                    char letra='a';
                                    for(int j=0; j<alternativas.size(); j++) {
                                        
%>
                                    <p>
                                        <input class="with-gap" name='<%="grupo"+i%>' type="radio" id='<%="alternativa"+idAlternativa%>'  />
                                        <label for='<%="alternativa"+idAlternativa%>'><b><%=((char)(letra+j))+")"%></b> <%= alternativas.get(j).getTxt_Alternativa() %> </label>
                                    </p>
<%
                                        idAlternativa++;
                                    }
%>
                                </form>
                            </div>
                        </div>
                        <div class="card-action">
                            <button onclick="teste()" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important;" id='<%="responder"+i%>'>Responder</button>
                            <a id='<%="forum"+i%>' href="#"><b>Forum</b></a>
                        </div>
                    </div>
                </div>
            </div>
<%
            } else {
%>
            <div class="row">
                <div class="col s12 m4">
                    <div class="card">
                        <div class="card-panel #f4511e deep-orange darken-1 white-text">
                            <div style="">
                                <b style="padding-top: 0px">Disciplina: </b><span id='<%="disciplina"+i%>'><%= questao.getDisciplina().getNom_Disciplina() %></span>
                                <b style="padding-left:50%;padding-top: 0px">Dificuldade: </b><span id='<%="dificuldade"+i%>'><%= questao.getDificuldade().getDes_Dificuldade() %></span>
                            </div>
                            <div>
                                <span id='<%="modulo"+i%>' style=""><b>Módulo: </b><%= questao.getModulo().getNom_Modulo() %></span>
                            </div>
                        </div>
                        <!--
                        <div class="card-image">
                            <img id="imagem2" class="responsive-img" src="">
                        </div>
                        -->
                        <div class="card-content">
                            <div id='<%="enunciado"+i%>'>
                                <p><b><%= questao.getTxt_Enunciado() %></b></p>
                            </div>
                            <div id='<%="respostaAberta"+i%>'>
                                <form action="post" id='<%="form"+i%>'>
                                    <div class="row">
                                        <div class="input-field col s12">
                                            <textarea id='<%="textArea"+i%>' class="materialize-textarea"></textarea>
                                            <label for='<%="textArea"+i%>'>Resposta:</label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <div class="card-action">
                            <button onclick="teste()" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important;" id='<%="responder"+i%>'>Responder</button>
                            <a id='<%="forum"+i%>' href="#"><b>Forum</b></a>
                        </div>

                    </div>
                </div>
            </div>
<%
            }
        } 
%>
        </div>
        <div>
        <h6 style="text-align: center;">Página: <%=(numeroPagina+1)%></h6>
        <form name="formPagina" action='post'>
            <input type='hidden' name='acao' value=''>
            <button onclick="proximaPagina(document.formPagina)" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important; margin-left: 70%; " id='teste75'>Próxima Página</button>
            <button onclick="paginaAnterior(document.formPagina)" class="btn waves-effect waves-orange orange right" style="background-color: #f4511e !important;" id='1'>Página Anterior</button>
        </form>
        </div>
        <br>
        <br>

        <footer class="page-footer orange">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Quem somos</h5>
                        <p class="grey-text text-lighten-4">Luiz Augusto Dias Berto</p>
                        <p class="grey-text text-lighten-4">Maria Carolina</p>
                        <p class="grey-text text-lighten-4">Rafael Gontijo</p>
                        <p class="grey-text text-lighten-4">Victor César</p>
                        <p class="grey-text text-lighten-4">Victor Gabriel</p>
                    </div>
                    <div class="col l3 s12">
                        <h5 class="white-text">Conecte-se</h5>
                        <ul>
                            <li><a class="white-text" href="http://www.cefetmg.br/">CEFET-MG</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    Feito com <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
                </div>
            </div>
        </footer>


          <!--  Scripts-->
        <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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

