package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UsuarioDAO;
import model.daoimpl.UsuarioDAOImpl;
import model.domain.Perfil;
import model.domain.Usuario;
import model.service.ManterUsuario;
import model.serviceimpl.ManterUsuarioImpl;

@WebServlet(name = "Cadastra", urlPatterns = {"/Cadastra"})
public class Cadastra extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        Perfil perfil;
        Usuario usuario;
        ManterUsuario manterUsuario; 
         
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String strdata = request.getParameter("data");
            DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date data = java.sql.Date.valueOf(LocalDate.now());
            String escolaridade = request.getParameter("escolaridade");
            String senha = request.getParameter("senha");
            
            perfil = new Perfil();
            perfil.setNome(nome);
            
            usuario = new Usuario();
            usuario.setPerfil(perfil);
            usuario.setEmail(email);
            usuario.setDataNascimento(data);
            //usuario.setEscolaridade(escolaridade);
            usuario.setSenha(senha);
            
            manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
    }
}
