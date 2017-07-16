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
public class PaginaInicial {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            request.getSession().setAttribute("numeroPagina",0);
            
            jsp = ListarQuestao.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
