/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.domain.Questao;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import java.util.List;
import model.domain.Questao;

/**
 *
 * @author Luiz
 */
public interface ManterQuestao {
    public Long cadastrarQuestao(Questao questao) throws ExcecaoPersistencia, ExcecaoNegocio;
    public boolean alterarQuestao(Questao questao) throws ExcecaoPersistencia, ExcecaoNegocio;
    public Questao deletarQuestao(Long cod_Questao) throws ExcecaoPersistencia;
    public Questao getQuestaoById(Long cod_Questao) throws ExcecaoPersistencia;
    public List<Questao> getAll() throws ExcecaoPersistencia;
    public List<Questao> getAll(char cod_Tipo) throws ExcecaoPersistencia;
}
