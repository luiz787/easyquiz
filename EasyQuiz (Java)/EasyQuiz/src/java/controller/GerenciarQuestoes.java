/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author Luiz
 */
public class GerenciarQuestoes {
    public static String execute(HttpServletRequest request){
        String jsp = "";
        try {
            ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
            List<Questao> listQuestao = manterQuestao.getAll();
            ManterQuestaoFechada manterQuestaoFechada = new ManterQuestaoFechadaImpl(QuestaoFechadaDAOImpl.getInstance());
            List<QuestaoFechada> listQuestaoFechada = manterQuestaoFechada.getAll();
            
            request.setAttribute("listQuestao", listQuestao);
            request.setAttribute("listQuestaoFechada", listQuestaoFechada);
            jsp = "/GerenciamentoQuestoes.jsp";
        } catch (Exception e){
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
