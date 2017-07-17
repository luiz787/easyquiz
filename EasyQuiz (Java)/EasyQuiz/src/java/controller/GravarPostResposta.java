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
public class GravarPostResposta {

    static String execute(HttpServletRequest request) {
        String jsp = "/erro.jsp";
        String erro = "Erro desconhecido";

        try {
            //Long cod_Usuario = new Long(1);
            ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
            Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
            Usuario usuario = manterUsuario.getUsuarioById(cod_Usuario);

            ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
            String str_Questao = request.getParameter("CodQuestaoPostResposta");
            Long cod_Questao = new Long(str_Questao);
            Questao questao = manterQuestao.getQuestaoById(cod_Questao);

            //Instant datCriacao = (Instant) request.getSession().getAttribute("dat_datCriacao");
            Instant datCriacao = Instant.now();

            ManterPost manterPostOriginal = new ManterPostImpl(PostDAOImpl.getInstance());
            Post post_original = manterPostOriginal.getPostById(new Long(request.getParameter("CodigoPostOriginal")));

            String comentario = "Em resposta a " + post_original.getAutor().getNome() + ": \"" + post_original.getTxtConteudo()
                    + "\" //" + request.getParameter("ComentarioResposta");

            Post post_resposta = new Post();

            post_resposta.setTxtConteudo(comentario);
            post_resposta.setDatCriacao(datCriacao);
            post_resposta.setAutor(usuario);
            post_resposta.setQuestao(questao);
            post_resposta.setCodigo(new Long(1));

            ManterPost manterPost = new ManterPostImpl(PostDAOImpl.getInstance());
            manterPost.cadastrarPost(post_resposta);

            System.out.println("SÓ SUCESSO");

            jsp = "/servletweb?acao=ListarForum&questao="+cod_Questao;

        } catch (Exception e) {
            erro = e.getMessage();
            System.out.println("erro ao gravar o post");
        }

        request.setAttribute("erro", erro);
        return jsp;
    }
}
