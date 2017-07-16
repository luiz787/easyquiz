/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.Escolaridade;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public interface ManterEscolaridade {
    public Escolaridade getEscolaridadeById(Long cod_Escolaridade) throws ExcecaoPersistencia, ExcecaoNegocio;
    public List<Escolaridade> getAll() throws ExcecaoPersistencia;
}
