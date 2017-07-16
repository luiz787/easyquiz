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
public class ListarPerfil {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            if(request.getSession().getAttribute("cod_Usuario")!=null) {
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
