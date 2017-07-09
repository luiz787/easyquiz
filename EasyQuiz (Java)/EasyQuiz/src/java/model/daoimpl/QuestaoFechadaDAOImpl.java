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
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;

/**
 *
 * @author Aluno
 */
public class QuestaoFechadaDAOImpl implements QuestaoFechadaDAO {
    private static QuestaoFechadaDAOImpl questaoFechadaDAO = null;

    private QuestaoFechadaDAOImpl() {
    }

    public static QuestaoFechadaDAOImpl getInstance() {

        if (questaoFechadaDAO == null) {
            questaoFechadaDAO = new QuestaoFechadaDAOImpl();
        }

        return questaoFechadaDAO;
    }

    @Override
    synchronized public void insert(List<QuestaoFechada> questaoFechada) throws ExcecaoPersistencia {
        try {
            if (questaoFechada.isEmpty() || questaoFechada==null) {
                throw new ExcecaoPersistencia("Entidade não pode ser vazia ou nula.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO questao_fechada (cod_questao, seq_alternativa, txt_alternativa) VALUES(?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            for(int i=0; i<questaoFechada.size(); i++) {
                pstmt.setLong(1, questaoFechada.get(i).getQuestao().getCod_Questao());
                pstmt.setLong(2, questaoFechada.get(i).getSeq_Alternativa());
                pstmt.setString(3, questaoFechada.get(i).getTxt_Alternativa());
            }
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }


    @Override
    synchronized public List<QuestaoFechada> delete(Long cod_Questao) throws ExcecaoPersistencia {
        try {
            List<QuestaoFechada> questoesFechada = this.listAll(cod_Questao);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM questao_fechada WHERE cod_questao = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setLong(1, cod_Questao);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return questoesFechada;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<QuestaoFechada> listAll(Long cod_Questao) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questao_fechada WHERE cod_questao = ? ORDER BY seq_alternativa;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Questao);
            ResultSet rs = pstmt.executeQuery();

            List<QuestaoFechada> listAll = new ArrayList<>();
            QuestaoDAO questaoDAOImpl = QuestaoDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    QuestaoFechada questaoFechada = new QuestaoFechada();
                    Questao questao = questaoDAOImpl.getQuestaoById(rs.getLong("cod_questao"));
                    questaoFechada.setQuestao(questao);
                    questaoFechada.setSeq_Alternativa(rs.getLong("seq_alternativa"));
                    questaoFechada.setTxt_Alternativa(rs.getString("txt_alternativa"));
                    listAll.add(questaoFechada);
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
    public List<QuestaoFechada> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questao_fechada ORDER BY cod_questao;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<QuestaoFechada> listAll = new ArrayList<>();
            QuestaoDAO questaoDAOImpl = QuestaoDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    QuestaoFechada questaoFechada = new QuestaoFechada();
                    Questao questao = questaoDAOImpl.getQuestaoById(rs.getLong("cod_questao"));
                    questaoFechada.setQuestao(questao);
                    questaoFechada.setSeq_Alternativa(rs.getLong("seq_alternativa"));
                    questaoFechada.setTxt_Alternativa(rs.getString("txt_alternativa"));
                    listAll.add(questaoFechada);
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
