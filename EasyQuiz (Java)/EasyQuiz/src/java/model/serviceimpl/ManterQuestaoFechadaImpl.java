/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.dao.QuestaoFechadaDAO;
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public class ManterQuestaoFechadaImpl implements ManterQuestaoFechada {
    private final QuestaoFechadaDAO questaoFechadaDAO;
    
    public ManterQuestaoFechadaImpl(QuestaoFechadaDAO questaoFechadaDAO) {
        this.questaoFechadaDAO = questaoFechadaDAO;
    }

    @Override
    public Long cadastrarQuestaoFechada(List<QuestaoFechada> questoesFechada) throws ExcecaoPersistencia, ExcecaoNegocio {
        Long result = questaoFechadaDAO.insert(questoesFechada);
        return result;
    }

    @Override
    public List<QuestaoFechada> deletarQuestaoFechada(Long cod_Questao) throws ExcecaoPersistencia {
        List<QuestaoFechada> result = questaoFechadaDAO.delete(cod_Questao);
        return result;
    }

    @Override
    public List<QuestaoFechada> getAll(Long cod_Questao) throws ExcecaoPersistencia {
        List<QuestaoFechada> result = questaoFechadaDAO.listAll(cod_Questao);
        return result;
    }

    @Override
    public List<QuestaoFechada> getAll() throws ExcecaoPersistencia {
        List<QuestaoFechada> result = questaoFechadaDAO.listAll();
        return result;
    }
    
}
