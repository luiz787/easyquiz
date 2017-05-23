/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.domain.Post;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author Luiz
 */
public interface ManterPost {
    public boolean inserirPost() throws ExcecaoNegocio, ExcecaoPersistencia;
    public Post getAll() throws ExcecaoPersistencia;
}
