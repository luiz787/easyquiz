/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.time.Instant;

/**
 *
 * @author Aluno
 */
public class Sessao {
    private Long cod_Usuario;
    private Instant dat_Inicio;
    private Instant dat_Fim;

    public Long getCod_Usuario() {
        return cod_Usuario;
    }

    public void setCod_Usuario(Long cod_Usuario) {
        this.cod_Usuario = cod_Usuario;
    }

    public Instant getDat_Inicio() {
        return dat_Inicio;
    }

    public void setDat_Inicio(Instant dat_Inicio) {
        this.dat_Inicio = dat_Inicio;
    }

    public Instant getDat_Fim() {
        return dat_Fim;
    }

    public void setDat_Fim(Instant dat_Fim) {
        this.dat_Fim = dat_Fim;
    }

    
}
