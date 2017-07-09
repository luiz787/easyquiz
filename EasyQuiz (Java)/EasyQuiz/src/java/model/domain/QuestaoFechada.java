/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author Luiz
 */
public class QuestaoFechada {
    private Questao questao;
    private Long seq_Alternativa;
    private String txt_Alternativa;

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Long getSeq_Alternativa() {
        return seq_Alternativa;
    }

    public void setSeq_Alternativa(Long seq_Alternativa) {
        this.seq_Alternativa = seq_Alternativa;
    }

    public String getTxt_Alternativa() {
        return txt_Alternativa;
    }

    public void setTxt_Alternativa(String txt_Alternativa) {
        this.txt_Alternativa = txt_Alternativa;
    }
}
