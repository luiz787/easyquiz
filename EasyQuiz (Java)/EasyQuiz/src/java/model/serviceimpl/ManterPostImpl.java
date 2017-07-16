/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.serviceimpl;

import java.util.ArrayList;
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
    public Long cadastrarPost(Post post) throws ExcecaoPersistencia, ExcecaoNegocio {
        List<String> errMsgList = new ArrayList<>();
         
         if(post == null) {
             throw new ExcecaoNegocio("Nenhum post informado!\n\n");
         }
     
         if(post.getTxtConteudo() == null) {
             errMsgList.add("Nada foi escrito!\n\n");
         }
 
         if(post.getDatCriacao() == null) {
             errMsgList.add("Nenhuma data informada!\n\n");
         }
         
         if(post.getAutor().getId() == null){
             errMsgList.add("O ID do autor não foi informado!\n\n");
         }
         
         if(post.getQuestao().getId() == null) {
             errMsgList.add("O ID da questão não foi informado!\n\n");
         }
         
         if (!errMsgList.isEmpty()) {
             String errMsg = "";
             for(String msg: errMsgList)
                 errMsg += (msg + "\n");
             throw new ExcecaoNegocio(errMsg);
         }
         
         Long result = postDAO.insert(post);
         return result;
    }

    @Override
    public Post deletarPost(Long id) throws ExcecaoPersistencia {
        if (id==null){
            throw new ExcecaoPersistencia("O id não pode ser nulo.");
        }
        Post result = postDAO.delete(id);
        return result;
    }

    @Override
    public Post getPostById(Long id) throws ExcecaoPersistencia {
        if (id==null){
            throw new ExcecaoPersistencia("O id não pode ser nulo.");
        }
        Post result = postDAO.getPostById(id);
        return result;
    }

    @Override
    public List<Post> getAllByQuestao(Long idQuestao) throws ExcecaoPersistencia {
        List<String> errMsgList = new ArrayList<>();
        if(idQuestao == null) {
            throw new ExcecaoPersistencia("Nenhum id informado!");
        }
        List<Post> result = postDAO.listAllByQuestao(idQuestao);
        return result;
    }
}
