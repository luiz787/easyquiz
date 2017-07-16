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
    public Long cadastrarDisciplina(Disciplina disciplina) throws ExcecaoPersistencia, ExcecaoNegocio;
    public boolean alterarDisciplina(Disciplina disciplina) throws ExcecaoPersistencia, ExcecaoNegocio;
    public Disciplina deletarDisciplina(Long cod_Disciplina) throws ExcecaoPersistencia, ExcecaoNegocio;
    public Disciplina getDisciplinaById(Long cod_Disciplina) throws ExcecaoPersistencia, ExcecaoNegocio;
    public List<Disciplina> getAll() throws ExcecaoPersistencia;
}
