<%@page import="model.serviceimpl.ManterEscolaridadeImpl"%>
<%@page import="model.domain.Escolaridade"%>
<%@page import="model.service.ManterEscolaridade"%>
<%@page import="model.daoimpl.EscolaridadeDAOImpl"%>
<%@page import="model.domain.Usuario"%>
<%@page import="model.serviceimpl.ManterUsuarioImpl"%>
<%@page import="model.service.ManterUsuario"%>
<%@page import="model.service.ManterUsuario"%>
<%@page import="model.daoimpl.UsuarioDAOImpl"%>
<%@page import="model.daoimpl.UsuarioDAOImpl"%>
<%@page import="model.serviceimpl.ManterPerfilImpl"%>
<%@page import="model.service.ManterPerfil"%>
<%@page import="model.service.ManterPerfil"%>
<%@page import="model.daoimpl.PerfilDAOImpl"%>
<%@page import="model.daoimpl.PerfilDAOImpl"%>
<%@page import="model.domain.Perfil"%>
<%@page import="controller.ListarQuestao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%        
    request.getSession().setAttribute("contadorRespostaQuestao", 0);
    String jsp = ListarQuestao.execute(request);
    RequestDispatcher rd = request.getRequestDispatcher(jsp);
    rd.forward(request, response);
%>