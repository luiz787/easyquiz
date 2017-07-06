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
public class Sessao {
    private Long cod_Usuario;
    private Long dat_Inicio;
    private Long dat_Fim;

    public Long getCod_Usuario() {
        return cod_Usuario;
    }

    public void setCod_Usuario(Long cod_Usuario) {
        this.cod_Usuario = cod_Usuario;
    }

    public Long getDat_Inicio() {
        return dat_Inicio;
    }

    public void setDat_Inicio(Long dat_Inicio) {
        this.dat_Inicio = dat_Inicio;
    }

    public Long getDat_Fim() {
        return dat_Fim;
    }

    public void setDat_Fim(Long dat_Fim) {
        this.dat_Fim = dat_Fim;
    }
}
