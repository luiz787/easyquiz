/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.domain.Usuario;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import java.util.List;

/**
 *
 * @author Luiz
 */
public interface ManterUsuario {
    public Long cadastrarUsuario(Usuario usuario) throws ExcecaoNegocio, ExcecaoPersistencia;
    public void alterarUsuario(Usuario usuario) throws ExcecaoNegocio, ExcecaoPersistencia;
    public void deletarUsuario(Long usuarioId) throws ExcecaoPersistencia;
    public Usuario getUsuarioById(Long usuarioid) throws ExcecaoPersistencia;
    public List<Usuario> listAll() throws ExcecaoPersistencia;
}
