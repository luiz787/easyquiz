
package model.dao;

import model.domain.Questao;
import model.exception.ExcecaoPersistencia;
import inf.util.db.JDBCManterConexao;
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
import model.domain.QuestaoAberta;
import model.domain.QuestaoFechada;

public class QuestaoDAOImpl implements QuestaoDAO {
    private static QuestaoDAOImpl questaoDAO = null;

    private QuestaoDAOImpl() {
    }

    public static QuestaoDAOImpl getInstancia() {

        if (questaoDAO == null) {
            questaoDAO = new QuestaoDAOImpl();
        }

        return questaoDAO;
    }

    synchronized public void insert(Questao questao) throws ExcecaoPersistencia {
        try {
            if (questao == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();
            
            String sql = "INSERT INTO questao (Enunciado, Imagem, Dificuldade, Disciplina, Tipo) VALUES (?,?,?,?,?)";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            pstmt.setString(1, questao.getEnunciado());
            pstmt.setBlob(2, (Blob) questao.getImagem());
            pstmt.setInt(3, questao.getDificuldade());
            pstmt.setString(4, questao.getDisciplina());
            pstmt.setString(5, String.valueOf(questao.getTipo()));
            
            ResultSet rs;
            
            if(questao instanceof QuestaoAberta) {
                pstmt.executeUpdate();
                rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() FROM questao");
                if (rs.next()) {
                    long id = (long) rs.getInt(1);
                    questao.setId(id);
                }
                sql = "INSERT INTO questao_aberta (Id, Resposta) "
                        + "VALUES (?,?)";
                pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, (int) questao.getId().longValue());
                pstmt.setString(2, ((QuestaoAberta)questao).getResposta());
                pstmt.executeUpdate();
            } else if(questao instanceof QuestaoFechada) {
                pstmt.executeUpdate();
                rs = pstmt.executeQuery("SELECT LAST_INSERT_ID() FROM questao");
                if (rs.next()) {
                    long id = (long) rs.getInt(1);
                    questao.setId(id);
                }
                sql = "INSERT INTO questao_fechada (Id, Alternativas, "
                        + "Alternativa_Correta)"
                        + " VALUES (?,?,?)";
                pstmt = conexao.prepareStatement(sql);
                
                String[] alternativas = ((QuestaoFechada)questao).getAlternativas();
                String alternativasTexto = "";
                for(int i=0; i<alternativas.length; i++) {
                    if(i!=(alternativas.length-1)) {
                        alternativasTexto += alternativas[i]+"_;_";
                    } else {
                        alternativasTexto += alternativas[i];
                    }
                }
                
                pstmt.setInt(1, (int) questao.getId().longValue());
                pstmt.setString(2, alternativasTexto);
                pstmt.setInt(3, ((QuestaoFechada)questao).getAlternativaCorreta());
                pstmt.executeUpdate();
            } else {
                throw new ClassNotFoundException();
            }
            //System.out.println(questao.getId());
            
            rs.close();
            pstmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    synchronized public void update(Questao questao) throws ExcecaoPersistencia {
        try {

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE questao SET Enunciado = ?, Imagem = ?, Dificuldade = ?, Disciplina = ?, Tipo = ? WHERE Id = ?; ";

            PreparedStatement pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, questao.getEnunciado());
            pstmt.setBlob(2, (Blob) questao.getImagem());
            pstmt.setInt(3, questao.getDificuldade());
            pstmt.setString(4, questao.getDisciplina());
            pstmt.setString(5, String.valueOf(questao.getTipo()));
            
            pstmt.setInt(6, (int) questao.getId().longValue());
            
            if(questao instanceof QuestaoAberta) {
                pstmt.executeUpdate();
                sql = "UPDATE questao_aberta SET Resposta = ? "
                        + "WHERE id = ?;";
                pstmt = conexao.prepareStatement(sql);
                pstmt.setString(1, ((QuestaoAberta)questao).getResposta());
                pstmt.setInt(2, (int) questao.getId().longValue());
                pstmt.executeUpdate();
            } else if(questao instanceof QuestaoFechada) {
                pstmt.executeUpdate();
                sql = "UPDATE questao_fechada SET Alternativas = ?, "
                        + "Alternativa_Correta = ?"
                        + " WHERE id = ?;";
                pstmt = conexao.prepareStatement(sql);
                String[] alternativas = ((QuestaoFechada)questao).getAlternativas();
                String alternativasTexto = "";
                for(int i=0; i<alternativas.length; i++) {
                    if(i!=(alternativas.length-1)) {
                        alternativasTexto += alternativas[i]+"_;_";
                    } else {
                        alternativasTexto += alternativas[i];
                    }
                }
                pstmt.setString(1, alternativasTexto);
                pstmt.setInt(2, ((QuestaoFechada)questao).getAlternativaCorreta());
                pstmt.setInt(3, (int) questao.getId().longValue());
                pstmt.executeUpdate();
            } else {
                throw new ClassNotFoundException();
            }

            pstmt.close();
            conexao.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    synchronized public Questao delete(Long questaoId) throws ExcecaoPersistencia {
        try {
            Questao questao = this.getQuestaoById(questaoId);

            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM questao WHERE Id = ?";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, (int) questaoId.longValue());
            
            if(questao instanceof QuestaoAberta) {
                pstmt.executeUpdate();
                sql = "DELETE FROM questao_aberta WHERE Id = ?";
                pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, (int) questaoId.longValue());
                pstmt.executeUpdate();
            } else if(questao instanceof QuestaoFechada) {
                pstmt.executeUpdate();
                sql = "DELETE FROM questao_fechada WHERE Id = ?";
                pstmt = conexao.prepareStatement(sql);
                pstmt.setInt(1, (int) questaoId.longValue());
                pstmt.executeUpdate();
            } else {
                throw new ClassNotFoundException();
            }

            pstmt.close();
            conexao.close();
            
            return questao;
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    public Questao getQuestaoById(Long questaoId) throws ExcecaoPersistencia {
        try {
            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questao WHERE Id = ?";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, (int) questaoId.longValue());
            
            ResultSet rs = pstmt.executeQuery();

            Questao questao = null;
            if (rs.next()) {
                if(rs.getString("Tipo").charAt(0)=='A') {
                    questao = new QuestaoAberta();
                    questao.setId(rs.getLong("Id"));
                    questao.setEnunciado(rs.getString("Enunciado"));
                    questao.setImagem((BufferedImage)rs.getBlob("Imagem"));
                    questao.setDificuldade(rs.getInt("Dificuldade"));
                    questao.setDisciplina(rs.getString("Disciplina"));
                    questao.setTipo(rs.getString("Tipo").charAt(0));
                    sql = "SELECT * FROM questao_aberta WHERE Id = ?";
                    pstmt = conexao.prepareStatement(sql);
                    pstmt.setInt(1, (int) questaoId.longValue());
                    ResultSet rsAberta = pstmt.executeQuery();
                    if (rsAberta.next()) {
                        ((QuestaoAberta)questao).setResposta(rsAberta.getString("Resposta"));
                    }
                    rsAberta.close();
                } else {
                    questao = new QuestaoFechada();
                    questao.setId(rs.getLong("Id"));
                    questao.setEnunciado(rs.getString("Enunciado"));
                    questao.setImagem((BufferedImage)rs.getBlob("Imagem"));
                    questao.setDificuldade(rs.getInt("Dificuldade"));
                    questao.setDisciplina(rs.getString("Disciplina"));
                    questao.setTipo(rs.getString("Tipo").charAt(0));
                    sql = "SELECT * FROM questao_fechada WHERE Id = ?";
                    pstmt = conexao.prepareStatement(sql);
                    pstmt.setInt(1, (int) questaoId.longValue());
                    ResultSet rsFechada = pstmt.executeQuery();
                    if (rsFechada.next()) {
                        ((QuestaoFechada)questao).setAlternativas(rsFechada.getString("Alternativas").split("_;_"));
                        ((QuestaoFechada)questao).setAlternativaCorreta(rsFechada.getInt("Alternativa_Correta"));
                    }
                    rsFechada.close();
                }
            }

            rs.close();
            pstmt.close();
            conexao.close();

            return questao;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    public List<Questao> listAll() throws ExcecaoPersistencia {
        try {
            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questao ORDER BY Id;";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Questao> listAll = new ArrayList<>();
            Questao questao = null;
            if (rs.next()) {
                do {
                    if(rs.getString("Tipo").charAt(0)=='A') {
                        questao = new QuestaoAberta();
                        questao.setId((long) rs.getInt("Id"));
                        questao.setEnunciado(rs.getString("Enunciado"));
                        questao.setImagem((BufferedImage)rs.getBlob("Imagem"));
                        questao.setDificuldade(rs.getInt("Dificuldade"));
                        questao.setDisciplina(rs.getString("Disciplina"));
                        questao.setTipo(rs.getString("Tipo").charAt(0));
                        sql = "SELECT * FROM questao_aberta WHERE Id = ?";
                        pstmt = conexao.prepareStatement(sql);
                        pstmt.setInt(1, rs.getInt("Id"));
                        ResultSet rsAberta = pstmt.executeQuery();
                        if (rsAberta.next()) {
                            ((QuestaoAberta)questao).setResposta(rsAberta.getString("Resposta"));
                        }
                        rsAberta.close();
                        listAll.add(questao);
                    } else {
                        questao = new QuestaoFechada();
                        questao.setId((long) rs.getInt("Id"));
                        questao.setEnunciado(rs.getString("Enunciado"));
                        questao.setImagem((BufferedImage)rs.getBlob("Imagem"));
                        questao.setDificuldade(rs.getInt("Dificuldade"));
                        questao.setDisciplina(rs.getString("Disciplina"));
                        questao.setTipo(rs.getString("Tipo").charAt(0));
                        sql = "SELECT * FROM questao_fechada WHERE Id = ?";
                        pstmt = conexao.prepareStatement(sql);
                        pstmt.setInt(1, rs.getInt("Id"));
                        ResultSet rsFechada = pstmt.executeQuery();
                        if (rsFechada.next()) {
                            ((QuestaoFechada)questao).setAlternativas(rsFechada.getString("Alternativas").split("_;_"));
                            ((QuestaoFechada)questao).setAlternativaCorreta(rsFechada.getInt("Alternativa_Correta"));
                        }
                        rsFechada.close();
                        listAll.add(questao);
                    }
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
    
    public List<Questao> listAll(char tipo) throws ExcecaoPersistencia {
        try {
            Connection conexao = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM questao WHERE Tipo = ? ORDER BY Id;";

            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(tipo));
            ResultSet rs = pstmt.executeQuery();

            List<Questao> listAll = new ArrayList<>();
            Questao questao = null;
            if (rs.next()) {
                do {
                    if(rs.getString("Tipo").charAt(0)=='A') {
                        questao = new QuestaoAberta();
                        questao.setId((long) rs.getInt("Id"));
                        questao.setEnunciado(rs.getString("Enunciado"));
                        questao.setImagem((BufferedImage)rs.getBlob("Imagem"));
                        questao.setDificuldade(rs.getInt("Dificuldade"));
                        questao.setDisciplina(rs.getString("Disciplina"));
                        questao.setTipo(rs.getString("Tipo").charAt(0));
                        sql = "SELECT * FROM questao_aberta WHERE Id = ?";
                        pstmt = conexao.prepareStatement(sql);
                        pstmt.setInt(1, rs.getInt("Id"));
                        ResultSet rsAberta = pstmt.executeQuery();
                        if (rsAberta.next()) {
                            ((QuestaoAberta)questao).setResposta(rsAberta.getString("Resposta"));
                        }
                        rsAberta.close();
                        listAll.add(questao);
                    } else {
                        questao = new QuestaoFechada();
                        questao.setId((long) rs.getInt("Id"));
                        questao.setEnunciado(rs.getString("Enunciado"));
                        questao.setImagem((BufferedImage)rs.getBlob("Imagem"));
                        questao.setDificuldade(rs.getInt("Dificuldade"));
                        questao.setDisciplina(rs.getString("Disciplina"));
                        questao.setTipo(rs.getString("Tipo").charAt(0));
                        sql = "SELECT * FROM questao_fechada WHERE Id = ?";
                        pstmt = conexao.prepareStatement(sql);
                        pstmt.setInt(1, rs.getInt("Id"));
                        ResultSet rsFechada = pstmt.executeQuery();
                        if (rsFechada.next()) {
                            ((QuestaoFechada)questao).setAlternativas(rsFechada.getString("Alternativas").split("_;_"));
                            ((QuestaoFechada)questao).setAlternativaCorreta(rsFechada.getInt("Alternativa_Correta"));
                        }
                        rsFechada.close();
                        listAll.add(questao);
                    }
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
