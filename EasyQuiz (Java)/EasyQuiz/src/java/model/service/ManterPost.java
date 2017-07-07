/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import model.domain.Post;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Luiz
 */
public interface ManterPost {
    public void cadastrarPost(Post post) throws ExcecaoPersistencia, ExcecaoNegocio;
    public void alterarPost(Post post) throws ExcecaoPersistencia, ExcecaoNegocio;
    public Post deletarPost(Long cod_Post) throws ExcecaoPersistencia;
    public Post getPostById(Long cod_Post) throws ExcecaoPersistencia;
    public List<Post> getAll() throws ExcecaoPersistencia;
}
