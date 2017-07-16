/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import java.time.Instant;
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
    public boolean cadastrarQuestaoFechadaResposta(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia, ExcecaoNegocio {
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
        boolean result = questaoFechadaRespostaDAO.insert(questaoFechadaResposta);
        return result;
    }
    
    @Override
    public boolean alterarQuestaoFechadaResposta(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia, ExcecaoNegocio {
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
        boolean result = questaoFechadaRespostaDAO.update(questaoFechadaResposta);
        return result;
    }
    
    @Override
    public List<QuestaoFechadaResposta> getAll() throws ExcecaoPersistencia {
        List<QuestaoFechadaResposta> result = questaoFechadaRespostaDAO.listAll();
        return result;
    }

    @Override
    public List<QuestaoFechadaResposta> getAllByUsuarioSessao(Long cod_Usuario, Instant dat_Inicio) throws ExcecaoPersistencia {
        List<QuestaoFechadaResposta> result = questaoFechadaRespostaDAO.listAllByUsuarioSessao(cod_Usuario, dat_Inicio);
        return result;
    }

    @Override
    public QuestaoFechadaResposta getByUsuarioSessaoQuestao(Long cod_Usuario, Instant dat_Inicio, Long cod_Questao) throws ExcecaoPersistencia {
        QuestaoFechadaResposta result = questaoFechadaRespostaDAO.getByUsuarioSessaoQuestao(cod_Usuario, dat_Inicio, cod_Questao);
        return result;
    }
}
