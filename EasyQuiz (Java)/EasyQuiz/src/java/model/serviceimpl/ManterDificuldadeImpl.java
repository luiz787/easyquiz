/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.dao.DificuldadeDAO;
import model.domain.Dificuldade;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public class ManterDificuldadeImpl implements ManterDificuldade {
    private final DificuldadeDAO dificuldadeDAO;
    
    public ManterDificuldadeImpl(DificuldadeDAO dificuldadeDAO) {
        this.dificuldadeDAO = dificuldadeDAO;
    }
    @Override
    public Dificuldade getDificuldadeById(Long codDificuldade) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (codDificuldade == null){
            throw new ExcecaoNegocio("Código da dificuldade não pode ser nulo.");
        }
        Dificuldade result = dificuldadeDAO.getDificuldadeById(codDificuldade);
        return result;
    }

    @Override
    public List<Dificuldade> listAll() throws ExcecaoPersistencia {
        List<Dificuldade> result = dificuldadeDAO.listAll();
        return result;
    }
}
