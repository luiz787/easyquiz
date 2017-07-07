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
import model.domain.Disciplina;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;

/**
 *
 * @author Aluno
 */
public class DisciplinaDAOImpl implements DisciplinaDAO{
    private static DisciplinaDAOImpl disciplinaDAO = null;

    private DisciplinaDAOImpl() {
    }

    public static DisciplinaDAOImpl getInstance() {

        if (disciplinaDAO == null) {
            disciplinaDAO = new DisciplinaDAOImpl();
        }

        return disciplinaDAO;
    }

    @Override
    synchronized public void insert(Disciplina disciplina) throws ExcecaoPersistencia {
        try {
            if (disciplina == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO disciplina (nom_disciplina) VALUES(?) RETURNING cod_disciplina";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, disciplina.getNom_Disciplina());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Long cod_disciplina = rs.getLong("cod_disciplina");
                disciplina.setCod_Disciplina(cod_disciplina);
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
    synchronized public void update(Disciplina disciplina) throws ExcecaoPersistencia {
        try {
            
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE disciplina "
                    + "   SET nom_disciplina  = ?"
                    + " WHERE cod_disciplina = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(1, disciplina.getNom_Disciplina());
            pstmt.setLong(2, disciplina.getCod_Disciplina());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    synchronized public Disciplina delete(Long cod_Disciplina) throws ExcecaoPersistencia {
        try {
            Disciplina disciplina = this.getDisciplinaById(cod_Disciplina);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM disciplina WHERE cod_disciplina = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setLong(1, cod_Disciplina);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return disciplina;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public Disciplina getDisciplinaById(Long cod_Disciplina) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM disciplina WHERE cod_disciplina = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Disciplina);
            ResultSet rs = pstmt.executeQuery();

            Disciplina disciplina = null;
            if (rs.next()) {
                disciplina = new Disciplina();
                disciplina.setCod_Disciplina(rs.getLong("cod_disciplina"));
                disciplina.setNom_Disciplina(rs.getString("des_disciplina"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return disciplina;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Disciplina> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM disciplina ORDER BY cod_disciplina;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Disciplina> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    Disciplina disciplina = new Disciplina();
                    disciplina.setCod_Disciplina(rs.getLong("cod_disciplina"));
                    disciplina.setNom_Disciplina(rs.getString("nom_disciplina"));
                    listAll.add(disciplina);
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
