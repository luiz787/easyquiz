<%@page import="model.domain.Usuario"%>
<%@page import="model.serviceimpl.ManterUsuarioImpl"%>
<%@page import="model.service.ManterUsuario"%>
<%@page import="model.daoimpl.UsuarioDAOImpl"%>
<%@page import="model.daoimpl.UsuarioDAOImpl"%>
<%@page import="controller.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int logado = Login.validarSessao(request, response);
    if(logado==1) {
        Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
        ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
        Usuario usuario = manterUsuario.getUsuarioById(cod_Usuario);
        
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page ="Menu.jsp"/>
        <H4 style="color: #47525E; padding-left: 80px;">Aproveitamento:</H4>
        <div class="container">
          <H5 style="color: #47525E; display: inline;">Perguntas respondidas:</H5> <H5 style="color: #C55353; display: inline;">250</H5>
          <H5 style="color: #47525E; display: inline; padding-left: 50px;">Perguntas acertadas:</H5> <H5 style="color: #C55353; display: inline;">175</H5>
          <br>
          <br>
          <H5 style="color: #47525E; display: inline;">Coeficiente de acerto:</H5> <H5 style="color: #C55353; display: inline;">70%</H5>
          <div class="progress" style="z-index: -1;">
            <div class="determinate" style="width: 70%; z-index: -11;"></div>
          </div>
        </div>

        <br>
        <br>

        <H4 style="color: #47525E; padding-left: 80px; display: inline;">O que deseja alterar </H4> <H4 style="color: #C55353; display: inline;">Usuário?</H4>
        <div class="container">
            <form class="col s12">
                <div class="input-field col s6">
                    <i class="material-icons prefix">account_circle</i>
                    <input id="nome" type="text" class="validate">
                    <label for="nome">Nome completo</label>
                </div>

                <div class="input-field col s6">
                    <i class="material-icons prefix">email</i>
                    <input id="email" type="email" class="validate">
                    <label for="email">E-mail</label>
                </div>

                <br>

                <label for="escolhe_data">Data de nascimento:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">perm_contact_calendar</i>
                    <input id="escolhe_data" type="date" class="validate">
                </div>

                <label for="escolaridade">Escolaridade:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">class</i>
                    <select id="escolaridade">
                        <option value="" selected>Escolaridade</option>
                        <option value="1">Analfabeto</option>
                        <option value="2">Fundamental incompleto</option>
                        <option value="3">Fundamental completo</option>
                        <option value="4">Médio incompleto</option>
                        <option value="5">Médio completo</option>
                        <option value="6">Superior incompleto</option>
                        <option value="7">Superior completo</option>
                        <option value="8">Mestrado</option>
                        <option value="9">Doutorado</option>
                    </select>
                </div>

                <br>

                <label for="senha">Senha:</label>
                <div class="input-field col s6">
                    <i class="material-icons prefix">lock_outline</i>
                    <input id="senha" type="password" class="validate">
                </div>
                <label for="senha">Confirmar senha:</label>
                <div class="input-field col s6">
                    <input type="password" id="confirma_senha">
                </div>

                <br>
                <br>
                <br>

                <div align="right">
                    <button class="btn waves-effect waves-light" type="button" onclick="window.open('../Tela de questões/TelaQuestoes.html');">Cancelar</button>

                    <button class="btn waves-effect waves-light" type="submit" name="action" onclick="window.open('../Tela de questões/TelaQuestoes.html');">Confirmar
                        <i class="material-icons right">send</i>
                    </button>
                </div>
            </form>
        </div>

        <br>
        <br>

        <jsp:include page ="Footer.jsp"/>
    </body>
</html>
