/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.PostDAOImpl;
import model.daoimpl.QuestaoDAOImpl;
import model.daoimpl.UsuarioDAOImpl;
import model.domain.Post;
import model.domain.Questao;
import model.domain.Usuario;
import model.service.ManterPost;
import model.service.ManterQuestao;
import model.service.ManterUsuario;
import model.serviceimpl.ManterPostImpl;
import model.serviceimpl.ManterQuestaoImpl;
import model.serviceimpl.ManterUsuarioImpl;

/**
 *
 * @author Carol
 */
class GravarPostAvulso {

    static String execute(HttpServletRequest request) {
        String jsp = "/erro.jsp";
        String erro = "Erro desconhecido";

        try {
            //Long cod_Usuario = new Long (2);
            ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
            Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
            Usuario usuario = manterUsuario.getUsuarioById(cod_Usuario);

            //Long cod_Questao = new Long (2);
            Long cod_Questao = (Long) request.getAttribute("cod_Questao");            
            ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
            Questao questao = manterQuestao.getQuestaoById(cod_Questao);

            String Comentario = request.getParameter("Comentario");
            
            Instant datCriacao = (Instant) request.getSession().getAttribute("dat_datCriacao");
            //Instant datCriacao = Instant.now();
            
            Post post = new Post();

            post.setTxtConteudo(Comentario);
            post.setDatCriacao(datCriacao);
            post.setAutor(usuario);
            post.setQuestao(questao);
            post.setCodigo(new Long (1));

            ManterPost manterPost = new ManterPostImpl(PostDAOImpl.getInstance());
            manterPost.cadastrarPost(post);
            
            System.out.println("SÓ SUCESSO");
            
            jsp = "/TelaForum.jsp";
            
        } catch (Exception e) {
            erro = e.getMessage();
            System.out.println("erro ao gravar o post");
        }

        request.setAttribute("erro", erro);
        return jsp;
    }

}
