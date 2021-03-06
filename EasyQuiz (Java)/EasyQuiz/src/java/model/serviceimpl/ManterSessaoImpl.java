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
    public boolean cadastrarSessao(Sessao sessao) throws ExcecaoPersistencia, ExcecaoNegocio {
        String errMsg = null;
        if (sessao==null){
            throw new ExcecaoNegocio("A sessão não pode ser nula.");
        } else {
            if (sessao.getUsuario()==null){
                errMsg+="A sessão deve pertencer a um usuário. ";
            }
            if (sessao.getDataInicio()==null){
                errMsg+="A sessão deve ter uma data inicial. ";
            }
            if (sessao.getDataFim()!=null){
                errMsg+="A sessão não pode ter data de encerramento ao ser cadastrada. ";
            }
        }
        if (errMsg!=null){
            throw new ExcecaoNegocio(errMsg);
        }
        boolean result = sessaoDAO.insert(sessao);
        return result;
    }

    @Override
    public boolean alterarSessao(Sessao sessao) throws ExcecaoPersistencia, ExcecaoNegocio {
        String errMsg = null;
        if (sessao==null){
            throw new ExcecaoNegocio("A sessão não pode ser nula.");
        } else {
            if (sessao.getUsuario()==null){
                errMsg+="A sessão deve pertencer a um usuário. ";
            }
            if (sessao.getDataInicio()==null){
                errMsg+="A sessão deve ter uma data inicial. ";
            }
        }
        if (errMsg!=null){
            throw new ExcecaoNegocio(errMsg);
        }
        boolean result = sessaoDAO.update(sessao);
        return result;
    }

    @Override
    public List<Sessao> getSessaoByUsuario(Long id) throws ExcecaoPersistencia {
        if (id==null){
            throw new ExcecaoPersistencia("O id de usuário não pode ser nulo.");
        }
        List<Sessao> result = sessaoDAO.getSessaoByUsuario(id);
        return result;
    }

    @Override
    public List<Sessao> getAll() throws ExcecaoPersistencia {
        List<Sessao> result = sessaoDAO.listAll();
        return result;
    }

    @Override
    public Sessao getSessaoByUsuarioData(Long id, Instant dataInicio) throws ExcecaoPersistencia {
        if (id==null){
            throw new ExcecaoPersistencia("O id de usuário não pode ser nulo.");
        }
        if (dataInicio == null) {
            throw new ExcecaoPersistencia("A data inicial não pode ser nula.");
        }
        Sessao result = sessaoDAO.getSessaoByUsuarioData(id, dataInicio);
        return result;
    }
}
