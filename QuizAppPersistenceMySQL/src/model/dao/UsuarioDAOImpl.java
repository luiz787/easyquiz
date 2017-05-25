/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import inf.util.db.JDBCManterConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.Usuario;
import model.exception.ExcecaoPersistencia;

public class UsuarioDAOImpl implements UsuarioDAO {
    private static UsuarioDAOImpl usuarioDAO = null;

    private UsuarioDAOImpl() {
    }

    public static UsuarioDAOImpl getInstancia() {

        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAOImpl();
        }

        return usuarioDAO;
    }

    synchronized public void insert(Usuario usuario) throws ExcecaoPersistencia {
        try {
            if (usuario == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();
            
            String sql = "INSERT INTO usuario (Nome, Data_Nascimento, Email, Senha) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setDate(2, usuario.getDataNascimento());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getSenha());
            //pstmt.setInt(5, (int) usuario.getQuestoesRespondidas().longValue());
            //pstmt.setInt(6, (int) usuario.getQuestoesAcertadas().longValue());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() FROM usuario");

            if (rs.next()) {
                long id = (long) rs.getInt(1);
                usuario.setId(id);
            }
            
            //System.out.println(usuario.getId());
            
            rs.close();
            pstmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    synchronized public void update(Usuario usuario) throws ExcecaoPersistencia {
        try {

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE usuario SET Nome = ?, Data_Nascimento = ?, "
                    + "Email = ?, Senha = ?, Questoes_Respondidas = ?, "
                    + "Questoes_Acertadas = ? WHERE Id = ?; ";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setDate(2, usuario.getDataNascimento());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getSenha());
            pstmt.setInt(5, (int) usuario.getQuestoesRespondidas().longValue());
            pstmt.setInt(6, (int) usuario.getQuestoesAcertadas().longValue());
            
            pstmt.setInt(7, (int) usuario.getId().longValue());
            
            pstmt.executeUpdate();

            pstmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    synchronized public Usuario delete(Long usuarioId) throws ExcecaoPersistencia {
        try {
            Usuario usuario = this.getUsuarioById(usuarioId);

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM usuario WHERE Id = ?";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, (int) usuarioId.longValue());
            
            pstmt.executeUpdate();

            pstmt.close();
            conexao.close();
            
            return usuario;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    public Usuario getUsuarioById(Long usuarioId) throws ExcecaoPersistencia {
        try {
            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM usuario WHERE Id = ?";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, (int) usuarioId.longValue());
            
            ResultSet rs = pstmt.executeQuery();

            Usuario usuario = null;
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("Id"));
                usuario.setNome(rs.getString("Nome"));
                usuario.setDataNascimento(rs.getDate("Data_Nascimento"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setSenha(rs.getString("Senha"));
                usuario.setQuestoesRespondidas((long) rs.getInt("Questoes_Respondidas"));
                usuario.setQuestoesAcertadas((long) rs.getInt("Questoes_Acertadas"));
                
            }

            rs.close();
            pstmt.close();
            conexao.close();

            return usuario;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    public List<Usuario> listAll() throws ExcecaoPersistencia {
        try {
            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM usuario ORDER BY Id;";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Usuario> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    Usuario usuario = new Usuario();
                    usuario.setId((long)rs.getInt("Id"));
                    usuario.setNome(rs.getString("Nome"));
                    usuario.setDataNascimento(rs.getDate("Data_Nascimento"));
                    usuario.setEmail(rs.getString("Email"));
                    usuario.setSenha(rs.getString("Senha"));
                    usuario.setQuestoesRespondidas((long) rs.getInt("Questoes_Respondidas"));
                    usuario.setQuestoesAcertadas((long) rs.getInt("Questoes_Acertadas"));
                    listAll.add(usuario);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            conexao.close();

            return listAll;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
}
