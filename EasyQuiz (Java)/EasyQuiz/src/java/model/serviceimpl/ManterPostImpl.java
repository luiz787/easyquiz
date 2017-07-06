package model.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import model.dao.PostDAO;
import model.domain.Post;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;
import model.service.ManterPost;

public class ManterPostImpl implements ManterPost{
    
    private final PostDAO postDAO;
    
    public ManterPostImpl(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    @Override
    public Long inserirPost(Post post) throws ExcecaoNegocio, ExcecaoPersistencia {
        
        List<String> errMsgList = new ArrayList<>();
        
        if(post == null) {
            throw new ExcecaoNegocio("Nenhum post informado!\n\n");
        }
    
        if(post.getConteudo() == null) {
            errMsgList.add("Nada foi escrito!\n\n");
        }

        if(post.getDataCriacao() == null) {
            errMsgList.add("Nenhuma data informada!\n\n");
        }
        
        if(post.getId() == null) {
            errMsgList.add("Nenhum ID informado!\n\n");
        }
        
        if(post.getIdAutor() == null){
            errMsgList.add("O ID do autor não foi informado!\n\n");
        }
        
        if(post.getIdQuestao() == null) {
            errMsgList.add("O ID da questão não foi informado!\n\n");
        }
        
        if (!errMsgList.isEmpty()) {
            String errMsg = "";
            for(String msg: errMsgList)
                errMsg += (msg + "\n");
            throw new ExcecaoNegocio(errMsg);
        }
        
        postDAO.insert(post);
        return post.getId();
    }

    @Override
    public List<Post> getAll(Long idQuestao) throws ExcecaoPersistencia {
        List<String> errMsgList = new ArrayList<>();
        
        if(idQuestao == null) {
            throw new ExcecaoPersistencia("Nenhum id informado!");
        }
        
        return postDAO.listAll();
    }
}
