/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.domain.Sessao;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author aluno
 */
public class ManterSessaoImpl implements ManterSessao {
    @Override
    public void cadastrarSessao(Sessao sessao) throws ExcecaoPersistencia, ExcecaoNegocio {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarSessao(Sessao sessao) throws ExcecaoPersistencia, ExcecaoNegocio {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessao> getSessaoByUsuario(Long cod_Usuario) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sessao> getAll() throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
