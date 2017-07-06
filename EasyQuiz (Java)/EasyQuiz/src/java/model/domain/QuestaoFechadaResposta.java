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
public class QuestaoFechadaResposta {
    private Long dat_Inicio;
    private Long cod_Usuario;
    private Long cod_Questao;
    private int seq_Questao_Resposta;

    public Long getDat_Inicio() {
        return dat_Inicio;
    }

    public void setDat_Inicio(Long dat_Inicio) {
        this.dat_Inicio = dat_Inicio;
    }

    public Long getCod_Usuario() {
        return cod_Usuario;
    }

    public void setCod_Usuario(Long cod_Usuario) {
        this.cod_Usuario = cod_Usuario;
    }

    public Long getCod_Questao() {
        return cod_Questao;
    }

    public void setCod_Questao(Long cod_Questao) {
        this.cod_Questao = cod_Questao;
    }

    public int getSeq_Questao_Resposta() {
        return seq_Questao_Resposta;
    }

    public void setSeq_Questao_Resposta(int seq_Questao_Resposta) {
        this.seq_Questao_Resposta = seq_Questao_Resposta;
    }
    
    
}
