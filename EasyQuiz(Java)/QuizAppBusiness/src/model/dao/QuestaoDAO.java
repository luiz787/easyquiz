/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.domain.Questao;
import model.exception.ExcecaoPersistencia;

public interface QuestaoDAO {
    public void insert(Questao questao) throws ExcecaoPersistencia;
    public void update(Questao questao) throws ExcecaoPersistencia;
    public Questao delete(Long questaoId) throws ExcecaoPersistencia;
    public Questao getQuestaoById(Long questaoId) throws ExcecaoPersistencia;
    public List<Questao> listAll() throws ExcecaoPersistencia;
    public List<Questao> listAll(char tipo) throws ExcecaoPersistencia;
}
