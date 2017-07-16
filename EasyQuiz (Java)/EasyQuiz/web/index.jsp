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
            /*
            ManterPerfil manterPerfil = new ManterPerfilImpl(PerfilDAOImpl.getInstance());
            Perfil perfil = manterPerfil.getPerfilById(new Long(2));
            ManterEscolaridade manterEscolaridade = new ManterEscolaridadeImpl(EscolaridadeDAOImpl.getInstance());
            Escolaridade escolaridade = manterEscolaridade.getEscolaridadeById(new Long(1));
            ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
            Usuario usuario = new Usuario();
            usuario.setDataNascimento(java.sql.Date.valueOf("2017-07-09"));
            usuario.setNome("Victor Gabriel");
            usuario.setPerfil(perfil);
            usuario.setEmail("andromenus@gmail.com");
            usuario.setSenha("123456789");
            usuario.setEscolaridade(escolaridade);
            
            Long id = manterUsuario.cadastrarUsuario(usuario);
            System.out.println("ID usuario: "+id);
            */
            
    request.getSession().setAttribute("contadorRespostaQuestao", 0);
    String jsp = ListarQuestao.execute(request);
    RequestDispatcher rd = request.getRequestDispatcher(jsp);
    rd.forward(request, response);
%>