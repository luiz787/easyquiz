/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author andro
 */
public class ContadorRespostaQuestao {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String questao = request.getParameter("questao");
            ArrayList questoes = (ArrayList) request.getAttribute("questoes");
            questoes.add(Long.parseLong(questao));
            request.setAttribute("questoes", questoes);
            String resposta = request.getParameter("resposta");
            request.setAttribute("resposta", Long.parseLong(resposta));
            int contadorRespostaQuestao = (Integer) request.getSession().getAttribute("contadorRespostaQuestao");
            contadorRespostaQuestao++;
            if(contadorRespostaQuestao<=10) {
                request.getSession().setAttribute("contadorRespostaQuestao", contadorRespostaQuestao);
                System.out.println("Contador: "+request.getSession().getAttribute("contadorRespostaQuestao"));
            }
            
            jsp = ListarQuestao.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
