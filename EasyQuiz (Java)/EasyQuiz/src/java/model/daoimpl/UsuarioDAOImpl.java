/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoimpl;

import util.db.JDBCManterConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.EscolaridadeDAO;
import model.dao.PerfilDAO;
import model.dao.UsuarioDAO;
import model.domain.Escolaridade;
import model.domain.Perfil;
import model.domain.Usuario;
import model.exception.ExcecaoPersistencia;

public class UsuarioDAOImpl implements UsuarioDAO {
    private static UsuarioDAOImpl usuarioDAO = null;

    private UsuarioDAOImpl() {
    }

    public static UsuarioDAOImpl getInstance() {

        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAOImpl();
        }

        return usuarioDAO;
    }

    @Override
    synchronized public Long insert(Usuario usuario) throws ExcecaoPersistencia {
        try {
            if (usuario == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO usuario ("
                    + "cod_perfil, "
                    + "nom_usuario, "
                    + "dat_nascimento, "
                    + "txt_email, "
                    + "txt_senha, "
                    + "cod_escolaridade"
                    + ") VALUES(?, ?, ?, ?, md5(?), ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, usuario.getPerfil().getId());
            pstmt.setString(2, usuario.getNome());
            pstmt.setDate(3, usuario.getDataNascimento());
            pstmt.setString(4, usuario.getEmail());
            pstmt.setString(5, usuario.getSenha());
            pstmt.setLong(6, usuario.getEscolaridade().getId());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() FROM usuario");
            
            Long id = null;
            if (rs.next()) {
                id = rs.getLong(1);
                usuario.setId(id);
            }
            
            rs.close();
            pstmt.close();
            connection.close();
            
            return id;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    synchronized public boolean update(Usuario usuario) throws ExcecaoPersistencia {
        try {
            
            Connection connection = JDBCManterConexao.getInstancia().getConexao();
            String senha = "";
            if(usuario.getSenha().isEmpty()) {
                senha = "txt_senha = md5(?) ";
            }
            String sql = "UPDATE usuario "
                    + "   SET "
                    + "nom_usuario=?, "
                    + "dat_nascimento=?, "
                    + "txt_email=?, "
                    + "cod_escolaridade=?, "
                    + "txt_senha = md5(?) "
                    + " WHERE cod_usuario = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            
            pstmt.setString(1, usuario.getNome());
            pstmt.setDate(2, usuario.getDataNascimento());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setLong(4, usuario.getEscolaridade().getId());
            pstmt.setString(5, usuario.getSenha());
            pstmt.setLong(6, usuario.getId());
            
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
            
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    synchronized public Usuario delete(Long cod_Usuario) throws ExcecaoPersistencia {
        try {
            Usuario usuario = this.getUsuarioById(cod_Usuario);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM usuario WHERE cod_usuario = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setLong(1, cod_Usuario);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return usuario;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public Usuario getUsuarioById(Long cod_Usuario) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM usuario WHERE cod_usuario = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Usuario);
            ResultSet rs = pstmt.executeQuery();

            Usuario usuario = null;
            PerfilDAO perfilDAOImpl = PerfilDAOImpl.getInstance();
            EscolaridadeDAO escolaridadeDAOImpl = EscolaridadeDAOImpl.getInstance();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("cod_usuario"));
                Perfil perfil = perfilDAOImpl.getPerfilById(rs.getLong("cod_perfil"));
                usuario.setPerfil(perfil);
                usuario.setNome(rs.getString("nom_usuario"));
                usuario.setDataNascimento(rs.getDate("dat_nascimento"));
                usuario.setEmail(rs.getString("txt_email"));
                usuario.setSenha(rs.getString("txt_senha"));
                Escolaridade escolaridade = escolaridadeDAOImpl.getEscolaridadeById(rs.getLong("cod_escolaridade"));
                usuario.setEscolaridade(escolaridade);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return usuario;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Usuario> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM usuario ORDER BY cod_usuario;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Usuario> listAll = new ArrayList<>();
            PerfilDAO perfilDAOImpl = PerfilDAOImpl.getInstance();
            EscolaridadeDAO escolaridadeDAOImpl = EscolaridadeDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getLong("cod_usuario"));
                    Perfil perfil = perfilDAOImpl.getPerfilById(rs.getLong("cod_perfil"));
                    usuario.setPerfil(perfil);
                    usuario.setNome(rs.getString("nom_usuario"));
                    usuario.setDataNascimento(rs.getDate("dat_nascimento"));
                    usuario.setEmail(rs.getString("txt_email"));
                    usuario.setSenha(rs.getString("txt_senha"));
                    Escolaridade escolaridade = escolaridadeDAOImpl.getEscolaridadeById(rs.getLong("cod_escolaridade"));
                    usuario.setEscolaridade(escolaridade);
                    listAll.add(usuario);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public Usuario getUsuarioByEmailSenha(String email, String senha) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM usuario WHERE txt_email = ? AND txt_senha = md5(?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();

            Usuario usuario = null;
            PerfilDAO perfilDAOImpl = PerfilDAOImpl.getInstance();
            EscolaridadeDAO escolaridadeDAOImpl = EscolaridadeDAOImpl.getInstance();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("cod_usuario"));
                Perfil perfil = perfilDAOImpl.getPerfilById(rs.getLong("cod_perfil"));
                usuario.setPerfil(perfil);
                usuario.setNome(rs.getString("nom_usuario"));
                usuario.setDataNascimento(rs.getDate("dat_nascimento"));
                usuario.setEmail(rs.getString("txt_email"));
                usuario.setSenha(rs.getString("txt_senha"));
                Escolaridade escolaridade = escolaridadeDAOImpl.getEscolaridadeById(rs.getLong("cod_escolaridade"));
                usuario.setEscolaridade(escolaridade);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return usuario;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
}