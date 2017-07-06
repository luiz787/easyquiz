/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.sql.Date;
/**
 *
 * @author Luiz
 */
public class Post {
    private Long cod_Post;
    private Long cod_Questao;
    private String txt_Conteudo;
    private Long dat_Criacao;
    /*
    private Long id;
    private String conteudo;
    private Long idAutor;
    private Date dataCriacao;
    private Long idQuestao;
    */

    public Long getCod_Post() {
        return cod_Post;
    }

    public void setCod_Post(Long cod_Post) {
        this.cod_Post = cod_Post;
    }

    public Long getCod_Questao() {
        return cod_Questao;
    }

    public void setCod_Questao(Long cod_Questao) {
        this.cod_Questao = cod_Questao;
    }

    public String getTxt_Conteudo() {
        return txt_Conteudo;
    }

    public void setTxt_Conteudo(String txt_Conteudo) {
        this.txt_Conteudo = txt_Conteudo;
    }

    public Long getDat_Criacao() {
        return dat_Criacao;
    }

    public void setDat_Criacao(Long dat_Criacao) {
        this.dat_Criacao = dat_Criacao;
    }
    
}
