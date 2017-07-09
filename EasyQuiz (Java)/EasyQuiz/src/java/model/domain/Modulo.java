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
    private Disciplina disciplina;
    private Long cod_Modulo;
    private String nom_Modulo;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
