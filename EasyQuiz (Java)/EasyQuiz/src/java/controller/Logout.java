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
 * @author F43L
 */
public class Logout {
 
    
    @SuppressWarnings("static-access")
    public static String execute(HttpServletRequest request) {

        String jsp = "";
        
        
        try {
        /*request.getSession().setAttribute("dat_fim", Instant.now());
        request.logout();
        request.getSession().invalidate();  
        */
        ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
        Usuario usuario = manterUsuario.getUsuarioById((Long) request.getSession().getAttribute("cod_Usuario"));
        
        ManterSessao manterSessao = 
                        new ManterSessaoImpl(SessaoDAOImpl.getInstance());
        Sessao sessao = new Sessao();
        sessao.setUsuario(usuario);
        sessao.setDataInicio((Instant)request.getSession().getAttribute("dat_Inicio"));
        sessao.setDataFim(Instant.now());
        boolean result = manterSessao.alterarSessao(sessao);
        
        
        request.getSession().removeAttribute("cod_Usuario"); 
        request.getSession().removeAttribute("listTxtResposta");
        request.getSession().removeAttribute("listRespostaNaoLogado");
        
        jsp = ListarQuestao.execute(request);
                
            

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    
}


