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
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String email;
    private String senha;
    private Long questoesRespondidas;
    private Long questoesAcertadas;
    private char perfil; //Tipo de usuário: Administrador (G), aluno(A), professor(P).

    public char getPerfil() {
        return perfil;
    }

    public void setPerfil(char perfil) {
        this.perfil = perfil;
    }

    public Long getQuestoesRespondidas() {
        return questoesRespondidas;
    }

    public void setQuestoesRespondidas(Long questoesRespondidas) {
        this.questoesRespondidas = questoesRespondidas;
    }

    public Long getQuestoesAcertadas() {
        return questoesAcertadas;
    }

    public void setQuestoesAcertadas(Long questoesAcertadas) {
        this.questoesAcertadas = questoesAcertadas;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
