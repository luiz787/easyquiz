/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.dao.ModuloDAO;
import model.domain.Modulo;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public class ManterModuloImpl implements ManterModulo {
    private final ModuloDAO moduloDAO;
    
    public ManterModuloImpl(ModuloDAO moduloDAO) {
        this.moduloDAO = moduloDAO;
    }
    @Override
    public Long cadastrarModulo(Modulo modulo) throws ExcecaoPersistencia, ExcecaoNegocio {
        String errMsg = null;
        if (modulo == null) {
            throw new ExcecaoNegocio("Módulo não pode ser nulo.");
        } else {
            if (modulo.getNome()==null){
                errMsg+="O módulo deve possuir um nome. ";
            }
            if (modulo.getDisciplina()==null){
                errMsg+="O módulo deve estar associado a uma disciplina. ";
            }
        }
        if (errMsg!=null){
            throw new ExcecaoNegocio(errMsg);
        }
        
        Long result = moduloDAO.insert(modulo);
        return result;
    }

    @Override
    public boolean alterarModulo(Modulo modulo) throws ExcecaoPersistencia, ExcecaoNegocio {
        String errMsg = null;
        if (modulo == null) {
            throw new ExcecaoNegocio("Módulo não pode ser nulo.");
        } else {
            if (modulo.getNome()==null){
                errMsg+="O módulo deve possuir um nome. ";
            }
            if (modulo.getDisciplina()==null){
                errMsg+="O módulo deve estar associado a uma disciplina. ";
            }
        }
        if (errMsg!=null){
            throw new ExcecaoNegocio(errMsg);
        }
        boolean result = moduloDAO.update(modulo);
        return result;
    }

    @Override
    public Modulo deletarModulo(Long codModulo) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (codModulo == null){
            throw new ExcecaoNegocio("Código não pode ser nulo.");
        }
        Modulo result = moduloDAO.delete(codModulo);
        return result;
    }

    @Override
    public Modulo getModuloById(Long codModulo) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (codModulo == null){
            throw new ExcecaoNegocio("Código não pode ser nulo.");
        }
        Modulo result = moduloDAO.getModuloById(codModulo);
        return result;
    }

    @Override
    public List<Modulo> getAll() throws ExcecaoPersistencia {
        List<Modulo> result = moduloDAO.listAll();
        return result;
    }
}
