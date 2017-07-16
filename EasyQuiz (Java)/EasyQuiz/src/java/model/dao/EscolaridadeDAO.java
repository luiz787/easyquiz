/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.domain.Escolaridade;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public interface EscolaridadeDAO {
    public Escolaridade getEscolaridadeById(Long cod_Escolaridade) throws ExcecaoPersistencia;
    public List<Escolaridade> listAll() throws ExcecaoPersistencia;
}
