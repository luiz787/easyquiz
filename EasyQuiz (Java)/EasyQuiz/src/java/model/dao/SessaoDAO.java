/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

/**
 *
 * @author Aluno
 */
public interface SessaoDAO {
    public Sessao getSessaoByData(Long cod_Sessao) throws ExcecaoPersistencia;
    public List<Sessao> listAll() throws ExcecaoPersistencia;
}