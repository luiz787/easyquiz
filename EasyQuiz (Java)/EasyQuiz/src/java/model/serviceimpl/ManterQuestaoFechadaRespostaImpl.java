/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.dao.QuestaoFechadaRespostaDAO;
import model.domain.QuestaoFechadaResposta;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author aluno
 */
public class ManterQuestaoFechadaRespostaImpl implements ManterQuestaoFechadaResposta {
    private final QuestaoFechadaRespostaDAO questaoFechadaRespostaDAO;
    
    public ManterQuestaoFechadaRespostaImpl(QuestaoFechadaRespostaDAO questaoFechadaRespostaDAO) {
        this.questaoFechadaRespostaDAO = questaoFechadaRespostaDAO;
    }
    
    @Override
    public void cadastrarQuestaoFechadaResposta(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia, ExcecaoNegocio {
        questaoFechadaRespostaDAO.insert(questaoFechadaResposta);
    }

    @Override
    public List<QuestaoFechadaResposta> getAll() throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
