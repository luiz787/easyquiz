package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.QuestaoDAOImpl;
import model.daoimpl.QuestaoFechadaDAOImpl;
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.service.ManterQuestao;
import model.service.ManterQuestaoFechada;
import model.serviceimpl.ManterQuestaoFechadaImpl;
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
            
            if (listQuestao != null) {
                request.setAttribute("listQuestao", listQuestao);
                if(listQuestaoFechada != null) {
                    request.setAttribute("listQuestaoFechada", listQuestaoFechada);
                } else {
                    request.setAttribute("nullQuestoesFechada", 1);
                }
                jsp = "/TelaQuestoes.jsp";
            } else {
                request.setAttribute("nullQuestoes", 1);
                jsp = "/TelaQuestoes.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
