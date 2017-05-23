/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.dao.UsuarioDAO;
import model.domain.Usuario;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author andro
 */
public class ManterUsuarioImpl implements ManterUsuario{

    private final UsuarioDAO usuarioDAO;

    public ManterUsuarioImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    synchronized public Long cadastrarUsuario(Usuario usuario) throws ExcecaoNegocio, ExcecaoPersistencia {

        List<String> errMsgList = new ArrayList<>();

        if (usuario == null) {
            throw new ExcecaoNegocio("Nenhum usuario informado.");
        }

        if ((usuario.getNome() == null) || (usuario.getNome().isEmpty())) {
            errMsgList.add("O nome nao pode ser nulo.");
        } else {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(usuario.getNome());
            if (matcher.find()) {
                errMsgList.add("O nome nao pode conter numeros.");
            }
        }

        if ((usuario.getSenha() == null) || (usuario.getSenha().isEmpty())) {
            errMsgList.add("A senha nao pode ser nula.");
        } else if ((usuario.getSenha()).length() < 8) {
            errMsgList.add("A senha e' muito curta.");
        }

        if ((usuario.getEmail() == null) || (usuario.getEmail().isEmpty())) {
            errMsgList.add("O e-mail nao pode ser nulo.");
        } else if ((usuario.getEmail() == null) || ((usuario.getEmail()).length() > 0)){
            String regexp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(usuario.getEmail());
            if (matcher.matches()) {
                errMsgList.add("Formato de e-mail invalido.");
            }
        }
 
        if ((usuario.getDataNascimento() == null)) {
            errMsgList.add("A data de nascimento nao pode ser nula.");
        }

        if (usuario.getId() != null) {
            errMsgList.add("Na criaçao de um novo usuario o ID deve ser nulo.");
        }

        if (usuario.getQuestoesAcertadas() != null) {
            errMsgList.add("Na criaçao de um novo usuario o número de questoes acertadas deve ser nulo.");
        }

        if (usuario.getQuestoesRespondidas() != null) {
            errMsgList.add("Na criaçao de um novo usuario o numero de questoes respondidas deve ser nulo.");
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
    public void alterarUsuario(Usuario usuario) throws ExcecaoNegocio, ExcecaoPersistencia {
        List<String> errMsgList = new ArrayList<>();

        if (usuario == null) {
            throw new ExcecaoNegocio("Nenhum usuario informado.");
        }

        if ((usuario.getNome() == null) || (usuario.getNome().isEmpty())) {
            errMsgList.add("O nome nao pode ser nulo.");
        } else {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(usuario.getNome());
            if (matcher.find()) {
                errMsgList.add("O nome nao pode conter numeros.");
            }
        }

        if ((usuario.getSenha() == null) || (usuario.getSenha().isEmpty())) {
            errMsgList.add("A senha nao pode ser nula!");
        } else if ((usuario.getSenha()).length() < 8) {
            errMsgList.add("A senha e' muito curta.");
        }

        if ((usuario.getEmail() == null) || (usuario.getEmail().isEmpty())) {
            errMsgList.add("O e-mail nao pode ser nulo.");
        } else if ((usuario.getEmail() == null) || ((usuario.getEmail()).length() > 0)){
            String regexp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(usuario.getEmail());
            if (matcher.matches()) {
                errMsgList.add("Formato de e-mail invalido.");
            }
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
    public void deletarUsuario(Long id) throws ExcecaoPersistencia {
        
        if (id == null){
            throw new ExcecaoPersistencia("Para remover um usuario o ID deve estar previamente presente no sistema.");
        }

        usuarioDAO.delete(id);
    }

    @Override
    public Usuario getUsuarioById(Long id) throws ExcecaoPersistencia {
        
        if (id == null){
            throw new ExcecaoPersistencia("Para buscar um usuario o ID deve estar previamente presente no sistema.");
        }

        return usuarioDAO.getUsuarioById(id);
    }

    @Override
    public List<Usuario> listAll() throws ExcecaoPersistencia {
        return usuarioDAO.listAll();
    }

}
