/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.time.Instant;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author F43L
 */
public class Logout {
 
    
    @SuppressWarnings("static-access")
    public static String execute(HttpServletRequest request) {

        String jsp = "";
        
        
        try {
        /*request.getSession().setAttribute("dat_fim", Instant.now());
        request.logout();
        request.getSession().invalidate();  
        */
        request.getSession().setAttribute("cod_Usuario",null); 
        jsp = ListarQuestao.execute(request);
                
            

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }

    
}


