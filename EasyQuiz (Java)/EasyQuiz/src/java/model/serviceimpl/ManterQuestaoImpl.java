/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import model.domain.Questao;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import java.util.List;
import model.dao.QuestaoDAO;
import model.daoimpl.QuestaoDAOImpl;
import model.domain.Questao;

/**
 *
 * @author Luiz
 */
public class ManterQuestaoImpl implements ManterQuestao {
    private final QuestaoDAO questaoDAO;
    
    public ManterQuestaoImpl(QuestaoDAO questaoDAO) {
        this.questaoDAO = questaoDAO;
    }

    @Override
    public void cadastrarQuestao(Questao questao) throws ExcecaoPersistencia, ExcecaoNegocio {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarQuestao(Questao questao) throws ExcecaoPersistencia, ExcecaoNegocio {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Questao deletarQuestao(Long cod_Questao) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Questao getQuestaoById(Long cod_Questao) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Questao> getAll() throws ExcecaoPersistencia {
        List<Questao> result = questaoDAO.listAll();
        return result;
    }

    @Override
    public List<Questao> getAll(char cod_Tipo) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
