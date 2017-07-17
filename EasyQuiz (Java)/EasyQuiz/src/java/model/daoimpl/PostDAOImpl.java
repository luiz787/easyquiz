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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.PostDAO;
import model.dao.QuestaoDAO;
import model.dao.UsuarioDAO;
import model.domain.Post;
import model.domain.Questao;
import model.domain.Usuario;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public class PostDAOImpl implements PostDAO {

    private static PostDAOImpl postDAO = null;

    private PostDAOImpl() {
    }

    public static PostDAOImpl getInstance() {

        if (postDAO == null) {
            postDAO = new PostDAOImpl();
        }

        return postDAO;
    }

   @Override
    synchronized public Long insert(Post post) throws ExcecaoPersistencia {
        try {
            if (post == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO post (cod_questao, txt_conteudo, dat_criacao, cod_usuario) VALUES(?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, post.getQuestao().getId());
            pstmt.setString(2, post.getTxtConteudo());
            pstmt.setTimestamp(3, java.sql.Timestamp.from(post.getDatCriacao()));
            pstmt.setLong(4, post.getAutor().getId());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() FROM post");
            
            Long codigo = null;
            if (rs.next()) {
                codigo = rs.getLong(1);
                post.setCodigo(codigo);
            }
            
            rs.close();
            pstmt.close();
            connection.close();
            
            return codigo;
            
            
            /*
            int linhas = pstmt.executeUpdate();

            if (linhas == 0) {
                System.out.println("ERRO AO GRAVAR");
            }
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                Long cod_post = rs.getLong(1);
                post.setCodigo(cod_post);
            }

            rs.close();
            pstmt.close();
            connection.close();
            */
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
    
    @Override
    synchronized public Post delete(Long cod_Post) throws ExcecaoPersistencia {
        try {
            Post post = this.getPostById(cod_Post);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM post WHERE cod_post = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setLong(1, cod_Post);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return post;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public Post getPostById(Long cod_Post) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM post WHERE cod_post = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Post);
            ResultSet rs = pstmt.executeQuery();

            Post post = null;
            QuestaoDAO questaoDAOImpl = QuestaoDAOImpl.getInstance();
            UsuarioDAO usuarioDAOImpl = UsuarioDAOImpl.getInstance();
            if (rs.next()) {
                post = new Post();
                post.setCodigo(rs.getLong("cod_post"));
                Questao questao = questaoDAOImpl.getQuestaoById(rs.getLong("cod_questao"));
                Usuario usuario = usuarioDAOImpl.getUsuarioById(rs.getLong("cod_usuario"));
                post.setQuestao(questao);
                post.setTxtConteudo(rs.getString("txt_conteudo"));
                post.setAutor(usuario);
                post.setDatCriacao((rs.getTimestamp("dat_criacao")).toInstant());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return post;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Post> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM post ORDER BY cod_post;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Post> listAll = new ArrayList<>();
            QuestaoDAO questaoDAOImpl = QuestaoDAOImpl.getInstance();
            UsuarioDAO usuarioDAOImpl = UsuarioDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    Post post = new Post();
                    post.setCodigo(rs.getLong("cod_post"));
                    Questao questao = questaoDAOImpl.getQuestaoById(rs.getLong("cod_questao"));
                    Usuario usuario = usuarioDAOImpl.getUsuarioById(rs.getLong("cod_usuario"));
                    post.setQuestao(questao);
                    post.setTxtConteudo(rs.getString("txt_conteudo"));
                    post.setAutor(usuario);
                    post.setDatCriacao((rs.getTimestamp("dat_criacao")).toInstant());
                    listAll.add(post);
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
    public List<Post> listAllByQuestao(Long cod_Questao) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM post WHERE cod_questao = ? ORDER BY cod_post;";

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, String.valueOf(cod_Questao));
            ResultSet rs = pstmt.executeQuery();
            List<Post> listAll = new ArrayList<>();
            QuestaoDAO questaoDAOImpl = QuestaoDAOImpl.getInstance();
            UsuarioDAO usuarioDAOImpl = UsuarioDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    Post post = new Post();
                    post.setCodigo(rs.getLong("cod_post"));
                    Questao questao = questaoDAOImpl.getQuestaoById(rs.getLong("cod_questao"));
                    Usuario usuario = usuarioDAOImpl.getUsuarioById(rs.getLong("cod_usuario"));
                    post.setQuestao(questao);
                    post.setTxtConteudo(rs.getString("txt_conteudo"));
                    post.setAutor(usuario);
                    post.setDatCriacao((rs.getTimestamp("dat_criacao")).toInstant());
                    listAll.add(post);
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
}
