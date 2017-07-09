/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.time.Instant;
import java.util.List;
import model.domain.Sessao;
import model.exception.ExcecaoNegocio;
import model.exception.ExcecaoPersistencia;

/**
 *
 * @author aluno
 */
public interface ManterSessao {
    public void cadastrarSessao(Sessao sessao) throws ExcecaoPersistencia, ExcecaoNegocio;
    public void alterarSessao(Sessao sessao) throws ExcecaoPersistencia, ExcecaoNegocio;
    public Sessao getSessaoByUsuarioData(Long cod_Usuario, Instant dat_Inicio) throws ExcecaoPersistencia;
    public List<Sessao> getSessaoByUsuario(Long cod_Usuario) throws ExcecaoPersistencia;
    public List<Sessao> getAll() throws ExcecaoPersistencia;
}
