/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.domain.QuestaoFechadaResposta;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public interface QuestaoFechadaRespostaDAO {
    public void insert(QuestaoFechadaResposta questaoFechadaResposta) throws ExcecaoPersistencia;
    public List<QuestaoFechadaResposta> listAll() throws ExcecaoPersistencia;
}
