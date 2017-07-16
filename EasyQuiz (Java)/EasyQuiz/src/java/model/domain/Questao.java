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

    private Long id;
    private Dificuldade dificuldade;
    private Disciplina disciplina;
    private Modulo modulo;
    private char idTipo;
    private String txtEnunciado;
    private byte[] imgEnunciado;
    private Long seqQuestaoCorreta;
    private String txtResposta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    

    public char getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(char idTipo) {
        this.idTipo = idTipo;
    }

    public String getTxtEnunciado() {
        return txtEnunciado;
    }

    public void setTxtEnunciado(String txtEnunciado) {
        this.txtEnunciado = txtEnunciado;
    }

    public byte[] getImgEnunciado() {
        return imgEnunciado;
    }

    public void setImgEnunciado(byte[] imgEnunciado) {
        this.imgEnunciado = imgEnunciado;
    }

    public Long getSeqQuestaoCorreta() {
        return seqQuestaoCorreta;
    }

    public void setSeqQuestaoCorreta(Long seqQuestaoCorreta) {
        this.seqQuestaoCorreta = seqQuestaoCorreta;
    }

    

    public String getTxtResposta() {
        return txtResposta;
    }

    public void setTxtResposta(String txtResposta) {
        this.txtResposta = txtResposta;
    }
    
}
