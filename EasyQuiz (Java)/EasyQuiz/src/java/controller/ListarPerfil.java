/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.Instant;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.QuestaoFechadaRespostaDAOImpl;
import model.domain.QuestaoFechadaResposta;
import model.service.ManterQuestaoFechadaResposta;
import model.serviceimpl.ManterQuestaoFechadaRespostaImpl;

/**
 *
 * @author andro
 */
public class ListarPerfil {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            if(request.getSession().getAttribute("cod_Usuario")!=null) {
                Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
                Instant dat_Inicio = (Instant) request.getSession().getAttribute("dat_Inicio");
                ManterQuestaoFechadaResposta manterQuestaoFechadaResposta 
                    = new ManterQuestaoFechadaRespostaImpl(QuestaoFechadaRespostaDAOImpl.getInstance());
                List<QuestaoFechadaResposta> listQuestaoFechadaResposta =
                manterQuestaoFechadaResposta.getAllByUsuarioSessao(cod_Usuario, dat_Inicio);
                request.getSession().setAttribute("Desempenho", listQuestaoFechadaResposta);
                jsp = "/TelaPerfil.jsp";
            } else {
                String erro = "Usuario nao encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
