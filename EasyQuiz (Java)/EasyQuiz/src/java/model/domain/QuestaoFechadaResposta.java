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
public class QuestaoFechadaResposta {
    private Sessao sessao;
    private Questao questao;
    private Long seqQuestaoResposta;

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    

    public Long getSeqQuestaoResposta() {
        return seqQuestaoResposta;
    }

    public void setSeqQuestaoResposta(Long seqQuestaoResposta) {
        this.seqQuestaoResposta = seqQuestaoResposta;
    }
}
