/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.domain.Disciplina;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public interface DisciplinaDAO {
    public Long insert(Disciplina disciplina) throws ExcecaoPersistencia;
    public boolean update(Disciplina disciplina) throws ExcecaoPersistencia;
    public Disciplina delete(Long cod_Disciplina) throws ExcecaoPersistencia;
    public Disciplina getDisciplinaById(Long cod_Disciplina) throws ExcecaoPersistencia;
    public List<Disciplina> listAll() throws ExcecaoPersistencia;
}
