/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.awt.image.BufferedImage;

/**
 *
 * @author Luiz Augusto
 */
public class Questao { //serializable?

    private Long cod_Questao;
    private Long cod_Dificuldade;
    private Long cod_Disciplina;
    private Long cod_Modulo;
    private char cod_Tipo;
    private String txt_Enunciado;
    private BufferedImage img_Enunciado;
    private Long seq_Questao_Correta;
    private String txt_Resposta_Aberta;
    
    /*
    private Long id;
    private String enunciado;
    private BufferedImage imagem; //Avaliar como a imagem será armazenada
    private int dificuldade;
    private String disciplina;
    private char tipo; //Aberta (A) ou Fechada (F)
    */

    public Long getCod_Questao() {
        return cod_Questao;
    }

    public void setCod_Questao(Long cod_Questao) {
        this.cod_Questao = cod_Questao;
    }

    public Long getCod_Dificuldade() {
        return cod_Dificuldade;
    }

    public void setCod_Dificuldade(Long cod_Dificuldade) {
        this.cod_Dificuldade = cod_Dificuldade;
    }

    public Long getCod_Disciplina() {
        return cod_Disciplina;
    }

    public void setCod_Disciplina(Long cod_Disciplina) {
        this.cod_Disciplina = cod_Disciplina;
    }

    public Long getCod_Modulo() {
        return cod_Modulo;
    }

    public void setCod_Modulo(Long cod_Modulo) {
        this.cod_Modulo = cod_Modulo;
    }

    

    public char getCod_Tipo() {
        return cod_Tipo;
    }

    public void setCod_Tipo(char cod_Tipo) {
        this.cod_Tipo = cod_Tipo;
    }

    public String getTxt_Enunciado() {
        return txt_Enunciado;
    }

    public void setTxt_Enunciado(String txt_Enunciado) {
        this.txt_Enunciado = txt_Enunciado;
    }

    public BufferedImage getImg_Enunciado() {
        return img_Enunciado;
    }

    public void setImg_Enunciado(BufferedImage img_Enunciado) {
        this.img_Enunciado = img_Enunciado;
    }

    public Long getSeq_Questao_Correta() {
        return seq_Questao_Correta;
    }

    public void setSeq_Questao_Correta(Long seq_Questao_Correta) {
        this.seq_Questao_Correta = seq_Questao_Correta;
    }

    

    public String getTxt_Resposta_Aberta() {
        return txt_Resposta_Aberta;
    }

    public void setTxt_Resposta_Aberta(String txt_Resposta_Aberta) {
        this.txt_Resposta_Aberta = txt_Resposta_Aberta;
    }
    
}
