/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import model.daoimpl.QuestaoDAOImpl;
import model.service.ManterQuestao;
import model.serviceimpl.ManterQuestaoImpl;
/**
 *
 * @author Luiz
 */
class ExcluirQuestao {
    public static String execute(HttpServletRequest request){
        String jsp = "";
        try {
          Long idQuestao = Long.parseLong(request.getParameter("questao"));
          ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
          manterQuestao.deletarQuestao(idQuestao);
          jsp = GerenciarQuestoes.execute(request);
        } catch (Exception e){
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
