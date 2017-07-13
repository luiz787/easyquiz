package model.dao;

import java.util.List;
import model.domain.Post;
import model.exception.ExcecaoPersistencia;

public interface PostDAO {
    public void insert(Post post) throws ExcecaoPersistencia;
    public Post delete(Long cod_Post) throws ExcecaoPersistencia;
    public Post getPostById(Long cod_Post) throws ExcecaoPersistencia;
    public List<Post> listAllByQuestao (Long cod_Questao) throws ExcecaoPersistencia;
}
