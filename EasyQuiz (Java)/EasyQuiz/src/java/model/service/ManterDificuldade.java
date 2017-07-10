/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.Dificuldade;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public interface ManterDificuldade {
    public Dificuldade getDificuldadeById(Long cod_Dificuldade) throws ExcecaoPersistencia, ExcecaoNegocio;
    public List<Dificuldade> listAll() throws ExcecaoPersistencia;
}
