/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import java.util.ArrayList;
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
    public Long cadastrarUsuario(Usuario usuario) throws ExcecaoPersistencia, ExcecaoNegocio {
        List<String> errMsgList = new ArrayList<>();
        if (usuario == null) {
            throw new ExcecaoNegocio("Nenhum usuario informado.");
        }

        if ((usuario.getNome() == null) || (usuario.getNome().isEmpty())) {
            errMsgList.add("O nome nao pode ser nulo.");
        }

        if ((usuario.getSenha() == null) || (usuario.getSenha().isEmpty())) {
            errMsgList.add("A senha nao pode ser nula.");
        } else if ((usuario.getSenha()).length() < 8) {
            errMsgList.add("A senha é muito curta.");
        }

        if ((usuario.getEmail() == null) || (usuario.getEmail().isEmpty())) {
            errMsgList.add("O e-mail nao pode ser nulo.");
        }
 
        if ((usuario.getDataNascimento() == null)) {
            errMsgList.add("A data de nascimento nao pode ser nula.");
            //data de nascimento posterior a data atual.
        }

        if (usuario.getId() != null) {
            errMsgList.add("Na criaçao de um novo usuario o ID deve ser nulo.");
        }

        if (!errMsgList.isEmpty()) {
            String errMsg = "";
            for (String msg : errMsgList) {
                errMsg += (msg + "\n");
            }
            throw new ExcecaoNegocio(errMsg);
        }
        

        usuarioDAO.insert(usuario);

        return usuario.getId();
    }

    @Override
    public void alterarUsuario(Usuario usuario) throws ExcecaoPersistencia, ExcecaoNegocio {
        List<String> errMsgList = new ArrayList<>();
        if (usuario == null) {
            
            throw new ExcecaoNegocio("Nenhum usuario informado.");
        }

        if ((usuario.getNome() == null) || (usuario.getNome().isEmpty())) {
            errMsgList.add("O nome nao pode ser nulo.");
        }
        
        if ((usuario.getSenha() == null) || (usuario.getSenha().isEmpty())) {
            errMsgList.add("A senha nao pode ser nula!");
        } else if ((usuario.getSenha()).length() < 8) {
            errMsgList.add("A senha é muito curta.");
        }

        if ((usuario.getEmail() == null) || (usuario.getEmail().isEmpty())) {
            errMsgList.add("O e-mail nao pode ser nulo.");
        }
 
        if ((usuario.getDataNascimento() == null)) {
            errMsgList.add("A data de nascimento nao pode ser nula.");
        }

        if (usuario.getId() == null) {
            errMsgList.add("Na alteraçao de um novo usuario o ID nao pode ser nulo.");
        }

        if (!errMsgList.isEmpty()) {
            String errMsg = "";
            for (String msg : errMsgList) {
                errMsg += (msg + "\n");
            }
            throw new ExcecaoNegocio(errMsg);
        }

        usuarioDAO.update(usuario);
    }

    @Override
    public Usuario deletarUsuario(Long id) throws ExcecaoPersistencia {
        if (id == null){
            throw new ExcecaoPersistencia("ID não pode ser nulo.");
        }
        return usuarioDAO.delete(id);
    }

    @Override
    public Usuario getUsuarioById(Long id) throws ExcecaoPersistencia {
        if (id == null){
            throw new ExcecaoPersistencia("ID não pode ser nulo.");
        }
        return usuarioDAO.getUsuarioById(id);
    }

    @Override
    public List<Usuario> getAll() throws ExcecaoPersistencia {
        List<Usuario> result = usuarioDAO.listAll();
        return result;
    }

    @Override
    public Usuario getUsuarioByEmailSenha(String email, String senha) throws ExcecaoPersistencia, ExcecaoNegocio {
        if (email==null || senha==null){
            throw new ExcecaoNegocio("O valor não pode ser nulo");
        }
        return usuarioDAO.getUsuarioByEmailSenha(email, senha);
    }
}
