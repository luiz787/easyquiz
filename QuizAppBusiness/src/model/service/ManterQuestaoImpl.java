/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.Questao;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public class ManterQuestaoImpl implements ManterQuestao {

    @Override
    public Long cadastrarQuestao(Questao questao) throws ExcecaoNegocio, ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterarQuestao(Questao questao) throws ExcecaoNegocio, ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletarQuestao(Long id) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Questao getQuestaoById(Long id) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Questao> listAll() throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
