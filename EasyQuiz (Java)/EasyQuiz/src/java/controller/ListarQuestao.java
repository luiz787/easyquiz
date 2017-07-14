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

public class ListarQuestao {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
            List<Questao> listQuestao = manterQuestao.getAll();
            
            ManterQuestaoFechada manterQuestaoFechada = 
                    new ManterQuestaoFechadaImpl(QuestaoFechadaDAOImpl.getInstance());
            List<QuestaoFechada> listQuestaoFechada = manterQuestaoFechada.getAll();
            
            
            if(request.getSession().getAttribute("cod_Usuario")!=null) {
                ListarQuestaoFechadaResposta.execute(request);
            }
            
            
            request.setAttribute("listQuestao", listQuestao);
            
            request.setAttribute("listQuestaoFechada", listQuestaoFechada);
            
            jsp = "/TelaQuestoes.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
