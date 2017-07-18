/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.time.Instant;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.daoimpl.SessaoDAOImpl;
import model.daoimpl.UsuarioDAOImpl;
import model.domain.Sessao;
import model.domain.Usuario;
import model.service.ManterSessao;
import model.service.ManterUsuario;
import model.serviceimpl.ManterSessaoImpl;
import model.serviceimpl.ManterUsuarioImpl;

/**
 *
 * @author andro
 */
public class Login {

    @SuppressWarnings("static-access")
    public static String execute(HttpServletRequest request) {

        String jsp = "";

        try {
            
            String email;
            String senha;
            
            if (request.getAttribute("tipo") != null && request.getAttribute("tipo").equals("cadastro")) {
                email = (String)request.getAttribute("email");
                senha = (String)request.getAttribute("senha");
            } else {
                email = request.getParameter("email");
                senha = request.getParameter("senha");
            }
            
            ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
            Usuario usuario = manterUsuario.getUsuarioByEmailSenha(email, senha);

            if (usuario == null) {
                String erro = "Usuario nao encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            } else {
                request.getSession().setAttribute("cod_Usuario", usuario.getId());
                request.getSession().setAttribute("dat_Inicio", Instant.now());
                ManterSessao manterSessao
                        = new ManterSessaoImpl(SessaoDAOImpl.getInstance());
                Sessao sessao = new Sessao();
                sessao.setUsuario(usuario);
                sessao.setDataInicio((Instant) request.getSession().getAttribute("dat_Inicio"));
                boolean result = manterSessao.cadastrarSessao(sessao);

                request.getSession().setAttribute("contadorRespostaQuestao", 0);
                request.getSession().removeAttribute("listTxtResposta");
                request.getSession().removeAttribute("listRespostaNaoLogado");
                jsp = ListarQuestao.execute(request);
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    public static int validarSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
        String jsp = "";
        if (cod_Usuario == null) {
            return 0;
        } else {
            return 1;
        }
    }
}
