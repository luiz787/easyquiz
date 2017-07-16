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
    public Long cadastrarDisciplina(Disciplina disciplina) throws ExcecaoPersistencia, ExcecaoNegocio {
        String errMsg = null;
        if (disciplina == null) {
            throw new ExcecaoNegocio("Disciplina não pode ser nula.");
        } else {
            if (disciplina.getNome()==null){
                errMsg+="A disciplina deve possuir um nome.";
            }
        }
        if (errMsg!=null){
            throw new ExcecaoNegocio(errMsg);
        }
        
        Long result = disciplinaDAO.insert(disciplina);
        return result;
    }

    @Override
    public boolean alterarDisciplina(Disciplina disciplina) throws ExcecaoPersistencia, ExcecaoNegocio {
        String errMsg = null;
        if (disciplina == null){
            throw new ExcecaoNegocio("Disciplina não pode ser nula.");
        } else {
            if (disciplina.getNome()==null){
                errMsg+="A disciplina deve possuir um nome.";
            }
        }
        if (errMsg!=null){
            throw new ExcecaoNegocio(errMsg);
        }
        
        boolean result = disciplinaDAO.update(disciplina);
        return result;
    }

    @Override
    public Disciplina deletarDisciplina(Long codDisciplina) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (codDisciplina == null){
            throw new ExcecaoNegocio("Código não pode ser nulo.");
        }
        Disciplina result = disciplinaDAO.delete(codDisciplina);
        return result;
    }

    @Override
    public Disciplina getDisciplinaById(Long codDisciplina) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (codDisciplina == null){
            throw new ExcecaoNegocio("Código não pode ser nulo.");
        }
        Disciplina result = disciplinaDAO.getDisciplinaById(codDisciplina);
        return result;
    }

    @Override
    public List<Disciplina> getAll() throws ExcecaoPersistencia {
        List<Disciplina> result = disciplinaDAO.listAll();
        return result;
    }
}
