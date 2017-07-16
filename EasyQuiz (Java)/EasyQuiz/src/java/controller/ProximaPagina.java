/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author andro
 */
public class ProximaPagina {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            int numeroPagina = (Integer) request.getSession().getAttribute("numeroPagina");
            request.getSession().setAttribute("numeroPagina", ++numeroPagina);
            request.getSession().setAttribute("acao", "ProximaPagina");
            
            jsp = ListarQuestao.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
