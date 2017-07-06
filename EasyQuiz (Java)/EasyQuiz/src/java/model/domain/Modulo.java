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
    private int cod_Disciplina;
    private int cod_Modulo;
    private String nom_Modulo;

    public int getCod_Disciplina() {
        return cod_Disciplina;
    }

    public void setCod_Disciplina(int cod_Disciplina) {
        this.cod_Disciplina = cod_Disciplina;
    }

    public int getCod_Modulo() {
        return cod_Modulo;
    }

    public void setCod_Modulo(int cod_Modulo) {
        this.cod_Modulo = cod_Modulo;
    }

    public String getNom_Modulo() {
        return nom_Modulo;
    }

    public void setNom_Modulo(String nom_Modulo) {
        this.nom_Modulo = nom_Modulo;
    }
    
}
