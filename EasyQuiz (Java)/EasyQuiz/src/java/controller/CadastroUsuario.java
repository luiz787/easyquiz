package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.DateFormat;
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
import model.serviceimpl.ManterUsuarioImpl;

@WebServlet(name = "Cadastra", urlPatterns = {"/Cadastra"})
public class CadastroUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Perfil perfil;
            Escolaridade escolaridade;
            Usuario usuario;
            ManterUsuarioImpl manterUsuario;

            String nome = request.getParameter("nome");
            String email = request.getParameter("emailCadastro");
            String strData = request.getParameter("data");
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date data = new Date(formato.parse(strData).getTime());
            String strEscolaridade = request.getParameter("escolaridade");
            String strPerfil = request.getParameter("perfil");
            String senha = request.getParameter("senhaCadastro");

            perfil = new Perfil();
            if (strPerfil.equals("aluno")) {
                perfil.setId(new Long(1)); // 1=aluno 2=professor
            } else if (strPerfil.equals("professor")) {
                perfil.setId(new Long(2)); // 1=aluno 2=professor
            }
            perfil.setNome(strPerfil);

            escolaridade = new Escolaridade();
            
            switch(strEscolaridade) {
                case "Analfabeto": escolaridade.setId(new Long(1));
                case "Fundamental incompleto": escolaridade.setId(new Long(2));
                case "Fundamental completo": escolaridade.setId(new Long(3));
                case "Médio incompleto": escolaridade.setId(new Long(4));
                case "Médio completo": escolaridade.setId(new Long(5));
                case "Superior incompleto": escolaridade.setId(new Long(6));
                case "Superior completo": escolaridade.setId(new Long(7));
                case "Pós graduado": escolaridade.setId(new Long(8));
            }
            
            escolaridade.setNome(strEscolaridade);

            usuario = new Usuario();
            usuario.setPerfil(perfil);
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setDataNascimento(data);
            usuario.setEscolaridade(escolaridade);
            usuario.setSenha(senha);

            manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
            manterUsuario.cadastrarUsuario(usuario);
            
            request.setAttribute("email", email);
            request.setAttribute("senha", senha);
            request.setAttribute("tipo", "cadastro");
            
            Login.execute(request);
            response.sendRedirect("TelaQuestoes.jsp");
             
        } catch (ParseException ex) {
            System.out.println(ex);
        } catch (ExcecaoPersistencia ex) {
            System.out.println(ex);
        } catch (ExcecaoNegocio ex) {
            System.out.println(ex);
        }
    }
}
