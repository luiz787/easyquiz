package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.daoimpl.UsuarioDAOImpl;
import model.domain.Escolaridade;
import model.domain.Perfil;
import model.domain.Usuario;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import model.service.ManterUsuario;
import model.serviceimpl.ManterUsuarioImpl;

@WebServlet(name = "Cadastra", urlPatterns = {"/Cadastra"})
public class Cadastra extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Perfil perfil;
            Escolaridade escolaridade;
            Usuario usuario;
            ManterUsuario manterUsuario;

            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String strData = request.getParameter("data");
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date data = new Date(formato.parse(strData).getTime());
            String strEscolaridade = request.getParameter("escolaridade");
            escolaridade = new Escolaridade();
            escolaridade.setNome(strEscolaridade);
            String senha = request.getParameter("senha");

            perfil = new Perfil();
            perfil.setNome(nome);

            usuario = new Usuario();
            usuario.setPerfil(perfil);
            usuario.setEmail(email);
            usuario.setDataNascimento(data);
            usuario.setEscolaridade(escolaridade);
            usuario.setSenha(senha);
            
            manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
            manterUsuario.cadastrarUsuario(usuario);
/*
            request.setAttribute("nome", nome);
            request.setAttribute("email", email);
            request.setAttribute("data", data);
            request.setAttribute("escolaridade", escolaridade.getNome());
            request.setAttribute("senha", senha);

            request.getRequestDispatcher("teste.jsp").forward(request, response);
*/
        } catch (ParseException | ExcecaoPersistencia | ExcecaoNegocio ex) {
            Logger.getLogger(Cadastra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}