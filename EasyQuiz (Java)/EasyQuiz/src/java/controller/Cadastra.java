package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Cadastra", urlPatterns = {"/Cadastra"})
public class Cadastra extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date data = formato.parse(request.getParameter("data"));
            } catch (ParseException ex) {
                Logger.getLogger(Cadastra.class.getName()).log(Level.SEVERE, null, ex);
            }
            String escolaridade = request.getParameter("escolaridade");
            String senha = request.getParameter("senha");
            String confirma_senha = request.getParameter("confirma_senha");
    }
}
