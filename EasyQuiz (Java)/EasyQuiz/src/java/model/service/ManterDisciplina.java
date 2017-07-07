/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.Disciplina;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public interface ManterDisciplina {
    public void cadastrarDisciplina(Disciplina disciplina) throws ExcecaoPersistencia, ExcecaoNegocio;
    public void alterarDisciplina(Disciplina disciplina) throws ExcecaoPersistencia, ExcecaoNegocio;
    public Disciplina deletarDisciplina(Long cod_Disciplina) throws ExcecaoPersistencia;
    public Disciplina getDisciplinaById(Long cod_Disciplina) throws ExcecaoPersistencia;
    public List<Disciplina> getAll() throws ExcecaoPersistencia;
}
