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
    private Long cod_Post;
    private Questao questao;
    private String txt_Conteudo;
    private Instant dat_Criacao;

    public Long getCod_Post() {
        return cod_Post;
    }

    public void setCod_Post(Long cod_Post) {
        this.cod_Post = cod_Post;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public String getTxt_Conteudo() {
        return txt_Conteudo;
    }

    public void setTxt_Conteudo(String txt_Conteudo) {
        this.txt_Conteudo = txt_Conteudo;
    }

    public Instant getDat_Criacao() {
        return dat_Criacao;
    }

    public void setDat_Criacao(Instant dat_Criacao) {
        this.dat_Criacao = dat_Criacao;
    }
    
}
