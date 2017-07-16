/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.domain.QuestaoFechada;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public interface QuestaoFechadaDAO {
    public Long insert(List<QuestaoFechada> questoesFechada) throws ExcecaoPersistencia;
    public List<QuestaoFechada> delete(Long cod_Questao) throws ExcecaoPersistencia;
    public List<QuestaoFechada> listAll(Long cod_Questao) throws ExcecaoPersistencia;
    public List<QuestaoFechada> listAll() throws ExcecaoPersistencia;
}
