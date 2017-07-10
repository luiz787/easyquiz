/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.Perfil;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public interface ManterPerfil {
    public Perfil getPerfilById(Long cod_Perfil) throws ExcecaoPersistencia, ExcecaoNegocio;
    public List<Perfil> getAll() throws ExcecaoPersistencia;
}
