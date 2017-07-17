/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.PostDAOImpl;
import model.daoimpl.QuestaoDAOImpl;
import model.daoimpl.QuestaoFechadaDAOImpl;
import model.domain.Post;
import model.domain.QuestaoFechada;
import model.service.ManterPost;
import model.service.ManterQuestao;
import model.service.ManterQuestaoFechada;
import model.serviceimpl.ManterPostImpl;
import model.serviceimpl.ManterQuestaoFechadaImpl;
import model.serviceimpl.ManterQuestaoImpl;

/**
 *
 * @author Luiz
 */
class ExcluirQuestao {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long idQuestao = Long.parseLong(request.getParameter("questao"));
            ManterPost manterPost = new ManterPostImpl(PostDAOImpl.getInstance());
            List<Post> posts = new ArrayList();
            posts = manterPost.getAllByQuestao(idQuestao);
            //excluir post que está relacionado a questão.
            if (!posts.isEmpty()) {
                for (int i = 0; i < posts.size(); i++) {
                    if (Objects.equals(posts.get(i).getQuestao().getId(), idQuestao)) {
                        manterPost.deletarPost(posts.get(i).getCodigo()); //deleta post que está relacionado a questão deletada.
                    }
                }
            }
            ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
            if (manterQuestao.getQuestaoById(idQuestao).getIdTipo() == 'F') {
                ManterQuestaoFechada manterQuestaoFechada = new ManterQuestaoFechadaImpl(QuestaoFechadaDAOImpl.getInstance());
                List<QuestaoFechada> qf = new ArrayList();
                qf = manterQuestaoFechada.getAll(idQuestao);
                for (int i = 0; i < qf.size(); i++) {
                    if (Objects.equals(qf.get(i).getQuestao().getId(), idQuestao)) {
                        manterQuestaoFechada.deletarQuestaoFechada(idQuestao);
                    }
                }
            }
            //excluir questoes fechadas que esta relacionado a questao
            manterQuestao.deletarQuestao(idQuestao);
            jsp = GerenciarQuestoes.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
