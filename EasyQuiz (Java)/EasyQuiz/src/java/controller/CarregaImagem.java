/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.daoimpl.QuestaoDAOImpl;
import model.domain.Questao;
import model.service.ManterQuestao;
import model.serviceimpl.ManterQuestaoImpl;
import util.db.JDBCManterConexao;

/**
 *
 * @author andro
 */

public class CarregaImagem {
    public static String execute(HttpServletRequest request, HttpServletResponse response) {
        String jsp = "";
        try {
                String questaoStr = request.getParameter("questao");
                Long cod_Questao = Long.parseLong(questaoStr);
                ManterQuestao manterQuestao = new ManterQuestaoImpl(QuestaoDAOImpl.getInstance());
                Questao questao = manterQuestao.getQuestaoById(cod_Questao);
                
                byte[] imagem = questao.getImgEnunciado();
                response.setContentType(request.getServletContext().getMimeType("imagem"+questao.getId()+".png"));
                response.setContentLength(imagem.length);
                response.getOutputStream().write(imagem);
                
                jsp = "notFoward";

        } catch (Exception e) {
            System.out.println("CATCH!"+e);
        }
        return jsp;
    }
}
