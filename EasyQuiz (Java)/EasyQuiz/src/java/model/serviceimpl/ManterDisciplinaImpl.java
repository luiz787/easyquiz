/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.dao.DisciplinaDAO;
import model.domain.Disciplina;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public class ManterDisciplinaImpl implements ManterDisciplina {
    private final DisciplinaDAO disciplinaDAO;
    
    public ManterDisciplinaImpl(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }
    @Override
    public void cadastrarDisciplina(Disciplina disciplina) throws ExcecaoPersistencia, ExcecaoNegocio {
        disciplinaDAO.insert(disciplina);
    }

    @Override
    public void alterarDisciplina(Disciplina disciplina) throws ExcecaoPersistencia, ExcecaoNegocio {
        disciplinaDAO.update(disciplina);
    }

    @Override
    public Disciplina deletarDisciplina(Long cod_Disciplina) throws ExcecaoPersistencia {
        Disciplina result = disciplinaDAO.delete(cod_Disciplina);
        return result;
    }

    @Override
    public Disciplina getDisciplinaById(Long cod_Disciplina) throws ExcecaoPersistencia {
        Disciplina result = disciplinaDAO.getDisciplinaById(cod_Disciplina);
        return result;
    }

    @Override
    public List<Disciplina> getAll() throws ExcecaoPersistencia {
        List<Disciplina> result = disciplinaDAO.listAll();
        return result;
    }
}
