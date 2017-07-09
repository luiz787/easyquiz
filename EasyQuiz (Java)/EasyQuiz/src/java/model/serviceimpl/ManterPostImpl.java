/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import model.service.*;
import java.util.List;
import model.dao.PostDAO;
import model.domain.Post;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Luiz
 */
public class ManterPostImpl implements ManterPost {
    private final PostDAO postDAO;
    
    public ManterPostImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }
    @Override
    public void cadastrarPost(Post post) throws ExcecaoPersistencia, ExcecaoNegocio {
        postDAO.insert(post);
    }

    @Override
    public Post deletarPost(Long cod_Post) throws ExcecaoPersistencia {
        Post result = postDAO.delete(cod_Post);
        return result;
    }

    @Override
    public Post getPostById(Long cod_Post) throws ExcecaoPersistencia {
        Post result = postDAO.getPostById(cod_Post);
        return result;
    }

    @Override
    public List<Post> getAll() throws ExcecaoPersistencia {
        List<Post> result = postDAO.listAll();
        return result;
    }
}
