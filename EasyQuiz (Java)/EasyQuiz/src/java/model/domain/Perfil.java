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
public class Perfil {
    private Long cod_Perfil;
    private String nom_Perfil;

    public Long getCod_Perfil() {
        return cod_Perfil;
    }

    public void setCod_Perfil(Long cod_Perfil) {
        this.cod_Perfil = cod_Perfil;
    }

    public String getNom_Perfil() {
        return nom_Perfil;
    }

    public void setNom_Perfil(String nom_Perfil) {
        this.nom_Perfil = nom_Perfil;
    }
    
}
