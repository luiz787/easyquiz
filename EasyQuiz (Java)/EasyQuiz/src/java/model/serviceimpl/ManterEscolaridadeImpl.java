/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import java.util.List;
import model.dao.EscolaridadeDAO;
import model.domain.Escolaridade;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import model.service.ManterEscolaridade;

/**
 *
 * @author andro
 */
public class ManterEscolaridadeImpl implements ManterEscolaridade{
    private final EscolaridadeDAO escolaridadeDAO;
    
    public ManterEscolaridadeImpl(EscolaridadeDAO escolaridadeDAO) {
        this.escolaridadeDAO = escolaridadeDAO;
    }
    @Override
    public Escolaridade getEscolaridadeById(Long codEscolaridade) throws ExcecaoPersistencia, ExcecaoNegocio{
        if (codEscolaridade==null){
            throw new ExcecaoNegocio("Código não pode ser nulo.");
        }
        Escolaridade result = escolaridadeDAO.getEscolaridadeById(codEscolaridade);
        return result;
    }

    @Override
    public List<Escolaridade> getAll() throws ExcecaoPersistencia {
        List<Escolaridade> result = escolaridadeDAO.listAll();
        return result;
    }
}
