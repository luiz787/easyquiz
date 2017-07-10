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
import model.dao.PerfilDAO;
import model.dao.UsuarioDAO;
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
    synchronized public void insert(Usuario usuario) throws ExcecaoPersistencia {
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
                    + "txt_senha"
                    + ") VALUES(?, ?, ?, ?, md5(?))";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, usuario.getPerfil().getCod_Perfil());
            pstmt.setString(2, usuario.getNom_Usuario());
            pstmt.setDate(3, usuario.getDat_Nascimento());
            pstmt.setString(4, usuario.getTxt_Email());
            pstmt.setString(5, usuario.getTxt_Senha());
            pstmt.executeUpdate();
            //ResultSet rs = pstmt.executeQuery();
            /*
            if (rs.next()) {
                Long cod_usuario = rs.getLong("cod_usuario");
                usuario.setCod_Usuario(cod_usuario);
            }
            */
            //rs.close();
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    synchronized public void update(Usuario usuario) throws ExcecaoPersistencia {
        try {
            
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE usuario "
                    + "   SET "
                    + "nom_usuario=?, "
                    + "dat_nascimento=?, "
                    + "txt_email=?, "
                    + "txt_senha = md5(?)"
                    + " WHERE cod_usuario = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            
            pstmt.setString(1, usuario.getNom_Usuario());
            pstmt.setDate(2, usuario.getDat_Nascimento());
            pstmt.setString(3, usuario.getTxt_Email());
            pstmt.setString(4, usuario.getTxt_Senha());
            pstmt.setLong(5, usuario.getCod_Usuario());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
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
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCod_Usuario(rs.getLong("cod_usuario"));
                Perfil perfil = perfilDAOImpl.getPerfilById(rs.getLong("cod_perfil"));
                usuario.setPerfil(perfil);
                usuario.setNom_Usuario(rs.getString("nom_usuario"));
                usuario.setDat_Nascimento(rs.getDate("dat_nascimento"));
                usuario.setTxt_Email(rs.getString("txt_email"));
                usuario.setTxt_Senha(rs.getString("txt_senha"));
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
            if (rs.next()) {
                do {
                    Usuario usuario = new Usuario();
                    usuario.setCod_Usuario(rs.getLong("cod_usuario"));
                    Perfil perfil = perfilDAOImpl.getPerfilById(rs.getLong("cod_perfil"));
                    usuario.setPerfil(perfil);
                    usuario.setNom_Usuario(rs.getString("nom_usuario"));
                    usuario.setDat_Nascimento(rs.getDate("dat_nascimento"));
                    usuario.setTxt_Email(rs.getString("txt_email"));
                    usuario.setTxt_Senha(rs.getString("txt_senha"));
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
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCod_Usuario(rs.getLong("cod_usuario"));
                Perfil perfil = perfilDAOImpl.getPerfilById(rs.getLong("cod_perfil"));
                usuario.setPerfil(perfil);
                usuario.setNom_Usuario(rs.getString("nom_usuario"));
                usuario.setDat_Nascimento(rs.getDate("dat_nascimento"));
                usuario.setTxt_Email(rs.getString("txt_email"));
                usuario.setTxt_Senha(rs.getString("txt_senha"));
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