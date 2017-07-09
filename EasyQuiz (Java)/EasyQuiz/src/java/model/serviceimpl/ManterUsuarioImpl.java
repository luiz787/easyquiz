/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import model.domain.Usuario;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import java.util.List;
import model.dao.UsuarioDAO;
import model.domain.Usuario;

/**
 *
 * @author Luiz
 */
public class ManterUsuarioImpl implements ManterUsuario {
    private final UsuarioDAO usuarioDAO;
    
    public ManterUsuarioImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    @Override
    public void cadastrarUsuario(Usuario usuario) throws ExcecaoPersistencia, ExcecaoNegocio {
        usuarioDAO.insert(usuario);
    }

    @Override
    public void alterarUsuario(Usuario usuario) throws ExcecaoPersistencia, ExcecaoNegocio {
        usuarioDAO.update(usuario);
    }

    @Override
    public Usuario deletarUsuario(Long cod_Usuario) throws ExcecaoPersistencia {
        Usuario result = usuarioDAO.delete(cod_Usuario);
        return result;
    }

    @Override
    public Usuario getUsuarioById(Long cod_Usuario) throws ExcecaoPersistencia {
        Usuario result = usuarioDAO.getUsuarioById(cod_Usuario);
        return result;
    }

    @Override
    public List<Usuario> getAll() throws ExcecaoPersistencia {
        List<Usuario> result = usuarioDAO.listAll();
        return result;
    }

    @Override
    public Usuario getUsuarioByEmailSenha(String email, String senha) throws ExcecaoPersistencia {
        Usuario result = usuarioDAO.getUsuarioByEmailSenha(email, senha);
        return result;    
    }
}
