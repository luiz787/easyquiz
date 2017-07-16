/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.time.Instant;
import java.util.List;
import model.domain.QuestaoFechadaResposta;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public interface QuestaoFechadaRespostaDAO {
    public boolean insert(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia;
    public boolean update(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia;
    public QuestaoFechadaResposta getByUsuarioSessaoQuestao(Long cod_Usuario, Instant dat_Inicio, Long cod_Questao) throws ExcecaoPersistencia;
    public List<QuestaoFechadaResposta> listAllByUsuarioSessao(Long cod_Usuario, Instant dat_Inicio) throws ExcecaoPersistencia;
    public List<QuestaoFechadaResposta> listAllByUsuarioPeriodo(Long cod_Usuario, Instant dat_Inicio, Instant dat_Fim) throws ExcecaoPersistencia;
    public List<QuestaoFechadaResposta> listAll() throws ExcecaoPersistencia;
}
