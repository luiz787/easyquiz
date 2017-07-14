/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.QuestaoDAOImpl;
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.domain.QuestaoFechadaResposta;
import model.service.ManterQuestao;
import model.serviceimpl.ManterQuestaoImpl;

/**
 *
 * @author andro
 */
public class ContadorRespostaQuestao {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            
            int contadorRespostaQuestao = (Integer) request.getSession().getAttribute("contadorRespostaQuestao");
            contadorRespostaQuestao++;
            if(contadorRespostaQuestao<=10) {
                request.getSession().setAttribute("contadorRespostaQuestao", contadorRespostaQuestao);
                
                String questaoStr = request.getParameter("questao");
                Long cod_Questao = Long.parseLong(questaoStr);
                ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
                Questao questao = manterQuestao.getQuestaoById(cod_Questao);
                
                if(questao.getIdTipo()=='A') {
                    
                } else if(questao.getIdTipo()=='F') {
                    if(request.getAttribute("listRespostaNaoLogado")==null) {
                        List<QuestaoFechadaResposta> listRespostaNaoLogado = new ArrayList<QuestaoFechadaResposta>();
                        request.setAttribute("listRespostaNaoLogado", listRespostaNaoLogado);
                    }
                    List<QuestaoFechadaResposta> listRespostaNaoLogado = 
                            (List<QuestaoFechadaResposta>) request.getAttribute("listRespostaNaoLogado");



                    String resposta = request.getParameter("resposta");
                    Long seqQuestaoResposta = Long.parseLong(resposta);

                    QuestaoFechadaResposta questaoFechadaResposta = new QuestaoFechadaResposta();
                    questaoFechadaResposta.setQuestao(questao);
                    questaoFechadaResposta.setSeqQuestaoResposta(seqQuestaoResposta);

                    listRespostaNaoLogado.add(questaoFechadaResposta);
                    request.setAttribute("listRespostaNaoLogado", listRespostaNaoLogado);
                }
            }
            
            jsp = ListarQuestao.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
