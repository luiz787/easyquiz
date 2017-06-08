/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.quizapp.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import model.dao.UsuarioDAO;
import model.domain.Usuario;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author aluno
 */
public class UsuarioDAOImpl implements UsuarioDAO {
    private static UsuarioDAOImpl usuarioDAO = null;        

    private static HashMap<Long, Usuario> usuarioDB = new HashMap<>();    
    private static long personCount = 0;
    
    private UsuarioDAOImpl() { 
    }

    public static UsuarioDAOImpl getInstance() {
        
        if (usuarioDAO == null)
            usuarioDAO = new UsuarioDAOImpl();
        
        return  usuarioDAO;
    }

    @Override
    public void insert(Usuario usuario) throws ExcecaoPersistencia {
        if (usuario == null)
            throw new ExcecaoPersistencia("Entidade não pode ser nula.");                
        
        Long usuarioId = usuario.getId();
        
        if ((usuarioId != null) && usuarioDB.containsKey(usuarioId))
            throw new ExcecaoPersistencia("Duplicação de chave.");
        
        usuarioId = ++personCount;
        usuario.setId(usuarioId);
        
        usuarioDB.put(usuarioId, usuario);
    }

    @Override
    public void update(Usuario usuario) throws ExcecaoPersistencia {
        if (usuario == null)
            throw new ExcecaoPersistencia("Entidade não pode ser nula.");              
        
        Long usuarioId = usuario.getId();

        if (usuarioId == null)
            throw new ExcecaoPersistencia("Chave da entidade não pode ser nulo.");        
        
        if (!usuarioDB.containsKey(usuarioId))
            throw new ExcecaoPersistencia("Não existe entidade com a chave " + usuarioId + ".");
        
        usuarioDB.replace(usuarioId, usuario);
    }

    @Override
    public Usuario delete(Long usuarioId) throws ExcecaoPersistencia {
        if (usuarioId == null)
            throw new ExcecaoPersistencia("Chave da entidade não pode ser nulo.");
        
        if (!usuarioDB.containsKey(usuarioId))
            throw new ExcecaoPersistencia("Não existe entidade com a chave " + usuarioId + ".");
        
        return usuarioDB.remove(usuarioId);
    }

    @Override
    public Usuario getUsuarioById(Long usuarioId) throws ExcecaoPersistencia {
        if (usuarioId == null)
            throw new ExcecaoPersistencia("Chave da entidade não pode ser nulo.");
        
        if (!usuarioDB.containsKey(usuarioId))
            throw new ExcecaoPersistencia("Não existe entidade com a chave " + usuarioId + ".");
        
        return usuarioDB.get((usuarioId));
    }

    @Override
    public List<Usuario> listAll() throws ExcecaoPersistencia {
        List<Usuario> personList = new ArrayList<>();
        
        Iterator<Usuario> iterator = usuarioDB.values().iterator();
	while (iterator.hasNext())
            personList.add(iterator.next());
        
        return personList;
    }
}
