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
    private Long seqAlternativa;
    private String txtAlternativa;

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Long getSeqAlternativa() {
        return seqAlternativa;
    }

    public void setSeqAlternativa(Long seqAlternativa) {
        this.seqAlternativa = seqAlternativa;
    }

    public String getTxtAlternativa() {
        return txtAlternativa;
    }

    public void setTxtAlternativa(String txtAlternativa) {
        this.txtAlternativa = txtAlternativa;
    }
}
