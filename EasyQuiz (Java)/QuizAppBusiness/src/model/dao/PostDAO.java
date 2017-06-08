package model.dao;

import java.util.List;
import model.domain.Post;
import model.exception.ExcecaoPersistencia;

public interface PostDAO {
    public void insert(Post post) throws ExcecaoPersistencia;
    public void update(Post post) throws ExcecaoPersistencia;
    public Post delete(Long postId) throws ExcecaoPersistencia;
    public Post getPostById(Long postId) throws ExcecaoPersistencia;
    public List<Post> listAll() throws ExcecaoPersistencia;
}
