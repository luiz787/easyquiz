/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.QuestaoDAOImpl;
import model.domain.Questao;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public class JDBCConexaoMySQL implements JDBCFabricaConexao {
    private final static String Driver = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/quiz";
    private final static String usuario = "root";
    private final static String senha = "";

    public JDBCConexaoMySQL() {
    }

    @Override
    public Connection getConexao() throws ClassNotFoundException, SQLException {
        Class.forName(Driver);
        return DriverManager.getConnection(URL, usuario, senha);
    }
}
