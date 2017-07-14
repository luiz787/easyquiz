/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import model.dao.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.Questao;
import model.domain.QuestaoFechadaResposta;
import model.domain.Sessao;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;

/**
 *
 * @author Aluno
 */
public class QuestaoFechadaRespostaDAOImpl implements QuestaoFechadaRespostaDAO {
    private static QuestaoFechadaRespostaDAOImpl questaoFechadaRespostaDAO = null;

    private QuestaoFechadaRespostaDAOImpl() {
    }

    public static QuestaoFechadaRespostaDAOImpl getInstance() {

        if (questaoFechadaRespostaDAO == null) {
            questaoFechadaRespostaDAO = new QuestaoFechadaRespostaDAOImpl();
        }

        return questaoFechadaRespostaDAO;
    }
    
    @Override
    synchronized public void insert(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia {
        try {
            if (questaoFechadaResposta == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();
            String sql = "INSERT INTO questaofechadaresposta (dat_inicio, cod_usuario, cod_questao, seq_questao_resposta) VALUES(?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setTimestamp(1, java.sql.Timestamp.from(questaoFechadaResposta.getSessao().getDataInicio()));
            pstmt.setLong(2, questaoFechadaResposta.getSessao().getUsuario().getId());
            pstmt.setLong(3, questaoFechadaResposta.getQuestao().getId());
            pstmt.setLong(4, questaoFechadaResposta.getSeqQuestaoResposta());
            
            pstmt.executeUpdate();
            
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
    
    @Override
    synchronized public void update(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia {
        try {
            
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE questaofechadaresposta "
                    + "SET "
                    + "seq_questao_resposta=? "
                    + " WHERE cod_usuario=? AND dat_inicio=? AND cod_questao=?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, questaoFechadaResposta.getSeqQuestaoResposta());
            pstmt.setLong(2, questaoFechadaResposta.getSessao().getUsuario().getId());
            pstmt.setTimestamp(3, java.sql.Timestamp.from(questaoFechadaResposta.getSessao().getDataInicio()));
            pstmt.setLong(4, questaoFechadaResposta.getQuestao().getId());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<QuestaoFechadaResposta> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questaofechadaresposta ORDER BY cod_usuario;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<QuestaoFechadaResposta> listAll = new ArrayList<>();
            SessaoDAO sessaoDAOImpl = SessaoDAOImpl.getInstance();
            QuestaoDAO questaoDAOImpl = QuestaoDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    QuestaoFechadaResposta questaoFechadaResposta = new QuestaoFechadaResposta();
                    
                    Sessao sessao = sessaoDAOImpl.getSessaoByUsuarioData(
                            rs.getLong("cod_usuario"), rs.getTimestamp("dat_inicio").toInstant());
                    questaoFechadaResposta.setSessao(sessao);
                    Questao questao = questaoDAOImpl.getQuestaoById(rs.getLong("cod_questao"));
                    questaoFechadaResposta.setQuestao(questao);
                    questaoFechadaResposta.setSeqQuestaoResposta(rs.getLong("seq_questao_resposta"));
                    listAll.add(questaoFechadaResposta);
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
    public List<QuestaoFechadaResposta> listAllByUsuarioSessao(Long cod_Usuario, Instant dat_Inicio) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questaofechadaresposta WHERE cod_usuario=? AND dat_inicio=? ORDER BY cod_questao;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Usuario);
            pstmt.setTimestamp(2, java.sql.Timestamp.from(dat_Inicio));
            ResultSet rs = pstmt.executeQuery();

            List<QuestaoFechadaResposta> listAll = new ArrayList<>();
            SessaoDAO sessaoDAOImpl = SessaoDAOImpl.getInstance();
            QuestaoDAO questaoDAOImpl = QuestaoDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    QuestaoFechadaResposta questaoFechadaResposta = new QuestaoFechadaResposta();
                    
                    Sessao sessao = sessaoDAOImpl.getSessaoByUsuarioData(
                            rs.getLong("cod_usuario"), rs.getTimestamp("dat_inicio").toInstant());
                    questaoFechadaResposta.setSessao(sessao);
                    Questao questao = questaoDAOImpl.getQuestaoById(rs.getLong("cod_questao"));
                    questaoFechadaResposta.setQuestao(questao);
                    questaoFechadaResposta.setSeqQuestaoResposta(rs.getLong("seq_questao_resposta"));
                    listAll.add(questaoFechadaResposta);
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
    public QuestaoFechadaResposta getByUsuarioSessaoQuestao(Long cod_Usuario, Instant dat_Inicio, Long cod_Questao) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questaofechadaresposta WHERE "
                    + "cod_usuario=? AND dat_inicio=? AND cod_questao=? ORDER BY cod_questao;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Usuario);
            pstmt.setTimestamp(2, java.sql.Timestamp.from(dat_Inicio));
            pstmt.setLong(3, cod_Questao);
            ResultSet rs = pstmt.executeQuery();
            
            QuestaoFechadaResposta questaoFechadaResposta = null;
            SessaoDAO sessaoDAOImpl = SessaoDAOImpl.getInstance();
            QuestaoDAO questaoDAOImpl = QuestaoDAOImpl.getInstance();
            if (rs.next()) {
                    questaoFechadaResposta = new QuestaoFechadaResposta();
                    
                    Sessao sessao = sessaoDAOImpl.getSessaoByUsuarioData(
                            rs.getLong("cod_usuario"), rs.getTimestamp("dat_inicio").toInstant());
                    questaoFechadaResposta.setSessao(sessao);
                    Questao questao = questaoDAOImpl.getQuestaoById(rs.getLong("cod_questao"));
                    questaoFechadaResposta.setQuestao(questao);
                    questaoFechadaResposta.setSeqQuestaoResposta(rs.getLong("seq_questao_resposta"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return questaoFechadaResposta;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    
}
