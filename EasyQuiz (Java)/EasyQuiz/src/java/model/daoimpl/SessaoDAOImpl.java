package model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.Sessao;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;

public class SessaoDAOImpl implements SessaoDAO {

    @Override
    synchronized public void insert(Sessao sessao) throws ExcecaoPersistencia {
        try {
            if (sessao == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();
            
            String sql = "INSERT INTO sessao (cod_usuario, dat_inicio) VALUES(?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, sessao.getCod_Usuario());
            pstmt.setTimestamp(2, java.sql.Timestamp.from(sessao.getDat_Inicio()));
            
            pstmt.executeUpdate();
            
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    synchronized public void update(Sessao sessao) throws ExcecaoPersistencia {
        try {
            
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE sessao "
                    + "   SET dat_fim = ?"
                    + " WHERE cod_usuario = ? and dat_inicio = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setTimestamp(1, java.sql.Timestamp.from(sessao.getDat_Fim()));
            pstmt.setLong(2, sessao.getCod_Usuario());
            pstmt.setTimestamp(3, java.sql.Timestamp.from(sessao.getDat_Inicio()));
            
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Sessao> getSessaoByUsuario(Long cod_Usuario) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM sessao WHERE cod_usuario = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Sessao> sessaoByUsuario = new ArrayList<>();
            if (rs.next()) {
                do {
                    Sessao sessao = new Sessao();
                    sessao.setDat_Inicio((rs.getTimestamp("dat_inicio")).toInstant());
                    sessao.setCod_Usuario(rs.getLong("cod_usuario"));
                    sessao.setDat_Fim((rs.getTimestamp("dat_inicio")).toInstant());
                    sessaoByUsuario.add(sessao);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return sessaoByUsuario;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Sessao> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM sessao ORDER BY cod_sessao;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Sessao> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    Sessao sessao = new Sessao();
                    sessao.setDat_Inicio((rs.getTimestamp("dat_inicio")).toInstant());
                    sessao.setCod_Usuario(rs.getLong("cod_usuario"));
                    sessao.setDat_Fim((rs.getTimestamp("dat_inicio")).toInstant());
                    listAll.add(sessao);
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
