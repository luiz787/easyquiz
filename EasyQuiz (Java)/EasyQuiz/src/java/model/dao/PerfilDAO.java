/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.domain.Perfil;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Aluno
 */
public interface PerfilDAO {
    public Perfil getPerfilById(Long cod_Perfil) throws ExcecaoPersistencia;
    public List<Perfil> listAll() throws ExcecaoPersistencia;
}
