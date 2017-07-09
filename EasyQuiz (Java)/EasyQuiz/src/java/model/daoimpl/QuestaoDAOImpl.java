
package model.daoimpl;

import model.domain.Questao;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;
import java.awt.image.BufferedImage;
import java.sql.Blob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DificuldadeDAO;
import model.dao.DisciplinaDAO;
import model.dao.ModuloDAO;
import model.dao.QuestaoDAO;
import model.domain.Dificuldade;
import model.domain.Disciplina;
import model.domain.Modulo;

public class QuestaoDAOImpl implements QuestaoDAO {
    private static QuestaoDAOImpl questaoDAO = null;

    private QuestaoDAOImpl() {
    }

    public static QuestaoDAOImpl getInstance() {

        if (questaoDAO == null) {
            questaoDAO = new QuestaoDAOImpl();
        }

        return questaoDAO;
    }

    @Override
    synchronized public void insert(Questao questao) throws ExcecaoPersistencia {
        try {
            if (questao == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO questao ("
                    + "cod_dificuldade, "
                    + "cod_disciplina, "
                    + "cod_modulo, "
                    + "cod_tipo, "
                    + "txt_enunciado, "
                    + "img_enunciado, "
                    + "seq_questao_correta, "
                    + "txt_resposta_aberta"
                    + ") VALUES(?, ?, ?, ?, ?, ?, ?, ?) RETURNING cod_questao";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, questao.getDificuldade().getCod_Dificuldade());
            pstmt.setLong(2, questao.getDisciplina().getCod_Disciplina());
            pstmt.setLong(3, questao.getModulo().getCod_Modulo());
            pstmt.setString(4, String.valueOf(questao.getCod_Tipo()));
            pstmt.setString(5, questao.getTxt_Enunciado());
            if(questao.getImg_Enunciado()!=null) {
                pstmt.setBlob(6, (Blob) questao.getImg_Enunciado());
            } else {
                pstmt.setNull(6, java.sql.Types.NULL);
            }
            if(questao.getSeq_Questao_Correta()!=null) {
                pstmt.setLong(7, questao.getSeq_Questao_Correta());
            } else {
                pstmt.setNull(7, java.sql.Types.NULL);
            }
            if(questao.getTxt_Resposta_Aberta()!=null) {
                pstmt.setString(8, questao.getTxt_Resposta_Aberta());
            } else {
                pstmt.setNull(8, java.sql.Types.NULL);
            }
            
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Long cod_questao = rs.getLong("cod_questao");
                questao.setCod_Questao(cod_questao);
            }

            rs.close();
            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    synchronized public void update(Questao questao) throws ExcecaoPersistencia {
        try {
            
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE questao "
                    + "SET "
                    + "cod_dificuldade=?, "
                    + "cod_disciplina=?, "
                    + "cod_modulo=?, "
                    + "cod_tipo=?, "
                    + "txt_enunciado=?, "
                    + "img_enunciado=?, "
                    + "seq_questao_correta=?, "
                    + "txt_resposta_aberta=?"
                    + " WHERE cod_questao = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, questao.getDificuldade().getCod_Dificuldade());
            pstmt.setLong(2, questao.getDisciplina().getCod_Disciplina());
            pstmt.setLong(3, questao.getModulo().getCod_Modulo());
            pstmt.setString(4, String.valueOf(questao.getCod_Tipo()));
            pstmt.setString(5, questao.getTxt_Enunciado());
            if(questao.getImg_Enunciado()!=null) {
                pstmt.setBlob(6, (Blob) questao.getImg_Enunciado());
            } else {
                pstmt.setNull(6, java.sql.Types.NULL);
            }
            if(questao.getSeq_Questao_Correta()!=null) {
                pstmt.setLong(7, questao.getSeq_Questao_Correta());
            } else {
                pstmt.setNull(7, java.sql.Types.NULL);
            }
            if(questao.getTxt_Resposta_Aberta()!=null) {
                pstmt.setString(8, questao.getTxt_Resposta_Aberta());
            } else {
                pstmt.setNull(8, java.sql.Types.NULL);
            }
            pstmt.setLong(9, questao.getCod_Questao());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    synchronized public Questao delete(Long cod_Questao) throws ExcecaoPersistencia {
        try {
            Questao questao = this.getQuestaoById(cod_Questao);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM questao WHERE cod_questao = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setLong(1, cod_Questao);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return questao;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public Questao getQuestaoById(Long cod_Questao) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questao WHERE cod_questao = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Questao);
            ResultSet rs = pstmt.executeQuery();
            
            Questao questao = null;
            DificuldadeDAO dificuldadeDAOImpl = DificuldadeDAOImpl.getInstance();
            DisciplinaDAO disciplinaDAOImpl = DisciplinaDAOImpl.getInstance();
            ModuloDAO moduloDAOImpl = ModuloDAOImpl.getInstance();
            if (rs.next()) {
                questao = new Questao();
                questao.setCod_Questao(rs.getLong("cod_questao"));
                Dificuldade dificuldade = dificuldadeDAOImpl.getDificuldadeById(rs.getLong("cod_dificuldade"));
                questao.setDificuldade(dificuldade);
                Disciplina disciplina = disciplinaDAOImpl.getDisciplinaById(rs.getLong("cod_disciplina"));
                questao.setDisciplina(disciplina);
                Modulo modulo = moduloDAOImpl.getModuloById(rs.getLong("cod_modulo"));
                questao.setModulo(modulo);
                questao.setCod_Tipo(rs.getString("cod_tipo").charAt(0));
                questao.setTxt_Enunciado(rs.getString("txt_enunciado"));
                questao.setImg_Enunciado((BufferedImage) rs.getBlob("img_enunciado"));
                questao.setSeq_Questao_Correta(rs.getLong("seq_questao_correta"));
                questao.setTxt_Resposta_Aberta(rs.getString("txt_resposta_aberta"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return questao;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Questao> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questao ORDER BY cod_questao;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Questao> listAll = new ArrayList<>();
            DificuldadeDAO dificuldadeDAOImpl = DificuldadeDAOImpl.getInstance();
            DisciplinaDAO disciplinaDAOImpl = DisciplinaDAOImpl.getInstance();
            ModuloDAO moduloDAOImpl = ModuloDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    Questao questao = new Questao();
                    questao.setCod_Questao(rs.getLong("cod_questao"));
                    Dificuldade dificuldade = dificuldadeDAOImpl.getDificuldadeById(rs.getLong("cod_dificuldade"));
                    questao.setDificuldade(dificuldade);
                    Disciplina disciplina = disciplinaDAOImpl.getDisciplinaById(rs.getLong("cod_disciplina"));
                    questao.setDisciplina(disciplina);
                    Modulo modulo = moduloDAOImpl.getModuloById(rs.getLong("cod_modulo"));
                    questao.setModulo(modulo);
                    questao.setCod_Tipo(rs.getString("cod_tipo").charAt(0));
                    questao.setTxt_Enunciado(rs.getString("txt_enunciado"));
                    questao.setImg_Enunciado((BufferedImage) rs.getBlob("img_enunciado"));
                    questao.setSeq_Questao_Correta(rs.getLong("seq_questao_correta"));
                    questao.setTxt_Resposta_Aberta(rs.getString("txt_resposta_aberta"));
                    listAll.add(questao);
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
    
    public List<Questao> listAll(char tipo) throws ExcecaoPersistencia {
        try {
            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questao WHERE Tipo = ? ORDER BY cod_questao;";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(tipo));
            ResultSet rs = pstmt.executeQuery();

            List<Questao> listAll = new ArrayList<>();
            DificuldadeDAO dificuldadeDAOImpl = DificuldadeDAOImpl.getInstance();
            DisciplinaDAO disciplinaDAOImpl = DisciplinaDAOImpl.getInstance();
            ModuloDAO moduloDAOImpl = ModuloDAOImpl.getInstance();
            if (rs.next()) {
                do {
                    Questao questao = new Questao();
                    questao.setCod_Questao(rs.getLong("cod_questao"));
                    Dificuldade dificuldade = dificuldadeDAOImpl.getDificuldadeById(rs.getLong("cod_dificuldade"));
                    questao.setDificuldade(dificuldade);
                    Disciplina disciplina = disciplinaDAOImpl.getDisciplinaById(rs.getLong("cod_disciplina"));
                    questao.setDisciplina(disciplina);
                    Modulo modulo = moduloDAOImpl.getModuloById(rs.getLong("cod_modulo"));
                    questao.setModulo(modulo);
                    questao.setCod_Tipo(rs.getString("cod_tipo").charAt(0));
                    questao.setTxt_Enunciado(rs.getString("txt_enunciado"));
                    questao.setImg_Enunciado((BufferedImage) rs.getBlob("img_enunciado"));
                    questao.setSeq_Questao_Correta(rs.getLong("seq_questao_correta"));
                    questao.setTxt_Resposta_Aberta(rs.getString("txt_resposta_aberta"));
                    listAll.add(questao);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            conexao.close();

            return listAll;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
}
