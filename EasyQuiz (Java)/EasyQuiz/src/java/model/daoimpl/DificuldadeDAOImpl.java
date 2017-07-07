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
import model.dao.DificuldadeDAO;
import model.domain.Dificuldade;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;

/**
 *
 * @author andro
 */
public class DificuldadeDAOImpl implements DificuldadeDAO {
    private static DificuldadeDAOImpl dificuldadeDAO = null;

    private DificuldadeDAOImpl() {
    }

    public static DificuldadeDAOImpl getInstance() {

        if (dificuldadeDAO == null) {
            dificuldadeDAO = new DificuldadeDAOImpl();
        }

        return dificuldadeDAO;
    }

    @Override
    public Dificuldade getDificuldadeById(Long cod_Dificuldade) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM dificuldade WHERE cod_dificuldade = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Dificuldade);
            ResultSet rs = pstmt.executeQuery();

            Dificuldade dificuldade = null;
            if (rs.next()) {
                dificuldade = new Dificuldade();
                dificuldade.setCod_Dificuldade(rs.getLong("cod_dificuldade"));
                dificuldade.setDes_Dificuldade(rs.getString("des_dificuldade"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return dificuldade;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DificuldadeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Dificuldade> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM dificuldade ORDER BY cod_dificuldade;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Dificuldade> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    Dificuldade dificuldade = new Dificuldade();
                    dificuldade.setCod_Dificuldade(rs.getLong("cod_dificuldade"));
                    dificuldade.setDes_Dificuldade(rs.getString("des_dificuldade"));
                    listAll.add(dificuldade);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DificuldadeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
}
