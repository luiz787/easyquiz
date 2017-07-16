package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import model.daoimpl.EscolaridadeDAOImpl;
import model.daoimpl.UsuarioDAOImpl;
import model.domain.Escolaridade;
import model.domain.Usuario;
import model.service.ManterEscolaridade;
import model.service.ManterUsuario;
import model.serviceimpl.ManterEscolaridadeImpl;
import model.serviceimpl.ManterUsuarioImpl;

public class AlterarUsuario {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Long cod_Usuario = (Long) request.getSession().getAttribute("cod_Usuario");
            if(cod_Usuario!=null) {
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = format.parse(request.getParameter("dataNascimento"));
                java.sql.Date data = new java.sql.Date(date.getTime());
                String senha = request.getParameter("senha");
                
                ManterEscolaridade manterEscolaridade = new ManterEscolaridadeImpl(EscolaridadeDAOImpl.getInstance());
                Long idEscolaridade = Long.parseLong(request.getParameter("escolaridadeInput"));
                Escolaridade escolaridade = manterEscolaridade.getEscolaridadeById(idEscolaridade);
                
                ManterUsuario manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
                
                Usuario usuario = new Usuario();
                usuario.setId(cod_Usuario);
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setDataNascimento(data);
                usuario.setEscolaridade(escolaridade);
                usuario.setSenha(senha);
                
                
                
                boolean result = manterUsuario.alterarUsuario(usuario);
                if(result) {
                    jsp = ListarPerfil.execute(request);
                } else {
                    String erro = "Não foi possivel alterar o usuário!";
                    request.setAttribute("erro", erro);
                    jsp = "/erro.jsp";
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
