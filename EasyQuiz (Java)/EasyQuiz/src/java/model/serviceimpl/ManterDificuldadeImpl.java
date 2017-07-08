/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.domain.Dificuldade;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public class ManterDificuldadeImpl implements ManterDificuldade {

    @Override
    public Dificuldade getDificuldadeById(Long cod_Dificuldade) throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dificuldade> listAll() throws ExcecaoPersistencia {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
