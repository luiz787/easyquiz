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
import java.util.ArrayList;
import model.dao.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.QuestaoFechadaResposta;
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
            String sql = "INSERT INTO questaoFechadaResposta (dat_inicio, cod_usuario, cod_questao, seq_questao_resposta) VALUES(?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setTimestamp(1, java.sql.Timestamp.from(questaoFechadaResposta.getDat_Inicio()));
            pstmt.setLong(2, questaoFechadaResposta.getCod_Usuario());
            pstmt.setLong(3, questaoFechadaResposta.getCod_Questao());
            pstmt.setLong(4, questaoFechadaResposta.getSeq_Questao_Resposta());
            
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

            String sql = "SELECT * FROM questaoFechadaResposta ORDER BY cod_usuario;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<QuestaoFechadaResposta> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    QuestaoFechadaResposta questaoFechadaResposta = new QuestaoFechadaResposta();
                    questaoFechadaResposta.setDat_Inicio((rs.getTimestamp("dat_inicio")).toInstant());
                    questaoFechadaResposta.setCod_Usuario(rs.getLong("cod_usuario"));
                    questaoFechadaResposta.setCod_Questao(rs.getLong("cod_questao"));
                    questaoFechadaResposta.setSeq_Questao_Resposta(rs.getLong("seq_questao_resposta"));
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
}
