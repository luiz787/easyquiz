/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.dao.PerfilDAO;
import model.domain.Perfil;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public class ManterPerfilImpl implements ManterPerfil {
    private final PerfilDAO perfilDAO;
    
    public ManterPerfilImpl(PerfilDAO perfilDAO) {
        this.perfilDAO = perfilDAO;
    }
    @Override
    public Perfil getPerfilById(Long codPerfil) throws ExcecaoPersistencia, ExcecaoNegocio{
        if (codPerfil==null){
            throw new ExcecaoNegocio("Código não pode ser nulo.");
        }
        Perfil result = perfilDAO.getPerfilById(codPerfil);
        return result;
    }

    @Override
    public List<Perfil> getAll() throws ExcecaoPersistencia {
        List<Perfil> result = perfilDAO.listAll();
        return result;
    }
}
