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
public class Usuario {

    public Usuario() {
        
    }
    private Long cod_Usuario;
    private int cod_Perfil; //Tipo de usuário: Administrador (G), aluno(A), professor(P).
    private String nom_Usuario;
    private Date dat_Nascimento;
    private String txt_Email;
    private String txt_Senha;
    /*private String nome;
    private Date dataNascimento;
    private String email;
    private String senha;
    private Long questoesRespondidas;
    private Long questoesAcertadas;
    private char perfil; /
    */

    public Long getCod_Usuario() {
        return cod_Usuario;
    }

    public void setCod_Usuario(Long cod_Usuario) {
        this.cod_Usuario = cod_Usuario;
    }

    public int getCod_Perfil() {
        return cod_Perfil;
    }

    public void setCod_Perfil(int cod_Perfil) {
        this.cod_Perfil = cod_Perfil;
    }

    public String getNom_Usuario() {
        return nom_Usuario;
    }

    public void setNom_Usuario(String nom_Usuario) {
        this.nom_Usuario = nom_Usuario;
    }

    public Date getDat_Nascimento() {
        return dat_Nascimento;
    }

    public void setDat_Nascimento(Date dat_Nascimento) {
        this.dat_Nascimento = dat_Nascimento;
    }

    public String getTxt_Email() {
        return txt_Email;
    }

    public void setTxt_Email(String txt_Email) {
        this.txt_Email = txt_Email;
    }

    public String getTxt_Senha() {
        return txt_Senha;
    }

    public void setTxt_Senha(String txt_Senha) {
        this.txt_Senha = txt_Senha;
    }
    
}