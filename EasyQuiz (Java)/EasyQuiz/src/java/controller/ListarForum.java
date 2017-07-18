package controller;

import javax.servlet.http.HttpServletRequest;

public class ListarForum {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String questaoStr = request.getParameter("questao");
            Long cod_Questao = Long.parseLong(questaoStr);
            
            request.setAttribute("cod_Questao", cod_Questao);
            
            jsp = "/TelaForum.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
