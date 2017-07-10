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
import model.domain.Perfil;
import model.domain.Perfil;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;

/**
 *
 * @author Aluno
 */
public class PerfilDAOImpl implements PerfilDAO{
    private static PerfilDAOImpl perfilDAO = null;

    private PerfilDAOImpl() {
    }

    public static PerfilDAOImpl getInstance() {

        if (perfilDAO == null) {
            perfilDAO = new PerfilDAOImpl();
        }

        return perfilDAO;
    }

    @Override
    public Perfil getPerfilById(Long cod_Perfil) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM perfil WHERE cod_perfil = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Perfil);
            ResultSet rs = pstmt.executeQuery();

            Perfil perfil = null;
            if (rs.next()) {
                perfil = new Perfil();
                perfil.setId(rs.getLong("cod_perfil"));
                perfil.setNome(rs.getString("nom_perfil"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return perfil;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PerfilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Perfil> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM perfil ORDER BY cod_perfil;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Perfil> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    Perfil perfil = new Perfil();
                    perfil.setId(rs.getLong("cod_perfil"));
                    perfil.setNome(rs.getString("nom_perfil"));
                    listAll.add(perfil);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PerfilDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
}
