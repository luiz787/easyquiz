/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.sql.Date;
import java.time.Instant;
/**
 *
 * @author Luiz
 */
public class Post {
    private Long codigo;
    private Questao questao;
    private String txtConteudo;
    private Instant datCriacao;
    private Usuario autor;

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public String getTxtConteudo() {
        return txtConteudo;
    }

    public void setTxtConteudo(String txtConteudo) {
        this.txtConteudo = txtConteudo;
    }

    public Instant getDatCriacao() {
        return datCriacao;
    }

    public void setDatCriacao(Instant datCriacao) {
        this.datCriacao = datCriacao;
    }
    
}
