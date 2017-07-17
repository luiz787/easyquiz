<%@page import="model.domain.Modulo"%>
<%@page import="model.serviceimpl.ManterModuloImpl"%>
<%@page import="model.daoimpl.ModuloDAOImpl"%>
<%@page import="model.daoimpl.ModuloDAOImpl"%>
<%@page import="model.domain.Disciplina"%>
<%@page import="model.serviceimpl.ManterDisciplinaImpl"%>
<%@page import="model.daoimpl.DisciplinaDAOImpl"%>
<%@page import="model.daoimpl.DisciplinaDAOImpl"%>
<%@page import="model.domain.Dificuldade"%>
<%@page import="model.serviceimpl.ManterDificuldadeImpl"%>
<%@page import="model.daoimpl.DificuldadeDAOImpl"%>
<%@page import="model.daoimpl.DificuldadeDAOImpl"%>
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int logado = Login.validarSessao(request, response);
    Usuario user = null;
    if(logado==1) {
        Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
        ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
        user = manterUsuario.getUsuarioById(cod_Usuario);
        
    }

    
%>
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
    
<nav class="nav-extended" style="background-color:#FFFFFF;">
            <div class="container" style="display: inline; margin-left: 50px;">
                <a id="logo-container" href="/EasyQuiz/servletweb?acao=PaginaInicial" style="color:#47525E; font-size: 32px;">EasyQuiz</a>
                <ul id="side-nav" class="right hide-on-med-and-down">
                    <% if(logado ==0) {          %>
                    <form name="frmLogin" method='post'>
                    <li> 
                        <input id="email" placeholder="email" name="email" type="email" class="form-control" style="color: #696969;border-color:#D3D3D3;">
                    </li>
                    <li>&ensp;</li>
                    <li>
                        <input id="password" placeholder="senha" name="senha" type="password" class="validate" style="color: #696969;border-color:#D3D3D3;">
                    </li>
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" onclick="validarCamposLogin()">Login</a>
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" href="./Cadastro.jsp">Cadastrar</a>
                     </form>
                    <% }else{ %>
                     <li> 
        <h5 style="color:#47525E; font-size: 32px;"> Bem vindo </h5>

      </li>
      <li>
        <h5 style="color:#EE6363; font-size: 32px;">&ensp; <%= user.getNome() %> </h5> 
      </li>


      <li><a class="waves-effect waves-light grey darken-2 btn" href="/EasyQuiz/servletweb?acao=ListarPerfil">&ensp;Perfil&ensp;</a></li>
        <% if(user.getPerfil().getId() == 2) { %>

      <li><a class="waves-effect waves-light grey darken-2 btn" href="#">Questões</a></li>
       <% } %>
      <li><a class="waves-effect waves-light grey darken-2 btn" href="/EasyQuiz/servletweb?acao=Sair">Sair</a></li>
                    <% } %>
                </ul>
            </div>
            <div class="row" style="background-color: #EE6363; margin-top: 15px;" >
                <div class="col s8" >Matérias comuns:
                    <a id="botao-matematica" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E">Matemática</a>
                    <a id="botao-portugues" class="waves-effect waves-light" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top: 2px; background-color: #E5E9F2; color: #47525E">Português</a>
                    <a id="botao-fisica" class="waves-effect waves-light" href="http://localhost:8080/EasyQuiz/servletweb?palavras=&materia=1&acao=PaginaInicial" style="margin-left: 5px; margin-right: 5px; padding-left: 5px; padding-right: 5px; padding-top:    2px; background-color: #E5E9F2; color: #47525E">Física</a>
                </div>
                <div class="col s4">
                    <a class="btn-small waves-effect waves-light grey darken-2 btn" onclick="mostrarform()">Filtrar</a></li>  			
                </div>
            </div>
            <div class="row " id="pesquisa" style="display: none; position: absolute;   width: 47%; background: rgba(255, 255, 255, 0.7);">
                <div class="col s12 offset-s12" id="pesquisa" style="border: 4px solid; border-color:#D3D3D3; background: rgba(255, 255, 255, 1.0); ; text-align:center;border-radius: 10px; z-index: 2;" >
                    <form name="frmbusca" >
                        <input id="palavras" name="palavras" type="search" placeholder="Busque por palavras chave" style="color: #696969;">
                        <div class="row">
                            <div class="input-field col s6">
                                <select id="nivel" name="nivel">
                                    <option value="" disabled selected>Escolha uma Dificuldade</option>
                                    <% 
                                        ManterDificuldadeImpl Dificuldade = new ManterDificuldadeImpl(DificuldadeDAOImpl.getInstance()); 
                                        List<Dificuldade> listadificuldades = Dificuldade.listAll();
                                        
                                        for (Dificuldade D : listadificuldades) { 
                                         String nomdif = D.getDescricao();
                                         int valdif = D.getId().intValue(); %>
                                    <option value="<%=valdif%>"><%=nomdif%></option>
                                    
                                    <% } %>
                                    <option value="">Nenhum</option>
                                </select>
                            </div>
                            <div class="input-field col s6">
                               <select id="materia" name="materia" onChange="getStates(this);">
                                    <option value="" disabled selected>Escolha uma Matéria</option>
                                    
                                     <% 
                                        ManterDisciplinaImpl Disciplina = new ManterDisciplinaImpl(DisciplinaDAOImpl.getInstance()); 
                                        List<Disciplina> listadisciplinas = Disciplina.getAll() ;
                                        
                                        for (Disciplina D : listadisciplinas) { 
                                         String nomdisc = D.getNome();
                                         int valdisc = D.getId().intValue(); %>
                                    <option value="<%=valdisc%>"><%=nomdisc%></option>
                                    
                                    <% } %>
                                    <option value="">Nenhum</option>
                                </select>
                                    <script> function getStates(mat){ 
                                      mat = document.getElementsById("meteria").value;
                                      alert("debug");
                                     //document.location.href="oi.jsp?tuavar="+variavel;} </script>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <select id="tipo" name="tipo">
                                    <option value="" disabled selected>Escolha um tipo</option>
                                    <option value="A">Aberta</option>
                                    <option value="F">Fechada</option>
                                    <option value="">Nenhum</option>
                                </select>
                            </div>
                            <div class="input-field col s6">
                                <select id="modulo" name="modulo">
                                    <option value="" disabled selected>Escolha um módulo</option>
                                     <% 
                                        ManterModuloImpl Modulo = new ManterModuloImpl(ModuloDAOImpl.getInstance()); 
                                        List<Modulo> listamodulos = Modulo.getAll() ;
                                        
                                        for (Modulo M : listamodulos) { 
                                         String nommodulo = M.getNome();
                                         int valmodulo = M.getId().intValue();
                                         %>
                                         <option value="<%=valmodulo%>" style="color:blue;"><%=nommodulo%></option>
                                    
                                    <% } %>
                                    <option value="">Nenhum</option>
                                </select>
                            </div>
                        </div>
                    
                         <input type='hidden' name='acao' value=''>           
                    <a class="btn-large waves-effect waves-light grey darken-2" onclick="paginaInicial(document.frmbusca)" >avançar          
                    </a>
                        </form>            
                </div>
            </div>
        </nav>

        
       