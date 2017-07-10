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
        String errMsg = null;
        if (questaoFechadaResposta == null){
            throw new ExcecaoNegocio("A objeto resposta não pode ser nulo.");
        } else {
            if (questaoFechadaResposta.getSeqQuestaoResposta()==null){
                errMsg+="A resposta não pode ser nula. ";
            }
            if (questaoFechadaResposta.getSessao()==null){
                errMsg+="A resposta deve pertencer a uma sessão. ";
            }
            if (questaoFechadaResposta.getQuestao()==null){
                errMsg+="A resposta deve pertencer a uma questão. ";
            }
        }
        if (errMsg!=null){
            throw new ExcecaoNegocio(errMsg);
        }
        questaoFechadaRespostaDAO.insert(questaoFechadaResposta);
    }

    @Override
    public List<QuestaoFechadaResposta> getAll() throws ExcecaoPersistencia {
        return questaoFechadaRespostaDAO.listAll();
    }
}
