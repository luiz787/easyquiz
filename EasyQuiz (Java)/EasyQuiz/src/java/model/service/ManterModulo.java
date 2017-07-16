/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.Modulo;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public interface ManterModulo {
    public Long cadastrarModulo(Modulo modulo) throws ExcecaoPersistencia, ExcecaoNegocio;
    public boolean alterarModulo(Modulo modulo) throws ExcecaoPersistencia, ExcecaoNegocio;
    public Modulo deletarModulo(Long cod_Modulo) throws ExcecaoPersistencia, ExcecaoNegocio;
    public Modulo getModuloById(Long cod_Modulo) throws ExcecaoPersistencia, ExcecaoNegocio;
    public List<Modulo> getAll() throws ExcecaoPersistencia;
}
