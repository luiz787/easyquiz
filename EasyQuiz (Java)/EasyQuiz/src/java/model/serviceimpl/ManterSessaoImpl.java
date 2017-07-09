/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import java.time.Instant;
import model.service.*;
import java.util.List;
import model.dao.SessaoDAO;
import model.domain.Sessao;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author aluno
 */
public class ManterSessaoImpl implements ManterSessao {
    private final SessaoDAO sessaoDAO;
    
    public ManterSessaoImpl(SessaoDAO sessaoDAO) {
        this.sessaoDAO = sessaoDAO;
    }
    @Override
    public void cadastrarSessao(Sessao sessao) throws ExcecaoPersistencia, ExcecaoNegocio {
        sessaoDAO.insert(sessao);
    }

    @Override
    public void alterarSessao(Sessao sessao) throws ExcecaoPersistencia, ExcecaoNegocio {
        sessaoDAO.update(sessao);
    }

    @Override
    public List<Sessao> getSessaoByUsuario(Long cod_Usuario) throws ExcecaoPersistencia {
        List<Sessao> result = sessaoDAO.getSessaoByUsuario(cod_Usuario);
        return result;
    }

    @Override
    public List<Sessao> getAll() throws ExcecaoPersistencia {
        List<Sessao> result = sessaoDAO.listAll();
        return result;
    }

    @Override
    public Sessao getSessaoByUsuarioData(Long cod_Usuario, Instant dat_Inicio) throws ExcecaoPersistencia {
        Sessao result = sessaoDAO.getSessaoByUsuarioData(cod_Usuario, dat_Inicio);
        return result;
    }
}
