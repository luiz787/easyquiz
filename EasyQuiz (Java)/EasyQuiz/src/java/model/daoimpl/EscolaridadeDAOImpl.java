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
import model.dao.EscolaridadeDAO;
import model.domain.Escolaridade;
import model.exception.ExcecaoPersistencia;
import util.db.JDBCManterConexao;

/**
 *
 * @author andro
 */
public class EscolaridadeDAOImpl implements EscolaridadeDAO{
    private static EscolaridadeDAOImpl escolaridadeDAO = null;

    private EscolaridadeDAOImpl() {
    }

    public static EscolaridadeDAOImpl getInstance() {

        if (escolaridadeDAO == null) {
            escolaridadeDAO = new EscolaridadeDAOImpl();
        }

        return escolaridadeDAO;
    }

    @Override
    public Escolaridade getEscolaridadeById(Long cod_Escolaridade) throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM escolaridade WHERE cod_escolaridade = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, cod_Escolaridade);
            ResultSet rs = pstmt.executeQuery();

            Escolaridade escolaridade = null;
            if (rs.next()) {
                escolaridade = new Escolaridade();
                escolaridade.setId(rs.getLong("cod_escolaridade"));
                escolaridade.setNome(rs.getString("nom_escolaridade"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return escolaridade;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EscolaridadeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }

    @Override
    public List<Escolaridade> listAll() throws ExcecaoPersistencia {
        try {
            Connection connection = JDBCManterConexao.getInstancia().getConexao();

            String sql = "SELECT * FROM escolaridade ORDER BY cod_escolaridade;";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Escolaridade> listAll = new ArrayList<>();
            if (rs.next()) {
                do {
                    Escolaridade escolaridade = new Escolaridade();
                    escolaridade.setId(rs.getLong("cod_escolaridade"));
                    escolaridade.setNome(rs.getString("nom_escolaridade"));
                    listAll.add(escolaridade);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EscolaridadeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcecaoPersistencia(ex);
        }
    }
}
