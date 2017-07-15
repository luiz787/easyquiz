package controller;

import javax.servlet.http.HttpServletRequest;

public class ListarForum {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            System.out.println("ListarForum!!!");
            
            jsp = "/erro.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
