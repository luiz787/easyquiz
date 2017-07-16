/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.time.Instant;
import java.util.List;
import model.domain.QuestaoFechadaResposta;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author aluno
 */
public interface ManterQuestaoFechadaResposta {
    public boolean cadastrarQuestaoFechadaResposta(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia, ExcecaoNegocio;
    public boolean alterarQuestaoFechadaResposta(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia, ExcecaoNegocio;
    public QuestaoFechadaResposta getByUsuarioSessaoQuestao(Long cod_Usuario, Instant dat_Inicio, Long cod_Questao) throws ExcecaoPersistencia;
    public List<QuestaoFechadaResposta> getAllByUsuarioSessao(Long cod_Usuario, Instant dat_Inicio) throws ExcecaoPersistencia;
    public List<QuestaoFechadaResposta> getAllByUsuarioPeriodo(Long cod_Usuario, Instant dat_Inicio, Instant dat_Fim) throws ExcecaoPersistencia;
    public List<QuestaoFechadaResposta> getAll() throws ExcecaoPersistencia;
}
