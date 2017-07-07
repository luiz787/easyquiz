/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author Aluno
 */
public class Modulo {
    private Long cod_Disciplina;
    private Long cod_Modulo;
    private String nom_Modulo;

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

    public String getNom_Modulo() {
        return nom_Modulo;
    }

    public void setNom_Modulo(String nom_Modulo) {
        this.nom_Modulo = nom_Modulo;
    }
    
}
