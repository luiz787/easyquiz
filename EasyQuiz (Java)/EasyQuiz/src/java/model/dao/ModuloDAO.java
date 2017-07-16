/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.domain.Modulo;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public interface ModuloDAO {
    public Long insert(Modulo modulo) throws ExcecaoPersistencia;
    public boolean update(Modulo modulo) throws ExcecaoPersistencia;
    public Modulo delete(Long cod_Modulo) throws ExcecaoPersistencia;
    public Modulo getModuloById(Long cod_Modulo) throws ExcecaoPersistencia;
    public List<Modulo> listAll() throws ExcecaoPersistencia;
}
