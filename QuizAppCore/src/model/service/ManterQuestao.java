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

/**
 *
 * @author Luiz
 */
public interface ManterQuestao {
    public Long cadastrarQuestao(Questao questao) throws ExcecaoNegocio, ExcecaoPersistencia;
    public void alterarQuestao(Questao questao) throws ExcecaoNegocio, ExcecaoPersistencia;
    public void deletarQuestao(Questao questao) throws ExcecaoPersistencia;
    public Questao getQuestaoById(Long id) throws ExcecaoPersistencia;
    public List<Questao> listAll() throws ExcecaoPersistencia;
}
