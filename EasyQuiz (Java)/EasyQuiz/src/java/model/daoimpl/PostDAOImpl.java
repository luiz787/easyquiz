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
import model.dao.PostDAO;
import model.domain.Post;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public class PostDAOImpl implements PostDAO{
    private static PostDAOImpl postDAO = null;

    private PostDAOImpl() {
    }

    public static PostDAOImpl getInstancia() {

        if (postDAO == null) {
            postDAO = new PostDAOImpl();
        }

        return postDAO;
    }

    synchronized public void insert(Post post) throws ExcecaoPersistencia {
        try {
            if (post == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();
            
            String sql = "INSERT INTO post (Conteudo, Id_Autor, Data_Criacao, "
                    + "Id_Questao) VALUES (?,?,?,?)";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, post.getConteudo());
            pstmt.setInt(2, (int) post.getIdAutor().longValue());
            pstmt.setDate(3, post.getDataCriacao());
            pstmt.setInt(4, (int) post.getIdQuestao().longValue());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() FROM post");

            if (rs.next()) {
                long id = (long) rs.getInt(1);
                post.setId(id);
            }
            
            //System.out.println(post.getId());
            
            rs.close();
            pstmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    synchronized public void update(Post post) throws ExcecaoPersistencia {
        try {

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE post SET Conteudo = ?, Data_Criacao = ? WHERE"
                    + " Id = ? AND Id_Autor = ? AND Id_Questao = ?;";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, post.getConteudo());
            pstmt.setDate(2, post.getDataCriacao());
            
            pstmt.setInt(3, (int) post.getId().longValue());
            pstmt.setInt(4, (int) post.getIdAutor().longValue());
            pstmt.setInt(5, (int) post.getIdQuestao().longValue());
            
            pstmt.executeUpdate();

            pstmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    synchronized public Post delete(Long postId) throws ExcecaoPersistencia {
        try {
            Post post = this.getPostById(postId);

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM post WHERE Id = ?";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, (int) postId.longValue());
            
            pstmt.executeUpdate();

            pstmt.close();
            conexao.close();
            
            return post;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    public Post getPostById(Long postId) throws ExcecaoPersistencia {
        try {
            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM post WHERE Id = ?";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, (int) postId.longValue());
            
            ResultSet rs = pstmt.executeQuery();

            Post post = null;
            if (rs.next()) {
                post = new Post();
                post.setId((long)rs.getLong("Id"));
                post.setConteudo(rs.getString("Conteudo"));
                post.setIdAutor((long)rs.getInt("Id_Autor"));
                post.setDataCriacao(rs.getDate("Data_Criacao"));
                post.setIdQuestao((long)rs.getInt("Id_Questao"));
                
            }

            rs.close();
            pstmt.close();
            conexao.close();

            return post;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    public List<Post> listAll() throws ExcecaoPersistencia {
        try {
            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM post ORDER BY Id;";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Post> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    Post post = new Post();
                    post.setId((long)rs.getInt("Id"));
                    post.setConteudo(rs.getString("Conteudo"));
                    post.setIdAutor((long)rs.getInt("Id_Autor"));
                    post.setDataCriacao(rs.getDate("Data_Criacao"));
                    post.setIdQuestao((long)rs.getInt("Id_Questao"));
                    listAll.add(post);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            conexao.close();

            return listAll;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
}
