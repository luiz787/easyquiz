/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.Instant;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.QuestaoDAOImpl;
import model.daoimpl.QuestaoFechadaDAOImpl;
import model.daoimpl.QuestaoFechadaRespostaDAOImpl;
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.domain.QuestaoFechadaResposta;
import model.service.ManterQuestao;
import model.service.ManterQuestaoFechada;
import model.service.ManterQuestaoFechadaResposta;
import model.serviceimpl.ManterQuestaoFechadaImpl;
import model.serviceimpl.ManterQuestaoFechadaRespostaImpl;
import model.serviceimpl.ManterQuestaoImpl;

/**
 *
 * @author andro
 */
public class ListarQuestaoFechadaResposta {
    public static void execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
            Instant dat_Inicio = (Instant) request.getSession().getAttribute("dat_Inicio");
            
            ManterQuestaoFechadaResposta manterQuestaoFechadaResposta = 
                    new ManterQuestaoFechadaRespostaImpl(QuestaoFechadaRespostaDAOImpl.getInstance());
            List<QuestaoFechadaResposta> listQuestaoFechadaResposta = 
                    manterQuestaoFechadaResposta.getAllByUsuarioSessao(cod_Usuario, dat_Inicio);
            
            
            request.setAttribute("listQuestaoFechadaResposta", listQuestaoFechadaResposta);

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
    }
}
