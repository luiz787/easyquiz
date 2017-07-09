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
    public void cadastrarModulo(Modulo modulo) throws ExcecaoPersistencia, ExcecaoNegocio {
        moduloDAO.insert(modulo);
    }

    @Override
    public void alterarModulo(Modulo modulo) throws ExcecaoPersistencia, ExcecaoNegocio {
        moduloDAO.update(modulo);
    }

    @Override
    public Modulo deletarModulo(Long cod_Modulo) throws ExcecaoPersistencia {
        Modulo result = moduloDAO.delete(cod_Modulo);
        return result;
    }

    @Override
    public Modulo getModuloById(Long cod_Modulo) throws ExcecaoPersistencia {
        Modulo result = moduloDAO.getModuloById(cod_Modulo);
        return result;
    }

    @Override
    public List<Modulo> getAll() throws ExcecaoPersistencia {
        List<Modulo> result = moduloDAO.listAll();
        return result;
    }
}
