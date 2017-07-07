/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.QuestaoFechadaResposta;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author aluno
 */
public interface ManterQuestaoFechadaResposta {
    public void cadastrarQuestaoFechadaResposta(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia, ExcecaoNegocio;
    public List<QuestaoFechadaResposta> getAll() throws ExcecaoPersistencia;
}
