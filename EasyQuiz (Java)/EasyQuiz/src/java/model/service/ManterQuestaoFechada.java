/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.Questao;
import model.domain.QuestaoFechada;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public interface ManterQuestaoFechada {
    public void cadastrarQuestaoFechada(List<QuestaoFechada> questoesFechada) throws ExcecaoPersistencia, ExcecaoNegocio;
    public List<QuestaoFechada> deletarQuestaoFechada(Long cod_Questao) throws ExcecaoPersistencia;
    public List<QuestaoFechada> getAll(Long cod_Questao) throws ExcecaoPersistencia;
    public List<QuestaoFechada> getAll() throws ExcecaoPersistencia;
    
}
