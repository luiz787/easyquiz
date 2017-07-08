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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ModuloDAO;
import model.domain.Modulo;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;


/**
 *
 * @author Aluno
 */
public class ModuloDAOImpl implements ModuloDAO {
    private static ModuloDAOImpl moduloDAO = null;

    private ModuloDAOImpl() {
    }

    public static ModuloDAOImpl getInstance() {

        if (moduloDAO == null) {
            moduloDAO = new ModuloDAOImpl();
        }

        return moduloDAO;
    }

    @Override
    synchronized public void insert(Modulo modulo) throws ExcecaoPersistencia {
        try {
            if (modulo == null) {
                throw new ExcecaoPersistencia("Entidade não pode ser nula.");
            }

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "INSERT INTO modulo (cod_disciplina, nom_modulo) VALUES(?, ?) RETURNING cod_modulo";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, modulo.getCod_Disciplina());
            pstmt.setString(2, modulo.getNom_Modulo());
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Long cod_modulo = rs.getLong("cod_modulo");
                modulo.setCod_Modulo(cod_modulo);
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
    synchronized public void update(Modulo modulo) throws ExcecaoPersistencia {
        try {
            
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "UPDATE modulo "
                    + "   SET nom_modulo = ?"
                    + " WHERE cod_modulo = ?;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(1, modulo.getNom_Modulo());
            pstmt.setLong(2, modulo.getCod_Modulo());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    synchronized public Modulo delete(Long cod_Modulo) throws ExcecaoPersistencia {
        try {
            Modulo modulo = this.getModuloById(cod_Modulo);

            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "DELETE FROM modulo WHERE cod_modulo = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            
            pstmt.setLong(1, cod_Modulo);
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return modulo;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public Modulo getModuloById(Long cod_Modulo) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM modulo WHERE cod_modulo = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Modulo);
            ResultSet rs = pstmt.executeQuery();

            Modulo modulo = null;
            if (rs.next()) {
                modulo = new Modulo();
                modulo.setCod_Disciplina(rs.getLong("cod_disciplina"));
                modulo.setCod_Modulo(rs.getLong("cod_modulo"));
                modulo.setNom_Modulo(rs.getString("des_modulo"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return modulo;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuestaoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Modulo> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM modulo ORDER BY cod_modulo;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Modulo> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    Modulo modulo = new Modulo();
                    modulo.setCod_Disciplina(rs.getLong("cod_disciplina"));
                    modulo.setCod_Modulo(rs.getLong("cod_modulo"));
                    modulo.setNom_Modulo(rs.getString("des_modulo"));
                    listAll.add(modulo);
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